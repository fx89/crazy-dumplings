import { Injectable } from '@angular/core';
import { CrazyDumplingsHttpService } from '../../services/crazy-dumplings-http/crazy-dumplings-http.service';
import { Observable } from 'rxjs';
import { EndpointResponse } from '../../model/game-world-registry/EndpointResponse';
import { GameAssetsRepository } from '../../model/game-world-registry/GameAssetsRepository';
import { map } from 'rxjs/operators';
import { ResponseUtils } from '../../utils/response-utils';
import { AbstractBackendRequestService } from '../../utils/abstract-backend-request-service';

@Injectable({
  providedIn: 'root'
})
export class RepositoriesService extends AbstractBackendRequestService {

    constructor( httpService: CrazyDumplingsHttpService ) { super(httpService, 'repositories'); }

    public getRepositoriesList(): Observable<GameAssetsRepository[]> {
        return this.list(null, null, true);
    }

    public saveRepository(repository: GameAssetsRepository): Observable<GameAssetsRepository> {
        return this.save(repository.id, null, repository.id, repository, true);
    }

    public deleteRepository(repository: GameAssetsRepository): Observable<EndpointResponse<any>> {
        return this.delete(repository.id, null, null, false);
    }
}
