import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-main-menu-card',
  templateUrl: './main-menu-card.component.html',
  styleUrls: ['./main-menu-card.component.less']
})
export class MainMenuCardComponent implements OnInit {
    @Input() picturePath: string;
    @Input() title: string;

    constructor() { }

    ngOnInit() { }
}
