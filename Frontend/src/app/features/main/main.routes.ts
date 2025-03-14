import { Routes } from '@angular/router';
import { noProfileGuard } from '../../core/guards/no-profile.guard';

export const routes: Routes = [
  {
    path: '',
    loadComponent: () =>
      import('./main.component').then((c) => c.MainComponent),
      children:[
        {
          path:'',
          pathMatch:'full',
          redirectTo:'feed'
        },
        {
          path:'feed',
          loadComponent:()=>import('../../muro/muro.component').then(c=>c.MuroComponent),
          // canActivate:[noProfileGuard]
        },
        {
          path:'volunteer-profile/:id',
          loadComponent:()=>import('./pages/volunteer-profile/volunteer-profile.component').then(c=>c.VolunteerProfileComponent)
        },
        {
          path:'organization-profile/:id',
          loadComponent:()=>import('./pages/organization-profile/organization-profile.component').then(c=>c.OrganizationProfileComponent)
        },
        {
          path: 'complete-register-organization',
          loadComponent: () =>
            import('../auth/complete-register-organization/complete-register-organization.component').then((c) => c.CompleteRegisterOrganizationComponent),
        },
        {
          path: 'complete-register-volunteer',
          loadComponent: () =>
            import('../../volunteer-form/volunteer-form.component').then((c) => c.VolunteerFormComponent),
        },
        {
          path: 'project/:id',
          loadComponent: () =>
            import('../../project-screen/project-screen.component').then((c) => c.ProjectScreenComponent),
        },
        {
          path:'**',
          redirectTo:'feed'
        }
      ]
  },
];
