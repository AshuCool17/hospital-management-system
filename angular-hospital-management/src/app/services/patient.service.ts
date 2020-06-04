import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';
import { map, retry, catchError } from 'rxjs/operators';
import { Patient } from '../hospitalmgnt/patient';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  private baseUrl = "http://localhost:8090/findAllPatients?size=100";
  
  constructor(private httpClient : HttpClient) { }

  findAllPatients(): Observable<Patient []>{
    return this.httpClient.get<Patient []>(this.baseUrl)
    .pipe(retry(1))
  }
  
}
