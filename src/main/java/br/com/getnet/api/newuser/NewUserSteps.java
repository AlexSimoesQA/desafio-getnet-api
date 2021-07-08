package br.com.getnet.api.newuser;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import br.com.getnet.api.core.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NewUserSteps implements Constants{
	
	RequestSpecification given;
	private Response when;
	
	@Given("que eu entre com um {string} e {string}")
	public void que_eu_entre_com_um_e(String name, String job) throws Throwable {
	    given = given()
	    		.body("{\r\n"
	    				+ "    \"name\": "+ '"'+name+'"' +",\r\n"
	    				+ "    \"job\": "+ '"'+job+'"' + "\r\n"
	    				+ "}");
	}

	@When("eu executar a {string}")
	public void eu_executar_a(String endpoint) {
		when = given.post(endpoint);
	}

	@Then("deve ser retornado {int}")
	public void deve_ser_retornado(int status) {
		Assert.assertEquals(status, when.getStatusCode());
		when.then().log().all();
	}

}
