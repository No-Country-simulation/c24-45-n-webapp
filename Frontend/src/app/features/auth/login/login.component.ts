import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Location } from '@angular/common';
import { Router, RouterLink } from '@angular/router';
import { LoginData } from '../../../shared/models/login.interface';
import { AuthService } from '../../../core/services/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  title = 'Sign in with us';
  loginForm: FormGroup;
  passwordVisibility = false;
  formSubmitted = false;
  errorMessage = ''; // Mensaje de error para el usuario

  private readonly authSvc = inject(AuthService);
  private readonly router = inject(Router);

  constructor(private fb: FormBuilder, private location: Location) {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8)]],
    });
  }

  // Validar el campo de email
  isEmailInvalid(): boolean {
    const emailControl = this.loginForm.get('email');
    return !!(emailControl && emailControl.invalid && (emailControl.touched || this.formSubmitted));
  }
  
  isFieldInvalid(fieldName: string): boolean {
    const control = this.loginForm.get(fieldName);
    return !!(control && control.invalid && (control.touched || this.formSubmitted));
  }
  

  // Envío del formulario con manejo de errores
  onSubmit() {
    this.formSubmitted = true;
  
    if (!this.loginForm.valid) {
      console.log('Formulario no válido');
      return;
    }
    console.log('Inicio de sesión exitoso. Redirigiendo...');
    this.router.navigate(['/organization-profile'], { replaceUrl: true }); 
  }
  
  

  // Regresar a la página anterior
  goBack() {
    this.location.back();
  }
}
