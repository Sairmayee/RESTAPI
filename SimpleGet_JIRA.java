package Week3.Day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SimpleGet_JIRA {
	@Test
	public void GetRequest() {
		RestAssured.baseURI="https://api-training.atlassian.net/rest/api/2/search?jql=project=”LeafTaps”";
		//Base Authentication
		RequestSpecification inputRequest = RestAssured
				.given()
				.auth()
				.preemptive()
				.basic("hari.radhakrishnan@testleaf.com", "YK9MgsR0ZF7BqmatFTX31B3C")
				.queryParam("project", "id,key,name");
				//.queryParam("sysparm_fields", "sys_id,Category,Number,Description");
		
		//Send Request
		Response response = inputRequest.get();
		response.prettyPrint();
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
	}
}
