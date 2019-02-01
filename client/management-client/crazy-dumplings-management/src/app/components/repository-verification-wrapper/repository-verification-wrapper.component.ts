import { Component, OnInit } from '@angular/core';
import { StatefulViewVariablesService, AppSection } from '../../services/stateful-view-variables/stateful-view-variables.service';
import { ImportantMessageIconType } from '../../model/gui/ImportantMessage';

/**
 * The role of this component is to deny access to the inner content unless a repository is selected
 */
@Component({
  selector: 'app-repository-verification-wrapper',
  templateUrl: './repository-verification-wrapper.component.html',
  styleUrls: ['./repository-verification-wrapper.component.less']
})
export class RepositoryVerificationWrapperComponent implements OnInit {

    constructor(private variables: StatefulViewVariablesService) { }

    isRepositorySelected() {
        return this.variables.currentRepository.id > 0;
    }

    private setupRepositoryNotSelectedMessage() {
        this.variables.importantMessage.iconType = ImportantMessageIconType.WARNING;
        this.variables.importantMessage.text = 'This content is not accessible unless a repository is selected';
        this.variables.currentSection = AppSection.IMPORTANT_MESSAGE;
    }

    ngOnInit() {
        if (this.isRepositorySelected() === false) {
            setTimeout(() => { this.setupRepositoryNotSelectedMessage(); }, 100);
        }
    }

}
