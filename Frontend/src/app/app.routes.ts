import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadComponent: () =>
      import('./features/home/home.component').then((c) => c.HomeComponent),
    pathMatch: 'full',
  },
 // {
 //   path: '', loadChildren: () => import('./features/main/main.routes').then(r => r.routes)
 // },
    {
      path: 'register',
      loadComponent: () =>
        import('./features/auth/register/register.component').then((c) => c.RegisterComponent),
    },
    {
      path: 'login',
      loadComponent: () =>
        import('./features/auth/login/login.component').then((c) => c.LoginComponent),
    },
    {
      path: 'complete-register-organization',
      loadComponent: () =>
        import('./features/auth/complete-register-organization/complete-register-organization.component').then((c) => c.CompleteRegisterOrganizationComponent),
    },
    {
      path: 'volunteer-form',
      loadComponent: () =>
        import('./volunteer-form/volunteer-form.component').then((c) => c.VolunteerFormComponent),
    },
    {
      path: 'muro',
      loadComponent: () =>
        import('./muro/muro.component').then((c) => c.MuroComponent),
    },

];
