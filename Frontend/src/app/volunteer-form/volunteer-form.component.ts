import { CommonModule } from '@angular/common';
import { Component, computed, inject, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { JwtService } from '../core/services/jwt.service';
import { VolunteerService } from '../core/services/volunteer.service';

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

  private readonly jwtSvc = inject(JwtService)
  private readonly volunteerSvc = inject(VolunteerService)

  id = computed(()=>this.jwtSvc.user()?.volunteerId)
  token = this.jwtSvc.currentUser

  constructor(private fb: FormBuilder, private router: Router) {
  }

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
      lastname: ['', Validators.required],
      birthday: ['', Validators.required],
      country: ['', Validators.required],
      state: ['', Validators.required],
      city: ['', Validators.required],
      preference: ['', Validators.required],
      skills: [''],
      phone: [0, Validators.required],
      street: ['', Validators.required],
      cp: [''],
    });
  }

  onSubmit() { // Define onSubmit()
    this.formSubmitted = true;
    if (this.miFormulario.valid) {
      let data = this.miFormulario.getRawValue()
      data.phone = parseInt(data.phone)
      this.volunteerSvc.updateVolunteer(this.id()!, data).subscribe({
        next:r=>{
          this.router.navigate(['/feed']);
        },
        error:e=>console.log(e)
      })
    }
    else {
      console.log('Formulario inválido');
    }
  }
  irMuro() {
    this.router.navigate(['/muro']);
  }

}
