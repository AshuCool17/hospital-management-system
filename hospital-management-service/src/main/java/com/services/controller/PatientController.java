/**
 * 
 */
package com.services.controller;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.services.model.Patient;
import com.services.service.PatientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

/**
 * @author ashumaha
 *
 */
@RestController
@Api(value = "Patient Controller")
@CrossOrigin(origins = "*")
public class PatientController {
	
	@Autowired
	private PatientService patientService;

	private static final Logger logger = LoggerFactory.getLogger(PatientController.class);
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(path = "/addPatient", method = RequestMethod.POST, produces={ "application/json" } )
	public ResponseEntity addPatient(@ApiParam("description") @RequestBody Patient patient) {
	  
		logger.info("Adding patient information");
		Patient patientInfo = patientService.addPatient(patient); //Invoking the patientService to add patient information
		Gson gson = new Gson();
		return new ResponseEntity<>(gson.toJson(patientInfo), HttpStatus.CREATED); //Return the patient information as a json response with the response code
	}
	 
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(path = "/viewAllPatients", method = RequestMethod.GET, produces= { "application/json" } )
	public ResponseEntity viewAllPatients() {
		
		logger.info("Retrieving all patient information");
		List<Patient> patientsList = Collections.emptyList(); //Initializing the collection
		/*try(Stream<Patient> patientStream = patientService.viewAllPatients()) {
			patientsList = patientStream.collect(Collectors.toList()); //Using Stream API to retrieve patient information
		}*/
		
		patientsList = patientService.viewAllPatients(); //Invoking the patientService to retrieve all patient information
		Gson gson = new Gson();
		return new ResponseEntity<>(gson.toJson(patientsList), HttpStatus.OK); //Return all the patient information as a json response with the response code
	}
}
