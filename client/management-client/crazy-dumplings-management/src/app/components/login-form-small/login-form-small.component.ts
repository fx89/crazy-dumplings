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

    username: string;
    password: string;
    user: User;



    constructor(
        private httpService: CrazyDumplingsHttpService,
        private statusService: StatusService
    ) { }



    ngOnInit() {
        this.getUserDetails();
    }

    login() {
        this.httpService.backendLogin(this.username, this.password).subscribe(response => { this.getUserDetails(); });
    }

    logout() {
        this.httpService.backendLogout().subscribe(response => { this.getUserDetails(); });
    }

    getUserDetails() {
        this.statusService.getCurrentUserDetails().subscribe(response => { this.user = response; });
    }

}
