import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PageAlignmentWrapperComponent } from './page-alignment-wrapper.component';

describe('PageAlignmentWrapperComponent', () => {
  let component: PageAlignmentWrapperComponent;
  let fixture: ComponentFixture<PageAlignmentWrapperComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PageAlignmentWrapperComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PageAlignmentWrapperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
