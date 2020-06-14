/**
 * 
 */
package com.services.application;

/**
 * @author ashumaha
 *
 */
public class AuthenticationBean {

	private String message;

	public AuthenticationBean(String message) {
		this.message=message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return String.format("Authenticaiton [message=%s]", message);
	}
	
}
