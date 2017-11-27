package stepDefination;

import cucumber.api.PendingException;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Homepage;
import testBase.testBase;

public class StepDefinations extends testBase {

	 	
	 Homepage hmpage =new Homepage(driver); 


	@Given("^User is on registation page$")
	public void user_is_on_registation_page() throws Throwable {
		
		/*hmpage= new Homepage(driver);*/
		hmpage.LoadUrl();
/*		throw new PendingException();*/
	}

	@When("^User enters registation details$")
	public void user_enters_registation_details() throws Throwable {
		hmpage.EnterUsername();
		hmpage.Enterpassword();
		hmpage.EnterUsername_mandatory();
		hmpage.ClickonLoginBtn();
	  //  throw new PendingException();
	}

	@Then("^Message displayed registration Successfully$")
	public void message_displayed_registration_Successfully() throws Throwable {
		/*System.out.println("Text is"+hmpage.verifyLogoutBtnMsg());
		Assert.assertEquals(hmpage.verifyLogoutBtnMsg(), "You're logged in!!");*/	 
/*	hmpage.ClickonLogoutBtn();*/
		hmpage.CloseBrowser();
	}

	
	}