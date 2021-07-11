package br.com.getnet.api.reqres.test;

import org.junit.runner.RunWith;

import br.com.getnet.api.core.BaseTest;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
plugin = {
"pretty"
},
monochrome = true,
glue = "br.com.getnet.api.reqres",
features = "src/test/resources/features/Reqres/",
snippets = SnippetType.CAMELCASE
)

public class ReqresTest extends BaseTest{

}
