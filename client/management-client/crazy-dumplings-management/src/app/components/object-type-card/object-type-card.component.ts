import { Component, OnInit, Input } from '@angular/core';
import { GameObjectType } from '../../model/game-world-registry/GameObjectType';
import { GameObjectTypesService } from '../../services/game-object-types/game-object-types.service';
import { ConfirmationService } from 'primeng/api';
import { StatefulViewVariablesService, AppSection } from '../../services/stateful-view-variables/stateful-view-variables.service';

@Component({
  selector: 'app-object-type-card',
  templateUrl: './object-type-card.component.html',
  styleUrls: ['./object-type-card.component.less']
})
export class ObjectTypeCardComponent implements OnInit {

    @Input() objectType: GameObjectType;

    constructor(
        private confirmationService: ConfirmationService,
        private gameObjectTypesService: GameObjectTypesService,
        private variables: StatefulViewVariablesService
    ) { }

    ngOnInit() {
    }

    edit() {
        this.variables.currentGameObjectType = this.objectType;
        this.variables.selectSection(AppSection.OBJECT_TYPES_EDIT);
    }

    deleteConfirm() {
        this.confirmationService.confirm({
            message: 'Are you sure you want to delete the ' + this.objectType.uniqueName + ' object type?',
            accept: () => { this.delete(); }
        });
    }

    private delete() {
        this.gameObjectTypesService.deleteGameObjectType(this.variables.currentRepository.id, this.objectType).subscribe(response => {
            if (response.status === 'OK') {
                this.variables.importantMessage.text = 'Object type ' + this.objectType.uniqueName + ' was successfully deleted';
                this.variables.selectSection(AppSection.IMPORTANT_MESSAGE);
            }
        });
    }
}
