import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-repository-card',
  templateUrl: './repository-card.component.html',
  styleUrls: ['./repository-card.component.less']
})
export class RepositoryCardComponent implements OnInit {

    @Input() name: string;

    @Input() description: string;

    constructor() { }

    ngOnInit() { }

}
