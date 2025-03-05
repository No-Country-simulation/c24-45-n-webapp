import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VolunteerFormComponent } from './volunteer-form.component';

describe('VolunteerFormComponent', () => {
  let component: VolunteerFormComponent;
  let fixture: ComponentFixture<VolunteerFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VolunteerFormComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VolunteerFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
