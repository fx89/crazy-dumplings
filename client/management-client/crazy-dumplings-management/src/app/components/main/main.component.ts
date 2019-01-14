import { Component } from '@angular/core';

import {
  trigger,
  state,
  style,
  animate,
  transition,
} from '@angular/animations';


import { StatefulViewVariablesService } from '../../services/stateful-view-variables/stateful-view-variables.service';


@Component({
  selector: 'app-root',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.less'],

  animations: [
    trigger('openClose', [
      // ...
      state('open', style({
        opacity: '0'
      })),
      state('closed', style({
        opacity: '1'
      })),
      transition('open => closed', [
        animate('1s')
      ]),
      transition('closed => open', [
        animate('0.5s')
      ]),
    ]),
  ]
})
export class MainComponent {
  title = 'Crazy Dumplings Management';

  constructor(protected variables: StatefulViewVariablesService) {}
}
