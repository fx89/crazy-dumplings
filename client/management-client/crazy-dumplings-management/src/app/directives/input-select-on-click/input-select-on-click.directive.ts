import { Directive, ElementRef, HostListener } from '@angular/core';

@Directive({
  selector: '[appInputSelectOnClick]'
})
export class InputSelectOnClickDirective {

    constructor(private elm: ElementRef) { }

    @HostListener('click') onClick() {
        this.elm.nativeElement.setSelectionRange(0, this.elm.nativeElement.value.length);
    }
}
