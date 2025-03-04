import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  loginForm: FormGroup;
  passwordVisibility = false;
  formSubmitted = false;

  constructor(private fb: FormBuilder) {
    this.loginForm = this.fb.group(
      {
        email: ['', [Validators.required, Validators.email]],
        password: ['', [Validators.required]],
        confirmPassword: ['', [Validators.required]]
      },
      { validators: this.passwordMatchValidator }
    );
  }

  //para validar el campo email y que este no sea invalido
  isEmailInvalid() {
    const emailControl = this.loginForm.get('email');
    return emailControl?.invalid && emailControl?.value !== '';
  }

  //para validar los campos de password y confirmar password
  isConfirmPasswordInvalid() {
    const confirmPasswordControl = this.loginForm.get('confirmPassword');
    const passwordControl = this.loginForm.get('password');

    if(!confirmPasswordControl || !passwordControl) {
      return false;
    }
    
    return confirmPasswordControl?.value !== '' && passwordControl?.value !== confirmPasswordControl?.value;
  }

  //para verificar que el password y confirmar password sean iguales en tiempo real
  passwordMatchValidator(formGroup: FormGroup) {
    const password = formGroup.get('password')?.value;
    const confirmPassword = formGroup.get('confirmPassword')?.value;
    return password === confirmPassword ? null : { passwordMismatch: true };
  }

  //para manejar las invalidaciones
  isFieldInvalid(fieldName: string) {
    const control = this.loginForm.get(fieldName);
    return control?.invalid && this.formSubmitted;
  }

  //para enviar el formulario, falta implementar la logica de envio
  onSubmit() {
    this.formSubmitted = true;
    if (this.loginForm.valid) {
      console.log(this.loginForm.value);
    }else{
      console.log('Form is invalid');
    }
  }
}
