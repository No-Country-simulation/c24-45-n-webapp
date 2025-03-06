import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompaniesWorkingWithUsComponent } from './companies-working-with-us.component';

describe('CompaniesWorkingWithUsComponent', () => {
  let component: CompaniesWorkingWithUsComponent;
  let fixture: ComponentFixture<CompaniesWorkingWithUsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CompaniesWorkingWithUsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CompaniesWorkingWithUsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
