package testBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

/**
 * @author mvbhatiya
 *
 */
public class testBase {

	public static WebDriver driver = null;

	public testBase() {

		retrivewebdriver();

	}

	public WebDriver retrivewebdriver() {

		if (driver == null) {

			/*
			 * ProfilesIni profile = new ProfilesIni(); FirefoxProfile myprofile
			 * = profile.getProfile("Manthan");
			 * System.setProperty("webdriver.gecko.driver",
			 * System.getProperty("user.dir") +
			 * "\\drivers\\geckodriver_new.exe"); //work with firefox driver
			 * 47.0 driver = new FirefoxDriver(myprofile);
			 */
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			// work with chrome browser Version 62.0.3202.94
			driver = new ChromeDriver();
	/*		System.setProperty("webdriver.gecko.driver",
					  System.getProperty("user.dir") +
					  "\\drivers\\geckodriver_new.exe");
			driver = new FirefoxDriver();*/
			driver.manage().window().maximize();
		}
		return driver;
	}

}

/*
 * public WebDriver getDriver() { return driver; }
 * 
 * public void setDriver(EventFiringWebDriver driver) { this.driver = driver; }
 */
