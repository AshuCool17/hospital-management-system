package com.services.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.services.model.Patient;
import com.services.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Transactional
	public Patient addPatient(Patient patient) {
		return patientRepository.save(patient); //Insert the patient record into database using save() present in CrudRepository
	}	 

	/*@Transactional(readOnly = true)
	public Stream<Patient> viewAllPatients() {
		return patientRepository.findAllPatients(); //Retrieve all patients through stream using JPA query 
	}*/
	
	@Transactional(readOnly = true)
	public List<Patient> findAllPatients() {
		List<Patient> patientList = new ArrayList<>();
		patientRepository.findAll().forEach(patient -> patientList.add(patient)); //Retrieve all patients and iterate to insert into a list using findAll() in CrudRepository
		return patientList;
	}
	
	@Transactional(readOnly = true)
	public Patient findPatientById(long patientId) {
		Patient patient = null;
		if(patientRepository.findById(patientId).isPresent()) { //check if the patientId exists in the DB
			patient = patientRepository.findById(patientId).get(); //Retrieve patient by patientId using findById() in CrudRepository
		}
		return patient;
	}

	public void deletePatientById(long patientId) {
		if(patientRepository.findById(patientId).isPresent()) { //check if the patientId exists in the DB
			patientRepository.deleteById(patientId); //Delete the patient record by patientId using deleteById() in CrudRepository
		}
	}
	
}
