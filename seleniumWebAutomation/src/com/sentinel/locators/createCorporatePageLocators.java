package com.sentinel.locators;

public interface createCorporatePageLocators {
	// createCorporatePageLocators.formPageLocators.LOC_CHECKBOX_PERMANENTPOSPERFACILITY_XPATH
	public interface formPageLocators {

		String LOC_DROPDOWNLIST_XPATH = "(//ng-select)";
		String LOC_TEXTAREA_XPATH = "//textarea";
		String LOC_CHECKBOX_PERMANENTPOSPERFACILITY_XPATH = "//label[contains(text(),'Permanent Pos Per Facility')]";

		String LOC_DATEPICKER_FIRSTCONTACTDATE_XPATH = "//input[@id='firstcontactdate']";
		String LOC_TEXTBOX_CORPORATENAME_XPATH = "//input[@formcontrolname='facilityname']";
		String LOC_TEXTBOX_FIRSTCONTACTMADEBY_XPATH = "//input[@formcontrolname='contactmadeby']";
		String LOC_TEXTBOX_EMAIL_XPATH = "//input[@formcontrolname='email']";
		String LOC_TEXTBOX_CONTACTPHONE_XPATH = "//input[@formcontrolname='phone']";
		String LOC_TEXTBOX_REFERREDBY_XPATH = "//input[@formcontrolname='referredby']";
		String LOC_TEXTBOX_TAXID_XPATH = "//input[@formcontrolname='taxid']";
		String LOC_TEXTBOX_WEBSITE_XPATH = "//input[@formcontrolname='website']";
		String LOC_TEXTBOX_FAX_XPATH = "//input[@formcontrolname='fax']";

	}

}
