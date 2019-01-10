import { Component, OnInit } from '@angular/core';

import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

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

  constructor(private httpClient: HttpClient) { }

  ngOnInit() {
    this.getUserId();
  }

  login() {
      const params = new HttpParams()
            .set('username', this.username)
            .set('password', this.password);

      this.httpClient.post(
            'http://127.0.0.1:8093/login',
            params,
            {
                headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded'),
                responseType: 'text',
                withCredentials: true
            }
      )
      .subscribe(response => {
                this.getUserId();
            });
  }

  logout() {
      this.httpClient.post('http://127.0.0.1:8093/logout', null,
      {
            responseType: 'text',
            withCredentials: true
      }
      )
      .subscribe(response => {
                this.getUserId();
            });
  }

  getUserId() {
    this.httpClient.get<Number>('http://127.0.0.1:8093/status/open/userid', { withCredentials: true })
    .subscribe(response => {
        this.userId = response;
    }) ;
  }

}
