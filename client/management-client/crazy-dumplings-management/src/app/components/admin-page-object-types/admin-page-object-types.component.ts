import { Component, OnInit } from '@angular/core';
import { StatefulViewVariablesService, AppSection } from '../../services/stateful-view-variables/stateful-view-variables.service';
import { GameObjectType } from '../../model/game-world-registry/GameObjectType';
import { GameObjectTypesService } from '../../services/game-object-types/game-object-types.service';
import { GameObjectTypeClass } from '../../model/game-world-registry/GameObjectTypeClass';

@Component({
  selector: 'app-admin-page-object-types',
  templateUrl: './admin-page-object-types.component.html',
  styleUrls: ['./admin-page-object-types.component.less', '../bottom-bar/css/bottom-bar-button.css']
})
export class AdminPageObjectTypesComponent implements OnInit {

    protected objectTypes: GameObjectType[];

    constructor(
        protected variables: StatefulViewVariablesService,
        protected gameObjectTypesService: GameObjectTypesService
    ) { }

    ngOnInit() {
        this.variables.isLoading = true;
        this.gameObjectTypesService.getGameObjectTypesList(this.variables.currentRepository.id)
                .subscribe(response => {
                    this.objectTypes = response;
                    this.variables.isLoading = false;
                });
    }

    newObjectType() {
        this.gameObjectTypesService.getGameObjectClassesList()
                .subscribe( (result: GameObjectTypeClass[]) => {
                    this.variables.currentGameObjectType = new GameObjectType();
                    this.variables.currentGameObjectType.gameObjectTypeClassId = result ? result[0].id : null;
                    this.variables.selectSection(AppSection.OBJECT_TYPES_EDIT);
                });
    }
}
