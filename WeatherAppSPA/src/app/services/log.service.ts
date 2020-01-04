import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

const localUrl = 'http://localhost:9090/';

@Injectable()
export class LogService {
  constructor(private http: HttpClient) { }
  jwt = sessionStorage.getItem('token');
  getHttpOptions(token: string) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Authorization': 'Bearer ' + token
      })
    };
    return httpOptions;
  }
  getAllQueryLogs() {
    return this.http.get(localUrl + 'reports/logs', this.getHttpOptions(this.jwt));
  }
  saveQuery(queryLogs) {
    return this.http.post(localUrl + 'reports/logs', queryLogs);
  }
}


