package com.sentinel.locators;

public interface sentinalLoginPageLocators {

	public interface signInboxLocators {
		// Sign In Box Locators
		String LOC_FAVICON_XPATH = "//link[@rel='shortcut icon'][@type='image/x-icon']";
		String LOC_LOGO_POWEREDBY_XPATH = "//div[@class='login-box-body-backdrop']";
		String LOC_LOGO_SIGNIN_XPATH = "(//div[@class='row same-height-block-wrap']/div)[2]";
		//String LOC_TITLE_SIGNINBOX_XPATH = "//div[@class='login-box-title']/h3";
		String LOC_TEXTBOX_USERNAME_XPATH = "//input[@placeholder='Enter Username']";
		String LOC_TEXTBOX_PASSWORD_XPATH = "//input[@placeholder='Enter Password']";
		String LOC_BUTTON_SUBMIT_XPATH = "//button[@type='submit']";
		String LOC_LINK_FORGETUSERNAMEORPASSWORD_XPATH = "//a[@class='login-link']";
	}

	public interface signInFooterLocators {
		// Sign In Page Footer Locators
		String LOC__TEXT_SENTINALADDRESS_CSS = "div.login-box-footer.text-center";
		String LOC_FOOTERLINKS_CSS = "ul.list-unstyled.list-inline ";
		String LOC_FOOTERLINKS1_XPATH = "(//ul[@class='list-unstyled list-inline ']/li/a)";
		String LOC_FOOTERLINKS2_XPATH = "(//ul[@class='list-unstyled list-inline']/li/a)";
	}

	public interface signInErrorMessages {
		// Blank Username and Password -----> Error Messages
		String LOC_ERRORMESSAGE_BLANKLOGIN_XPATH = "(//span[@class='is-error'])[1]";
		String LOC_ERRORMESSAGE_BLANKPASSWORD_XPATH = "(//span[@class='is-error'])[2]";
		// Toaster Fade Away Error Messages.
		String LOC_TOASTERMESSAGE_SIGNIN_XPATH = "//div[@id='toast-container']/div";
	}

	public interface forgetUsernamePasswordPageLocators {
	//	String LOC_TITLE_FORGOTUSERNAMEPASSWORD_XPATH = "//div[@class='login-box-title']/h3";
		String LOC_RADIOBUTTONLABELS_RESENDUSERNAMERESETPASSWORD_XPATH = "//div[@class='radio radio-inline radio-login']";
		String LOC_RADIOBUTTON_RESENDUSERNAMERESETPASSWORD_XPATH = "//div[@class='radio radio-inline radio-login']/input";
		String LOC_TEXTBOX_ENTEREMAILADDRESS_XPATH = "//input[@type='email']";
		String LOC_TEXTBOX_ENTERMOBILENUMBER_XPATH = "//input[@type='text']";
		String LOC_LOGO_DND_CSS = "div.input-group-addon";
		String LOC_TOOLTIP_DND_CSS = "div.input-group-addon i";
		String LOC_BUTTON_SUBMITANDCANCEL_XPATH = "(//div[@class='row']/div/div/button)";
		String LOC_BUTTON_SUBMIT_XPATH = "(//div[@class='row']/div/div/button)[1]";
		// String LOC_BUTTON_SUBMIT_XPATH =
		// "//div[@class='form-group']/button[@type='submit']";
	}

	public interface forgetUsernamePasswordErrorMessagesLocators {
		// Blank Email ID and MOBILE NUMBER -----> Error Messages
		String LOC_ERRORMESSAGE_BLANKEMAILID_XPATH = "(//span[@class='is-error'])[1]";
		String LOC_ERRORMESSAGE_BLANKMOBILENUMBER_XPATH = "(//span[@class='is-error'])[2]";
		String LOC_ERRORMESSAGE_INVALIDEMAILID_XPATH = "//span[2][contains(text(),'Proper')]";
		// Toaster Fade Away Error Messages.
		String LOC_TOASTERMESSAGE_SIGNIN_XPATH = "//div[@id='toast-container']/div";
		String LOC_TOASTERMESSAGE_INVALIDEMAILORMOBILENUMBER_XPATH = "//div[@class='toast-title ng-star-inserted']";
	}

	public interface reSendUsernameMessagesLocators {

		String LOC_TOASTERMESSAGE_RESENDUSERNAME_XPATH = "//div[@class='toast-title ng-star-inserted']";

	}

	public interface enterOneTimePasswordLocators {

		String LOC_TITLE_SCREENTITLE_XPATH = "//h3[@class='title']";
		String LOC_ALERTINFO_ENTERONETIMEPASSWORD_XPATH = "//div[@class='alert alert-info']";
		String LOC_TEXTBOX_ENTEROTP_XPATH = "//input[@type='text']";
		String LOC_BUTTON_RESEND_XPATH = "(//button[@type='button'])[1]";
		String LOC_INFO_ABOUTOTP_XPATH = "//small[@class='text-info']";
		String LOC_BUTTON_SUBMIT_XPATH = "(//button[@type='submit'])";
		String LOC_BUTTON_CANCEL_XPATH = "(//button[@type='button'])[2]";
		String LOC_TOASTERMESSAGE_SUCCESSOTPSENT_XPATH = "//div[@class='toast-title ng-star-inserted']";
		// String LOC_TOASTERMESSAGE_SUCCESSOTPSENT_XPATH =
		// "//div[@class='toast-success toast ng-trigger
		// ng-trigger-flyInOut']/div";
		String LOC_TOASTERMESSAGE_ERROROTPSENT_XPATH = "//div[@class='toast-error toast ng-trigger ng-trigger-flyInOut']/div";
		String LOC_BUTTONLOADINGICON_SENDING_XPATH = "//button[@class='btn btn-default resend-otp ng-star-inserted']";
		String LOC_TOASTERMESSAGE_MAXIMUMRESENTOTPLIMIT_XPATH = "//div[@class='toast-title ng-star-inserted']";

	}

	public interface newPasswordLocators {

		String LOC_TITLE_NEWPASSWORD_XPATH = "//h3[@class='title']";
		String LOC_ALERTINFO_PASSWORD_XPATH = "//div[@class='col-sm-6 login-box-body-right same-height-block']/div[2]";
		String LOC_TEXTBOX_ENTERNEWPASSWORD_XPATH = "(//div[contains(@class,'form-group')]/input)[1]";
		String LOC_TEXTBOX_CONFIRMNEWPASSWORD_XPATH = "(//div[contains(@class,'form-group')]/input)[2]";
		String LOC_BUTTON_SUBMIT_XPATH = "(//div[@class='form-group']/button)[1]";
		String LOC_BUTTON_CANCEL_XPATH = "(//div[@class='form-group']/button)[2]";
		String LOC_TOASTERMESSAGE_SUCCESSPASSWORDCHANGE_XPATH = "//div[@class='toast-title ng-star-inserted']";
		String LOC_TOASTERMESSAGE_SUCCESSPASSWORDCHANGE_CSS = "div.toast-title.ng-star-inserted";
		String LOC_TOASTERMESSAGE_RESETPASSWORDMAXIMUMLIMIT_XPATH = "//div[@class='toast-title ng-star-inserted']";
		String LOC_LINK_CLICKHERE_XPATH = "//a[@class='alert-link']";
	}

	public interface OTPErrorMessagesLocators {

		String LOC_ERRORMESSAGE_BLANKOTP_XPATH = "//span[@class='is-error']";
		String LOC_TOASTERMESSAGE_OTPCHARLIMIT_XPATH = "//div[@class='toast-title ng-star-inserted']";
		String LOC_TOASTERMESSAGE_INVALIDOTP_XPATH = "//div[@class='toast-title ng-star-inserted']";

	}

	public interface changePasswordAndConfirmPasswordMessagesLocators {

		String LOC_ERRORMESSAGE_BLANKCHANGEPASSWORD_XPATH = "(//span[@class='is-error ng-star-inserted'])[1]";
		String LOC_ERRORMESSAGE_BLANKCONFIRMPASSWORD_XPATH = "(//span[@class='is-error ng-star-inserted'])[2]";
		String LOC_ERRORMESSAGE_INVALIDCONFIRMPASSWORD_XPATH = "(//span[@class='is-error ng-star-inserted'])[1]";

	}

}
