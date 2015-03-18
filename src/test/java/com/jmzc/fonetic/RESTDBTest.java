package com.jmzc.fonetic;



import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RESTDBTest.class)
@WebAppConfiguration
public class RESTDBTest 
{
	
private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
//http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#rest-resttemplate
private RestTemplate template = null;

@Before
public void setUp() 
{
	this.template = new TestRestTemplate();
	this.template.setErrorHandler(new CustomResponseErrorHandler());


}

/**
 * Test returns all items
 * 
 */
@Test
@SuppressWarnings({ "rawtypes"})
public void test1() throws Exception 
{
	
	
	ResponseEntity<List> r = template.getForEntity("http://localhost:8080/item/list", List.class);

	Assert.isTrue(r.getStatusCode().is2xxSuccessful() && r.getBody() != null && r.getBody().size() == 4);
	logger.info("Received {}", r.getBody());
	
   

}
/**
 * Test filter items by type 
 * 
 */
@Test
@SuppressWarnings({ "rawtypes"})
public void test2() throws Exception 
{
	
	
	ResponseEntity<List> r = template.getForEntity("http://localhost:8080/item/list?type=B", List.class);
	


	Assert.isTrue(r.getStatusCode().is2xxSuccessful() && r.getBody() != null && r.getBody().size() == 2);
	logger.info("Received {}", r.getBody());

   

}
/**
 * Test empty list of items
 * 
 */
@Test
@SuppressWarnings({ "rawtypes"})
public void test3() throws Exception 
{
	
	
	ResponseEntity<List> r = template.getForEntity("http://localhost:8080/item/list?type=X", List.class);
	
	Assert.isTrue(r.getStatusCode().is2xxSuccessful() && r.getBody() != null && r.getBody().size() == 0);
	logger.info("Received {}", r.getBody());
	

   

}

/**
 * Test database exception
 * 
 */
@Test
@SuppressWarnings({ "rawtypes"})
public void test4() throws Exception 
{
	
	
	ResponseEntity<List> r = template.getForEntity("http://localhost:8080/item/list?type=EXCEPTION", List.class);
	
	Assert.isTrue(r.getStatusCode().is5xxServerError());

	

   

}
/*
 By default RestTemplate contains a default ResponseErrorHandler implementation called DefaultResponseErrorHandler, 
 which throws an exception when there’s an HTTP error.
 */ 
 private class CustomResponseErrorHandler implements ResponseErrorHandler 
 {

    @Override
    public void handleError(ClientHttpResponse response) throws IOException 
    {
        logger.error("Response error: {} {}", response.getStatusCode(), response.getStatusText());
    }

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException 
    {
    	 HttpStatus.Series series = response.getStatusCode().series();
         return (HttpStatus.Series.CLIENT_ERROR.equals(series)|| HttpStatus.Series.SERVER_ERROR.equals(series));

    }
}


}

   

