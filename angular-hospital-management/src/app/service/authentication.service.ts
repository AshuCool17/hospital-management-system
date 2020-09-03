import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor() { }

  /* authenticating patient credentials */
  authenticate(username, password) {
    console.log("Authenticating patient credentials")
    if (username === "patient" && password === "patient") {
      //valid user, set the username into the session
      sessionStorage.setItem('username', username)
      console.log('username ' +username);
      return true; //valid user
    } else {
      return false; //invalid user
    }
  }

  /* check on the user activity */
  isUserLoggedIn() {
    let user = sessionStorage.getItem('username') //retrieve user from the session
    console.log(!(user === null))
    console.log("Invalidating the user")
    return !(user === null) //return true if user present in the session otherwise false
  }

  /* logout */
  logOut() {
    console.log("Removing username during logout")
    sessionStorage.removeItem('username') //clear user from session
  }
}