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
import {ScrollPanelModule} from 'primeng/scrollpanel';
import {TooltipModule} from 'primeng/tooltip';

// Animation
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

// Proprietary
import { LoginFormSmallComponent } from './components/login-form-small/login-form-small.component';
import { InputSelectOnClickDirective } from './directives/input-select-on-click/input-select-on-click.directive';
import { ContentAreaComponent } from './components/content-area/content-area.component';
import { MainMenuComponent } from './components/main-menu/main-menu.component';
import { MainMenuCardComponent } from './components/main-menu-card/main-menu-card.component';
import { AdminPageRepositoriesComponent } from './components/admin-page-repositories/admin-page-repositories.component';
import { RepositoryCardComponent } from './components/repository-card/repository-card.component';

@NgModule({
  declarations: [
    ProgressSpinner,
    MainComponent,
    LoginFormSmallComponent,
    InputSelectOnClickDirective,
    ContentAreaComponent,
    MainMenuComponent,
    MainMenuCardComponent,
    AdminPageRepositoriesComponent,
    RepositoryCardComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule, // required for [(ngModel)]
    HttpClientModule,
    ToolbarModule,
    ButtonModule,
    PasswordModule,
    InputTextModule,
    ScrollPanelModule,
    TooltipModule
  ],
  providers: [],
  bootstrap: [MainComponent]
})
export class AppModule { }
