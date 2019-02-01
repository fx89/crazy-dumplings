import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminPageObjectTypesEditComponent } from './admin-page-object-types-edit.component';

describe('AdminPageObjectTypesEditComponent', () => {
  let component: AdminPageObjectTypesEditComponent;
  let fixture: ComponentFixture<AdminPageObjectTypesEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminPageObjectTypesEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminPageObjectTypesEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
