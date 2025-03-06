import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { VolunteerFormComponent } from './volunteer-form/volunteer-form.component';
import { ReactiveFormsModule, FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, VolunteerFormComponent, ReactiveFormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Share your help';
}
