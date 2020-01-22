package com.negs.springboot.microservice.standard.calculator.service;

/**
 * 
 * @author Nancy GS
 *
 */

public interface StandardCalculatorService {

	Double add(Double value1, Double value2);

	Double subtract(Double value1, Double value2);

	Double multiply(Double value1, Double value2);

	Double divide(Double value1, Double value2);
}
