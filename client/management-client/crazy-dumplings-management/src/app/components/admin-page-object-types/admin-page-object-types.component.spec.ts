import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminPageObjectTypesComponent } from './admin-page-object-types.component';

describe('AdminPageObjectTypesComponent', () => {
  let component: AdminPageObjectTypesComponent;
  let fixture: ComponentFixture<AdminPageObjectTypesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminPageObjectTypesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminPageObjectTypesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
