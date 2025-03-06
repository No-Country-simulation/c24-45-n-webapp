import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadComponent: () =>
      import('./main.component').then((c) => c.MainComponent),
  },
  /* new routes */
];
