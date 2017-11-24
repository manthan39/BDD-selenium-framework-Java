package cucumberTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	plugin = {"html:C:/Users/mvbhatiya/Desktop/cucumber-html-report" },
	// for json format "json:C:/Users/mvbhatiya/Desktop/cucumber-json-report.json"
	features = {"src\\main\\java\\resources"},
	glue={"stepDefination"}
)
public class TestRunner {

	
}