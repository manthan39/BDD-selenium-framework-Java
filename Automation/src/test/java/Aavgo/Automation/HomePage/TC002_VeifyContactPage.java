/**
 * 
 */
package Aavgo.Automation.HomePage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Aavgo.Automation.uiActions.contactPage;
import testBase.testBase;

/**
 * @author mvbhatiya
 *
 */
public class TC002_VeifyContactPage extends testBase {
	
	contactPage ctpage ;
	
	@BeforeClass
	public void setUp() {

		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		 */
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		/* driver=new FirefoxDriver(); */
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.phptravels.net/contact-us");

	}

	@Test
	public void verifycontactPage() throws InterruptedException {
		ctpage = new contactPage(driver);
		Thread.sleep(3000);
		ctpage.EnterUsername("test");
		ctpage.EnterEmail("test@1234.com");
		ctpage.EnterSub("hello");
		ctpage.EnterMsg("this is automated test");
		ctpage.clickOnsubmitBtn();
		
	}

	@AfterClass
	public void endTest() {
		driver.close();

	}
}
