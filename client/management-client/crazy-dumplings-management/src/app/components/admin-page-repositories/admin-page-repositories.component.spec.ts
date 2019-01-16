import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminPageRepositoriesComponent } from './admin-page-repositories.component';

describe('AdminPageRepositoriesComponent', () => {
  let component: AdminPageRepositoriesComponent;
  let fixture: ComponentFixture<AdminPageRepositoriesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminPageRepositoriesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminPageRepositoriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
