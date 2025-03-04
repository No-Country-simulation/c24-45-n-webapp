import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter, withComponentInputBinding } from '@angular/router';
import { routes } from './app.routes';
import { provideHttpClient, withFetch } from '@angular/common/http';
import { LoginComponent } from './features/auth/login/login.component';
import { AppComponent } from './app.component';
import { HomeComponent } from './features/home/home.component';
export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes, withComponentInputBinding()),
    provideHttpClient(withFetch()),
    LoginComponent,
    AppComponent,
    HomeComponent,
  ],
};
