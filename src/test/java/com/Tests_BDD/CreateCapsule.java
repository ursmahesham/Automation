package com.Tests_BDD;

import static io.restassured.RestAssured.given;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.Utilities.AppConfigLoader;

import static io.restassured.RestAssured.*;

public class CreateCapsule {
	@Test
	public void querycapsules_post() {

		JSONObject request = new JSONObject();
		request.put("reuse_count", 1);
		request.put("water_landings", 1);
		request.put("land_landings", 0);
		request.put("last_update", "Reentered after three weeks in orbit");
		request.put("launches", Arrays.asList("5eb87cdeffd86e000604b330"));
		request.put("serial", "C101");
		request.put("status", "retired");

		given().header("spacex-key", "test").body(request.toJSONString()).when()
				.post(AppConfigLoader.getInstance().getBaseURL() + "/capsules").then().statusCode(401);

	}
}