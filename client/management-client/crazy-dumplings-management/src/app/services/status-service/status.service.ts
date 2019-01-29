import { Injectable } from '@angular/core';
import { CrazyDumplingsHttpService } from '../../services/crazy-dumplings-http/crazy-dumplings-http.service';
import { Observable } from 'rxjs';
import { User } from '../../model/security/user.model';
import { ResponseUtils } from '../../utils/response-utils';

@Injectable({
  providedIn: 'root'
})
export class StatusService {

    private readonly serviceUrl: string = 'status';
    private readonly openUrl:    string = '/open';
    private readonly secureUrl:  string = '/secure';

    constructor( private httpService: CrazyDumplingsHttpService ) { }

    public getCurrentUserId() {
        return this.getOpenStatus('userid');
    }

    public getCurrentUserDetails(): Observable<User> {
        return this.getSecureStatus('userDetails');
    }

    private getOpenStatus(statusType: string, params?: Map<string, string>): Observable<any> {
        return ResponseUtils.unwrapEndpointResponse(
                    this.httpService.backendGet(this.serviceUrl + this.openUrl + '/' + statusType, params)
                );
    }

    private getSecureStatus(statusType: string, params?: Map<string, string>): Observable<any> {
        return ResponseUtils.unwrapEndpointResponse(
                    this.httpService.backendGet(this.serviceUrl + this.secureUrl + '/' + statusType, params)
                );
    }
}
