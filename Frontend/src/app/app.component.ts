import { Component } from '@angular/core';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { LoginComponent } from "./features/auth/login/login.component";
import { HomeComponent } from "./features/home/home.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, LoginComponent, RouterLink, HomeComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Frontend';

  constructor(private router: Router) {
    console.log('App component created');
  }

  Login(ruta : string) {
    this.router.navigate(["/" + ruta]);
  }

  Register(ruta : string) {
    this.router.navigate(["/" + ruta]);
  }
}
