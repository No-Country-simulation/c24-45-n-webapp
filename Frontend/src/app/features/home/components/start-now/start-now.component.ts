import { Component, computed, inject } from '@angular/core';
import { Router } from '@angular/router';
import { JwtService } from '../../../../core/services/jwt.service';
import { NgClass } from '@angular/common';

@Component({
  selector: 'start-now',
  imports: [NgClass],
  templateUrl: './start-now.component.html',
  styleUrl: './start-now.component.css',
})
export class StartNowComponent {
  constructor(private router: Router) {}

  private jwtSvc = inject(JwtService)

    isUserLogged = computed(()=> this.jwtSvc.tokenExist())

  onRegister(type: string) {
    this.router.navigate(['/register'], { queryParams: { type } });
  }
  }

