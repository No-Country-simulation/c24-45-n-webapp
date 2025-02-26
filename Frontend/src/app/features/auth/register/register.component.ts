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

  constructor(private fb: FormBuilder) {
    this.registerForm = this.fb.group(
      {
        name: ['', [Validators.required, Validators.minLength(3)]],
        lastName: ['', [Validators.required, Validators.minLength(3)]],
        age: ['', [Validators.required, Validators.min(18), Validators.pattern('^[0-9]*$')]],
        phone: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
        address: ['', [Validators.required, Validators.minLength(10)]],
        email: ['', [Validators.required, Validators.email]],
        password: ['', [Validators.required, Validators.minLength(8)]],
        confirmPassword: ['', [Validators.required]],
        userType: ['', [Validators.required]]
      },
      { validators: this.passwordsMatchValidator } //necesario! es para que se use el validador de las contraseñas
    );
  }

  // Valido si las contraseñas coinciden
  passwordsMatchValidator(formGroup: FormGroup) {
    const password = formGroup.get('password');
    const confirmPassword = formGroup.get('confirmPassword');
    if (password?.value !== confirmPassword?.value) {
      confirmPassword?.setErrors({ passwordsMatch: true });
    } else {
      confirmPassword?.setErrors(null);
    }
  }

  // Para verificar si los campos son validos y hacer que muestre los errores.
  isFieldValid(fieldName: string) {
    const control = this.registerForm.get(fieldName);
    return control?.invalid && this.formSubmitted;
  }

  // Con esto las verifico las contraseñas que sean iguales
  getPasswordMatch() {
    return this.registerForm.get('password')?.value === this.registerForm.get('confirmPassword')?.value;
  }

  //Esto es la logica que contiene al enviar el formulario, debo agregar la logica de envio de datos al backend
  onSubmit() {
    this.formSubmitted = true;
    if (this.registerForm.valid) {
      const userData = this.registerForm.value;
      console.log('Formulario de registro:', userData);

    } else {
      console.log('Formulario no válido');
    }
  }
}
