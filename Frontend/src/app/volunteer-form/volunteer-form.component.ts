import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-volunteer-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './volunteer-form.component.html',
  styleUrl: './volunteer-form.component.css'
})
export class VolunteerFormComponent implements OnInit {
  miFormulario!: FormGroup; // Define miFormulario
  avatarPreview: string | ArrayBuffer | null = null;
  defaultAvatar = './assets/avatar.jpg';

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
  irMuro() {
    this.router.navigate(['/muro']);
  }
}