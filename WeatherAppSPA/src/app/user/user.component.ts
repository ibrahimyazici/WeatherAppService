import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  headers = ['id', 'username', 'title'];
  users: any = [];
  newUsername;
  newPassword;
  selectedTitle;
  private newUser: { password: any; title: any; username: any };
  constructor(private api: UserService) { }

  ngOnInit() {
    this.getAllUsers();
  }
  getAllUsers() {
    this.api.getAllUsers()
      .subscribe(data => this.users = data);
  }
  deleteUser(index) {
    this.api.deleteUserById(this.users[index].id)
      .subscribe(response => {
        this.getAllUsers();
      });
    this.getAllUsers();
  }

  addUser() {
    this.newUser = {
      username: this.newUsername,
      password: this.newPassword,
      title: this.selectedTitle
    };
    this.api.addUser(this.newUser).subscribe(response => {
      this.getAllUsers();
    });
  }
}
