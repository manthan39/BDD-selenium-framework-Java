package com.sentinel.test;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.sentinel.databaseUtility.ProjectDatabaseQueries;
import com.sentinel.driver.WebDriverTestBase;
import com.sentinel.pages.AddressPage;
import com.sentinel.pages.ContactPage;
import com.sentinel.pages.CreateFacilityFormPage;
import com.sentinel.pages.DepartmentManagementPage;
import com.sentinel.pages.FacilityDepartmentPage;
import com.sentinel.pages.HomePage;
import com.sentinel.pages.SignInPage;

public class DepartmentManagementTestSuite extends WebDriverTestBase {

	String stringValue = null, dbValue = null, temp = null;
	int intValue = 0;
	SignInPage signIn = null;
	ArrayList<String> arrayListValue = null;
	LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();

	@Test(enabled = true, groups = {
			"Sprint5" }, priority = 1, description = "Verifing Department Management Page Layout.")
	public void verifyDepartmentManagementPageLayout() throws InterruptedException {

		SignInPage signIn = new SignInPage();
		HomePage homePage = new HomePage();
		DepartmentManagementPage departmentManagementPage = new DepartmentManagementPage();

		/**
		 * CHANGE THE PASSWORD TO DEFAULT
		 */

		stringValue = signIn.resetToDefaultPassword("change to default password");
		// stringValue = "Admin@123";

		/**
		 * LOGIN THE APPLICATION
		 */

		signIn.loginApplication(stringValue);
		homePage.navigateToDeparmentManagementPage();
		departmentManagementPage.verifyPageHeaderElements();
		departmentManagementPage.verifyDepartmentListTable();
		departmentManagementPage.verifyAboveTableElements();
		departmentManagementPage.verifyBelowTableElements();
		departmentManagementPage.verifyTableHeaders("departmentManagement");
		signIn.logoutTheApplication();
	}

	@Test(enabled = false, groups = { "Sprint5" }, priority = 2, description = "Verifing New Department Page Layout.")
	public void verifyNewDepartmentPageLayout() throws InterruptedException {

		SignInPage signIn = new SignInPage();
		HomePage homePage = new HomePage();
		DepartmentManagementPage departmentManagementPage = new DepartmentManagementPage();

		/**
		 * CHANGE THE PASSWORD TO DEFAULT
		 */
		stringValue = signIn.resetToDefaultPassword("dont change to default password");
		// stringValue = "Admin@123";

		/**
		 * LOGIN THE APPLICATION
		 */

		signIn.loginApplication(stringValue);
		homePage.navigateToDeparmentManagementPage();
		departmentManagementPage.navigateNewDepartmentWindowElements();
		departmentManagementPage.verifyFormElements();
		signIn.logoutTheApplication();
	}

	@Test(enabled = false, groups = { "Sprint5" }, priority = 3, description = "Verifing Department List Displayed..")
	public void verifyErrorMessagesAndSearchFunctionality() throws InterruptedException {

		SignInPage signIn = new SignInPage();
		HomePage homePage = new HomePage();
		DepartmentManagementPage departmentManagementPage = new DepartmentManagementPage();
		ProjectDatabaseQueries projectDatabaseQueries = new ProjectDatabaseQueries();

		/**
		 * CHANGE THE PASSWORD TO DEFAULT
		 */

		stringValue = signIn.resetToDefaultPassword("dont change to default password");
		// stringValue = "Admin@123";

		/**
		 * LOGIN THE APPLICATION
		 */
		signIn.loginApplication(stringValue);
		homePage.navigateToDeparmentManagementPage();
		departmentManagementPage.navigateNewDepartmentWindowElements();
		departmentManagementPage.verifyErrorMessageForBlankFieldAndInvalidInput();

		/**
		 * GET THE EXISITING DEPARTMENT LIST SO WE CAN MAKE A VALID SEARCH...
		 */

		arrayListValue = projectDatabaseQueries.getDepartmentListFromDB("getExisitingAdminDepartments");

		/**
		 * SELECT THE RANDOM DEPARTMENT FROM THE LIST AND SEARCH . THEN VERIFY
		 * THE LIST WITH THE DATABASE
		 */

		stringValue = departmentManagementPage.enterSearchText(arrayListValue);

		/**
		 * VERIFY THE SEARCH RESULT ON THE UI WITH THE DB
		 */

		arrayListValue = projectDatabaseQueries.getDepartmentListFromDB("searchFunctionalityQuery", stringValue);
		departmentManagementPage.verifyDepartmentListDataDisplayed(arrayListValue);
		signIn.logoutTheApplication();
	}

	@Test(enabled = false, groups = {
			"Sprint5" }, priority = 4, description = "Verify new add department in the list..")
	public void verifyNewlyAddedDepartment() throws InterruptedException {

		SignInPage signIn = new SignInPage();
		HomePage homePage = new HomePage();
		DepartmentManagementPage departmentManagementPage = new DepartmentManagementPage();
		ProjectDatabaseQueries projectDatabaseQueries = new ProjectDatabaseQueries();
		/**
		 * CHANGE THE PASSWORD TO DEFAULT
		 */

		stringValue = signIn.resetToDefaultPassword("dont change to default password");
		// stringValue = "Admin@123";

		/**
		 * LOGIN THE APPLICATION
		 */

		signIn.loginApplication(stringValue);
		homePage.navigateToDeparmentManagementPage();
		departmentManagementPage.navigateNewDepartmentWindowElements();
		departmentManagementPage.addNewDepartmentManagement("testForm");
		arrayListValue = projectDatabaseQueries.getDepartmentListFromDB();
		departmentManagementPage.verifyDepartmentListDataDisplayed(arrayListValue);
		signIn.logoutTheApplication();
	}

	@Test(enabled = false, groups = { "Sprint5" }, priority = 5, description = "Verify facility department UI..")
	public void verifyFacilityDepartmentLayout() throws InterruptedException {

		SignInPage signIn = new SignInPage();
		HomePage homePage = new HomePage();
		CreateFacilityFormPage createFacilityFormPage = new CreateFacilityFormPage();
		AddressPage addressPage = new AddressPage();
		FacilityDepartmentPage facilityDepartmentPage = new FacilityDepartmentPage();
		DepartmentManagementPage departmentManagementPage = new DepartmentManagementPage();

		/**
		 * CHANGE THE PASSWORD TO DEFAULT
		 */
		stringValue = signIn.resetToDefaultPassword("dont change to default password");
		// stringValue = "Admin@123";

		/**
		 * LOGIN THE APPLICATION
		 */

		signIn.loginApplication(stringValue);

		homePage.navigateToFacilityPage("Navigate to Create Form Page");
		linkedHashMap = createFacilityFormPage.saveCreateFacilityForm("Mandatory Fields");
		addressPage.navigateToViewFacilityPage(linkedHashMap);
		facilityDepartmentPage.navigateToDepartmentTab();
		departmentManagementPage.verifyDepartmentListTable();
		departmentManagementPage.verifyAboveTableElements();
		departmentManagementPage.verifyBelowTableElements();
		departmentManagementPage.verifyTableHeaders("facilityDepartment");
		departmentManagementPage.navigateNewDepartmentWindowElements();
		facilityDepartmentPage.verifyFormElements();
		signIn.logoutTheApplication();
	}

	@Test(enabled = false, groups = {
			"Sprint5" }, priority = 6, description = "Verify the General department displayed and the admin department coing in the textbox list ..")
	public void verifyDefaultDepartmentAdminCreatedDepartment() throws InterruptedException {

		SignInPage signIn = new SignInPage();
		HomePage homePage = new HomePage();
		CreateFacilityFormPage createFacilityFormPage = new CreateFacilityFormPage();
		AddressPage addressPage = new AddressPage();
		FacilityDepartmentPage facilityDepartmentPage = new FacilityDepartmentPage();
		DepartmentManagementPage departmentManagementPage = new DepartmentManagementPage();

		/**
		 * CHANGE THE PASSWORD TO DEFAULT
		 */

		stringValue = signIn.resetToDefaultPassword("dont change to default password");
		// stringValue = "Admin@123";

		/**
		 * LOGIN THE APPLICATION
		 */

		signIn.loginApplication(stringValue);

		homePage.navigateToFacilityPage("Navigate to Create Form Page");
		linkedHashMap = createFacilityFormPage.saveCreateFacilityForm("Mandatory Fields");
		addressPage.navigateToViewFacilityPage(linkedHashMap);
		facilityDepartmentPage.navigateToDepartmentTab();

		/**
		 * VERIFY THE DEFAULT DEPARTMENT ADDED I.E,. 'GENERAL' DEPARTMENT
		 */
		departmentManagementPage.verifyFacilityDepartment(linkedHashMap);
		/**
		 * VERIFY THE ADMIN DEPARTMENT DISPLAYED UNDER TEXTBOX LST
		 */
		departmentManagementPage.navigateNewDepartmentWindowElements();
		facilityDepartmentPage.verifyAdminDepartmentListDisplayedIntextbox();
		signIn.logoutTheApplication();
	}

	@Test(enabled = false, groups = { "Sprint5" }, priority = 7, description = "Verify the Added Department ..")
	public void addAndVerifyFacilityDepartment() throws InterruptedException {

		SignInPage signIn = new SignInPage();
		HomePage homePage = new HomePage();
		CreateFacilityFormPage createFacilityFormPage = new CreateFacilityFormPage();
		AddressPage addressPage = new AddressPage();
		FacilityDepartmentPage facilityDepartmentPage = new FacilityDepartmentPage();
		DepartmentManagementPage departmentManagementPage = new DepartmentManagementPage();

		/**
		 * CHANGE THE PASSWORD TO DEFAULT
		 */

		stringValue = signIn.resetToDefaultPassword("dont change to default password");
		// stringValue = "Admin@123";

		/**
		 * LOGIN THE APPLICATION
		 */

		signIn.loginApplication(stringValue);

		homePage.navigateToFacilityPage("Navigate to Create Form Page");
		linkedHashMap = createFacilityFormPage.saveCreateFacilityForm("Mandatory Fields");
		addressPage.navigateToViewFacilityPage(linkedHashMap);
		facilityDepartmentPage.navigateToDepartmentTab();

		departmentManagementPage.navigateNewDepartmentWindowElements();
		facilityDepartmentPage.addFacilityDepartment("random", "random", "random");
		departmentManagementPage.navigateNewDepartmentWindowElements();
		facilityDepartmentPage.addFacilityDepartment("random", "random", "random");

		departmentManagementPage.verifyFacilityDepartment(linkedHashMap);
		signIn.logoutTheApplication();
	}

	@Test(enabled = false, groups = {
			"Sprint5" }, priority = 8, description = "Verify the added Department by adding contact to it  ..")
	public void addDepartmentToContact() throws InterruptedException {

		SignInPage signIn = new SignInPage();
		HomePage homePage = new HomePage();
		CreateFacilityFormPage createFacilityFormPage = new CreateFacilityFormPage();
		AddressPage addressPage = new AddressPage();
		FacilityDepartmentPage facilityDepartmentPage = new FacilityDepartmentPage();
		DepartmentManagementPage departmentManagementPage = new DepartmentManagementPage();
		ContactPage contactPage = new ContactPage();

		/**
		 * CHANGE THE PASSWORD TO DEFAULT
		 */

		stringValue = signIn.resetToDefaultPassword("dont change to default password");
		// stringValue = "Admin@123";

		/**
		 * LOGIN THE APPLICATION
		 */

		signIn.loginApplication(stringValue);

		homePage.navigateToFacilityPage("Navigate to Create Form Page");
		linkedHashMap = createFacilityFormPage.saveCreateFacilityForm("Mandatory Fields");
		addressPage.navigateToViewFacilityPage(linkedHashMap);
		facilityDepartmentPage.navigateToDepartmentTab();

		/**
		 * ADD FOUR DEPARTMENTS
		 */
		for (int i = 0; i <= 5; i++) {
			departmentManagementPage.navigateNewDepartmentWindowElements();
			if (i == 3) {
				facilityDepartmentPage.addFacilityDepartment("No random", "Yes", "Active");
			} else {
				facilityDepartmentPage.addFacilityDepartment("random", "Yes", "Active");
			}
		}
		contactPage.navigateToContactTab();
		linkedHashMap = contactPage.fillContactForm("All Fields");
		contactPage.editContactAndVerifyDepartment(linkedHashMap.get("department").toString());
		signIn.logoutTheApplication();
	}

	@Test(enabled = false, groups = {
			"Sprint5" }, priority = 9, description = "Verify when we inactivate the facility department its contacts are moved to 'General' department ..")
	public void verifyFacilityDepartmentInacticateFunctionality() throws InterruptedException {

		SignInPage signIn = new SignInPage();
		HomePage homePage = new HomePage();
		CreateFacilityFormPage createFacilityFormPage = new CreateFacilityFormPage();
		AddressPage addressPage = new AddressPage();
		FacilityDepartmentPage facilityDepartmentPage = new FacilityDepartmentPage();
		DepartmentManagementPage departmentManagementPage = new DepartmentManagementPage();
		ContactPage contactPage = new ContactPage();
		/**
		 * CHANGE THE PASSWORD TO DEFAULT
		 */

		stringValue = signIn.resetToDefaultPassword("dont change to default password");
		// stringValue = "Admin@123";

		/**
		 * LOGIN THE APPLICATION
		 */

		signIn.loginApplication(stringValue);

		homePage.navigateToFacilityPage("Navigate to Create Form Page");
		linkedHashMap = createFacilityFormPage.saveCreateFacilityForm("Mandatory Fields");
		addressPage.navigateToViewFacilityPage(linkedHashMap);
		facilityDepartmentPage.navigateToDepartmentTab();
		/**
		 * ADD FOUR DEPARTMENTS
		 */
		for (int i = 0; i <= 5; i++) {
			departmentManagementPage.navigateNewDepartmentWindowElements();
			facilityDepartmentPage.addFacilityDepartment("random", "Yes", "Active");

		}
		contactPage.navigateToContactTab();
		linkedHashMap = contactPage.fillContactForm("All Fields");
		contactPage.editContactAndVerifyDepartment(linkedHashMap.get("department").toString());
		facilityDepartmentPage.navigateToDepartmentTab();
		stringValue = facilityDepartmentPage.inactivateFacilityDepartment(linkedHashMap);
		contactPage.navigateToContactTab();
		contactPage.editContactAndVerifyDepartment(stringValue);
		signIn.logoutTheApplication();
	}

	@Test(enabled = false, groups = {
			"Sprint5" }, priority = 10, description = "Verify when we inactivate the facility department its contacts are moved to 'General' department ..")
	public void verifyAdminDepartmentInacticateFunctionality() throws InterruptedException {

		SignInPage signIn = new SignInPage();
		HomePage homePage = new HomePage();
		CreateFacilityFormPage createFacilityFormPage = new CreateFacilityFormPage();
		AddressPage addressPage = new AddressPage();
		FacilityDepartmentPage facilityDepartmentPage = new FacilityDepartmentPage();
		DepartmentManagementPage departmentManagementPage = new DepartmentManagementPage();

		/**
		 * CHANGE THE PASSWORD TO DEFAULT
		 */

		stringValue = signIn.resetToDefaultPassword("dont change to default password");
		// stringValue = "Admin@123";

		/**
		 * LOGIN THE APPLICATION
		 */

		signIn.loginApplication(stringValue);

		homePage.navigateToFacilityPage("Navigate to Create Form Page");
		linkedHashMap = createFacilityFormPage.saveCreateFacilityForm("Mandatory Fields");
		addressPage.navigateToViewFacilityPage(linkedHashMap);
		facilityDepartmentPage.navigateToDepartmentTab();

		/**
		 * ADD FOUR DEPARTMENTS
		 */
		for (int i = 0; i <= 3; i++) {
			departmentManagementPage.navigateNewDepartmentWindowElements();
			if (i == 3) {
				stringValue = facilityDepartmentPage.addFacilityDepartment("No random", "Yes", "Active");
			} else {
				facilityDepartmentPage.addFacilityDepartment("random", "Yes", "Active");
			}
		}
		homePage.navigateToDeparmentManagementPage();
		departmentManagementPage.verifyFacilityUsedDepartmentCannotBeDeactivated(stringValue);
		signIn.logoutTheApplication();
	}

}
