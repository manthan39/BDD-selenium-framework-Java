package com.sentinel.pages;

import java.util.ArrayList;
import java.util.Iterator;
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

import com.sentinel.driver.WebDriverTestBase;
import com.sentinel.locators.addressPageLocators;
import com.sentinel.locators.facilityPageLocators;
import com.sentinel.locators.facilityPageLocators.facilityListingLocators;
import com.sentinel.locators.genericLocators;
import com.sentinel.locators.genericLocators.toasterMessagesLocators;
import com.sentinel.locators.sentinalHomePageLocators;
import com.sentinel.utils.ExcelUtility;
import com.sentinel.utils.GenericFunctions;

public class AddressPage extends WebDriverTestBase {

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
	int intValue = 0, i = 0, j = 0, randomNumber = 0;
	String[] stringValueArray = null;
	int xlValues = 0;
	boolean booleanValue;
	SoftAssert softAssertion = new SoftAssert();

	/**
	 * This is the constructor
	 */
	public AddressPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = facilityListingLocators.LOC_BUTTON_NEXT_XPATH)
	private WebElement buttonNext;

	@FindBy(xpath = facilityListingLocators.LOC_COLOUMN_CORPORATENAMEFACILITYNAME_XPATH)
	private List<WebElement> coloumnCorporateNameFacilityName;

	@FindBy(xpath = facilityListingLocators.LOC_LIST_PAGINATION_XPATH)
	private List<WebElement> listPagination;

	@FindBy(xpath = genericLocators.locators.LOC_PAGETITLE_XPATH)
	private WebElement pageTitleCreateFacility;

	@FindBy(xpath = genericLocators.locators.LOC_LINK_BREADCRUM_XPATH)
	@CacheLookup
	private List<WebElement> listBreadcrum;

	@FindBy(xpath = genericLocators.locators.LOC_BREADCRUM_CURRENTACTIVEPAGE_XPATH)
	@CacheLookup
	private WebElement textBreadCrumActivePage;

	@FindBy(xpath = facilityPageLocators.facilityListingLocators.LOC_LIST_EDIT_XPATH)
	@CacheLookup
	private List<WebElement> listEditButton;

	@FindBy(xpath = addressPageLocators.tableAddressPageLocators.LOC_TITLE_ADDRESSPAGE_XPATH)
	@CacheLookup
	private WebElement titleAddressPage;

	@FindBy(xpath = addressPageLocators.tableAddressPageLocators.LOC_TITLE_ADDRESSPAGEFACILITYID_XPATH)
	@CacheLookup
	private WebElement titleAddressPageFacilityID;

	@FindBy(xpath = addressPageLocators.tableAddressPageLocators.LOC_TITLE_ACTIVEORINACTIVESTATUS_XPATH)
	@CacheLookup
	private WebElement titleAddressPageStatus;

	@FindBy(xpath = addressPageLocators.tableAddressPageLocators.LOC_LIST_TABS_XPATH)
	@CacheLookup
	private List<WebElement> listTabs;

	@FindBy(xpath = genericLocators.locators.LOC_COLLAPSALBUTTON_NEW_XPATH)
	private WebElement buttonNewAddress;

	@FindBy(xpath = addressPageLocators.tableAddressPageLocators.LOC_TAB_ADDRESSES_XPATH)
	private WebElement tabAddresses;

	@FindBy(xpath = sentinalHomePageLocators.navigateToCreateFacilityFormLocators.LOC_ICONBUTTON_PLUSSIGN_XPATH)
	@CacheLookup
	private WebElement rightBottomPlusSignIconButton;

	@FindBy(xpath = genericLocators.tableHeadersList.LOC_LABELLIST_TABLEHEADER_XPATH)
	@CacheLookup
	private List<WebElement> labelListTableHeaders;

	@FindBy(xpath = genericLocators.tableHeadersList.LOC_LABEL_TABLENAME_XPATH)
	@CacheLookup
	private WebElement labelTableName;

	@FindBy(xpath = genericLocators.tableHeadersList.LOC_DEFAULTMESSAGE_TABLE_XPATH)
	@CacheLookup
	private WebElement defaultMessageTable;

	@FindBy(xpath = genericLocators.formFieldsList.LOC_LABELLIST_DROPDOWNS_XPATH)
	@CacheLookup
	private List<WebElement> labelListDropdowns;

	@FindBy(xpath = genericLocators.formFieldsList.LOC_LIST_DROPDOWN_XPATH)
	@CacheLookup
	private List<WebElement> listDropdowns;

	@FindBy(xpath = genericLocators.formFieldsList.LOC_LABELLIST_TEXTBOX_XPATH)
	@CacheLookup
	private List<WebElement> labelListTextbox;

	@FindBy(xpath = genericLocators.formFieldsList.LOC_LIST_TEXTBOX_XPATH)
	@CacheLookup
	private List<WebElement> listTextbox;

	@FindBy(xpath = genericLocators.formFieldsList.LOC_BUTTON_SAVE_XPATH)
	private WebElement buttonSave;

	@FindBy(xpath = genericLocators.formFieldsList.LOC_BUTTON_CANCEL_XPATH)
	@CacheLookup
	private WebElement buttonCancel;

	@FindBy(xpath = genericLocators.formFieldsList.LOC_ERRORMESSAGELIST_XPATH)
	private List<WebElement> errorMessageFields;

	@FindBy(xpath = addressPageLocators.newAddressPageLocators.LOC_DROPDOWN_ADDRESSTYPE_XPATH)
	@CacheLookup
	private WebElement dropdownAddressType;

	@FindBy(xpath = addressPageLocators.newAddressPageLocators.LOC_TEXTBOX_ADDRESSLINE1_XPATH)
	private WebElement textboxAddressLine1;

	@FindBy(xpath = addressPageLocators.newAddressPageLocators.LOC_TEXTBOX_ADDRESSLINE2_XPATH)
	@CacheLookup
	private WebElement textboxAddressLine2;

	@FindBy(xpath = addressPageLocators.newAddressPageLocators.LOC_DROPDOWN_STATEID_XPATH)
	@CacheLookup
	private WebElement dropdownStateID;

	@FindBy(xpath = addressPageLocators.newAddressPageLocators.LOC_DROPDOWN_CITYID_XPATH)
	@CacheLookup
	private WebElement dropdownCityID;

	@FindBy(xpath = addressPageLocators.newAddressPageLocators.LOC_TEXTBOX_ZIP_XPATH)
	@CacheLookup
	private WebElement textboxZip;

	@FindBy(xpath = addressPageLocators.newAddressPageLocators.LOC_LIST_TOTALNEWADDRESSFIELDS_XPATH)
	@CacheLookup
	private List<WebElement> listTotalNewAddressFields;

	@FindBy(xpath = addressPageLocators.newAddressPageLocators.LOC_OPTIONSLIST_DROPDOWN_XPATH)
	private List<WebElement> listDropDownOptions;

	@FindBy(xpath = addressPageLocators.newAddressPageLocators.LOC_CROSS_CLEARDROPDOWN_XPATH)
	private WebElement crossClearDropdown;

	@FindBy(xpath = toasterMessagesLocators.LOC_TOASTERMESSAGE__XPATH)
	@CacheLookup
	private WebElement toasterMessage;
	@FindBy(xpath = facilityListingLocators.LOC_LIST_FIRSTROW_XPATH)
	@CacheLookup
	private List<WebElement> listFirstRow;

	public List<WebElement> getListFirstRow() {
		return listFirstRow;
	}

	public WebElement getToasterMessage() {
		return toasterMessage;
	}

	public WebElement getCrossClearDropdown() {
		return crossClearDropdown;
	}

	public List<WebElement> getListDropDownOptions() {
		return listDropDownOptions;
	}

	public List<WebElement> getListTotalNewAddressFields() {
		return listTotalNewAddressFields;
	}

	public WebElement getDropdownAddressType() {
		return dropdownAddressType;
	}

	public WebElement getTextboxAddressLine1() {
		return textboxAddressLine1;
	}

	public WebElement getTextboxAddressLine2() {
		return textboxAddressLine2;
	}

	public WebElement getDropdownStateID() {
		return dropdownStateID;
	}

	public WebElement getDropdownCityID() {
		return dropdownCityID;
	}

	public WebElement getTextboxZip() {
		return textboxZip;
	}

	public List<WebElement> getErrorMessageFields() {
		return errorMessageFields;
	}

	public WebElement getButtonSave() {
		return buttonSave;
	}

	public WebElement getButtonCancel() {
		return buttonCancel;
	}

	public List<WebElement> getLabelListTextbox() {
		return labelListTextbox;
	}

	public List<WebElement> getListTextbox() {
		return listTextbox;
	}

	public List<WebElement> getLabelListDropdowns() {
		return labelListDropdowns;
	}

	public List<WebElement> getListDropdowns() {
		return listDropdowns;
	}

	public WebElement getDefaultMessageTable() {
		return defaultMessageTable;
	}

	public WebElement getLabelTableName() {
		return labelTableName;
	}

	public List<WebElement> getLabelListTableHeaders() {
		return labelListTableHeaders;
	}

	public WebElement getTabAddresses() {
		return tabAddresses;
	}

	public WebElement getRightBottomPlusSignIconButton() {
		return rightBottomPlusSignIconButton;
	}

	public WebElement getButtonNewAddress() {
		return buttonNewAddress;
	}

	public List<WebElement> getListTabs() {
		return listTabs;
	}

	public WebElement getTitleAddressPage() {
		return titleAddressPage;
	}

	public WebElement getTitleAddressPageFacilityID() {
		return titleAddressPageFacilityID;
	}

	public WebElement getTitleAddressPageStatus() {
		return titleAddressPageStatus;
	}

	public List<WebElement> getListEditButton() {
		return listEditButton;
	}

	public WebElement getTextBreadCrumActivePage() {
		return textBreadCrumActivePage;
	}

	public List<WebElement> getListBreadcrum() {
		return listBreadcrum;
	}

	public WebElement getPageTitleCreateFacility() {
		return pageTitleCreateFacility;
	}

	public List<WebElement> getListPagination() {
		return listPagination;
	}

	public WebElement getButtonNext() {
		return buttonNext;
	}

	public List<WebElement> getColoumnCorporateNameFacilityName() {
		return coloumnCorporateNameFacilityName;
	}

	public void navigateToViewFacilityPage(LinkedHashMap<Object, Object> linkedHashMap) {
		try {
			elementList = getColoumnCorporateNameFacilityName();
			intValue = elementList.size();
			for (i = 0; i < intValue; i++) {
				if (elementList.get(i).getText().equals(linkedHashMap.values().toArray()[0])) {
					GenericFunctions.highlightElement(elementList.get(i));
					GenericFunctions.highlightElement(getListEditButton().get(i));
					getListEditButton().get(i).click();
					// get to the address page of our newly added facility and
					// exit
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// public void verifyPageHeader(LinkedHashMap<Object, Object> linkedHashMap,
	// ArrayList<String> arrayListValue) {
	public void verifyPageHeader(ArrayList<String> arrayListValue) {
		try {
			// verify page Title
			Thread.sleep(800);
			// facility Name
			GenericFunctions.highlightElement(getTitleAddressPage());
			stringValueArray = getTitleAddressPage().getText().split(" ");
			stringValue = stringValueArray[0];
			softAssertion.assertTrue(stringValue.equals(arrayListValue.get(1)),
					stringValue + " - title on the page. does not match with the db value facility_name - "
							+ arrayListValue.get(1));

			// facility id
			GenericFunctions.highlightElement(getTitleAddressPageFacilityID());
			stringValue = getTitleAddressPageFacilityID().getText().replace("(", "").replace(")", "").replace("ID:",
					"");
			softAssertion.assertTrue(stringValue.equals(arrayListValue.get(0)), stringValue
					+ " - id on the page. does not match with the db value facility_id - " + arrayListValue.get(0));

			// Status
			GenericFunctions.highlightElement(getTitleAddressPageStatus());
			stringValue = getTitleAddressPageStatus().getText();
			softAssertion.assertTrue(stringValue.equals(arrayListValue.get(4)), stringValue
					+ " - id on the page. does not match with the db value facility_id - " + arrayListValue.get(4));

			// Verify Header Breadcrum displayed
			intValue = getListBreadcrum().size();
			for (i = 0; i < intValue; i++) {
				GenericFunctions.highlightElement(getListBreadcrum().get(i));
				softAssertion.assertTrue(
						(genericFunctions.verifyLink(getListBreadcrum().get(i).getAttribute("href"))) == 200,
						getListBreadcrum().get(i).getText() + "  Link in the Breadcrum is not clickable");
			}

			GenericFunctions.highlightElement(getTextBreadCrumActivePage());
			softAssertion.assertTrue(getTextBreadCrumActivePage().getText().equals("View Facility"),
					"'Facility' text is not as expected ... it is displayed as - "
							+ getTextBreadCrumActivePage().getText());

			genericFunctions.logEvent("Verified the Page Header with titles and breadcrum ...");
			i = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyTabDisplayedAndSelected() {
		try {
			sheetName = "AddressPageTabs";
			fileNameAndExtension = "addressPageExcelSheet.xls";
			elementList = getListTabs();
			intValue = elementList.size();

			while (xlValues < data.readData(sheetName, fileNameAndExtension).size()) {
				for (i = 0; i < intValue; i++) {
					GenericFunctions.highlightElement(elementList.get(i));
					if (elementList.get(i).getText().length() > 0) {
						stringValue = elementList.get(i).getText();
						softAssertion.assertTrue(
								stringValue.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
								stringValue + " ui tab does not match with the expected excel values - "
										+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
						if (elementList.get(i).getText()
								.equals(data.readData(sheetName, fileNameAndExtension).get(1))) {
							elementList.get(i).click();
							softAssertion.assertTrue(elementList.get(i).findElement(By.xpath(".."))
									.getAttribute("class").contains("active"), "Address tab is not selected.");
						}
					} else {
						stringValue = elementList.get(i).getText().replace("", "");
						softAssertion.assertTrue(
								stringValue.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)
										.replace("", "").replace(" ", "")),
								stringValue + " ui tab does not match with the expected excel values - "
										+ data.readData(sheetName, fileNameAndExtension).get(xlValues).replace("", "")
												.replace(" ", ""));
					}
					xlValues++;
				}
			}
			genericFunctions.logEvent("Verified the tabs are displayed and 'Address' page is default selected..");
			xlValues = 0;
			i = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyAboveTableAndBelowElements() {
		try {
			GenericFunctions.highlightElement(getButtonNewAddress());
			softAssertion.assertTrue(getButtonNewAddress().isEnabled(), "'New Address' button is not enabled.");
			softAssertion.assertTrue(getButtonNewAddress().isDisplayed(), "'New Address' button is not displayed.");
			softAssertion.assertTrue(getButtonNewAddress().getText().equals("New Address"),
					getButtonNewAddress().getText()
							+ " text does not match the expected text. Expected text is 'New Address'");

			genericFunctions.scrollToElement(getRightBottomPlusSignIconButton());
			GenericFunctions.highlightElement(getRightBottomPlusSignIconButton());
			softAssertion.assertTrue(getRightBottomPlusSignIconButton().isDisplayed(),
					"The '+ Icon' is not displayed...");
			Thread.sleep(2000);
			genericFunctions.scrollToElement(getButtonNewAddress());
			GenericFunctions.highlightElement(getRightBottomPlusSignIconButton());
			softAssertion.assertTrue(getRightBottomPlusSignIconButton().isDisplayed(),
					"The '+ Icon' is not displayed...");
			genericFunctions.logEvent("Right Side Bottom icon on the page is displayed all the times..");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyAddressListTableHeadersAndNoRecordsFoundMessage() {
		try {
			elementList = getLabelListTableHeaders();
			intValue = elementList.size();
			sheetName = "tableHeader";
			fileNameAndExtension = "addressPageExcelSheet.xls";

			GenericFunctions.highlightElement(getLabelTableName());
			softAssertion.assertTrue(getLabelTableName().getText().equals("Address List"), getLabelTableName().getText()
					+ " the table name does not match the expected table name , i.,e,. 'Address List'");
			genericFunctions.logEvent("Verified the table name !!!! ");

			while (xlValues < data.readData(sheetName, fileNameAndExtension).size()) {
				if ((i == 0) && (xlValues == 6)) {
					break;
				}
				for (i = 0; i < intValue; i++) {
					if ((i == 0) && (xlValues == 6)) {
						break;
					}

					if ((data.readData(sheetName, fileNameAndExtension).get(xlValues).length() > 1)
							&& (elementList.get(i).getText().length() > 0)) {
						GenericFunctions.highlightElement(elementList.get(i));
						if (elementList.get(i).getText().length() > 0) {
							stringValue = elementList.get(i).getText();
							softAssertion.assertTrue(
									stringValue.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
									stringValue + " ui tab does not match with the expected excel values - "
											+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
						} else {
							stringValue = elementList.get(i).getText().replace("", "");
							softAssertion.assertTrue(
									stringValue.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)
											.replace("", "").replace(" ", "")),
									stringValue + " ui tab does not match with the expected excel values - "
											+ data.readData(sheetName, fileNameAndExtension).get(xlValues)
													.replace("", "").replace(" ", ""));
						}
						xlValues++;
					}
				}
			}
			genericFunctions.logEvent("Table headers verified !!!! ");
			GenericFunctions.highlightElement(getDefaultMessageTable());
			softAssertion.assertTrue(getDefaultMessageTable().getText().equals("No Records Found"),
					getDefaultMessageTable().getText()
							+ " the table name does not match the expected table name , i.,e,. 'No Records Found'");
			genericFunctions.logEvent("Verified the default Message displayed !!!! ");
			xlValues = 0;
			i = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyNewAddressFormDropDowns() {
		try {

			sheetName = "dropdownsLabelsAndPlaceholders";
			fileNameAndExtension = "addressPageExcelSheet.xls";
			while (xlValues < data.readData(sheetName, fileNameAndExtension).size()) {
				for (i = 0; i < getLabelListDropdowns().size(); i++) {
					// Dropdown Label
					GenericFunctions.highlightElement(getLabelListDropdowns().get(i));

					softAssertion.assertTrue(
							getLabelListDropdowns().get(i).getText()
									.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
							getLabelListDropdowns().get(i).getText()
									+ " -UI dropdown Label does not match with the expected excel value , i.e., -"
									+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
					xlValues++;

					// Dropdown PLaceholder
					GenericFunctions.highlightElement(getListDropdowns().get(i));
					softAssertion.assertTrue(
							getListDropdowns().get(i).getAttribute("placeholder")
									.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
							getListDropdowns().get(i).getAttribute("placeholder")
									+ " -UI dropdown Label does not match with the expected excel value , i.e., -"
									+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
					xlValues++;
				}
			}
			genericFunctions.logEvent("Verified the dropdown values and default values");
			xlValues = 0;
			i = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyNewAddressFormTextBoxes() {
		try {
			sheetName = "textBoxLabelsAndPlaceholders";
			fileNameAndExtension = "addressPageExcelSheet.xls";
			while (xlValues < data.readData(sheetName, fileNameAndExtension).size()) {
				for (i = 0; i < getLabelListTextbox().size(); i++) {
					GenericFunctions.highlightElement(getLabelListTextbox().get(i));
					stringValue = getLabelListTextbox().get(i).getAttribute("innerHTML");
					stringValue = stringValue.replace("<span class=\"text-danger\">", "").replace("</span>", "")
							.replace("\n", "").replace(" ", "").trim();

					softAssertion.assertTrue(
							stringValue.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
							stringValue + " label of the text box does not match with the expected excel value - "
									+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
					xlValues++;
					GenericFunctions.highlightElement(getListTextbox().get(i));
					softAssertion.assertTrue(
							getListTextbox().get(i).getAttribute("placeholder")
									.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
							getListTextbox().get(i).getAttribute("placeholder")
									+ " placeholder of the text box does not match with the expected excel value - "
									+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
					xlValues++;
				}

			}
			genericFunctions.logEvent("Verified the textboxes in the address page.");
			xlValues = 0;
			i = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifybuttons() {
		try {
			GenericFunctions.highlightElement(getButtonSave());
			softAssertion.assertTrue(getButtonSave().isDisplayed(), "'Save Button' is not displayed");
			softAssertion.assertTrue(getButtonSave().getText().equals("Save"), getButtonSave().getText()
					+ " text does not match with the expected text , expected text is 'Save' .");

			GenericFunctions.highlightElement(getButtonCancel());
			softAssertion.assertTrue(getButtonCancel().isDisplayed(), "'Cancel Button' is not displayed");
			softAssertion.assertTrue(getButtonCancel().getText().equals("Cancel"), getButtonCancel().getText()
					+ " text does not match with the expected text , expected text is 'Cancel' .");
			genericFunctions.logEvent("Verified the save and cancel button .");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void navigateToNewAddressPage() {

		try {
			while (!getTabAddresses().isDisplayed()) {
			}
			Thread.sleep(800);
			getTabAddresses().click();
			while (!getButtonNewAddress().isDisplayed()) {
			}

			getButtonNewAddress().click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyBlankErrorMessages() {
		try {
			getButtonSave().click();
			sheetName = "blankErrorMessages";
			fileNameAndExtension = "addressPageExcelSheet.xls";
			while (xlValues < data.readData(sheetName, fileNameAndExtension).size()) {
				for (i = 0; i < getErrorMessageFields().size(); i++) {
					stringValue = getErrorMessageFields().get(i).getText();
					softAssertion.assertTrue(
							stringValue.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
							stringValue + " blank error message does not match with the excel value,i.e - "
									+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
					xlValues++;
				}
			}
			genericFunctions.logEvent("Verify the Blank Error Message.");
			xlValues = 0;
			i = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyAllFieldsErrorMessages() {
		try {

			driver.navigate().refresh();
			// navigates you back to Address Tab
			navigateToNewAddressPage();
			sheetName = "blankErrorMessages";
			fileNameAndExtension = "addressPageExcelSheet.xls";
			while (xlValues < data.readData(sheetName, fileNameAndExtension).size()) {

				/**
				 * Verify Address Type Error Message
				 */
				stringValue = getDropdownAddressType().findElement(By.xpath("../label")).getText();
				fillFormFieldsToCreateNewAddress(stringValue);
				GenericFunctions.highlightElement(getErrorMessageFields().get(0));
				softAssertion.assertTrue(
						getErrorMessageFields().get(0).getText()
								.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
						getErrorMessageFields().get(0).getText()
								+ " --> does not match with the expected excel value - "
								+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
				xlValues++;
				clearNewAddressElementFields(stringValue);

				/**
				 * Verify Address Line 1 Error Message
				 */
				stringValue = getTextboxAddressLine1().findElement(By.xpath("../label")).getText();
				fillFormFieldsToCreateNewAddress(stringValue);
				GenericFunctions.highlightElement(getErrorMessageFields().get(0));
				softAssertion.assertTrue(
						getErrorMessageFields().get(0).getText()
								.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
						getErrorMessageFields().get(0).getText()
								+ " --> does not match with the expected excel value - "
								+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
				xlValues++;
				clearNewAddressElementFields(stringValue);

				/**
				 * Verify state Error Message
				 */
				stringValue = getDropdownStateID().findElement(By.xpath("../label")).getText();
				fillFormFieldsToCreateNewAddress(stringValue);
				GenericFunctions.highlightElement(getErrorMessageFields().get(0));
				softAssertion.assertTrue(
						getErrorMessageFields().get(0).getText()
								.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
						getErrorMessageFields().get(0).getText()
								+ " --> does not match with the expected excel value - "
								+ data.readData(sheetName, fileNameAndExtension).get(xlValues));

				xlValues++;
				clearNewAddressElementFields(stringValue);

				/**
				 * Verify city Error Message
				 */
				stringValue = getDropdownCityID().findElement(By.xpath("../label")).getText();
				fillFormFieldsToCreateNewAddress(stringValue);
				GenericFunctions.highlightElement(getErrorMessageFields().get(0));
				softAssertion.assertTrue(
						getErrorMessageFields().get(0).getText()
								.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
						getErrorMessageFields().get(0).getText()
								+ " --> does not match with the expected excel value - "
								+ data.readData(sheetName, fileNameAndExtension).get(xlValues));

				xlValues++;
				clearNewAddressElementFields(stringValue);

				/**
				 * Verify zip Error Message
				 */
				stringValue = getTextboxZip().findElement(By.xpath("../label")).getText();
				fillFormFieldsToCreateNewAddress(stringValue);
				GenericFunctions.highlightElement(getErrorMessageFields().get(0));
				softAssertion.assertTrue(
						getErrorMessageFields().get(0).getText()
								.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
						getErrorMessageFields().get(0).getText()
								+ " --> does not match with the expected excel value - "
								+ data.readData(sheetName, fileNameAndExtension).get(xlValues));

				xlValues++;
				clearNewAddressElementFields(stringValue);

			}
			genericFunctions.logEvent("Verify the Blank Error Message.");
			xlValues = 0;
			i = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clearNewAddressElementFields(String... args) {

		try {
			/**
			 * clear dropdowns
			 */
			intValue = getListDropdowns().size();
			if ((stringValue.equals("Address Type *")) || (stringValue.equals("State *"))
					|| (stringValue.equals("City *"))) {
				for (int i = 0; i < (intValue - 1); i++) {
					element = getCrossClearDropdown();
					booleanValue = genericFunctions.verifyElementDisplayedOnDOM(element);
					if (booleanValue == true) {
						getCrossClearDropdown().click();
					}
				}
			} else {
				for (int i = 0; i < intValue; i++) {
					element = getCrossClearDropdown();
					booleanValue = genericFunctions.verifyElementDisplayedOnDOM(element);
					if (booleanValue == true) {
						getCrossClearDropdown().click();
					}
				}
			}

			/**
			 * clear textboxes
			 */
			for (int i = 0; i < getListTextbox().size(); i++) {
				intValue = getListTextbox().get(i).getAttribute("value").length();
				while (intValue > 0) {
					getListTextbox().get(i).sendKeys(Keys.BACK_SPACE);
					intValue--;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void fillFormFieldsToCreateNewAddress(String... args) {
		try {
			stringValue = args[0];
			/**
			 * select Address Type
			 */
			if (!stringValue.equals("Address Type *")) {
				getDropdownAddressType().click();
				while (!getListDropDownOptions().get(0).isDisplayed()) {
				}
				intValue = getListDropDownOptions().size();
				randomNumber = genericFunctions.generateRandomNumber(0, (intValue - 1));
				for (int i = 0; i < intValue; i++) {
					if (i == randomNumber) {
						getListDropDownOptions().get(i).click();
						break;
					}
				}
			}
			/**
			 * Select Address Line1
			 */
			if (!stringValue.equals("Address Line 1 *")) {
				getTextboxAddressLine1().sendKeys(genericFunctions.generaterandomString(5));
				getTextboxAddressLine2().sendKeys(genericFunctions.generaterandomString(5));
			}
			/**
			 * select stateID
			 */
			if (!stringValue.equals("State *")) {
				getDropdownStateID().click();
				while (!getListDropDownOptions().get(0).isDisplayed()) {
				}
				intValue = getListDropDownOptions().size();
				randomNumber = genericFunctions.generateRandomNumber(0, (intValue - 1));
				for (int i = 0; i < intValue; i++) {
					if (i == randomNumber) {
						getListDropDownOptions().get(i).click();
						break;
					}
				}
			}
			Thread.sleep(1000);
			/**
			 * select cityID
			 */
			if (!stringValue.equals("City *")) {
				getDropdownCityID().click();
				while (!getListDropDownOptions().get(0).isDisplayed()) {
				}
				intValue = getListDropDownOptions().size();
				randomNumber = genericFunctions.generateRandomNumber(0, (intValue - 1));
				for (int i = 0; i < intValue; i++) {
					if (i == randomNumber) {
						getListDropDownOptions().get(i).click();
						break;
					}
				}
			}
			/**
			 * zip
			 */
			if (!stringValue.equals("Zip *")) {
				getTextboxZip().sendKeys(Float.toString(genericFunctions.generateRandomNumber(111111111, 999999999)));
			}

			getButtonSave().click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public LinkedHashMap<Object, Object> fillNewAddressForm(Object... args) {

		try {

			sheetName = "tableHeader";
			fileNameAndExtension = "addressPageExcelSheet.xls";
			while (xlValues < (data.readData(sheetName, fileNameAndExtension).size() - 6)) {
				/**
				 * Select Address Type
				 */
				getDropdownAddressType().click();
				while (!getListDropDownOptions().get(0).isDisplayed()) {
				}
				intValue = getListDropDownOptions().size();

				if (args[0].equals("dontSelectPhysicalAddress")) {
					randomNumber = genericFunctions.generateRandomNumber(0, (intValue - 2));
				}
				if (args[0].equals("selectPhysicalAddress")) {
					randomNumber = intValue - 1;
				}
				if (args[0].toString().length() == 0) {
					randomNumber = genericFunctions.generateRandomNumber(0, intValue);
				}
				for (int i = 0; i < intValue; i++) {
					if (i == randomNumber) {
						stringValue = getListDropDownOptions().get(i).getText();
						getListDropDownOptions().get(i).click();
						break;
					}
				}
				linkedHashMap.put(data.readData(sheetName, fileNameAndExtension).get(xlValues), stringValue);
				xlValues++;

				/**
				 * Fill Address Line 1
				 */
				getTextboxAddressLine1().sendKeys(genericFunctions.generaterandomString(7));
				/**
				 * Fill Address Line 2
				 */
				getTextboxAddressLine2().sendKeys(genericFunctions.generaterandomString(7));
				stringValue = getTextboxAddressLine1().getAttribute("value") + ""
						+ getTextboxAddressLine2().getAttribute("value");
				linkedHashMap.put(data.readData(sheetName, fileNameAndExtension).get(xlValues), stringValue);
				xlValues++;

				/**
				 * Select State Value
				 */
				getDropdownStateID().click();
				while (!getListDropDownOptions().get(0).isDisplayed()) {
				}
				intValue = getListDropDownOptions().size();
				randomNumber = genericFunctions.generateRandomNumber(0, (intValue - 1));
				for (int i = 0; i < intValue; i++) {
					if (i == randomNumber) {
						stringValue = getListDropDownOptions().get(i).getText();
						getListDropDownOptions().get(i).click();
						break;
					}
				}
				linkedHashMap.put(data.readData(sheetName, fileNameAndExtension).get(xlValues), stringValue);
				xlValues++;

				/**
				 * select city value
				 */
				getDropdownCityID().click();
				while (!getListDropDownOptions().get(0).isDisplayed()) {
				}
				intValue = getListDropDownOptions().size();
				randomNumber = genericFunctions.generateRandomNumber(0, (intValue - 1));
				for (int i = 0; i < intValue; i++) {
					if (i == randomNumber) {
						stringValue = getListDropDownOptions().get(i).getText();
						getListDropDownOptions().get(i).click();
						break;
					}
				}
				linkedHashMap.put(data.readData(sheetName, fileNameAndExtension).get(xlValues), stringValue);
				xlValues++;

				/**
				 * zip
				 */
				stringValue = genericFunctions.generateRandomNumber(1111, 9999) + ""
						+ genericFunctions.generateRandomNumber(11121, 99299);

				if (stringValue.length() != 9) {
					stringValue = "987678767";
				}
				getTextboxZip().sendKeys(stringValue);
				linkedHashMap.put(data.readData(sheetName, fileNameAndExtension).get(xlValues), stringValue);
				xlValues++;
			}
			/**
			 * click on save button
			 */
			getButtonSave().click();

			while (!getToasterMessage().isDisplayed()) {
			}
			softAssertion.assertTrue(getToasterMessage().isDisplayed(),
					"The New Address record saved successfully toaster message is not displayed...");
			xlValues = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return linkedHashMap;
	}

	public void verifyTheNewAddedAddressWithDB(LinkedHashMap<Object, Object> linkedHashMap1,
			LinkedHashMap<Object, Object> linkedHashMap2) {

		try {
			Object uiValue, dbValue;
			Iterator<Object> uiIterator = linkedHashMap1.keySet().iterator();
			Iterator<Object> dbIterator = linkedHashMap2.keySet().iterator();
			while (uiIterator.hasNext()) {
				while (dbIterator.hasNext()) {
					uiValue = linkedHashMap1.get(uiIterator.next());
					dbValue = linkedHashMap2.get(dbIterator.next());
					softAssertion.assertTrue(uiValue.toString().equals(dbValue.toString()), uiValue.toString()
							+ " - ui value does not match with the expected db value - " + dbValue.toString());
					uiIterator.hasNext();
				}
			}
			genericFunctions.logEvent("Verified the New Address added with the database value ...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyPostDropDownOptions(LinkedHashMap<Object, Object> linkedHashMap) {
		try {

			/**
			 * navigate Back to 'New Address' collapsal form
			 */
			getButtonNewAddress().click();
			while (!getDropdownAddressType().isDisplayed()) {
			}
			GenericFunctions.highlightElement(getDropdownAddressType());
			getDropdownAddressType().click();

			while (!getListDropDownOptions().get(0).isDisplayed()) {
			}

			/**
			 * Assert that dropdown size is 2 now since the dropdown size auto
			 * dicrements by the dropdown value selected
			 */
			softAssertion.assertTrue(getListDropDownOptions().size() < 3,
					"The 'Address Type' dropdown size is more than or egaul to 3. At present dropdown size is -"
							+ getListDropDownOptions().size());
			elementList = getListDropDownOptions();
			/**
			 * verify That The dropdown values does not have the preiously
			 * selected dropdown value
			 */
			for (int i = 0; i < elementList.size(); i++) {
				GenericFunctions.highlightElement(elementList.get(i));
				softAssertion.assertTrue(
						!elementList.get(i).getText().equals(linkedHashMap.values().toArray()[0].toString()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyAddedPhysicalAddressOnFailityListingPage(LinkedHashMap<Object, Object> linkedHashMap3) {
		try {
			driver.navigate().back();
			Thread.sleep(2000);
			softAssertion.assertTrue(
					getListFirstRow().get(1).getText().equals(linkedHashMap3.values().toArray()[2].toString().trim()),
					getListFirstRow().get(1).getText()
							+ " - UI state value does not match with the Physical Address given . Expected State value is -"
							+ linkedHashMap3.values().toArray()[2].toString().trim());

			softAssertion.assertTrue(
					getListFirstRow().get(2).getText().equals(linkedHashMap3.values().toArray()[3].toString().trim()),
					getListFirstRow().get(2).getText()
							+ " - UI City value does not match with the Physical Address given . Expected City value is -"
							+ linkedHashMap3.values().toArray()[3].toString().trim());

			genericFunctions.logEvent(
					"Verified the added physical address 'State' and 'City' displayed on UI is similar to the address added in address field. ");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
