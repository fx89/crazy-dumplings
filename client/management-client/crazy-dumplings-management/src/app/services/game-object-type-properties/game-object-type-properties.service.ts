import { Injectable } from '@angular/core';
import { CrazyDumplingsHttpService } from '../crazy-dumplings-http/crazy-dumplings-http.service';
import { Observable } from 'rxjs';
import { GameObjectType } from '../../model/game-world-registry/GameObjectType';
import { GameObjectTypeProperty } from '../../model/game-world-registry/GameObjectTypeProperty';
import { EndpointResponse } from '../../model/game-world-registry/EndpointResponse';
import { AbstractBackendRequestService } from '../../utils/abstract-backend-request-service';

@Injectable({
  providedIn: 'root'
})
export class GameObjectTypePropertiesService extends AbstractBackendRequestService {

    constructor(
        httpService: CrazyDumplingsHttpService
    ) { 
        super(httpService, 'game-object-type-properties');
    }



    public getGameObjectTypePropertiesList(repoId: number, gameObjectType: GameObjectType): Observable<GameObjectTypeProperty[]> {
        return this.list(repoId, gameObjectType.id, true);
    }

    public saveGameObjectTypeProperty(repoId: number, gameObjectTypeProperty: GameObjectTypeProperty): Observable<GameObjectTypeProperty> {
        return this.save(repoId, gameObjectTypeProperty.gameObjectTypeId, gameObjectTypeProperty.id, gameObjectTypeProperty, true);
    }

    public deleteGameObjectTypeProperty(repoId: number, gameObjectTypeProperty: GameObjectTypeProperty): Observable<EndpointResponse<any>> {
        return this.delete(repoId, gameObjectTypeProperty.gameObjectTypeId, gameObjectTypeProperty.gameObjectTypeId, false);
    }



    public bulkSaveGameObjectTypeProperties(repoId: number, gameObjectTypeId: number, properties: GameObjectTypeProperty[]): Observable<EndpointResponse<any>> {
        return this.bulkSave(repoId, gameObjectTypeId, properties);
    }



    public bulkDeleteGameObjectTypeProperties(repoId: number, gameObjectTypeId: number, properties: GameObjectTypeProperty[]): Observable<any> {
        const bulkRequest: number[] = [];

        for(let property of properties) {
            bulkRequest.push(property.id);
        }

        return this.bulkDelete(repoId, gameObjectTypeId, bulkRequest);
    }

}
