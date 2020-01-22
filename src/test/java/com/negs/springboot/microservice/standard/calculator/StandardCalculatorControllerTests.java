/**
 * 
 */
package com.negs.springboot.microservice.standard.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.negs.springboot.microservice.standard.calculator.controller.StandardCalculatorController;
import com.negs.springboot.microservice.standard.calculator.service.StandardCalculatorService;

/**
 * @author Nancy GS
 *
 */

@RunWith(SpringRunner.class)
@WebMvcTest(value = StandardCalculatorController.class)
public class StandardCalculatorControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StandardCalculatorService standardCalculatorService;

	@Test
	public void addOperation() throws Exception {

		Mockito.when(standardCalculatorService.add(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(new Double(5));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/standard-calculator/add/2/3")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "5.0";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void subtractOperation() throws Exception {

		Mockito.when(standardCalculatorService.subtract(Mockito.anyDouble(), Mockito.anyDouble()))
				.thenReturn(new Double(1));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/standard-calculator/subtract/3/2")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "1.0";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void multiplyOperation() throws Exception {

		Mockito.when(standardCalculatorService.multiply(Mockito.anyDouble(), Mockito.anyDouble()))
				.thenReturn(new Double(6));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/standard-calculator/multiply/3/2")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "6.0";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void divideOperation() throws Exception {

		Mockito.when(standardCalculatorService.divide(Mockito.anyDouble(), Mockito.anyDouble()))
				.thenReturn(new Double(20));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/standard-calculator/divide/80/4")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "20.0";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

}
