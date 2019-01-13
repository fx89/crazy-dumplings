import { Injectable } from '@angular/core';
import { User } from '../../model/security/user.model';


/**
 * Holds the state of the application.
 * For example, it has variables of common interest to two or more components, such as the current user.
 */
@Injectable({
    providedIn: 'root'
})
export class StatefulViewVariablesService {

    public currentUser: User;

    constructor() { }
}
