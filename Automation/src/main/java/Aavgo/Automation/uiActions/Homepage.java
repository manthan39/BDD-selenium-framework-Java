package Aavgo.Automation.uiActions;


import java.awt.RenderingHints.Key;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	
	@FindBy(xpath="//*[@id='body-section']/div[1]/span/div/div[4]/section[2]/div[2]/div[2]/input")	
	WebElement Nationalitydrpdown;
	
	@FindBy(xpath="//*[@id='body-section']/div[1]/span/div/div[4]/section[2]/div[2]/div[4]/input")	
	WebElement BirthdayField;
	
	@FindBy(xpath="//*[@id='body-section']/div[1]/span/div/div[4]/section[2]/div[2]/div[5]/select")	
	WebElement CountryofBirth;
	
	@FindBy(xpath="//*[@id='body-section']/div[1]/span/div/div[4]/section[2]/div[2]/div[6]/select")	
	WebElement Genderdrpdwn;
	
	@FindBy(xpath="html/body/div[8]/div[1]/table/tbody/tr[1]/td[4]")	
	WebElement SelectDate;
	

	

public Homepage(WebDriver driver){
	this.driver=driver;
    PageFactory.initElements(driver, this);
	//Homepage homePage = PageFactory.initElements(driver, Homepage.class);

	
}

public void VerifyLogin(String email,String passwd){

	
	Emailfield.sendKeys(email);
	Passwdfield.sendKeys(passwd);
	Passwdfield.sendKeys(Keys.ENTER);
	
}

public void clickonvisaBtn(){

	visaBtn.click();
	
}

public void clickonLoginBtn(){
	LoginBtn.click();
}

public void enteremail(){
	Emailfield.sendKeys("Test@123.com");

}

public void EnterArrivalDate(){
	Emailfield.sendKeys(Keys.TAB);
	SelectDate.click();

}

public void selectcountrycode(){
	Select drpdwn = new Select(CountryCode);
	drpdwn.selectByVisibleText("+91");
}

public void EnterPhoneNumber(){
	PhoneNumberField.sendKeys("70430123404");	
}

public void EnterFirstName(){
	FirstName.sendKeys("Hari");	
}

public void EnterLastName(){
	LastName.sendKeys("Sandu");	
}


public void selectNationality(){
	Select drpdwn = new Select(Nationalitydrpdown);
	drpdwn.selectByVisibleText("India (IN)");
}

public void EnterBirthday(){
	PhoneNumberField.sendKeys("19940908");	
}
public void selectCountryofBirth(){
	Select drpdwn = new Select(CountryofBirth);
	drpdwn.selectByVisibleText("India (IN)");
}


public void selectGender(){
	Select drpdwn = new Select(Genderdrpdwn);
	drpdwn.selectByVisibleText("Male");
}

public void clickonLogout(){
	UserBtn.click();
	LogoutBtn.click();
}


}	


