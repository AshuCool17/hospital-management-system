/**
 * 
 */
package com.services.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.services.model.Gender;
import com.services.model.Patient;
import com.services.repository.PatientRepository;

/**
 * @author ashumaha
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class PatientServiceTest {

	@InjectMocks
    private PatientService patientService;
	
	@Mock
	PatientRepository patientRepository;
	
	@Before
	public void initMocks(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAddPatient() {
		
		Patient patient = new Patient();
		patient.setFirstName("Ashutosh");
		patient.setLastName("Mahato");
		patient.setAge(30);
		patient.setEmailId("ashutosh.mahato@gmail.com");
		patient.setGender(Gender.Male);
		patient.setMobileNumber(9590293525L);
		patient.setImageUrl("001.jpg");
		patient.setSymptoms("fever");
		
		patientService.addPatient(patient);
		
		verify(patientRepository, times(1)).save(patient);
		
	}
	
}
