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

// Proprietary
import { LoginFormSmallComponent } from './components/login-form-small/login-form-small.component';

@NgModule({
  declarations: [
    ProgressSpinner,
    MainComponent,
    LoginFormSmallComponent
  ],
  imports: [
    BrowserModule,
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
