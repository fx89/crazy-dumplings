import { Component, OnInit } from '@angular/core';
import { StatefulViewVariablesService } from '../../services/stateful-view-variables/stateful-view-variables.service';

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

  }
}