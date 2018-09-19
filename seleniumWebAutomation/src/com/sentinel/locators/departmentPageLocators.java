package com.sentinel.locators;

public interface departmentPageLocators {
	
	public interface tableAddressPageLocators {
		String LOC_TEXTBOX_DEPARTMENTNAME_XPATH = "//input[@formcontrolname='name'][@placeholder='Enter Department Name']";
		String LOC_TEXTBOXDROPDOWN_DEPARTMENTNAME_XPATH = "//div[@class='ng-dropdown-panel-items scroll-host']/div//div";
		String LOC_ICON_DEPARTMENTMANAGEMENTACTIONEDIT_XPATH="(//td/a)";
		String LOC_TABLEDATA_FIRSTROW_XPATH="//tr[@class='ng-star-inserted']/td[1]";
	}

	public interface facilityDepartmentPageLocators {
		String LOC_TAB_SETUP_XPATH = "//a[text()='Setup']";
		String LOC_TAB_DEPARTMENTS_XPATH = "//a[text()='Departments']";
		String LOC_CHECKBOX_CREATEDEPARTMENT_XPATH = "(//input[@formcontrolname='department'])/following-sibling::label";
		String LOC_TEXTBOX_DEPARTMENTNAME_XPATH = "((//div[@class='form-group']/ng-select)/div)[1]";
		String LOC_DROPDOWN_ADDITEM_XPATH = "//span[@class='ng-tag-label'][text()='Add item']";
		String LOC_DROPDOWN_ISANADMIN_XPATH = "//ng-select[@formcontrolname='dept_isadmin']";
		String LOC_DROPDOWNLIST_ISANADMIN_XPATH = "//ng-select[@formcontrolname='dept_isadmin']//div[contains(@class,'ng-option')]";
		String LOC_TEXTBOX_MOVETODEPARTMENT_XPATH = "(//ng-select[@formcontrolname='move_to_department'])";
		String LOC_DROPDOWNLIST_MOVETODEPARTMENT_XPATH = "(//ng-select[@formcontrolname='move_to_department'])/ng-dropdown-panel//div//div/div";
	}

}
