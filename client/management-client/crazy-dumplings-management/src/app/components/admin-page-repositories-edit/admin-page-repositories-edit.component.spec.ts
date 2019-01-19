import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminPageRepositoriesEditComponent } from './admin-page-repositories-edit.component';

describe('AdminPageRepositoriesEditComponent', () => {
  let component: AdminPageRepositoriesEditComponent;
  let fixture: ComponentFixture<AdminPageRepositoriesEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminPageRepositoriesEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminPageRepositoriesEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
