package com.sentinel.pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.sentinel.driver.WebDriverTestBase;
import com.sentinel.locators.facilityPageLocators;
import com.sentinel.locators.genericLocators;
import com.sentinel.locators.facilityPageLocators.facilityListingLocators;
import com.sentinel.locators.sentinalCreateFacilityFormPageLocators.CreateFacilityFormLocators;
import com.sentinel.locators.sentinalHomePageLocators;
import com.sentinel.utils.ExcelUtility;
import com.sentinel.utils.GenericFunctions;

public class FacilityPage extends WebDriverTestBase {

	GenericFunctions genericFunctions = new GenericFunctions();
	ExcelUtility data = new ExcelUtility();
	// HomePage homePage=new HomePage();
	Actions action = new Actions(WebDriverTestBase.driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Select select = null;
	SoftAssert softAssertion = new SoftAssert();
	List<WebElement> elementList = null, elementList2 = null;
	WebElement element = null;

	String stringValue = null, fileNameAndExtension = null, sheetName = null;
	int intValue = 0, i = 0, j = 0, z = 0;
	String[] stringValueArray = null;
	int xlValues = 0;

	ArrayList<String> arrayList = new ArrayList<String>();
	ArrayList<String> arrayList1 = new ArrayList<String>();
	LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();

	// This is the constructor
	public FacilityPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = facilityListingLocators.LOC_COLOUMN_CORPORATENAMEFACILITYNAME_XPATH)
	private List<WebElement> coloumnCorporateNameFacilityName;

	@FindBy(xpath = facilityListingLocators.LOC_LINKPAGINATION_NEXTENABLED_XPATH)
	@CacheLookup
	private WebElement paginationLinkNextEnabled;

	@FindBy(xpath = facilityListingLocators.LOC_LINKPAGINATION_NEXTDISABLED_XPATH)
	@CacheLookup
	private WebElement paginationLinkNextDisabled;

	@FindBy(xpath = facilityListingLocators.LOC_BUTTON_NEXT_XPATH)
	private WebElement buttonNext;

	@FindBy(xpath = facilityListingLocators.LOC_LIST_PAGINATION_XPATH)
	private List<WebElement> listPagination;

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

	@FindBy(xpath = facilityListingLocators.LOC_BUTTON_FILTER_XPATH)
	@CacheLookup
	private WebElement buttonFacilityFilter;

	@FindBy(xpath = facilityListingLocators.LOC_DOWNLOADEXCEL_FACILITY_XPATH)
	@CacheLookup
	private WebElement buttonDownloadExcelFacility;

	@FindBy(xpath = genericLocators.locators.LOC_PAGINATION_PERPAGEENTRIES_XPATH)
	@CacheLookup
	private WebElement perPagePaginationEntries;

	@FindBy(css = genericLocators.locators.LOC_PAGINATION_PREVIOUSNEXT_CSS)
	@CacheLookup
	private WebElement paginationPreviousNext;

	@FindBy(xpath = genericLocators.locators.LOC_LABEL_SHOWINGPAGINATIONCOUNT_XPATH)
	@CacheLookup
	private WebElement labelShowingPaginationCount;

	@FindBy(xpath = sentinalHomePageLocators.navigateToCreateFacilityFormLocators.LOC_ICONBUTTON_PLUSSIGN_XPATH)
	@CacheLookup
	private WebElement rightBottomPlusSignIconButton;

	@FindBy(xpath = genericLocators.locators.LOC_LABELLIST_TABLEHEADER_XPATH)
	@CacheLookup
	private List<WebElement> labelListTableHeaders;

	@FindBy(xpath = facilityPageLocators.facilityListingLocators.LOC_LIST_EDIT_XPATH)
	@CacheLookup
	private List<WebElement> listEditButton;

	public List<WebElement> getListEditButton() {
		return listEditButton;
	}

	public List<WebElement> getLabelListTableHeaders() {
		return labelListTableHeaders;
	}

	public WebElement getRightBottomPlusSignIconButton() {
		return rightBottomPlusSignIconButton;
	}

	public WebElement getLabelShowingPaginationCount() {
		return labelShowingPaginationCount;
	}

	public WebElement getPaginationPreviousNext() {
		return paginationPreviousNext;
	}

	public WebElement getPerPagePaginationEntries() {
		return perPagePaginationEntries;
	}

	public WebElement getButtonDownloadExcelFacility() {
		return buttonDownloadExcelFacility;
	}

	public WebElement getButtonFacilityFilter() {
		return buttonFacilityFilter;
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

	public List<WebElement> getListPagination() {
		return listPagination;
	}

	public WebElement getButtonNext() {
		return buttonNext;
	}

	public WebElement getPaginationLinkNextEnabled() {
		return paginationLinkNextEnabled;
	}

	public WebElement getPaginationLinkNextDisabled() {
		return paginationLinkNextDisabled;
	}

	public List<WebElement> getColoumnCorporateNameFacilityName() {
		return coloumnCorporateNameFacilityName;
	}

	public void verifyAddedFacility(LinkedHashMap<Object, Object> linkedHashMap) {
		try {

			for (@SuppressWarnings("rawtypes")
			Map.Entry m : linkedHashMap.entrySet()) {
				if (m.getKey().equals("Corporate")) {
					if (m.getValue() != null) {
						elementList = getListPagination();
						while (j < elementList.size()) {
						//	System.out.println("J value - " + j);
							elementList2 = getColoumnCorporateNameFacilityName();
							intValue = elementList2.size();
							while (i < intValue) {
								//System.out.println(i + " - " + elementList2.get(i).getText());
								genericFunctions.scrollToElement(elementList2.get(i));
								GenericFunctions.highlightElement(elementList2.get(i));
								if (elementList2.get(i).getText().equals(m.getValue())) {
								//	System.out.println("FOUND THE VALUE -");
								//	System.out.println(elementList2.get(i).getText() + "" + m.getValue());

									break;
								}
								i++;
							}
							if (!(j == (elementList.size() - 1))) {
								genericFunctions.scrollToElement(getButtonNext());
								getButtonNext().click();
								Thread.sleep(800);
							}
							i = 0;
							j++;
						//	System.out
						//			.println("***********************************************************************");
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyPageHeader() {
		try {
			// verify page Title
			Thread.sleep(2000);
			element = getPageTitleCreateFacility();
			intValue = element.getText().length();
			GenericFunctions.highlightElement(element);
			softAssertion.assertTrue(element.getText().trim().equals("Facility"),
					"'Title' of the page is not displayed . Expected Title is :- 'Facility' ");

			// Verify Header Breadcrum displayed
			intValue = getListBreadcrum().size();
			for (i = 0; i < intValue; i++) {
				GenericFunctions.highlightElement(getListBreadcrum().get(i));
				softAssertion.assertTrue(
						(genericFunctions.verifyLink(getListBreadcrum().get(i).getAttribute("href"))) == 200,
						getListBreadcrum().get(i).getText() + "  Link in the Breadcrum is not clickable");
			}

			GenericFunctions.highlightElement(getTextBreadCrumActivePage());
			softAssertion.assertTrue(getTextBreadCrumActivePage().getText().equals("Facility"),
					"'Facility' text is not as expected ... it is displayed as - "
							+ getTextBreadCrumActivePage().getText());

			genericFunctions.logEvent("Verified the Page Header with titles and breadcrum ...");
			i = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyAboveTableElements() {
		try {
			GenericFunctions.highlightElement(getPerPagePaginationEntries());
			softAssertion.assertTrue(getPerPagePaginationEntries().isDisplayed(), "Entries text is displayed..");
			genericFunctions.logEvent("Verified Entries dropdown is displayed. ");

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

			GenericFunctions.highlightElement(getRightBottomPlusSignIconButton());
			softAssertion.assertTrue(getRightBottomPlusSignIconButton().isDisplayed(),
					"The '+ Icon' is not displayed...");
			Thread.sleep(2000);
			genericFunctions.scrollToElement(getPageTitleCreateFacility());
			GenericFunctions.highlightElement(getRightBottomPlusSignIconButton());
			softAssertion.assertTrue(getRightBottomPlusSignIconButton().isDisplayed(),
					"The '+ Icon' is not displayed...");
			genericFunctions.logEvent("Right Side Bottom icon on the page is displayed all the times..");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyTableHeaders() {
		try {
			elementList = getLabelListTableHeaders();
			intValue = elementList.size();
			sheetName = "departmentListTableLabels";
			fileNameAndExtension = "departmentManagementExcelSheet.xls";
			while (xlValues < data.readData(sheetName, fileNameAndExtension).size()) {
				for (i = 0; i < intValue; i++) {
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
			genericFunctions.logEvent("verified the facility table headers.");
			i = 0;
			xlValues = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToAddressPage(LinkedHashMap<Object, Object> linkedHashMap) {
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

}
