import { Observable } from 'rxjs';
import { EndpointResponse } from '../model/game-world-registry/EndpointResponse';
import { map } from 'rxjs/operators';


/**
 * Contains common operations to be applied on the response of the back-end API
 */
export abstract class ResponseUtils {

    /**
     * Extracts the payload from the endpoint response
     */
    static unwrapEndpointResponse(observableResponse: Observable<EndpointResponse<any>>): Observable<any> {
        return observableResponse.pipe(map(
                            (response: EndpointResponse<any>) => {
                                return response.status === 'OK' ? response.payload : undefined;
                            }
                        ));
    }
}
