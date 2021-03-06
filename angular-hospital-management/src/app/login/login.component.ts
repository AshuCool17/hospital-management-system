import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
    username = 'patient' //temp username
    password = 'patient' //temp password
    invalidLogin = false //boolean field

    constructor(private router: Router,
    private loginservice: AuthenticationService) { }

    ngOnInit() {
    }

    /* authentication */
    checkLogin() {
        console.log("Authenticating the login credentials");
        
        if (this.loginservice.authenticate(this.username, this.password)) {
            
            console.log("Authentic user");
            this.router.navigate(['']) //navigate to the home page if the credentials are authentic
            this.invalidLogin = false //valid user
        } else{
            
            console.log("Unauthenticated user");
            this.invalidLogin = true //invalid user
        }
    }
}