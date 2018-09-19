/**
 * 
 */
package Aavgo.Automation.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author mvbhatiya
 *
 */
public class contactPage {

	WebDriver driver;

	@FindBy(xpath = "//div[@id='body-section']/div/div/div/div/form/div/div[2]/input")
	WebElement NameField;

	@FindBy(xpath = "//input[2]")
	WebElement EmailField;

	@FindBy(xpath = "//input[3]")
	WebElement SubField;

	@FindBy(xpath = "//textarea")
	WebElement MsgField;

	@FindBy(xpath = "//form/div[2]/input")
	WebElement SubmitBtn;

	public contactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// Homepage homePage = PageFactory.initElements(driver, Homepage.class);

	}

	public void EnterUsername(String userName) {
		NameField.sendKeys(userName);
	}

	public void EnterEmail(String email) {
		EmailField.sendKeys(email);

	}

	public void EnterSub(String Sub) {
		SubField.sendKeys(Sub);
	}

	public void EnterMsg(String msg) {
		MsgField.sendKeys(msg);
	}
	public void clickOnsubmitBtn(){
		SubmitBtn.click();
	}
}
