import { Injectable } from '@angular/core';
import { CrazyDumplingsHttpService } from '../crazy-dumplings-http/crazy-dumplings-http.service';
import { Observable } from 'rxjs';
import { GameObjectType } from '../../model/game-world-registry/GameObjectType';
import { GameObjectTypeState } from '../../model/game-world-registry/GameObjectTypeState';
import { EndpointResponse } from '../../model/game-world-registry/EndpointResponse';
import { AbstractBackendRequestService } from '../../utils/abstract-backend-request-service';

@Injectable({
  providedIn: 'root'
})
export class GameObjectTypeStatesService extends AbstractBackendRequestService {

    constructor(
        httpService: CrazyDumplingsHttpService
    ) { 
        super(httpService, 'game-object-type-states');
    }



    public getGameObjectTypeStatesList(repoId: number, gameObjectType: GameObjectType): Observable<GameObjectTypeState[]> {
        return this.list(repoId, gameObjectType.id, true);
    }

    public saveGameObjectTypeState(repoId: number, gameObjectTypeState: GameObjectTypeState): Observable<GameObjectTypeState> {
        return this.save(repoId, gameObjectTypeState.gameObjectTypeId, gameObjectTypeState.id, gameObjectTypeState, true);
    }

    public deleteGameObjectTypeState(repoId: number, gameObjectTypeState: GameObjectTypeState): Observable<EndpointResponse<any>> {
        return this.delete(repoId, gameObjectTypeState.gameObjectTypeId, gameObjectTypeState.gameObjectTypeId, false);
    }



    public bulkSaveGameObjectTypeStates(repoId: number, gameObjectTypeId: number, states: GameObjectTypeState[]): Observable<EndpointResponse<any>> {
        return this.bulkSave(repoId, gameObjectTypeId, states);
    }



    public bulkDeleteGameObjectTypeStates(repoId: number, gameObjectTypeId: number, states: GameObjectTypeState[]): Observable<any> {
        const bulkRequest: number[] = [];

        for(let state of states) {
            bulkRequest.push(state.id);
        }

        return this.bulkDelete(repoId, gameObjectTypeId, bulkRequest);
    }

}
