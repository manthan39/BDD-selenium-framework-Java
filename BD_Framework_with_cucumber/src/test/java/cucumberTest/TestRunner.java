package cucumberTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	plugin={"pretty"},
	features = {"src\\main\\java\\resources"},
	glue={"stepDefination"}
)
public class TestRunner {

	
}