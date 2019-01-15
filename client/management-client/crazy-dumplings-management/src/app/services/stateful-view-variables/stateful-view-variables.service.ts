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

    /**
     * The currently logged in user
     */
    public currentUser: User;

    /**
     * This title is modified by various buttons and icons when clicked to move to new sections of the application
     */
    public currentSectionTitle: string;

    constructor() { this.currentSectionTitle = 'Not logged in'; }
}
