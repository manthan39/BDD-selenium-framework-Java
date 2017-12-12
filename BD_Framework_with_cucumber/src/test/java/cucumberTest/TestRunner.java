package cucumberTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @author mvbhatiya
 *
 */

@RunWith(Cucumber.class)
@CucumberOptions(
		strict = false,
		plugin = { "pretty", "json:target/cucumber.json"}, 
		tags = "@smoke, @regression" ,

		// for json format
		// "json:C:/Users/mvbhatiya/Desktop/cucumber-json-report.json"
		features = { "src\\main\\java\\resources"}, 
		glue = { "stepDefination" }
		)
public class TestRunner {

}