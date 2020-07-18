import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';
import { map, retry, catchError } from 'rxjs/operators';
import { Patient } from '../hospitalmgnt/patient';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  private baseUrl = "http://localhost:8090";
  
  constructor(private httpClient : HttpClient) { }
  
  addPatient(patient: object): Observable<object> {  
    return this.httpClient.post(`${this.baseUrl}`+'/addPatient/', patient)
    .pipe(retry(1));  
  }  

  /*delete patient by id API*/
  deletePatientById(patientId: number): Observable<object> {  
    return this.httpClient.delete(`${this.baseUrl}`+'/deletePatientById/'+`${patientId}`)
    .pipe(retry(1));  
  } 

  /*find patient by id API*/
  findPatientById(patientId: number): Observable<object> {  
    return this.httpClient.get(`${this.baseUrl}`+'/findPatientById/'+`${patientId}`)
    .pipe(retry(1));  
  }

  /*find all patients API*/
  findAllPatients(): Observable<Patient []>{
    //return this.httpClient.get<Patient []>(this.baseUrl)
    return this.httpClient.get<Patient []>(`${this.baseUrl}`+'/findAllPatients?size=100')
    .pipe(retry(1));
  }
  
}
