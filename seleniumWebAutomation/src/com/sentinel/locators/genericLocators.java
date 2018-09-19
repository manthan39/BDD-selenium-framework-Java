package com.sentinel.locators;

public interface genericLocators {
	// genericLocators.locators
	public interface locators {
		String LOC_TITLE_XPATH = "//div[contains(@class,'login-box')]/h3";
		String LOC_LINK_BREADCRUM_XPATH = "(//ol[@class='breadcrumb']/li/a)";
		String LOC_BREADCRUM_CURRENTACTIVEPAGE_XPATH = "//li[@class='active']";
		String LOC_INFO_LINKEXPIRED_XPATH = "//div[@class='alert alert-info']//p";
		String LOC_ICONBUTTON_EDIT_XPATH = "//a[@class='btn-lg']";
		String LOC_PAGETITLE_XPATH = "//section[@class='content-header']/h1";
		String LOC_PAGINATION_PERPAGEENTRIES_XPATH = "//div[@class='dataTables_length']/label";
		String LOC_PAGINATION_PREVIOUSNEXT_CSS = "pagination-template ul";
		String LOC_LABEL_SHOWINGPAGINATIONCOUNT_XPATH = "//div[contains(@class,'dataTables_info')]";
		String LOC_LABELLIST_TABLEHEADER_XPATH = "//div[@class='table-responsive']/table/thead/tr/th";
		String LOC_LOADERIMAGE_XPATH = "//div[@id='loader-wrapper']/div[@id='loader']";
		String LOC_SEARCH_XPATH = "//input[@type='search']";
		String LOC_COLLAPSALBUTTON_NEW_XPATH = "(//button[@type='button'])[2]";
		String LOC_RADIOBUTTON_ACTIVE_XPATH = "(//div[contains(@class,'radio radio-inline')]/input)[1]/following-sibling::label";
		String LOC_RADIOBUTTON_INACTIVE_XPATH = "(//div[contains(@class,'radio radio-inline')]/input)[2]/following-sibling::label";
		String LOC_FACILITYTABS_XPATH = "//div[@class='tabs-resp-custom ng-star-inserted']/ul/li/a[contains(@class,'nav-link')]";
		String LOC_PAGINATION_NEXT_XPATH="//li[contains(@class,'pagination-next')]/a";
		String LOC_TEXTBOX_NORMALTEXTBOX_XPATH = "//label[@class='control-label']/following-sibling::input";
		String LOC_LABEL_NORMALTEXTBOX_XPATH = "//label[@class='control-label']/following-sibling::input/preceding-sibling::label";
		String LOC_LABEL_RADIOBUTTONS_XPATH = "((((//div[@class='radio radio-inline'])/input)/..)/..)/preceding-sibling::label";
		String LOC_RADIOBUTTONINPUTLIST_ACTIVEINACTIVE_XPATH = "((//div[@class='radio radio-inline'])/input)";
		String LOC_LABELLIST_RADIOBUTTONS_XPATH = "(//div[@class='radio radio-inline'])/label";
		String LOC_RADIOBUTTONINPUT_ACTIVE_XPATH = "((//div[@class='radio radio-inline']))[1]";
		String LOC_RADIOBUTTONINPUT_INACTIVE_XPATH = "((//div[@class='radio radio-inline']))[2]";
		String LOC_ERRORMESSAGESLIST_COMPULSARYFIELDSBLANK_XPATH = "//span[starts-with(@class,'is-error')]";
			
	}

	public interface loadingImageLocators {
		String LOC_IMAGE_LOADING_XPATH = "//div[@id='loader']";
	}

	public interface logoutLocators {
		String LOC_DROPDOWN_UPPERRIGHTSIDELOGOUT_XPATH = "//li[@class='dropdown user user-menu']//a[@class='dropdown-toggle']";
		String LOC_DROPDOWNMENU_PROFILE_XPATH = "//ul[@class='dropdown-menu']/li";
		String LOC_BUTTON_LOGOUT_XPATH = "//ul[@class='dropdown-menu']/li[3]/button";
	}

	public interface toasterMessagesLocators {
		String LOC_TOASTERMESSAGE__XPATH = "//div[contains(@class,'ng-star-inserted')]";
	}

	public interface tableHeadersList {
		String LOC_LABELLIST_TABLEHEADER_XPATH = "//div[contains(@class,'active')]//tr/th";
		String LOC_LABEL_TABLENAME_XPATH = "//h5[@class='header_title']";
		String LOC_DEFAULTMESSAGE_TABLE_XPATH = "//div[contains(@class,'active')]//td";
		String LOC_LIST_TEXTBOX_XPATH = "(//div[contains(@class,'active')]//label)/following-sibling::input[@type='text']";
		String LOC_LABELLIST_TEXTBOX_XPATH = "(//div[contains(@class,'active')]//label)/following-sibling::input[@type='text']/preceding-sibling::label";
	}

	public interface formFieldsList {
		String LOC_LIST_TEXTBOX_XPATH = "(//div[contains(@class,'active')]//label)/following-sibling::input[@type='text']";
		String LOC_LABELLIST_TEXTBOX_XPATH = "(//div[contains(@class,'active')]//label)/following-sibling::input[@type='text']/preceding-sibling::label";
		String LOC_LIST_DROPDOWN_XPATH = "(//div[contains(@class,'active')]//ng-select)";
		String LOC_LABELLIST_DROPDOWNS_XPATH = "(//div[contains(@class,'active')]//ng-select)/preceding-sibling::label";
		String LOC_BUTTON_SAVE_XPATH = "//button[contains(@class,'btn btn-success')]";
		String LOC_BUTTON_CANCEL_XPATH = "//button[contains(@class,'btn btn-default')]";
		String LOC_ERRORMESSAGELIST_XPATH = "//span[contains(@class,'is-error')]";
	}

	public interface tableData {
		String LOC_DATA_TABLE_XPATH = "//tbody/tr/td";
		String LOC_ICON_ACTIONEDIT_XPATH = "(//tr[@class='ng-star-inserted']/td[4])";
		String LOC_FIRSTROWDATA_TABLE_XPATH = "// tbody/tr/td[1]";
	}
}
// genericLocators.tableData