package com.Tests_BDD;

import static io.restassured.RestAssured.given;

import java.util.Arrays;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.Utilities.AppConfigLoader;

public class QueryCapsules {

	@Test
	public void querycapsules_post() {

		JSONObject request = new JSONObject();

		request.put("query", Arrays.asList());
		request.put("options", Arrays.asList());

		given().body(request.toJSONString()).when().post(AppConfigLoader.getInstance().getBaseURL() + "/capsules/query")
				.then().statusCode(200);

	}
}
