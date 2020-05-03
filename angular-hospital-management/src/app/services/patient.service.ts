import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Patient } from '../hospitalmgnt/patient';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  private baseUrl = "http://localhost:8090/findAllPatients";
  
  constructor(private httpClient : HttpClient) { }

  findAllPatients(): Observable<Patient[]>{

    return this.httpClient.get<GetResponsePatients> (this.baseUrl).pipe(
      map(response => response.patients)
    );
  }
}

interface GetResponsePatients{
   patients : Patient[];
}
