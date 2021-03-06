import { Injectable } from '@angular/core';
import { User } from '../../model/security/user.model';
import { GameAssetsRepository } from '../../model/game-world-registry/GameAssetsRepository';
import { Stack } from '../../reusable/stack';
import { ImportantMessage } from '../../model/gui/ImportantMessage';
import { GameObjectType } from '../../model/game-world-registry/GameObjectType';


export enum AppSection {
    NOT_LOGGED_IN = 'Not logged in',
    MAIN_MENU = 'Main menu',
    REPOSITORIES = 'Repositories',
    REPOSITORIES_EDIT = 'Edit repository',
    IMPORTANT_MESSAGE = 'Important message',
    OBJECT_TYPES = 'Object types',
    OBJECT_TYPES_EDIT = 'Edit object type',
    OBJECT_TYPES_CATEGORY = 'Add object type category'
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

    /**
     * Navigation history for generic back buttons and possibly listing at some point
     */
    private navigationHistory: Stack<AppSection> = new Stack<AppSection>();

    /**
     * All the work will be done in the current repository. A current repository may be selected
     * in the repositories management section.
     */
    public currentRepository: GameAssetsRepository;

    /**
     * Some pages need to revert to the previous repository, for example the repository edit form upon cancelling
     */
    public previousRepository: GameAssetsRepository;

    /**
     * Required for editing game object types, game object type states, game object type properties and so on
     */
    public currentGameObjectType: GameObjectType;

    /**
     * Defins the content of the important message component
     */
    public importantMessage: ImportantMessage = new ImportantMessage();

    /**
     * Signals the main component that the current page is loading
     */
    public isLoading: boolean;


    /**
     * Clears all variables, usually upon logout
     */
    public clear() {
        this.currentUser = undefined;
        this.currentSection = AppSection.NOT_LOGGED_IN;
        this.currentRepository = new GameAssetsRepository('No repository selected');
    }

    public selectRepository(repository: GameAssetsRepository) {
        this.previousRepository = this.currentRepository;
        this.currentRepository = repository;
    }

    public revertRepositorySelection() {
        this.currentRepository = this.previousRepository ? this.previousRepository : this.currentRepository;
    }

    public selectSection(section: AppSection) {
        this.navigationHistory.push(this.currentSection);
        this.currentSection = section;
    }

    public revertSectionSelection() {
        this.currentSection = this.navigationHistory.pop();
    }



    constructor() {
        this.clear();
    }
}
