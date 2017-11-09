package Aavgo.Automation.HomePage;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.jboss.netty.util.Timeout;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Aavgo.Automation.uiActions.Homepage;
import testBase.testBase;

public class TC001_VerifyHomepage extends testBase  {
	
//	Homepage hmpage = PageFactory.initElements(driver, Homepage.class);
		
	//public WebDriver driver= null;

		Homepage hmpage;




	
	@BeforeClass
	public  void setUp(){
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.phptravels.net");
		
		

	}
	

	
	@Test(priority=1)
	
	@Parameters({"mailid","mobileNo","FirstName","LastName"})
	
	public void testvisa(){
		hmpage = new Homepage(driver);
		hmpage.clickonvisaBtn();
		hmpage.enteremail().sendKeys("mailid");
		//hmpage.EnterArrivalDate();
		hmpage.selectcountrycode();
		hmpage.EnterPhoneNumber().sendKeys("mobileNo");
		hmpage.EnterFirstName().sendKeys("firstName");
		hmpage.EnterLastName().sendKeys("lastName");
		hmpage.selectNationality();
		hmpage.SelectBirthday();
		hmpage.selectCountryofBirth();
		hmpage.selectGender();
		hmpage.EnterpassportNumber();
		hmpage.EnterpassportIssuedDetail();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		hmpage.EnterpassportExpirationDetail();
		
	
	
	}
		
	 	
	
	//@AfterClass
	public  void endTest(){
		driver.close();
		
	}
}
