import { Component, OnInit } from '@angular/core';
import { Patient } from 'src/app/hospitalmgnt/patient';

@Component({
  selector: 'app-patients-list',
  templateUrl: './patients-list.component.html',
  styleUrls: ['./patients-list.component.css']
})
export class PatientsListComponent implements OnInit {

  patients : Patient[] = [
    {
      "id": 1,
      "firstName": "Suman",
      "lastName": "Trivedi",
      "age": 34,
      "gender": "Female",
      "mobileNumber": 9876543130,
      "emailId": "sumant@gmail.com",
      "symptoms": "Respiratory problem"
  },
  {
    "id": 2,
    "firstName": "Suman",
    "lastName": "Trivedi",
    "age": 34,
    "gender": "Female",
    "mobileNumber": 9876543130,
    "emailId": "sumant@gmail.com",
    "symptoms": "Respiratory problem"
},
{
  "id": 3,
  "firstName": "Suman",
  "lastName": "Trivedi",
  "age": 34,
  "gender": "Female",
  "mobileNumber": 9876543130,
  "emailId": "sumant@gmail.com",
  "symptoms": "Respiratory problem"
}
  ]
  constructor() { }

  ngOnInit(): void {
  }

}
