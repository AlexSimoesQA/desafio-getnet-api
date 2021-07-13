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
	
	
	@Given("que eu entrei com um {string}: {string} e {string}: {string}")
	public void que_eu_entrei_com_um_e(String atributo1, String valor1, String atributo2, String valor2) {
	    requestSpec = given()
	    		.body("{\r\n"
	    				+ "    \""+atributo1+"\": "+ '"'+valor1+'"' +",\r\n"
	    				+ "    \""+atributo2+"\": "+ '"'+valor2+'"' +"\r\n"
	    				+ "}");
	}

	@When("eu executar a API {string} de metodo Post")
	public void eu_executar_a_api_de_metodo_post(String endpoint) {
		response = requestSpec.post(endpoint);
	}

	@Then("deve ser retornado {int} created")
	public void deve_ser_retornado_created(Integer status) {
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
	
	@Given("que eu entrei com um email: {string}")
	public void que_eu_entre_com_um(String string) throws Throwable{
		requestSpec = given()
	    		.body("{\r\n"
	    				+ "    \"email\": "+ '"'+string+'"' +"\r\n"
	    				+ "}");
	}
	
	@Then("deve ser retornado {int} Bad Request")
	public void deve_ser_retornado_badrequest(Integer status) {
		response
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
		response = requestSpec.put(string);
	}
	
	@Then("deve ser retornado {int} update")
	public void deve_ser_retornado_update(Integer status) {
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
	
	
	@When("eu executar a API {string} de metodo Patch")
	public void eu_executar_a_api_de_metodo_patch(String string) {
		response = requestSpec.patch(string);
	}
	
	@Then("deve ser retornado {int} ok")
	public void deve_ser_retornado_ok(Integer status) {
		response
		.then()
		.assertThat()
		.statusCode(status)
		.log()
		.all()
		;
	}
	
	@When("eu executar a API {string} de metodo GET")
	public void eu_executar_a_api_de_metodo_get(String string) {
		response = get(string);
	}
	
	@Then("deve validar a lista de usuarios")
	public void deve_validar_a_lista_de_usuarios() {
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

}
