import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

// PrimeFaces
import {ToolbarModule} from 'primeng/toolbar';
import {ButtonModule} from 'primeng/button';
import {InputTextModule} from 'primeng/inputtext';
import {InputTextareaModule} from 'primeng/inputtextarea';
import {PasswordModule} from 'primeng/password';
import {ProgressSpinner} from 'primeng/progressspinner';
import {ScrollPanelModule} from 'primeng/scrollpanel';
import {TooltipModule} from 'primeng/tooltip';
import {ConfirmDialogModule} from 'primeng/confirmdialog';
import {ConfirmationService} from 'primeng/api';
import {MessagesModule} from 'primeng/messages';
import {MessageService} from 'primeng/api';
import {DropdownModule} from 'primeng/dropdown';

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
import { MainComponent } from './components/main/main.component';
import { BottomBarComponent } from './components/bottom-bar/bottom-bar.component';
import { AdminPageRepositoriesEditComponent } from './components/admin-page-repositories-edit/admin-page-repositories-edit.component';
import { ImportantMessageComponent } from './components/important-message/important-message.component';
import { LoadingWrapperComponent } from './components/loading-wrapper/loading-wrapper.component';
import { AdminPageObjectTypesComponent } from './components/admin-page-object-types/admin-page-object-types.component';
import { RepositoryVerificationWrapperComponent } from './components/repository-verification-wrapper/repository-verification-wrapper.component';
import { AdminPageObjectTypesEditComponent } from './components/admin-page-object-types-edit/admin-page-object-types-edit.component';
import { ObjectTypeCardComponent } from './components/object-type-card/object-type-card.component';
import {ToggleButtonModule} from 'primeng/togglebutton';

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
    RepositoryCardComponent,
    BottomBarComponent,
    AdminPageRepositoriesEditComponent,
    ImportantMessageComponent,
    LoadingWrapperComponent,
    AdminPageObjectTypesComponent,
    RepositoryVerificationWrapperComponent,
    AdminPageObjectTypesEditComponent,
    ObjectTypeCardComponent
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
    InputTextareaModule,
    ScrollPanelModule,
    TooltipModule,
    ConfirmDialogModule,
    MessagesModule,
    DropdownModule,
    ToggleButtonModule
  ],
  providers: [ConfirmationService, MessageService],
  bootstrap: [MainComponent]
})
export class AppModule { }
