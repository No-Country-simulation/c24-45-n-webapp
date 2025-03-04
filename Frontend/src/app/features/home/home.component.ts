import { Component } from '@angular/core';
import { NavbarComponent } from '../../layout/navbar/navbar.component';
import { StartNowComponent } from './components/start-now/start-now.component';
import { AboutUsComponent } from './components/about-us/about-us.component';
import { CompaniesWorkingWithUsComponent } from './components/companies-working-with-us/companies-working-with-us.component';
import { NgClass, NgIf } from '@angular/common';
import { FooterComponent } from '../../layout/footer/footer.component';

@Component({
  selector: 'app-home',
  imports: [
    NavbarComponent,
    StartNowComponent,
    AboutUsComponent,
    CompaniesWorkingWithUsComponent,
    FooterComponent,
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent {}
