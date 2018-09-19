package stepDefination;

import java.util.NoSuchElementException;

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
public class LoginpageTestSteps extends testBase {

	Homepage hmpage = new Homepage(driver);

	@Given("^User is on registration page$")
	public void user_is_on_registation_page() throws Throwable {

		/* hmpage= new Homepage(driver); */
		hmpage.LoadUrl();
		/* throw new PendingException(); */
	}

	@When("^User enters valid registration details$")
	public void user_enters_registration_details() throws Throwable {
		hmpage.EnterUsername("angular");
		hmpage.Enterpassword("password");
		hmpage.EnterUsername_mandatory("angular");
		Thread.sleep(2000);
		hmpage.ClickonLoginBtn();
		Thread.sleep(3000);
		

	}

	@Then("^Message displayed registration Successfully$")
	public void message_displayed_registration_Successfully() throws Throwable {
		
		try{
		 System.out.println(hmpage.verifyLogoutBtnMsg().contains("logged") + ":for Valid");
//		 hmpage.ClickonLogoutBtn();
	} catch (NoSuchElementException e) {
	    System.out.println("Element Not Found");
	}	 
		 
		}

	@When("^User enters Invalid registration details$")
	public void user_enters_Invalid_registration_details() throws Throwable {
		hmpage.EnterUsername("invalid username");
		hmpage.Enterpassword("InvalidPasswd");
		hmpage.EnterUsername_mandatory("invalid username");
		Thread.sleep(2000);
		hmpage.ClickonLoginBtn();

	}

	@Then("^Message displayed enter valid credentials$")
	public void message_displayed_enter_valid_credentials() throws Throwable {
	try{
		System.out.println(hmpage.GetInvalidMsg().contains("is incorrect") + " :for Invalid");
/*		Assert.assertEquals("test", "bug");
*/	} catch (NoSuchElementException e) {
	    System.out.println("Element Not Found");
	}
	}
	
	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
		hmpage.CloseBrowser();

	}
	
	

	


}