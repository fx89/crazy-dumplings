import { CrazyDumplingsHttpService } from '../services/crazy-dumplings-http/crazy-dumplings-http.service';
import { Observable } from 'rxjs';
import { ResponseUtils } from './response-utils';

export abstract class AbstractBackendRequestService {
    private static possiblyUnwrap(response: Observable<any>, unwrapEndpointResponse: boolean): Observable<any> {
        return unwrapEndpointResponse ? ResponseUtils.unwrapEndpointResponse(response)
                                      : response;
    }

    constructor(
            private http: CrazyDumplingsHttpService,
            private entityEndpointAddress: string
        ) { }

    private createOpParams(params: Map<string, any>, repoId, parentId: number): Map<string, any> {
        if (params == null || params === undefined) {
            params = new Map<string, any>();
        }

        if (repoId) {
            params.set('repo_id', repoId);
        }

        if (parentId) {
            params.set('parent_id', parentId);
        }

        return params;
    }

    protected list(repoId: number, parentId: number, unwrapEndpointResponse?: boolean, params?: Map<string, any>): Observable<any> {
        return this.getRequest('list', this.createOpParams(params, repoId, parentId), unwrapEndpointResponse);
    }

    protected save(repoId: number, parentId: number, assetId: number, entityRequest: any, unwrapEndpointResponse?: boolean): Observable<any> {
        return (
            assetId > 0 ? this.update(repoId, parentId, assetId, entityRequest, unwrapEndpointResponse)
                        : this.add(repoId, parentId, entityRequest, unwrapEndpointResponse)
            );
    }

    private add(repoId: number, parentId: number, entityRequest: any, unwrapEndpointResponse?: boolean): Observable<any> {
        return this.postRequest('add', entityRequest, this.createOpParams(null, repoId, parentId), unwrapEndpointResponse);
    }

    private update(repoId: number, parentId: number, assetId: number, entityRequest: any, unwrapEndpointResponse?: boolean) {
        const params: Map<string, number> = new Map([['asset_id', assetId]]);
        return this.putRequest('update', entityRequest, this.createOpParams(params, repoId, parentId), unwrapEndpointResponse);
    }

    protected delete(repoId: number, parentId: number, assetId: number, unwrapEndpointResponse?: boolean) {
        const params: Map<string, number> = new Map([['asset_id', assetId]]);
        return this.deleteRequest('delete', this.createOpParams(params, repoId, parentId), unwrapEndpointResponse);
    }

    protected getRequest(operation: string, params?: Map<string, any>, unwrapEndpointResponse?: boolean): any {
        return AbstractBackendRequestService.possiblyUnwrap(
                    this.http.backendGet(this.entityEndpointAddress + '/' + operation, params)
                  , unwrapEndpointResponse
                );
    }

    protected postRequest(operation: string, body: any, params?: Map<string, any>, unwrapEndpointResponse?: boolean): any {
        return AbstractBackendRequestService.possiblyUnwrap(
                    this.http.backendPost(this.entityEndpointAddress + '/' + operation, body, params)
                  , unwrapEndpointResponse
                );
    }

    protected putRequest(operation: string, body: any, params?: Map<string, any>, unwrapEndpointResponse?: boolean): any {
        return AbstractBackendRequestService.possiblyUnwrap(
                    this.http.backendPut(this.entityEndpointAddress + '/' + operation, body, params)
                  , unwrapEndpointResponse
                );
    }

    protected deleteRequest(operation: string, params?: Map<string, any>, unwrapEndpointResponse?: boolean): any {
        return AbstractBackendRequestService.possiblyUnwrap(
                    this.http.backendDeleteExt(this.entityEndpointAddress + '/' + operation, params)
                  , unwrapEndpointResponse
                );
    }

}
