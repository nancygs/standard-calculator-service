/**
 * 
 */
package com.negs.springboot.microservice.standard.calculator.exception;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Nancy GS
 *
 */
@Getter
@Setter
public class ErrorDetails {
	private HttpStatus status;
	private String message;
	private List<String> errors;

	public ErrorDetails(HttpStatus status, String message, String error) {
		super();
		this.status = status;
		this.message = message;
		errors = Arrays.asList(error);
	}
}
