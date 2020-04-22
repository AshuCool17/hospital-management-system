/**
 * 
 */
package com.services.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ashumaha
 *
 */
@Entity
@Table(name = "patient")
@Getter
@Setter
@ToString
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
	private int age;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name = "mobile_no")
	private int mobileNumber;
	
	@Column(name = "emaid_address")
	private String emailId;
	
	private String symptoms;
}
