import { Injectable } from '@angular/core';
import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate{

  constructor(private router: Router,
    private authService: AuthenticationService) {

    }
    /* user authentication */
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {    

    console.log('Entered canActivate method');
    if (this.authService.isUserLoggedIn()){ //if logged-in user
      console.log('Authenticated user');
      this.router.navigate(['login']); //navigating to login page
      console.log('Navigate to login page');     
      return true; //if authenticated user, return true 
    } else {
      console.log('Unathenticated user');
      return false; //if unauthenticated user, return false
    }
  }
}
