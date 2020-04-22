/**
 * 
 */
package com.services.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.services.model.Patient;

/**
 * @author ashumaha
 *
 */
public interface PatientRepository extends CrudRepository<Patient, Long> {

	/*
	 * @Query("insert into hospitaldb.patient(patient_id, first_name, last_name, age, gender, mobile_number, email_address, symptoms) values ('1', 'Aman', 'Pandey', '37', 'Male', '9876543120', 'aman@pandey@gmail.com', 'Cough and Cold')"
	 * )
	 * 
	 * @Transactional public Patient addPatient(Patient patient);
	 */
	
	@Query(value = "select * from hospitaldb.patient",nativeQuery = true)
	public Stream<Patient> findAllPatients();

}