import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'navbar-component',
  standalone: true,
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent {
  constructor(private router: Router) {}

  onSignIn() {
    this.router.navigate(['/login']);
  }
}
