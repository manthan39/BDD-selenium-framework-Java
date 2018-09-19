package com.sentinel.locators;

public interface addressPageLocators {

	public interface tableAddressPageLocators {
		String LOC_TITLE_ADDRESSPAGE_XPATH = "//section[starts-with(@class,'content-header')]/h1";
		String LOC_TITLE_ADDRESSPAGEFACILITYID_XPATH = "//section[starts-with(@class,'content-header')]/h1/small";
		String LOC_TITLE_ACTIVEORINACTIVESTATUS_XPATH = "//section[starts-with(@class,'content-header')]//h4";
		String LOC_LIST_TABS_XPATH = "(//ul[@class='nav nav-tabs']/li/a/span)";
		String LOC_TAB_ADDRESSES_XPATH = "//span[text()='Addresses']";
		
	}

	public interface newAddressPageLocators {
		String LOC_ERRORMESSAGELIST_BLANKFIELDS_XPATH = "//span[contains(@class,'is-error')]";
		String LOC_DROPDOWN_ADDRESSTYPE_XPATH = "(//ng-select[@formcontrolname='type'])";
		String LOC_TEXTBOX_ADDRESSLINE1_XPATH = "(//input[@formcontrolname='address'])";
		String LOC_TEXTBOX_ADDRESSLINE2_XPATH = "(//input[@formcontrolname='address2'])";
		String LOC_DROPDOWN_STATEID_XPATH = "(//ng-select[@formcontrolname='state_id'])";
		String LOC_DROPDOWN_CITYID_XPATH = "(//ng-select[@formcontrolname='city_id'])";
		String LOC_TEXTBOX_ZIP_XPATH = "(//input[@formcontrolname='zip'])";
		String LOC_LIST_TOTALNEWADDRESSFIELDS_XPATH = "((//div[@class='form-group'])/label)";

		// String LOC_OPTIONSLIST_DROPDOWN_XPATH
		// ="(//span[@class='ng-option-label'])";
		String LOC_OPTIONSLIST_DROPDOWN_XPATH = "(//span[starts-with(@class,'ng-option-label')])";
		String LOC_CROSS_CLEARDROPDOWN_XPATH = "(//span[@class='ng-clear'])[1]";

	}

}
