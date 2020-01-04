import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

export class User {
  constructor(
    public status: string,
  ) {}

}

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(
    private httpClient: HttpClient
  ) {
  }

  authenticate(username, password) {
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    const info = {username: username, password: password};
    sessionStorage.setItem('username', '');
    sessionStorage.setItem('token', '');
    return this.httpClient.post('http://localhost:9090/authentication', info).pipe(
      map(
        userData => {
          sessionStorage.setItem('username', username);
          // @ts-ignore
          sessionStorage.setItem('token', userData.jwt);
          return userData;
        }
      )

    );
  }


  isUserLoggedIn() {
    const user = sessionStorage.getItem('username');
    console.log(!(user === null));
    return !(user === null);
  }

  logOut() {
    sessionStorage.setItem('username', '');
    sessionStorage.setItem('token', '');
  }
}
