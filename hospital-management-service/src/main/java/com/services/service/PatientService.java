package com.services.service;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.model.Patient;
import com.services.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	/*
	 * public Patient addPatient(Patient patient) { return
	 * patientRepository.addPatient(patient); }
	 */

	public Stream<Patient> viewAllPatients() {
		return patientRepository.findAllPatients();
	}
	
}
