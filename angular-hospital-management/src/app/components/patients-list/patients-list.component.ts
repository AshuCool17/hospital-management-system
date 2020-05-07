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
  constructor(private patientService : PatientService) { 
  }

  ngOnInit() {
    this.listOfPatients();
  }

  listOfPatients(){
    this.patientService.findAllPatients().subscribe(
      data => this.patients = data
    )
  }
}
