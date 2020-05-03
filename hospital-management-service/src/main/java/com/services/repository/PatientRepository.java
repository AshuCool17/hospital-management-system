/**
 * 
 */
package com.services.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.services.model.Patient;

/**
 * @author ashumaha
 *
 */
@Repository
@CrossOrigin
public interface PatientRepository extends CrudRepository<Patient, Long> {

	/*@Query(value = "select * from hospitaldb.patient",nativeQuery = true)
	public Stream<Patient> findAllPatients();*/ //Retrieve all patients from database using JPA query
	
	public Iterable<Patient> findAll(); // Retrieve all patients from database

}