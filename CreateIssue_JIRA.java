package Week3.Day1;

import java.io.File;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIssue_JIRA {
	@Test
	public void sendPostReq() {
		File input = new File("./src/main/resources/CreateIssueJIRA.json");
		RestAssured.baseURI="https://api-training.atlassian.net/rest/api/2/issue/";
		//Base Authentication
		RequestSpecification inputRequest = RestAssured
				.given()
				.auth()
				.preemptive()
				.basic("hari.radhakrishnan@testleaf.com", "YK9MgsR0ZF7BqmatFTX31B3C")
				.contentType(ContentType.JSON) //for POST nd PUT this is mandatory
				.accept(ContentType.JSON)
				.queryParams("fields", "key,summary,description")
				.body(input);
					
		//Send Request
		Response response = inputRequest.post();
		System.out.println("Status Code is"+response.getStatusCode());
		response.prettyPrint();
		String sys_id = response.jsonPath().get("id");
		System.out.println("System ID is "+sys_id);
	}
}
