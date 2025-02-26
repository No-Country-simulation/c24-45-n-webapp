import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  registerForm: FormGroup;
  formSubmitted = false;
  isModalOpen = false;

  constructor(private fb: FormBuilder) {
    this.registerForm = this.fb.group(
      {
        name: ['', [Validators.required, Validators.minLength(3)]],
        email: ['', [Validators.required, Validators.email]],
        password: ['', [Validators.required, Validators.minLength(8)]],
        confirmPassword: ['', [Validators.required]],
      },
      { validators: this.passwordMatchValidator }
    );
  }

  // es para abrir y cerrar el modal
  toggleModal() {
    this.isModalOpen = !this.isModalOpen;
    if(!this.isModalOpen) {
      this.registerForm.reset();
      this.formSubmitted = false;
    }
  }

  //con esto puedo validar y verificar que las contraseñas coincidan
  passwordMatchValidator(formGroup: FormGroup) {
    const password = formGroup.get('password')?.value;
    const confirmPassword = formGroup.get('confirmPassword')?.value;

    return password === confirmPassword ? null : { passwordMismatch: true };
  }

  // Para poder verificar si el campo de email es valido
  isEmailInvalid(): boolean {
    const emailControl = this.registerForm.get('email');
    if (!emailControl) {
      return false;
    }
    return emailControl.invalid && (emailControl.touched || this.formSubmitted);
  }

  // con esto valido si el campo de confirmacion es valido
  isConfirmPasswordInvalid(): boolean {
    const confirmPasswordControl = this.registerForm.get('confirmPassword');
    const passwordControl = this.registerForm.get('password');

    if (!confirmPasswordControl || !passwordControl) {
      return false;
    }

    // muestro los errores cuando el usuario toca el input o envia el formularo
    if (confirmPasswordControl.touched || this.formSubmitted) {
      if (confirmPasswordControl.hasError('required')) {
        return true;
      }

      if (this.registerForm.hasError('passwordMismatch')) {
        return true;
      }
    }

    return false;
  }

  // Verificar si algun campo es inválido
  isFieldValid(fieldName: string): boolean {
    const control = this.registerForm.get(fieldName);
    return control ? control.invalid && (control.touched || this.formSubmitted) : false;
  }

  // Para enviar el formulario, me falta la lógica de enviar los datos al servidor
  onSubmit() {
    this.formSubmitted = true;

    if (this.registerForm.valid) {
      const userData = this.registerForm.value;
      console.log('Formulario de registro:', userData);
      this.registerForm.reset();
      this.formSubmitted = false;
    } else {
      console.log('Formulario no válido');
    }
  }
}