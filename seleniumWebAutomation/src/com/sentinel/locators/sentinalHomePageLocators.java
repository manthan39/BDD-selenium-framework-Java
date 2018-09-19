package com.sentinel.locators;

public interface sentinalHomePageLocators {

	public interface navigateToCreateFacilityFormLocators {
		// Sign In Box Locators

		String LOC_LOGO_UPLEFTCORNORHOMEPAGE_XPATH = "//img[@class='header-logo-collapse']";
		String LOC_IMAGEBUTTON_UPLEFTSIDEBAR_XPATH = "//a[@class='sidebar-toggle']";
		String LOC_COLLAPSABLEMENU_ENTITY_XPATH = "//span[text()='Entity']";
		String LOC_COLLAPSABLEMENU_ADMINISTRATOR_XPATH = "//span[text()='Administrator']";
		String LOC_COLLAPSABLEMENU_ACCOUNTING_XPATH = "(//li[@class='treeview'])[2]";
		String LOC_LINK_FACILITY_XPATH = "(//ul[@class='treeview-menu']/li)[1]";
		String LOC_LINK_DEPARTMENTMANAGEMENT_XPATH = "(//ul[@class='treeview-menu']/li)[2]";
		String LOC_LINK_DISTRIBUTORS_XPATH = "(//ul[@class='treeview-menu']/li)[2]";
		String LOC_LINK_ADMINCONTACTS_XPATH = "(//ul[@class='treeview-menu']/li)[3]";
		String LOC_ICONBUTTON_PLUSSIGN_XPATH = "//div[@class='floating-button']";
		String LOC_TEXTANDICONLIST_CREATEFACILITY_XPATH = "((//div[@class='menu-title'])[4]/../div)";
		String LOC_TEXTANDICONLIST_CREATECORPORATE_XPATH = "((//div[@class='menu-title'])[1]/../div)";
	}

}
