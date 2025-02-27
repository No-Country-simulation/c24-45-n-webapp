import { Component } from '@angular/core';

@Component({
  selector: 'navbar-component',
  imports: [],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css',
})
export class NavbarComponent {
  onSignIn() {
    console.log('clicked on sign in');
  }
}
