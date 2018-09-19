package com.sentinel.test;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.sentinel.driver.WebDriverTestBase;
import com.sentinel.pages.CreateFacilityFormPage;
import com.sentinel.pages.FacilityPage;
import com.sentinel.pages.HomePage;
import com.sentinel.pages.SignInPage;

public class CreateFacilityTestSuite extends WebDriverTestBase {

	String stringValue = null, dbValue = null, temp = null;
	int intValue = 0;
	SignInPage signIn = null;
	LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();

	@Test(enabled = true, groups = {
			"Sprint2" }, priority = 1, description = "Verifing All the page elements with position and default values.")
	public void verifyFacilityCreateLayout() throws InterruptedException {

		SignInPage signIn = new SignInPage();
		HomePage homePage = new HomePage();
		CreateFacilityFormPage createFacilityFormPage = new CreateFacilityFormPage();

		/**
		 * CHANGE THE PASSWORD TO DEFAULT
		 */
		
		stringValue = signIn.resetToDefaultPassword("change to default password");
		// stringValue = "Admin@123";
		// Login the application
		signIn.loginApplication(stringValue);
		// Navigate to Create Facility Page
		homePage.navigateToFacilityPage("Navigate to Create Form Page");
		createFacilityFormPage.verifyPageHeaderElements();
		createFacilityFormPage.verifyFormNormalTextBoxesLayout();
		createFacilityFormPage.verifyImageUploadButtonLayout();
		createFacilityFormPage.verifyToolTips();
		createFacilityFormPage.verifyTextboxesWithToolTips();
		createFacilityFormPage.verifyDropDownsAndDefautValues();
		createFacilityFormPage.VerifyTextAreas();
		createFacilityFormPage.verifyRadioButtonLayout();
		createFacilityFormPage.VerifyButtonsLayout();
		createFacilityFormPage.verifyCheckBoxLayout();
		createFacilityFormPage.verifyRemainingSalesTaxTextbox();
		// logout the Application
		signIn.logoutTheApplication();
	}

	@Test(enabled = true, groups = {
			"Sprint2" }, priority = 2, description = "Verifing all the Validations for creating facility.")
	public void verifyFacilityCreateErrorMessages() throws InterruptedException {

		SignInPage signIn = new SignInPage();
		HomePage homePage = new HomePage();
		CreateFacilityFormPage createFacilityFormPage = new CreateFacilityFormPage();

		/**
		 * CHANGE THE PASSWORD TO DEFAULT
		 */
		
		stringValue = signIn.resetToDefaultPassword("change to default password");
		// stringValue = "Admin@123";
		// Login the application
		signIn.loginApplication(stringValue);
		homePage.navigateToFacilityPage("Navigate to Create Form Page");
		createFacilityFormPage.verifyCompulsaryFieldBlankErrorMessages();
		createFacilityFormPage.verifyWrongInputValidations();
		// logout the Application
		signIn.logoutTheApplication();

	}

	@Test(enabled = false, groups = {
			"Sprint2" }, priority = 3, description = "Verifing form is created with All compulsary and non compulsary fields and verifing the data saved in the database.")
	public void verifyFacilityFormCreated() throws InterruptedException {

		SignInPage signIn = new SignInPage();
		HomePage homePage = new HomePage();
		CreateFacilityFormPage createFacilityFormPage = new CreateFacilityFormPage();
		FacilityPage facilityPage = new FacilityPage();

		/**
		 * CHANGE THE PASSWORD TO DEFAULT
		 */
		
		stringValue = signIn.resetToDefaultPassword("change to default password");
		// stringValue = "Admin@123";
		// Login the application
		signIn.loginApplication(stringValue);
		homePage.navigateToFacilityPage(config.getProperty("navigateToCreateFacilitypage"));
		// fill the form with all the fields and verify in the database
		linkedHashMap = createFacilityFormPage.saveCreateFacilityForm("All Fields");
		facilityPage.verifyAddedFacility(linkedHashMap);
		// logout the Application
		signIn.logoutTheApplication();
	}

}
