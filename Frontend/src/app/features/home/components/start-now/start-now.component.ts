import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'start-now',
  imports: [],
  templateUrl: './start-now.component.html',
  styleUrl: './start-now.component.css',
})
export class StartNowComponent {

  constructor(private Router: Router) {}

  onRegister(){
    this.Router.navigate(['/register']);
  }

  }

