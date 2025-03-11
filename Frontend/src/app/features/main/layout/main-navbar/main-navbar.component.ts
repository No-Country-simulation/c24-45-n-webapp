import { NgClass } from '@angular/common';
import { Component, effect, inject, signal } from '@angular/core';
import { JwtService } from '../../../../core/services/jwt.service';

@Component({
  selector: 'main-navbar',
  imports: [NgClass],
  templateUrl: './main-navbar.component.html',
  styleUrl: './main-navbar.component.css'
})
export class MainNavbarComponent {
  isToggled:boolean = true;
  private readonly jwtSvc = inject(JwtService)

  user = signal<string>(this.jwtSvc.decodedToken()!.sub)

  toggleMenu(){
    this.isToggled = !this.isToggled;
  }
}
