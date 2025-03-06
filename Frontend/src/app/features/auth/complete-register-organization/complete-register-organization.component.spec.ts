import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompleteRegisterOrganizationComponent } from './complete-register-organization.component';

describe('CompleteRegisterOrganizationComponent', () => {
  let component: CompleteRegisterOrganizationComponent;
  let fixture: ComponentFixture<CompleteRegisterOrganizationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CompleteRegisterOrganizationComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CompleteRegisterOrganizationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
