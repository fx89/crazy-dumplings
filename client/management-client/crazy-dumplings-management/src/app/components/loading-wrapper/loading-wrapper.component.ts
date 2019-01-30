import { Component, OnInit } from '@angular/core';
import { StatefulViewVariablesService } from '../../services/stateful-view-variables/stateful-view-variables.service';

/**
 * This component displays a loading notification for as long as StatefulViewVariablesService.isLoading is set to TRUE.
 * This is useful in pages displaying content which is being loaded from the back-end. One would need to wrap this
 * component around the content of the page (i.e. <app-loading-wrapper>the page content</app-loading-wrapper>). After
 * that, simply setting the isLoading property of the injected StatefulViewVariablesService will trigger the loading
 * notification.
 */
@Component({
  selector: 'app-loading-wrapper',
  templateUrl: './loading-wrapper.component.html',
  styleUrls: ['./loading-wrapper.component.less']
})
export class LoadingWrapperComponent implements OnInit {

  constructor( protected variables: StatefulViewVariablesService ) { }

  ngOnInit() {
  }

}
