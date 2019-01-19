import { Component, OnInit, Input } from '@angular/core';

import { StatefulViewVariablesService, AppSection } from '../../services/stateful-view-variables/stateful-view-variables.service';

@Component({
  selector: 'app-bottom-bar',
  templateUrl: './bottom-bar.component.html',
  styleUrls: ['./bottom-bar.component.less']
})
export class BottomBarComponent implements OnInit {

    constructor(protected variables: StatefulViewVariablesService) { }

    ngOnInit() {
    }

    goBack() {
        this.variables.revertSectionSelection();
    }
}
