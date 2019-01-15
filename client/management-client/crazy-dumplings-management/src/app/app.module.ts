import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { MainComponent } from './components/main/main.component';

import { HttpClientModule } from '@angular/common/http';

// PrimeFaces
import {ToolbarModule} from 'primeng/toolbar';
import {ButtonModule} from 'primeng/button';
import {InputTextModule} from 'primeng/inputtext';
import {PasswordModule} from 'primeng/password';
import {ProgressSpinner} from 'primeng/progressspinner';

// Animation
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

// Proprietary
import { LoginFormSmallComponent } from './components/login-form-small/login-form-small.component';
import { InputSelectOnClickDirective } from './directives/input-select-on-click/input-select-on-click.directive';

@NgModule({
  declarations: [
    ProgressSpinner,
    MainComponent,
    LoginFormSmallComponent,
    InputSelectOnClickDirective
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule, // required for [(ngModel)]
    HttpClientModule,
    ToolbarModule,
    ButtonModule,
    PasswordModule,
    InputTextModule
  ],
  providers: [],
  bootstrap: [MainComponent]
})
export class AppModule { }
