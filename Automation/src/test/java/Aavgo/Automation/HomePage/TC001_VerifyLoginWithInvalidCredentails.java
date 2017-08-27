package Aavgo.Automation.HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Aavgo.Automation.uiActions.HomePage;

public class TC001_VerifyLoginWithInvalidCredentails {
	
	private static final Object False = null;
	WebDriver driver;
	HomePage homepage;
	@BeforeClass
	public void setUp(){
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://dev.aavgo.com");
	}
	
	@Test
	public void verifyLoginWithInvalidCredentails() throws InterruptedException{
		homepage = new HomePage(driver);
		homepage.loginToApplication("ledoh@mobilevpn.top","wrongpass");
		Thread.sleep(5);
		Assert.assertEquals(homepage.getLogoutBtn(), False);
	}
	
	@AfterClass
	public void endTest(){
		driver.close();
		
	}
}
