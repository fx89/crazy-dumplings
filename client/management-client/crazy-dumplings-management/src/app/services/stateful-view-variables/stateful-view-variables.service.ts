import { Injectable } from '@angular/core';
import { User } from '../../model/security/user.model';


export enum AppSection {
    NOT_LOGGED_IN = 'Not logged in',
    MAIN_MENU = 'Main menu'
}


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
    * This variable determines which section will be displayed by the content-area component,
    * as well as the title on the main screen and possibly other items.
    */
    public currentSection: AppSection;

    constructor() { this.currentSection = AppSection.NOT_LOGGED_IN; }
}
