import { Component, computed, inject, signal } from '@angular/core';
import { Router } from '@angular/router';
import { JwtService } from '../../core/services/jwt.service';

@Component({
  selector: 'navbar-component',
  standalone: true,
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent {

  private readonly router = inject(Router)
  private jwtSvc = inject(JwtService)

  isUserLogged = computed(()=> this.jwtSvc.tokenExist())

  goTo(path:string) {
    this.router.navigate([`/${path}`]);
  }
}
