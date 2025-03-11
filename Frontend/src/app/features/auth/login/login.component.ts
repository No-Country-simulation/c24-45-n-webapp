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
  title = 'Sign in with us'
  loginForm: FormGroup;
  passwordVisibility = false;
  formSubmitted = false;
  private readonly authSvc = inject(AuthService)
  private readonly router = inject(Router)

  constructor(private fb: FormBuilder, private location: Location) {
    this.loginForm = this.fb.group(
      {
        email: ['', [Validators.required, Validators.email]],
        password: ['', [Validators.required, Validators.minLength(8)]],
      },
    );
  }

  //para validar el campo email y que este no sea invalido
  isEmailInvalid() {
    const emailControl = this.loginForm.get('email');
    return emailControl?.invalid && emailControl?.value !== '';
  }

  //para manejar las invalidaciones
  isFieldInvalid(fieldName: string) {
    const control = this.loginForm.get(fieldName);
    return control?.invalid && this.formSubmitted;
  }

  //para enviar el formulario, falta implementar la logica de envio
  onSubmit() {
    this.formSubmitted = true;
    if (!this.loginForm.valid) {
      return console.log('Form is invalid');
    }
    const loginData:LoginData = this.loginForm.getRawValue()
    this.authSvc.login(loginData).subscribe({
      next:r=>{
        localStorage.setItem('token', r.token)
      },
      error:e=>console.log(e),
      complete:()=> this.router.navigate(['/'],{replaceUrl:true})
    })
  }

  // Es para volver a la pagina anterior
  goBack() {
    this.location.back();
  }
}
