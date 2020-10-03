import { Component, OnInit } from '@angular/core';
import { PatientService } from 'src/app/services/patient.service';
import { Patient } from 'src/app/hospitalmgnt/patient';

@Component({
  selector: 'app-patients-list',
  templateUrl: './patients-grid-list.component.html',
  styleUrls: ['./patients-list.component.css']
})
export class PatientsListComponent implements OnInit {

  patients : Patient[];
  patient : Patient;
  constructor(private patientService : PatientService) { 
  }

  ngOnInit() {
    
    this.listOfPatients();
  }

  /*find all patients*/
  listOfPatients() {
    
    this.patientService.findAllPatients().subscribe(
      data => this.patients = data
    )
  }

  /* add patient */
  addPatients() {
    this.patientService.addorUpdatePatient(
      data => this.patient = data
    )
  }

  /*find patient by id*/
  findPatient(id) {
    this.patientService.findPatientById(id).subscribe(
    )
  }

  /* delete patient by id */
  deletePatientById(id) {
    this.patientService.deletePatientById(id).subscribe(      
    )
  }
}
