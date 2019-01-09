import { TestBed } from '@angular/core/testing';

import { CrazyDumplingsHttpService } from './crazy-dumplings-http.service';

describe('CrazyDumplingsHttpService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CrazyDumplingsHttpService = TestBed.get(CrazyDumplingsHttpService);
    expect(service).toBeTruthy();
  });
});
