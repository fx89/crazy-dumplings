import { Component, OnInit } from '@angular/core';
import { StatefulViewVariablesService, AppSection } from '../../services/stateful-view-variables/stateful-view-variables.service';
import { GameObjectType } from '../../model/game-world-registry/GameObjectType';

@Component({
  selector: 'app-admin-page-object-types',
  templateUrl: './admin-page-object-types.component.html',
  styleUrls: ['./admin-page-object-types.component.less', '../bottom-bar/css/bottom-bar-button.css']
})
export class AdminPageObjectTypesComponent implements OnInit {

      constructor(
      protected variables: StatefulViewVariablesService
      ) { }

      ngOnInit() {
      }

      newObjectType() {
          this.variables.currentGameObjectType = new GameObjectType();
          this.variables.selectSection(AppSection.OBJECT_TYPES_EDIT);
      }
}
