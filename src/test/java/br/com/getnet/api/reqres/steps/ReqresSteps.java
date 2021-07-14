package br.com.getnet.api.reqres.steps;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import br.com.getnet.api.core.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ReqresSteps extends BaseTest {
	
	RequestSpecification requestSpec;
	private Response response;
	
	
	@Given("I send {string}: {string} and {string}: {string}")
	public void i_send_and(String attribute1, String value1, String attribute2, String value2) {
	    requestSpec = given()
	    		.body("{\r\n"
	    				+ "    \""+attribute1+"\": "+ '"'+value1+'"' +",\r\n"
	    				+ "    \""+attribute2+"\": "+ '"'+value2+'"' +"\r\n"
	    				+ "}");
	}

	@When("I run a post method api {string}")
	public void i_run_a_post_method_api(String endpoint) {
		response = requestSpec.post(endpoint);
	}

	@Then("Should be returned {int} created")
	public void should_be_returned_created(Integer status) {
		response
		.then()
		.assertThat()
		.statusCode(status)
		.log()
		.all()
		.body("name", is("Alex"))
		.body("job", is("QA"))
		;
	}
	
	@Given("I send email: {string}")
	public void i_send_email(String value) {
		requestSpec = given()
	    		.body("{\r\n"
	    				+ "    \"email\": "+ '"'+value+'"' +"\r\n"
	    				+ "}");
	}
	
	@Then("Should be returned {int} bad request")
	public void should_be_returned_bad_request(Integer status) {
		response
		.then()
		.assertThat()
		.statusCode(status)
		.log()
		.all()
		.body("error", is("Missing password"))
		;
	}
	
	@When("I run a put method api {string}")
	public void i_run_a_put_method_api(String endpoint) {
		response = requestSpec.put(endpoint);
	}
	
	@Then("Should be returned {int} update")
	public void should_be_returned_update(Integer status) {
		response
		.then()
		.assertThat()
		.statusCode(status)
		.log()
		.all()
		.body("name", anyOf(is("Alex Simoes"), is("Yanne")))
		.body("job", anyOf(is("Automator"), is("Dev")))
		;
	}
	
	
	@When("I run a patch method api {string}")
	public void i_run_a_patch_method_api(String endpoint) {
		response = requestSpec.patch(endpoint);
	}
	
	@Then("Should be returned {int} ok")
	public void should_be_returned_ok(Integer status) {
		response
		.then()
		.assertThat()
		.statusCode(status)
		.log()
		.all()
		;
	}
	
	@When("I run a get method api {string}")
	public void i_run_a_get_method_api(String endpoint) {
		response = get(endpoint);
	}
	
	@Then("must validade a list of users")
	public void must_validade_a_list_of_users() {
		response
		.then()
		.assertThat()
		.log()
		.all()
		.body("data", hasSize(6))
		.body("data[0].first_name", is("Michael"))
		.body("data.last_name", contains("Lawson", "Ferguson", "Funke", "Fields", "Edwards", "Howell"))
		.body("data.email", hasItems("michael.lawson@reqres.in", "lindsay.ferguson@reqres.in", "george.edwards@reqres.in"))
		;
	}
	
	@Then("must validade a single user")
	public void must_validade_a_single_user() {
		response
		.then()
		.assertThat()
		.log()
		.all()
		.body("data.id", is(2))
		.body("data.email", is("janet.weaver@reqres.in"))
		.body("data.first_name", is("Janet"))
		.body("data.last_name", is("Weaver"))
		.body("data.avatar", is("https://reqres.in/img/faces/2-image.jpg"))
		;
	}
	
	@Then("Should be returned {int} not found")
	public void should_be_returned_not_found(Integer status) {
		response
		.then()
		.assertThat()
		.statusCode(status)
		.log()
		.all()
		.body("isEmpty()", is(true))
		;
	}

}
