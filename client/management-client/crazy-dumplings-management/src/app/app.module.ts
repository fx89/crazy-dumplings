import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { MainComponent } from './components/main/main.component';

// PrimeFaces
import {ToolbarModule} from 'primeng/toolbar';
import {ButtonModule} from 'primeng/button';

@NgModule({
  declarations: [
    MainComponent
  ],
  imports: [
    BrowserModule,
    ToolbarModule,
    ButtonModule
  ],
  providers: [],
  bootstrap: [MainComponent]
})
export class AppModule { }
