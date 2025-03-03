import { Component } from '@angular/core';
import { SocialNavbarComponent } from '../../shared/social-navbar/social-navbar.component';
import { ReactiveFormsModule, FormGroup, Validators, FormBuilder } from '@angular/forms';

@Component({
  selector: 'complete-register-organization',
  standalone: true,
  imports: [SocialNavbarComponent, ReactiveFormsModule],
  templateUrl: './complete-register-organization.component.html',
  styleUrl: './complete-register-organization.component.css'
})
export class CompleteRegisterOrganizationComponent {
  formulario: FormGroup;
  imagenSeleccionada: File | null = null;
  formSubmitted = false;

  constructor(private fb: FormBuilder) {
    this.formulario = this.fb.group({
      nombre: ['', Validators.required],
      causa: [''],
      fundacion: [''],
      descripcion: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      telefono: ['', [Validators.required, Validators.pattern('^[0-9]+$')]],
      pais: ['', Validators.required],
      provincia: ['', Validators.required],
      ciudad: ['', Validators.required],
      direccion: ['', Validators.required],
      zip: ['', Validators.required],
      website: ['', Validators.required],
      social: ['', Validators.required],
      imagen: [null]
    });
  }

  onFileChange(event: any) {
    const file = event.target.files[0];
    if (file) {
      this.imagenSeleccionada = file;
      this.formulario.patchValue({ imagen: file });
    }
  }

  isFieldInvalid(fieldName: string) {
    const control = this.formulario.get(fieldName);
    return control?.invalid && (control?.touched || this.formSubmitted);
  }
  

  onSubmit() {
    this.formSubmitted = true;

    if (this.formulario.invalid) {
      return;
    }

    const formData = new FormData();
    Object.keys(this.formulario.controls).forEach((key) => {
      formData.append(key, this.formulario.get(key)?.value);
    });

    if (this.imagenSeleccionada) {
      formData.append('imagen', this.imagenSeleccionada);
    }

    console.log('Formulario Enviado:', this.formulario.value);
    alert('Formulario enviado con éxito!');
  }
}
