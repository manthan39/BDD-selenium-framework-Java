package com.sentinel.locators;

public interface sentinalCreateFacilityFormPageLocators {

	public interface CreateFacilityFormLocators {

		String LOC_SMALLTITLE_CUSTOMERCODE_XPATH = "//section[@class='content-header']/h1/small/strong";
		String LOC_ELEMENTS_ONPAGE_XPATH = "(//div[@class='box-body']/div/div)";
		String LOC_BUTTONLIST_UPLOADFACILITYLOGOANDFAVICON_XPATH = "((//span[@class='buttonText']/preceding-sibling::span/..)/..)";
		String LOC_LABELLIST_FACILITYLOGOANDFAVICON_XPATH = "(((//span[@class='buttonText']/preceding-sibling::span/..)/..)/..)/preceding-sibling::label";
		String LOC_INFOTEXTLIST_FACILITYLOGOANDFAVICON_XPATH = "(((((//span[@class='buttonText']/preceding-sibling::span/..)/..)/..)/preceding-sibling::label)/following-sibling::div)/following-sibling::p/small";
		String LOC_TEXTBOX_IMAGEUPLOAD_XPATH = "(((((//span[@class='buttonText']/preceding-sibling::span/..)/..)/..)/preceding-sibling::label)/following-sibling::div/input)";
		String LOC_LIST_TOOLTIP_XPATH = "(//div[@class='help-inline']/a)";
		String LOC_LIST_TOOLTIPTEXTBOXES_XPATH = "(//div[@class='help-inline'])";
		String LOC_PLACEHOLDERSLIST_TOOLTIPTEXTBOXES_XPATH = "(//div[@class='help-inline']/input)";
		String LOC_HELPTEXT_FACILITYSHORTNAME_XPATH = "((//div[@class='help-inline']/input)/..)/p/small";
		String LOC_LABELSLIST_TOOLTIPTEXTBOXES_XPATH = "(//div[@class='help-inline'])/preceding-sibling::label";
		String LOC_LIST_DROPDOWNS_XPATH = "(//select)";
		String LOC_LIST_TEXTAREAS_XPATH = "(//textarea)";
		String LOC_LABELSLIST_TEXTAREAS_XPATH = "((//textarea)/preceding-sibling::label)";
		String LOC_HELPTEXT_FORCOMMENTS_XPATH = "(((//textarea)/preceding-sibling::label)/following-sibling::p)/small";
		String LOC_BUTTONLIST_SAVEANDCANCEL_XPATH = "(//div[@class='row']/div/button)";
		String LOC_CHECKBOXLIST_DISTRIBUTORCREATEDEPARTMENT_XPATH = "//label[starts-with(@for,'checkbox1')]/../input";
		String LOC_CHECKBOXLABELLIST_DISTRIBOTERCREATEDEPARTMENT_XPATH = "(((//label[starts-with(@for,'checkbox1')]/../input)/..)/..)/preceding-sibling::label";
		String LOC_LABEL_SALESTAX_XPATH = "(//div[@class='input-group'])/preceding-sibling::label";
		String LOC_TEXTBOX_SALESTAX_XPATH = "((//div[@class='input-group'])/input)[2]";
		String LOC_ICON_SALESTAX_XPATH = "((//div[@class='input-group'])/input/following-sibling::div)[2]";
	}

	public interface CreateFacilityCompulsaryElementsLocators {

		String LOC_TEXTBOX_FACILITYNAME_XPATH = "//input[@formcontrolname='facilityname']";
		String LOC_TEXTBOX_FACILITYCONTACTEMAIL_XPATH = "//input[@formcontrolname='email']";
		String LOC_TEXTBOX_FACILITYCONTACTPHONE_XPATH = "//input[@formcontrolname='phone']";
		String LOC_TEXTBOX_FACILITYSALESTAXRATE_XPATH = "//input[@formcontrolname='salestaxrate']";
		String LOC_TEXTBOX_FACILITYBILLINGEMAILANDFAX_XPATH = "//textarea[@formcontrolname='billingcontactmethod']";
		String LOC_TEXTBOX_FACILITYSALESTAXEXEMPTIONNUMBER_XPATH = "//input[@formcontrolname='taxexemptnumber']";
		String LOC_TEXTBOX_FACILITYFAX_XPATH = "//input[@formcontrolname='fax']";
		String LOC_TEXTBOX_FACILITYSALESTAXID_XPATH = "//input[@formcontrolname='salestaxid']";
		String LOC_TEXTBOX_FACILITYWEBSITE_XPATH = "//input[@formcontrolname='website']";
		String LOC_TEXTBOX_FACILITYSHORTNAME_XPATH = "//input[@formcontrolname='shortname']";
	//	String LOC_ERRORMESSAGESLIST_COMPULSARYFIELDSBLANK_XPATH = "//span[starts-with(@class,'is-error')]";
	}

	public interface CreateFacilityAllElementsLocators {
		String LOC_DROPDOWN_CORPORATE_XPATH = "//select[@formcontrolname='corporate']";
		String LOC_DROPDOWN_DIVISION_XPATH = "//select[@formcontrolname='division']";
		String LOC_DROPDOWN_REGION_XPATH = "//select[@formcontrolname='region']";
		String LOC_DROPDOWN_BILLINGMETHOD_XPATH = "//select[@formcontrolname='billingmethod']";
		String LOC_CHECKBOX_ALLOWTAXPERDISTRIBUTOR_XPATH = "//input[@formcontrolname='facilitysalestaxperdistributor_opt']";
		String LOC_CHECKBOX_CREATEDEPARTMENTFORFACILITY_XPATH = "//input[@formcontrolname='department']";
		String LOC_UPLOAD_FACILITYLOGO_XPATH = "((//div/label[text()=' Facility Logo'])/following-sibling::div/input)/following-sibling::span";
		String LOC_UPLOAD_FACILITYFAVICON_XPATH = "((//div/label[text()=' Facility Favicon'])/following-sibling::div/input)/following-sibling::span";
		String LOC_TEXTBOX_FACILITYLOGO_XPATH = "((//div/label[text()=' Facility Logo'])/following-sibling::div/input)";
		String LOC_TEXTBOX_FACILITYFAVICON_XPATH = "((//div/label[text()=' Facility Favicon'])/following-sibling::div/input)";
		String LOC_TEXTBOX_COMMENTS_XPATH = "//textarea[@formcontrolname='comments']";
		String LOC_BUTTON_SAVEANDEXIT_XPATH = "(//div[starts-with(@class,'col-xs-12')]/button)[1]";
		String LOC_BUTTON_SAVEANDNEXT_XPATH = "(//div[starts-with(@class,'col-xs-12')]/button)[2]";
		String LOC_BUTTON_CANCEL_XPATH = "(//div[starts-with(@class,'col-xs-12')]/button)[3]";
		String LOC_TOASTERMESSAGE_XPATH = "//div[@class='toast-title ng-star-inserted']";
	}

	public interface filterElementsLocators {
		String LOC_BUTTON_FILTER_XPATH = "//button[@id='button-basic']";
		String LOC_TEXTBOX_NAME_XPATH = "(//div[@class='form-group']/input)";
		String LOC_LABEL_NAME_XPATH = "((//div[@class='form-group']/input)/preceding-sibling::label)";
		String LOC_DROPDOWNLIST_FILTER_XPATH = "((//div[@class='form-group'])/ng-select)";
		String LOC_DROPDOWNLISTLABEL_FILTER_XPATH = "(((//div[@class='form-group'])/ng-select)/preceding-sibling::label)";
		String LOC_DROPDOWNLIST_XPATH = "//div[@class='ng-dropdown-panel-items scroll-host']/div/div";
		String LOC_BUTTON_APPLY_XPATH = "(//button[@class='btn btn-success'])[1]";
		String LOC_BUTTON_RESET_XPATH = "(//button[@class='btn btn-default'])[1]";
		String LOC_DROPDOWN_STATE_XPATH = "((//div[@class='form-group'])/ng-select[@id='state'])";
		String LOC_DROPDOWN_CITY_XPATH = "((//div[@class='form-group'])/ng-select[@id='city'])";
		String LOC_DROPDOWN_SELECTSTATUS_XPATH = "(((//div[@class='form-group'])/ng-select)[3])";

	}

}
