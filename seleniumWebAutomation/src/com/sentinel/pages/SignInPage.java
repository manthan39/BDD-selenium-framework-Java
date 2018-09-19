package com.sentinel.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.sentinel.databaseUtility.ProjectDatabaseQueries;
import com.sentinel.driver.WebDriverTestBase;
import com.sentinel.locators.genericLocators;
import com.sentinel.locators.genericLocators.logoutLocators;
import com.sentinel.locators.sentinalHomePageLocators.navigateToCreateFacilityFormLocators;
import com.sentinel.locators.sentinalLoginPageLocators.OTPErrorMessagesLocators;
import com.sentinel.locators.sentinalLoginPageLocators.changePasswordAndConfirmPasswordMessagesLocators;
import com.sentinel.locators.sentinalLoginPageLocators.enterOneTimePasswordLocators;
import com.sentinel.locators.sentinalLoginPageLocators.forgetUsernamePasswordErrorMessagesLocators;
import com.sentinel.locators.sentinalLoginPageLocators.forgetUsernamePasswordPageLocators;
import com.sentinel.locators.sentinalLoginPageLocators.newPasswordLocators;
import com.sentinel.locators.sentinalLoginPageLocators.reSendUsernameMessagesLocators;
import com.sentinel.locators.sentinalLoginPageLocators.signInErrorMessages;
import com.sentinel.locators.sentinalLoginPageLocators.signInFooterLocators;
import com.sentinel.locators.sentinalLoginPageLocators.signInboxLocators;
import com.sentinel.locators.thirdPartySiteLocators;
import com.sentinel.locators.thirdPartySiteLocators.mailinatorMailBoxLocators;
import com.sentinel.utils.ExcelUtility;
import com.sentinel.utils.GenericFunctions;
import com.sentinel.utils.SoftAssertUtil;

public class SignInPage extends WebDriverTestBase {

	String stringValue = null, stringValue1 = null, dbValue = null;
	String changePasswordFlag = null;
	int i = 0, j = 0, intValue = 0;
	GenericFunctions genericFunctions = new GenericFunctions();
	ExcelUtility data = new ExcelUtility();
	Actions action = new Actions(driver);
	ArrayList<String> arrayListValue = null;
	String[] stringValueArray = null;
	String fileNameAndExtension = null;

	// This is the constructor
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = signInboxLocators.LOC_LOGO_POWEREDBY_XPATH)
	@CacheLookup
	private WebElement leftPanePoweredByLogo;

	@FindBy(xpath = signInboxLocators.LOC_LOGO_SIGNIN_XPATH)
	@CacheLookup
	private WebElement rightPaneSignIn;

	@FindBy(css = signInFooterLocators.LOC__TEXT_SENTINALADDRESS_CSS)
	@CacheLookup
	private WebElement textSentianalAddress;

	@FindBy(xpath = signInFooterLocators.LOC_FOOTERLINKS1_XPATH)
	@CacheLookup
	private List<WebElement> footerLink1;

	@FindBy(xpath = signInFooterLocators.LOC_FOOTERLINKS2_XPATH)
	@CacheLookup
	private List<WebElement> footerLink2;

	@FindBy(xpath = genericLocators.locators.LOC_TITLE_XPATH)
	@CacheLookup
	private WebElement titleSignInBox;

	@FindBy(xpath = signInboxLocators.LOC_LINK_FORGETUSERNAMEORPASSWORD_XPATH)
	private WebElement linkForgetUsernameOrPassword;

	@FindBy(xpath = signInboxLocators.LOC_TEXTBOX_USERNAME_XPATH)
	private WebElement textboxUsername;

	@FindBy(xpath = signInboxLocators.LOC_TEXTBOX_PASSWORD_XPATH)
	private WebElement textboxPassword;

	@FindBy(xpath = signInboxLocators.LOC_BUTTON_SUBMIT_XPATH)
	private WebElement buttonLogIn;

	@FindBy(xpath = signInErrorMessages.LOC_ERRORMESSAGE_BLANKLOGIN_XPATH)
	@CacheLookup
	private WebElement errorMessageBlankUsername;

	@FindBy(xpath = signInErrorMessages.LOC_ERRORMESSAGE_BLANKPASSWORD_XPATH)
	@CacheLookup
	private WebElement errorMessageBlankPassword;

	@FindBy(xpath = signInErrorMessages.LOC_TOASTERMESSAGE_SIGNIN_XPATH)
	private WebElement toasterMessage;

	@FindBy(xpath = signInboxLocators.LOC_FAVICON_XPATH)
	@CacheLookup
	private WebElement faviconIcon;

	@FindBy(xpath = forgetUsernamePasswordPageLocators.LOC_RADIOBUTTONLABELS_RESENDUSERNAMERESETPASSWORD_XPATH)
	private List<WebElement> labelRadioBtnResendUsernameResetPassword;

	@FindBy(xpath = forgetUsernamePasswordPageLocators.LOC_RADIOBUTTON_RESENDUSERNAMERESETPASSWORD_XPATH)
	@CacheLookup
	private List<WebElement> radioBtnResendUsernameResetPassword;

	@FindBy(xpath = genericLocators.locators.LOC_TITLE_XPATH)
	@CacheLookup
	private WebElement labelForgotUsernamePassword;

	@FindBy(xpath = forgetUsernamePasswordPageLocators.LOC_TEXTBOX_ENTEREMAILADDRESS_XPATH)
	private WebElement textboxEnterEmailAddress;

	@FindBy(xpath = forgetUsernamePasswordPageLocators.LOC_TEXTBOX_ENTERMOBILENUMBER_XPATH)
	@CacheLookup
	private WebElement textboxEnterMobileNumber;

	@FindBy(css = forgetUsernamePasswordPageLocators.LOC_LOGO_DND_CSS)
	@CacheLookup
	private WebElement logoDnd;

	@FindBy(css = forgetUsernamePasswordPageLocators.LOC_TOOLTIP_DND_CSS)
	@CacheLookup
	private WebElement tooltipDnd;

	@FindBy(xpath = forgetUsernamePasswordPageLocators.LOC_BUTTON_SUBMITANDCANCEL_XPATH)
	@CacheLookup
	private List<WebElement> buttonSubmitAndCancel;

	@FindBy(xpath = forgetUsernamePasswordPageLocators.LOC_BUTTON_SUBMIT_XPATH)
	private WebElement buttonSubmit;

	@FindBy(xpath = forgetUsernamePasswordErrorMessagesLocators.LOC_ERRORMESSAGE_BLANKEMAILID_XPATH)
	@CacheLookup
	private WebElement errorMessageBlankEmailID;

	@FindBy(xpath = forgetUsernamePasswordErrorMessagesLocators.LOC_ERRORMESSAGE_BLANKMOBILENUMBER_XPATH)
	@CacheLookup
	private WebElement errorMessageBlankMobileNumber;

	@FindBy(xpath = forgetUsernamePasswordErrorMessagesLocators.LOC_ERRORMESSAGE_INVALIDEMAILID_XPATH)
	private WebElement errorMessageProperEmailID;

	@FindBy(xpath = forgetUsernamePasswordErrorMessagesLocators.LOC_TOASTERMESSAGE_INVALIDEMAILORMOBILENUMBER_XPATH)
	@CacheLookup
	private WebElement toasterMessageInvalidEmailOrPassword;

	@FindBy(xpath = genericLocators.loadingImageLocators.LOC_IMAGE_LOADING_XPATH)
	@CacheLookup
	private WebElement imageLoading;

	@FindBy(xpath = reSendUsernameMessagesLocators.LOC_TOASTERMESSAGE_RESENDUSERNAME_XPATH)
	@CacheLookup
	private WebElement toasterMessageResendUsername;

	@FindBy(xpath = thirdPartySiteLocators.mailinatorMailBoxLocators.LOC_TEXTBOX_CHECKANYINBOX_XPATH)
	private WebElement textboxCheckAnyInbox;

	@FindBy(xpath = thirdPartySiteLocators.mailinatorMailBoxLocators.LOC_TEXTLINK_GENERATEDMAIL_XPATH)
	private WebElement textLinkGeneratedMail;

	@FindBy(xpath = thirdPartySiteLocators.mailinatorMailBoxLocators.LOC_IFRAME_EMAILBODY_XPATH)
	private WebElement iframeMailinatorEmailBody;

	@FindBy(xpath = thirdPartySiteLocators.mailinatorMailBoxLocators.LOC_TEXT_EMAILBODY_XPATH)
	private WebElement textMailinatorEmail;

	@FindBy(xpath = enterOneTimePasswordLocators.LOC_TITLE_SCREENTITLE_XPATH)
	@CacheLookup
	private WebElement titleEnterOneTimePassword;

	@FindBy(xpath = mailinatorMailBoxLocators.LOC_LINK_CLICKHERE_XPATH)
	@CacheLookup
	private WebElement sentinelLinkClickHere;

	@FindBy(xpath = enterOneTimePasswordLocators.LOC_ALERTINFO_ENTERONETIMEPASSWORD_XPATH)
	@CacheLookup
	private WebElement alertInfoEnterOneTimePassword;

	@FindBy(xpath = enterOneTimePasswordLocators.LOC_TEXTBOX_ENTEROTP_XPATH)
	@CacheLookup
	private WebElement textboxEnterOTP;

	@FindBy(xpath = OTPErrorMessagesLocators.LOC_ERRORMESSAGE_BLANKOTP_XPATH)
	@CacheLookup
	private WebElement errormessageBlankOTP;

	@FindBy(xpath = enterOneTimePasswordLocators.LOC_BUTTON_RESEND_XPATH)
	private WebElement buttonResend;

	@FindBy(xpath = enterOneTimePasswordLocators.LOC_BUTTON_SUBMIT_XPATH)
	@CacheLookup
	private WebElement buttonOTPSubmit;

	@FindBy(xpath = OTPErrorMessagesLocators.LOC_TOASTERMESSAGE_OTPCHARLIMIT_XPATH)
	@CacheLookup
	private WebElement charLimitErrorMessage;

	@FindBy(xpath = OTPErrorMessagesLocators.LOC_TOASTERMESSAGE_INVALIDOTP_XPATH)
	@CacheLookup
	private WebElement errorMessageInvalidOTP;

	@FindBy(xpath = enterOneTimePasswordLocators.LOC_INFO_ABOUTOTP_XPATH)
	@CacheLookup
	private WebElement infoAboutOTP;

	@FindBy(xpath = enterOneTimePasswordLocators.LOC_BUTTON_CANCEL_XPATH)
	private WebElement buttonOTPCancel;

	@FindBy(xpath = enterOneTimePasswordLocators.LOC_TOASTERMESSAGE_SUCCESSOTPSENT_XPATH)
	private WebElement toasterSuccessmessageOTPSent;

	@FindBy(xpath = enterOneTimePasswordLocators.LOC_TOASTERMESSAGE_ERROROTPSENT_XPATH)
	private WebElement toasterErrormessageOTPSent;

	@FindBy(xpath = enterOneTimePasswordLocators.LOC_BUTTONLOADINGICON_SENDING_XPATH)
	@CacheLookup
	private WebElement buttonLoadingSending;

	@FindBy(xpath = enterOneTimePasswordLocators.LOC_TOASTERMESSAGE_MAXIMUMRESENTOTPLIMIT_XPATH)
	private WebElement toasterMessageResendOTPMaximumLimit;

	@FindBy(xpath = newPasswordLocators.LOC_TITLE_NEWPASSWORD_XPATH)
	private WebElement titleNewPassword;

	@FindBy(xpath = newPasswordLocators.LOC_ALERTINFO_PASSWORD_XPATH)
	@CacheLookup
	private WebElement alertInfoPassword;

	@FindBy(xpath = newPasswordLocators.LOC_TEXTBOX_ENTERNEWPASSWORD_XPATH)
	@CacheLookup
	private WebElement textboxEnterNewPassword;

	@FindBy(xpath = newPasswordLocators.LOC_TEXTBOX_CONFIRMNEWPASSWORD_XPATH)
	private WebElement textboxEnterConfirmNewPassword;

	@FindBy(xpath = changePasswordAndConfirmPasswordMessagesLocators.LOC_ERRORMESSAGE_BLANKCHANGEPASSWORD_XPATH)
	@CacheLookup
	private WebElement errorMessageBlankChangePassword;

	@FindBy(xpath = changePasswordAndConfirmPasswordMessagesLocators.LOC_ERRORMESSAGE_BLANKCONFIRMPASSWORD_XPATH)
	@CacheLookup
	private WebElement errorMessageBlankConfirmPassword;

	@FindBy(xpath = changePasswordAndConfirmPasswordMessagesLocators.LOC_ERRORMESSAGE_INVALIDCONFIRMPASSWORD_XPATH)
	@CacheLookup
	private WebElement errorMessageInvalidConfirmPassword;

	@FindBy(xpath = newPasswordLocators.LOC_BUTTON_SUBMIT_XPATH)
	@CacheLookup
	private WebElement buttonNewPasswordSubmit;

	@FindBy(xpath = newPasswordLocators.LOC_BUTTON_CANCEL_XPATH)
	@CacheLookup
	private WebElement buttonNewPasswordCancel;

	@FindBy(xpath = navigateToCreateFacilityFormLocators.LOC_LOGO_UPLEFTCORNORHOMEPAGE_XPATH)
	@CacheLookup
	private WebElement logoUpperLeftCornerHomePage;

	@FindBy(xpath = logoutLocators.LOC_DROPDOWN_UPPERRIGHTSIDELOGOUT_XPATH)
	private WebElement dropdownUpperRightSide;

	@FindBy(xpath = logoutLocators.LOC_BUTTON_LOGOUT_XPATH)
	private WebElement buttonLogout;

	@FindBy(xpath = logoutLocators.LOC_DROPDOWNMENU_PROFILE_XPATH)
	@CacheLookup
	private WebElement dropdownProfileMenu;

	@FindBy(xpath = newPasswordLocators.LOC_TOASTERMESSAGE_RESETPASSWORDMAXIMUMLIMIT_XPATH)
	private WebElement toasterMessageResetPasswordMaximumLimit;

	@FindBy(xpath = newPasswordLocators.LOC_LINK_CLICKHERE_XPATH)
	@CacheLookup
	private WebElement linkClickHere;

	@FindAll({ @FindBy(xpath = newPasswordLocators.LOC_TOASTERMESSAGE_SUCCESSPASSWORDCHANGE_XPATH),
			@FindBy(xpath = newPasswordLocators.LOC_TOASTERMESSAGE_SUCCESSPASSWORDCHANGE_CSS) })
	private WebElement toasterSuccessmessagePasswordChanged;

	@FindBy(xpath = genericLocators.locators.LOC_LOADERIMAGE_XPATH)
	private WebElement loaderImage;

	public WebElement getLoaderImage() {
		return loaderImage;
	}

	public WebElement getSentinelLinkClickHere() {
		return sentinelLinkClickHere;
	}

	public WebElement getToasterSuccessmessagePasswordChanged() {
		return toasterSuccessmessagePasswordChanged;
	}

	public WebElement getLinkClickHere() {
		return linkClickHere;
	}

	public WebElement getToasterMessageResendOTPMaximumLimit() {
		return toasterMessageResendOTPMaximumLimit;
	}

	public WebElement getToasterMessageResetPasswordMaximumLimit() {
		return toasterMessageResetPasswordMaximumLimit;
	}

	public WebElement getButtonLoadingSending() {
		return buttonLoadingSending;
	}

	public WebElement getErrorMessageInvalidConfirmPassword() {
		return errorMessageInvalidConfirmPassword;
	}

	public WebElement getErrorMessageBlankChangePassword() {
		return errorMessageBlankChangePassword;
	}

	public WebElement getErrorMessageBlankConfirmPassword() {
		return errorMessageBlankConfirmPassword;
	}

	public WebElement getDropdownProfileMenu() {
		return dropdownProfileMenu;
	}

	public WebElement getButtonLogout() {
		return buttonLogout;
	}

	public WebElement getDropdownUpperRightSide() {
		return dropdownUpperRightSide;
	}

	public WebElement getLogoUpperLeftCornerHomePage() {
		return logoUpperLeftCornerHomePage;
	}

	public WebElement getErrorMessageInvalidOTP() {
		return errorMessageInvalidOTP;
	}

	public WebElement getButtonNewPasswordSubmit() {
		return buttonNewPasswordSubmit;
	}

	public WebElement getButtonNewPasswordCancel() {
		return buttonNewPasswordCancel;
	}

	public WebElement getTextboxEnterConfirmNewPassword() {
		return textboxEnterConfirmNewPassword;
	}

	public WebElement getTextboxEnterNewPassword() {
		return textboxEnterNewPassword;
	}

	public WebElement getAlertInfoPassword() {
		return alertInfoPassword;
	}

	public WebElement getTitleNewPassword() {
		return titleNewPassword;
	}

	public WebElement getToasterErrormessageOTPSent() {
		return toasterErrormessageOTPSent;
	}

	public WebElement getToasterSuccessmessageOTPSent() {
		return toasterSuccessmessageOTPSent;
	}

	public WebElement getButtonOTPCancel() {
		return buttonOTPCancel;
	}

	public WebElement getButtonOTPSubmit() {
		return buttonOTPSubmit;
	}

	public WebElement getInfoAboutOTP() {
		return infoAboutOTP;
	}

	public WebElement getButtonResend() {
		return buttonResend;
	}

	public WebElement getTextboxEnterOTP() {
		return textboxEnterOTP;
	}

	public WebElement getAlertInfoEnterOneTimePassword() {
		return alertInfoEnterOneTimePassword;
	}

	public WebElement getTitleEnterOneTimePassword() {
		return titleEnterOneTimePassword;
	}

	public WebElement getTextMailinatorEmail() {
		return textMailinatorEmail;
	}

	public WebElement getIframeMailinatorEmailBody() {
		return iframeMailinatorEmailBody;
	}

	public WebElement getTextLinkGeneratedMail() {
		return textLinkGeneratedMail;
	}

	public WebElement getTextboxCheckAnyInbox() {
		return textboxCheckAnyInbox;
	}

	public WebElement getErrormessageBlankOTP() {
		return errormessageBlankOTP;
	}

	public WebElement getToasterMessageResendUsername() {
		return toasterMessageResendUsername;
	}

	public WebElement getImageLoading() {
		return imageLoading;
	}

	public WebElement getToasterMessageInvalidEmailOrPassword() {
		return toasterMessageInvalidEmailOrPassword;
	}

	public WebElement getErrorMessageProperEmailID() {
		return errorMessageProperEmailID;
	}

	public WebElement getErrorMessageBlankEmailID() {
		return errorMessageBlankEmailID;
	}

	public WebElement getErrorMessageBlankMobileNumber() {
		return errorMessageBlankMobileNumber;
	}

	public WebElement getButtonSubmit() {
		return buttonSubmit;
	}

	public List<WebElement> getButtonSubmitAndCancel() {
		return buttonSubmitAndCancel;
	}

	public WebElement getTooltipDnd() {
		return tooltipDnd;
	}

	public WebElement getLogoDnd() {
		return logoDnd;
	}

	public WebElement getTextboxEnterEmailAddress() {
		return textboxEnterEmailAddress;
	}

	public WebElement getTextboxEnterMobileNumber() {
		return textboxEnterMobileNumber;
	}

	public WebElement getLabelForgotUsernamePassword() {
		return labelForgotUsernamePassword;
	}

	public List<WebElement> getRadioBtnResendUsernameResetPassword() {
		return radioBtnResendUsernameResetPassword;
	}

	public List<WebElement> getLabelRadioBtnResendUsernameResetPassword() {
		return labelRadioBtnResendUsernameResetPassword;
	}

	public WebElement getFaviconIcon() {
		return faviconIcon;
	}

	public WebElement getToasterMessage() {
		return toasterMessage;
	}

	public WebElement getErrorMessageblankPassword() {
		return errorMessageBlankPassword;
	}

	public WebElement getErrorMessageblankUsername() {
		return errorMessageBlankUsername;
	}

	public WebElement getButtonLogIn() {
		return buttonLogIn;
	}

	public WebElement getCharLimitErrorMessage() {
		return charLimitErrorMessage;
	}

	public WebElement getTextboxUsername() {
		return textboxUsername;
	}

	public WebElement getTextboxPassword() {
		return textboxPassword;
	}

	public WebElement getTitleSignInBox() {
		return titleSignInBox;
	}

	public WebElement getLinkForgetUsernameOrPassword() {
		return linkForgetUsernameOrPassword;
	}

	public List<WebElement> getFooterLink2() {
		return footerLink2;
	}

	public List<WebElement> getFooterLink1() {
		return footerLink1;
	}

	public WebElement getLeftPanePoweredByLogo() {
		return leftPanePoweredByLogo;
	}

	public WebElement getRightPaneSignIn() {
		return rightPaneSignIn;
	}

	public WebElement getText_sentianalAddress() {
		return textSentianalAddress;
	}

	/**
	 * Verify the Page Title and Favicon
	 */

	public void verifyFaviconPageTitle() {

		try {
			// Verify Page Title
			SoftAssertUtil.myAssert().assertTrue(
					!WebDriverTestBase.driver.getTitle().equals(WebDriverTestBase.config.getProperty("projectTitle")),
					"Page not dispalyed as " + WebDriverTestBase.config.getProperty("projectTitle")
							+ " . At Present it is displayed as - " + WebDriverTestBase.driver.getTitle());
			genericFunctions.logEvent("Verified Page Title..");
			// Verify Page Favicon
			stringValue = getFaviconIcon().getAttribute("href");
			SoftAssertUtil.myAssert().assertTrue(genericFunctions.verifyLink(stringValue) == 200,
					"Favicon is not present !!!" + genericFunctions.verifyLink(stringValue));
			genericFunctions.logEvent("Verified Page Favicon..");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyLogoSignUpPanel() {
		try {

			SoftAssertUtil.myAssert().assertTrue(getLeftPanePoweredByLogo().isDisplayed(),
					"'Powered By' pane is not Displayed ...");
			genericFunctions.logEvent("Verified Powered by left side pane is Displayed Title..");
			SoftAssertUtil.myAssert().assertTrue(getRightPaneSignIn().isDisplayed(),
					"'Sign In' pane is not Displayed ...");
			genericFunctions.logEvent("Verified Sign in right side pane is Displayed Title..");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifySignInBoxElementsDisplayed() {
		try {

			SoftAssertUtil.myAssert().assertTrue(getTitleSignInBox().getText().equals("Sign In"),
					"Sign In Box Title is not expected Equal to 'Sign In'");
			SoftAssertUtil.myAssert().assertTrue(
					getTextboxUsername().getAttribute("placeholder").equals("Enter Username"),
					"PlaceHolder does not contain the expected text 'Enter Username' .");
			SoftAssertUtil.myAssert().assertTrue(
					getTextboxPassword().getAttribute("placeholder").equals("Enter Password"),
					"PlaceHolder does not contain the expected text 'Enter Password' .");
			SoftAssertUtil.myAssert().assertTrue(!getButtonLogIn().isEnabled(), "The Submit Button is Enabled !!!!");
			SoftAssertUtil.myAssert().assertTrue(getLinkForgetUsernameOrPassword().isDisplayed(),
					"Forget Username or Password Link is Displayed . ");
			stringValue = getLinkForgetUsernameOrPassword().getAttribute("href");
			SoftAssertUtil.myAssert().assertTrue(genericFunctions.verifyLink(stringValue) == 200,
					"This is deadlink !!! Link response code is :-" + genericFunctions.verifyLink(stringValue));

			genericFunctions.logEvent("Verified the Sign Panel all the Elements are displayed.");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void VerifyWrongLoginErrorMessages(Object... args) {

		try {

			switch (args[0].toString()) {
			case "verifyErrorMessages":
				stringValue = "WrongUsernameAndPassword";
				fileNameAndExtension = "SignInExcelSheet.xls";
				while (i < data.readData(stringValue, fileNameAndExtension).size()) {
					getTextboxUsername().clear();
					getTextboxUsername().sendKeys(data.readData(stringValue, fileNameAndExtension).get(i));
					i++;

					getTextboxPassword().clear();
					getTextboxPassword().sendKeys(data.readData(stringValue, fileNameAndExtension).get(i));
					i++;
					if (!getButtonLogIn().isEnabled()) {
						genericFunctions.waitForElementVisible(getButtonLogIn());
					}
					getButtonLogIn().click();
					Thread.sleep(800);
					SoftAssertUtil.myAssert().assertTrue(
							getToasterMessage().getText().equals("Invalid Credentials! Please try again."),
							"\"Invalid Credientials\" Error Message is not as Expected");
					Reporter.log("Verifed the Error Message for \"Invalid Credientials.\"");
				}
				Reporter.log("Verifed the Error Message for \"Invalid Credientials.\"");
				break;

			case "verifyMaxLimitValidUsernameInvalidPassword":

				intValue = Integer.parseInt((String) config.get("maximumInvalidLogins")) - (int) args[1];

				while (intValue >= 0) {
					Thread.sleep(800);
					getTextboxUsername().clear();
					getTextboxUsername().sendKeys(config.getProperty("userName"));
					getTextboxPassword().clear();
					getTextboxPassword().sendKeys(genericFunctions.generaterandomString(10));
					getButtonLogIn().click();
					Thread.sleep(800);
					SoftAssertUtil.myAssert().assertTrue(getToasterMessage().isDisplayed(),
							"Error Message is not Displayed.");
					if (intValue != 0) {
						stringValue = "Invalid Credentials! Please try again. You have " + intValue + " attempt left.";

						SoftAssertUtil.myAssert().assertTrue(getToasterMessage().getText().equals(stringValue),
								" Error Message is not as Expected. Expected Error Message is - 'Invalid Credentials! Please try again. You have [5-1] attempt left.'");
					} else {
						SoftAssertUtil.myAssert().assertTrue(
								getToasterMessage().getText()
										.equals("Your account is inactivated due to 5 incorrect attempt in single day.Please Contact admin for further assistance."),
								"Maximum Login Attempt Error Message is not expected . Expected Max Login Attempt error message is ---'Your account is inactivated due to 5 incorrect attempt in single day.Please Contact admin for further assistance.' .");
						break;
					}
					intValue--;
					Thread.sleep(5000);
				}
				Reporter.log("Verifed the Error Message for \"Maximum Login Attempts.\"");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyBlankSignInErrorMessages() {

		try {
			getTextboxUsername().click();
			getTextboxPassword().click();
			getTextboxUsername().click();
			SoftAssertUtil.myAssert().assertTrue(getErrorMessageblankUsername().isDisplayed(),
					"Blank Username Error Message is not dispayed .");
			SoftAssertUtil.myAssert().assertTrue(getErrorMessageblankPassword().isDisplayed(),
					"Blank Password Error Message is not dispayed .");
			SoftAssertUtil.myAssert().assertTrue(
					getErrorMessageblankUsername().getText().equals("Username is required"),
					"Blank Username Error Message is different than expected .");
			SoftAssertUtil.myAssert().assertTrue(
					getErrorMessageblankPassword().getText().equals("Password is required"),
					"Blank Password Error Message is  different than expected .");
			genericFunctions.logEvent("Verified Blank Username and Password Error Messages ....");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifySignInPageFooter() {
		try {
			/**
			 * Verified left side footer with the excel values
			 */
			stringValue = "FooterLabelsLeftSide";
			fileNameAndExtension = "SignInExcelSheet.xls";
			List<WebElement> footerLinkTextLeftSide = getFooterLink1();
			while (i < data.readData(stringValue, fileNameAndExtension).size()) {
				while (j < footerLinkTextLeftSide.size()) {
					GenericFunctions.highlightElement(footerLinkTextLeftSide.get(j));
					SoftAssertUtil.myAssert().assertTrue(
							footerLinkTextLeftSide.get(j).getText()
									.equals(data.readData(stringValue, fileNameAndExtension).get(i)),
							"The Footer Label - " + footerLinkTextLeftSide.get(j).getText()
									+ " does not match the data in excel "
									+ data.readData(stringValue, fileNameAndExtension).get(i) + ".");
					if (j == 3) {
						break;
					}
					i++;
					j++;
				}
				if (i == 3) {
					i = 0;
					j = 0;
					genericFunctions.logEvent("Verified Left Side Footer Link Text...");
					break;

				}
			}

			/**
			 * Verified right side footer with the excel values
			 */
			stringValue = "FooterLabelsRightSide";
			fileNameAndExtension = "SignInExcelSheet.xls";
			List<WebElement> footerLinkTextRightSide = getFooterLink2();
			// System.out.println("Right Footer Link Size
			// "+footerLinkTextRightSide.size());
			while (i < data.readData(stringValue, fileNameAndExtension).size()) {
				while (j < footerLinkTextRightSide.size()) {
					GenericFunctions.highlightElement(footerLinkTextRightSide.get(j));
					SoftAssertUtil.myAssert().assertTrue(
							footerLinkTextRightSide.get(j).getText()
									.equals(data.readData(stringValue, fileNameAndExtension).get(i)),
							"The Footer Label - " + footerLinkTextRightSide.get(j).getText()
									+ " does not match the data in excel "
									+ data.readData(stringValue, fileNameAndExtension).get(i) + ".");
					if (j == 3) {
						break;
					}
					i++;
					j++;
				}
				if (i == 3) {
					i = 0;
					j = 0;
					genericFunctions.logEvent("Verified Left Side Footer Link Text...");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyPaneTitle() {
		try {
			GenericFunctions.highlightElement(getLabelForgotUsernamePassword());
			SoftAssertUtil.myAssert().assertTrue(getLabelForgotUsernamePassword().isDisplayed(),
					"Pane Title is not displayed as -" + getLabelForgotUsernamePassword().getText());
			genericFunctions.logEvent("Verified the 'Forgot Username/Password' Title . It is Displayed as - "
					+ getLabelForgotUsernamePassword().getText());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyDefaultRadioButtonSelected() {
		try {
			List<WebElement> radioButton = getRadioBtnResendUsernameResetPassword();
			for (int i = 0; i < radioButton.size(); i++) {
				if (i == 0) {
					GenericFunctions.highlightElement(radioButton.get(i));
					SoftAssertUtil.myAssert().assertTrue(radioButton.get(i).isSelected(),
							"'Resend Username' -Radio Button default is not selected");
				} else {
					GenericFunctions.highlightElement(radioButton.get(i));
					SoftAssertUtil.myAssert().assertTrue(!radioButton.get(i).isSelected(),
							"'Reset Password' -Radio Button default is selected");
				}
			}
			genericFunctions.logEvent("Verified the default selected Radio Buttons");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyRadioButtonlabels() {
		stringValue = "signInRadioBtnLabels";
		fileNameAndExtension = "SignInExcelSheet.xls";
		try {
			List<WebElement> radioButtonText = getLabelRadioBtnResendUsernameResetPassword();
			while (i < data.readData(stringValue, fileNameAndExtension).size()) {
				while (j < radioButtonText.size()) {
					GenericFunctions.highlightElement(radioButtonText.get(j));
					SoftAssertUtil.myAssert().assertTrue(
							radioButtonText.get(j).getText()
									.equals(data.readData(stringValue, fileNameAndExtension).get(i)),
							"The Radio Button Label - " + radioButtonText.get(j).getText()
									+ " does not match the data in excel "
									+ data.readData(stringValue, fileNameAndExtension).get(i) + ".");
					if (j == 1) {
						break;
					}
					i++;
					j++;
				}
				if (i == 1) {
					i = 0;
					j = 0;
					genericFunctions.logEvent("Verified Radio Buttons Validations...");
					break;

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// test textboxes, placeholder and DND Logo

	public void verifyTextBoxesAndTextPlaceholders() {
		try {
			GenericFunctions.highlightElement(getTextboxEnterEmailAddress());
			GenericFunctions.highlightElement(getTextboxEnterMobileNumber());

			SoftAssertUtil.myAssert().assertTrue(getTextboxEnterEmailAddress().isDisplayed(),
					"'Enter Email Address' textbox is not displayed .");

			SoftAssertUtil.myAssert().assertTrue(getTextboxEnterMobileNumber().isDisplayed(),
					"'Enter Mobile Number' textbox is not displayed .");
			genericFunctions.logEvent("Enter Username and Enter Password textboxs are  displayed.");
			SoftAssertUtil.myAssert().assertTrue(
					getTextboxEnterEmailAddress().getAttribute("placeholder").equals("Enter Email Address"),
					"'Enter Email Address' placeholder text is not displayed .");
			SoftAssertUtil.myAssert().assertTrue(
					getTextboxEnterMobileNumber().getAttribute("placeholder").equals("Enter Mobile Number"),
					"'Enter Mobile Number' placeholder text is not displayed .");
			genericFunctions.logEvent(getTextboxEnterEmailAddress().getAttribute("placeholder")
					+ " textbox placeholder and " + getTextboxEnterMobileNumber().getAttribute("placeholder")
					+ "textbox placeholder " + "are  displayed.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyDNDLogoAndToolTip() {
		try {
			GenericFunctions.highlightElement(getLogoDnd());
			SoftAssertUtil.myAssert().assertTrue(getLogoDnd().isDisplayed());
			action.moveToElement(getLogoDnd()).build().perform();
			stringValue = getTooltipDnd().getAttribute("data-original-title").replace(" <br/><strong> ", "")
					.replace("</strong>", "");
			SoftAssertUtil.myAssert().assertTrue(stringValue.equals(config.getProperty("dndToolTip")),
					"Dnd Tool Tip does not match with the expected tool tip -" + config.getProperty("dndToolTip"));
			genericFunctions
					.logEvent("Verified the DND Logo and DND ToolTip .ToolTip is displayed as - " + stringValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifySubmitAndCancelButtons() {
		stringValue = "ForgotPaneBtnLabels";
		fileNameAndExtension = "SignInExcelSheet.xls";
		try {
			List<WebElement> buttonList = getButtonSubmitAndCancel();
			while (i < data.readData(stringValue, fileNameAndExtension).size()) {
				while (j < buttonList.size()) {
					GenericFunctions.highlightElement(buttonList.get(j));
					SoftAssertUtil.myAssert().assertTrue(
							buttonList.get(j).getText().equals(data.readData(stringValue, fileNameAndExtension).get(i)),
							"UI Button Label " + buttonList.get(j).getText() + " is not as  expected as "
									+ data.readData(stringValue, fileNameAndExtension).get(i) + " .");
					if (buttonList.get(j).getText().equals("SUBMIT")) {
						GenericFunctions.highlightElement(buttonList.get(j));
						SoftAssertUtil.myAssert().assertTrue(!buttonList.get(i).isEnabled(),
								buttonList.get(j).getText() + " button is not Disabled .");
					} else {
						GenericFunctions.highlightElement(buttonList.get(j));
						SoftAssertUtil.myAssert().assertTrue(buttonList.get(i).isEnabled(),
								buttonList.get(j).getText() + " button is Disabled .");
					}
					if (j == 1) {
						break;
					}
					i++;
					j++;
				}
				if (i == 1) {
					i = 0;
					j = 0;
					genericFunctions.logEvent("Verified Submitand cancel Button Validations...");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifySubmitButtonFunctionalityWithInvalidEmailIdAndPassword() {
		stringValue = "invalidEmailIdData";
		fileNameAndExtension = "SignInExcelSheet.xls";
		try {
			for (int i = 0; i < data.readData(stringValue, fileNameAndExtension).size(); i++) {
				GenericFunctions.highlightElement(getTextboxEnterEmailAddress());
				getTextboxEnterEmailAddress().clear();
				getTextboxEnterEmailAddress().sendKeys(data.readData(stringValue, fileNameAndExtension).get(i));
				GenericFunctions.highlightElement(getButtonSubmit());
				if (getButtonSubmit().isEnabled()) {
					SoftAssertUtil.myAssert().assertTrue(getButtonSubmit().isEnabled(),
							"The Submit button is not enabled !!!");
					getButtonSubmit().click();
				}

				SoftAssertUtil.myAssert().assertTrue(
						getErrorMessageProperEmailID().getText().equals("Please Enter Proper Email Address"),
						"The Proper Email ID Error Message is not displayed !!!!!!");
			}
			getTextboxEnterEmailAddress().sendKeys(Keys.chord(Keys.CONTROL, "a"));
			getTextboxEnterEmailAddress().sendKeys(Keys.BACK_SPACE);
			getTextboxEnterEmailAddress().sendKeys(Keys.TAB);
			GenericFunctions.highlightElement(getTextboxEnterMobileNumber());
			getTextboxEnterMobileNumber().sendKeys(
					Float.toString(genericFunctions.generateRandomNumber(66666666, 99999999)).replace(".0", ""));
			getButtonSubmit().click();
			SoftAssertUtil.myAssert().assertTrue(
					getErrorMessageProperEmailID().getText().equals("Please Enter Proper Mobile Number"),
					"The Proper Mobile Number ID Error Message is not displayed !!!!!!");
			genericFunctions.logEvent(
					"Verified the Submit Button Functionality with Invalid EmailId's and Password and Error Messages ");
			getTextboxEnterEmailAddress().clear();
			getTextboxEnterMobileNumber().clear();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyBlankEmailAddressAndMobileNumErrorMessages() {
		try {
			getTextboxEnterEmailAddress().sendKeys(Keys.chord(Keys.CONTROL, "a"));
			getTextboxEnterEmailAddress().sendKeys(Keys.BACK_SPACE);
			getTextboxEnterEmailAddress().sendKeys(Keys.TAB);
			getTextboxEnterEmailAddress().sendKeys(Keys.CONTROL);

			GenericFunctions.highlightElement(getErrorMessageBlankEmailID());
			SoftAssertUtil.myAssert().assertTrue(
					(getErrorMessageBlankEmailID().isDisplayed())
							&& (getErrorMessageBlankEmailID().getText().equals("Email Address is required")),
					"Blank Email ID Error Message is not displayed.");

			GenericFunctions.highlightElement(getErrorMessageBlankMobileNumber());
			SoftAssertUtil.myAssert().assertTrue(
					(getErrorMessageBlankMobileNumber().isDisplayed())
							&& (getErrorMessageBlankMobileNumber().getText().equals("Mobile Number is required")),
					"Blank Mobile Number Error Message is not displayed.");
			genericFunctions.logEvent("Verified that Blank Email Id and Password Error Messages are displayed ...");
			getTextboxEnterEmailAddress().clear();
			getTextboxEnterMobileNumber().clear();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void navigateToForgetUsernameOrPasswordPage(String... args) {
		try {
			if (!driver.getCurrentUrl().contains("forgot-password")) {
				getLinkForgetUsernameOrPassword().click();
			}
			if (args.length > 0) {
				if (args[0].equals("Reset Password")) {
					for (int i = 0; i < getLabelRadioBtnResendUsernameResetPassword().size(); i++) {
						if (getLabelRadioBtnResendUsernameResetPassword().get(i).getText().equals(args[0])) {
							getLabelRadioBtnResendUsernameResetPassword().get(i).click();
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void navigateToLoginPage() {
		try {
			if (!driver.getCurrentUrl().equals(config.getProperty("projectUrl"))) {
				driver.get(config.getProperty("projectUrl"));
			} else {
				WebDriverTestBase.driver.navigate().refresh();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyWithNonRegisteredEmailAndMobileNumber() {
		try {
			getTextboxEnterEmailAddress().clear();
			getTextboxEnterEmailAddress().sendKeys(genericFunctions.generateRandomEmail());
			getButtonSubmit().click();

			SoftAssertUtil.myAssert().assertTrue(getToasterMessageInvalidEmailOrPassword().isDisplayed(),
					"Toaster Error Message is not Displayed !!!");
			SoftAssertUtil.myAssert().assertTrue(
					getToasterMessageInvalidEmailOrPassword().getText()
							.equals("Invalid Phone number/Email Address. Try Again."),
					"Toaster Error Messages is not displayed as expected ..");
			genericFunctions.logEvent(
					"Verified The Non Registered Email Address if passed , Validation Message is shown is toaster . The Toaster Error Message is "
							+ getToasterMessageInvalidEmailOrPassword().getText());
			stringValue = genericFunctions.generateRandomNumber(99999, 99999) + ""
					+ genericFunctions.generateRandomNumber(99999, 99999);
			getTextboxEnterMobileNumber().clear();
			getTextboxEnterMobileNumber().sendKeys(stringValue);
			SoftAssertUtil.myAssert().assertTrue(getToasterMessageInvalidEmailOrPassword().isDisplayed(),
					"Toaster Error Message is not Displayed !!!");
			SoftAssertUtil.myAssert().assertTrue(
					getToasterMessageInvalidEmailOrPassword().getText()
							.equals("Invalid Phone number/Email Address. Try Again."),
					"Toaster Error Messages is not displayed as expected ..");
			genericFunctions.logEvent(
					"Verified The Non Mobile Number if passed , Validation Message is shown is toaster . The Toaster Error Message is "
							+ getToasterMessageInvalidEmailOrPassword().getText());
			getTextboxEnterEmailAddress().clear();
			getTextboxEnterMobileNumber().clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyResendUsernameFunctionality(String dbValue) {
		try {

			getTextboxEnterEmailAddress().sendKeys(dbValue);
			getButtonSubmit().click();
			genericFunctions.waitForElementInvisible(getImageLoading());
			genericFunctions.logEvent("Email Sent for Register Email ID .");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getvalueFromMailBox(String... args) {
		try {
			if (args.length > 1) {
				stringValue1 = args[1];
			}
			stringValue = args[0];
			String parentHandle = WebDriverTestBase.driver.getWindowHandle();

			genericFunctions.navigateToNewTab();
			genericFunctions.waitForElementVisible(getTextboxCheckAnyInbox());
			getTextboxCheckAnyInbox().clear();
			getTextboxCheckAnyInbox().sendKeys(String.valueOf(stringValue));
			getTextboxCheckAnyInbox().sendKeys(Keys.ENTER);
			Thread.sleep(200);
			WebDriverTestBase.driver.navigate().refresh();
			Thread.sleep(200);
			WebDriverTestBase.driver.navigate().refresh();
			Thread.sleep(200);
			WebDriverTestBase.driver.navigate().refresh();
			Thread.sleep(200);
			genericFunctions.waitForElementVisible(getTextLinkGeneratedMail());
			getTextLinkGeneratedMail().click();
			genericFunctions.waitForElementVisible(getIframeMailinatorEmailBody());
			WebDriverTestBase.driver.switchTo().frame(getIframeMailinatorEmailBody());

			GenericFunctions.highlightElement(getTextMailinatorEmail());
			if (args.length > 1) {
				getSentinelLinkClickHere().click();
				WebDriverTestBase.driver.switchTo().defaultContent();

				/**
				 * Close the unwanted windows and focus on the forget password
				 * window
				 */

				Set<String> totalhandles = WebDriverTestBase.driver.getWindowHandles();
				Iterator<String> iterator = totalhandles.iterator();
				while (iterator.hasNext()) {
					String child_window = iterator.next();
					driver.switchTo().window(child_window);
					if (((driver.switchTo().window(child_window).getTitle().equals(config.getProperty("projectTitle")))
							&& (driver.getCurrentUrl().equals(config.getProperty("projectUrl"))))
							|| (driver.switchTo().window(child_window).getTitle()
									.equals(config.getProperty("emailSiteTitle")))) {
						driver.close();
					}
				}
			} else {
				stringValue = getTextMailinatorEmail().getText();
				stringValueArray = stringValue.split("is ");
				stringValue = stringValueArray[1];
				WebDriverTestBase.driver.switchTo().defaultContent();
				driver.close();
				WebDriverTestBase.driver.switchTo().window(parentHandle);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringValue;
	}

	public void VerifyEmailedUserNameWithDB(String stringValue, String dbValue) {
		try {
			SoftAssertUtil.myAssert().assertTrue(stringValue.trim().equals(dbValue.trim()), stringValue
					+ " Username in the Email content is not equal to expected Username in the DataBase " + dbValue);
			genericFunctions.logEvent("Verified that the userName in the email content " + stringValue
					+ " is as expected value in the database " + dbValue + " .");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifysendOTPFunctionality(String dbValue) {
		try {

			getTextboxEnterEmailAddress().sendKeys(dbValue);
			getButtonSubmit().click();
			genericFunctions.waitForElementInvisible(getImageLoading());
			genericFunctions.logEvent("Verifed send OTP Functionality for Register Email ID .");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void VerifyEmailedOTPWithDatabaseOTPvalue(String stringValue, String dbValue) {
		try {
			SoftAssertUtil.myAssert().assertTrue(stringValue.trim().equals(dbValue.trim()), stringValue
					+ " OTP in the Email content is not equal to expected OTP in the DataBase -" + dbValue + " .");
			genericFunctions.logEvent("Verified that the OTP in the email content " + stringValue
					+ " is as expected value in the database " + dbValue + " .");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyEnterOneTimePasswordLayout() {
		try {

			// OTP Side Page Title
			SoftAssertUtil.myAssert().assertTrue(
					getTitleEnterOneTimePassword().getText().trim().equals("Enter One Time Password"),
					"Side Page Title is not equal to expected title 'Enter One Time Password'");

			// OTP INFO

			/*
			 * SoftAssertUtil.myAssert().assertTrue(
			 * getAlertInfoEnterOneTimePassword().getText().trim() .contains(
			 * "Enter One Time Password sent to your registered  email address or mobile number. Please do not refresh page."
			 * ),
			 * "Side Page Title is not equal to expected title 'Enter One Time Password sent to your registered  email address or mobile number. Please do not refresh page.'"
			 * );
			 */
			SoftAssertUtil.myAssert().assertTrue(getAlertInfoEnterOneTimePassword().isDisplayed(),
					"OTP Info text is not displayed");

			// Enter OTP textbox verification
			SoftAssertUtil.myAssert().assertTrue(
					getTextboxEnterOTP().getAttribute("placeholder").trim().equals("Enter OTP"),
					"Enter Otp Text Box Placeholder is not equal to as expected , i.e,. 'Enter OTP'...");

			SoftAssertUtil.myAssert().assertTrue(getTextboxEnterOTP().isDisplayed(),
					"Enter Otp Text Box is not Displayed...");

			// Resend Button Verification getButtonResend()
			SoftAssertUtil.myAssert().assertTrue(getButtonResend().isDisplayed(), "Resend Button is not Displayed.");
			SoftAssertUtil.myAssert().assertTrue(getButtonResend().isEnabled(), "Resend Button is not Enabled.");
			SoftAssertUtil.myAssert().assertTrue(getButtonResend().getText().trim().equals("Resend"),
					"Resend Button text is not expected ,i.e,. 'Resend'.");

			// Small INfo verification LOC_INFO_ABOUTOTP_XPATH
			SoftAssertUtil.myAssert().assertTrue(getInfoAboutOTP().isDisplayed(),
					"Small OTP Info beneath the 'Resend' Button is not Displayed.");

			SoftAssertUtil.myAssert().assertTrue(
					getInfoAboutOTP().getText().trim().equals("OTP will expire in 10 minutes."),
					"OTP INFO text is not expected ,i.e,. ' OTP will expire in 10 minutes.'.");

			// SUbmit Button getButtonOTPSubmit()
			SoftAssertUtil.myAssert().assertTrue(getButtonOTPSubmit().isDisplayed(), "Submit Button is not Displayed.");
			SoftAssertUtil.myAssert().assertTrue(!getButtonOTPSubmit().isEnabled(), "Submit Button is  Enabled.");
			SoftAssertUtil.myAssert().assertTrue(getButtonOTPSubmit().getText().trim().equals("SUBMIT"),
					"Button text is not expected ,i.e,. ' SUBMIT'.");

			// Cancel Button getButtonOTPCancel()
			SoftAssertUtil.myAssert().assertTrue(getButtonOTPCancel().isDisplayed(), "Cancel Button is not Displayed.");
			SoftAssertUtil.myAssert().assertTrue(getButtonOTPCancel().isEnabled(), "Cancel Button is not Enabled.");
			SoftAssertUtil.myAssert().assertTrue(getButtonOTPCancel().getText().trim().equals("CANCEL"),
					"Button text is not expected ,i.e,. ' CANCEL'.");

			genericFunctions.logEvent("Verified all the contents on Enter One Time Password Screen.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyEnteringOTPReceivedOnEmailed(String stringValue) {
		try {
			getTextboxEnterOTP().sendKeys(stringValue);
			getButtonOTPSubmit().click();
			// Verify OTP Success Message
			genericFunctions.waitForElementVisible(getToasterSuccessmessageOTPSent());
			SoftAssertUtil.myAssert().assertTrue(getToasterSuccessmessageOTPSent().isDisplayed(),
					"Toaster Success Message is not displayed..");
			SoftAssertUtil.myAssert().assertTrue(
					getToasterSuccessmessageOTPSent().getText().trim().equals("Your OTP is verified."),
					"Toaster Success Message is not as expected..i.e,. 'Your OTP is verified.'");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyNewPasswordLayout() {
		try {
			// Verify Side Window New Password Title
			SoftAssertUtil.myAssert().assertTrue(getTitleNewPassword().isDisplayed(),
					"'New Password' title is not displayed..");
			SoftAssertUtil.myAssert().assertTrue(getTitleNewPassword().getText().trim().equals("New Password"),
					"'New Password' title literal is not expected . At present it is dispayed as - "
							+ getTitleNewPassword().getText().trim());

			// New Password Info
			SoftAssertUtil.myAssert().assertTrue(getAlertInfoPassword().isDisplayed(),
					"'New Password' Alert Info is not displayed..");

			// New Password Text Box Validations
			SoftAssertUtil.myAssert().assertTrue(getTextboxEnterNewPassword().isDisplayed(),
					"New Password textbox is not displayed..");
			SoftAssertUtil.myAssert().assertTrue(
					getTextboxEnterNewPassword().getAttribute("placeholder").trim().equals("Enter New Password"),
					"Placeholder text for Enter New Password is not as expected . Expected placeholder text is 'Enter New Password' .  At present it is displayed as - "
							+ getTextboxEnterNewPassword().getAttribute("placeholder").trim());

			// New Password Text Box Validations
			SoftAssertUtil.myAssert().assertTrue(getTextboxEnterConfirmNewPassword().isDisplayed(),
					"Confirm Password textbox is not displayed..");
			SoftAssertUtil.myAssert().assertTrue(
					getTextboxEnterConfirmNewPassword().getAttribute("placeholder").trim()
							.equals("Confirm New password"),
					"Placeholder text for Confirm New  Password is not as expected . Expected placeholder text is 'Confirm New Password' .  At present it is displayed as - "
							+ getTextboxEnterConfirmNewPassword().getAttribute("placeholder").trim());

			// Submit Button getButtonNewPasswordSubmit()
			SoftAssertUtil.myAssert().assertTrue(getButtonNewPasswordSubmit().isDisplayed(),
					"Submit Button is not displayed..");
			SoftAssertUtil.myAssert().assertTrue(!getButtonNewPasswordSubmit().isEnabled(),
					"Submit Button is  Enabled..");
			SoftAssertUtil.myAssert().assertTrue(getButtonNewPasswordSubmit().getText().trim().equals("SUBMIT"),
					"Submit Button Text is not as expected . The label for button expected is - 'SUBMIT'. At present it is displayed as - "
							+ getButtonNewPasswordSubmit().getText().trim());
			// Submit Button getButtonNewPasswordCancel()
			SoftAssertUtil.myAssert().assertTrue(getButtonNewPasswordCancel().isDisplayed(),
					"Cancel Button is not displayed..");
			SoftAssertUtil.myAssert().assertTrue(getButtonNewPasswordCancel().isEnabled(),
					"Cancel Button is not Enabled..");
			SoftAssertUtil.myAssert().assertTrue(getButtonNewPasswordCancel().getText().trim().equals("CANCEL"),
					"Submit Button Text is not as expected . The label for button expected is - 'CANCEL'. At present it is displayed as - "
							+ getButtonNewPasswordCancel().getText().trim());
			genericFunctions.logEvent("Verified the New Password side pane page Layout ...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String verifyNewPasswordConfirmPasswordFuntionality(String... args) {
		try {
			if (args[0].equals("change to default password")) {
				stringValue = config.getProperty("defaultPasswordToBeSet");
			} else {
				stringValue = genericFunctions.generaterandomString(5);
				intValue = genericFunctions.generateRandomNumber(1, 3);
				stringValue = "!@#A" + stringValue + intValue;
			}
			genericFunctions.logEvent(stringValue + " is the new password for user .");
			getTextboxEnterNewPassword().sendKeys(stringValue);
			getTextboxEnterConfirmNewPassword().sendKeys(stringValue);
			getButtonNewPasswordSubmit().click();

			SoftAssertUtil.myAssert().assertTrue(
					getToasterSuccessmessagePasswordChanged().getText().trim()
							.equals("Your password changed successfully."),
					"Toaster success message for password change is not as expected  . Expected is 'Your password changed successfully.'. At Present it is displayed as - "
							+ getToasterSuccessmessagePasswordChanged().getText().trim());

			if (args[0].equals("change to default password")) {
				while (!getLinkClickHere().isDisplayed()) {
				}
				SoftAssertUtil.myAssert().assertTrue(
						genericFunctions.verifyLink(getLinkClickHere().getAttribute("href")) == 200,
						"Click Here link is not working...");
				getLinkClickHere().click();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringValue;
	}

	public void verifySuccessfullyLoginOnPasswordChange(String firstName, String newPassword) {
		try {
			genericFunctions.waitForElementVisible(getTextboxUsername());
			getTextboxUsername().sendKeys(firstName);
			getTextboxPassword().sendKeys(newPassword);
			getButtonLogIn().click();
			genericFunctions.waitForElementVisible(getLogoUpperLeftCornerHomePage());
			SoftAssertUtil.myAssert().assertTrue(getLogoUpperLeftCornerHomePage().isDisplayed(),
					"User Not Logged IN . ");
			genericFunctions.logEvent("Verified the Sign Up Functionality After Password Change Successfully !!!!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void logoutTheApplication() {
		try {
			Thread.sleep(2000);
			genericFunctions.waitForElementVisible(getDropdownUpperRightSide());
			Thread.sleep(1000);
			genericFunctions.scrollToElement(getDropdownUpperRightSide());
			getDropdownUpperRightSide().click();
			genericFunctions.waitForElementVisible(getButtonLogout());
			getButtonLogout().click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyBlankOTPErrorMessage() {
		try {
			getTextboxEnterOTP().sendKeys(Keys.TAB);

			SoftAssertUtil.myAssert().assertTrue(getErrormessageBlankOTP().isDisplayed(),
					"Blank Otp error message is not displayed..");
			SoftAssertUtil.myAssert().assertTrue(getErrormessageBlankOTP().getText().equals("Otp is required"),
					"Blank Otp error message is not as expected ..Expected test is -'Otp is required'");
			genericFunctions.logEvent("Verified Blank OTP Error Message.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyOTPCharLimitErrorMessage() {
		try {
			getTextboxEnterOTP().sendKeys(Float.toString(genericFunctions.generateRandomNumber(3, 5)));
			if (!getButtonOTPSubmit().isEnabled()) {
				genericFunctions.waitForElementVisible(getButtonOTPSubmit());
			}
			getButtonOTPSubmit().click();
			SoftAssertUtil.myAssert().assertTrue(getCharLimitErrorMessage().isDisplayed(),
					"Character Limit Error Message is not displayed..");

			SoftAssertUtil.myAssert().assertTrue(
					getCharLimitErrorMessage().getText().trim().equals("The otp value must be 6 digits."),
					"Character Limit Error Message is not as expected..Expected Error Message is -'The otp value must be 6 digits.'");

			genericFunctions.logEvent("Verified Character Limit OTP Error Message.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyInvalidOTPErrorMessage() {
		try {
			Thread.sleep(5000);
			intValue = genericFunctions.generateRandomNumber(333333, 666666);
			stringValue = Integer.toString(intValue);
			getTextboxEnterOTP().clear();
			getTextboxEnterOTP().sendKeys(stringValue.trim());
			if (!getButtonOTPSubmit().isEnabled()) {
				genericFunctions.waitForElementVisible(getButtonOTPSubmit());
			}
			getButtonOTPSubmit().click();
			SoftAssertUtil.myAssert().assertTrue(getErrorMessageInvalidOTP().isDisplayed(),
					"Invalid OTP Error Message is not displayed..");
			SoftAssertUtil.myAssert().assertTrue(
					getErrorMessageInvalidOTP().getText().trim().equals("OTP is invalid. Please try again."),
					"Invalid OTP Error Message is not as expected..Expected Error Message is -'OTP is invalid. Please try again..'");

			genericFunctions.logEvent("Verified Invalid  OTP Error Message.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyChangePasswordAndConfirmPasswordBlankErrorMessages() {
		try {
			getTextboxEnterNewPassword().sendKeys(Keys.TAB);
			getTitleNewPassword().click();
			// getTextboxEnterConfirmNewPassword().sendKeys(Keys.TAB);
			SoftAssertUtil.myAssert().assertTrue(getErrorMessageBlankChangePassword().isDisplayed(),
					"Invalid OTP Error Message is not displayed..");
			SoftAssertUtil.myAssert().assertTrue(getErrorMessageBlankConfirmPassword().isDisplayed(),
					"Invalid OTP Error Message is not displayed..");

			SoftAssertUtil.myAssert().assertTrue(
					getErrorMessageBlankChangePassword().getText().trim().equals("Password is required"),
					"Blank Change Password Error Message is not as expected..Expected Error Message is -'Password is required'");

			SoftAssertUtil.myAssert().assertTrue(
					getErrorMessageBlankConfirmPassword().getText().trim().equals("Confirm Password is required"),
					"Blank Change Password Error Message is not as expected..Expected Error Message is -'Confirm Password is required'");

			genericFunctions.logEvent("Verified Blank Change and Confirm Password Error Message.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyChangePasswordAndConfirmPasswordInvalidErrorMessages() {
		try {
			getTextboxEnterNewPassword().sendKeys("Admin@123");
			getTextboxEnterConfirmNewPassword().sendKeys(genericFunctions.generaterandomString(5));
			SoftAssertUtil.myAssert().assertTrue(getErrorMessageInvalidConfirmPassword().isDisplayed(),
					"Invalid Confirm Password Error Message is not dispayed..");
			SoftAssertUtil.myAssert().assertTrue(
					getErrorMessageInvalidConfirmPassword().getText().equals("Password is not matching."),
					"Invalid Confirm Password Error Message is not as expected ..Expected Error Message is 'Password is not matching.' .");
			SoftAssertUtil.myAssert().assertTrue(!getButtonNewPasswordSubmit().isEnabled(),
					"New Password Submit Button is enabled..");

			genericFunctions.logEvent("Verified Invalid  Change and Confirm Password Error Message.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyMaximumSendOTPFunctionality(int intValue, String dbValue) {
		SignInPage signIn = new SignInPage();
		stringValue = "Reset Password";
		try {
			while (intValue != Integer.parseInt((config.getProperty("resetPasswordMailSentMaximumValue") + 1))) {
				getTextboxEnterEmailAddress().clear();
				getTextboxEnterEmailAddress().sendKeys(dbValue);
				getButtonSubmit().click();
				if (intValue < Integer.parseInt(config.getProperty("resetPasswordMailSentMaximumValue"))) {
					genericFunctions.waitForElementInvisible(getImageLoading());
					getButtonOTPCancel().click();
					signIn.navigateToForgetUsernameOrPasswordPage(stringValue);
				} else {
					while (!getToasterMessageResetPasswordMaximumLimit().isDisplayed()) {
					}
					SoftAssertUtil.myAssert().assertTrue(getToasterMessageResetPasswordMaximumLimit().isDisplayed(),
							"Maximum Limit Reset Password Toaster Message Error Message is not displayed . ");

					SoftAssertUtil.myAssert().assertTrue(
							getToasterMessageResetPasswordMaximumLimit().getText().trim()
									.equals("You have reached the maximum limit of forgot password."),
							"Maximum Limit Reset Password Toaster Message Error Message is not expected , Expected Toaster message is - 'You have reached the maximum limit of forgot password.' ");
					break;
				}
				intValue++;
			}
			genericFunctions.logEvent("Verified that reset Password e-mail to the customer can be sent maximum - "
					+ config.getProperty("resetPasswordMailSentMaximumValue") + " times.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyOTPcountInDatabaseIsMaximum(int intValue) {
		try {
			SoftAssertUtil.myAssert().assertTrue(
					intValue == Integer.parseInt(config.getProperty("resetPasswordMailSentMaximumValue")),
					"The db value does not match as expected ...");
			genericFunctions
					.logEvent("Verified that reset Password e-mail to the customer  sent count with the Database.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyEnteringOTPReceivedOnEmailedMaximumTimes(String dbValue) {
		try {
			intValue = Integer.parseInt(dbValue);
			while (intValue <= (Integer.parseInt(config.getProperty("resendOTPMaximumValue")))) {
				if (intValue < Integer.parseInt(config.getProperty("resendOTPMaximumValue"))) {
					getButtonResend().click();
					SoftAssertUtil.myAssert().assertTrue(getToasterSuccessmessageOTPSent().isDisplayed(),
							"The Otp Send Message is not  displayed .");
					SoftAssertUtil.myAssert().assertTrue(
							getToasterSuccessmessageOTPSent().getText().trim()
									.equals("We have sent otp to your email/sms. Please check your inbox!."),
							"The Otp Send Message is not as expected,. Expected Message is 'We have sent otp to your email/sms. Please check your inbox!.' .");
					Thread.sleep(6000);
				} else {
					Thread.sleep(5000);
					getButtonResend().click();
					while (!getToasterErrormessageOTPSent().isDisplayed()) {
					}

					SoftAssertUtil.myAssert().assertTrue(getToasterErrormessageOTPSent().isDisplayed(),
							"The OTP resend Maximum Limit message is not displayed .");
					SoftAssertUtil.myAssert().assertTrue(
							getToasterErrormessageOTPSent().getText().trim()
									.equals("You have reached the maximum limit of resend otp."),
							"The OTP resend Maximum Limit message is not expected . Expected Message is - 'You have reached the maximum limit of resend otp.' .");
				}
				intValue++;
			}
			genericFunctions.logEvent("Verify 3 times OTP is resent from UI Side");
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyMaximumOTPValueInDatabase(String dbValue) {
		try {
			SoftAssertUtil.myAssert().assertTrue(
					Integer.parseInt(dbValue) == Integer.parseInt(config.getProperty("resendOTPMaximumValue")),
					"The db value does not match as expected ...");
			genericFunctions.logEvent("Verified that resend OTP e-mail to the customer  sent count with the Database.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyDbValuesPostInvalidPasswordAttempts(int intValue, int intValue1) {
		try {
			SoftAssertUtil.myAssert().assertTrue(
					intValue == Integer.parseInt(config.getProperty("maximumInvalidLogins")),
					"'tbllogin_attempts' Table value i,.e,. " + intValue
							+ " does not match with the expected value . i.,e,. - "
							+ config.getProperty("maximumInvalidLogins"));

			SoftAssertUtil.myAssert().assertTrue(intValue1 == 0, "'tblcontact' table 'active' coloumn value i,.e,. "
					+ intValue1 + " does not match with the expected value . i.,e,. - 0");
			genericFunctions.logEvent(
					"Verified the database table 'tbllogin_attempts' and 'tblcontact' values succussfully !!! ");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void loginApplication(String... args) {
		try {
			Thread.sleep(3000);
			getTextboxUsername().clear();
			if (args.length > 1) {
				getTextboxUsername().sendKeys(args[1].toString());
			} else {
				getTextboxUsername().sendKeys(config.getProperty("firstName"));
			}
			getTextboxPassword().clear();
			getTextboxPassword().sendKeys(args[0]);
			getButtonLogIn().click();
			Thread.sleep(5000);
			SoftAssertUtil.myAssert()
					.assertTrue((driver.getCurrentUrl()
							.equals("http://ec2-13-229-128-214.ap-southeast-1.compute.amazonaws.com/admin/dashboard"))
							&& (driver.getTitle().equals("Sentinel")), "User is not navigated to homepage");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String resetToDefaultPassword(String... args) {

		try {
			stringValue = "Reset Password";
			String changePasswordFlag = args[0];
			SignInPage signIn = new SignInPage();
			ProjectDatabaseQueries projectDatabaseQueries = new ProjectDatabaseQueries();
			if (changePasswordFlag.equals("change to default password")) {
				// Get the Email Id from the DB
				dbValue = projectDatabaseQueries.updateAndGetEmailAddressDataBase();
				// Click on 'Reset Password' Radio Button
				signIn.navigateToForgetUsernameOrPasswordPage(stringValue);
				// check the number of times reset password email id is send .
				// Maximum 5
				// times is allowed. If more than 5 delete all related to id
				projectDatabaseQueries.checkContactIdCountInOTPTableUpdateIfNeeded(dbValue);
				// send otp mail
				signIn.verifysendOTPFunctionality(dbValue);
				// get the otp value from the email and store it in the
				// stringValue variable
				stringValue = signIn.getvalueFromMailBox(dbValue);
				// enter the otp and proceed to change password screen
				signIn.verifyEnteringOTPReceivedOnEmailed(stringValue);
				// enter new password and confirm password
				stringValue = signIn.verifyNewPasswordConfirmPasswordFuntionality(changePasswordFlag);
				changePasswordFlag = "Don't Change the Password";
			} else {
				stringValue = config.getProperty("defaultPasswordToBeSet");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringValue;
	}
}
