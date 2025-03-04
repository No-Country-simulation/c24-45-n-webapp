import { Routes } from '@angular/router';
import { RegisterComponent } from './features/auth/register/register.component';

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
];
