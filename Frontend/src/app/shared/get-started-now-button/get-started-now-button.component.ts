import { NgClass } from '@angular/common';
import { Component, input } from '@angular/core';

export enum SizeType {
  SMALL = 'small',
  DEFAULT = 'default',
  MEDIUM = 'medium',
  LARGE = 'large',
}

@Component({
  selector: 'get-started-now-button',
  imports: [NgClass],
  templateUrl: './get-started-now-button.component.html',
  styleUrl: './get-started-now-button.component.css',
})
export class GetStartedNowButtonComponent {
  size = input.required<SizeType>();
  text = input<string>('Get Started Now');
  invertStyle = input<boolean>(false);
  SizeType = SizeType;
}
