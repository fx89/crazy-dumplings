import { Component, OnInit } from '@angular/core';
import { StatefulViewVariablesService } from '../../services/stateful-view-variables/stateful-view-variables.service';
import { AppSection } from '../../services/stateful-view-variables/stateful-view-variables.service';

import {
  trigger,
  state,
  style,
  animate,
  transition,
} from '@angular/animations';



@Component({
  selector: 'app-content-area',
  templateUrl: './content-area.component.html',
  styleUrls: ['./content-area.component.less'],

  animations: [
    trigger('slideInAndOut', [
      // ...
      state('slideIn', style({
        opacity: '1',
        transform: 'translateX(0%)'
      })),
      state('slideOut', style({
        opacity: '0',
        transform: 'translateX(-100%)'
      })),
      transition('slideIn => slideOut', [
        animate('1s')
      ]),
      transition('slideOut => slideIn', [
        animate('0.5s')
      ]),
    ]),
  ]
})
export class ContentAreaComponent implements OnInit {

  constructor(protected variables: StatefulViewVariablesService) { }

  protected appSectionMainMenu: AppSection = AppSection.MAIN_MENU;

  ngOnInit() {
  }

}
