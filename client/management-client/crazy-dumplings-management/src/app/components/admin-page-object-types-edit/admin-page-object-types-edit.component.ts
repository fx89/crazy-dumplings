import { Component, OnInit } from '@angular/core';
import { StatefulViewVariablesService, AppSection } from '../../services/stateful-view-variables/stateful-view-variables.service';
import { GameObjectTypesService } from '../../services/game-object-types/game-object-types.service';
import { GameObjectTypeClass } from '../../model/game-world-registry/GameObjectTypeClass';
import { ImportantMessageIconType } from '../../model/gui/ImportantMessage';
import { GameObjectTypeProperty } from '../../model/game-world-registry/GameObjectTypeProperty';

@Component({
  selector: 'app-admin-page-object-types-edit',
  templateUrl: './admin-page-object-types-edit.component.html',
  styleUrls: ['./admin-page-object-types-edit.component.less', '../bottom-bar/css/bottom-bar-button.css']
})
export class AdminPageObjectTypesEditComponent implements OnInit {

    protected objectTypeClasses: GameObjectTypeClass[];

    protected properties: GameObjectTypeProperty[];
    protected deletedProperties: GameObjectTypeProperty[] = [];

    protected propertiesTableCols = [
                           { field: 'propertyName'        , header: 'Property name' },
                           { field: 'propertyDefaultValue', header: 'Default value' },
                           { field: 'propertyMinValue'    , header: 'Minimum value' },
                           { field: 'propertyMaxValue'    , header: 'Maximum value' }
                       ];

    constructor(
        protected variables: StatefulViewVariablesService,
        private gameObjectTypesService: GameObjectTypesService
    ) { }

    ngOnInit() {
        this.gameObjectTypesService.getGameObjectClassesList()
            .subscribe(
                result => { this.objectTypeClasses = result; }
            );

        if (this.variables.currentGameObjectType.id > 0) {
            this.gameObjectTypesService.properties.getGameObjectTypePropertiesList(this.variables.currentRepository.id, this.variables.currentGameObjectType)
                .subscribe(
                    result => { this.properties = result ? result : []; }
                );
        } else {
            this.properties = [];
        }
    }

    addNewProperty() {
        this.properties.push(new GameObjectTypeProperty());
    }

    removeExistingProperty(arrayIndex: number) {
        const property: GameObjectTypeProperty = this.properties[arrayIndex];

        if (property.id > 0) {
            this.deletedProperties.push(property);
        }

        const newProperties: GameObjectTypeProperty[] = [];

        let idx = 0; for (let property of this.properties) {
            if (idx !== arrayIndex) {
                newProperties.push(property);
            }
        idx++; }

        this.properties = newProperties;
    }

    save() {
        if (this.variables.currentGameObjectType.gameObjectTypeClass) {
            this.saveGameObjectType();
        } else {
            this.warnMissingClass();
        }
    }

    private saveGameObjectType() {
        this.variables.isLoading = true;

        this.gameObjectTypesService.saveGameObjectType(
                    this.variables.currentRepository.id,
                    this.variables.currentGameObjectType
                )
                .subscribe( () => {
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
                                          this.variables.isLoading = false;
                                          this.variables.selectSection(AppSection.OBJECT_TYPES);
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
