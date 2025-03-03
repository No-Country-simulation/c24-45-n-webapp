import { Component, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-social-navbar',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './social-navbar.component.html',
  styleUrl: './social-navbar.component.css'
})
export class SocialNavbarComponent {
  isDropdownOpen = false;
  userProfileImage = 'images/Greenpeace.jpg';
  notificationsCount = 3;
  searchQuery = '';

  clearNotifications() {
    this.notificationsCount = 0;
  }

  toggleDropdown() {
    this.isDropdownOpen = !this.isDropdownOpen;
  }

  logout() {
    console.log('Cerrando sesion...')
    // agregar la logica para cerrar sesion
  }

  search(){
    console.log('Buscando: ', this.searchQuery);
    // agregar la logica para buscar
  }
}
