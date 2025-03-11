import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-volunteer-form',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './volunteer-form.component.html',
  styleUrl: './volunteer-form.component.css'
})
export class VolunteerFormComponent implements OnInit {
  miFormulario!: FormGroup; 
  avatarPreview: string | ArrayBuffer | null = null;
  defaultAvatar = './assets/avatar.jpg';
  formSubmitted = false;

  constructor(private fb: FormBuilder, private router: Router) {}

  onFileChange(event: any) {
    const file = event.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onload = (e) => {
        this.avatarPreview = e.target?.result || null;
      };
      reader.readAsDataURL(file);
    }
  }

  ngOnInit() {
    this.avatarPreview = this.defaultAvatar;
    this.miFormulario = this.fb.group({
      names: ['', Validators.required],
      surnames: ['', Validators.required],
      birthday: ['', Validators.required],
      country: ['', Validators.required],
      province: ['', Validators.required],
      city: ['', Validators.required],
      volunteerPreference: ['', Validators.required],
      skills: ['', Validators.required],
      phone: ['', Validators.required],
      address: ['', Validators.required],
      zipCode: ['', Validators.required],
      avatar: [null],
    });
  }

  onSubmit() { 
    this.formSubmitted = true;
    if (this.miFormulario.valid) {
      console.log( this.formSubmitted);
      console.log(this.miFormulario.value);
      this.router.navigate(['/muro']);
    }
    else {
      console.log('Formulario inválido');
    }
  }

}
