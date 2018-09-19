package Aavgo.Automation.HomePage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Aavgo.Automation.uiActions.Homepage;
import testBase.testBase;

public class TC001_VerifyHomepage extends testBase  {
	
//	Homepage hmpage = PageFactory.initElements(driver, Homepage.class);
		
	//public WebDriver driver= null;

		Homepage hmpage;




	//@Parameters({"url"})
		
	@BeforeClass
	public  void setUp(){
		
		/*System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");*/
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		/*driver=new FirefoxDriver();*/
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.phptravels.net/");
		
		

	}
	

	
	@Test
	
	@Parameters({"mailid","mobileNo","FirstName","LastName"})
	
	public void testvisa(String strMailID,String strMobNo,String strFirstName,String strLastName){
		hmpage = new Homepage(driver);
		hmpage.clickonvisaBtn();
		hmpage.enteremail().sendKeys(strMailID);
		//hmpage.EnterArrivalDate();
		hmpage.selectcountrycode();
		hmpage.EnterPhoneNumber().sendKeys(strMobNo);
		hmpage.EnterFirstName().sendKeys(strFirstName);
		hmpage.EnterLastName().sendKeys(strLastName);
		hmpage.selectNationality();
		hmpage.SelectBirthday();
		hmpage.selectCountryofBirth();
		hmpage.selectGender();
		hmpage.EnterpassportNumber();
		hmpage.EnterpassportIssuedDetail();
		hmpage.EnterpassportExpirationDetail();
		hmpage.selectsupportingDoc();
		hmpage.SelectCountrythatIssued();
	//	hmpage.SelectVisaExpiry();
		hmpage.clickcheckbox();
	
	
		
	}
	
	 	
	
	@AfterClass
	public  void endTest(){
		driver.close();
		
	}
}
