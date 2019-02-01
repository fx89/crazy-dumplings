import { GameAssetsRepository } from './GameAssetsRepository';
import { GameObjectTypeClass } from './GameObjectTypeClass';

export class GameObjectType {
    id: number;
    gameAssetsRepository: GameAssetsRepository;
    gameObjectTypeClass: GameObjectTypeClass;
    uniqueName: string;
    isExperimental: boolean;
    description: string;
}
