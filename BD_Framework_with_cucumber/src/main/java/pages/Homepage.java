package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import locators.HomepageLocator.IautoLocator;
import testBase.testBase;

/**
 * @author mvbhatiya
 *
 */
public class Homepage extends testBase {

	@FindBy(xpath = IautoLocator.usernamefield)
	private WebElement usernamefield;

	@FindBy(xpath = IautoLocator.passwordfield)
	private WebElement passwdfield;

	@FindBy(xpath = IautoLocator.username_mandatory)
	private WebElement username_mandatory1;

	@FindBy(css = IautoLocator.loginBtn)
	private WebElement LoginBtn;

	@FindBy(xpath = IautoLocator.LogoutBtn)
	private WebElement LogoutBtn;

	@FindBy(xpath = IautoLocator.InvalidMsgTxt)
	private WebElement InvalidMsgTxt;

	public void EnterUsername(String username) {
		usernamefield.clear();
		usernamefield.sendKeys(username);
	}

	public void Enterpassword(String password) {
		passwdfield.clear();
		passwdfield.sendKeys(password);
	}

	public void EnterUsername_mandatory(String username_mandatory) {
		username_mandatory1.clear();
		username_mandatory1.sendKeys(username_mandatory);
	}

	public void ClickonLoginBtn() {
		LoginBtn.click();
	}

	public void LoadUrl() {
		driver.get("http://www.way2automation.com/angularjs-protractor/registeration/#/login");

	}

	public void CloseBrowser() {
		driver.quit();

	}

	public String verifyLogoutBtnMsg() {
		return LogoutBtn.getAttribute("href");
	}

	public void ClickonLogoutBtn() {
		LogoutBtn.click();
	}

	public String GetInvalidMsg() {
		return InvalidMsgTxt.getText();
	}

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
}