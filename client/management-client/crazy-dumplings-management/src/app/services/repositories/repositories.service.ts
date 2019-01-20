import { Injectable } from '@angular/core';
import { CrazyDumplingsHttpService } from '../../services/crazy-dumplings-http/crazy-dumplings-http.service';
import { Observable } from 'rxjs';
import { EndpointResponse } from '../../model/game-world-registry/EndpointResponse';
import { GameAssetsRepository } from '../../model/game-world-registry/GameAssetsRepository';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RepositoriesService {

    constructor( private httpService: CrazyDumplingsHttpService ) { }

    public getRepositoriesList(): Observable<GameAssetsRepository[]> {
        return this.httpService.backendGet('repositories/list', null)
                    .pipe(
                        map(
                            (response: EndpointResponse<GameAssetsRepository[]>) => {
                                return response.status === 'OK' ? response.payload : null;
                            }
                        )
                    );
    }

    public saveRepository(repository: GameAssetsRepository): Observable<GameAssetsRepository> {
        return (repository.id > 0 ? this.updateRepository(repository) : this.createRepository(repository))
                    .pipe(
                        map(
                            (response: EndpointResponse<GameAssetsRepository>) => {
                                return response.status === 'OK' ? response.payload : null;
                            }
                        )
                    );
    }

    private updateRepository(repository: GameAssetsRepository): Observable<EndpointResponse<GameAssetsRepository>> {
        return null;
    }

    private createRepository(repository: GameAssetsRepository): Observable<EndpointResponse<GameAssetsRepository>> {
        return this.httpService.backendPost('repositories/add', repository);
    }

    public deleteRepository(repository: GameAssetsRepository): Observable<EndpointResponse<any>> {
        return this.httpService.backendDelete('repositories/delete', 'repo_id', repository.id);
    }
}
