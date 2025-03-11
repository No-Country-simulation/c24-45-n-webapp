import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'about-us',
  imports: [],
  templateUrl: './about-us.component.html',
  styleUrl: './about-us.component.css',
})
export class AboutUsComponent {

  router = inject(Router)

  goToRegister(){
    this.router.navigate(['/register'],{replaceUrl:true})
  }
}
