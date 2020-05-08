/**
 * 
 */
package com.services.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
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
	public void testGetAllPatients() throws Exception {
		List<Patient> patientList = new ArrayList<>();
		Patient patient = preparePatientData();
		patientList.add(patient);
		
		patient = preparePatientData();
		patientList.add(patient);
		
		Mockito.when(patientService.findAllPatients()).thenReturn(patientList);
		
		// Make request and verify it was successful
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/findAllPatients")
									.accept(MediaType.APPLICATION_JSON))
									.andExpect(status().isOk()).andReturn();
				
		Patient[] responsePatients = mapFromJson(result.getResponse().getContentAsString(), Patient[].class);
		List<Patient> responsePatientList = new ArrayList<>();
		for (Patient responsePatient : responsePatients) {
			responsePatientList.add(responsePatient);
		}
		assertThat(responsePatients.length, is(2));
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		
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
