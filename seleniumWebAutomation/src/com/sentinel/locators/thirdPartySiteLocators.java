package com.sentinel.locators;

public interface thirdPartySiteLocators {
	public interface mailinatorMailBoxLocators {
		String LOC_TEXTBOX_CHECKANYINBOX_XPATH = "//input[@type='text']";
		String LOC_TEXTLINK_GENERATEDMAIL_XPATH = "(//ul[@class='single_mail-body']/li)[1]";
		String LOC_IFRAME_EMAILBODY_XPATH = "//iframe[@id='msg_body']";
		//String LOC_TEXT_EMAILBODY_XPATH = "//body/p";
		String LOC_TEXT_EMAILBODY_XPATH = "(//td[@class='content']//td)[1]";
		String LOC_LINK_CLICKHERE_XPATH = "(//td[@class='content']//td)/p/a";
	
	}
}
