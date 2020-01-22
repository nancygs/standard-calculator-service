/**
 * 
 */
package com.negs.springboot.microservice.standard.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Nancy GS
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StandardCalculatorExceptionHandlerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void whenTry_thenOK() {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		ResponseEntity<String> response = restTemplate.exchange("/standard-calculator/add/2/3", HttpMethod.GET, entity,
				String.class);
		assertEquals(200, response.getStatusCodeValue());

	}

	@Test
	public void handleMethodArgumentTypeMismatchTest() throws JSONException {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		ResponseEntity<String> response = restTemplate.exchange("/standard-calculator/add/a2/3", HttpMethod.GET, entity,
				String.class);

		assertEquals(400, response.getStatusCodeValue());
		JSONObject json = new JSONObject(response.getBody());

		assertTrue(json.get("status").toString().contains("BAD_REQUEST"));
		assertTrue(json.get("message").toString()
				.contains("Failed to convert value of type 'java.lang.String' to required type 'java.lang.Double'"));
		assertTrue(json.get("errors").toString().contains("should be of type"));

	}

}
