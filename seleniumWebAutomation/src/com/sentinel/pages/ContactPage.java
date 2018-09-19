package com.sentinel.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.sentinel.databaseUtility.ProjectDatabaseQueries;
import com.sentinel.driver.WebDriverTestBase;
import com.sentinel.locators.contactPageLocators;
import com.sentinel.locators.facilityPageLocators;
import com.sentinel.locators.facilityPageLocators.facilityListingLocators;
import com.sentinel.locators.genericLocators;
import com.sentinel.locators.thirdPartySiteLocators;
import com.sentinel.utils.ExcelUtility;
import com.sentinel.utils.GenericFunctions;
import com.sentinel.utils.SoftAssertUtil;

public class ContactPage extends WebDriverTestBase {

	GenericFunctions genericFunctions = new GenericFunctions();
	ExcelUtility data = new ExcelUtility();
	ProjectDatabaseQueries projectDatabaseQueries = new ProjectDatabaseQueries();
	/**
	 * HomePage homePage=new HomePage();
	 */
	Actions action = new Actions(WebDriverTestBase.driver);
	Select select = null;
	LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
	List<WebElement> elementList = null, elementList2 = null;
	WebElement element = null;
	String stringValue = null, fileNameAndExtension = null, sheetName = null, stringValue1 = null, stringValue2 = null;
	int intValue = 0, i = 0, j = 0, randomNumber = 0;
	String[] stringValueArray = null;
	int xlValues = 0;
	boolean booleanValue;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	/**
	 * This is the constructor
	 */
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = facilityListingLocators.LOC_COLOUMN_CORPORATENAMEFACILITYNAME_XPATH)
	private List<WebElement> coloumnCorporateNameFacilityName;

	public List<WebElement> getColoumnCorporateNameFacilityName() {
		return coloumnCorporateNameFacilityName;
	}

	@FindBy(xpath = facilityPageLocators.facilityListingLocators.LOC_LIST_EDIT_XPATH)
	@CacheLookup
	private List<WebElement> listEditButton;

	public List<WebElement> getListEditButton() {
		return listEditButton;
	}

	@FindBy(xpath = contactPageLocators.tableContactPageLocators.LOC_TAB_CONTACT_XPATH)
	@CacheLookup
	private WebElement tabContact;

	@FindBy(xpath = genericLocators.locators.LOC_COLLAPSALBUTTON_NEW_XPATH)
	private WebElement buttonNewContact;

	@FindBy(xpath = contactPageLocators.linkExpiredLocators.LOC_LINK_CLICKHERE_XPATH)
	@CacheLookup
	private WebElement linkExpiredPageClickHere;

	@FindBy(xpath = contactPageLocators.linkExpiredLocators.LOC_LINK_SUPPORTMAIL_XPATH)
	@CacheLookup
	private WebElement supportEmailLink;

	@FindBy(xpath = contactPageLocators.tableContactPageLocators.LOC_TABLEDATA_NEWCONTACT_XPATH)
	private List<WebElement> firstRowTableData;

	@FindBy(xpath = genericLocators.tableHeadersList.LOC_LABELLIST_TABLEHEADER_XPATH)
	@CacheLookup
	private List<WebElement> labelListTableHeaders;

	@FindBy(xpath = genericLocators.tableHeadersList.LOC_LABEL_TABLENAME_XPATH)
	@CacheLookup
	private WebElement labelTableName;

	@FindBy(xpath = genericLocators.tableHeadersList.LOC_DEFAULTMESSAGE_TABLE_XPATH)
	@CacheLookup
	private WebElement defaultMessageTable;

	@FindBy(xpath = genericLocators.locators.LOC_ICONBUTTON_EDIT_XPATH)
	private WebElement iconButtonEdit;

	@FindBy(xpath = genericLocators.formFieldsList.LOC_LABELLIST_TEXTBOX_XPATH)
	@CacheLookup
	private List<WebElement> labelListTextbox;

	@FindBy(xpath = genericLocators.formFieldsList.LOC_LIST_TEXTBOX_XPATH)
	@CacheLookup
	private List<WebElement> listTextbox;

	@FindBy(xpath = thirdPartySiteLocators.mailinatorMailBoxLocators.LOC_TEXTBOX_CHECKANYINBOX_XPATH)
	private WebElement textboxCheckAnyInbox;

	@FindBy(xpath = thirdPartySiteLocators.mailinatorMailBoxLocators.LOC_TEXTLINK_GENERATEDMAIL_XPATH)
	private WebElement textLinkGeneratedMail;

	@FindBy(xpath = thirdPartySiteLocators.mailinatorMailBoxLocators.LOC_IFRAME_EMAILBODY_XPATH)
	private WebElement iframeMailinatorEmailBody;

	@FindBy(xpath = thirdPartySiteLocators.mailinatorMailBoxLocators.LOC_TEXT_EMAILBODY_XPATH)
	private WebElement textMailinatorEmail;

	@FindBy(xpath = thirdPartySiteLocators.mailinatorMailBoxLocators.LOC_LINK_CLICKHERE_XPATH)
	private WebElement linkClickHere;

	@FindBy(xpath = genericLocators.locators.LOC_TITLE_XPATH)
	private WebElement sidePanelTitle;

	@FindBy(xpath = genericLocators.locators.LOC_INFO_LINKEXPIRED_XPATH)
	@CacheLookup
	private WebElement infoLinkExpired;

	@FindBy(xpath = genericLocators.formFieldsList.LOC_LABELLIST_DROPDOWNS_XPATH)
	@CacheLookup
	private List<WebElement> labelListDropdowns;

	@FindBy(xpath = genericLocators.formFieldsList.LOC_LIST_DROPDOWN_XPATH)
	@CacheLookup
	private List<WebElement> listDropdowns;

	@FindBy(xpath = contactPageLocators.newContactPageLocators.LOC_TEXTBOX_UPLOADPROFILEIMAGE_XPATH)
	@CacheLookup
	private WebElement textboxUploadProfileImage;

	@FindBy(xpath = contactPageLocators.newContactPageLocators.LOC_LABEL_UPLOADPROFILEIMAGE_XPATH)
	@CacheLookup
	private WebElement labelUploadProfileImage;

	@FindBy(xpath = contactPageLocators.newContactPageLocators.LOC_BUTTON_UPLOADPROFILEIMAGE_XPATH)
	@CacheLookup
	private WebElement buttonUploadProfileImage;

	@FindBy(xpath = contactPageLocators.newContactPageLocators.LOC_INFOTEXT_UPLOADPROFILEIMAGE_XPATH)
	@CacheLookup
	private WebElement infotextUploadProfileImage;

	@FindBy(xpath = genericLocators.locators.LOC_RADIOBUTTON_ACTIVE_XPATH)
	@CacheLookup
	private WebElement radioButtonActive;

	@FindBy(xpath = genericLocators.locators.LOC_RADIOBUTTON_INACTIVE_XPATH)
	@CacheLookup
	private WebElement radioButtonInactive;

	@FindBy(xpath = genericLocators.formFieldsList.LOC_BUTTON_SAVE_XPATH)
	private WebElement buttonSave;

	@FindBy(xpath = genericLocators.formFieldsList.LOC_BUTTON_CANCEL_XPATH)
	@CacheLookup
	private WebElement buttonCancel;

	@FindBy(xpath = contactPageLocators.newContactPageLocators.LOC_TEXTBOX_USERNAME_XPATH)
	private WebElement textboxUserName;

	@FindBy(xpath = contactPageLocators.newContactPageLocators.LOC_TEXTBOX_FIRSTNAME_XPATH)
	private WebElement textboxFirstName;

	@FindBy(xpath = contactPageLocators.newContactPageLocators.LOC_TEXTBOX_LASTNAME_XPATH)
	private WebElement textboxLastName;

	@FindBy(xpath = contactPageLocators.newContactPageLocators.LOC_TEXTBOX_EMAIL_XPATH)
	private WebElement textboxEmail;

	@FindBy(xpath = contactPageLocators.newContactPageLocators.LOC_TEXTBOX_CONTACTPHONE_XPATH)
	private WebElement textboxContactPhone;

	@FindBy(xpath = genericLocators.formFieldsList.LOC_ERRORMESSAGELIST_XPATH)
	private List<WebElement> errorMessageFields;

	@FindBy(xpath = contactPageLocators.newContactPageLocators.LOC_DROPDOOWN_SALUTATION_XPATH)
	@CacheLookup
	private WebElement dropdownSalutation;

	@FindBy(xpath = contactPageLocators.newContactPageLocators.LOC_DROPDOOWN_ISBILLING_XPATH)
	private WebElement dropdownIsBilling;

	@FindBy(xpath = contactPageLocators.newContactPageLocators.LOC_DROPDOOWN_DEPARTMENT_XPATH)
	private WebElement dropdownDepartment;

	@FindBy(xpath = contactPageLocators.newContactPageLocators.LOC_DROPDOOWNLIST_XPATH)
	private List<WebElement> dropdownList;

	@FindBy(xpath = contactPageLocators.newContactPageLocators.LOC_TEXTBOX_EXTENSION_XPATH)
	@CacheLookup
	private WebElement textboxExtension;

	@FindBy(xpath = contactPageLocators.newContactPageLocators.LOC_TEXTBOX_BUSINESSPHONE_XPATH)
	private WebElement textboxBusinessPhone;

	@FindBy(xpath = contactPageLocators.newContactPageLocators.LOC_TEXTBOX_FAX_XPATH)
	@CacheLookup
	private WebElement textboxFax;

	@FindBy(xpath = contactPageLocators.newContactPageLocators.LOC_TEXTBOX_TITLE_XPATH)
	@CacheLookup
	private WebElement textboxTitle;

	@FindBy(xpath = contactPageLocators.newContactPageLocators.LOC_LABEL_RESENDUSERNAME_XPATH)
	@CacheLookup
	private WebElement labelResendUsername;

	@FindBy(xpath = contactPageLocators.newContactPageLocators.LOC_CHECKBOX_RESENDUSERNAME_XPATH)
	@CacheLookup
	private WebElement checkboxResendUsername;

	@FindBy(xpath = contactPageLocators.newContactPageLocators.LOC_LABEL_RESETPASSWORD_XPATH)
	@CacheLookup
	private WebElement labelResetPassword;

	@FindBy(xpath = contactPageLocators.newContactPageLocators.LOC_CHECKBOX_RESETPASSWORD_XPATH)
	@CacheLookup
	private WebElement checkboxResetPassword;

	public WebElement getLabelResendUsername() {
		return labelResendUsername;
	}

	public WebElement getLabelResetPassword() {
		return labelResetPassword;
	}

	public WebElement getCheckboxResetPassword() {
		return checkboxResetPassword;
	}

	public WebElement getCheckboxResendUsername() {
		return checkboxResendUsername;
	}

	public WebElement getIconButtonEdit() {
		return iconButtonEdit;
	}

	public WebElement getInfoLinkExpired() {
		return infoLinkExpired;
	}

	public WebElement getSidePanelTitle() {
		return sidePanelTitle;
	}

	public WebElement getTextboxTitle() {
		return textboxTitle;
	}

	public WebElement getDropdownSalutation() {
		return dropdownSalutation;
	}

	public WebElement getDropdownDepartment() {
		return dropdownDepartment;
	}

	public WebElement getDropdownIsBilling() {
		return dropdownIsBilling;
	}

	public List<WebElement> getDropdownList() {
		return dropdownList;
	}

	public WebElement getTextboxBusinessPhone() {
		return textboxBusinessPhone;
	}

	public WebElement getTextboxExtension() {
		return textboxExtension;
	}

	public WebElement getTextboxFax() {
		return textboxFax;
	}

	public List<WebElement> getErrorMessageFields() {
		return errorMessageFields;
	}

	public WebElement getTextboxUserName() {
		return textboxUserName;
	}

	public WebElement getTextboxFirstName() {
		return textboxFirstName;
	}

	public WebElement getTextboxLastName() {
		return textboxLastName;
	}

	public WebElement getTextboxEmail() {
		return textboxEmail;
	}

	public WebElement getTextboxContactPhone() {
		return textboxContactPhone;
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

	public WebElement getTextboxCheckAnyInbox() {
		return textboxCheckAnyInbox;
	}

	public WebElement getTextLinkGeneratedMail() {
		return textLinkGeneratedMail;
	}

	public WebElement getIframeMailinatorEmailBody() {
		return iframeMailinatorEmailBody;
	}

	public WebElement getTextMailinatorEmail() {
		return textMailinatorEmail;
	}

	public WebElement getRadioButtonInactive() {
		return radioButtonInactive;
	}

	public WebElement getLinkClickHere() {
		return linkClickHere;
	}

	public WebElement getLinkExpiredPageClickHere() {
		return linkExpiredPageClickHere;
	}

	public WebElement getSupportEmailLink() {
		return supportEmailLink;
	}

	public WebElement getInfotextUploadProfileImage() {
		return infotextUploadProfileImage;
	}

	public WebElement getButtonUploadProfileImage() {
		return buttonUploadProfileImage;
	}

	public WebElement getLabelUploadProfileImage() {
		return labelUploadProfileImage;
	}

	public WebElement getTextboxUploadProfileImage() {
		return textboxUploadProfileImage;
	}

	public List<WebElement> getLabelListDropdowns() {
		return labelListDropdowns;
	}

	public List<WebElement> getListDropdowns() {
		return listDropdowns;
	}

	public List<WebElement> getLabelListTextbox() {
		return labelListTextbox;
	}

	public List<WebElement> getListTextbox() {
		return listTextbox;
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

	public List<WebElement> getFirstRowTableData() {
		return firstRowTableData;
	}

	public WebElement getButtonNewContact() {
		return buttonNewContact;
	}

	public WebElement getTabContact() {
		return tabContact;
	}

	public void navigateToContactTab() {
		try {

			Thread.sleep(2000);
			getTabContact().click();
			while (!getButtonNewContact().isDisplayed()) {
			}
			Thread.sleep(1000);
			getButtonNewContact().click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyContactListTableHeadersAndNoRecordsFoundMessage() {
		try {
			elementList = getLabelListTableHeaders();
			intValue = elementList.size();
			sheetName = "tableHeader";
			fileNameAndExtension = "contactPageExcelSheet.xls";
			genericFunctions.scrollToElement(getLabelTableName());
			GenericFunctions.highlightElement(getLabelTableName());
			SoftAssertUtil.myAssert().assertTrue(getLabelTableName().getText().equals("Contact List"),
					getLabelTableName().getText()
							+ " the table name does not match the expected table name , i.,e,. 'Contact List'");
			genericFunctions.logEvent("Verified the table name !!!! ");
			logger.debug("::Verifing Contact list table header and no recrd found Message ::");
			logger.debug("UI  value size -" + intValue);
			logger.debug("XL  value size -" + data.readData(sheetName, fileNameAndExtension).size());

			while (xlValues < data.readData(sheetName, fileNameAndExtension).size()) {
				if ((i == 0) && (xlValues == 7)) {
					break;
				}
				for (i = 0; i < intValue; i++) {
					if ((i == 0) && (xlValues == 7)) {
						break;
					}
					if ((data.readData(sheetName, fileNameAndExtension).get(xlValues).length() > 1)
							&& (elementList.get(i).getText().length() > 0)) {
						genericFunctions.scrollToElement(elementList.get(i));
						genericFunctions.scrollToElement(getDefaultMessageTable());
						if (elementList.get(i).getText().length() > 0) {
							stringValue = elementList.get(i).getText();
							SoftAssertUtil.myAssert().assertTrue(
									stringValue.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
									stringValue + " ui tab does not match with the expected excel values - "
											+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
						} else {
							stringValue = elementList.get(i).getText().replace("", "");
							SoftAssertUtil.myAssert().assertTrue(
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
			genericFunctions.logEvent("**Table headers verified !!!! **");
			GenericFunctions.highlightElement(getDefaultMessageTable());
			SoftAssertUtil.myAssert().assertTrue(getDefaultMessageTable().getText().equals("No Records Found"),
					getDefaultMessageTable().getText()
							+ " the table name does not match the expected table name , i.,e,. 'No Records Found'");
			genericFunctions.logEvent("Verified the default Message displayed !!!! ");
			xlValues = 0;
			i = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyNewContactFormTextBoxes() {
		try {
			sheetName = "textBoxLabelsAndPlaceholders";
			fileNameAndExtension = "contactPageExcelSheet.xls";
			intValue = getLabelListTextbox().size();
			logger.debug("::Verifing textboxes labels and PlaceHolders on New Contact page::");
			logger.debug("UI  value size -" + intValue);
			logger.debug("XL  value size -" + data.readData(sheetName, fileNameAndExtension).size());

			while (xlValues < data.readData(sheetName, fileNameAndExtension).size()) {
				for (i = 0; i < intValue; i++) {
					GenericFunctions.highlightElement(getLabelListTextbox().get(i));
					stringValue = getLabelListTextbox().get(i).getAttribute("innerHTML");
					stringValue = stringValue.replace("<span class=\"text-danger\">", "").replace("</span>", "")
							.replace("\n", "").replace(" ", "").trim();
					logger.debug(i + " -UI value :-" + stringValue);
					logger.debug(
							xlValues + " -XL value :-" + data.readData(sheetName, fileNameAndExtension).get(xlValues));
					SoftAssertUtil.myAssert().assertTrue(
							stringValue.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
							stringValue + " label of the text box does not match with the expected excel value - "
									+ data.readData(sheetName, fileNameAndExtension).get(xlValues));

					xlValues++;
					GenericFunctions.highlightElement(getListTextbox().get(i));

					logger.debug(i + " -UI placeholder :-" + getListTextbox().get(i).getAttribute("placeholder"));
					logger.debug(xlValues + " -XL placeholder :-"
							+ data.readData(sheetName, fileNameAndExtension).get(xlValues));

					SoftAssertUtil.myAssert().assertTrue(
							getListTextbox().get(i).getAttribute("placeholder")
									.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
							getListTextbox().get(i).getAttribute("placeholder")
									+ " placeholder of the text box does not match with the expected excel value - "
									+ data.readData(sheetName, fileNameAndExtension).get(xlValues));

					xlValues++;
					if ((stringValue.equals("Fax"))
							&& (getListTextbox().get(i).getAttribute("placeholder").equals("(XXX)XXX-XXXX"))) {
						break;
					}
				}
			}

			genericFunctions.logEvent("**Verified the textboxes in the address page.**");
			xlValues = 0;
			i = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyNewContactFormDropDowns() {
		try {
			sheetName = "dropdownsLabelsAndPlaceholders";
			fileNameAndExtension = "contactPageExcelSheet.xls";
			intValue = getLabelListDropdowns().size();
			logger.debug("::Verifing dropdown labels and PlaceHolders on New Contact page::");
			logger.debug("UI  value size -" + intValue);
			logger.debug("XL  value size -" + data.readData(sheetName, fileNameAndExtension).size());

			while (xlValues < data.readData(sheetName, fileNameAndExtension).size()) {
				for (i = 0; i < (intValue); i++) {
					// Dropdown Label
					GenericFunctions.highlightElement(getLabelListDropdowns().get(i));
					logger.debug(i + " -dropdown Label -" + getLabelListDropdowns().get(i).getText().trim());
					logger.debug(
							xlValues + " -XL value :-" + data.readData(sheetName, fileNameAndExtension).get(xlValues));

					SoftAssertUtil.myAssert()
							.assertTrue(
									getLabelListDropdowns().get(i).getText().trim()
											.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)
													.trim()),
									getLabelListDropdowns().get(i).getText()
											+ " -UI dropdown Label does not match with the expected excel value , i.e., -"
											+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
					xlValues++;

					// Dropdown Placeholder

					GenericFunctions.highlightElement(getListDropdowns().get(i));
					try {
						stringValue = getListDropdowns().get(i).getAttribute("placeholder");
						stringValue.length();
					} catch (Exception e) {
						/**
						 * catch the exception and make string null
						 */
						stringValue = "null";
					}
					logger.debug(i + " - 1 dropdown Label -" + stringValue);
					logger.debug(xlValues + " - 1 XL value :-"
							+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
					SoftAssertUtil.myAssert().assertTrue(
							stringValue.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues).trim()),
							stringValue + " -UI dropdown Label does not match with the expected excel value , i.e., -"
									+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
					xlValues++;
				}
			}

			genericFunctions.logEvent("**Verified the dropdown values and default values**");
			xlValues = 0;
			i = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyUploadProfileImage() {
		try {
			// 'Upload Profile Image' label text
			GenericFunctions.highlightElement(getLabelUploadProfileImage());
			SoftAssertUtil.myAssert().assertTrue(getLabelUploadProfileImage().isDisplayed(),
					"'Upload Profile Image' label is displayed.");
			SoftAssertUtil.myAssert().assertTrue(
					getLabelUploadProfileImage().getText().trim().equals("Upload Profile Image"),
					getLabelUploadProfileImage().getText()
							+ "is not as expected . Expected label is -'Upload Profile Image'.");
			// 'Upload Profile Image' textbox
			GenericFunctions.highlightElement(getTextboxUploadProfileImage());
			SoftAssertUtil.myAssert().assertTrue(getTextboxUploadProfileImage().isDisplayed(),
					"'Upload Profile Image' textbox is displayed.");

			// 'Upload Profile Image' button
			GenericFunctions.highlightElement(getButtonUploadProfileImage());
			SoftAssertUtil.myAssert().assertTrue(getButtonUploadProfileImage().isDisplayed(),
					"'Upload Profile Image' button is displayed.");
			SoftAssertUtil.myAssert().assertTrue(getButtonUploadProfileImage().isEnabled(),
					"'Upload Profile Image' button is enabled.");
			// 'Upload Profile Image' textbox
			GenericFunctions.highlightElement(getInfotextUploadProfileImage());
			SoftAssertUtil.myAssert().assertTrue(getInfotextUploadProfileImage().isDisplayed(),
					"'Upload Profile Image' infotext is displayed.");
			genericFunctions.logEvent("'Upload Profile Image' fields are verified....");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyRadioButtons() {
		try {
			GenericFunctions.highlightElement(getRadioButtonActive());
			SoftAssertUtil.myAssert().assertTrue(getRadioButtonActive().isSelected(),
					"'Active' radio button is by default IS NOT selected.");
			GenericFunctions.highlightElement(getRadioButtonActive().findElement(By.xpath("following-sibling::label")));
			SoftAssertUtil.myAssert().assertTrue(
					getRadioButtonActive().findElement(By.xpath("following-sibling::label")).getText().equals("Active"),
					"'Active' radio button label is not displayed as 'Active'");

			GenericFunctions.highlightElement(getRadioButtonInactive());
			SoftAssertUtil.myAssert().assertTrue(!getRadioButtonInactive().isSelected(),
					"'Inactive' radio button is by default IS selected.");
			GenericFunctions
					.highlightElement(getRadioButtonInactive().findElement(By.xpath("following-sibling::label")));
			SoftAssertUtil.myAssert().assertTrue(getRadioButtonInactive()
					.findElement(By.xpath("following-sibling::label")).getText().equals("Inactive"),
					"'Inactive' radio button label is not displayed as 'Inactive'");

			genericFunctions.logEvent("Verified the radio button label and default selected element ...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyButtons() {
		try {
			genericFunctions.scrollToElement(getButtonSave());
			GenericFunctions.highlightElement(getButtonSave());
			SoftAssertUtil.myAssert().assertTrue(getButtonSave().isDisplayed(), "'Save'  button  IS NOT Displayed.");
			GenericFunctions.highlightElement(getButtonSave());
			SoftAssertUtil.myAssert().assertTrue(getButtonSave().getText().equals("Save"),
					"'Save' button label is not displayed as 'Save'");

			genericFunctions.scrollToElement(getButtonCancel());
			GenericFunctions.highlightElement(getButtonCancel());
			SoftAssertUtil.myAssert().assertTrue(getButtonCancel().isDisplayed(), "'Cancel'button  IS NOT Displayed.");
			GenericFunctions.highlightElement(getButtonCancel());
			SoftAssertUtil.myAssert().assertTrue(getButtonCancel().getText().equals("Cancel"),
					"'Cancel'  button label is not displayed as 'Cancel'");

			genericFunctions.logEvent("Verified the 'Save' and 'Cancel' button label and displayed ...");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyBlankErrorMessages() {
		try {
			fillContactForm("Mandatory Fields", "verifingBlankErrorMessages");
			while (!getErrorMessageFields().get(0).isDisplayed()) {
			}
			intValue = getErrorMessageFields().size();
			sheetName = "blankErrorMessages";
			fileNameAndExtension = "contactPageExcelSheet.xls";
			while (xlValues < data.readData(sheetName, fileNameAndExtension).size()) {
				for (int i = 0; i < intValue; i++) {
					GenericFunctions.highlightElement(getErrorMessageFields().get(i));
					Assert.assertTrue(
							data.readData(sheetName, fileNameAndExtension).get(xlValues)
									.equals(getErrorMessageFields().get(i).getText()),
							data.readData(sheetName, fileNameAndExtension).get(xlValues)
									+ " xl value does not match with the UI Value -"
									+ getErrorMessageFields().get(i).getText());
					xlValues++;
				}

			}
			genericFunctions.logEvent("Verified the Blank Error Messages for Contacts Tab");
			xlValues = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public LinkedHashMap<Object, Object> fillContactForm(String... args) throws InterruptedException {

		if (args.length == 2) {
			stringValue = args[0];
			stringValue1 = args[1];
		} else {
			stringValue = args[0];
			stringValue1 = "Test in DB";
		}

		switch (stringValue) {
		case "Mandatory Fields":
			while (!getTextboxUserName().isDisplayed()) {
			}
			Thread.sleep(1000);
			if (!stringValue1.equals("verifingBlankErrorMessages")) {
				// userName
				stringValue = "userName" + genericFunctions.generaterandomString(5);
				getTextboxUserName().clear();
				getTextboxUserName().sendKeys(stringValue);
				linkedHashMap.put("userName", stringValue);
				// firstName
				stringValue = "firstName_" + genericFunctions.generaterandomString(5);
				getTextboxFirstName().clear();
				getTextboxFirstName().sendKeys(stringValue);
				linkedHashMap.put("firstName", stringValue);
				// lastName
				stringValue = "lastName_" + genericFunctions.generaterandomString(5);
				getTextboxLastName().clear();
				getTextboxLastName().sendKeys(stringValue);
				linkedHashMap.put("lastName", stringValue);
				// email
				stringValue = "email_" + genericFunctions.generateRandomEmail();
				getTextboxEmail().clear();
				getTextboxEmail().sendKeys(stringValue);
				linkedHashMap.put("email", stringValue);
				// contactPhone
				stringValue = genericFunctions.generateRandomNumber(11111, 99999) + ""
						+ genericFunctions.generateRandomNumber(11111, 99999);
				getTextboxContactPhone().clear();
				getTextboxContactPhone().sendKeys(stringValue);
				linkedHashMap.put("contactPhone", stringValue);

			} else {
				// userName
				getTextboxUserName().sendKeys(Keys.TAB);
				// firstName
				getTextboxFirstName().sendKeys(Keys.TAB);
				// lastName
				getTextboxLastName().sendKeys(Keys.TAB);
				// email
				getTextboxEmail().sendKeys(Keys.TAB);
				// contactPhone
				getTextboxContactPhone().sendKeys(Keys.TAB);
			}

			break;

		case "All Fields":
			// username field
			getTextboxUserName().clear();
			if (stringValue1.equals("test_Username_Validations")) {
				stringValue = genericFunctions.generateCustomizedRandomString(3, "abc89&0.,-'/?\"(}_ ");
			} else {
				stringValue = genericFunctions.generateCustomizedRandomString(8,
						"abcdefghijklmnopqrstuvwxyz1234567890.,-'/?&\"()_");
			}
			getTextboxUserName().sendKeys(stringValue);
			stringValue = getTextboxUserName().getAttribute("value");
			linkedHashMap.put("userName", stringValue);

			// salutation
			getDropdownSalutation().click();
			while (!getDropdownList().get(0).isDisplayed()) {
			}
			intValue = genericFunctions.generateRandomNumber(0, 2);
			for (int i = 0; i < getDropdownList().size(); i++) {
				if (i == intValue) {
					stringValue = getDropdownList().get(i).getText();
					getDropdownList().get(i).click();
					break;
				}
			}
			linkedHashMap.put("salutation", stringValue);

			// Title-->min 2-40 characters
			getTextboxTitle().clear();
			if (stringValue1.equals("test_title_Validations")) {
				stringValue = genericFunctions.generateCustomizedRandomString(1, "abc89&0.,-'/?\"()_");
			} else {
				stringValue = genericFunctions.generateCustomizedRandomString(5,
						"abcdefghijklmnopqrstuvwxyz123456789&0.,-'/?\"()_");
			}
			getTextboxTitle().sendKeys(stringValue);
			stringValue = getTextboxTitle().getAttribute("value");
			linkedHashMap.put("title", stringValue);

			// First Name3-40
			getTextboxFirstName().clear();
			if (stringValue1.equals("test_firstName_Validations")) {
				stringValue = genericFunctions.generateCustomizedRandomString(2, "abc89&0.,-'/?\"()_");
			} else {
				stringValue = genericFunctions.generateCustomizedRandomString(8,
						"abcdefghijklmnopqrstuvwxyz123456789&0.,-'/?\"()_");
			}
			getTextboxFirstName().sendKeys(stringValue);
			stringValue = getTextboxFirstName().getAttribute("value");
			linkedHashMap.put("firstName", stringValue);

			// Last Name3-40
			getTextboxLastName().clear();
			if (stringValue1.equals("test_lastName_Validations")) {
				stringValue = genericFunctions.generateCustomizedRandomString(2, "abc89&0.,-'/?\"()_");

			} else {
				stringValue = genericFunctions.generateCustomizedRandomString(8,
						"abcdefghijklmnopqrstuvwxyz123456789&0.,-'/?\"()_");
			}
			getTextboxLastName().sendKeys(stringValue);
			stringValue = getTextboxLastName().getAttribute("value");
			linkedHashMap.put("lastName", stringValue);

			// contact Email 70 chars
			getTextboxEmail().clear();
			if (stringValue1.equals("test_email_Validations")) {
				intValue = 0;
				if (intValue == 0) {
					stringValue = genericFunctions.generaterandomString(10) + "@*" + "@mailinator.com";
				} else if (stringValue2.equals("activePhoneNumber")) {
					stringValue = projectDatabaseQueries.getActiveUserPhoneNumber();
				}
			} else {
				stringValue = genericFunctions.generaterandomString(5) + "newContact_"
						+ genericFunctions.generaterandomString(2) + "_" + genericFunctions.generaterandomString(8) + ""
						+ genericFunctions.generateRandomNumber(000, 1000) + "@mailinator.com";
			}
			getTextboxEmail().sendKeys(stringValue);
			stringValue = getTextboxEmail().getAttribute("value");
			linkedHashMap.put("contactEmail", stringValue);

			// contact phone
			getTextboxContactPhone().clear();
			if (stringValue1.equals("test_contactPhone_Validations")) {
				intValue = genericFunctions.generateRandomNumber(0, 1);
				intValue = 0;
				if (intValue == 0) {
					intValue = genericFunctions.generateRandomNumber(111111, 999999);
					stringValue = Integer.toString(intValue);
				} else if (stringValue2.equals("activePhoneNumber")) {
					stringValue = projectDatabaseQueries.getActiveUserPhoneNumber();

				}
			} else {
				stringValue = genericFunctions.generateRandomNumber(11111, 99999) + ""
						+ genericFunctions.generateRandomNumber(11111, 99999);
			}
			getTextboxContactPhone().sendKeys(stringValue);
			stringValue = getTextboxContactPhone().getAttribute("value");
			linkedHashMap.put("contactPhone", stringValue);

			// is billing contact
			getDropdownIsBilling().click();
			while (!getDropdownList().get(0).isDisplayed()) {
			}
			intValue = genericFunctions.generateRandomNumber(0, 2);
			for (int i = 0; i < getDropdownList().size(); i++) {
				if (i == intValue) {
					stringValue = getDropdownList().get(i).getText();
					getDropdownList().get(i).click();
					break;
				}
			}
			linkedHashMap.put("isBilling", stringValue);

			// extension -=- no max 10
			getTextboxExtension().clear();
			stringValue = genericFunctions.generateRandomNumber(11111, 99999) + ""
					+ genericFunctions.generateRandomNumber(11111, 99999);

			getTextboxExtension().sendKeys(stringValue);
			stringValue = getTextboxExtension().getAttribute("value");
			linkedHashMap.put("extension", stringValue);

			// business phone -=- no max 10
			getTextboxBusinessPhone().clear();
			if (stringValue1.equals("test_businessPhone_Validations")) {
				intValue = genericFunctions.generateRandomNumber(1111111, 92229999);
				stringValue = Integer.toString(intValue);
			} else {
				stringValue = genericFunctions.generateRandomNumber(11111, 99999) + ""
						+ genericFunctions.generateRandomNumber(11111, 99999);
			}

			getTextboxBusinessPhone().sendKeys(stringValue);
			stringValue = getTextboxBusinessPhone().getAttribute("value");
			linkedHashMap.put("businessPhone", stringValue);

			// fax -=- no max 10
			getTextboxFax().clear();
			if (stringValue1.equals("test_fax_Validations")) {
				intValue = genericFunctions.generateRandomNumber(1111111, 92229999);
				stringValue = Integer.toString(intValue);
			} else {
				stringValue = genericFunctions.generateRandomNumber(11111, 99999) + ""
						+ genericFunctions.generateRandomNumber(11111, 99999);
			}

			getTextboxFax().sendKeys(stringValue);
			stringValue = getTextboxFax().getAttribute("value");
			linkedHashMap.put("fax", stringValue);

			// department
			getDropdownDepartment().click();
			while (!getDropdownList().get(0).isDisplayed()) {
			}
			intValue = getDropdownList().size();
			if (intValue != 1) {
				intValue = (intValue - 1);
				randomNumber = genericFunctions.generateRandomNumber(1, intValue);
			} else {
				/**
				 ** WHEN SIZE OF THE 'DEPARTMENT' DROPDOWN IS 1 . THEN BY DEFAULT
				 * DISPLAYED 'GENERAL' VALUE IS TO BE SELECTED..
				 */
				randomNumber = 0;
			}

			// randomNumber=1;
			for (int i = 0; i < getDropdownList().size(); i++) {
				if (i == randomNumber) {
					stringValue = getDropdownList().get(i).getText();
					getDropdownList().get(i).click();
					break;
				}
			}
			linkedHashMap.put("department", stringValue);
			break;
		}

		getButtonSave().click();
		return linkedHashMap;
	}

	public void verifyAllFieldsErrorMessages() {
		try {

			sheetName = "fieldErrorMessages";
			fileNameAndExtension = "contactPageExcelSheet.xls";
			while (xlValues < data.readData(sheetName, fileNameAndExtension).size()) {

				// username validation
				fillContactForm("All Fields", "test_Username_Validations");
				GenericFunctions.highlightElement(getErrorMessageFields().get(0));
				Assert.assertTrue(
						getErrorMessageFields().get(0).getText()
								.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
						getErrorMessageFields().get(0).getText()
								+ " ui error message does not match with the expected error message , i.e,. -"
								+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
				genericFunctions.logEvent("Verified the error message :- " + getErrorMessageFields().get(0).getText());
				clearNewContactElementFields();
				xlValues++;

				// title validation
				fillContactForm("All Fields", "test_title_Validations");
				GenericFunctions.highlightElement(getErrorMessageFields().get(0));
				Assert.assertTrue(
						getErrorMessageFields().get(0).getText()
								.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
						getErrorMessageFields().get(0).getText()
								+ " ui error message does not match with the expected error message , i.e,. -"
								+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
				genericFunctions.logEvent("Verified the error message :- " + getErrorMessageFields().get(0).getText());
				clearNewContactElementFields();
				xlValues++;

				// first Name validation
				fillContactForm("All Fields", "test_firstName_Validations");
				GenericFunctions.highlightElement(getErrorMessageFields().get(0));
				Assert.assertTrue(
						getErrorMessageFields().get(0).getText()
								.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
						getErrorMessageFields().get(0).getText()
								+ " ui error message does not match with the expected error message , i.e,. -"
								+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
				genericFunctions.logEvent("Verified the error message :- " + getErrorMessageFields().get(0).getText());
				clearNewContactElementFields();
				xlValues++;

				// last Name validation
				fillContactForm("All Fields", "test_lastName_Validations");
				GenericFunctions.highlightElement(getErrorMessageFields().get(0));
				Assert.assertTrue(
						getErrorMessageFields().get(0).getText()
								.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
						getErrorMessageFields().get(0).getText()
								+ " ui error message does not match with the expected error message , i.e,. -"
								+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
				genericFunctions.logEvent("Verified the error message :- " + getErrorMessageFields().get(0).getText());
				clearNewContactElementFields();
				xlValues++;

				// email validation
				fillContactForm("All Fields", "test_email_Validations");
				GenericFunctions.highlightElement(getErrorMessageFields().get(0));
				Assert.assertTrue(
						getErrorMessageFields().get(0).getText()
								.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
						getErrorMessageFields().get(0).getText()
								+ " ui error message does not match with the expected error message , i.e,. -"
								+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
				genericFunctions.logEvent("Verified the error message :- " + getErrorMessageFields().get(0).getText());
				clearNewContactElementFields();
				xlValues++;

				// Contact Phone validation
				fillContactForm("All Fields", "test_contactPhone_Validations");
				GenericFunctions.highlightElement(getErrorMessageFields().get(0));
				Assert.assertTrue(
						getErrorMessageFields().get(0).getText()
								.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
						getErrorMessageFields().get(0).getText()
								+ " ui error message does not match with the expected error message , i.e,. -"
								+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
				genericFunctions.logEvent("Verified the error message :- " + getErrorMessageFields().get(0).getText());
				clearNewContactElementFields();
				xlValues++;

				// Business Phone validation
				fillContactForm("All Fields", "test_businessPhone_Validations");
				GenericFunctions.highlightElement(getErrorMessageFields().get(0));
				Assert.assertTrue(
						getErrorMessageFields().get(0).getText()
								.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
						getErrorMessageFields().get(0).getText()
								+ " ui error message does not match with the expected error message , i.e,. -"
								+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
				genericFunctions.logEvent("Verified the error message :- " + getErrorMessageFields().get(0).getText());
				clearNewContactElementFields();
				xlValues++;

				// Fax validation
				fillContactForm("All Fields", "test_fax_Validations");
				GenericFunctions.highlightElement(getErrorMessageFields().get(0));
				Assert.assertTrue(
						getErrorMessageFields().get(0).getText()
								.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
						getErrorMessageFields().get(0).getText()
								+ " ui error message does not match with the expected error message , i.e,. -"
								+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
				genericFunctions.logEvent("Verified the error message :- " + getErrorMessageFields().get(0).getText());
				clearNewContactElementFields();
				xlValues++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void clearNewContactElementFields() {
		try {
			getButtonNewContact().click();
			Thread.sleep(1000);
			getButtonNewContact().click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyNewContactDataWithDB(LinkedHashMap<Object, Object> linkedHashMap,
			ArrayList<String> arrayListValue) {
		try {
			i = 0;
			Iterator<Object> it = linkedHashMap.values().iterator();
			while (i < arrayListValue.size()) {
				while (it.hasNext()) {
					Object linkedListVal = it.next();
					SoftAssertUtil.myAssert().assertTrue(linkedListVal.equals(arrayListValue.get(i)),
							linkedListVal
									+ "- UI value entered does not match with the database entry .. database entry is :-"
									+ arrayListValue.get(i));
					i++;
				}
			}
			genericFunctions.logEvent("Verified the new contact created values with the database!!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyNewContactListData(ArrayList<String> arrayListValue) {
		try {
			int i = 0;
			getFirstRowTableData();
			while (i < (getFirstRowTableData().size() - 1)) {
				for (int j = 0; j < arrayListValue.size(); j++) {
					Thread.sleep(1000);
					SoftAssertUtil.myAssert().assertTrue(
							arrayListValue.get(j).equals(getFirstRowTableData().get(i).getText()),
							arrayListValue.get(j)
									+ "- UI listing value entered does not match with the database entry .. database entry is :-"
									+ getFirstRowTableData().get(i).getText());
					i++;
				}
			}
			genericFunctions.logEvent("Verified the new contact list data displayed in table with the database!!!!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void resetNewContactCreatedPassword(LinkedHashMap<Object, Object> linkedHashMap) {
		try {
			genericFunctions.navigateToNewTab();
			genericFunctions.waitForElementVisible(getTextboxCheckAnyInbox());
			stringValue = (String) linkedHashMap.get("contactEmail");
			getTextboxCheckAnyInbox().sendKeys(stringValue);
			getTextboxCheckAnyInbox().sendKeys(Keys.ENTER);
			genericFunctions.waitForElementVisible(getTextLinkGeneratedMail());

			try {
				getTextLinkGeneratedMail().click();
			} catch (Exception e) {
				driver.navigate().refresh();
				driver.navigate().refresh();
				Thread.sleep(500);
			}
			genericFunctions.waitForElementVisible(getIframeMailinatorEmailBody());
			WebDriverTestBase.driver.switchTo().frame(getIframeMailinatorEmailBody());
			GenericFunctions.highlightElement(getTextMailinatorEmail());
			stringValue = getTextMailinatorEmail().getText();
			stringValue = stringValue.replace("\n", "").trim();
			stringValue1 = (String) linkedHashMap.get("userName");
			String newString = "Welcome to SentinelC3,You have been registered successfully on SentinelC3Your Username Is "
					+ stringValue1 + "Click here to set passwordThis link will be valid for the next 48 hours";

			SoftAssertUtil.myAssert().assertTrue(stringValue.equals(newString),
					"String in the mail does not match with the expected string...");

			getLinkClickHere().click();
			Set<String> totalhandles = WebDriverTestBase.driver.getWindowHandles();
			Iterator<String> iterator = totalhandles.iterator();
			while (iterator.hasNext()) {
				String child_window = iterator.next();
				driver.switchTo().window(child_window);
				if (((driver.switchTo().window(child_window).getTitle().equals(config.getProperty("projectTitle")))
						&& (driver.getCurrentUrl().equals(config.getProperty("projectUrl"))))
						|| (driver.switchTo().window(child_window).getTitle()
								.equals(config.getProperty("emailSiteTitle")))) {
					driver.close();
				}
			}
			WebDriverTestBase.driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyMailLinkExpired() {
		try {
			Thread.sleep(200);
			while (!getSidePanelTitle().isDisplayed()) {
			}
			// title
			GenericFunctions.highlightElement(getSidePanelTitle());
			SoftAssertUtil.myAssert().assertTrue(getSidePanelTitle().getText().trim().equals("Link Expired !"),
					"'Link Expired' side panel title is not displayed");

			// info text
			GenericFunctions.highlightElement(getInfoLinkExpired());
			SoftAssertUtil.myAssert().assertTrue(getInfoLinkExpired().getText().trim().equals(
					"Your activation link has expired. Please contact administrator at support@sentinelc3.com to resent password link. Click here To go back at login page."));

			// supportlink
			GenericFunctions.highlightElement(getSupportEmailLink());
			SoftAssertUtil.myAssert().assertTrue(
					getSupportEmailLink().getText().trim().equals("support@sentinelc3.com"),
					"Support Mail is not displayed . Mail displayed should be 'support@sentinelc3.com'");

			// click here
			GenericFunctions.highlightElement(getLinkExpiredPageClickHere());
			SoftAssertUtil.myAssert().assertTrue(getLinkExpiredPageClickHere().getText().trim().equals("Click Here"));

			SoftAssertUtil.myAssert().assertTrue(getLinkExpiredPageClickHere().getText().trim().equals("Clich Here"),
					"'Clich Here' text is not displayed . text displayed should be 'Clich Here'");
			SoftAssertUtil.myAssert().assertTrue(
					genericFunctions.verifyLink(getLinkExpiredPageClickHere().getAttribute("href")) == 200,
					"'Clich Here' link is broken. Reponse code of the link is :-"
							+ getSupportEmailLink().getAttribute("href"));
			String parentWindowHandle = WebDriverTestBase.driver.getWindowHandle();
			Set<String> totalhandles = WebDriverTestBase.driver.getWindowHandles();
			Iterator<String> iterator = totalhandles.iterator();
			while (iterator.hasNext()) {
				String child_window = iterator.next();
				driver.switchTo().window(child_window);
				if (!parentWindowHandle.equals(WebDriverTestBase.driver.getWindowHandle())) {
					driver.close();
				}
			}
			genericFunctions.logEvent("Link Expired page elements are verified !!!!");

			getLinkExpiredPageClickHere().click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public LinkedHashMap<Object, Object> editCreatedContact() {
		try {

			/**
			 * update the fields
			 */
			linkedHashMap = fillContactForm("Mandatory Fields");
			genericFunctions.logEvent("Verified Edit form layout!!!!");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return linkedHashMap;

	}



	public void navigateToEditContactPage() {
		try {
			/**
			 * navigate to edit window
			 */
			while (!getIconButtonEdit().isDisplayed()) {
			}
			getIconButtonEdit().click();
			genericFunctions.logEvent("Navigated to edit contact window.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyCheckBoxes() {
		try {
			GenericFunctions.highlightElement(getLabelResendUsername());
			GenericFunctions.highlightElement(getLabelResetPassword());
			GenericFunctions.highlightElement(getCheckboxResetPassword());
			GenericFunctions.highlightElement(getCheckboxResendUsername());
			SoftAssertUtil.myAssert().assertTrue(
					(getLabelResendUsername().equals("Resend UserName"))
							&& (getLabelResendUsername().equals("Reset Password")),
					"Verified the radio buttons label . Expected labels are 'Resend Username' and 'Reset Password'");

			SoftAssertUtil.myAssert().assertTrue(!getCheckboxResendUsername().isSelected(),
					"Checkbox ResendUsername is selected. It should not be selected.");

			SoftAssertUtil.myAssert().assertTrue(!getCheckboxResetPassword().isSelected(),
					"Checkbox Reset Password is selected. It should not be selected.");

			genericFunctions.logEvent("Verified the Checkbox and its labels.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void checkCheckboxResendUsernameorResetPassword(String... args) {
		try {
			navigateToEditContactPage();
			if (args[0].contentEquals("resendUsername")) {
				Thread.sleep(1000);
				getLabelResendUsername().click();
				genericFunctions.logEvent("Checked the 'Resend Username' checkbox.");
			} else {
				Thread.sleep(1000);
				genericFunctions.scrollToElement(getLabelResetPassword());
				getLabelResetPassword().click();
				genericFunctions.logEvent("Checked the 'Reset Password' checkbox.");
			}
			Thread.sleep(1000);

			getButtonSave().click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyEmailedUsername(LinkedHashMap<Object, Object> linkedHashMap, String stringValue) {
		try {

			SoftAssertUtil.myAssert().assertTrue(linkedHashMap.get("userName").equals(stringValue),
					linkedHashMap.get("userName") + ":- Emailed username does not match with the expected username.");
			genericFunctions.logEvent("Verified 'Resend Username' functionality ....");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void editContactAndVerifyDepartment(String stringValue) {
		try {
			navigateToEditContactPage();
			genericFunctions.scrollToElement(getDropdownDepartment());
			GenericFunctions.highlightElement(getDropdownDepartment());

			SoftAssertUtil.myAssert().assertTrue(getDropdownDepartment().getText().equals(stringValue),
					getDropdownDepartment().getText()
							+ " -UI department dropdown value displayed is not equal to the entered Department value -"
							+ stringValue);
			genericFunctions.logEvent("Verified the Newly added Department Name.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
