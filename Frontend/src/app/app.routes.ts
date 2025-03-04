import { Routes } from '@angular/router';
import { LoginComponent } from "./features/auth/login/login.component";

export const routes: Routes = [
    {
        path: '', 
        loadComponent: () =>
            import('./features/home/home.component').then((c) => c.HomeComponent),
        pathMatch: 'full',
    },
    { path: 'login', component: LoginComponent },
];
