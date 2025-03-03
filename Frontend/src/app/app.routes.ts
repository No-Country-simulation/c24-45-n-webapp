import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadComponent: () =>
      import('./features/home/home.component').then((c) => c.HomeComponent),
  },
  {
    path: 'complete-register-organization',
    loadComponent: () =>
      import('./features/complete-register-organization/complete-register-organization.component').then(
        (c) => c.CompleteRegisterOrganizationComponent
      ),
  },
];
