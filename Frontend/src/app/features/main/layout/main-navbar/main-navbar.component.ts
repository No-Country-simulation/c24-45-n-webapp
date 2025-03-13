import { NgClass, TitleCasePipe, UpperCasePipe } from '@angular/common';
import { Component, computed, effect, inject, signal } from '@angular/core';
import { JwtService } from '../../../../core/services/jwt.service';
import { Router, RouterLink } from '@angular/router';
import { VolunteerService } from '../../../../core/services/volunteer.service';

@Component({
  selector: 'main-navbar',
  imports: [NgClass, TitleCasePipe, UpperCasePipe, RouterLink],
  templateUrl: './main-navbar.component.html',
  styleUrl: './main-navbar.component.css'
})
export class MainNavbarComponent {
  isToggled:boolean = true;
  private readonly jwtSvc = inject(JwtService)
  private readonly volunteerSvc = inject(VolunteerService)
  private readonly router = inject(Router)

  user = computed(()=>this.jwtSvc.currentUser)

  onLogout(){
    this.jwtSvc.logout()
  }

  toggleMenu(){
    this.isToggled = !this.isToggled;
  }
}
