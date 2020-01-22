/**
 * 
 */
package com.negs.springboot.microservice.standard.calculator.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Nancy GS
 *
 */

@ControllerAdvice
@Slf4j
public class StandardCalculatorExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
			WebRequest request) {
		log.info("Method handleMethodArgumentTypeMismatch starts ");
		StringBuilder msg = new StringBuilder(ex.getName()).append(" should be of type ")
				.append(ex.getRequiredType().getName());

		ErrorDetails error = new ErrorDetails(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), msg.toString());
		log.info("Method handleMethodArgumentTypeMismatch ends ");
		return new ResponseEntity<Object>(error, new HttpHeaders(), error.getStatus());
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
		log.info("Method handleAll starts ");
		ErrorDetails error = new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(),
				"error occurred");
		log.error(ex.getMessage());
		log.info("Method handleAll ends ");
		return new ResponseEntity<Object>(error, new HttpHeaders(), error.getStatus());
	}
}
