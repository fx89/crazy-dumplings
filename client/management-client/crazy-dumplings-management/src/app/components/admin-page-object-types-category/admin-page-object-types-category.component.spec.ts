import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminPageObjectTypesCategoryComponent } from './admin-page-object-types-category.component';

describe('AdminPageObjectTypesCategoryComponent', () => {
  let component: AdminPageObjectTypesCategoryComponent;
  let fixture: ComponentFixture<AdminPageObjectTypesCategoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminPageObjectTypesCategoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminPageObjectTypesCategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
