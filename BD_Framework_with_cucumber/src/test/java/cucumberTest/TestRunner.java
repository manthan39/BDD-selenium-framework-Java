package cucumberTest;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @author mvbhatiya
 *
 */

@RunWith(Cucumber.class)
@CucumberOptions(
		strict = false,
		plugin = {"pretty","html:target/cucumber-reports"}, 
		tags = "@smoke, @regression" ,

		// for json format
		// "json:C:/Users/mvbhatiya/Desktop/cucumber-json-report.json"
		features = { "src\\main\\java\\resources"}, 
		glue = { "stepDefination" }
		)
public class TestRunner {
	

}