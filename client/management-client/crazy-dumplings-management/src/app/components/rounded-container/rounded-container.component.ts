import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-rounded-container',
  templateUrl: './rounded-container.component.html',
  styleUrls: ['./rounded-container.component.less']
})
export class RoundedContainerComponent implements OnInit {
    @Input() borderRadiusPX = 11;
    @Input() backgroundColorSTR = '#000';
    @Input() opacityDBL = .7;
    @Input() marginTopPX = 10;
    @Input() paddingPX = 15;
    @Input() widthPX = 400;
    @Input() heightPX = 200;
    @Input() hasShadow = false;

    constructor() { }

    ngOnInit() {
    }

    protected computePaddingTopPX(): number {
        return this.paddingPX * 2 / 3;
    }

}
