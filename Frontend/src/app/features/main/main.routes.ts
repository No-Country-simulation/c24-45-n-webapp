import { Routes } from '@angular/router';

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
          path:'**',
          redirectTo:'feed'
        }
      ]
  },
];
