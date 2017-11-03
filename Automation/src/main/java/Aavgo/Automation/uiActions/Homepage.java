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

		

	

	@FindBy(xpath="(//a[contains(@href, 'javascript:void(0);')])[3]")
	WebElement MyaccountBtn;
	
	
	@FindBy(xpath="//*[@id='li_myaccount']/ul/li[1]/a")
	WebElement LoginBtn;
	
	@FindBy(xpath="//*[@id='loginfrm']/div[1]/div[5]/div/div[1]/input")
	WebElement Emailfield; 
	
	@FindBy(xpath="//*[@id='loginfrm']/div[1]/div[5]/div/div[2]/input")
	WebElement Passwdfield;

	@FindBy(xpath="//*[@id='body-section']/div/div[1]/div/div[1]/h3")
	WebElement validlogintext;
	
	@FindBy(xpath="html/body/div[3]/div/div/div[2]/ul/ul/li[1]/a")
	WebElement UserBtn;
	
	@FindBy(xpath="html/body/div[3]/div/div/div[2]/ul/ul/li[1]/ul/li[2]/a")
	WebElement LogoutBtn;

	@FindBy(xpath="//*[@id='tsf']/div[2]/div[3]/center/input[1]")	
	WebElement click;
	
	

public Homepage (WebDriver driver){
	PageFactory.initElements(driver, this);
}

public void VerifyLogin(String email,String passwd){

	
	Emailfield.sendKeys(email);
	Passwdfield.sendKeys(passwd);
	Passwdfield.sendKeys(Keys.ENTER);
	
}

public void clickonMyAcc(){
	Select drpdwn= new Select(MyaccountBtn);
	drpdwn.selectByVisibleText("Login");
}

public void clickonLoginBtn(){
	LoginBtn.click();
}

public String getvalidlogintext(){
	return validlogintext.getText(); 
	
}

public boolean verifylogoutDisplay(){
	UserBtn.click();
	try{
	LogoutBtn.isDisplayed();
	return true;
	}catch(Exception e){
	return false;	
	}
}
public void clickonLogout(){
	UserBtn.click();
	LogoutBtn.click();
}

public void testclick(){
	click.click();
}	

}	


