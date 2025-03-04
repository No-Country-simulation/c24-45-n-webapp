import { Component } from '@angular/core';

import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { LoginComponent } from "./features/auth/login/login.component";
import "@fontsource-variable/montserrat";

// >>>>>>> 6270de646977506652213ba641fcfbfd1aeff523

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, LoginComponent, RouterLink],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'Frontend';

  constructor(private router : Router) {
    console.log('AppComponent constructor');
  }

  login(ruta : string) {
    this.router.navigate(["/" + ruta]);
  }
}
