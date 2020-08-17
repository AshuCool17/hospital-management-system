import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
    username = 'patient'
    password = 'patient'
    invalidLogin = false 

    constructor(private router: Router,
    private loginservice: AuthenticationService) { }

    ngOnInit() {
    }

    /* authentication */
    checkLogin() {
        console.log("Authenticating the login credentials");
        if (this.loginservice.authenticate(this.username, this.password)) {
            console.log("Authentic user");
            this.router.navigate([''])
            this.invalidLogin = false //valid user
        } 
        else{
            console.log("Unauthenticated user");
            this.invalidLogin = true //invalid user
        }
    }
}