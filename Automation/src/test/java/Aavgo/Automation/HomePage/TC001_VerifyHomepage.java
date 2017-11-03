package Aavgo.Automation.HomePage;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Aavgo.Automation.uiActions.Homepage;
import testBase.testBase;

public class TC001_VerifyHomepage extends testBase  {
	
	Homepage hmpage;
	testBase tb;
	@BeforeClass
	public  void setUp(){
		tb=new testBase();
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://www.google.com");
		
		

	}
	

	
//	@Test(priority=1)
	public void Verifyloginwithvalidcredentials(){
		hmpage.clickonMyAcc();
		hmpage.clickonLoginBtn();
		hmpage.VerifyLogin("user@phptravels.com", "demouser");
		Assert.assertEquals(hmpage.getvalidlogintext(), "Hi, Johny Smith");
	        }
	
//	@Test(priority=2)
	public void VerifyLogoutBtn(){
		Assert.assertEquals(hmpage.verifylogoutDisplay(), true);
	} 
	
//	@Test (priority=3)
	public void Verifylogout(){
		hmpage.clickonLogout();
	}

	@Test
	public void searchtest(){
		hmpage.testclick();
	}
	
	 	
	
	@AfterClass
	public  void endTest(){
		driver.close();
		
	}
}
