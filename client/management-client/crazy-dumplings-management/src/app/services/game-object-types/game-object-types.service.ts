import { Injectable } from '@angular/core';
import { CrazyDumplingsHttpService } from '../crazy-dumplings-http/crazy-dumplings-http.service';
import { Observable } from 'rxjs';
import { GameObjectType } from '../../model/game-world-registry/GameObjectType';
import { ResponseUtils } from '../../utils/response-utils';
import { GameObjectTypeClass } from '../../model/game-world-registry/GameObjectTypeClass';
import { GameObjectTypeRequest } from '../../model/game-world-registry/GameObjectTypeRequest';
import { EndpointResponse } from '../../model/game-world-registry/EndpointResponse';

@Injectable({
  providedIn: 'root'
})
export class GameObjectTypesService {

    constructor( private httpService: CrazyDumplingsHttpService ) { }



    public getGameObjectClassesList(): Observable<GameObjectTypeClass[]> {
        return ResponseUtils.unwrapEndpointResponse(this.httpService.backendGet('game-object-types/listClasses'));
    }

    public addGameObjectClass(name: string): Observable<GameObjectTypeClass> {
        return ResponseUtils.unwrapEndpointResponse(
                    this.httpService.backendPost('game-object-types/addClass', new Map([['class_name', name]]))
                );
    }

    public getGameObjectTypesList(repoId: number): Observable<GameObjectType[]> {
        return ResponseUtils.unwrapEndpointResponse(this.httpService.backendGet('game-object-types/list', new Map([['repo_id', repoId]])));
    }

    public saveGameObjectType(repoId: number, gameObjectType: GameObjectType): Observable<GameObjectType> {
        return ResponseUtils.unwrapEndpointResponse(
                    gameObjectType.id > 0
                        ? this.updateGameObjectType(repoId, gameObjectType.id, this.createGameObjectTypeRequest(gameObjectType))
                        : this.createGameObjectType(repoId, this.createGameObjectTypeRequest(gameObjectType))
                );
    }

    public deleteGameObjectType(repoId: number, gameObjectType: GameObjectType): Observable<EndpointResponse<any>> {
        return this.httpService.backendDeleteExt(
                        'game-object-types/delete', new Map([['repo_id', repoId], ['asset_id', gameObjectType.id]])
                );
    }

    private createGameObjectType(repoId: number, request: GameObjectTypeRequest): Observable<EndpointResponse<GameObjectType>> {
        return this.httpService.backendPost('game-object-types/add', request, new Map([['repo_id', repoId]]));
    }

    private updateGameObjectType(repoId: number, assetId: number, request: GameObjectTypeRequest)
    : Observable<EndpointResponse<GameObjectType>> {
        return this.httpService.backendPut('game-object-types/update', request, new Map([['repo_id', repoId], ['asset_id', assetId]]));
    }

    private createGameObjectTypeRequest(gameObjectType: GameObjectType): GameObjectTypeRequest {
        const  request: GameObjectTypeRequest = new GameObjectTypeRequest();

        request.description = gameObjectType.description;
        request.experimental = gameObjectType.isExperimental;
        request.gameObjectTypeClassId = gameObjectType.gameObjectTypeClass.id;
        request.uniqueName = gameObjectType.uniqueName;

        return request;
    }
}
