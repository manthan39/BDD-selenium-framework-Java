package pages;

import org.openqa.selenium.Keys;
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

	@FindBy(id = IautoLocator.GoBtn)
	private WebElement GoBtn;

	public void EnterFirstInput(String input) {
		firstInput.clear();
		firstInput.sendKeys(input);
	}

	public void EnterSecondInput(String input1) {
		SecondInput.clear();
		SecondInput.sendKeys(input1);
	}

	public void SelectFromDropDown(String symbol) {
		Select sc = new Select(SelectSymbol);
		sc.selectByVisibleText(symbol);
	}
	
	public void clickOnGoBtn() {
		GoBtn.click();
	}
	
	public void Loadurl(){
		driver.get("http://www.way2automation.com/angularjs-protractor/calc/");
	}
	
	

	public CalculatorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
}
