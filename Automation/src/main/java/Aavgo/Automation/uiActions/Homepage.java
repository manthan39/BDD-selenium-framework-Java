package Aavgo.Automation.uiActions;


import java.awt.RenderingHints.Key;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import Aavgo.Automation.HomePage.TC001_VerifyHomepage;
import testBase.testBase;



public class Homepage extends testBase   {

	WebDriver driver;



	@FindBy(xpath="html/body/nav[1]/div/div/div/ul/li[6]/a")
	WebElement visaBtn;
	
	
	@FindBy(xpath="//*[@id='li_myaccount']/ul/li[1]/a")
	WebElement LoginBtn;
	
	@FindBy(xpath="//*[@id='ivisa-global-fields']/div[2]/div[1]/input")
	WebElement Emailfield; 
	
	@FindBy(xpath="//*[@id='loginfrm']/div[1]/div[5]/div/div[2]/input")
	WebElement Passwdfield;

	@FindBy(xpath="//*[@id='body-section']/div/div[1]/div/div[1]/h3")
	WebElement validlogintext;
	
	@FindBy(xpath="html/body/div[3]/div/div/div[2]/ul/ul/li[1]/a")
	WebElement UserBtn;
	
	@FindBy(xpath="html/body/div[3]/div/div/div[2]/ul/ul/li[1]/ul/li[2]/a")
	WebElement LogoutBtn;

	@FindBy(xpath="//*[@id='ivisa-global-fields']/div[2]/div[2]/input")	
	WebElement ArrivalDate;
	
	@FindBy(xpath="//*[@id='ivisa-global-fields']/div[2]/div[3]/div/div/div/div[2]")	
	WebElement CountryCode;
	
	@FindBy(xpath="//*[@id='ivisa-global-fields']/div[2]/div[3]/div/input")	
	WebElement PhoneNumberField;
	
	@FindBy(xpath="//*[@id='body-section']/div[1]/span/div/div[4]/section[2]/div[2]/div[1]/input")	
	WebElement FirstName;
	
	@FindBy(xpath="//*[@id='body-section']/div[1]/span/div/div[4]/section[2]/div[2]/div[2]/input")	
	WebElement LastName;
	
	@FindBy(xpath="//*[@id='body-section']/div[1]/span/div/div[4]/section[2]/div[2]/div[3]/select")	
	WebElement Nationalitydrpdown;
	
	@FindBy(xpath="//*[@id='body-section']/div[1]/span/div/div[4]/section[2]/div[2]/div[4]/input")	
	WebElement BirthdayField;
	
	@FindBy(xpath="//*[@id='body-section']/div[1]/span/div/div[4]/section[2]/div[2]/div[5]/select")	
	WebElement CountryofBirth;
	
	@FindBy(xpath="//*[@id='body-section']/div[1]/span/div/div[4]/section[2]/div[2]/div[6]/select")	
	WebElement Genderdrpdwn;
	
	@FindBy(xpath="html/body/div[8]/div[1]/table/tbody/tr[1]/td[4]")	
	WebElement SelectDate;
	
	@FindBy(xpath="//*[@id='body-section']/div[1]/span/div/div[4]/section[2]/div[2]/div[7]/input")	
	WebElement PassportNumberField;
	
	@FindBy(xpath="//*[@id='body-section']/div[1]/span/div/div[4]/section[2]/div[2]/div[8]/input")	
	WebElement PassportIssuedField;
	
	
	@FindBy(xpath="//*[@id='dp_month']")
	WebElement Monthdrpdwn; 
	
	@FindBy(xpath="//*[@id='dp_day']")
	WebElement daydrpdwn; 
	
	@FindBy(xpath="//*[@id='dp_year']")
	WebElement yeardrpdwn; 

	@FindBy(xpath="//*[@id='dp_save']")
	WebElement SaveBtn;
	
	@FindBy(xpath="//*[@id='body-section']/div[1]/span/div/div[4]/section[2]/div[2]/div[9]/input")
	WebElement PassportExpirationField;
	
	@FindBy(xpath="//*[@id='ivisa-subtotal-section']/div[3]/div/div[3]/button")
	WebElement NextBtn;
	
	@FindBy(xpath="//span[contains(@class, 'dial-code') and text() = '+91']")
	WebElement IndianCountryCode;
	
	@FindBy(xpath="//*[@id='body-section']/div[1]/span/div/div[4]/section[2]/div[3]/div[1]/select")
	WebElement SupportingDoc;
	
	@FindBy(xpath="//*[@id='body-section']/div[1]/span/div/div[4]/section[2]/div[3]/div[2]/select")
	WebElement CountrythatIssued;
	
	@FindBy(xpath="//*[@id='body-section']/div[1]/span/div/div[4]/section[2]/div[3]/div[3]/input")
	WebElement VisaExpiry;
	
	@FindBy(xpath="//*[@id='body-section']/div[1]/span/div/div[4]/section[2]/div[4]/div/input")
	WebElement FirstCheckbox;
	
	
	
public Homepage(WebDriver driver){
	this.driver=driver;
    PageFactory.initElements(driver, this);
	//Homepage homePage = PageFactory.initElements(driver, Homepage.class);

	
}

/*public void VerifyLogin(String email,String passwd){

	
	Emailfield.sendKeys(email);
	Passwdfield.sendKeys(passwd);
	Passwdfield.sendKeys(Keys.ENTER);
	
}*/

public void clickonvisaBtn(){

	visaBtn.click();
	
}

public void clickonLoginBtn(){
	LoginBtn.click();
}


public  WebElement enteremail(){
	return Emailfield;

}

public void EnterArrivalDate(){
	
	List<WebElement> columns=ArrivalDate.findElements(By.tagName("td"));

	for (WebElement cell: columns){
	   //Select 13th Date 
	   if (cell.getText().equals("13")){
	      cell.findElement(By.linkText("13")).click();
	      break;
	   }
	   }

}

public void selectcountrycode(){
	/*Select drpdwn = new Select(CountryCode);
	drpdwn.selectByVisibleText("+91");*/
	CountryCode.click();
	IndianCountryCode.click();
}


public WebElement EnterPhoneNumber(){
	PhoneNumberField.clear();
	return 	PhoneNumberField;	
}


public  WebElement EnterFirstName(){
	return FirstName;
}


public  WebElement EnterLastName(){
	return LastName;	
}


public void selectNationality(){
	Nationalitydrpdown.sendKeys(Keys.ARROW_DOWN);
		
}

public void SelectBirthday(){
	BirthdayField.click();
	Select month = new Select(Monthdrpdwn);
	month.selectByIndex(1);
	Select day= new Select(daydrpdwn);
	day.selectByIndex(2);
	Select year= new Select(yeardrpdwn);
	year.selectByVisibleText("2017");
	SaveBtn.click();
}
public void selectCountryofBirth(){
	/*Select drpdwn1 = new Select(CountryofBirth);
	drpdwn1.selectByVisibleText("Andorra (AD)");*/
	CountryofBirth.sendKeys(Keys.ARROW_DOWN);
}


public void selectGender(){
	Select drpdwn2 = new Select(Genderdrpdwn);
	drpdwn2.selectByVisibleText("Male");
}


public void EnterpassportNumber(){
	PassportNumberField.sendKeys("23423534534234");
}



public void EnterpassportIssuedDetail(){
	PassportIssuedField.click();
	Select month = new Select(Monthdrpdwn);
	month.selectByIndex(1);
	Select day= new Select(daydrpdwn);
	day.selectByIndex(2);
	Select year= new Select(yeardrpdwn);
	year.selectByVisibleText("2017");
	SaveBtn.click();
}


public void EnterpassportExpirationDetail(){
	
	
	PassportIssuedField.sendKeys(Keys.TAB);
	Select month = new Select(Monthdrpdwn);
	month.selectByIndex(5);
	Select day= new Select(daydrpdwn);
	day.selectByIndex(2);
	Select year= new Select(yeardrpdwn);
	year.selectByVisibleText("2022");
	SaveBtn.click();
}

public void selectsupportingDoc(){
	SupportingDoc.sendKeys(Keys.ARROW_DOWN);
		
}

public void SelectCountrythatIssued(){
	CountrythatIssued.sendKeys(Keys.ARROW_DOWN);
		
}
public void SelectVisaExpiry(){
	/*String press = Keys.chord(Keys.SHIFT,Keys.ENTER); 
	FirstCheckbox.sendKeys(press);*/
	VisaExpiry.clear();
	Select month = new Select(Monthdrpdwn);
	month.selectByIndex(5);
	Select day= new Select(daydrpdwn);
	day.selectByIndex(2);
	Select year= new Select(yeardrpdwn);
	year.selectByVisibleText("2022");
	SaveBtn.click();
}

public void clickcheckbox(){
	List<WebElement> els = driver.findElements(By.xpath("//input[@type='checkbox']"));
	for ( WebElement el : els ) {
	    if ( !el.isSelected() ) {
	        el.click();
	    }
	}
}

public void clickonNext(){
	NextBtn.click();
	
}


}	


