import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor() { }

  /* authenticating patient credentials */
  authenticate(username, password) {
    console.log("Authencating patient credentials")
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

  /* logout */
  logOut() {
    console.log("Removing username during logout")
    sessionStorage.removeItem('username')
  }
}