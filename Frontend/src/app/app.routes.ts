import { Routes } from '@angular/router';
import { authGuard } from './core/guards/auth.guard';
import { noAuthGuard } from './core/guards/no-auth.guard';

export const routes: Routes = [
  {
    path: 'home',
    loadComponent: () =>
      import('./features/home/home.component').then((c) => c.HomeComponent),
  },
  {
    path: 'main',
    loadChildren: () => import('./features/main/main.routes').then(r => r.routes),
    canActivate: [authGuard]
  },
  {
    path: 'register',
    loadComponent: () =>
      import('./features/auth/register/register.component').then((c) => c.RegisterComponent),
  },
  {
    path: 'complete-register-organization',
    loadComponent: () =>
      import('./features/auth/complete-register-organization/complete-register-organization.component').then((c) => c.CompleteRegisterOrganizationComponent),
  },
  {
    path: 'login',
    loadComponent: () =>
      import('./features/auth/login/login.component').then((c) => c.LoginComponent),
  },
  {
    path: '**',
    redirectTo: 'home',
    pathMatch: 'full'
  },
]
