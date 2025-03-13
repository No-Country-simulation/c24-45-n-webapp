import { Component, computed, inject } from '@angular/core';
import { Router } from '@angular/router';
import { JwtService } from '../../../../core/services/jwt.service';
import { NgClass } from '@angular/common';

@Component({
  selector: 'about-us',
  imports: [NgClass],
  templateUrl: './about-us.component.html',
  styleUrl: './about-us.component.css',
})
export class AboutUsComponent {

  private router = inject(Router)
  private jwtSvc = inject(JwtService)

  isUserLogged = computed(()=> this.jwtSvc.tokenExist())


  goToRegister(){
    this.router.navigate(['/register'],{replaceUrl:true})
  }
}
