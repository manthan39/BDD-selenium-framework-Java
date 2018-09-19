/**
 * 
 */
package Aavgo.Automation.HomePage;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testBase.testBase;

/**
 * @author mvbhatiya
 *
 */
public class WindowHandle extends testBase {

	@BeforeClass
	public void setUp() {
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		 */
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		/* driver=new FirefoxDriver(); */
		driver = new ChromeDriver(cap);
		driver.manage().window().maximize();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");

	}

	@Test
	public void switchwindow() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='button1']")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				Thread.sleep(3000);
				driver.close(); // closing child window
				driver.switchTo().window(parentWindow);
				driver.close();
				
			}
		}
	}
}
