import { Component, OnInit } from '@angular/core';
import { GameObjectTypesService } from '../../services/game-object-types/game-object-types.service';
import { StatefulViewVariablesService, AppSection } from '../../services/stateful-view-variables/stateful-view-variables.service';

@Component({
  selector: 'app-admin-page-object-types-category',
  templateUrl: './admin-page-object-types-category.component.html',
  styleUrls: ['./admin-page-object-types-category.component.less']
})
export class AdminPageObjectTypesCategoryComponent implements OnInit {

    protected objectTypeClassName: string;

    constructor(
        private objectTypesService: GameObjectTypesService,
        private variables: StatefulViewVariablesService
    ) { }

    ngOnInit() {
        this.objectTypeClassName = 'New object class';
    }

    protected save() {
        this.objectTypesService.addGameObjectClass(this.objectTypeClassName)
                .subscribe( () => {
                    this.variables.selectSection(AppSection.OBJECT_TYPES_EDIT);
                });
    }

}
