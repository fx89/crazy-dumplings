import { Component, OnInit } from '@angular/core';
import { CrazyDumplingsHttpService } from '../../services/crazy-dumplings-http/crazy-dumplings-http.service';
import { StatusService } from '../../services/status-service/status.service';
import { StatefulViewVariablesService, AppSection } from '../../services/stateful-view-variables/stateful-view-variables.service';

@Component({
  selector: 'app-login-form-small',
  templateUrl: './login-form-small.component.html',
  styleUrls: ['./login-form-small.component.less']
})
export class LoginFormSmallComponent implements OnInit {

    waiting: boolean;

    username: string;
    password: string;



    constructor(
        private httpService: CrazyDumplingsHttpService,
        private statusService: StatusService,
        protected variables: StatefulViewVariablesService
    ) { }

    ngOnInit() {
        this.waiting = true;
        this.getUserDetails();
        this.username = 'username';
        this.password = 'password';
    }



    login() {
        this.waiting = true;
        this.httpService.backendLogin(this.username, this.password).subscribe(response => { this.getUserDetails(); });
    }

    logout() {
        this.waiting = true;
        this.httpService.backendLogout().subscribe(response => { this.getUserDetails(); this.variables.clear(); });
    }

    private getUserDetails() {
        this.statusService.getCurrentUserDetails().subscribe(response => {
                                                        this.variables.currentUser = response;
                                                        this.selectSection();
                                                    });

        this.waiting = false;
    }

    private selectSection() {
        this.variables.selectSection(this.variables.currentUser ? AppSection.MAIN_MENU : AppSection.NOT_LOGGED_IN);
    }
}
