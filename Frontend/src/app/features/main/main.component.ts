import { Component } from '@angular/core';
import { MainNavbarComponent } from './layout/main-navbar/main-navbar.component';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'main',
  imports: [MainNavbarComponent, RouterOutlet],
  templateUrl: './main.component.html',
  styleUrl: './main.component.css',
})
export class MainComponent {}
