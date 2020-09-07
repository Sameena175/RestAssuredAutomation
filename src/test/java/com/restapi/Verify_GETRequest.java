package com.restapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Verify_GETRequest {
	
	@Test
	void getspaceXDetails() {
		
		//specify baseURI		
		RestAssured.baseURI = "https://api.spacexdata.com/v4/launches";
		//creating request object
		RequestSpecification httpRequest = RestAssured.given();
		//creating response object
		Response httpResponse = httpRequest.request(Method.GET, "/Latest");
		
		String responseBody = httpResponse.getBody().asString();
		
		System.out.println("Response of the API : "+responseBody);
		
		//verify Status code 
		int statusCode = httpResponse.getStatusCode();
		System.out.println("Status code from Response of the API : "+statusCode);
		
		Assert.assertEquals(statusCode, 200);
		
		//Verify Status Line
		String statusLine = httpResponse.getStatusLine();
		System.out.println("Status Line from Response of the API : "+statusLine);
		
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		
		//Verify Status Line-Refereed Response header using Postman web app
		String contentType = httpResponse.getContentType();
		System.out.println("Content-Type Value from Response of the API : "+contentType);
			
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
		
		//Verify Status Line- Refereed Response header using Postman web app
		String contentEncoding = httpResponse.header("Content-Encoding");
		System.out.println("Content-Type Value from Response of the API : "+contentEncoding);
					
		Assert.assertEquals(contentType, "gzip");
	}

}
