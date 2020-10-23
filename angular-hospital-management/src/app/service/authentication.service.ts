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
      console.log('Valid user');
      sessionStorage.setItem('username', username) // add username to session
      console.log('username ' +username);
      console.log('returning true');
      return true; //valid user

    } else {

      console.log('Invalid user');
      console.log('returning false');
      return false; //invalid user
      
    }
  }

  /* check on the user activity */
  isUserLoggedIn() {
    let user = sessionStorage.getItem('username') //retrieve user from the session
    console.log("Invalidating the user")
    return !(user === null) //return true if user present in the session otherwise false

  }

  /* logout */
  logOut() {

    console.log("Removing username during logout")
    sessionStorage.removeItem('username') //clear user from session
    
  }
}