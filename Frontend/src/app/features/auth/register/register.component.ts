import { CommonModule } from '@angular/common';
import { Component, input, OnInit } from '@angular/core';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators, FormControlOptions } from '@angular/forms';
import { Location } from '@angular/common';
import { Router, ActivatedRoute, RouterModule } from '@angular/router';
import { AuthService } from '../../../core/services/auth.service';
import { UserRegistrationData } from '../../../shared/models/user.interface';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterModule],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  formSubmitted = false;
  userType: string | null = null;
  params = input.name

  constructor(
    private fb: FormBuilder,
    private location: Location,
    private router: Router,
    private route: ActivatedRoute,
    private readonly authSvc: AuthService
  ) {
    this.registerForm = this.fb.group(
      {
        userName: ['', [Validators.required, Validators.minLength(3)]],
        email: ['', [Validators.required, Validators.email]],
        password: ['', [Validators.required, Validators.minLength(8)]],
        password2: ['', [Validators.required]],
      },
      { validators: this.passwordMatchValidator } as FormControlOptions
    );
  }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.userType = params['type'] || null;
    });
  }

  //con esto puedo validar y verificar que las contraseñas coincidan
  passwordMatchValidator(formGroup: FormGroup) {
    const password = formGroup.get('password')?.value;
    const password2 = formGroup.get('password2')?.value;
    return password === password2 ? null : { passwordMismatch: true };
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
    const confirmPasswordControl = this.registerForm.get('password2');
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
    if (this.registerForm.invalid) {
      this.registerForm.markAllAsTouched()
      return;
    }
    const registeredData = this.registerForm.getRawValue()
    if (this.userType === 'organization') {
      this.router.navigate(['/complete-register-organization'], { state: { registeredData } });
    } else {
      this.authSvc.register(registeredData).subscribe({
        next: r => {this.router.navigate(['/login'], { replaceUrl: true })},
        error: e => console.log(e.error.message),
      })
    }
  }
  goBack() {
    this.location.back();
  }
}
