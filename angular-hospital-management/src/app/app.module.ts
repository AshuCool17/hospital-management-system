import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { Routes, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { PatientsListComponent } from './components/patients-list/patients-list.component';
import { PatientService } from './services/patient.service';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';

const routes: Routes = [
  { path: '', component: PatientsListComponent },
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent }

];

@NgModule({
  declarations: [
    AppComponent,
    PatientsListComponent,
    LoginComponent,
    LogoutComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    FormsModule
  ],
  providers: [
    PatientService
  ],
  bootstrap: [AppComponent
  ],
  exports: [RouterModule]
})
export class AppModule { }
