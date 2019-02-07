import { GameObjectType } from './GameObjectType';

export class GameObjectTypeProperty {
    public id: number;
    public gameObjectType: GameObjectType;
    public propertyName: string;
    public propertyDefaultValue: number;
    public propertyMinValue: number;
    public propertyMaxValue: number;
}