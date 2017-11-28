package stepDefination;

import cucumber.api.PendingException;
import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Homepage;
import testBase.testBase;


/**
 * @author mvbhatiya
 *
 */
public class StepDefinations extends testBase {

	Homepage hmpage = new Homepage(driver);

	@Given("^User is on registration page$")
	public void user_is_on_registation_page() throws Throwable {

		/* hmpage= new Homepage(driver); */
		hmpage.LoadUrl();
		/* throw new PendingException(); */
	}

	@When("^User enters valid registation details$")
	public void user_enters_registation_details() throws Throwable {
		hmpage.EnterUsername("angular");
		hmpage.Enterpassword("password");
		hmpage.EnterUsername_mandatory("angular");
		hmpage.ClickonLoginBtn();

	}

	@Then("^Message displayed registration Successfully$")
	public void message_displayed_registration_Successfully() throws Throwable {
		/*
		 * System.out.println("Text is"+hmpage.verifyLogoutBtnMsg());
		 * Assert.assertEquals(hmpage.verifyLogoutBtnMsg(),
		 * "You're logged in!!");
		 */
		/* hmpage.ClickonLogoutBtn(); */
		/* hmpage.CloseBrowser(); */
	}

	@When("^User enters Invalid registation details$")
	public void user_enters_Invalid_registation_details() throws Throwable {
		hmpage.EnterUsername("invalid username");
		hmpage.Enterpassword("InvalidPasswd");
		hmpage.EnterUsername_mandatory("invalid username");
		hmpage.ClickonLoginBtn();

	}

	@Then("^Message displayed enter valid credentials$")
	public void message_displayed_enter_valid_credentials() throws Throwable {
		Assert.assertEquals(null, "Username or password is correct", "Username or password is incorrect");
		hmpage.CloseBrowser();

	}

}