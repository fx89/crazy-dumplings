import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginFormSmallComponent } from './login-form-small.component';

describe('LoginFormSmallComponent', () => {
  let component: LoginFormSmallComponent;
  let fixture: ComponentFixture<LoginFormSmallComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginFormSmallComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginFormSmallComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
