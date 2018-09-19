package com.sentinel.test;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.sentinel.databaseUtility.ProjectDatabaseQueries;
import com.sentinel.driver.WebDriverTestBase;
import com.sentinel.pages.AddressPage;
import com.sentinel.pages.ContactPage;
import com.sentinel.pages.CreateFacilityFormPage;
import com.sentinel.pages.HomePage;
import com.sentinel.pages.SignInPage;

public class AddContactWithLoginFunctionalityTestSuite extends WebDriverTestBase {

	String stringValue = null, dbValue = null, temp = null;
	int intValue = 0;
	SignInPage signIn = null;
	ArrayList<String> arrayListValue = null;

	LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();

	@Test(enabled = true, groups = { "Sprint4" }, priority = 1, description = "Verifing Contact Page Layout.")
	public void verifyAddContactPageLayout() throws InterruptedException {

		SignInPage signIn = new SignInPage();
		HomePage homePage = new HomePage();
		ContactPage contactPage = new ContactPage();
		CreateFacilityFormPage createFacilityFormPage = new CreateFacilityFormPage();
		AddressPage addressPage = new AddressPage();

		/**
		 * CHANGE THE PASSWORD TO DEFAULT
		 */

		stringValue = signIn.resetToDefaultPassword("change to default password");
		// stringValue = "Admin@123";
		// Login the application
		signIn.loginApplication(stringValue);
		homePage.navigateToFacilityPage("Navigate to Create Form Page");
		linkedHashMap = createFacilityFormPage.saveCreateFacilityForm("Mandatory Fields");
		addressPage.navigateToViewFacilityPage(linkedHashMap);
		contactPage.navigateToContactTab();
		contactPage.verifyContactListTableHeadersAndNoRecordsFoundMessage();
		signIn.logoutTheApplication();
	}

	@Test(enabled = true, groups = { "Sprint4" }, priority = 2, description = "Verifing New Contact Page Layout.")
	public void verifyNewContactFieldsLayout() throws Exception {

		SignInPage signIn = new SignInPage();
		HomePage homePage = new HomePage();
		ContactPage contactPage = new ContactPage();
		CreateFacilityFormPage createFacilityFormPage = new CreateFacilityFormPage();
		AddressPage addressPage = new AddressPage();

		/**
		 * CHANGE THE PASSWORD TO DEFAULT
		 */

		stringValue = signIn.resetToDefaultPassword("don't change to default password");
		// stringValue = "Admin@123";
		// Login the application

		signIn.loginApplication(stringValue);
		homePage.navigateToFacilityPage("Navigate to Create Form Page");
		linkedHashMap = createFacilityFormPage.saveCreateFacilityForm("Mandatory Fields");
		addressPage.navigateToViewFacilityPage(linkedHashMap);
		contactPage.navigateToContactTab();
		contactPage.verifyNewContactFormTextBoxes();
		contactPage.verifyNewContactFormDropDowns();
		contactPage.verifyUploadProfileImage();
		contactPage.verifyRadioButtons();
		contactPage.verifyButtons();

		signIn.logoutTheApplication();

	}

	@Test(enabled = true, groups = { "Sprint4" }, priority = 3, description = "Verifing New Contact Page Layout.")
	public void verifyNewContactFieldsErrorMessages() throws Exception {

		SignInPage signIn = new SignInPage();
		HomePage homePage = new HomePage();
		ContactPage contactPage = new ContactPage();
		CreateFacilityFormPage createFacilityFormPage = new CreateFacilityFormPage();
		AddressPage addressPage = new AddressPage();

		/**
		 * CHANGE THE PASSWORD TO DEFAULT
		 */

		stringValue = signIn.resetToDefaultPassword("don't change to default password");
		// stringValue = "Admin@123";
		// Login the application

		signIn.loginApplication(stringValue);
		homePage.navigateToFacilityPage("Navigate to Create Form Page");
		linkedHashMap = createFacilityFormPage.saveCreateFacilityForm("Mandatory Fields");
		addressPage.navigateToViewFacilityPage(linkedHashMap);
		contactPage.navigateToContactTab();
		contactPage.verifyBlankErrorMessages();
		contactPage.verifyAllFieldsErrorMessages();

		signIn.logoutTheApplication();

	}

	@Test(enabled = true, groups = { "Sprint4" }, priority = 4, description = "Verifing New Contact in Db.")
	public void verifyNewContactAddedvaluesInDataBase() throws Exception {

		SignInPage signIn = new SignInPage();
		HomePage homePage = new HomePage();
		ContactPage contactPage = new ContactPage();
		CreateFacilityFormPage createFacilityFormPage = new CreateFacilityFormPage();
		AddressPage addressPage = new AddressPage();
		ProjectDatabaseQueries projectDatabaseQueries = new ProjectDatabaseQueries();

		/**
		 * CHANGE THE PASSWORD TO DEFAULT
		 */

		stringValue = signIn.resetToDefaultPassword("don't change to default password");
		// stringValue = "Admin@123";
		// Login the application

		signIn.loginApplication(stringValue);
		homePage.navigateToFacilityPage("Navigate to Create Form Page");
		linkedHashMap = createFacilityFormPage.saveCreateFacilityForm("Mandatory Fields");
		addressPage.navigateToViewFacilityPage(linkedHashMap);
		contactPage.navigateToContactTab();
		linkedHashMap = contactPage.fillContactForm("All Fields");
		arrayListValue = projectDatabaseQueries.getNewContactData("All Fields");
		contactPage.verifyNewContactDataWithDB(linkedHashMap, arrayListValue);
		arrayListValue = projectDatabaseQueries.getNewContactData("LIsting Data");
		contactPage.verifyNewContactListData(arrayListValue);

		signIn.logoutTheApplication();

	}

	@Test(enabled = true, groups = {
			"Sprint4" }, priority = 5, description = "Verifing  Email Generated and reset password.")
	public void verifyEmailGeneratedResetPasswordAndLinkExpired() throws Exception {

		SignInPage signIn = new SignInPage();
		HomePage homePage = new HomePage();
		ContactPage contactPage = new ContactPage();
		CreateFacilityFormPage createFacilityFormPage = new CreateFacilityFormPage();
		AddressPage addressPage = new AddressPage();

		/**
		 * CHANGE THE PASSWORD TO DEFAULT
		 */

		stringValue = signIn.resetToDefaultPassword("don't change to default password");
		// stringValue = "Admin@123";
		// Login the application

		signIn.loginApplication(stringValue);
		homePage.navigateToFacilityPage("Navigate to Create Form Page");
		linkedHashMap = createFacilityFormPage.saveCreateFacilityForm("Mandatory Fields");
		addressPage.navigateToViewFacilityPage(linkedHashMap);
		contactPage.navigateToContactTab();
		linkedHashMap = contactPage.fillContactForm("All Fields");
		signIn.logoutTheApplication();
		contactPage.resetNewContactCreatedPassword(linkedHashMap);
		stringValue = signIn.verifyNewPasswordConfirmPasswordFuntionality("Don't change to default password");
		signIn.loginApplication(stringValue, linkedHashMap.get("userName").toString());
		contactPage.resetNewContactCreatedPassword(linkedHashMap);
		contactPage.verifyMailLinkExpired();
		/**
		 * no logout here because we are already on login page after test is
		 * completed . Next Page will start from this page only
		 */
	}

	@Test(enabled = true, groups = {
			"Sprint4" }, priority = 6, description = "verify Edit Created Contact Functionality.")
	public void verifyEditContactPageLayout() throws Exception {

		SignInPage signIn = new SignInPage();
		HomePage homePage = new HomePage();
		ContactPage contactPage = new ContactPage();
		CreateFacilityFormPage createFacilityFormPage = new CreateFacilityFormPage();
		AddressPage addressPage = new AddressPage();

		/**
		 * CHANGE THE PASSWORD TO DEFAULT
		 */

		stringValue = signIn.resetToDefaultPassword("don't change to default password");
		// stringValue = "Admin@123";
		// Login the application

		signIn.loginApplication(stringValue);
		homePage.navigateToFacilityPage("Navigate to Create Form Page");
		linkedHashMap = createFacilityFormPage.saveCreateFacilityForm("Mandatory Fields");
		addressPage.navigateToViewFacilityPage(linkedHashMap);
		contactPage.navigateToContactTab();
		contactPage.fillContactForm("Mandatory Fields");
		contactPage.navigateToEditContactPage();
		contactPage.verifyNewContactFormTextBoxes();
		contactPage.verifyNewContactFormDropDowns();
		contactPage.verifyUploadProfileImage();
		contactPage.verifyRadioButtons();
		contactPage.verifyButtons();
		contactPage.verifyCheckBoxes();
		signIn.logoutTheApplication();

	}

	@Test(enabled = true, groups = {
			"Sprint4" }, priority = 7, description = "verify Edit Created Contact Functionality.")
	public void verifyEditCreatedContactFunctionality() throws Exception {

		SignInPage signIn = new SignInPage();
		HomePage homePage = new HomePage();
		ContactPage contactPage = new ContactPage();
		CreateFacilityFormPage createFacilityFormPage = new CreateFacilityFormPage();
		AddressPage addressPage = new AddressPage();
		ProjectDatabaseQueries projectDatabaseQueries = new ProjectDatabaseQueries();

		/**
		 * CHANGE THE PASSWORD TO DEFAULT
		 */

		stringValue = signIn.resetToDefaultPassword("don't change to default password");
		// stringValue = "Admin@123";
		// Login the application

		signIn.loginApplication(stringValue);
		homePage.navigateToFacilityPage("Navigate to Create Form Page");
		linkedHashMap = createFacilityFormPage.saveCreateFacilityForm("Mandatory Fields");
		addressPage.navigateToViewFacilityPage(linkedHashMap);
		contactPage.navigateToContactTab();
		contactPage.fillContactForm("Mandatory Fields");
		contactPage.navigateToEditContactPage();
		linkedHashMap = contactPage.editCreatedContact();
		arrayListValue = projectDatabaseQueries.getNewContactData("Mandatory Fields");
		contactPage.verifyNewContactListData(arrayListValue);
		signIn.logoutTheApplication();

	}

	@Test(enabled = true, groups = {
			"Sprint4" }, priority = 8, description = "verify Edit  Contact resend Username Functionality.")
	public void verifyEditContactResendUserNameFunctionality() throws Exception {

		SignInPage signIn = new SignInPage();
		HomePage homePage = new HomePage();
		ContactPage contactPage = new ContactPage();
		CreateFacilityFormPage createFacilityFormPage = new CreateFacilityFormPage();
		AddressPage addressPage = new AddressPage();
		ProjectDatabaseQueries projectDatabaseQueries = new ProjectDatabaseQueries();

		/**
		 * CHANGE THE PASSWORD TO DEFAULT
		 */
		stringValue = signIn.resetToDefaultPassword("don't change to default password");
		// stringValue = "Admin@123";
		// Login the application

		signIn.loginApplication(stringValue);
		homePage.navigateToFacilityPage("Navigate to Create Form Page");
		linkedHashMap = createFacilityFormPage.saveCreateFacilityForm("Mandatory Fields");
		addressPage.navigateToViewFacilityPage(linkedHashMap);
		contactPage.navigateToContactTab();
		contactPage.fillContactForm("Mandatory Fields");
		contactPage.navigateToEditContactPage();
		linkedHashMap = contactPage.editCreatedContact();
		arrayListValue = projectDatabaseQueries.getNewContactData("Mandatory Fields");
		contactPage.verifyNewContactListData(arrayListValue);
		/**
		 * Resend Username Functionality
		 */
		contactPage.checkCheckboxResendUsernameorResetPassword("resendUsername");
		stringValue = signIn.getvalueFromMailBox(arrayListValue.get(3));
		contactPage.verifyEmailedUsername(linkedHashMap, stringValue);

		/**
		 * Resend Password Functionality
		 */
		contactPage.checkCheckboxResendUsernameorResetPassword("resetPassword");
		signIn.logoutTheApplication();
		signIn.getvalueFromMailBox(arrayListValue.get(3), "editContact");
		stringValue = signIn.verifyNewPasswordConfirmPasswordFuntionality("change to default password");
		/**
		 * login with the email and new password
		 */
		signIn.verifySuccessfullyLoginOnPasswordChange(linkedHashMap.get("userName").toString(), stringValue);
		signIn.logoutTheApplication();
	}

}
