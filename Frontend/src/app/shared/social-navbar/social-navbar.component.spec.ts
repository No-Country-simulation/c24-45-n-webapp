import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SocialNavbarComponent } from './social-navbar.component';

describe('SocialNavbarComponent', () => {
  let component: SocialNavbarComponent;
  let fixture: ComponentFixture<SocialNavbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SocialNavbarComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SocialNavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
