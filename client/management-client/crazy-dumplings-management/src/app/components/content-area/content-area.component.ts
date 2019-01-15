import { Component, OnInit } from '@angular/core';
import { StatefulViewVariablesService } from '../../services/stateful-view-variables/stateful-view-variables.service';
import { AppSection } from '../../services/stateful-view-variables/stateful-view-variables.service';



@Component({
  selector: 'app-content-area',
  templateUrl: './content-area.component.html',
  styleUrls: ['./content-area.component.less']
})
export class ContentAreaComponent implements OnInit {

  constructor(protected variables: StatefulViewVariablesService) { }

  protected appSectionMainMenu: AppSection = AppSection.MAIN_MENU;

  ngOnInit() {
  }

}
