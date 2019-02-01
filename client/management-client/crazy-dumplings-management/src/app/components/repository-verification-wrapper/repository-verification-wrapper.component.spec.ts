import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RepositoryVerificationWrapperComponent } from './repository-verification-wrapper.component';

describe('RepositoryVerificationWrapperComponent', () => {
  let component: RepositoryVerificationWrapperComponent;
  let fixture: ComponentFixture<RepositoryVerificationWrapperComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RepositoryVerificationWrapperComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RepositoryVerificationWrapperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
