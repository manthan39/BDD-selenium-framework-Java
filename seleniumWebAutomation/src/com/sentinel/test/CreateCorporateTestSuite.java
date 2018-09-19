package com.sentinel.test;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.sentinel.driver.WebDriverTestBase;
import com.sentinel.pages.CorporatePage;
import com.sentinel.pages.CreateFacilityFormPage;
import com.sentinel.pages.HomePage;
import com.sentinel.pages.SignInPage;

public class CreateCorporateTestSuite extends WebDriverTestBase {

	String stringValue = null, dbValue = null, temp = null;
	int intValue = 0;
	SignInPage signIn = null;
	LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();

	@Test(enabled = true, groups = {
			"Sprint6" }, priority = 1, description = "Verifing All the page elements with position and default values.")
	public void verifyFacilityCreateLayout() throws InterruptedException {

		SignInPage signIn = new SignInPage();
		HomePage homePage = new HomePage();
		CreateFacilityFormPage createFacilityFormPage = new CreateFacilityFormPage();
		CorporatePage corporatePage = new CorporatePage();

		/**
		 * CHANGE THE PASSWORD TO DEFAULT
		 */

		stringValue = signIn.resetToDefaultPassword("DONT change to default password");
		// stringValue = "Admin@123";
		// Login the application
		signIn.loginApplication(stringValue);
		// Navigate to Create Facility Page
		homePage.navigateToFacilityPage("Dont navigate to Create Form Page");
		corporatePage.navigateToCreateCorporatePage("Navigate to Create Form Page");
		corporatePage.verifyPageHeaderElements();
		corporatePage.verifyFormNormalTextBoxesLayout();
		corporatePage.verifyDropDownsAndDefautValues();

		corporatePage.verifyTextAreas();
		corporatePage.verifyRadioButtonLayout();
		corporatePage.verifyCheckBoxAndDateDropdown();

		/**
		 * LOGOUT THE APPLICATION
		 */
		signIn.logoutTheApplication();
	}

	@Test(enabled = true, groups = { "Sprint6" }, priority = 2, description = "Verifing All the error messages.")
	public void verifyFacilityCreateErrorMessages() throws InterruptedException {

		SignInPage signIn = new SignInPage();
		HomePage homePage = new HomePage();
		CreateFacilityFormPage createFacilityFormPage = new CreateFacilityFormPage();
		CorporatePage corporatePage = new CorporatePage();

		/**
		 * CHANGE THE PASSWORD TO DEFAULT
		 */

		stringValue = signIn.resetToDefaultPassword("DONT change to default password");
		// stringValue = "Admin@123";
		// Login the application
		signIn.loginApplication(stringValue);
		// Navigate to Create Facility Page
		homePage.navigateToFacilityPage("Dont navigate to Create Form Page");
		corporatePage.navigateToCreateCorporatePage("Navigate to Create Form Page");
		//corporatePage.verifyCompulsaryFieldBlankErrorMessages();
		corporatePage.fillCorporateForm();
		/**
		 * LOGOUT THE APPLICATION
		 */
		signIn.logoutTheApplication();
	}

}
