import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetStartedNowButtonComponent } from './get-started-now-button.component';

describe('GetStartedNowButtonComponent', () => {
  let component: GetStartedNowButtonComponent;
  let fixture: ComponentFixture<GetStartedNowButtonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GetStartedNowButtonComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetStartedNowButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
