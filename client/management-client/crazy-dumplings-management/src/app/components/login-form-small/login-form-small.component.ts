import { Component, OnInit } from '@angular/core';
import { CrazyDumplingsHttpService } from '../../services/crazy-dumplings-http/crazy-dumplings-http.service';
import { StatusService } from '../../services/status-service/status.service';

@Component({
  selector: 'app-login-form-small',
  templateUrl: './login-form-small.component.html',
  styleUrls: ['./login-form-small.component.less']
})
export class LoginFormSmallComponent implements OnInit {

  userId: Number;
  username: string;
  password: string;

  setUsername(username: string) {
      this.username = username;
  }

  getUsername(): string {
      return this.username;
  }

  constructor(
      private httpService: CrazyDumplingsHttpService,
      private statusService: StatusService
  ) { }

  ngOnInit() {
    this.getUserId();
  }

  login() {
      this.httpService.backendLogin(this.username, this.password).subscribe(response => { this.getUserId(); });
  }

  logout() {
      this.httpService.backendLogout().subscribe(response => { this.getUserId(); });
  }

  getUserId() {
      this.statusService.getCurrentUserId().subscribe(response => { this.userId = response; });
  }

}
