package com.sentinel.pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.sentinel.databaseUtility.ProjectDatabaseQueries;
import com.sentinel.driver.WebDriverTestBase;
import com.sentinel.locators.departmentPageLocators;
import com.sentinel.locators.genericLocators;
import com.sentinel.utils.ExcelUtility;
import com.sentinel.utils.GenericFunctions;
import com.sentinel.utils.SoftAssertUtil;

public class FacilityDepartmentPage extends WebDriverTestBase {

	GenericFunctions genericFunctions = new GenericFunctions();
	ExcelUtility data = new ExcelUtility();
	/**
	 * HomePage homePage=new HomePage();
	 */
	Actions action = new Actions(WebDriverTestBase.driver);
	Select select = null;
	LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();

	List<WebElement> elementList = null, elementList2 = null;
	WebElement element = null;
	String stringValue = null, fileNameAndExtension = null, sheetName = null;
	int intValue = 0, i = 0, j = 0, randomNumber = 0, intVariable = 0;
	String[] stringValueArray = null;
	int xlValues = 0;
	boolean booleanValue;
	SoftAssert softAssertion = new SoftAssert();
	ProjectDatabaseQueries projectDatabaseQueries = new ProjectDatabaseQueries();
	ArrayList<String> arrayListValue = null;
	ArrayList<String> arrayListValue1 = null;

	/**
	 * This is the constructor
	 */
	public FacilityDepartmentPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = departmentPageLocators.facilityDepartmentPageLocators.LOC_TAB_SETUP_XPATH)
	@CacheLookup
	private WebElement tabSetUp;

	@FindBy(xpath = departmentPageLocators.facilityDepartmentPageLocators.LOC_TAB_DEPARTMENTS_XPATH)
	private WebElement tabDepartments;

	@FindBy(xpath = departmentPageLocators.facilityDepartmentPageLocators.LOC_CHECKBOX_CREATEDEPARTMENT_XPATH)
	private WebElement checkboxCreateDepartment;

	@FindBy(xpath = genericLocators.formFieldsList.LOC_BUTTON_SAVE_XPATH)
	private WebElement buttonSave;

	@FindBy(xpath = genericLocators.formFieldsList.LOC_BUTTON_CANCEL_XPATH)
	private WebElement buttonCancel;

	@FindBy(xpath = genericLocators.locators.LOC_RADIOBUTTON_ACTIVE_XPATH)
	@CacheLookup
	private WebElement radioButtonActive;

	@FindBy(xpath = genericLocators.locators.LOC_RADIOBUTTON_INACTIVE_XPATH)
	@CacheLookup
	private WebElement radioButtonInactive;

	@FindBy(xpath = departmentPageLocators.facilityDepartmentPageLocators.LOC_TEXTBOX_DEPARTMENTNAME_XPATH)
	@CacheLookup
	private WebElement textboxDepartmentName;

	@FindBy(xpath = departmentPageLocators.facilityDepartmentPageLocators.LOC_DROPDOWN_ADDITEM_XPATH)
	private WebElement textboxDropdownAddItem;

	@FindBy(xpath = departmentPageLocators.tableAddressPageLocators.LOC_TEXTBOXDROPDOWN_DEPARTMENTNAME_XPATH)
	private List<WebElement> textboxDropdownDepartmentName;

	@FindBy(xpath = departmentPageLocators.facilityDepartmentPageLocators.LOC_DROPDOWN_ISANADMIN_XPATH)
	@CacheLookup
	private WebElement dropdownIsAnAdmin;

	@FindBy(xpath = departmentPageLocators.facilityDepartmentPageLocators.LOC_DROPDOWNLIST_ISANADMIN_XPATH)
	private List<WebElement> dropdownListIsAnAdmin;

	@FindBy(xpath = genericLocators.tableData.LOC_DATA_TABLE_XPATH)
	private List<WebElement> tableData;

	@FindBy(xpath = genericLocators.tableData.LOC_ICON_ACTIONEDIT_XPATH)
	@CacheLookup
	private List<WebElement> actionEditIconButton;

	@FindBy(xpath = genericLocators.locators.LOC_FACILITYTABS_XPATH)
	private List<WebElement> facilityTabsList;

	@FindBy(xpath = genericLocators.tableData.LOC_FIRSTROWDATA_TABLE_XPATH)
	private List<WebElement> firstColoumnData;

	@FindBy(xpath = departmentPageLocators.facilityDepartmentPageLocators.LOC_DROPDOWNLIST_MOVETODEPARTMENT_XPATH)
	private List<WebElement> dropDownListMoveToDepartment;

	@FindBy(xpath = departmentPageLocators.facilityDepartmentPageLocators.LOC_TEXTBOX_MOVETODEPARTMENT_XPATH)
	private WebElement textboxMoveToDepartment;

	public WebElement getTextboxMoveToDepartment() {
		return textboxMoveToDepartment;
	}

	public List<WebElement> getDropDownListMoveToDepartment() {
		return dropDownListMoveToDepartment;
	}

	public List<WebElement> getFirstColoumnData() {
		return firstColoumnData;
	}

	public List<WebElement> getActionEditIconButton() {
		return actionEditIconButton;
	}

	public List<WebElement> getFacilityTabsList() {
		return facilityTabsList;
	}

	public List<WebElement> getTableData() {
		return tableData;
	}

	public List<WebElement> getDropdownListIsAnAdmin() {
		return dropdownListIsAnAdmin;
	}

	public List<WebElement> getTextboxDropdownDepartmentName() {
		return textboxDropdownDepartmentName;
	}

	public WebElement getTextboxDropdownAddItem() {
		return textboxDropdownAddItem;
	}

	public WebElement getDropdownIsAnAdmin() {
		return dropdownIsAnAdmin;
	}

	public WebElement getTextboxDepartmentName() {
		return textboxDepartmentName;
	}

	public WebElement getRadioButtonInactive() {
		return radioButtonInactive;
	}

	public WebElement getRadioButtonActive() {
		return radioButtonActive;
	}

	public WebElement getButtonCancel() {
		return buttonCancel;
	}

	public WebElement getButtonSave() {
		return buttonSave;
	}

	public WebElement getTabDepartments() {
		return tabDepartments;
	}

	public WebElement getCheckboxCreateDepartment() {
		return checkboxCreateDepartment;
	}

	public WebElement getTabSetUp() {
		return tabSetUp;
	}

	public void navigateToDepartmentTab() {
		try {
			/**
			 * open Setup tab
			 */
			while (!getTabSetUp().isDisplayed()) {
				Thread.sleep(1000);
			}
			genericFunctions.scrollToElement(getTabSetUp());
			GenericFunctions.highlightElement(getTabSetUp());
			getTabSetUp().click();
			/**
			 * check the create department checkbox,select if not selected
			 */

			stringValue = "click the checkbox";
			for (int i = 0; i < getFacilityTabsList().size(); i++) {

				if (getFacilityTabsList().get(i).getText().equalsIgnoreCase("Departments")) {
					stringValue = "don't click the checkbox";
				}
			}
			if (stringValue.equals("click the checkbox")) {
				genericFunctions.scrollToElement(getButtonSave());
				GenericFunctions.highlightElement(getCheckboxCreateDepartment());
				getCheckboxCreateDepartment().click();
			}
			/**
			 * save
			 */
			genericFunctions.scrollToElement(getButtonSave());
			GenericFunctions.highlightElement(getButtonSave());
			getButtonSave().click();
			/**
			 * click on department tab
			 */

			while (!getTabDepartments().isDisplayed()) {
				Thread.sleep(1000);
			}
			genericFunctions.scrollToElement(getTabDepartments());
			GenericFunctions.highlightElement(getTabDepartments());
			getTabDepartments().click();
			Thread.sleep(2000);
			logger.debug("Navigated to Department Tab");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyFormElements() {
		try {
			/**
			 * verify save and cancel buttons
			 */
			genericFunctions.scrollToElement(getButtonSave());
			GenericFunctions.highlightElement(getButtonSave());
			SoftAssertUtil.myAssert().assertTrue(getButtonSave().isDisplayed(), "'Save'  button  IS NOT Displayed.");
			SoftAssertUtil.myAssert().assertTrue(getButtonSave().getText().equals("Save"),
					"'Save' button label is not displayed as 'Save'");

			genericFunctions.scrollToElement(getButtonCancel());
			GenericFunctions.highlightElement(getButtonCancel());
			SoftAssertUtil.myAssert().assertTrue(getButtonCancel().isDisplayed(), "'Cancel'button  IS NOT Displayed.");
			SoftAssertUtil.myAssert().assertTrue(getButtonCancel().getText().equals("Cancel"),
					"'Cancel'  button label is not displayed as 'Cancel'");
			genericFunctions.logEvent("Verified the 'Save' and 'Cancel' button label and displayed ...");

			/**
			 * verify Radio Buttons
			 */
			GenericFunctions.highlightElement(getRadioButtonActive());
			SoftAssertUtil.myAssert().assertTrue(getRadioButtonActive().isSelected(),
					"'Active' radio button is by default IS NOT selected.");
			GenericFunctions.highlightElement(getRadioButtonActive());
			SoftAssertUtil.myAssert().assertTrue(getRadioButtonActive().getText().equals("Active"),
					"'Active' radio button label is not displayed as 'Active'");

			GenericFunctions.highlightElement(getRadioButtonInactive());
			SoftAssertUtil.myAssert().assertTrue(!getRadioButtonInactive().isSelected(),
					"'Inactive' radio button is by default IS selected.");
			GenericFunctions.highlightElement(getRadioButtonInactive());
			SoftAssertUtil.myAssert().assertTrue(getRadioButtonInactive().getText().equals("Inactive"),
					"'Inactive' radio button label is not displayed as 'Inactive'");

			genericFunctions.logEvent("Verified the radio button label and default selected element ...");
			/**
			 * verify the textbox
			 */

			GenericFunctions.highlightElement(getTextboxDepartmentName());
			GenericFunctions.highlightElement(
					getTextboxDepartmentName().findElement(By.xpath("ancestor::ng-select/preceding-sibling::label")));
			SoftAssertUtil.myAssert()
					.assertTrue(getTextboxDepartmentName()
							.findElement(By.xpath("ancestor::ng-select/preceding-sibling::label")).getText().trim()
							.equals("Department Name *"), "'Department Name' label is not displayed");
			/**
			 * is an admin dropdown
			 */
			GenericFunctions.highlightElement(getDropdownIsAnAdmin());
			GenericFunctions.highlightElement(getDropdownIsAnAdmin().findElement(By.xpath("preceding-sibling::label")));
			SoftAssertUtil.myAssert().assertTrue(getDropdownIsAnAdmin()
					.findElement(By.xpath("preceding-sibling::label")).getText().trim().equals("Is an Admin ?"),
					"'Is an Admin ?' label is not displayed");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String addFacilityDepartment(String departmentname, String isAnAdmin, String status) {
		try {
			/**
			 * DEPARTMENT NAME
			 */
			if (departmentname.equalsIgnoreCase("random")) {
				stringValue = "rand_dept_l" + genericFunctions.generaterandomString(3);
				action.moveToElement(getTextboxDepartmentName());
				action.click();
				action.sendKeys(stringValue);
				action.build().perform();
				while (!getTextboxDropdownAddItem().isDisplayed()) {
					Thread.sleep(1000);
				}
				getTextboxDropdownAddItem().click();
			} else {
				getTextboxDepartmentName().click();
				elementList = getTextboxDropdownDepartmentName();
				intValue = elementList.size();
				intValue = (intValue - 1);
				randomNumber = genericFunctions.generateRandomNumber(1, intValue - 1);

				for (int i = 1; i < elementList.size(); i++) {
					if (i == randomNumber) {
						stringValue = elementList.get(i).getText();
						elementList.get(i).click();

						break;
					}
				}
			}
			/**
			 * IS AN ADMIN
			 */
			getDropdownIsAnAdmin().click();
			elementList = getDropdownListIsAnAdmin();
			if (isAnAdmin.equalsIgnoreCase("random")) {
				intValue = elementList.size();
				randomNumber = genericFunctions.generateRandomNumber(0, (intValue - 1));
				elementList.get(randomNumber).click();

			} else {
				if (isAnAdmin.equalsIgnoreCase("Yes")) {
					elementList.get(1).click();
				}
				if (isAnAdmin.equalsIgnoreCase("No")) {
					elementList.get(0).click();
				}
			}

			/**
			 * STATUS
			 */
			if (status.equalsIgnoreCase("random")) {
				intValue = genericFunctions.generateRandomNumber(0, 1);
				if (intValue == 0) {
					getRadioButtonActive().click();
				} else {
					getRadioButtonInactive().click();
				}
			} else {
				if (status.equalsIgnoreCase("Active")) {
					getRadioButtonActive().click();
				}
				if (status.equalsIgnoreCase("Inactive")) {
					getRadioButtonInactive().click();
				}
			}

			/**
			 * click on save button
			 */
			getButtonSave().click();
			logger.debug("Add an department. Department Name:-" + stringValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	//	stringValue = "Accounts11";
		return stringValue;
	}

	public void verifyAdminDepartmentListDisplayedIntextbox() {
		try {
			int j = 0, i = 0;
			getTextboxDepartmentName().click();
			elementList = getTextboxDropdownDepartmentName();
			arrayListValue = projectDatabaseQueries
					.getDepartmentListFromDB("getExisitingAdminDepartmentsOrderedByName");
			while (j < arrayListValue.size()) {
				while (i < elementList.size()) {
					genericFunctions.scrollToElement(elementList.get(i));
					GenericFunctions.highlightElement(elementList.get(i));
					SoftAssertUtil.myAssert().assertTrue(elementList.get(i).getText().equals(arrayListValue.get(j)),
							elementList.get(i).getText()
									+ " -UI textbox admin department name does not match with the DB Value - "
									+ arrayListValue.get(j));
					j++;
					i++;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String inactivateFacilityDepartment(LinkedHashMap<Object, Object> linkedHashMap) {
		try {
			elementList = getFirstColoumnData();
			for (int i = 0; i < elementList.size(); i++) {
				genericFunctions.scrollToElement(elementList.get(i));
				GenericFunctions.highlightElement(elementList.get(i));
				if (elementList.get(i).getText().equals(linkedHashMap.get("department"))) {
					GenericFunctions.highlightElement(getActionEditIconButton().get(i));
					getActionEditIconButton().get(i).click();
					Thread.sleep(1000);
					break;
				}
			}
			getRadioButtonInactive().click();
			Thread.sleep(1000);
			while (!getTextboxMoveToDepartment().isDisplayed()) {
				Thread.sleep(1000);
			}
			SoftAssertUtil.myAssert().assertTrue(
					getTextboxMoveToDepartment().findElement(By.xpath("preceding-sibling::label")).getText()
							.equals("Move Contact from this Department to *"),
					getTextboxMoveToDepartment().findElement(By.xpath("preceding-sibling::label")).getText()
							+ "-ui 'Move Contact from this Department to *' label does not match with the expected text...");
			/**
			 * VERIFY BY DEFAULT 'GENERAL' OPTION IS SELECTED
			 */

			SoftAssertUtil.myAssert().assertTrue(getTextboxMoveToDepartment().getText().equals("General"),
					getTextboxMoveToDepartment().getText()
							+ "'move to Department' default text should be equal to be 'General'");

			getTextboxMoveToDepartment().click();
			intValue = getDropDownListMoveToDepartment().size();
			randomNumber = genericFunctions.generateRandomNumber(1, intValue);
			for (int i = 0; i < getDropDownListMoveToDepartment().size(); i++) {
				genericFunctions.scrollToElement(getDropDownListMoveToDepartment().get(i));
				GenericFunctions.highlightElement(getDropDownListMoveToDepartment().get(i));
				if (i == randomNumber) {
					stringValue = getDropDownListMoveToDepartment().get(i).getText();
					getDropDownListMoveToDepartment().get(i).click();
					break;
				}
			}
			getButtonSave().click();
			logger.debug("Moved the contacts to department -" + stringValue + " on deactivating the department -"
					+ linkedHashMap.get("department"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringValue;
	}
}
