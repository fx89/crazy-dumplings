import { Injectable } from '@angular/core';
import { CrazyDumplingsHttpService } from '../crazy-dumplings-http/crazy-dumplings-http.service';
import { Observable } from 'rxjs';
import { GameObjectType } from '../../model/game-world-registry/GameObjectType';
import { ResponseUtils } from '../../utils/response-utils';
import { GameObjectTypeClass } from '../../model/game-world-registry/GameObjectTypeClass';
import { EndpointResponse } from '../../model/game-world-registry/EndpointResponse';
import { AbstractBackendRequestService } from '../../utils/abstract-backend-request-service';
import { GameObjectTypePropertiesService } from '../game-object-type-properties/game-object-type-properties.service';

@Injectable({
  providedIn: 'root'
})
export class GameObjectTypesService extends AbstractBackendRequestService {

    constructor(
        public properties: GameObjectTypePropertiesService,
        httpService: CrazyDumplingsHttpService
    ) { 
        super(httpService, 'game-object-types');
    }



    public getGameObjectClassesList(): Observable<GameObjectTypeClass[]> {
        return this.getRequest('listClasses', null, true);
    }

    public addGameObjectClass(name: string): Observable<GameObjectTypeClass> {
        return this.postRequest('addClass', null, new Map([['class_name', name]]), true);
    }

    public getGameObjectTypesList(repoId: number): Observable<GameObjectType[]> {
        return this.list(repoId, null, true);
    }

    public saveGameObjectType(repoId: number, gameObjectType: GameObjectType): Observable<GameObjectType> {
        return this.save(repoId, null, gameObjectType.id, gameObjectType, true);
    }

    public deleteGameObjectType(repoId: number, gameObjectType: GameObjectType): Observable<EndpointResponse<any>> {
        return this.delete(repoId, null, gameObjectType.id, false);
    }

}
