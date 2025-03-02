import { Component } from '@angular/core';
import {
  GetStartedNowButtonComponent,
  SizeType,
} from '../../../../shared/get-started-now-button/get-started-now-button.component';

@Component({
  selector: 'about-us',
  imports: [GetStartedNowButtonComponent],
  templateUrl: './about-us.component.html',
  styleUrl: './about-us.component.css',
})
export class AboutUsComponent {
  SizeType = SizeType;
}
