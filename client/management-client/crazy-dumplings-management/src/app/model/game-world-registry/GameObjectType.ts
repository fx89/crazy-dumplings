import { GameAssetsRepository } from './GameAssetsRepository';
import { GameObjectTypeClass } from './GameObjectTypeClass';

export class GameObjectType {
    id: number;
    gameAssetsRepositoryId: number;
    gameObjectTypeClassId: number;
    uniqueName: string;
    isExperimental: boolean;
    description: string;

    GameObjectType() {
        this.id = 0;
    }
}
