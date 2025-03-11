import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MuroComponent } from './muro.component';

describe('MuroComponent', () => {
  let component: MuroComponent;
  let fixture: ComponentFixture<MuroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MuroComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MuroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
