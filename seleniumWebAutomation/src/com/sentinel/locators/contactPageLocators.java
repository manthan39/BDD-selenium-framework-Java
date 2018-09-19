package com.sentinel.locators;

public interface contactPageLocators {

	public interface tableContactPageLocators {

		String LOC_TAB_CONTACT_XPATH = "//ul[@class='nav nav-tabs']/li/a[text()='Contacts']";
		String LOC_TABLEDATA_NEWCONTACT_XPATH = "((//div[contains(@class,'active')])//table/tbody/tr[1]/td)";

	}

	public interface newContactPageLocators {

		String LOC_TEXTBOX_UPLOADPROFILEIMAGE_XPATH = "//div[contains(@class,'active')]//input[@formcontrolname='profileimage']";
		String LOC_LABEL_UPLOADPROFILEIMAGE_XPATH = "(//div[contains(@class,'active')]//input[@formcontrolname='profileimage'])/preceding-sibling::label";
		String LOC_BUTTON_UPLOADPROFILEIMAGE_XPATH = "(//div[contains(@class,'active')]//input[@formcontrolname='profileimage'])/parent::div/div/span";
		String LOC_INFOTEXT_UPLOADPROFILEIMAGE_XPATH = "((//div[contains(@class,'active')]//input[@formcontrolname='profileimage'])/parent::div/div)[2]/small";
		String LOC_TEXTBOX_USERNAME_XPATH = "//div[contains(@class,'active')]//input[@formcontrolname='username']";
		String LOC_TEXTBOX_FIRSTNAME_XPATH = "//div[contains(@class,'active')]//input[@formcontrolname='firstname']";
		String LOC_TEXTBOX_LASTNAME_XPATH = "//div[contains(@class,'active')]//input[@formcontrolname='lastname']";
		String LOC_TEXTBOX_EMAIL_XPATH = "//div[contains(@class,'active')]//input[@formcontrolname='email']";
		String LOC_TEXTBOX_CONTACTPHONE_XPATH = "//div[contains(@class,'active')]//input[@formcontrolname='contactphone']";
		String LOC_DROPDOOWN_SALUTATION_XPATH = "//div[contains(@class,'active')]//ng-select[@formcontrolname='salutation']";
		String LOC_DROPDOOWN_ISBILLING_XPATH = "//div[contains(@class,'active')]//ng-select[@formcontrolname='isbilling']";
		String LOC_DROPDOOWN_DEPARTMENT_XPATH = "//div[contains(@class,'active')]//ng-select[@formcontrolname='department']";
		String LOC_DROPDOOWNLIST_XPATH = "//div[contains(@class,'active')]//div[contains(@class,'ng-option')]";
		String LOC_TEXTBOX_EXTENSION_XPATH = "//div[contains(@class,'active')]//input[@formcontrolname='extension']";
		String LOC_TEXTBOX_BUSINESSPHONE_XPATH = "//div[contains(@class,'active')]//input[@formcontrolname='businessphone']";
		String LOC_TEXTBOX_FAX_XPATH = "//div[contains(@class,'active')]//input[@formcontrolname='fax']";
		String LOC_TEXTBOX_TITLE_XPATH = "//div[contains(@class,'active')]//input[@formcontrolname='title']";
		String LOC_BUTTONLIST_DROPDOWNCROSS_XPATH = "//span[contains(@class,'ng-clear-wrapper')]/span";
		String LOC_LABEL_RESENDUSERNAME_XPATH = "((//div[contains(@class,'active')])//input[@formcontrolname='resendusername'])/following-sibling::label";
		String LOC_CHECKBOX_RESENDUSERNAME_XPATH = "((//div[contains(@class,'active')])//input[@formcontrolname='resendusername'])";
		String LOC_LABEL_RESETPASSWORD_XPATH = "((//div[contains(@class,'active')])//input[@formcontrolname='resetpassword'])/following-sibling::label";
		String LOC_CHECKBOX_RESETPASSWORD_XPATH = "((//div[contains(@class,'active')])//input[@formcontrolname='resetpassword'])";

	}

	public interface linkExpiredLocators {

		String LOC_LINK_SUPPORTMAIL_XPATH = "//a[@class='alert-link'][1]";
		String LOC_LINK_CLICKHERE_XPATH = "//a[@class='alert-link'][2]";
	}

}
// contactPageLocators.linkExpiredLocators.LOC_LINK_CLICKHERE_XPATH