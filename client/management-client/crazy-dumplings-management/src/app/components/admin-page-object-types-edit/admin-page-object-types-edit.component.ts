import { Component, OnInit } from '@angular/core';
import { StatefulViewVariablesService, AppSection } from '../../services/stateful-view-variables/stateful-view-variables.service';
import { GameObjectTypesService } from '../../services/game-object-types/game-object-types.service';
import { GameObjectTypeClass } from '../../model/game-world-registry/GameObjectTypeClass';
import { ImportantMessageIconType } from '../../model/gui/ImportantMessage';
import { GameObjectTypeProperty } from '../../model/game-world-registry/GameObjectTypeProperty';
import { GameObjectTypeState } from '../../model/game-world-registry/GameObjectTypeState';
import { GameObjectTypeStatesService } from '../../services/game-object-type-states/game-object-type-states.service';

@Component({
  selector: 'app-admin-page-object-types-edit',
  templateUrl: './admin-page-object-types-edit.component.html',
  styleUrls: ['./admin-page-object-types-edit.component.less', '../bottom-bar/css/bottom-bar-button.css']
})
export class AdminPageObjectTypesEditComponent implements OnInit {

    protected objectTypeClasses: GameObjectTypeClass[];

    protected properties: GameObjectTypeProperty[];
    protected deletedProperties: GameObjectTypeProperty[] = [];

    protected currentGameObjectTypeClass: GameObjectTypeClass;

    protected propertiesTableCols = [
                           { field: 'propertyName'        , header: 'Property name' },
                           { field: 'propertyDefaultValue', header: 'Default value' },
                           { field: 'propertyMinValue'    , header: 'Minimum value' },
                           { field: 'propertyMaxValue'    , header: 'Maximum value' }
                       ];

    protected states : GameObjectTypeState[];
    protected deletedStates : GameObjectTypeState[] = [];

    protected statesTableCols = [{ field: 'name', header: 'State name' }];



    constructor(
        protected variables: StatefulViewVariablesService,
        private gameObjectTypesService: GameObjectTypesService,
        private gameObjectTypeStatesService: GameObjectTypeStatesService
    ) { }

    ngOnInit() {
        this.gameObjectTypesService.getGameObjectClassesList()
            .subscribe(
                result => {
                        this.objectTypeClasses = result;

                        result.forEach( typeClass => { if (typeClass.id === this.variables.currentGameObjectType.gameObjectTypeClassId) this.currentGameObjectTypeClass = typeClass; } )
                    }
            );

        if (this.variables.currentGameObjectType.id > 0) {
            this.gameObjectTypesService.properties.getGameObjectTypePropertiesList(this.variables.currentRepository.id, this.variables.currentGameObjectType)
                .subscribe(
                    result => { this.properties = result ? result : []; }
                );
        } else {
            this.properties = [];
        }

        this.gameObjectTypeStatesService.getGameObjectTypeStatesList(this.variables.currentRepository.id, this.variables.currentGameObjectType)
            .subscribe(
                    result => { this.states = result ? result : []; }
            );
    }


    addNewProperty() {
        this.properties.push(new GameObjectTypeProperty());
    }

 
    removeExistingProperty(arrayIndex: number) {
        const property: GameObjectTypeProperty = this.properties[arrayIndex];

        if (property.id > 0) {
            this.deletedProperties.push(property);
        }

        this.properties = this.removeElementAtIndex(this.properties, arrayIndex);;
    }


    addNewState() {
        this.states.push(new GameObjectTypeState());
    }


    removeExistingState(arrayIndex: number) {
        const state : GameObjectTypeState = this.states[arrayIndex];

        if (state.id > 0) {
            this.deletedStates.push(state);
        }

        this.states = this.removeElementAtIndex(this.states, arrayIndex);
    }


    private removeElementAtIndex<T>(array: T[], arrayIndex: number) : T[] {
        const newArray : T[] = [];

        let idx = 0; for (let element of array) {
            if (idx !== arrayIndex) {
                newArray.push(element);
            }
        idx++; }

        return newArray;
    }


    save() {
        if (this.currentGameObjectTypeClass && this.currentGameObjectTypeClass.id) {
            this.saveGameObjectType();
        } else {
            this.warnMissingClass();
        }
    }


    private saveGameObjectType() {
        this.variables.isLoading = true;

        this.variables.currentGameObjectType.gameObjectTypeClassId = this.currentGameObjectTypeClass.id;

        this.gameObjectTypesService.saveGameObjectType(
                    this.variables.currentRepository.id,
                    this.variables.currentGameObjectType
                )
                .subscribe( result => {
                    this.variables.currentGameObjectType = result;

                    this.gameObjectTypesService.properties
                            .bulkSaveGameObjectTypeProperties(
                                    this.variables.currentRepository.id,
                                    this.variables.currentGameObjectType.id,
                                    this.properties
                             )
                             .subscribe(() => {
                                 this.gameObjectTypesService.properties
                                     .bulkDeleteGameObjectTypeProperties(
                                             this.variables.currentRepository.id,
                                             this.variables.currentGameObjectType.id,
                                             this.deletedProperties
                                      )
                                      .subscribe(() => {
                                          this.gameObjectTypeStatesService.bulkSaveGameObjectTypeStates(
                                                  this.variables.currentRepository.id,
                                                  this.variables.currentGameObjectType.id,
                                                  this.states
                                          )
                                          .subscribe(() => {
                                              this.gameObjectTypeStatesService.bulkDeleteGameObjectTypeStates(
                                                          this.variables.currentRepository.id,
                                                          this.variables.currentGameObjectType.id,
                                                          this.deletedStates
                                                      )
                                                      .subscribe(() => {
                                                          this.variables.isLoading = false;
                                                          this.variables.selectSection(AppSection.OBJECT_TYPES);
                                                       })
                                               })
                                          })
                                      })
                    });
    }


    private warnMissingClass() {
        this.variables.importantMessage.iconType = ImportantMessageIconType.WARNING;
        this.variables.importantMessage.text = 'You must select a category';
        this.variables.selectSection(AppSection.IMPORTANT_MESSAGE);
    }


    addClass() {
        this.variables.selectSection(AppSection.OBJECT_TYPES_CATEGORY);
    }

}
