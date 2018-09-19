package com.sentinel.test;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.sentinel.databaseUtility.ProjectDatabaseQueries;
import com.sentinel.driver.WebDriverTestBase;
import com.sentinel.pages.AddressPage;
import com.sentinel.pages.CreateFacilityFormPage;
import com.sentinel.pages.FacilityPage;
import com.sentinel.pages.HomePage;
import com.sentinel.pages.SignInPage;

public class VerifyFacilityListingAndCreateAddressTestSuite extends WebDriverTestBase {

	String stringValue = null, dbValue = null, temp = null;
	int intValue = 0;
	SignInPage signIn = null;
	ArrayList<String> arrayListValue = null;

	LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
	LinkedHashMap<Object, Object> linkedHashMap1 = new LinkedHashMap<Object, Object>();
	LinkedHashMap<Object, Object> linkedHashMap2 = new LinkedHashMap<Object, Object>();
	LinkedHashMap<Object, Object> linkedHashMap3 = new LinkedHashMap<Object, Object>();

	@Test(enabled = false, groups = { "Sprint3" }, priority = 1, description = "Verifing Facility Page Layout.")
	public void verifyFacilityPageLayout() throws InterruptedException {

		SignInPage signIn = new SignInPage();
		HomePage homePage = new HomePage();
		FacilityPage facilityPage = new FacilityPage();

		/**
		 * CHANGE THE PASSWORD TO DEFAULT
		 */

		// stringValue =
		stringValue = signIn.resetToDefaultPassword("change to default password");
		// stringValue = "Admin@123";
		// Login the application
		signIn.loginApplication(stringValue);
		homePage.navigateToFacilityPage("Navigate to Facility Page");
		facilityPage.verifyPageHeader();
		facilityPage.verifyAboveTableElements();
		facilityPage.verifyBelowTableElements();
		facilityPage.verifyTableHeaders();
		signIn.logoutTheApplication();
	}

	@Test(enabled = false, groups = { "Sprint3" }, priority = 2, description = "Verifing Address page Layout.")
	public void verifyAddressPageLayout() throws InterruptedException {

		SignInPage signIn = new SignInPage();
		HomePage homePage = new HomePage();
		CreateFacilityFormPage createFacilityFormPage = new CreateFacilityFormPage();
		AddressPage addressPage = new AddressPage();
		ProjectDatabaseQueries projectDatabaseQueries = new ProjectDatabaseQueries();

		/**
		 * CHANGE THE PASSWORD TO DEFAULT
		 */

		stringValue = signIn.resetToDefaultPassword("Don't Change the Password");
		// stringValue = "Admin@123";
		// Login the application
		signIn.loginApplication(stringValue);
		homePage.navigateToFacilityPage("Navigate to Create Form Page");
		linkedHashMap = createFacilityFormPage.saveCreateFacilityForm("Mandatory Fields");
		addressPage.navigateToViewFacilityPage(linkedHashMap);
		arrayListValue = projectDatabaseQueries.getFacilityDataForFirstRow();
		addressPage.verifyPageHeader(arrayListValue);
		addressPage.verifyTabDisplayedAndSelected();
		addressPage.verifyAboveTableAndBelowElements();
		addressPage.verifyAddressListTableHeadersAndNoRecordsFoundMessage();
		signIn.logoutTheApplication();
	}

	@Test(enabled = false, groups = {
			"Sprint3" }, priority = 3, description = "Verifing the new Address fields Layout.")
	public void verifyNewAddressFieldsLayout() throws InterruptedException {

		SignInPage signIn = new SignInPage();
		HomePage homePage = new HomePage();
		CreateFacilityFormPage createFacilityFormPage = new CreateFacilityFormPage();
		AddressPage addressPage = new AddressPage();

		/**
		 * CHANGE THE PASSWORD TO DEFAULT
		 */

		stringValue = signIn.resetToDefaultPassword("Don't Change the Password");
		// stringValue = "Admin@123";
		// Login the application
		signIn.loginApplication(stringValue);
		homePage.navigateToFacilityPage("Navigate to Create Form Page");
		// Add a facility
		linkedHashMap = createFacilityFormPage.saveCreateFacilityForm("Mandatory Fields");
		addressPage.navigateToViewFacilityPage(linkedHashMap);
		addressPage.navigateToNewAddressPage();
		addressPage.verifyNewAddressFormDropDowns();
		addressPage.verifyNewAddressFormTextBoxes();
		addressPage.verifybuttons();
		signIn.logoutTheApplication();
	}

	@Test(enabled = false, groups = {
			"Sprint3" }, priority = 4, description = "Verifing the New Address page Error Messages.")
	public void verifyNewAddressFieldsErrorMessages() throws InterruptedException {

		SignInPage signIn = new SignInPage();
		HomePage homePage = new HomePage();
		CreateFacilityFormPage createFacilityFormPage = new CreateFacilityFormPage();
		AddressPage addressPage = new AddressPage();

		/**
		 * CHANGE THE PASSWORD TO DEFAULT
		 */

		stringValue = signIn.resetToDefaultPassword("Don't Change the Password");
		// stringValue = "Admin@123";
		// Login the application
		signIn.loginApplication(stringValue);
		homePage.navigateToFacilityPage("Navigate to Create Form Page");
		linkedHashMap = createFacilityFormPage.saveCreateFacilityForm("Mandatory Fields");
		addressPage.navigateToViewFacilityPage(linkedHashMap);
		// click on 'New Address' button
		addressPage.navigateToNewAddressPage();
		addressPage.verifyBlankErrorMessages();
		addressPage.verifyAllFieldsErrorMessages();
		signIn.logoutTheApplication();
	}

	@Test(enabled = false, groups = {
			"Sprint3" }, priority = 5, description = "Verifing the newly added Address data with the database.")
	public void verifyNewAddressFieldsWithDataBase() throws InterruptedException {

		SignInPage signIn = new SignInPage();
		HomePage homePage = new HomePage();
		CreateFacilityFormPage createFacilityFormPage = new CreateFacilityFormPage();
		AddressPage addressPage = new AddressPage();
		ProjectDatabaseQueries projectDatabaseQueries = new ProjectDatabaseQueries();

		/**
		 * CHANGE THE PASSWORD TO DEFAULT
		 */

		stringValue = signIn.resetToDefaultPassword("Don't Change the Password");
		// stringValue = "Admin@123";
		// Login the application
		signIn.loginApplication(stringValue);
		homePage.navigateToFacilityPage("Navigate to Create Form Page");
		linkedHashMap = createFacilityFormPage.saveCreateFacilityForm("Mandatory Fields");
		addressPage.navigateToViewFacilityPage(linkedHashMap);
		arrayListValue = projectDatabaseQueries.getFacilityDataForFirstRow();
		addressPage.navigateToNewAddressPage();
		linkedHashMap1 = addressPage.fillNewAddressForm("dontSelectPhysicalAddress");
		linkedHashMap2 = projectDatabaseQueries.getAddedAddressValues(arrayListValue);
		addressPage.verifyTheNewAddedAddressWithDB(linkedHashMap1, linkedHashMap2);
		addressPage.verifyPostDropDownOptions(linkedHashMap1);
		linkedHashMap3 = addressPage.fillNewAddressForm("selectPhysicalAddress");
		addressPage.verifyAddedPhysicalAddressOnFailityListingPage(linkedHashMap3);
		signIn.logoutTheApplication();
	}

	@Test(enabled = true, groups = { "Sprint3" }, priority = 6, description = "Verifing the facility Filter.")
	public void verifyFacilityFilter() throws InterruptedException {

		SignInPage signIn = new SignInPage();
		HomePage homePage = new HomePage();
		CreateFacilityFormPage createFacilityFormPage = new CreateFacilityFormPage();
		ProjectDatabaseQueries projectDatabaseQueries = new ProjectDatabaseQueries();

		/**
		 * CHANGE THE PASSWORD TO DEFAULT
		 */

		stringValue = signIn.resetToDefaultPassword("Don't Change the Password");
		// stringValue = "Admin@123";
		// Login the application
		signIn.loginApplication(stringValue);
		homePage.navigateToFacilityPage("Navigate to Create Form Page");
		linkedHashMap = createFacilityFormPage.saveCreateFacilityForm("Mandatory Fields");
		arrayListValue = projectDatabaseQueries.getFacilityDataForFirstRow();
		createFacilityFormPage.verifyFacilityListingFilterButtonAndLabel();
		createFacilityFormPage.verifyPopUpElements();
		createFacilityFormPage.verifyDropdowns();
		// Search by Name
		arrayListValue = projectDatabaseQueries.getFacilityWithCityState();
		createFacilityFormPage.verifySearchFunctionalityUsingName(arrayListValue, "Name");
		// Search by State
		arrayListValue = projectDatabaseQueries.getFacilityWithCityState();
		createFacilityFormPage.verifySearchFunctionalityUsingName(arrayListValue, "State");
		// Search by City
		arrayListValue = projectDatabaseQueries.getFacilityWithCityState();
		createFacilityFormPage.verifySearchFunctionalityUsingName(arrayListValue, "City");

		signIn.logoutTheApplication();
	}

}
