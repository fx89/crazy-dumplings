import { TestBed } from '@angular/core/testing';

import { GameObjectTypesService } from './game-object-types.service';

describe('GameObjectTypesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GameObjectTypesService = TestBed.get(GameObjectTypesService);
    expect(service).toBeTruthy();
  });
});
