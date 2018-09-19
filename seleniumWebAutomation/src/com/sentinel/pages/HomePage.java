package com.sentinel.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import com.sentinel.driver.WebDriverTestBase;
import com.sentinel.locators.sentinalHomePageLocators.navigateToCreateFacilityFormLocators;
import com.sentinel.utils.ExcelUtility;
import com.sentinel.utils.GenericFunctions;

public class HomePage extends WebDriverTestBase {

	GenericFunctions genericFunctions = new GenericFunctions();
	ExcelUtility data = new ExcelUtility();
	// HomePage homePage=new HomePage();
	Actions action = new Actions(WebDriverTestBase.driver);

	List<WebElement> elementList = null;
	WebElement element = null;
	String stringValue = null, fileNameAndExtension = null, sheetName = null;
	int intValue = 0, i = 0, j = 0;
	String[] stringValueArray = null;
	int xlValues = 0;
	SoftAssert softAssertion = new SoftAssert();

	// This is the constructor
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = navigateToCreateFacilityFormLocators.LOC_IMAGEBUTTON_UPLEFTSIDEBAR_XPATH)
	@CacheLookup
	private WebElement toggleButtonSideBarAndClose;

	@FindBy(xpath = navigateToCreateFacilityFormLocators.LOC_COLLAPSABLEMENU_ENTITY_XPATH)
	@CacheLookup
	private WebElement collapsableEntity;

	@FindBy(xpath = navigateToCreateFacilityFormLocators.LOC_COLLAPSABLEMENU_ADMINISTRATOR_XPATH)
	@CacheLookup
	private WebElement collapsableAdministrator;

	@FindBy(xpath = navigateToCreateFacilityFormLocators.LOC_COLLAPSABLEMENU_ACCOUNTING_XPATH)
	@CacheLookup
	private WebElement collapsableAccounting;

	@FindBy(xpath = navigateToCreateFacilityFormLocators.LOC_LINK_FACILITY_XPATH)
	@CacheLookup
	private WebElement linkFacility;

	@FindBy(xpath = navigateToCreateFacilityFormLocators.LOC_LINK_DEPARTMENTMANAGEMENT_XPATH)
	@CacheLookup
	private WebElement linkDepartmentManagement;

	@FindBy(xpath = navigateToCreateFacilityFormLocators.LOC_LINK_DISTRIBUTORS_XPATH)
	@CacheLookup
	private WebElement linkDistributors;

	@FindBy(xpath = navigateToCreateFacilityFormLocators.LOC_LINK_ADMINCONTACTS_XPATH)
	@CacheLookup
	private WebElement linkAdminContacts;

	@FindBy(xpath = navigateToCreateFacilityFormLocators.LOC_TEXTANDICONLIST_CREATEFACILITY_XPATH)
	@CacheLookup
	private List<WebElement> listAndIconCreateFacility;

	@FindBy(xpath = navigateToCreateFacilityFormLocators.LOC_ICONBUTTON_PLUSSIGN_XPATH)
	@CacheLookup
	private WebElement rightBottomPlusSignIconButton;

	public WebElement getRightBottomPlusSignIconButton() {
		return rightBottomPlusSignIconButton;
	}

	public List<WebElement> getListAndIconCreateFacility() {
		return listAndIconCreateFacility;
	}

	public WebElement getLinkFacility() {
		return linkFacility;
	}

	public WebElement getLinkDepartmentManagement() {
		return linkDepartmentManagement;
	}

	public WebElement getLinkDistributors() {
		return linkDistributors;
	}

	public WebElement getLinkAdminContacts() {
		return linkAdminContacts;
	}

	public WebElement getCollapsableEntity() {
		return collapsableEntity;
	}

	public WebElement getCollapsableAdministrator() {
		return collapsableAdministrator;
	}

	public WebElement getCollapsableAccounting() {
		return collapsableAccounting;
	}

	public WebElement getToggleButtonSideBarAndClose() {
		return toggleButtonSideBarAndClose;
	}

	public void navigateToFacilityPage(String... args) {

		try {
			getToggleButtonSideBarAndClose().click();
			getCollapsableEntity().click();
			genericFunctions.waitForElementVisible(getLinkFacility());
			getLinkFacility().click();
			genericFunctions.logEvent("Navigated to 'Facility' page.");

			if (args[0].equals("Navigate to Create Form Page")) {
				genericFunctions.waitForElementVisible(getRightBottomPlusSignIconButton());
				while (!getRightBottomPlusSignIconButton().isDisplayed()) {
				}
				Thread.sleep(2000);
				getRightBottomPlusSignIconButton().click();
				elementList = getListAndIconCreateFacility();
				softAssertion.assertTrue(elementList.size() == 2, "'Create Facility' Size is not 2..");
				while (!elementList.get(0).isDisplayed()) {
					Thread.sleep(200);
				}
				for (i = 0; i < elementList.size(); i++) {
					softAssertion.assertTrue(elementList.get(i).isDisplayed(),
							"'Create Facility' text or icon is missing..");
				}
				elementList.get(0).click();
				genericFunctions.logEvent("Navigated to 'Create Facility' page.");
				i = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToDeparmentManagementPage() {
		try {
			Thread.sleep(3000);

			getToggleButtonSideBarAndClose().click();
			while (!getCollapsableAdministrator().isDisplayed()) {
			}
			getCollapsableAdministrator().click();
			while (!getLinkDepartmentManagement().isDisplayed()) {
			}
			getLinkDepartmentManagement().click();
			logger.debug("Navigated to 'Department Management ' page.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
