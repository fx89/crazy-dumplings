import { Component, OnInit } from '@angular/core';

import { HttpClient } from '@angular/common/http';

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
      console.log("a = " + this.username);

      // Build form data
      const formData: FormData = new FormData();
      formData.append('username', this.username);
      formData.append('password', this.password);
      formData.append('submit', 'Login');

      // Post form data
      this.httpClient.post('http://127.0.0.1:8093/login', formData)
            .subscribe(response => {
                this.getUserId();
            });
  }

  getUserId() {
    this.httpClient.get<Number>('http://127.0.0.1:8093/status/open/userid', )
    .subscribe(response => {
        this.userId = response;
    }) ;
  }

}
