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
        return this.unwrapEndpointResponse(this.httpService.backendGet('repositories/list', null));
    }

    public saveRepository(repository: GameAssetsRepository): Observable<GameAssetsRepository> {
        return this.unwrapEndpointResponse(repository.id > 0 ? this.updateRepository(repository) : this.addRepository(repository));
    }

    private updateRepository(repository: GameAssetsRepository): Observable<EndpointResponse<GameAssetsRepository>> {
        return this.httpService.backendPut('repositories/update', repository, new Map([['repo_id', repository.id]]))
            .pipe(map(
                (response: EndpointResponse<any>) => { response.payload = repository; return response; }
            ));
    }

    private addRepository(repository: GameAssetsRepository): Observable<EndpointResponse<GameAssetsRepository>> {
        return this.httpService.backendPost('repositories/add', repository);
    }

    public deleteRepository(repository: GameAssetsRepository): Observable<EndpointResponse<any>> {
        return this.httpService.backendDelete('repositories/delete', 'repo_id', repository.id);
    }



    private unwrapEndpointResponse = (input: Observable<EndpointResponse<any>>) => {
        return input.pipe(map(
                            (response: EndpointResponse<any>) => {
                                return response.status === 'OK' ? response.payload : null;
                            }
                        ));
    }
}
