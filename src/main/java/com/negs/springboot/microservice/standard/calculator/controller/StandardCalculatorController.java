package com.negs.springboot.microservice.standard.calculator.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.negs.springboot.microservice.standard.calculator.service.StandardCalculatorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Nancy GS
 *
 */

@RestController
@RequestMapping("/standard-calculator")
@Slf4j
@Api(tags = "Standard Calculator")
public class StandardCalculatorController {

	@Autowired
	private StandardCalculatorService standardCalculatorService;

	@GetMapping("/add/{value1}/{value2}")
	@ApiOperation(value = "Retrieve add operation result", notes = "Return the result value of (value1 + value2) operation")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "An unexpected error occurred"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "INTERNAL ERROR SERVER") })
	public Double add(@Valid @PathVariable Double value1, @PathVariable Double value2) {
		log.info("Method add starts - parameters value1: {} , value2: {}", value1, value2);
		return standardCalculatorService.add(value1, value2);
	}

	@GetMapping("/subtract/{value1}/{value2}")
	@ApiOperation(value = "Retrieve subtract operation result", notes = "Return the result value of (value1 - value2) operation")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "An unexpected error occurred"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "INTERNAL ERROR SERVER") })
	public Double subtract(@PathVariable Double value1, @PathVariable Double value2) {
		log.info("Method subtract starts - parameters value1: {} , value2: {}", value1, value2);
		return standardCalculatorService.subtract(value1, value2);
	}

	@GetMapping("/multiply/{value1}/{value2}")
	@ApiOperation(value = "Retrieve multiply operation result", notes = "Return the result value of (value1 * value2) operation")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "An unexpected error occurred"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "INTERNAL ERROR SERVER") })
	public Double multiply(@PathVariable Double value1, @PathVariable Double value2) {
		log.info("Method multiply starts - parameters value1: {} , value2: {}", value1, value2);
		return standardCalculatorService.multiply(value1, value2);
	}

	@GetMapping("/divide/{value1}/{value2}")
	@ApiOperation(value = "Retrieve divide operation result", notes = "Return the result value of (value1 / value2) operation")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "An unexpected error occurred"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "INTERNAL ERROR SERVER") })
	public Double divide(@PathVariable Double value1, @PathVariable Double value2) {
		log.info("Method divide starts - parameters value1: {} , value2: {}", value1, value2);
		return standardCalculatorService.divide(value1, value2);
	}
}
