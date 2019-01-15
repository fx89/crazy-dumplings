import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MainMenuCardComponent } from './main-menu-card.component';

describe('MainMenuIconComponent', () => {
  let component: MainMenuCardComponent;
  let fixture: ComponentFixture<MainMenuCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MainMenuCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MainMenuCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
