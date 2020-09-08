package com.Tests_TDD;

import static io.restassured.RestAssured.given;

import java.util.Arrays;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.Utilities.AppConfigLoader;

public class CreateLaunchpad {

	@Test
	public void createlanunpad_post() {
		JSONObject request = new JSONObject();
		request.put("name", "VAFB SLC 4E");
		request.put("full_name", "Vandenberg Air Force Base Space Launch Complex 4E");
		request.put("locality", "Vandenberg Air Force Base");
		request.put("region", "region");
		request.put("timezone", "America/Los_Angeles");
		request.put("latitude", 34.632093);
		request.put("longitude", " -120.610829");
		request.put("launch_attempts", 15);
		request.put("launch_successes", " 15");
		request.put("rockets", Arrays.asList("5e9d0d95eda69973a809d1ec"));
		request.put("launches", Arrays.asList("5eb87ce1ffd86e000604b334", "5eb87cf0ffd86e000604b343",
				"5eb87cfdffd86e000604b34c", "5eb87d05ffd86e000604b354"));

		given().header("spacex-key", "test").body(request.toJSONString()).when()
				.post(AppConfigLoader.getInstance().getBaseURL() + "/launchpads").then().statusCode(401);
	}
}
