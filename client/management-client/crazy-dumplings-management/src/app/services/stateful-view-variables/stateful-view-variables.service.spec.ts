import { TestBed } from '@angular/core/testing';

import { ViewVariablesService } from './view-variables.service';

describe('ViewVariablesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ViewVariablesService = TestBed.get(ViewVariablesService);
    expect(service).toBeTruthy();
  });
});
