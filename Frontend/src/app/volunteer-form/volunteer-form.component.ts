import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-volunteer-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './volunteer-form.component.html',
  styleUrl: './volunteer-form.component.css'
})
export class VolunteerFormComponent implements OnInit {
  miFormulario!: FormGroup; // Define miFormulario

  constructor(private fb: FormBuilder) {}

  ngOnInit() {
    this.miFormulario = this.fb.group({
      name: ['', Validators.required],
      surname: ['', Validators.required],
      birthday: ['', Validators.required],
      country: ['', Validators.required],
      province: ['', Validators.required],
      city: ['', Validators.required],
      volunteer_preference: ['', Validators.required],
      skill: ['', Validators.required],
      phone: ['', Validators.required],
      adress: ['', Validators.required],
      zip_code: ['', Validators.required],
    });
  }

  onSubmit() { // Define onSubmit()
    if (this.miFormulario.valid) {
      console.log(this.miFormulario.value);
    }
  }
}