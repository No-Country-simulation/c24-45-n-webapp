import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VolunteerProfileComponent } from './volunteer-profile.component';

describe('VolunteerProfileComponent', () => {
  let component: VolunteerProfileComponent;
  let fixture: ComponentFixture<VolunteerProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VolunteerProfileComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VolunteerProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
