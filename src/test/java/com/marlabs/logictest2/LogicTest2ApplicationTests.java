package com.marlabs.logictest2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
class LogicTest2ApplicationTests extends AbstractTest {
	
	@Test
	public void getRandomNumbers() throws Exception {
	   mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	   String uri = "/";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   System.out.println("content="+content);
	   Integer[] randomNumbers = super.mapFromJson(content, Integer[].class);
	   assertTrue(randomNumbers.length > 1 && randomNumbers.length < 11);
	}
	
	@Test
	public void checkAdditionTestResultSuccess() throws Exception {
	   String successMessage = "Addition is correct.";
	   mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	   String uri = "/AdditionResult/95,25/120";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   System.out.println("content="+content);
	   assertEquals(successMessage, content);
	}
	
	@Test
	public void checkAdditionTestResultFailure() throws Exception {
	   String successMessage = "Addition is incorrect. Please try again!";
	   mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	   String uri = "/AdditionResult/95,25/1200";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   System.out.println("content="+content);
	   assertEquals(successMessage, content);
	}	
}
