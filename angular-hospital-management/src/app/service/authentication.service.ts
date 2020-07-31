import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor() { }

  /* authenticating patient credentials */
  authenticate(username, password) {
    if (username === "patient" && password === "patient") {
      sessionStorage.setItem('username', username)
      return true;
    } else {
      return false;
    }
  }

  /* check on the user activity */
  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    console.log(!(user === null))
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('username')
  }
}