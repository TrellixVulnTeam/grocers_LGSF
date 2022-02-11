import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/model-component/user';
@Injectable({
  providedIn: 'root'
})
export class SigninService {

  constructor(private httpClient: HttpClient) { }
  baseUrl = 'http://localhost:9090'
  //Retrieves user token and checks authentication
  authenticate(username: string, password: string) {
    let url =`${this.baseUrl}/user`;
    return this.httpClient.post<any>(url,{username, password}).subscribe(
      userData => {
        sessionStorage.setItem('user', username);
        let tokenStr = 'Bearer' +userData.token;
        sessionStorage.setItem('token', tokenStr);
        return userData;
      }
    );
  }

  // Checks whether the user is logged in
  isUserLoggedIn():boolean {
    let user = sessionStorage.getItem('username')
    return !(user === null)
  }

  // Removes user session(logout)
  logOut() {
    sessionStorage.removeItem('username');
  }

  // Retrives role of user(customer/admin)
  getRole(username:String) {
    
    return this.httpClient.get('http://localhost:9090/user/fetchUser/'+ username);
  }

  // Adds a new User
  signUp(user: User) {
        return this.httpClient.post('http://localhost:9090/user/store', user);
  }

}

