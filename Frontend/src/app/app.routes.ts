import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadComponent: () =>
      import('./features/home/home.component').then((c) => c.HomeComponent),
    pathMatch: 'full',
  },
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
      path: 'organization-profile',
      loadComponent: () =>
      import('./features/auth/profiles/organization-profile/organization-profile.component').then((c) => c.OrganizationProfileComponent),
    },
    {
      path: 'volunteer-profile',
      loadComponent: () =>
      import('./features/auth/profiles/volunteer-profile/volunteer-profile.component').then((c) => c.VolunteerProfileComponent),
    }
];
