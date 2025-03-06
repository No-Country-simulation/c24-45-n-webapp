import { NgClass } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'main-navbar',
  imports: [NgClass],
  templateUrl: './main-navbar.component.html',
  styleUrl: './main-navbar.component.css'
})
export class MainNavbarComponent {
  isToggled:boolean = true;

  toggleMenu(){
    this.isToggled = !this.isToggled;
  }
}
