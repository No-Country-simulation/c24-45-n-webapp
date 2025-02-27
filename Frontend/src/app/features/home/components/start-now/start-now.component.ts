import { Component } from '@angular/core';
import {
  GetStartedNowButtonComponent,
  SizeType,
} from '../../../../shared/get-started-now-button/get-started-now-button.component';

@Component({
  selector: 'start-now',
  imports: [GetStartedNowButtonComponent],
  templateUrl: './start-now.component.html',
  styleUrl: './start-now.component.css',
})
export class StartNowComponent {
  SizeType = SizeType;
}
