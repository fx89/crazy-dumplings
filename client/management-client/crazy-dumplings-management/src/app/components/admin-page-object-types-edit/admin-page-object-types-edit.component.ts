import { Component, OnInit } from '@angular/core';
import { StatefulViewVariablesService, AppSection } from '../../services/stateful-view-variables/stateful-view-variables.service';
import { GameObjectTypesService } from '../../services/game-object-types/game-object-types.service';
import { GameObjectTypeClass } from '../../model/game-world-registry/GameObjectTypeClass';

@Component({
  selector: 'app-admin-page-object-types-edit',
  templateUrl: './admin-page-object-types-edit.component.html',
  styleUrls: ['./admin-page-object-types-edit.component.less', '../bottom-bar/css/bottom-bar-button.css']
})
export class AdminPageObjectTypesEditComponent implements OnInit {

    protected objectTypeClasses: GameObjectTypeClass[];

    constructor(
        protected variables: StatefulViewVariablesService,
        private gameObjectTypesService: GameObjectTypesService
    ) { }

    ngOnInit() {
        this.gameObjectTypesService.getGameObjectClassesList().subscribe(
            result => { this.objectTypeClasses = result; }
        );
    }

    save() {
        this.gameObjectTypesService.saveGameObjectType(
                        this.variables.currentRepository.id,
                        this.variables.currentGameObjectType
            ).subscribe( () => {
                this.variables.selectSection(AppSection.OBJECT_TYPES);
            });
    }

}
