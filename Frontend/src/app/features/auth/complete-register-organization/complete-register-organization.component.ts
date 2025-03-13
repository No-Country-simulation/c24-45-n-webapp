import { Component } from '@angular/core';

@Component({
  selector: 'app-complete-register-organization',
  standalone: true,
  templateUrl: './complete-register-organization.component.html',
  styleUrls: ['./complete-register-organization.component.css'],
  imports: []
})
export class CompleteRegisterOrganizationComponent {
  profileImage: string = 'assets/default-profile-organization.svg';
  userData = history.state.registeredData;

  constructor() {
    console.log(this.userData)
  }

  onFileSelected(event: Event): void {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files[0]) {
      const file = input.files[0];
      const reader = new FileReader();
      reader.onload = (e: any) => {
        this.profileImage = e.target.result;
      };
      reader.readAsDataURL(file);
    }
  }
}
