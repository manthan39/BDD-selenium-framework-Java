/**
 * 
 */
package stepDefination;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CalculatorPage;
import testBase.testBase;

/**
 * @author mvbhatiya
 *
 */
public class CalculatorpageTestSteps extends testBase {

	String FirstInput = "10";
	String SecondInput = "20";

	CalculatorPage calpage = new CalculatorPage(driver);

	@Given("^User is on Calculator page$")
	public void user_is_on_Calculator_page() throws Throwable {
		calpage.Loadurl();

	}

	@When("^User enter first input$")
	public void user_enter_first_input() throws Throwable {
		calpage.EnterFirstInput(FirstInput);

	}

	@When("^user enter second input$")
	public void user_enter_second_input() throws Throwable {
		calpage.EnterSecondInput(SecondInput);

	}

	@When("^user select symbol$")
	public void user_select_symbol() throws Throwable {
		calpage.SelectFromDropDown("+");

	}

	@When("^user click on Go button$")
	public void user_click_on_Go_button() throws Throwable {
		calpage.clickOnGoBtn();

	}

	@Then("^User get correct result$")
	public void user_get_correct_result() throws Throwable {

	}

}
