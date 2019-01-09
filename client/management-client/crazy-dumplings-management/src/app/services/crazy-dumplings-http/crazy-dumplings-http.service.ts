import { Injectable } from '@angular/core';
import {HttpParams} from '@angular/common/http';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CrazyDumplingsHttpService {

    private baseUrl: String;
    private http: HttpClient;

  constructor() { }

  public setBaseUrl(val: String) {
    this.baseUrl = val;
  }

  public getBaseUrl(): String {
    return this.baseUrl;
  }


}
