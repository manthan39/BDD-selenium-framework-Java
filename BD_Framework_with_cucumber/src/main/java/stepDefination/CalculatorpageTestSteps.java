/**
 * 
 */
package stepDefination;

import javax.net.ssl.HostnameVerifier;

import org.openqa.selenium.interactions.Actions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CalculatorPage;
import pages.Homepage;
import testBase.testBase;

/**
 * @author mvbhatiya
 *
 */
public class CalculatorpageTestSteps extends testBase {

	/*String FirstInput = "50";
	String SecondInput = "30";
*/
	CalculatorPage calpage = new CalculatorPage(driver);
	Homepage hmpage = new Homepage(driver);


	@Given("^User is on Calculator page$")
	public void user_is_on_Calculator_page() throws Throwable {
		calpage.Loadurl();

	}

	@And("^User enter first input as \"([^\"]*)\"$")
	public void user_enter_first_input_as(String FirstInput) throws Throwable {
		calpage.EnterFirstInput(FirstInput);

	}

	@And("^User enter second input as \"([^\"]*)\"$")
	public void user_enter_second_input_as(String SecondInput) throws Throwable {
		 calpage.EnterSecondInput(SecondInput);
		 
	}

	@And("^User select symbol as \"([^\"]*)\"$")
	public void user_select_symbol_as(String Symbol) throws Throwable {
		calpage.SelectFromDropDown(Symbol);

	}

	@When("^User click on Go button$")
	public void user_click_on_Go_button() throws Throwable {
		Thread.sleep(2000);
		calpage.clickOnGoBtn();

	}

	@Then("^User get correct result$")
	public void user_get_correct_result() throws Throwable {

	}
	
	@Then("^Close the Browser$")
	public void close_the_Browser() throws Throwable {
	 hmpage.CloseBrowser();
	    throw new PendingException();
	}
	
}
