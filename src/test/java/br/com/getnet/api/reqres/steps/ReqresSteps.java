package br.com.getnet.api.reqres.steps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

import br.com.getnet.api.core.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ReqresSteps implements Constants {
	
	RequestSpecification given;
	private Response when;
	
	
	@Given("que eu entrei com um {string}: {string} e {string}: {string}")
	public void que_eu_entrei_com_um_e(String atributo1, String valor1, String atributo2, String valor2) {
	    given = given()
	    		.body("{\r\n"
	    				+ "    \""+atributo1+"\": "+ '"'+valor1+'"' +",\r\n"
	    				+ "    \""+atributo2+"\": "+ '"'+valor2+'"' +"\r\n"
	    				+ "}");
	}

	@When("eu executar a API {string} de metodo Post")
	public void eu_executar_a_api_de_metodo_post(String endpoint) {
		when = given.post(endpoint);
	}

	@Then("deve ser retornado {int} created")
	public void deve_ser_retornado_created(Integer status) {
		when
		.then()
		.assertThat()
		.statusCode(status)
		.log()
		.all()
		.body("name", is("Alex"))
		.body("job", is("QA"))
		;
	}
	
	@Given("que eu entrei com um email: {string}")
	public void que_eu_entre_com_um(String string) throws Throwable{
		given = given()
	    		.body("{\r\n"
	    				+ "    \"email\": "+ '"'+string+'"' +"\r\n"
	    				+ "}");
	}
	
	@Then("deve ser retornado {int} Bad Request")
	public void deve_ser_retornado_badrequest(Integer status) {
		when
		.then()
		.assertThat()
		.statusCode(status)
		.log()
		.all()
		.body("error", is("Missing password"))
		;
	}
	
	@When("eu executar a API {string} de metodo Put")
	public void eu_executar_a_api_de_metodo_put(String string) {
		when = given.put(string);
	}
	
	@Then("deve ser retornado {int} update")
	public void deve_ser_retornado_update(Integer status) {
		when
		.then()
		.assertThat()
		.statusCode(status)
		.log()
		.all()
		.body("name", anyOf(is("Alex Simoes"), is("Yanne")))
		.body("job", anyOf(is("Automator"), is("Dev")))
		;
	}
	
	
	@When("eu executar a API {string} de metodo Patch")
	public void eu_executar_a_api_de_metodo_patch(String string) {
		when = given.patch(string);
	}
	
	@Then("deve ser retornado {int} ok")
	public void deve_ser_retornado_ok(Integer status) {
		when
		.then()
		.assertThat()
		.statusCode(status)
		.log()
		.all()
		;
	}

}
