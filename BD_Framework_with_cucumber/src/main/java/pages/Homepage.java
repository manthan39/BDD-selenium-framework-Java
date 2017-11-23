package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import locators.HomepageLocator.IautoLocator;
import testBase.testBase;

public class Homepage extends testBase {

	@FindBy(xpath = IautoLocator.usernamefield)
	private WebElement usernamefield;

	@FindBy(xpath = IautoLocator.passwordfield)
	private WebElement passwdfield;

	@FindBy(xpath = IautoLocator.username_mandatory)
	private WebElement username_mandatory1;

	@FindBy(css = IautoLocator.loginBtn)
	private WebElement LoginBtn;

	@FindBy(css = IautoLocator.LoggedinMsg)
	private WebElement LoggedinMsg;

	public void EnterUsername() {
		usernamefield.sendKeys("angular");
	}

	public void Enterpassword() {
		passwdfield.sendKeys("password");
	}

	public void EnterUsername_mandatory() {
		username_mandatory1.sendKeys("angular");
	}

	public void ClickonLoginBtn() {
		LoginBtn.click();
	}

	public void LoadUrl() {
		driver.get("http://www.way2automation.com/angularjs-protractor/registeration/#/login");

	}

	public String verifyLoogedinMsg() {
		return LoggedinMsg.getText();
	}

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
}