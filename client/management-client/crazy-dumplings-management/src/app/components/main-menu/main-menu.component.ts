import { Component, OnInit } from '@angular/core';
import { StatefulViewVariablesService, AppSection } from '../../services/stateful-view-variables/stateful-view-variables.service';

@Component({
  selector: 'app-main-menu',
  templateUrl: './main-menu.component.html',
  styleUrls: ['./main-menu.component.less']
})
export class MainMenuComponent implements OnInit {

    constructor(private variables: StatefulViewVariablesService) { }

    ngOnInit() {
    }

    goToSectionRepositories() { this.variables.currentSection = AppSection.NOT_LOGGED_IN; } // TODO: change
}
