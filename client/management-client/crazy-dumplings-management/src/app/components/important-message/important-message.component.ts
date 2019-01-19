import { Component, OnInit } from '@angular/core';
import { StatefulViewVariablesService } from '../../services/stateful-view-variables/stateful-view-variables.service';

@Component({
  selector: 'app-important-message',
  templateUrl: './important-message.component.html',
  styleUrls: ['./important-message.component.less']
})
export class ImportantMessageComponent implements OnInit {

    constructor( protected variables: StatefulViewVariablesService ) { }

    ngOnInit() {
    }

    okClick() {
        this.variables.revertSectionSelection();
    }
}
