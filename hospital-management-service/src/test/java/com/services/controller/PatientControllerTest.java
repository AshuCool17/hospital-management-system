/**
 * 
 */
package com.services.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.services.application.HospitalMgmtApplication;
import com.services.model.Gender;
import com.services.model.Patient;
import com.services.repository.PatientRepository;
import com.services.service.PatientService;

/**
 * @author ashumaha
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PatientController.class)
@ContextConfiguration(classes = { HospitalMgmtApplication.class })
public class PatientControllerTest extends AbstractControllerTest{

	@MockBean
	PatientService patientService;
	
	@MockBean
	PatientRepository patientRepository;
	
	@Before
	public void setup() {
		super.setUp();
	}
	
	@Test
	public void testAddPatient() throws Exception {
		
		Patient patient = preparePatientData(); // creating a mock object
		String patientJson = this.mapToJson(patient);
		
		//Mockito.when(patientService.addPatient(any())).thenReturn(patient); //whenever the addPatient API is called, return the mocked patient object 
		
		// Make request and verify it was successful
		mvc.perform(MockMvcRequestBuilders.post("/addPatient")
									.accept(MediaType.APPLICATION_JSON)
									.contentType(MediaType.APPLICATION_JSON).content(patientJson))
									.andExpect(status().isCreated()).andReturn(); //verifying 201 status as response
		
		Mockito.verify(patientService, Mockito.times(1)).addPatient(any()); //verifying the service method executed once and retrieved back the result
	}
	
	@Test
	public void testDeletePatient() throws Exception {
		
		Patient patient = preparePatientData();  // creating a mock object
		String patientJson = this.mapToJson(patient);
		long patientId = 1;
		
		Mockito.when(patientService.findPatientById(anyLong())).thenReturn(patient); //surpasses the findPatientId and feeds in the mocked patient object
		
		// Make request and verify it was successful
		mvc.perform(MockMvcRequestBuilders.delete("/deletePatientById/{patientId}", patientId)
										.accept(MediaType.APPLICATION_JSON)
										.contentType(MediaType.APPLICATION_JSON).content(patientJson))
										.andExpect(status().isNoContent()).andReturn(); //verifying 204 status as response
		
		Mockito.verify(patientService, Mockito.times(1)).deletePatientById(anyLong()); //verifying the service method executed once and retrieved back the result
	}
	
	@Test
	public void testFindAllPatients() throws Exception {
		List<Patient> patientList = new ArrayList<>();
		Patient patient = preparePatientData();  // creating a mock object
		patientList.add(patient); // add to the patientList
		
		patient = preparePatientData();  // creating a mock object
		patientList.add(patient); // add to the patientList
		
		Mockito.when(patientService.findAllPatients()).thenReturn(patientList); //surpasses the findPatientId and feeds in the mocked patient object
		
		// Make request and verify it was successful
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/findAllPatients")
									.accept(MediaType.APPLICATION_JSON))
									.andExpect(status().isOk()).andReturn();  //verifying 200 status as response
				
		Patient[] responsePatients = mapFromJson(result.getResponse().getContentAsString(), Patient[].class); //convert the response into a patient array for size comparison
		List<Patient> responsePatientList = new ArrayList<>();
		for (Patient responsePatient : responsePatients) {
			responsePatientList.add(responsePatient);
		}
		assertThat(responsePatientList.size(), is(2)); //check if the response has 2 patient records or not
		
	}
	
	@Test
	public void testFindPatientById() throws Exception {
		
		long patientId = 1;
		Patient patient = preparePatientData();
		
		Mockito.when(patientService.findPatientById(patientId)).thenReturn(patient); //surpasses the findPatientId and feeds in the mocked patient object
		
		// Make request and verify it was successful
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/findPatientById/{patientId}", patientId)
									.accept(MediaType.APPLICATION_JSON))
									.andExpect(status().isOk()).andReturn();  //verifying 200 status as response
				
		Patient responsePatient = mapFromJson(result.getResponse().getContentAsString(), Patient.class); //convert the response into a patient object to be used for verification if the values were same as the mocked object
		
		assertThat(responsePatient.getFirstName(), is("Ashutosh")); //check if the response has the patient first name as "Ashutosh"
		assertThat(responsePatient.getLastName(), is("Mahato")); //check if the response has the patient last name as "Mahato"
		assertThat(responsePatient.getAge(), is(30)); //check if the response has the patient age as 30
		
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
