package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import locators.CalculatorPageLocator;
import locators.CalculatorPageLocator.IautoLocator;
import testBase.testBase;

/**
 * @author mvbhatiya
 *
 */
public class CalculatorPage extends testBase {

	@FindBy(xpath = IautoLocator.FirstInput)
	private WebElement firstInput;

	@FindBy(xpath = IautoLocator.SecondInput)
	private WebElement SecondInput;

	@FindBy(xpath = IautoLocator.SelectSymbol)
	private WebElement SelectSymbol;

	@FindBy(css = IautoLocator.GoBtn)
	private WebElement GoBtn;

	public void EnterFirstInput(String input) {
		firstInput.sendKeys(input);
	}

	public void EnterSecondInput(String input) {
		firstInput.sendKeys(input);
	}

	public void SelectFromDropDown(String symbol) {
		Select sc = new Select(SelectSymbol);
		sc.selectByVisibleText(symbol);
	}

	public void clickOnGoBtn() {
		GoBtn.click();
	}

	public CalculatorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
}
