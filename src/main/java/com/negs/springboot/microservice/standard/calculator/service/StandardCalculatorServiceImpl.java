package com.negs.springboot.microservice.standard.calculator.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Nancy GS
 *
 */

@Service
@Slf4j
public class StandardCalculatorServiceImpl implements StandardCalculatorService {

	@Override
	public Double add(Double value1, Double value2) {
		log.debug("Method add starts - parameters value1: {} , value2: {}", value1, value2);
		return value1 + value2;
	}

	@Override
	public Double subtract(Double value1, Double value2) {
		log.debug("Method subtract starts - parameters value1: {} , value2: {}", value1, value2);
		return value1 - value2;
	}

	@Override
	public Double multiply(Double value1, Double value2) {
		log.debug("Method multiply starts - parameters value1: {} , value2: {}", value1, value2);
		return value1 * value2;
	}

	@Override
	public Double divide(Double value1, Double value2) {
		log.debug("Method divide starts - parameters value1: {} , value2: {}", value1, value2);
		return value1 / value2;
	}

}
