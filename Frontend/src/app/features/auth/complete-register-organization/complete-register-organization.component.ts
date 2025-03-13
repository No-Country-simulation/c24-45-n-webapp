import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { JwtService } from '../../../core/services/jwt.service';

@Component({
  selector: 'app-complete-register-organization',
  standalone: true,
  templateUrl: './complete-register-organization.component.html',
  styleUrls: ['./complete-register-organization.component.css']
})
export class CompleteRegisterOrganizationComponent {
  private readonly jwtSvc = inject(JwtService);
  private readonly router = inject(Router);

  profileImage: string = 'assets/default-profile-organization.svg';
  userData = history.state.registeredData;

  constructor() {
    console.log(this.userData)
  }

  onFileSelected(event: Event): void {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files[0]) {
      const reader = new FileReader();
      reader.onload = (e: any) => this.profileImage = e.target.result;
      reader.readAsDataURL(input.files[0]);
    }
  }

  completarRegistro() {
    console.log('Registro de organización completado');
    this.router.navigate(['/organization-profile']);
  }
}
