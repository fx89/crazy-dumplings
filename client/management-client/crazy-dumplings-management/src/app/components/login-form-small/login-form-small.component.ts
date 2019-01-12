import { Component, OnInit } from '@angular/core';
import { CrazyDumplingsHttpService } from '../../services/crazy-dumplings-http/crazy-dumplings-http.service';
import { StatusService } from '../../services/status-service/status.service';
import { User } from '../../model/security/user.model';

@Component({
  selector: 'app-login-form-small',
  templateUrl: './login-form-small.component.html',
  styleUrls: ['./login-form-small.component.less']
})
export class LoginFormSmallComponent implements OnInit {

    waiting: boolean;

    username: string;
    password: string;

    user: User;



    constructor(
        private httpService: CrazyDumplingsHttpService,
        private statusService: StatusService
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
        this.httpService.backendLogout().subscribe(response => { this.getUserDetails(); });
    }

    getUserDetails() {
        this.statusService.getCurrentUserDetails().subscribe(response => { this.user = response; });
        this.waiting = false;
    }

}
