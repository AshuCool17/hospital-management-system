/**
 * 
 */
package com.services.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
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
	@Spy
    private PatientService patientService;
	
	@Mock
	PatientRepository patientRepository;
	
	@Before
	public void initMocks(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAddPatient() {
		
		Patient patient = preparePatientData();
		patientService.addPatient(patient);
		verify(patientRepository, times(1)).save(patient);
		
	}
	
	@Test
	public void testFindAllPatients() {
		
		List<Patient> patientList = new ArrayList<>();
		Patient patient = preparePatientData();  // creating a mock object
		patientList.add(patient); // add to the patientList
		
		patient = preparePatientData();  // creating a mock object
		patientList.add(patient); // add to the patientList
		
		when(patientService.findAllPatients()).thenReturn(patientList);
		
		List<Patient> patients = patientService.findAllPatients();
		assertEquals(2, patients.size());
		verify(patientRepository, times(1)).findAll();
		
	}
	
	@Test
	public void testFindPatientById() {
		
		long patientId = 1L;
		Patient patient = preparePatientData();  // creating a mock object
		
		doReturn(patient).when(patientService).findPatientById(patientId);
		
		Patient responsePatient = patientService.findPatientById(patientId);
		assertEquals("Ashutosh", responsePatient.getFirstName());
		assertEquals("Mahato", responsePatient.getLastName());
		assertEquals(30, responsePatient.getAge());
		assertEquals("ashutosh.mahato@gmail.com", responsePatient.getEmailId());
		assertEquals("Male", responsePatient.getGender().toString());
		assertEquals(9590293525L, responsePatient.getMobileNumber());
		assertEquals("001.jpg", responsePatient.getImageUrl());
		assertEquals("fever", responsePatient.getSymptoms());
		
	}
	
	@Test
	public void testDeletePatientById() {
		long patientId = 1L;
		Patient patient = preparePatientData();
		patient.setId(patientId);
		//when(patientRepository.findById(patientId).isPresent()).thenReturn(true);
		//doReturn(true).when(patientService).deletePatientById(patientId);
		patientService.deletePatientById(patientId);
		
		verify(patientRepository, times(1)).deleteById(patientId);
	}
	
	private Patient preparePatientData() {
		Patient patient = new Patient();
		patient.setFirstName("Ashutosh");
		patient.setLastName("Mahato");
		patient.setAge(30);
		patient.setEmailId("ashutosh.mahato@gmail.com");
		//patient.setAdmissionDate(new Date(61202516585000L));
		patient.setGender(Gender.Male);
		patient.setMobileNumber(9590293525L);
		patient.setImageUrl("001.jpg");
		patient.setSymptoms("fever");
		return patient;
	}
	
}
