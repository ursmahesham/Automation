package com.Tests_TDD;

import java.util.Arrays;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.Utilities.AppConfigLoader;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class All_Rockets_Tests {
	private String rocketId;
	@Test
	public void getAllRockets() {
		String responsebody;
		RequestSpecification httpRequest = RestAssured.given();
		
		httpRequest.header("Content-Type", "application/json");
		
		Response response = httpRequest.get(AppConfigLoader.getInstance().getBaseURL() + "/rockets");
	    responsebody = response.body().toString();
		JsonPath jsonPathEvaluator = response.jsonPath();
	    rocketId = jsonPathEvaluator.getString("payload_weights.id[0]").replace("[", "").replace("]", "");
	    
	    Assert.assertTrue(response.getStatusCode() == 200);	    
	}

	@Test
	public void getOneRokcet()
	{
		RequestSpecification httpRequest = RestAssured.given();

		httpRequest.header("Content-Type", "application/json");
		httpRequest.queryParam("id", rocketId);
			
		Response response = httpRequest.get(AppConfigLoader.getInstance().getBaseURL() + "/rockets/");
		
		Assert.assertTrue(response.getStatusCode() == 200);	
		
	}
	
	@Test
	public void postQueryrocket()
	{
		JSONObject request = new JSONObject();
		request.put("query", Arrays.asList());
		request.put("options", Arrays.asList());
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.body(request.toJSONString());	
		Response response = httpRequest.post(AppConfigLoader.getInstance().getBaseURL() + "/rockets/query");

		Assert.assertTrue(response.getStatusCode() == 200);	
		
	}
}
