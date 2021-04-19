package com.bankdigitalretail.creditcheckservice;

import com.bankdigitalretail.creditcheckservice.BaseContractTest;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import io.restassured.response.ResponseOptions;
import org.junit.Test;

import static com.toomuchcoding.jsonassert.JsonAssertion.assertThatJson;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.springframework.cloud.contract.verifier.assertion.SpringCloudContractAssertions.assertThat;

public class CreditcardserviceTest extends BaseContractTest {

	@Test
	public void validate_shouldDenyACreditScoreLowToACitizen() throws Exception {
		// given:
			MockMvcRequestSpecification request = given()
					.header("Content-Type", "application/json")
					.body("{\"citizenNumber\":4444,\"requestDate\":\"2020-04-26\",\"uuid\":\"aac0a33c-8822-11ea-bc55-0242ac130003\"}");

		// when:
			ResponseOptions response = given().spec(request)
					.post("/credit-scores");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
			assertThat(response.header("Content-Type")).matches("application/json.*");
		// and:
			DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
			assertThatJson(parsedJson).field("['score']").isEqualTo("LOW");
			assertThatJson(parsedJson).field("['uuid']").isEqualTo("aac0a33c-8822-11ea-bc55-0242ac130003");
	}

	@Test
	public void validate_shouldGrantACreditScoreHighToACitizen() throws Exception {
		// given:
			MockMvcRequestSpecification request = given()
					.header("Content-Type", "application/json")
					.body("{\"citizenNumber\":1234,\"requestDate\":\"2020-04-26\",\"uuid\":\"aac0a33c-8822-11ea-bc55-0242ac130003\"}");

		// when:
			ResponseOptions response = given().spec(request)
					.post("/credit-scores");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
			assertThat(response.header("Content-Type")).matches("application/json.*");
		// and:
			DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
			assertThatJson(parsedJson).field("['score']").isEqualTo("HIGH");
			assertThatJson(parsedJson).field("['uuid']").isEqualTo("aac0a33c-8822-11ea-bc55-0242ac130003");
	}

}
