package br.com.getnet.api.reqres;

import static io.restassured.RestAssured.given;

import br.com.getnet.api.core.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ReqresSteps implements Constants{
	
	RequestSpecification given;
	private Response when;
	
	@Given("que eu entre com um {string} e {string}")
	public void que_eu_entre_com_um_e(String string1, String string2) throws Throwable {
	    given = given()
	    		.body("{\r\n"
	    				+ "    \"name\": "+ '"'+string1+'"' +",\r\n"
	    				+ "    \"job\": "+ '"'+string2+'"' + "\r\n"
	    				+ "}");
	}

	@When("eu executar a {string} de metodo Post")
	public void eu_executar_a(String endpoint) {
		when = given.post(endpoint);
	}

	@Then("deve ser retornado {int} created")
	public void deve_ser_retornado(Integer status) {
//		Assert.assertEquals(status, when.getStatusCode());
		when.then().assertThat().statusCode(201).log().all();
	}
	
	@Given("que eu entre com um {string}")
	public void que_eu_entre_com_um(String string) {
		given = given()
	    		.body("{\r\n"
	    				+ "    \"email\": "+ '"'+string+'"' +",\r\n"
	    				+ "}");
	}
	
	@Then("deve ser retornado {int} Bad Request")
	public void deve_ser_retornado_ok(Integer int1) {
		when.then().assertThat().statusCode(400);
	}
	
	@When("eu executar a {string} de metodo Put")
	public void eu_executar_a_de_metodo_put(String string) {
		when = given.put(string);
	}
	
	@Then("deve ser retornado {int} update")
	public void deve_ser_retornado_update(Integer int1) {
		when.then().assertThat().statusCode(200).log().all();
	}
	
	@When("eu executar a {string} de metodo Patch")
	public void eu_executar_a_de_metodo_patch(String string) {
		when = given.patch(string);
	}

}
