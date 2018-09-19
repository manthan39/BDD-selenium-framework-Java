package com.sentinel.pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.sentinel.driver.WebDriverTestBase;
import com.sentinel.locators.sentinalCreateFacilityFormPageLocators;
import com.sentinel.locators.contactPageLocators;
import com.sentinel.locators.facilityPageLocators.facilityListingLocators;
import com.sentinel.locators.genericLocators;
import com.sentinel.locators.sentinalCreateFacilityFormPageLocators.CreateFacilityAllElementsLocators;
import com.sentinel.locators.sentinalCreateFacilityFormPageLocators.CreateFacilityCompulsaryElementsLocators;
import com.sentinel.locators.sentinalCreateFacilityFormPageLocators.CreateFacilityFormLocators;
import com.sentinel.locators.sentinalHomePageLocators.navigateToCreateFacilityFormLocators;
import com.sentinel.utils.ExcelUtility;
import com.sentinel.utils.GenericFunctions;
import com.sentinel.utils.SoftAssertUtil;

public class CreateFacilityFormPage extends WebDriverTestBase {

	GenericFunctions genericFunctions = new GenericFunctions();
	ExcelUtility data = new ExcelUtility();
	// HomePage homePage=new HomePage();
	Actions action = new Actions(WebDriverTestBase.driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Select select = null;
	SoftAssert softAssertion = new SoftAssert();
	List<WebElement> elementList = null;
	WebElement element = null;

	String stringValue = null, fileNameAndExtension = null, sheetName = null;
	int intValue = 0, i = 0, j = 0;
	String[] stringValueArray = null;
	int xlValues = 0;

	ArrayList<String> arrayList = new ArrayList<String>();
	LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();

	// This is the constructor
	public CreateFacilityFormPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = CreateFacilityFormLocators.LOC_ELEMENTS_ONPAGE_XPATH)
	@CacheLookup
	private List<WebElement> allElementsCreateFacilityForm;

	@FindBy(xpath = navigateToCreateFacilityFormLocators.LOC_COLLAPSABLEMENU_ACCOUNTING_XPATH)
	@CacheLookup
	private WebElement collapsableAccounting;

	@FindBy(xpath = navigateToCreateFacilityFormLocators.LOC_LINK_DISTRIBUTORS_XPATH)
	@CacheLookup
	private WebElement linkDistributors;

	@FindBy(xpath = navigateToCreateFacilityFormLocators.LOC_LINK_ADMINCONTACTS_XPATH)
	@CacheLookup
	private WebElement linkAdminContacts;

	@FindBy(xpath = genericLocators.locators.LOC_PAGETITLE_XPATH)
	private WebElement pageTitleCreateFacility;

	@FindBy(xpath = CreateFacilityFormLocators.LOC_SMALLTITLE_CUSTOMERCODE_XPATH)
	@CacheLookup
	private WebElement pageSmallTitleCustomerCode;

	@FindBy(xpath = genericLocators.locators.LOC_LINK_BREADCRUM_XPATH)
	@CacheLookup
	private List<WebElement> listBreadcrum;

	@FindBy(xpath = genericLocators.locators.LOC_BREADCRUM_CURRENTACTIVEPAGE_XPATH)
	@CacheLookup
	private WebElement textBreadCrumActivePage;

	@FindBy(xpath = genericLocators.locators.LOC_TEXTBOX_NORMALTEXTBOX_XPATH)
	@CacheLookup
	private List<WebElement> textboxNormalTextbox;

	@FindBy(xpath = genericLocators.locators.LOC_LABEL_NORMALTEXTBOX_XPATH)
	@CacheLookup
	private List<WebElement> labelNormalTextbox;

	@FindBy(xpath = CreateFacilityFormLocators.LOC_BUTTONLIST_UPLOADFACILITYLOGOANDFAVICON_XPATH)
	@CacheLookup
	private List<WebElement> buttonListFacilityLogoAndFavicon;

	@FindBy(xpath = CreateFacilityFormLocators.LOC_LABELLIST_FACILITYLOGOANDFAVICON_XPATH)
	@CacheLookup
	private List<WebElement> labelListFacilityLogoAndFavicon;

	@FindBy(xpath = CreateFacilityFormLocators.LOC_INFOTEXTLIST_FACILITYLOGOANDFAVICON_XPATH)
	@CacheLookup
	private List<WebElement> infoTextListFacilityLogoAndFavicon;

	@FindBy(xpath = CreateFacilityFormLocators.LOC_TEXTBOX_IMAGEUPLOAD_XPATH)
	@CacheLookup
	private List<WebElement> textboxUploadImage;

	@FindBy(xpath = CreateFacilityFormLocators.LOC_LIST_TOOLTIP_XPATH)
	@CacheLookup
	private List<WebElement> listToolTip;

	@FindBy(xpath = CreateFacilityFormLocators.LOC_LIST_TOOLTIPTEXTBOXES_XPATH)
	@CacheLookup
	private List<WebElement> listToolTipTextBoxes;

	@FindBy(xpath = CreateFacilityFormLocators.LOC_PLACEHOLDERSLIST_TOOLTIPTEXTBOXES_XPATH)
	@CacheLookup
	private List<WebElement> listToolTipTextboxesPlaceholders;

	@FindBy(xpath = CreateFacilityFormLocators.LOC_LABELSLIST_TOOLTIPTEXTBOXES_XPATH)
	@CacheLookup
	private List<WebElement> listToolTipTextBoxLabel;

	@FindBy(xpath = CreateFacilityFormLocators.LOC_LIST_DROPDOWNS_XPATH)
	@CacheLookup
	private List<WebElement> listDropDowns;

	@FindBy(xpath = CreateFacilityFormLocators.LOC_HELPTEXT_FACILITYSHORTNAME_XPATH)
	@CacheLookup
	private WebElement helpTextFacilityShortName;

	@FindBy(xpath = CreateFacilityFormLocators.LOC_LIST_TEXTAREAS_XPATH)
	@CacheLookup
	private List<WebElement> listTextAreas;

	@FindBy(xpath = CreateFacilityFormLocators.LOC_LABELSLIST_TEXTAREAS_XPATH)
	@CacheLookup
	private List<WebElement> listLabelsTextAreas;

	@FindBy(xpath = CreateFacilityFormLocators.LOC_HELPTEXT_FORCOMMENTS_XPATH)
	@CacheLookup
	private WebElement helpTextComments;

	@FindBy(xpath =  genericLocators.locators.LOC_LABELLIST_RADIOBUTTONS_XPATH)
	@CacheLookup
	private List<WebElement> listLabelsRadioButtons;

	@FindBy(xpath =  genericLocators.locators.LOC_RADIOBUTTONINPUT_ACTIVE_XPATH)
	@CacheLookup
	private WebElement radiobuttonInputActive;

	@FindBy(xpath =  genericLocators.locators.LOC_RADIOBUTTONINPUT_INACTIVE_XPATH)
	@CacheLookup
	private WebElement radiobuttonInputInactive;

	@FindBy(xpath = genericLocators.locators.LOC_LABEL_RADIOBUTTONS_XPATH)
	@CacheLookup
	private WebElement labelRadioButtons;

	@FindBy(xpath = genericLocators.locators.LOC_RADIOBUTTONINPUTLIST_ACTIVEINACTIVE_XPATH)
	@CacheLookup
	private List<WebElement> listRadioButtonsInputActiveInactive;

	@FindBy(xpath = CreateFacilityFormLocators.LOC_BUTTONLIST_SAVEANDCANCEL_XPATH)
	@CacheLookup
	private List<WebElement> listButtonsSaveAndCancel;

	@FindBy(xpath = CreateFacilityFormLocators.LOC_CHECKBOXLIST_DISTRIBUTORCREATEDEPARTMENT_XPATH)
	@CacheLookup
	private List<WebElement> checkboxListDistributorCreateDepartment;

	@FindBy(xpath = CreateFacilityFormLocators.LOC_CHECKBOXLABELLIST_DISTRIBOTERCREATEDEPARTMENT_XPATH)
	@CacheLookup
	private List<WebElement> checkboxLabelListDistributorCreateDepartment;

	@FindBy(xpath = CreateFacilityFormLocators.LOC_LABEL_SALESTAX_XPATH)
	@CacheLookup
	private WebElement labelSalesTax;

	@FindBy(xpath = CreateFacilityFormLocators.LOC_TEXTBOX_SALESTAX_XPATH)
	@CacheLookup
	private WebElement textboxSalesTax;

	@FindBy(xpath = CreateFacilityFormLocators.LOC_ICON_SALESTAX_XPATH)
	@CacheLookup
	private WebElement iconSalesTax;

	@FindBy(xpath = CreateFacilityCompulsaryElementsLocators.LOC_TEXTBOX_FACILITYNAME_XPATH)
	private WebElement textboxFacilityName;

	@FindBy(xpath = CreateFacilityCompulsaryElementsLocators.LOC_TEXTBOX_FACILITYCONTACTEMAIL_XPATH)
	private WebElement textboxFacilityContactEmail;

	@FindBy(xpath = CreateFacilityCompulsaryElementsLocators.LOC_TEXTBOX_FACILITYCONTACTPHONE_XPATH)
	private WebElement textboxFacilityContactPhone;


	@FindBy(xpath = CreateFacilityCompulsaryElementsLocators.LOC_TEXTBOX_FACILITYSALESTAXRATE_XPATH)
	private WebElement textboxFacilitySalesTaxRate;

	@FindBy(xpath = CreateFacilityCompulsaryElementsLocators.LOC_TEXTBOX_FACILITYBILLINGEMAILANDFAX_XPATH)
	private WebElement textboxBillingEmailAndFax;

	@FindBy(xpath = genericLocators.locators.LOC_ERRORMESSAGESLIST_COMPULSARYFIELDSBLANK_XPATH)
	private List<WebElement> errorMessageListBlankCompulsaryFields;

	@FindBy(xpath = CreateFacilityCompulsaryElementsLocators.LOC_TEXTBOX_FACILITYSALESTAXEXEMPTIONNUMBER_XPATH)
	private WebElement textboxFacilitySalesTaxExemptionNumber;

	@FindBy(xpath = CreateFacilityCompulsaryElementsLocators.LOC_TEXTBOX_FACILITYFAX_XPATH)
	private WebElement textboxFacilityFax;

	@FindBy(xpath = CreateFacilityCompulsaryElementsLocators.LOC_TEXTBOX_FACILITYSALESTAXID_XPATH)
	private WebElement textboxFacilitySalesTaxID;

	@FindBy(xpath = CreateFacilityCompulsaryElementsLocators.LOC_TEXTBOX_FACILITYWEBSITE_XPATH)
	private WebElement textboxFacilityWebsite;

	@FindBy(xpath = CreateFacilityCompulsaryElementsLocators.LOC_TEXTBOX_FACILITYSHORTNAME_XPATH)
	private WebElement textboxFacilityShortName;

	@FindBy(xpath = CreateFacilityAllElementsLocators.LOC_DROPDOWN_CORPORATE_XPATH)
	@CacheLookup
	private WebElement dropdownCorporate;

	@FindBy(xpath = CreateFacilityAllElementsLocators.LOC_DROPDOWN_DIVISION_XPATH)
	@CacheLookup
	private WebElement dropdownDivision;

	@FindBy(xpath = CreateFacilityAllElementsLocators.LOC_DROPDOWN_REGION_XPATH)
	@CacheLookup
	private WebElement dropdownRegion;

	@FindBy(xpath = sentinalCreateFacilityFormPageLocators.filterElementsLocators.LOC_DROPDOWN_STATE_XPATH)
	@CacheLookup
	private WebElement dropdownState;

	@FindBy(xpath = sentinalCreateFacilityFormPageLocators.filterElementsLocators.LOC_DROPDOWN_CITY_XPATH)
	private WebElement dropdownCity;

	@FindBy(xpath = sentinalCreateFacilityFormPageLocators.filterElementsLocators.LOC_DROPDOWN_SELECTSTATUS_XPATH)
	private WebElement dropdownSelectStatus;

	@FindBy(xpath = sentinalCreateFacilityFormPageLocators.filterElementsLocators.LOC_DROPDOWNLIST_XPATH)
	private List<WebElement> listDropdownOptions;

	@FindBy(xpath = sentinalCreateFacilityFormPageLocators.filterElementsLocators.LOC_DROPDOWNLIST_FILTER_XPATH)
	private List<WebElement> dropdownListFilter;

	@FindBy(xpath = sentinalCreateFacilityFormPageLocators.filterElementsLocators.LOC_DROPDOWNLISTLABEL_FILTER_XPATH)
	@CacheLookup
	private List<WebElement> dropdownListLableFilter;

	@FindBy(xpath = sentinalCreateFacilityFormPageLocators.filterElementsLocators.LOC_TEXTBOX_NAME_XPATH)
	@CacheLookup
	private WebElement textboxName;

	@FindBy(xpath = contactPageLocators.newContactPageLocators.LOC_BUTTONLIST_DROPDOWNCROSS_XPATH)
	@CacheLookup
	private List<WebElement> buttonListCross;

	@FindBy(xpath = facilityListingLocators.LOC_LIST_FIRSTROW_XPATH)
	private List<WebElement> listFirstRow;

	@FindBy(xpath = sentinalCreateFacilityFormPageLocators.filterElementsLocators.LOC_LABEL_NAME_XPATH)
	@CacheLookup
	private WebElement labelName;

	@FindBy(xpath = sentinalCreateFacilityFormPageLocators.filterElementsLocators.LOC_BUTTON_FILTER_XPATH)
	@CacheLookup
	private WebElement buttonFilter;

	@FindBy(xpath = sentinalCreateFacilityFormPageLocators.filterElementsLocators.LOC_BUTTON_APPLY_XPATH)
	@CacheLookup
	private WebElement buttonApply;

	@FindBy(xpath = sentinalCreateFacilityFormPageLocators.filterElementsLocators.LOC_BUTTON_RESET_XPATH)
	@CacheLookup
	private WebElement buttonReset;

	@FindBy(xpath = CreateFacilityAllElementsLocators.LOC_DROPDOWN_BILLINGMETHOD_XPATH)
	@CacheLookup
	private WebElement dropdownBillingMethod;

	@FindBy(xpath = CreateFacilityAllElementsLocators.LOC_CHECKBOX_ALLOWTAXPERDISTRIBUTOR_XPATH)
	@CacheLookup
	private WebElement checkboxAllowTaxPerDistributor;

	@FindBy(xpath = CreateFacilityAllElementsLocators.LOC_CHECKBOX_CREATEDEPARTMENTFORFACILITY_XPATH)
	@CacheLookup
	private WebElement checkboxCreateDepartmentForFacility;

	@FindBy(xpath = CreateFacilityAllElementsLocators.LOC_UPLOAD_FACILITYLOGO_XPATH)
	@CacheLookup
	private WebElement uploadFacilityLogo;

	@FindBy(xpath = CreateFacilityAllElementsLocators.LOC_UPLOAD_FACILITYFAVICON_XPATH)
	@CacheLookup
	private WebElement uploadFacilityFavicon;

	@FindBy(xpath = CreateFacilityAllElementsLocators.LOC_TEXTBOX_COMMENTS_XPATH)
	@CacheLookup
	private WebElement textboxComments;

	@FindBy(xpath = CreateFacilityAllElementsLocators.LOC_BUTTON_SAVEANDEXIT_XPATH)
	@CacheLookup
	private WebElement buttonSaveAndExit;

	@FindBy(xpath = CreateFacilityAllElementsLocators.LOC_BUTTON_SAVEANDNEXT_XPATH)
	@CacheLookup
	private WebElement buttonSaveAndNext;

	@FindBy(xpath = CreateFacilityAllElementsLocators.LOC_BUTTON_CANCEL_XPATH)
	@CacheLookup
	private WebElement buttonCancel;

	@FindBy(xpath = CreateFacilityAllElementsLocators.LOC_TEXTBOX_FACILITYLOGO_XPATH)
	@CacheLookup
	private WebElement textboxUploadLogo;

	@FindBy(xpath = CreateFacilityAllElementsLocators.LOC_TEXTBOX_FACILITYFAVICON_XPATH)
	@CacheLookup
	private WebElement textboxUploadFavicon;

	@FindBy(xpath = CreateFacilityAllElementsLocators.LOC_TOASTERMESSAGE_XPATH)
	@CacheLookup
	private WebElement toasterMessage;

	public List<WebElement> getButtonListCross() {
		return buttonListCross;
	}

	public List<WebElement> getListFirstRow() {
		return listFirstRow;
	}

	public WebElement getToasterMessage() {
		return toasterMessage;
	}

	public WebElement getTextboxUploadLogo() {
		return textboxUploadLogo;
	}

	public WebElement getTextboxUploadFavicon() {
		return textboxUploadFavicon;
	}

	public WebElement getButtonSaveAndExit() {
		return buttonSaveAndExit;
	}

	public WebElement getButtonSaveAndNext() {
		return buttonSaveAndNext;
	}

	public WebElement getButtonCancel() {
		return buttonCancel;
	}

	public WebElement getTextboxComments() {
		return textboxComments;
	}

	public WebElement getUploadFacilityFavicon() {
		return uploadFacilityFavicon;
	}

	public WebElement getUploadFacilityLogo() {
		return uploadFacilityLogo;
	}

	public WebElement getCheckboxAllowTaxPerDistributor() {
		return checkboxAllowTaxPerDistributor;
	}

	public WebElement getCheckboxCreateDepartmentForFacility() {
		return checkboxCreateDepartmentForFacility;
	}

	public WebElement getDropdownBillingMethod() {
		return dropdownBillingMethod;
	}

	public WebElement getDropdownRegion() {
		return dropdownRegion;
	}

	public WebElement getDropdownDivision() {
		return dropdownDivision;
	}

	public WebElement getDropdownCorporate() {
		return dropdownCorporate;
	}

	public WebElement getTextboxFacilitySalesTaxExemptionNumber() {
		return textboxFacilitySalesTaxExemptionNumber;
	}

	public WebElement getTextboxFacilityFax() {
		return textboxFacilityFax;
	}

	public WebElement getTextboxFacilitySalesTaxID() {
		return textboxFacilitySalesTaxID;
	}

	public WebElement getTextboxFacilityShortName() {
		return textboxFacilityShortName;
	}

	public WebElement getTextboxFacilityWebsite() {
		return textboxFacilityWebsite;
	}

	public WebElement getTextboxFacilityName() {
		return textboxFacilityName;
	}

	public WebElement getTextboxFacilityContactEmail() {
		return textboxFacilityContactEmail;
	}

	public WebElement getTextboxFacilityContactPhone() {
		return textboxFacilityContactPhone;
	}

	public WebElement getTextboxFacilitySalesTaxRate() {
		return textboxFacilitySalesTaxRate;
	}

	public WebElement getTextboxBillingEmailAndFax() {
		return textboxBillingEmailAndFax;
	}

	public List<WebElement> getErrorMessageListBlankCompulsaryFields() {
		return errorMessageListBlankCompulsaryFields;
	}

	public WebElement getLabelSalesTax() {
		return labelSalesTax;
	}

	public WebElement getTextboxSalesTax() {
		return textboxSalesTax;
	}

	public WebElement getIconSalesTax() {
		return iconSalesTax;
	}

	public List<WebElement> getCheckboxListDistributorCreateDepartment() {
		return checkboxListDistributorCreateDepartment;
	}

	public List<WebElement> getCheckboxLabelListDistributorCreateDepartment() {
		return checkboxLabelListDistributorCreateDepartment;
	}

	public List<WebElement> getListButtonsSaveAndCancel() {
		return listButtonsSaveAndCancel;
	}

	public List<WebElement> getListRadioButtonsInputActiveInactive() {
		return listRadioButtonsInputActiveInactive;
	}

	public WebElement getRadiobuttonInputActive() {
		return radiobuttonInputActive;
	}

	public WebElement getRadiobuttonInputInactive() {
		return radiobuttonInputInactive;
	}

	public WebElement getLabelRadioButtons() {
		return labelRadioButtons;
	}

	public List<WebElement> getListLabelsRadioButtons() {
		return listLabelsRadioButtons;
	}

	public List<WebElement> getListTextAreas() {
		return listTextAreas;
	}

	public List<WebElement> getListLabelsTextAreas() {
		return listLabelsTextAreas;
	}

	public WebElement getHelpTextComments() {
		return helpTextComments;
	}

	public WebElement getHelpTextFacilityShortName() {
		return helpTextFacilityShortName;
	}

	public List<WebElement> getListDropDowns() {
		return listDropDowns;
	}

	public List<WebElement> getListToolTipTextBoxes() {
		return listToolTipTextBoxes;
	}

	public List<WebElement> getListToolTipTextboxesPlaceholders() {
		return listToolTipTextboxesPlaceholders;
	}

	public List<WebElement> getListToolTipTextBoxLabel() {
		return listToolTipTextBoxLabel;
	}

	public List<WebElement> getListToolTip() {
		return listToolTip;
	}

	public List<WebElement> getTextboxUploadImage() {
		return textboxUploadImage;
	}

	public List<WebElement> getLabelListFacilityLogoAndFavicon() {
		return labelListFacilityLogoAndFavicon;
	}

	public List<WebElement> getInfoTextListFacilityLogoAndFavicon() {
		return infoTextListFacilityLogoAndFavicon;
	}

	public List<WebElement> getButtonListFacilityLogoAndFavicon() {
		return buttonListFacilityLogoAndFavicon;
	}

	public List<WebElement> getLabelNormalTextbox() {
		return labelNormalTextbox;
	}

	public List<WebElement> getTextboxNormalTextbox() {
		return textboxNormalTextbox;
	}

	public List<WebElement> getAllElementsCreateFacilityForm() {
		return allElementsCreateFacilityForm;
	}

	public WebElement getTextBreadCrumActivePage() {
		return textBreadCrumActivePage;
	}

	public List<WebElement> getListBreadcrum() {
		return listBreadcrum;
	}

	public WebElement getPageSmallTitleCustomerCode() {
		return pageSmallTitleCustomerCode;
	}

	public WebElement getPageTitleCreateFacility() {
		return pageTitleCreateFacility;
	}

	public WebElement getLinkDistributors() {
		return linkDistributors;
	}

	public WebElement getLinkAdminContacts() {
		return linkAdminContacts;
	}

	public WebElement getCollapsableAccounting() {
		return collapsableAccounting;
	}

	public WebElement getButtonFilter() {
		return buttonFilter;
	}

	public WebElement getTextboxName() {
		return textboxName;
	}

	public WebElement getLabelName() {
		return labelName;
	}

	public List<WebElement> getDropdownListFilter() {
		return dropdownListFilter;
	}

	public List<WebElement> getListDropdownOptions() {
		return listDropdownOptions;
	}

	public List<WebElement> getDropdownListLableFilter() {
		return dropdownListLableFilter;
	}

	public WebElement getButtonApply() {
		return buttonApply;
	}

	public WebElement getButtonReset() {
		return buttonReset;
	}

	public WebElement getDropdownState() {
		return dropdownState;
	}

	public WebElement getDropdownCity() {
		return dropdownCity;
	}

	public WebElement getDropdownSelectStatus() {
		return dropdownSelectStatus;
	}

	public void verifyPageHeaderElements() {
		try {
			/**
			 *  verify page Title
			 */
			
			element = getPageTitleCreateFacility();
			intValue = element.getText().length();
			GenericFunctions.highlightElement(element);
			softAssertion.assertTrue(element.getText().substring(0, 15).trim().equals("Create Facility"),
					"'Create Title' of the page is not displayed . ");
			
			/**
			 *  verify customer code
			 */
			element = getPageSmallTitleCustomerCode();
			intValue = element.getText().length();
			GenericFunctions.highlightElement(element);
			softAssertion.assertTrue(element.getText().substring(0, 15).trim().contains("Customer Code :"),
					"'Customer Code :' of the page is not displayed . ");
			Thread.sleep(800);
			intValue = element.getText().substring(16, intValue).trim().length();
			softAssertion.assertTrue((intValue) >= 10, "Customer code is not displayed  ");
			
			/**
			 *  Verify Header Breadcrum displayed
			 */
			
			intValue = getListBreadcrum().size();
			for (int i = 0; i < intValue; i++) {
				GenericFunctions.highlightElement(getListBreadcrum().get(i));
				softAssertion.assertTrue(
						(genericFunctions.verifyLink(getListBreadcrum().get(i).getAttribute("href"))) == 200,
						getListBreadcrum().get(i).getText() + "  Link in the Breadcrum is not clickable");
			}
			GenericFunctions.highlightElement(getTextBreadCrumActivePage());
			softAssertion.assertTrue(getTextBreadCrumActivePage().getText().equals("Create Facility"),
					"'Create Facility' text is not as expected ... it is displayed as - "
							+ getTextBreadCrumActivePage().getText());

			genericFunctions.logEvent("Verified the Page Header with titles and breadcrum ...");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyCreateFacilityFormElements() {
		try {
			elementList = getAllElementsCreateFacilityForm();

			intValue = getAllElementsCreateFacilityForm().size();
		//	System.out.println("size - " + intValue);
			for (int i = 0; i < intValue; i++) {
				// System.out.println(i + " - " +
				// getAllElementsCreateFacilityForm().get(i).getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyFormNormalTextBoxesLayout() {
		try {
			sheetName = "normalTextBoxLabelsAndPlaceholders";
			fileNameAndExtension = "CreateFacilityExcelSheet.xls";
			intValue = getTextboxNormalTextbox().size();
			while (xlValues < data.readData(sheetName, fileNameAndExtension).size()) {
				while (j < (intValue - 2)) {
					GenericFunctions.highlightElement(getLabelNormalTextbox().get(j));
					softAssertion.assertTrue(
							getLabelNormalTextbox().get(j).getText()
									.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
							getLabelNormalTextbox().get(j).getText()
									+ " -->UI button label does not match with the expected excel value ,i.e,. -"
									+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
					xlValues++;
					GenericFunctions.highlightElement(getTextboxNormalTextbox().get(j));
					softAssertion.assertTrue(
							getTextboxNormalTextbox().get(j).getAttribute("placeholder")
									.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
							getTextboxNormalTextbox().get(j).getAttribute("placeholder")
									+ " -->UI Placeholder  does not match with the expected excel value ,i.e,. -"
									+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
					j++;
					xlValues++;
				}
			}
			genericFunctions.logEvent(
					"Verified the Labels and Placeholders for buttons i.e,. 'Contact Email * , Contact Phone * , FAX , Tax ID , Website , '");
			xlValues = 0;
			i = 0;
			j = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyImageUploadButtonLayout() {
		try {
			sheetName = "facilityElements";
			fileNameAndExtension = "CreateFacilityExcelSheet.xls";
			intValue = getLabelListFacilityLogoAndFavicon().size();
			while (xlValues < data.readData(sheetName, fileNameAndExtension).size()) {
				while (j < intValue) {
					// Textbox Labels

					GenericFunctions.highlightElement(getLabelListFacilityLogoAndFavicon().get(j));
					softAssertion
							.assertTrue(
									getLabelListFacilityLogoAndFavicon().get(j).getText().trim()
											.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)
													.trim()),
									getLabelListFacilityLogoAndFavicon().get(j).getText().trim()
											+ " UI Label Text does not match with the excel value , i.e,. "
											+ data.readData(sheetName, fileNameAndExtension).get(xlValues).trim());
					xlValues++;

					// Button Labels
					GenericFunctions.highlightElement(getButtonListFacilityLogoAndFavicon().get(j));
					softAssertion
							.assertTrue(
									getButtonListFacilityLogoAndFavicon().get(j).getText().trim()
											.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)
													.trim()),
									getButtonListFacilityLogoAndFavicon().get(j).getText().trim()
											+ " UI Label Text does not match with the excel value , i.e,. "
											+ data.readData(sheetName, fileNameAndExtension).get(xlValues).trim());

					xlValues++;
					// Image Info Text
					GenericFunctions.highlightElement(getInfoTextListFacilityLogoAndFavicon().get(j));
					softAssertion
							.assertTrue(
									getInfoTextListFacilityLogoAndFavicon().get(j).getText().trim()
											.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)
													.trim()),
									getInfoTextListFacilityLogoAndFavicon().get(j).getText().trim()
											+ " UI Label Text does not match with the excel value , i.e,. "
											+ data.readData(sheetName, fileNameAndExtension).get(xlValues).trim());
					// Verify the textboxes
					if ((j == 0)) {
						elementList = getTextboxUploadImage();
						for (int z = 0; z < getTextboxUploadImage().size(); z++) {
							GenericFunctions.highlightElement(getTextboxUploadImage().get(z));
							softAssertion.assertTrue(getTextboxUploadImage().get(z).isDisplayed(),
									"The Image Load Textbox is not displayed...");
						}
					}
					xlValues++;
					j++;

				}
			}

			j = 0;
			xlValues = 0;
			// homePage.resetvariableValuestoDefault();
			genericFunctions.logEvent("Verified the Facility Logo and Facility Favicon All elements..");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyToolTips() {
		try {
			sheetName = "InfoToolTips";
			fileNameAndExtension = "CreateFacilityExcelSheet.xls";
			// intValue = getLabelListFacilityLogoAndFavicon().size();

			// INITIALIZE VARIABLES
			int intValue = 0;
			String[] stringValueArray = null;
			String temp = null, finalString = null;

			// OPERATE ON VARIABLES

			String[] specialCharArray = { "null", "<ul class='m-n text-left p-l-md'>", "</li><li>", "<li>", "</ul><ul",
					"</li></ul>", "</li>" };
			elementList = getListToolTip();
			// GET THE EXCEL DATA
			while (xlValues < data.readData(sheetName, fileNameAndExtension).size()) {
				for (int Z = 0; Z < elementList.size(); Z++) {
					GenericFunctions.highlightElement(elementList.get(Z));
					action.moveToElement(elementList.get(Z)).perform();
					stringValue = elementList.get(Z).getAttribute("data-original-title");

					stringValueArray = stringValue.split("<li>");
					intValue = stringValueArray.length;
					for (int i = 0; i < intValue; i++) {
						temp += stringValueArray[i];
						finalString = genericFunctions.replaceSpecialCharacters(temp, specialCharArray);
					}
					softAssertion.assertTrue(
							finalString.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
							finalString
									+ " -- UI tooltip does not match the expected tooltipl text in the excel, i.e,. - "
									+ data.readData(sheetName, fileNameAndExtension).get(xlValues));

					// AFTER USE FLUSH THE VALUES WITH NULL VALUES
					finalString = null;
					stringValueArray = null;
					temp = null;
					xlValues++;

				}
			}
			genericFunctions.logEvent("Verified the tooltip text...");
			xlValues = 0;
			elementList = null;
			stringValue = null;
			stringValueArray = null;
			// homePage.resetvariableValuestoDefault();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void resetvariableValuestoDefault() {

		xlValues = 0;
		elementList = null;
		stringValue = null;
		stringValueArray = null;

	}

	public void verifyTextboxesWithToolTips() {
		try {
			sheetName = "TextboxLabelsAndPlaceholders";
			fileNameAndExtension = "CreateFacilityExcelSheet.xls";
			intValue = getListToolTipTextBoxes().size();
			while (xlValues < data.readData(sheetName, fileNameAndExtension).size()) {
				for (i = 0; i < intValue; i++) {
					GenericFunctions.highlightElement(getListToolTipTextBoxLabel().get(i));
					softAssertion.assertTrue(
							getListToolTipTextBoxLabel().get(i).getText()
									.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
							getListToolTipTextBoxLabel().get(i).getText()
									+ " --> UI Label does not match with the expected excel value ,i.e,. - "
									+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
					xlValues++;
					GenericFunctions.highlightElement(getListToolTipTextboxesPlaceholders().get(i));
					softAssertion.assertTrue(
							getListToolTipTextboxesPlaceholders().get(i).getAttribute("placeholder")
									.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
							getListToolTipTextboxesPlaceholders().get(i).getAttribute("placeholder")
									+ " --> UI Placeholder  does not match with the expected excel value ,i.e,. - "
									+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
					// Verify short notice below dropdown

					if (getListToolTipTextboxesPlaceholders().get(i).getAttribute("placeholder")
							.equals("Enter Facility Short Name")) {
						GenericFunctions.highlightElement(getHelpTextFacilityShortName());
						softAssertion.assertTrue(
								(getHelpTextFacilityShortName().getText()
										.equals(config.getProperty("facilityShortName")))
										&& (getHelpTextFacilityShortName().isDisplayed()),
								"The Help text for 'Enter Facility Short Name' is not displayed...");
					}
					xlValues++;
				}
			}
			genericFunctions.logEvent(
					"Verified the Labels and Placeholder for textboxes - 'Facility Name *','Sales Tax Exemption Number' and 'Facility Short Name' .");
			i = 0;
			xlValues = 0;
			// homePage.resetvariableValuestoDefault();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyDropDownsAndDefautValues() {
		try {
			sheetName = "DropdownsAndDefaultValues";
			fileNameAndExtension = "CreateFacilityExcelSheet.xls";
			elementList = getListDropDowns();
			intValue = elementList.size();
			while (xlValues < data.readData(sheetName, fileNameAndExtension).size()) {
				for (i = 0; i < intValue; i++) {
					GenericFunctions.highlightElement(elementList.get(i));
					GenericFunctions.highlightElement(elementList.get(i));
					stringValue = elementList.get(i).getText().replace("\n", "");
					/**
					 * Need to format the ui string received
					 */
					String[] stringArray = { "                                             " };
					genericFunctions.replaceSpecialCharacters(stringValue, stringArray);
					String stringValueArray[] = stringValue.split("                                            ");
					stringValue = stringValueArray[1];
					genericFunctions.logEvent(stringValue.trim() + " -  compare -"
							+ data.readData(sheetName, fileNameAndExtension).get(xlValues).trim());
					softAssertion
							.assertTrue(
									stringValue.trim()
											.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)
													.trim()),
									stringValue
											+ " dropdown value does not match with the expected excel values , i.e,. "
											+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
					xlValues++;
				}
			}
			genericFunctions.logEvent("Verified the Dropdowns and default Values displayed..");
			xlValues = 0;
			i = 0;
			intValue = 0;
			stringValue = null;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void VerifyTextAreas() {
		try {
			sheetName = "textAreaLabelsAndPlaceholders";
			fileNameAndExtension = "CreateFacilityExcelSheet.xls";
			intValue = getListTextAreas().size();
			while (xlValues < data.readData(sheetName, fileNameAndExtension).size()) {
				for (i = 0; i < intValue; i++) {
					GenericFunctions.highlightElement(getListLabelsTextAreas().get(i));
					softAssertion.assertTrue(
							getListLabelsTextAreas().get(i).getText()
									.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
							getListLabelsTextAreas().get(i).getText()
									+ "--> UI Label does not match with the expected excel value , i.e,. -"
									+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
					xlValues++;
					GenericFunctions.highlightElement(getListTextAreas().get(i));
					softAssertion.assertTrue(
							getListTextAreas().get(i).getAttribute("placeholder")
									.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
							getListTextAreas().get(i).getAttribute("placeholder")
									+ "--> UI Placeholder does not match with the expected excel value , i.e,. -"
									+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
					xlValues++;
					if (getListLabelsTextAreas().get(i).getText().equals("Comments")) {
						genericFunctions.scrollToElement(getHelpTextComments());
						GenericFunctions.highlightElement(getHelpTextComments());
						softAssertion.assertTrue(
								(getHelpTextComments().getText().equals(config.getProperty("Comments")))
										&& (getHelpTextFacilityShortName().isDisplayed()),
								"The Help text for 'Enter Facility Short Name' is not displayed...");
					}
				}
			}
			genericFunctions.logEvent("Verified the TextAreas and default Values displayed..");
			xlValues = 0;
			i = 0;
			intValue = 0;
			stringValue = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyRadioButtonLayout() {
		try {
			sheetName = "radioButtonLabelAndNames";
			fileNameAndExtension = "CreateFacilityExcelSheet.xls";
			intValue = getListLabelsRadioButtons().size();
			while (xlValues < data.readData(sheetName, fileNameAndExtension).size()) {
				for (i = 0; i < intValue; i++) {
					genericFunctions.scrollToElement(getListLabelsRadioButtons().get(i));
					GenericFunctions.highlightElement(getListLabelsRadioButtons().get(i));

					softAssertion.assertTrue(
							getListLabelsRadioButtons().get(i).getText()
									.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
							getListLabelsRadioButtons().get(i).getText()
									+ " The radio button label does not match with the expected xl value , i,.e,. -"
									+ data.readData(sheetName, fileNameAndExtension).get(xlValues));

					GenericFunctions.highlightElement(getLabelRadioButtons());
					softAssertion.assertTrue(
							getLabelRadioButtons().getText().equals(config.getProperty("radioButtonLabel")),
							"The label of the radio buttons is not as expected .  Extected Label is - "
									+ config.getProperty("radioButtonLabel"));
					GenericFunctions.highlightElement(getListRadioButtonsInputActiveInactive().get(i));
					if (i == 0) {
						softAssertion.assertTrue(getListRadioButtonsInputActiveInactive().get(i).isSelected(),
								"Active radio button is by default not selected..");
					} else {
						softAssertion.assertTrue(!getListRadioButtonsInputActiveInactive().get(i).isSelected(),
								"Inactive radio button is by  selected..");
					}
					xlValues++;
				}
			}
			genericFunctions.logEvent("Verified the radio Buttons and  default Values displayed..");
			xlValues = 0;
			i = 0;
			intValue = 0;
			stringValue = null;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void VerifyButtonsLayout() {
		try {
			sheetName = "buttonNamesList";
			fileNameAndExtension = "CreateFacilityExcelSheet.xls";
			intValue = getListButtonsSaveAndCancel().size();
			while (xlValues < data.readData(sheetName, fileNameAndExtension).size()) {
				for (i = 0; i < intValue; i++) {
					genericFunctions.scrollToElement(getListButtonsSaveAndCancel().get(i));
					GenericFunctions.highlightElement(getListButtonsSaveAndCancel().get(i));

					softAssertion.assertTrue(
							getListButtonsSaveAndCancel().get(i).getText()
									.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
							getListButtonsSaveAndCancel().get(i).getText()
									+ " The  button label does not match with the expected xl value , i,.e,. -"
									+ data.readData(sheetName, fileNameAndExtension).get(xlValues));

					softAssertion.assertTrue(getListButtonsSaveAndCancel().get(i).isDisplayed(),
							"The Buttons are not displayed ... ");
					softAssertion.assertTrue(getListButtonsSaveAndCancel().get(i).isEnabled(),
							"The Buttons are not enabled ... ");
					xlValues++;
				}

			}
			genericFunctions.logEvent("Verified the Buttons and  default Values displayed..");
			xlValues = 0;
			i = 0;
			intValue = 0;
			stringValue = null;

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyCheckBoxLayout() {
		try {

			sheetName = "checkboxlabels";
			fileNameAndExtension = "CreateFacilityExcelSheet.xls";
			intValue = getCheckboxLabelListDistributorCreateDepartment().size();
			while (xlValues < data.readData(sheetName, fileNameAndExtension).size()) {
				for (i = 0; i < intValue; i++) {
					genericFunctions.scrollToElement(getCheckboxLabelListDistributorCreateDepartment().get(i));
					GenericFunctions.highlightElement(getCheckboxLabelListDistributorCreateDepartment().get(i));

					softAssertion.assertTrue(
							getCheckboxLabelListDistributorCreateDepartment().get(i).getText()
									.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
							getCheckboxLabelListDistributorCreateDepartment().get(i).getText()
									+ " The checkbox label does not match with the expected xl value , i,.e,. -"
									+ data.readData(sheetName, fileNameAndExtension).get(xlValues));

					genericFunctions.scrollToElement(getCheckboxListDistributorCreateDepartment().get(i));
					GenericFunctions.highlightElement(getCheckboxListDistributorCreateDepartment().get(i));
					softAssertion.assertTrue(getCheckboxListDistributorCreateDepartment().get(i).isEnabled(),
							"the Checkboxes are not enabled ... ");
					softAssertion.assertTrue(!getCheckboxListDistributorCreateDepartment().get(i).isSelected(),
							"the Checkboxes are selected ... ");

					xlValues++;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyRemainingSalesTaxTextbox() {
		try {

			genericFunctions.scrollToElement(getLabelSalesTax());
			GenericFunctions.highlightElement(getLabelSalesTax());
			softAssertion.assertTrue(getLabelSalesTax().getText().equals(config.getProperty("salesTaxTextboxLabel")),
					"The textbox label for 'Sales Tax *' is not as expected... expected label is - "
							+ config.getProperty("salesTaxTextboxLabel"));
			GenericFunctions.highlightElement(getTextboxSalesTax());
			softAssertion.assertTrue(getTextboxSalesTax().isDisplayed(), "the textbox is not displayed... ");

			GenericFunctions.highlightElement(getIconSalesTax());
			softAssertion.assertTrue(getIconSalesTax().isDisplayed(),
					"the sales tax textbox icon in is not displayed... ");
			softAssertion.assertTrue(getIconSalesTax().isEnabled(), "the sales tax textbox icon in is  enabled ... ");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyCompulsaryFieldBlankErrorMessages() {
		try {
			sheetName = "compulsaryFieldsBlankErrorMessages";
			fileNameAndExtension = "CreateFacilityExcelSheet.xls";

			fillTheFields("Keep Compulsary Fields Blank");

			while (getErrorMessageListBlankCompulsaryFields().size() < 0) {
			}
			elementList = getErrorMessageListBlankCompulsaryFields();
			intValue = elementList.size();

			while (xlValues < data.readData(sheetName, fileNameAndExtension).size()) {

				for (i = 0; i < intValue; i++) {
					softAssertion.assertTrue(
							elementList.get(i).getText()
									.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
							elementList.get(i).getText()
									+ "The Error Messages displayed does not match witht the expected error message, i,.e,. -"
									+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
					xlValues++;
				}
			}
			genericFunctions.logEvent("verified  the Blank Error Messages for Compulsary field.");
			xlValues = 0;
			i = 0;
			intValue = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void clearTheFacilityFormFields() {
		try {
			getTextboxFacilityName().clear();
			getTextboxFacilityContactEmail().clear();
			getTextboxFacilityContactPhone().clear();
			getTextboxFacilitySalesTaxRate().clear();
			getTextboxBillingEmailAndFax().clear();
			getTextboxFacilitySalesTaxExemptionNumber().clear();
			getTextboxFacilityFax().clear();
			getTextboxFacilitySalesTaxID().clear();
			getTextboxFacilityWebsite().clear();
			getTextboxFacilityShortName().clear();
			getTextboxFacilityShortName().clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fillTheFields(String... args) {
		try {
			stringValue = args[0];
			switch (stringValue) {
			case "Keep Compulsary Fields Blank":

				getTextboxFacilityName().sendKeys(Keys.TAB);
				getTextboxFacilityContactEmail().sendKeys(Keys.TAB);
				getTextboxFacilityContactPhone().sendKeys(Keys.TAB);
				getTextboxFacilitySalesTaxRate().sendKeys(Keys.TAB);
				getTextboxBillingEmailAndFax().sendKeys(Keys.TAB);

				break;

			case "Check Wrong Input Error Messages":

				getTextboxFacilityName().sendKeys(genericFunctions.generaterandomString(1));
				getTextboxFacilityContactEmail().sendKeys(genericFunctions.generaterandomString(5));
				getTextboxFacilityContactPhone().sendKeys(Float.toString(genericFunctions.generateRandomNumber(1, 5)));
				getTextboxFacilitySalesTaxExemptionNumber()
						.sendKeys(Float.toString(genericFunctions.generateRandomNumber(1, 3)));
				getTextboxFacilityFax().sendKeys(genericFunctions.generaterandomString(1));
				getTextboxFacilitySalesTaxID().sendKeys(Float.toString(genericFunctions.generateRandomNumber(1, 3)));
				getTextboxFacilityWebsite().sendKeys(genericFunctions.generaterandomString(1));
				getTextboxFacilityShortName().sendKeys(genericFunctions.generaterandomString(1));
				getTextboxFacilityShortName().sendKeys(Keys.TAB);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public LinkedHashMap<Object, Object> saveCreateFacilityForm(String... args) {
		try {
			stringValue = args[0];
			switch (stringValue) {

			case "Mandatory Fields":
				while (!getTextboxFacilityName().isDisplayed()) {
				}
				// Facility Name
				stringValue = "facilityName_" + genericFunctions.generaterandomString(3);
				getTextboxFacilityName().sendKeys(stringValue);
				arrayList.add(stringValue);
				linkedHashMap.put("Facility Name", stringValue);

				// Contact Email
				stringValue = "contactEmail_"+genericFunctions.generateRandomEmail();
				getTextboxFacilityContactEmail().sendKeys(stringValue);
				arrayList.add(stringValue);
				linkedHashMap.put("Contact Email", stringValue);

				// Contact Phone
				stringValue = genericFunctions.generateRandomNumber(33333, 99999) + ""
						+ genericFunctions.generateRandomNumber(33333, 99999);
				getTextboxFacilityContactPhone().sendKeys(stringValue);
				arrayList.add(stringValue);
				linkedHashMap.put("Contact Phone", stringValue);

				// Sales Tax
				intValue = genericFunctions.generateRandomNumber(1, 9);
				getTextboxFacilitySalesTaxRate().sendKeys(Float.toString(intValue));
				arrayList.add(String.valueOf(intValue));
				linkedHashMap.put("Sales Tax", stringValue);

				// Billing Email and Fax *
				stringValue = "email_Fax_"+genericFunctions.generateRandomEmail();
				getTextboxBillingEmailAndFax().sendKeys(stringValue);
				arrayList.add(stringValue);
				linkedHashMap.put("Billing Email and Fax *", stringValue);

				getButtonSaveAndNext().click();
				Thread.sleep(1000);
				while (!getToasterMessage().isDisplayed()) {
					Thread.sleep(1000);
				}
				softAssertion.assertTrue(getToasterMessage().isDisplayed(),
						"'Record saved successfully.' toaster message is not displayed..");
				softAssertion.assertTrue(getToasterMessage().getText().equals("Record saved successfully."),
						getToasterMessage().getText()
								+ " toaster message is not as expected . Expected Toaster message is - 'Record saved successfully.'");

				genericFunctions.logEvent("Added Facility with mandatory fields only of the form .");

				break;

			case "All Fields":

				while (!getTextboxFacilityName().isDisplayed()) {
				}
				// Select DropDown Values
				if ((args[1] == null) && (args[4] == null)) {
					selectDropdownValues(null, null, null, null);
				} else {
					selectDropdownValues(args[1], args[2], args[3], args[4]);
				}
				// Facility Name
				stringValue = "facilityName_"+genericFunctions.generaterandomString(3);
				getTextboxFacilityName().sendKeys(stringValue);

				arrayList.add(stringValue);
				linkedHashMap.put("Facility Name", stringValue);

				// Contact Email
				stringValue = "email_"+genericFunctions.generateRandomEmail();
				getTextboxFacilityContactEmail().sendKeys(stringValue);
				arrayList.add(stringValue);
				linkedHashMap.put("Contact Email", stringValue);

				// Contact Phone
				stringValue = genericFunctions.generateRandomNumber(33333, 99999) + ""
						+ genericFunctions.generateRandomNumber(33333, 99999);
				getTextboxFacilityContactPhone().sendKeys(stringValue);
				arrayList.add(stringValue);
				linkedHashMap.put("Contact Phone", stringValue);

				// Sales Tax
				intValue = genericFunctions.generateRandomNumber(1, 9);
				getTextboxFacilitySalesTaxRate().sendKeys(Float.toString(intValue));
				arrayList.add(String.valueOf(intValue));
				linkedHashMap.put("Sales Tax", stringValue);

				// Sales Tax Exemption Number
				stringValue = genericFunctions.generaterandomString(5);
				getTextboxFacilitySalesTaxExemptionNumber().sendKeys(stringValue);
				arrayList.add(stringValue);
				linkedHashMap.put("Sales Tax", stringValue);

				// checkbox -- Allow Sales Tax Per Distributor
				action = new Actions(WebDriverTestBase.driver);
				action.moveToElement(getCheckboxAllowTaxPerDistributor()).click().build().perform();

				// FAX
				stringValue = genericFunctions.generateRandomNumber(33333, 99999) + ""
						+ genericFunctions.generateRandomNumber(33333, 99999);
				getTextboxFacilityFax().sendKeys(stringValue);
				arrayList.add(stringValue);
				linkedHashMap.put("FAX", stringValue);

				// Tax ID
				stringValue = genericFunctions.generateRandomNumber(1111, 9999) + ""
						+ genericFunctions.generateRandomNumber(33333, 99999);
				getTextboxFacilitySalesTaxID().sendKeys(stringValue);
				arrayList.add(stringValue);
				linkedHashMap.put("Tax ID", stringValue);

				// Website
				stringValue = "www." + genericFunctions.generaterandomString(5) + ".com";
				getTextboxFacilityWebsite().sendKeys(stringValue);
				arrayList.add(stringValue);
				linkedHashMap.put("Website", stringValue);

				// Facility Short Name
				stringValue = genericFunctions.generaterandomString(5);
				getTextboxFacilityShortName().sendKeys(stringValue);
				arrayList.add(stringValue);
				linkedHashMap.put("Facility Short Name", stringValue);

				// Facility Logo
				stringValue = System.getProperty("user.dir") + "\\projectDataFiles\\ImageFiles\\Logo.jpg";
				js.executeScript("arguments[0].value=arguments[1];", getTextboxUploadLogo(), stringValue);
				arrayList.add(stringValue);
				linkedHashMap.put("Facility Logo", stringValue);

				// Facility Favicon
				stringValue = System.getProperty("user.dir") + "\\projectDataFiles\\ImageFiles\\favion_fb.png";
				js.executeScript("arguments[0].value=arguments[1];", getTextboxUploadFavicon(), stringValue);
				arrayList.add(stringValue);
				linkedHashMap.put("Facility Favicon", stringValue);

				// Billing Email and Fax *
				stringValue = genericFunctions.generateRandomEmail();
				getTextboxBillingEmailAndFax().sendKeys(stringValue);
				arrayList.add(stringValue);
				linkedHashMap.put("Billing Email and Fax *", stringValue);

				// Comments
				stringValue = genericFunctions.generaterandomString(10);
				getTextboxComments().sendKeys(stringValue);
				arrayList.add(stringValue);
				linkedHashMap.put("Comments", stringValue);

				// Radio Buttons

				intValue = genericFunctions.generateRandomNumber(1, 10);
				if (intValue > 5) {
					getRadiobuttonInputActive().click();
					arrayList.add("Active Radio Button Selected.");
					linkedHashMap.put("Active Radio Button", "Active Radio Button Selected.");

				} else {
					getRadiobuttonInputInactive().click();
					arrayList.add("Inactive Radio Button Selected.");
					linkedHashMap.put("Inactive Radio Button", "Inactive Radio Button Selected.");

				}

				// Checkbox - create departments
				action = new Actions(WebDriverTestBase.driver);
				action.moveToElement(getCheckboxCreateDepartmentForFacility()).click().build().perform();

				getButtonSaveAndNext().click();
				Thread.sleep(800);
				softAssertion.assertTrue(getToasterMessage().isDisplayed(),
						"'Record saved successfully.' toaster message is not displayed..");
				softAssertion.assertTrue(getToasterMessage().getText().equals("Record saved successfully."),
						getToasterMessage().getText()
								+ " toaster message is not as expected . Expected Toaster message is - 'Record saved successfully.'");
				genericFunctions.logEvent("Added Facility with all the fields in the form .");

				break;

			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return linkedHashMap;
	}

	private void selectDropdownValues(String Corporate, String Division, String Region, String billingMethod) {
		try {
			while (!getDropdownCorporate().isDisplayed()) {
			}
			if (Corporate != null) {
				// Select Random Value from Corporate DropDown
				select = new Select(getDropdownCorporate());
				Thread.sleep(800);
				elementList = select.getOptions();
				intValue = elementList.size();
				if (intValue > 1) {
					intValue = intValue - 1;
					intValue = genericFunctions.generateRandomNumber(1, intValue);
					select.selectByIndex(intValue);
					arrayList.add(select.getFirstSelectedOption().getText().trim());
					linkedHashMap.put("Corporate", select.getFirstSelectedOption().getText().trim());
				}

				// Select Random Value from Division DropDown, If Present

				select = new Select(getDropdownDivision());
				Thread.sleep(800);
				elementList = select.getOptions();
				intValue = elementList.size();
				if ((Division != null) && (intValue > 1)) {
					intValue = intValue - 1;
					intValue = genericFunctions.generateRandomNumber(1, intValue);
					select.selectByIndex(intValue);
					arrayList.add(select.getFirstSelectedOption().getText().trim());
					linkedHashMap.put("Division", select.getFirstSelectedOption().getText().trim());
				} else {
					linkedHashMap.put("Division", null);
				}

				// Select Random Value from Region DropDown, If Present

				select = new Select(getDropdownRegion());
				Thread.sleep(800);
				elementList = select.getOptions();
				intValue = elementList.size();
				if ((Region != null) && (intValue > 1)) {
					intValue = intValue - 1;
					intValue = genericFunctions.generateRandomNumber(1, intValue);
					select.selectByIndex(intValue);
					arrayList.add(select.getFirstSelectedOption().getText().trim());
					linkedHashMap.put("Region", select.getFirstSelectedOption().getText().trim());
				} else {
					linkedHashMap.put("Region", null);
				}
			} else {
				linkedHashMap.put("Corporate", null);
				linkedHashMap.put("Division", null);
				linkedHashMap.put("Region", null);
			}

			// Select Random Value from Billing Method DropDown, If Present
			if (billingMethod != null) {
				select = new Select(getDropdownBillingMethod());
				elementList = select.getOptions();
				intValue = elementList.size();
				if (intValue > 1) {
					intValue = intValue - 1;
					intValue = genericFunctions.generateRandomNumber(1, intValue);
					select.selectByIndex(intValue);
					arrayList.add(select.getFirstSelectedOption().getText().trim());
					linkedHashMap.put("billingMethod", select.getFirstSelectedOption().getText().trim());
				}
			} else {
				linkedHashMap.put("billingMethod", null);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyWrongInputValidations() {
		// clear the fields and refresh the page
		clearTheFacilityFormFields();
		WebDriverTestBase.driver.navigate().refresh();

		try {
			sheetName = "validationWrongInputErrorMessages";
			fileNameAndExtension = "CreateFacilityExcelSheet.xls";

			fillTheFields("Check Wrong Input Error Messages");
			while (getErrorMessageListBlankCompulsaryFields().size() < 0) {
			}
			elementList = getErrorMessageListBlankCompulsaryFields();
			intValue = elementList.size();
			while (xlValues < data.readData(sheetName, fileNameAndExtension).size()) {
				for (i = 0; i < intValue; i++) {
					softAssertion.assertTrue(
							elementList.get(i).getText()
									.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
							elementList.get(i).getText()
									+ "The Error Messages displayed does not match with the expected error message, i,.e,. -"
									+ data.readData(sheetName, fileNameAndExtension).get(xlValues));

					xlValues++;
				}
			}
			genericFunctions.logEvent("verified  the Blank Error Messages for Compulsary field.");
			xlValues = 0;
			i = 0;
			intValue = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyFacilityListingFilterButtonAndLabel() {
		try {
			GenericFunctions.highlightElement(getButtonFilter());
			SoftAssertUtil.myAssert().assertTrue(getButtonFilter().isDisplayed(), "'Filter' buttn is not displyed...");
			SoftAssertUtil.myAssert().assertTrue(getButtonFilter().getText().equals("Filter"),
					"'Filter' expected text is not displayed...");
			getButtonFilter().click();
			genericFunctions.logEvent("verified  the Facility Filter displayed.");
			genericFunctions.logEvent("verified  the Facility Filter Textbox.");
			genericFunctions.logEvent("verified  the Facility Filter Dropdowns.");
			genericFunctions.logEvent("verified  the Facility Filter Buttons.");
			genericFunctions.logEvent("verified  the 'No Records Found' Message.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyPopUpElements() {
		try {
			// verify textbox
			GenericFunctions.highlightElement(getTextboxName());
			SoftAssertUtil.myAssert().assertTrue(getTextboxName().isDisplayed(), "'Name' textbox is not displayed...");
			SoftAssertUtil.myAssert().assertTrue(
					getTextboxName().getAttribute("placeholder").equals("Enter Corporate / Facility Name"),
					"'Enter Corporate / Facility Name' expected placeholder is not displayed...");
			// verify textbox label
			GenericFunctions.highlightElement(getLabelName());
			SoftAssertUtil.myAssert().assertTrue(getLabelName().isDisplayed(), "'Name' label is not displayed...");
			SoftAssertUtil.myAssert().assertTrue(getLabelName().getText().equals("Name"),
					"'Name' expected label is not displayed...");
			genericFunctions.logEvent("verified  the Facility Filter Textbox.");

			// verify button Apply
			GenericFunctions.highlightElement(getButtonApply());
			SoftAssertUtil.myAssert().assertTrue(getButtonApply().isDisplayed(), "'Apply' button is not displayed...");
			SoftAssertUtil.myAssert().assertTrue(getButtonApply().getText().equals("Apply"),
					"'Apply' button label is not displayed...");
			genericFunctions.logEvent("verified  the Facility button 'Apply'.");

			// verify button Reset
			GenericFunctions.highlightElement(getButtonReset());
			SoftAssertUtil.myAssert().assertTrue(getButtonReset().isDisplayed(), "'Reset' button is not displayed...");
			SoftAssertUtil.myAssert().assertTrue(getButtonReset().getText().equals("Reset"),
					"'Reset' button label is not displayed...");
			genericFunctions.logEvent("verified  the Facility button 'Reset'.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyDropdowns() {
		try {

			sheetName = "filterPopUpDropDownPlaceholdersAndLabels";
			fileNameAndExtension = "CreateFacilityExcelSheet.xls";
			intValue = getDropdownListFilter().size();
			while (xlValues < data.readData(sheetName, fileNameAndExtension).size()) {
				for (int i = 0; i < intValue; i++) {
					GenericFunctions.highlightElement(getDropdownListLableFilter().get(i));
					SoftAssertUtil.myAssert().assertTrue(
							data.readData(sheetName, fileNameAndExtension).get(xlValues)
									.equals(getDropdownListLableFilter().get(i).getText()),
							getDropdownListLableFilter().get(i).getText()
									+ " - Label Name Does not Match with the Excel Label name..."
									+ data.readData(sheetName, fileNameAndExtension).get(xlValues));

					xlValues++;
					GenericFunctions.highlightElement(getDropdownListFilter().get(i));
					SoftAssertUtil.myAssert().assertTrue(
							data.readData(sheetName, fileNameAndExtension).get(xlValues)
									.equals(getDropdownListFilter().get(i).getAttribute("placeholder")),
							getDropdownListFilter().get(i).getAttribute("placeholder")
									+ " - dropdown placeholder Does not Match with the Excel placeholder..."
									+ data.readData(sheetName, fileNameAndExtension).get(xlValues));
					xlValues++;

				}
			}
			genericFunctions.logEvent("verified  the Facility Filter Dropdowns.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifySearchFunctionalityUsingName(ArrayList<String> arrayListValue, String... args) {

		try {
			if (args[0].equals("Name")) {
				logger.debug("Filter by - " + args[0]);
				getTextboxName().clear();
				GenericFunctions.highlightElement(getTextboxName());
				getTextboxName().sendKeys(arrayListValue.get(0));
			}

			if ((args[0].equals("City")) || (args[0].equals("State"))) {
				logger.debug("Filter by - " + arrayListValue.get(0) + "---" + arrayListValue.get(1) + "---"
						+ arrayListValue.get(2));
				getButtonFilter().click();
				getButtonReset().click();
				getButtonFilter().click();

				getTextboxName().clear();
				getTextboxName().sendKeys(arrayListValue.get(0));

				getDropdownState().click();
				intValue = getListDropdownOptions().size();
				for (int i = 0; i < intValue; i++) {
					if (getListDropdownOptions().get(i).getText().equals(arrayListValue.get(1))) {
						getListDropdownOptions().get(i).click();
						break;
					}
				}
				Thread.sleep(800);
				getDropdownCity().click();
				intValue = getListDropdownOptions().size();
				for (int i = 0; i < intValue; i++) {
					if (getListDropdownOptions().get(i).getText().equals(arrayListValue.get(2))) {
						getListDropdownOptions().get(i).click();
						break;
					}
				}
			}

			getDropdownSelectStatus().click();
			intValue = getListDropdownOptions().size();
			for (int i = 0; i < intValue; i++) {
				if (getListDropdownOptions().get(i).getText().equals(arrayListValue.get(5))) {
					getListDropdownOptions().get(i).click();
					break;
				}
			}
			getButtonApply().click();
			i = 0;
			intValue = getListFirstRow().size();
			while (i < intValue) {
				for (int j = 0; j < arrayListValue.size(); j++) {
					if (i == 5) {
						i++;
						break;
					}
					if (i == 4) {
						stringValueArray = getListFirstRow().get(i).getText().split(" ");
						stringValue = stringValueArray[0];
						SoftAssertUtil.myAssert().assertTrue(stringValue.equals(arrayListValue.get(j)), arrayListValue
								+ " ui row data does not match with the database data -" + arrayListValue.get(j));
						i++;
					} else {
						Thread.sleep(1000);
						SoftAssertUtil.myAssert().assertTrue(
								getListFirstRow().get(i).getText().equals(arrayListValue.get(j)),
								getListFirstRow().get(i).getText()
										+ " ui row data does not match with the database data -"
										+ arrayListValue.get(j));
						i++;
					}
				}
			}
			genericFunctions.logEvent("Search verified with Name Filter");
			xlValues = 0;
			i = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
