import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SidebarOrganizationComponent } from './sidebar-organization.component';

describe('SidebarOrganizationComponent', () => {
  let component: SidebarOrganizationComponent;
  let fixture: ComponentFixture<SidebarOrganizationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SidebarOrganizationComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SidebarOrganizationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
