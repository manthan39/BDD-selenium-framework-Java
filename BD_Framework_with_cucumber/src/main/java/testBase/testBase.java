package testBase;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class testBase {

	public static WebDriver driver = null;

	public testBase() {

		retrivewebdriver();

	}

	public WebDriver retrivewebdriver() {

		if (driver == null) {
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile myprofile = profile.getProfile("Manthan");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver(myprofile);
			driver.manage().window().maximize();
		}
		return driver;
	}

	/*
	 * @AfterClass() public void tearDown(){
	 * 
	 * driver.close();
	 * 
	 * }
	 */
}

/*
 * public WebDriver getDriver() { return driver; }
 * 
 * public void setDriver(EventFiringWebDriver driver) { this.driver = driver; }
 */
