package com.sentinel.pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class DepartmentManagementPage extends WebDriverTestBase {

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
	public DepartmentManagementPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = genericLocators.locators.LOC_PAGETITLE_XPATH)
	private WebElement pageTitle;

	@FindBy(xpath = genericLocators.locators.LOC_SEARCH_XPATH)
	private WebElement textboxSearch;

	@FindBy(xpath = genericLocators.locators.LOC_LOADERIMAGE_XPATH)
	private WebElement loaderImage;

	@FindBy(xpath = genericLocators.locators.LOC_LINK_BREADCRUM_XPATH)
	@CacheLookup
	private List<WebElement> listBreadcrum;

	@FindBy(xpath = genericLocators.locators.LOC_BREADCRUM_CURRENTACTIVEPAGE_XPATH)
	@CacheLookup
	private WebElement textBreadCrumActivePage;

	@FindBy(xpath = genericLocators.tableHeadersList.LOC_LABEL_TABLENAME_XPATH)
	@CacheLookup
	private WebElement labelTableName;

	@FindBy(xpath = genericLocators.locators.LOC_LABEL_SHOWINGPAGINATIONCOUNT_XPATH)
	@CacheLookup
	private WebElement labelShowingPaginationCount;

	@FindBy(xpath = genericLocators.locators.LOC_PAGINATION_PERPAGEENTRIES_XPATH)
	@CacheLookup
	private WebElement perPagePaginationEntries;

	@FindBy(css = genericLocators.locators.LOC_PAGINATION_PREVIOUSNEXT_CSS)
	@CacheLookup
	private WebElement paginationPreviousNext;

	@FindBy(xpath = genericLocators.locators.LOC_LABELLIST_TABLEHEADER_XPATH)
	@CacheLookup
	private List<WebElement> labelListTableHeaders;

	@FindBy(xpath = genericLocators.locators.LOC_COLLAPSALBUTTON_NEW_XPATH)
	private WebElement buttonNewDepartment;

	@FindBy(xpath = genericLocators.locators.LOC_RADIOBUTTON_ACTIVE_XPATH)
	@CacheLookup
	private WebElement radioButtonActive;

	@FindBy(xpath = genericLocators.locators.LOC_RADIOBUTTON_INACTIVE_XPATH)
	@CacheLookup
	private WebElement radioButtonInactive;

	@FindBy(xpath = departmentPageLocators.tableAddressPageLocators.LOC_TEXTBOX_DEPARTMENTNAME_XPATH)
	@CacheLookup
	private WebElement textboxDepartmentName;

	@FindBy(xpath = genericLocators.formFieldsList.LOC_BUTTON_SAVE_XPATH)
	private WebElement buttonSave;

	@FindBy(xpath = genericLocators.formFieldsList.LOC_BUTTON_CANCEL_XPATH)
	private WebElement buttonCancel;

	@FindBy(xpath = genericLocators.tableData.LOC_DATA_TABLE_XPATH)
	private List<WebElement> tableData;

	@FindBy(xpath = genericLocators.locators.LOC_PAGINATION_NEXT_XPATH)
	private WebElement nextPaginationButton;

	@FindBy(xpath = genericLocators.tableData.LOC_FIRSTROWDATA_TABLE_XPATH)
	private List<WebElement> firstColoumnData;

	@FindBy(xpath = genericLocators.formFieldsList.LOC_ERRORMESSAGELIST_XPATH)
	private List<WebElement> errorMessageFields;

	@FindBy(xpath = departmentPageLocators.tableAddressPageLocators.LOC_ICON_DEPARTMENTMANAGEMENTACTIONEDIT_XPATH)
	private List<WebElement> editIconDepartmentManagement;

	@FindBy(xpath = departmentPageLocators.tableAddressPageLocators.LOC_TABLEDATA_FIRSTROW_XPATH)
	private List<WebElement> firstColoumnDataDepartmentmanagement;

	public List<WebElement> getFirstColoumnDataDepartmentmanagement() {
		return firstColoumnDataDepartmentmanagement;
	}

	public WebElement getNextPaginationButton() {
		return nextPaginationButton;
	}

	public List<WebElement> getEditIconDepartmentManagement() {
		return editIconDepartmentManagement;
	}

	public List<WebElement> getErrorMessageFields() {
		return errorMessageFields;
	}

	public List<WebElement> getFirstColoumnData() {
		return firstColoumnData;
	}

	public List<WebElement> getTableData() {
		return tableData;
	}

	public WebElement getTextboxDepartmentName() {
		return textboxDepartmentName;
	}

	public WebElement getButtonSave() {
		return buttonSave;
	}

	public WebElement getButtonCancel() {
		return buttonCancel;
	}

	public WebElement getRadioButtonActive() {
		return radioButtonActive;
	}

	public WebElement getRadioButtonInactive() {
		return radioButtonInactive;
	}

	public WebElement getButtonNewDepartment() {
		return buttonNewDepartment;
	}

	public List<WebElement> getLabelListTableHeaders() {
		return labelListTableHeaders;
	}

	public WebElement getPerPagePaginationEntries() {
		return perPagePaginationEntries;
	}

	public WebElement getPaginationPreviousNext() {
		return paginationPreviousNext;
	}

	public WebElement getLabelTableName() {
		return labelTableName;
	}

	public WebElement getLabelShowingPaginationCount() {
		return labelShowingPaginationCount;
	}

	public WebElement getTextBreadCrumActivePage() {
		return textBreadCrumActivePage;
	}

	public List<WebElement> getListBreadcrum() {
		return listBreadcrum;
	}

	public WebElement getPageTitle() {
		return pageTitle;
	}

	public WebElement getTextboxSearch() {
		return textboxSearch;
	}

	public WebElement getLoaderImage() {
		return loaderImage;
	}

	public void verifyPageHeaderElements() {
		try {
			/**
			 * verify page Title
			 */
			Thread.sleep(800);

			while (!getPageTitle().getText().equals("Department Management")) {
			}
			element = getPageTitle();
			intValue = element.getText().length();
			GenericFunctions.highlightElement(element);
			softAssertion.assertTrue(element.getText().substring(0, 15).trim().equals("Department Management"),
					"'Create Title' of the page is not displayed . ");

			/**
			 * Verify Header Breadcrum displayed
			 */

			intValue = getListBreadcrum().size();
			for (int i = 0; i < intValue; i++) {
				GenericFunctions.highlightElement(getListBreadcrum().get(i));
				softAssertion.assertTrue(
						(genericFunctions.verifyLink(getListBreadcrum().get(i).getAttribute("href"))) == 200,
						getListBreadcrum().get(i).getText() + "  Link in the Breadcrum is not clickable");
			}
			GenericFunctions.highlightElement(getTextBreadCrumActivePage());
			softAssertion.assertTrue(getTextBreadCrumActivePage().getText().equals("Department Management"),
					"'Department Management' text is not as expected ... it is displayed as - "
							+ getTextBreadCrumActivePage().getText());

			genericFunctions.logEvent("Verified the Page Header with titles and breadcrum ...");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyDepartmentListTable() {
		try {
			/**
			 * Verify Table Header
			 */
			GenericFunctions.highlightElement(getLabelTableName());
			SoftAssertUtil.myAssert().assertTrue((getLabelTableName().isDisplayed())
					&& (getLabelTableName().getText().trim().equals("Department List")));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyAboveTableElements() {
		try {
			GenericFunctions.highlightElement(getPerPagePaginationEntries());
			softAssertion.assertTrue(getPerPagePaginationEntries().isDisplayed(), "Entries text is displayed..");
			genericFunctions.logEvent("Verified Entries dropdown is displayed. ");

			GenericFunctions.highlightElement(getTextboxSearch());
			softAssertion.assertTrue(getTextboxSearch().isDisplayed(), "Search box is displayed..");
			genericFunctions.logEvent("Verified Search box  is displayed. ");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyBelowTableElements() {
		try {

			genericFunctions.scrollToElement(getLabelShowingPaginationCount());
			GenericFunctions.highlightElement(getLabelShowingPaginationCount());
			softAssertion.assertTrue(getLabelShowingPaginationCount().isDisplayed(),
					"The facility disalyed count is not displayed...");
			genericFunctions.logEvent("Verified below table icons are displayed");

			GenericFunctions.highlightElement(getPaginationPreviousNext());
			softAssertion.assertTrue(getPaginationPreviousNext().isDisplayed(),
					"The Pagination Links are not displayed...");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyTableHeaders(String... args) {
		try {
			elementList = getLabelListTableHeaders();
			intValue = elementList.size();
			if (args[0].equalsIgnoreCase("facilityDepartment")) {
				sheetName = "facilityDepartmentListTableLabels";
			} else {
				sheetName = "departmentListTableLabels";
			}
			fileNameAndExtension = "departmentManagementExcelSheet.xls";
			while (xlValues < data.readData(sheetName, fileNameAndExtension).size()) {
				for (i = 0; i < intValue; i++) {
					genericFunctions.scrollToElement(elementList.get(i));
					GenericFunctions.highlightElement(elementList.get(i));
					softAssertion.assertTrue(
							elementList.get(i).getText()
									.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
							elementList.get(i).getText()
									+ " --> UI label does not match with the expected excel value ,i.e,. - "
									+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
					xlValues++;
				}
			}
			genericFunctions.logEvent("verified the department management table headers.");
			i = 0;
			xlValues = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateNewDepartmentWindowElements() {
		try {

			while (!getButtonNewDepartment().isDisplayed()) {
				Thread.sleep(2000);
			}
			Thread.sleep(2000);
			getButtonNewDepartment().click();
			Thread.sleep(2000);
			logger.debug("Navigate to New Department window..");
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
			GenericFunctions.highlightElement(getButtonCancel());
			SoftAssertUtil.myAssert().assertTrue(getButtonCancel().getText().equals("Cancel"),
					"'Cancel'  button label is not displayed as 'Cancel'");

			genericFunctions.logEvent("Verified the 'Save' and 'Cancel' button label and displayed ...");

			/**
			 * verify Radio Buttons
			 */
			GenericFunctions.highlightElement(getRadioButtonActive());
			SoftAssertUtil.myAssert().assertTrue(getRadioButtonActive().isSelected(),
					"'Active' radio button is by default IS NOT selected.");
			/*
			 * GenericFunctions.highlightElement(getRadioButtonActive().
			 * findElement(By.xpath("following-sibling::label")));
			 * SoftAssertUtil.myAssert().assertTrue(
			 * getRadioButtonActive().findElement(By.xpath(
			 * "following-sibling::label")).getText().equals("Active"),
			 * "'Active' radio button label is not displayed as 'Active'");
			 */
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
			GenericFunctions
					.highlightElement(getTextboxDepartmentName().findElement(By.xpath("preceding-sibling::label")));
			SoftAssertUtil.myAssert().assertTrue(getTextboxDepartmentName()
					.findElement(By.xpath("preceding-sibling::label")).getText().trim().equals("Department Name *"),
					"'Department Name' label is not displayed");
			SoftAssertUtil.myAssert().assertTrue(
					getTextboxDepartmentName().getAttribute("placeholder").equals("Enter Department Name"),
					"'Department Name' textbox placeholder is verified.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyDepartmentListDataDisplayed(ArrayList<String> arrayListValue) {
		try {
			List<WebElement> departmentData = getTableData();
			int i = 0, j = 0;
			intValue = departmentData.size();
			logger.debug("********************************");
			while (i < arrayListValue.size()) {
				while (j < intValue) {
					if (!departmentData.get(j).getText().equals("")) {
						logger.debug("UI Table Value - " + departmentData.get(j).getText().trim());
						logger.debug("DB Table Value - " + arrayListValue.get(i).trim());
						logger.debug(departmentData.get(j).getText().trim().equals(arrayListValue.get(i).trim()));
						genericFunctions.scrollToElement(departmentData.get(j));
						GenericFunctions.highlightElement(departmentData.get(j));
						SoftAssertUtil.myAssert().assertTrue(
								departmentData.get(j).getText().trim().equals(arrayListValue.get(i).trim()),
								departmentData.get(j).getText()
										+ " - UI Value does not match with the expected Db Value -"
										+ arrayListValue.get(i));
					} else {
						stringValue = arrayListValue.get(i);
						if (stringValue.equals("1")) {
							logger.debug("'General' department Tool Tip - "
									+ departmentData.get(j).findElement(By.xpath("a")).getAttribute("title"));
							logger.debug(departmentData.get(j).findElement(By.xpath("a")).getAttribute("title")
									.equals("This is default Department."));
							GenericFunctions.highlightElement(departmentData.get(j));
							SoftAssertUtil.myAssert().assertTrue(
									departmentData.get(j).findElement(By.xpath("a")).getAttribute("title")
											.equals("This is default Department."),
									departmentData.get(j).findElement(By.xpath("a")).getAttribute("title")
											+ "- 'General' department Tool Tip is not expected ");
						} else {
							arrayListValue1 = projectDatabaseQueries.getActionValueFromDB(stringValue);
							intVariable = Integer.parseInt(arrayListValue1.get(0));
							if (intVariable == 0) {
								logger.debug("Department Tool Tip - "
										+ departmentData.get(j).findElement(By.xpath("a")).getAttribute("title"));
								logger.debug(departmentData.get(j).findElement(By.xpath("a")).getAttribute("title")
										.equals("Edit"));
								GenericFunctions.highlightElement(departmentData.get(j));
								SoftAssertUtil.myAssert().assertTrue(
										departmentData.get(j).findElement(By.xpath("a")).getAttribute("title")
												.equals("Edit"),
										departmentData.get(j).findElement(By.xpath("a")).getAttribute("title")
												+ "- Department Tool Tip is not expected ");
							} else {
								logger.debug("Department Tool Tip - "
										+ departmentData.get(j).findElement(By.xpath("a")).getAttribute("title"));
								logger.debug(departmentData.get(j).findElement(By.xpath("a")).getAttribute("title")
										.equals("Department can not be edited as it is already being used by facilities."));
								GenericFunctions.highlightElement(departmentData.get(j));
								SoftAssertUtil.myAssert().assertTrue(
										departmentData.get(j).findElement(By.xpath("a")).getAttribute("title")
												.equals("Department can not be edited as it is already being used by facilities."),
										departmentData.get(j).findElement(By.xpath("a")).getAttribute("title")
												+ "- Department Tool Tip is not expected ");
							}
						}
					}
					j++;
					i++;
				}
			}
			logger.debug("Verified the Department Listed with the Database...");
			logger.debug("****************************************");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addNewDepartmentManagement(String... args) {
		try {
			stringValue = genericFunctions.generateCurrentDateAndTime("yyyy/MM/dd..HH/mm/ss");
			stringValue = stringValue + "deptartment--" + genericFunctions.generaterandomString(2);
			getTextboxDepartmentName().sendKeys(stringValue);
			linkedHashMap.put("departmentName", stringValue);
			if (args.length > 0) {
				intValue = genericFunctions.generateRandomNumber(0, 10);
				intValue = 3;
				if (intValue < 5) {
					/**
					 * no need to click the active radio button as it is already
					 * selected
					 */
					if (!getRadioButtonActive().isSelected()) {
						getRadioButtonActive().click();
					}
					linkedHashMap.put("activeRadioButton", "active");
				} else {
					getRadioButtonInactive().click();
					linkedHashMap.put("inactiveRadioButton", "inactive");
				}
			}
			getButtonSave().click();
			genericFunctions.logEvent("Department Added !!! - " + stringValue);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyErrorMessageForBlankFieldAndInvalidInput() {
		try {

			getButtonSave().click();
			/*
			 * String[] arrayValue = { "!", "#", "%", "^", "&", "*", "(", ")",
			 * "_", "=", "+", "[", "]", "{", "}", ";", ":", "'", "<", ">", "?",
			 * "/" };
			 * 
			 */
			String[] arrayValue = { "!", "#", "^", "*", "(", ")", "_", "=", "+", "[", "]", "{", "}", ";", ":", "<", ">",
					"?" };
			for (int i = 0; i < arrayValue.length; i++) {
				getTextboxDepartmentName().sendKeys(arrayValue[i]);
				SoftAssertUtil.myAssert().assertTrue(
						getErrorMessageFields().get(0).getText().equals("Department Name is required."),
						getErrorMessageFields().get(0).getText()
								+ " - UI error message does not match with the expected error message-'Department Name is required.'");
			}
			genericFunctions.logEvent("Verified the Error Message");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String enterSearchText(ArrayList<String> arrayListValue) {
		try {
			getButtonCancel().click();
			intValue = arrayListValue.size();
			randomNumber = genericFunctions.generateRandomNumber(0, intValue);
			for (int i = 0; i < intValue; i++) {
				if (randomNumber == i) {
					stringValue = arrayListValue.get(i);
					break;
				}
			}
			logger.debug("Search text entered is -" + stringValue);
			getTextboxSearch().sendKeys(stringValue);
			getTextboxSearch().sendKeys(Keys.ENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringValue;
	}

	public void verifyFacilityDepartment(LinkedHashMap<Object, Object> linkedHashMap) {
		try {
			while (!getTableData().get(0).isDisplayed()) {
				Thread.sleep(500);
			}
			Thread.sleep(2000);
			List<WebElement> departmentFirstRowData = getFirstColoumnData();
			intValue = departmentFirstRowData.size();
			int i = 0, j = 0, k = 0;
			while (i < intValue) {
				stringValue = departmentFirstRowData.get(i).getText();
				arrayListValue = projectDatabaseQueries.getDepartmentData(stringValue,
						linkedHashMap.get("Facility Name").toString());
				while (j < arrayListValue.size()) {
					/**
					 * DEPARTMENT NAME
					 */
					GenericFunctions.highlightElement(getTableData().get(k));
					SoftAssertUtil.myAssert().assertTrue(getTableData().get(k).getText().equals(arrayListValue.get(j)),
							getTableData().get(k).getText()
									+ "-UI 'department name' does not match with the database values ="
									+ arrayListValue.get(j));
					j++;
					k++;
					/**
					 * IS AN ADMIN
					 */
					GenericFunctions.highlightElement(getTableData().get(k));
					if (arrayListValue.get(j).equals("1")) {
						SoftAssertUtil.myAssert().assertTrue(getTableData().get(k).getText().equals("Yes"),
								getTableData().get(k).getText()
										+ "-UI 'is an admin -' does not match with the database values =" + "Yes");
					} else {
						SoftAssertUtil.myAssert().assertTrue(getTableData().get(k).getText().equals("No"),
								getTableData().get(k).getText()
										+ "-UI 'is an admin -' does not match with the database values =" + "No");
					}
					j++;
					k++;
					/**
					 * STATUS
					 */
					GenericFunctions.highlightElement(getTableData().get(k));
					if (arrayListValue.get(j).equals("1")) {
						SoftAssertUtil.myAssert().assertTrue(getTableData().get(k).getText().equals("Active"),
								getTableData().get(k).getText()
										+ "-UI 'Status -' does not match with the database values =" + "Active");
					} else {
						SoftAssertUtil.myAssert().assertTrue(getTableData().get(k).getText().equals("Inactive"),
								getTableData().get(k).getText()
										+ "-UI 'Status -' does not match with the database values =" + "Inactive");
					}
					k++;
					/**
					 * ACTION
					 */
					if (arrayListValue.get(0).equals("General")) {
						GenericFunctions.highlightElement(getTableData().get(k).findElement(By.xpath("a")));
						SoftAssertUtil.myAssert().assertTrue(
								getTableData().get(k).findElement(By.xpath("a")).getAttribute("title")
										.equals("This is default Department."),
								getTableData().get(k).findElement(By.xpath("a")).getAttribute("title")
										+ "-UI 'Action -' does not match with the database values ="
										+ "This is default Department.");
					} else {
						GenericFunctions.highlightElement(getTableData().get(k).findElement(By.xpath("a")));
						SoftAssertUtil.myAssert().assertTrue(
								getTableData().get(k).findElement(By.xpath("a")).getAttribute("title").equals("Edit"),
								getTableData().get(k).findElement(By.xpath("a")).getAttribute("title")
										+ "-UI 'Action -' does not match with the database values =" + "Edit");
					}
					k++;
					j = j + 5;
				}
				i++;
				j = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyFacilityUsedDepartmentCannotBeDeactivated(String stringValue) {
		try {
			int k = 0;
			Thread.sleep(3000);
			// List<WebElement> departmentData = getTableData();
			List<WebElement> departmentData = getFirstColoumnDataDepartmentmanagement();
			intValue = departmentData.size();

			logger.debug("********************************");

			for (k = 0; k < intValue; k++) {
			//	System.out.println(k + " - " + departmentData.get(k).getText());
				if (departmentData.get(k).getText().equals(stringValue)) {

					genericFunctions.scrollToElement(departmentData.get(k));
					GenericFunctions.highlightElement(departmentData.get(k));
					SoftAssertUtil.myAssert().assertTrue(departmentData.get(k).getText().equals(stringValue),
							departmentData.get(k).getText()
									+ " Admin Management department does not match with the selected department - "
									+ stringValue);

					SoftAssertUtil.myAssert().assertTrue(
							getEditIconDepartmentManagement().get(k).getAttribute("title")
									.equals("Department can not be edited as it is already being used by facilities."),
							getEditIconDepartmentManagement().get(k).getAttribute("title")
									+ " Action edit but title does not match with the expected title "
									+ "Department can not be edited as it is already being used by facilities.");
					break;
				}
				if ((k == 24)) {
					genericFunctions.scrollToElement(getNextPaginationButton());
					GenericFunctions.highlightElement(getNextPaginationButton());
					getNextPaginationButton().click();
					k = 0;
				}

			}
			logger.debug("Verified the Selected Admin Department cannot be edited...");
			logger.debug("****************************************");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
