import { Injectable } from '@angular/core';
import { HttpClientWrapperService, RequestType, ResponseType } from '../http-client-wrapper/http-client-wrapper.service';
import {environment} from '../../../environments/environment';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { EndpointResponse } from '../../model/game-world-registry/EndpointResponse';
import {MessageService} from 'primeng/api';



/**
 * Exposes specialized application-specific functionality for querying the back-end API using as little lines of code as possible
 * Pushes any error messages fro
 */
@Injectable({
    providedIn: 'root'
})
export class CrazyDumplingsHttpService {

    constructor(
        private httpClientWrapper: HttpClientWrapperService,
        private messaegService: MessageService
    ) {
        this.httpClientWrapper.setBaseUrl(environment.backEndURL);
    }

    /**
     * Emulates the behavior of the standard login form generated by Spring Security
     */
    public backendLogin(username: string, password: string): Observable<any> {
        return this.request(
                            RequestType.POST, 'login',
                            null,
                            new Map([
                                    ['username', username],
                                    ['password', password]
                                ]),
                            new Map([
                                    ['Content-Type', 'application/x-www-form-urlencoded']
                                ]),
                            ResponseType.TEXT
                        );
    }

    /**
     * Submits a logout request to Spring Security
     */
    public backendLogout(): Observable<any> {
        return this.request(RequestType.POST, 'logout', null, null, null, ResponseType.TEXT);
    }

    /**
     * Query the back end API for specific information
     */
    public backendGet(path: string, params?: Map<string, string>): Observable<any> {
        return this.request(RequestType.GET, path, null, params);
    }

    /**
     * Update an entity via the back end API
     */
    public backendPost(path: string, body: any, params?: Map<string, string>): Observable<any> {
        return this.request(RequestType.POST, path, body, params);
    }

    /**
     * Add an entity to the back end using the API
     */
    public backendPut(path: string, body: any, params?: Map<string, any>): Observable<any> {
        return this.request(RequestType.PUT, path, body, params);
    }

    /**
     * Remove an entity from the back end using the API
     */
    public backendDelete(path: string, paramName: string, paramValue: any): Observable<any> {
        return this.request(RequestType.DELETE, path, null, new Map([[paramName, paramValue]]));
    }

    /**
     * Wraps around the request() method of the HttpClientWrapper and forwards any errors coming from the
     * back end to the PrimeNG messages service
     */
    private request(
        requestType: RequestType,
        url: string,
        body: any,
        params?: Map<string, string>,
        headers?: Map<string, string>,
        responseType?: ResponseType
    ): Observable<EndpointResponse<any>> {
            return this.httpClientWrapper.request(requestType, url, body, params, headers, responseType)
                    .pipe(
                        map(
                            ( (response: EndpointResponse<any>) => {
                                    if (response.status === 'OK') {
                                        return response;
                                    } else {
                                     /*   this.messaegService.add(
                                            {
                                                severity: 'error',
                                                summary: 'Operation failed',
                                                detail: <string>(response.payload)
                                            }
                                        );
*/
                                        return undefined;
                                    }
                            } )
                        )
                    );
    }
}
