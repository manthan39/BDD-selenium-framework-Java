package com.sentinel.locators;

public interface facilityPageLocators {

	public interface facilityListingLocators {
		String LOC_COLOUMN_CORPORATENAMEFACILITYNAME_XPATH = "(//td[@class='custom-child-table in-table-view with_info'])";
		String LOC_ROW_ALLROWELEMENTS_XPATH ="(//tr[@class='ng-star-inserted'])";
		String LOC_LINKPAGINATION_NEXTENABLED_XPATH = "//li[@class='pagination-next']/a";
		String LOC_LINKPAGINATION_NEXTDISABLED_XPATH = "//li[@class='pagination-next disabled']/span";
		String LOC_BUTTON_NEXT_XPATH = "//li[starts-with(@class,'pagination-next')]/a";
	
		String LOC_LIST_PAGINATION_XPATH = "//span[starts-with(@class,'show-for-sr')]/following-sibling::span";
	//	String LOC_BUTTON_FILTER_XPATH ="//a[@class='dropdown-toggle btn btn-outline-primary']";
		String LOC_BUTTON_FILTER_XPATH =	"//div[contains(@class,'pull-left dropdown-custom-wrap')]";
		String LOC_DOWNLOADEXCEL_FACILITY_XPATH ="//div[@class='text-right m-b-sm']/a/i";
		String LOC_DROPDOWN_PERPAGEENTRIES_XPATH ="//div[@class='dataTables_length']/label/select";
		String LOC_LIST_EDIT_XPATH ="(//td[@class='text-center'])/a/following-sibling::a";	
		String LOC_LIST_FIRSTROW_XPATH ="((//tbody/tr)[1])/td";
	}

	
}
