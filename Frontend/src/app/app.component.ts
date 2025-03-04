import { Component } from '@angular/core';
import { RouterLink, RouterOutlet, Router } from '@angular/router';
import { RegisterComponent } from "./features/auth/register/register.component";
import '@fontsource-variable/montserrat';

@Component({
  selector: 'app-root',
  standalone  : true,
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  imports: [RegisterComponent, RouterOutlet, RouterLink]
})
export class AppComponent {
  title = 'Frontend';

  constructor(private router: Router) {
    console.log('App component created');
  }

  Register(ruta : string) {
    this.router.navigate(["/" + ruta]);
  }
}
