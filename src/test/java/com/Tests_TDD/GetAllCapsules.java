package com.Tests_TDD;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.Utilities.AppConfigLoader;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllCapsules {

	@Test
	public void getAllCapsules() {
		Response response = RestAssured.get(AppConfigLoader.getInstance().getBaseURL() + "/capsules");
		Assert.assertTrue(response.statusCode() == 200);
		System.out.print(response.asString());
	}


}
