import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const localUrl = 'http://localhost:9090/';
@Injectable()
export class UserService {

  constructor(private http: HttpClient) { }
  getAllUsers() {
    return this.http.get(localUrl + 'users');
  }
  deleteUserById(id) {
    return this.http.delete(localUrl + 'user/' + id);
  }
  editUserById(user) {
    return this.http.put(localUrl + 'user/', user);
  }
  addUser(user) {
    return this.http.post(localUrl + 'user', user);
  }
}
