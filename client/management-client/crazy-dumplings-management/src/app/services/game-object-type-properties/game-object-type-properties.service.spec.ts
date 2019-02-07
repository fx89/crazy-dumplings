import { TestBed } from '@angular/core/testing';

import { GameObjectTypePropertiesService } from './game-object-type-properties.service';

describe('GameObjectTypePropertiesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GameObjectTypePropertiesService = TestBed.get(GameObjectTypePropertiesService);
    expect(service).toBeTruthy();
  });
});
