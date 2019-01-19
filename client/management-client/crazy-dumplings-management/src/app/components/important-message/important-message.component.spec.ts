import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImportantMessageComponent } from './important-message.component';

describe('ImportantMessageComponent', () => {
  let component: ImportantMessageComponent;
  let fixture: ComponentFixture<ImportantMessageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImportantMessageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImportantMessageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
