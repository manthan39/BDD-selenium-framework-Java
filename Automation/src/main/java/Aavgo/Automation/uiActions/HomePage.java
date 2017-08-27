package Aavgo.Automation.uiActions;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private static final Boolean True = null;


	private static final Boolean False = null;


	//WebDriver driver;	
	@FindBy(id="username")
	 WebElement username;
	
	
	@FindBy(id="userpass")
	WebElement password;
	
	@FindBy(id="loginForm")
	WebElement LoginBtn;

	@FindBy(xpath="html/body/div[1]/div/div/div[2]/div[2]/p")
	WebElement LoginFailMsg;
	
	@FindBy(xpath="//*[@id='sidebar-scroll']/div/div[3]/div/ul/li[3]/a/span")
	 WebElement LogoutBtn;
	
public HomePage(WebDriver driver){
	PageFactory.initElements(driver, this);
}	
	
	
public void loginToApplication(String emailAddress,String passwd){
	username.sendKeys(emailAddress);
	password.sendKeys(passwd);
	LoginBtn.click();
}
public String getInvalidLoginText(){
	return LoginFailMsg.getText();

	
}

public Boolean getLogoutBtn(){
 
	try{
	LogoutBtn.getText();
	return True;
	}
	
	catch(Exception e){
	return False;	
	}
}
	
	
}	
	


