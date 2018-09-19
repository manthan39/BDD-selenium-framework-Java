package com.sentinel.pages;

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

import com.sentinel.driver.WebDriverTestBase;
import com.sentinel.locators.createCorporatePageLocators;
import com.sentinel.locators.genericLocators;
import com.sentinel.locators.sentinalCreateFacilityFormPageLocators.CreateFacilityFormLocators;
import com.sentinel.locators.sentinalHomePageLocators.navigateToCreateFacilityFormLocators;
import com.sentinel.utils.ExcelUtility;
import com.sentinel.utils.GenericFunctions;
import com.sentinel.utils.SoftAssertUtil;

public class CorporatePage extends WebDriverTestBase {

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
	public CorporatePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = navigateToCreateFacilityFormLocators.LOC_ICONBUTTON_PLUSSIGN_XPATH)
	@CacheLookup
	private WebElement rightBottomPlusSignIconButton;

	@FindBy(xpath = navigateToCreateFacilityFormLocators.LOC_TEXTANDICONLIST_CREATEFACILITY_XPATH)
	@CacheLookup
	private List<WebElement> listAndIconCreateFacility;

	@FindBy(xpath = navigateToCreateFacilityFormLocators.LOC_TEXTANDICONLIST_CREATECORPORATE_XPATH)
	@CacheLookup
	private List<WebElement> listAndIconCreateCorporate;

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

	@FindBy(xpath = createCorporatePageLocators.formPageLocators.LOC_DROPDOWNLIST_XPATH)
	@CacheLookup
	private List<WebElement> dropdownList;

	@FindBy(xpath = createCorporatePageLocators.formPageLocators.LOC_TEXTAREA_XPATH)
	@CacheLookup
	private WebElement commentsTextArea;

	@FindBy(xpath = genericLocators.locators.LOC_LABELLIST_RADIOBUTTONS_XPATH)
	@CacheLookup
	private List<WebElement> listLabelsRadioButtons;

	@FindBy(xpath = genericLocators.locators.LOC_LABEL_RADIOBUTTONS_XPATH)
	@CacheLookup
	private WebElement labelRadioButtons;

	@FindBy(xpath = genericLocators.locators.LOC_RADIOBUTTONINPUTLIST_ACTIVEINACTIVE_XPATH)
	@CacheLookup
	private List<WebElement> listRadioButtonsInputActiveInactive;

	@FindBy(xpath = createCorporatePageLocators.formPageLocators.LOC_CHECKBOX_PERMANENTPOSPERFACILITY_XPATH)
	private WebElement checkboxPermanentPerFacility;

	@FindBy(xpath = createCorporatePageLocators.formPageLocators.LOC_DATEPICKER_FIRSTCONTACTDATE_XPATH)
	private WebElement datePickerFirstContactDate;

	@FindBy(xpath = createCorporatePageLocators.formPageLocators.LOC_TEXTBOX_CORPORATENAME_XPATH)
	private WebElement textboxCorporateName;

	@FindBy(xpath = createCorporatePageLocators.formPageLocators.LOC_TEXTBOX_FIRSTCONTACTMADEBY_XPATH)
	private WebElement textboxfirstContactBy;

	@FindBy(xpath = createCorporatePageLocators.formPageLocators.LOC_TEXTBOX_EMAIL_XPATH)
	private WebElement textboxEmail;

	@FindBy(xpath = createCorporatePageLocators.formPageLocators.LOC_TEXTBOX_CONTACTPHONE_XPATH)
	private WebElement textboxContactPhone;

	@FindBy(xpath = createCorporatePageLocators.formPageLocators.LOC_TEXTBOX_REFERREDBY_XPATH)
	private WebElement textboxReferredBy;

	@FindBy(xpath = createCorporatePageLocators.formPageLocators.LOC_TEXTBOX_TAXID_XPATH)
	private WebElement textboxTaxID;

	@FindBy(xpath = createCorporatePageLocators.formPageLocators.LOC_TEXTBOX_WEBSITE_XPATH)
	private WebElement textboxWebsite;

	@FindBy(xpath = createCorporatePageLocators.formPageLocators.LOC_TEXTBOX_FAX_XPATH)
	private WebElement textboxFax;
	
	public WebElement getTextboxFax() {
		return textboxFax;
	}
	
	public WebElement getTextboxReferredBy() {
		return textboxReferredBy;
	}
	
	public WebElement getTextboxTaxID() {
		return textboxTaxID;
	}
	
	public WebElement getTextboxWebsite() {
		return textboxWebsite;
	}

	public WebElement getTextboxEmail() {
		return textboxEmail;
	}

	public WebElement getTextboxContactPhone() {
		return textboxContactPhone;
	}

	public WebElement getTextboxfirstContactBy() {
		return textboxfirstContactBy;
	}

	public WebElement getTextboxCorporateName() {
		return textboxCorporateName;
	}

	public WebElement getDatePickerFirstContactDate() {
		return datePickerFirstContactDate;
	}

	public WebElement getCheckboxPermanentPerFacility() {
		return checkboxPermanentPerFacility;
	}

	public List<WebElement> getListRadioButtonsInputActiveInactive() {
		return listRadioButtonsInputActiveInactive;
	}

	public WebElement getLabelRadioButtons() {
		return labelRadioButtons;
	}

	public List<WebElement> getListLabelsRadioButtons() {
		return listLabelsRadioButtons;
	}

	public WebElement getCommentsTextArea() {
		return commentsTextArea;
	}

	public List<WebElement> getDropdownList() {
		return dropdownList;
	}

	public List<WebElement> getLabelNormalTextbox() {
		return labelNormalTextbox;
	}

	public List<WebElement> getTextboxNormalTextbox() {
		return textboxNormalTextbox;
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

	public List<WebElement> getListAndIconCreateCorporate() {
		return listAndIconCreateCorporate;
	}

	public List<WebElement> getListAndIconCreateFacility() {
		return listAndIconCreateFacility;
	}

	public WebElement getRightBottomPlusSignIconButton() {
		return rightBottomPlusSignIconButton;
	}

	public void navigateToCreateCorporatePage(String... args) {
		try {
			if (args[0].equals("Navigate to Create Form Page")) {
				genericFunctions.waitForElementVisible(getRightBottomPlusSignIconButton());
				while (!getRightBottomPlusSignIconButton().isDisplayed()) {
				}
				Thread.sleep(2000);
				getRightBottomPlusSignIconButton().click();
				/**
				 * Navigate to Corporate Form
				 */
				elementList = getListAndIconCreateCorporate();
				while (!elementList.get(0).isDisplayed()) {
					Thread.sleep(200);
				}
				for (i = 0; i < elementList.size(); i++) {
					GenericFunctions.highlightElement(elementList.get(i));
					softAssertion.assertTrue(elementList.get(i).isDisplayed(),
							"'Create corporate' text or icon is missing..");
				}
				GenericFunctions.highlightElement(elementList.get(0));
				elementList.get(0).click();
				genericFunctions.logEvent("Navigated to 'Create Corporate' page.");
				i = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyPageHeaderElements() {
		try {
			/**
			 * verify page Title
			 */

			element = getPageTitleCreateFacility();
			intValue = element.getText().length();
			GenericFunctions.highlightElement(element);
			softAssertion.assertTrue(element.getText().substring(0, 15).trim().equals("Create Corporate"),
					"'Create Corporate' of the page is not displayed . ");

			/**
			 * verify customer code
			 */
			element = getPageSmallTitleCustomerCode();
			intValue = element.getText().length();
			GenericFunctions.highlightElement(element);
			softAssertion.assertTrue(element.getText().substring(0, 15).trim().contains("Customer Code :"),
					"'Customer Code :' of the page is not displayed . ");
			Thread.sleep(1200);

			intValue = element.getText().substring(16, intValue).trim().length();

			softAssertion.assertTrue((intValue) >= 10, "Customer code is not displayed  ");

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
			softAssertion.assertTrue(getTextBreadCrumActivePage().getText().equals("Create Corporate"),
					"'Create Corporate' text is not as expected ... it is displayed as - "
							+ getTextBreadCrumActivePage().getText());

			genericFunctions.logEvent("Verified the Page Header with titles and breadcrum ...");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyFormNormalTextBoxesLayout() {

		try {
			sheetName = "normalTextBoxLabelsAndPlaceholders";
			fileNameAndExtension = "CreateCorporateExcelSheet.xls";
			intValue = getTextboxNormalTextbox().size();
			logger.debug("The No. of textboxes on UI are:-" + intValue);

			while (xlValues < data.readData(sheetName, fileNameAndExtension).size()) {
				while (j < (intValue)) {
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

	public void verifyDropDownsAndDefautValues() {
		try {
			i = 0;
			xlValues = 0;
			elementList = getDropdownList();
			intValue = getDropdownList().size();
			fileNameAndExtension = "CreateCorporateExcelSheet.xls";
			sheetName = "dropdownsLabelsAndPlaceholders";
			System.out.println("*****************************************");
			while (xlValues < data.readData(sheetName, fileNameAndExtension).size()) {

				while (i < intValue) {

					GenericFunctions.highlightElement(
							getDropdownList().get(i).findElement(By.xpath("preceding-sibling::label")));
					softAssertion.assertTrue(
							getDropdownList().get(i).findElement(By.xpath("preceding-sibling::label")).getText()
									.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
							getDropdownList().get(i).findElement(By.xpath("preceding-sibling::label")).getText()
									+ " -->UI Label does not match with the expected excel value ,i.e,. -"
									+ data.readData(sheetName, fileNameAndExtension).get(xlValues));

					xlValues++;

					GenericFunctions.highlightElement(getDropdownList().get(i));
					softAssertion.assertTrue(
							getDropdownList().get(i).getAttribute("placeholder")
									.equals(data.readData(sheetName, fileNameAndExtension).get(xlValues)),
							getDropdownList().get(i).getAttribute("placeholder")
									+ " -->UI Placeholder  does not match with the expected excel value ,i.e,. -"
									+ data.readData(sheetName, fileNameAndExtension).get(xlValues));

					xlValues++;

					i++;

				}

			}
			genericFunctions.logEvent("Verified the Labels and Placeholders for dropdowns");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyTextAreas() {
		try {
			/**
			 * COMMENTS SECTION TEXTAREA VERIFICATIONS
			 */

			GenericFunctions.highlightElement(getCommentsTextArea().findElement(By.xpath("preceding-sibling::label")));
			softAssertion.assertTrue(
					getCommentsTextArea().findElement(By.xpath("preceding-sibling::label")).getText()
							.equals("Comments"),
					getCommentsTextArea().findElement(By.xpath("preceding-sibling::label")).getText()
							+ " -->UI Label does not match with the expected excel value ,i.e,. - 'Comments'");

			GenericFunctions.highlightElement(getCommentsTextArea());
			SoftAssertUtil.myAssert().assertTrue(getCommentsTextArea().isDisplayed(),
					"'Enter Comments' textarea is not displayed...");
			softAssertion.assertTrue(getCommentsTextArea().getAttribute("placeholder").equals("Enter Comments"),
					getCommentsTextArea().getAttribute("placeholder")
							+ " -->UI Placeholder  does not match with the expected excel value ,i.e,. - 'Enter Comments'");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyRadioButtonLayout() {
		try {
			xlValues = 0;
			i = 0;
			sheetName = "radioButtonLabelAndNames";
			fileNameAndExtension = "CreateCorporateExcelSheet.xls";
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

	public void verifyCheckBoxAndDateDropdown() {
		try {
			GenericFunctions.highlightElement(getCheckboxPermanentPerFacility());
			SoftAssertUtil.myAssert().assertTrue(getCheckboxPermanentPerFacility().isDisplayed(),
					"'Permanent Pos Per Facility'Checkbox is not displayed.");
			/**
			 * DATE PICKER VALIDATION
			 */
			GenericFunctions.highlightElement(getDatePickerFirstContactDate());
			SoftAssertUtil.myAssert().assertTrue(getDatePickerFirstContactDate().isDisplayed(),
					"'First Contact Date' date picker is not displayed..");
			SoftAssertUtil.myAssert().assertTrue(
					getDatePickerFirstContactDate().findElement(By.xpath("../preceding-sibling::label")).getText()
							.equals("First Contact Date *"),
					getDatePickerFirstContactDate().findElement(By.xpath("../preceding-sibling::label")).getText()
							+ " label does not match with the expected label :- 'First Contact Date *'");
			genericFunctions.logEvent("Verified the checkbox and date picker..");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyCompulsaryFieldBlankErrorMessages() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void fillCorporateForm(String... args) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
