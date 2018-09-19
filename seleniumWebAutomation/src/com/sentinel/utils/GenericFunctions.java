package com.sentinel.utils;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import com.sentinel.driver.WebDriverTestBase;

public class GenericFunctions extends WebDriverTestBase {

	public static int invisibleExceptionCounter = 0;
	public static Actions action = null;
	public static File file = null;
	public static String exceptionFolder = System.getProperty("user.dir") + "\\ExceptionFiles\\Exception.txt";
	public static Robot robot = null;
	public static int exceptionCounter = 1;
	boolean elementLoaded;
	Actions actions = null;
	ArrayList<String> arrayListValue = null;
	Random random = new Random();
	public static GenericFunctions genericFunctions = new GenericFunctions();
	public static URL link = null;
	public static HttpURLConnection httpConn = null;
	JavascriptExecutor js = null;

	public void waitForPageLoad() {
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

	public boolean waitForElementVisible(WebElement webElement) {

		elementLoaded = false;
		try {
			for (int i = 0; i < 30; i++) {
				java.util.concurrent.TimeUnit.SECONDS.sleep(2);

				if (webElement.isDisplayed() == true) {
					elementLoaded = true;
					return elementLoaded;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return elementLoaded;
	}

	public boolean waitForElementInvisible(WebElement webElement) {

		elementLoaded = true;
		for (int i = 0; i < 30; i++) {
			try {
				java.util.concurrent.TimeUnit.SECONDS.sleep(1);

				if (webElement.isDisplayed() == false) {
					elementLoaded = true;
					return elementLoaded;
				}
			} catch (Exception e) {
				elementLoaded = true;
				break;
			}
		}
		return elementLoaded;
	}

	public int generateRandomNumber(int minimum, int maximum) {

		int randomNum = minimum + random.nextInt((maximum - minimum) + 1);
		return randomNum;
	}

	public void scrollToElement(WebElement element) {

		actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public String generaterandomString(int stringLength) {

		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < stringLength; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String output = sb.toString();
		return output;

	}

	public String generateRandomEmail() {
		String email;
		email = "sentinel_" + (System.currentTimeMillis() % 1000000000) + "@mailinator.com";
		return email;
	}

	public String getCurrentDate() {

		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		return date;

	}

	public String screenshotOnFailure(String fileName) {
		String screenshotFilePath = null, test = null;
		link = null;
		File scrFile = ((TakesScreenshot) WebDriverTestBase.driver).getScreenshotAs(OutputType.FILE);
		try {
			Thread.sleep(2000);
			screenshotFilePath = System.getProperty("user.dir") + "\\Screenshots\\" + fileName + "_" + exceptionCounter
					+ ".jpg";
			FileUtils.copyFile(scrFile, new File(screenshotFilePath));
			exceptionCounter++;
			String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
			System.setProperty(ESCAPE_PROPERTY, "false");
			link = new File(screenshotFilePath).toURI().toURL();
			test = "<a href=" + link + "> click to open screenshot of " + fileName + "</a>";
		} catch (Exception e) {

			e.printStackTrace();
		}
		return test;
	}

	public void completescreenshotOnFailure(String fileName) {
		String completeScreenPhoto = System.getProperty("user.dir") + "\\CompleteScreenshots\\";
		try {
			file = new File(completeScreenPhoto);
			if (!file.exists()) {
				file.mkdir();
			}
			robot = new Robot();
			BufferedImage screenShot = robot
					.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(screenShot, "JPG", new File(file + "\\" + fileName + "E_NO_" + exceptionCounter + ".jpg "));
			exceptionCounter++;
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public boolean verifyElementPresent(WebElement element) {

		elementLoaded = false;
		try {
			if (element.isDisplayed() == true) {
				if ((element.isDisplayed())) {
					elementLoaded = true;
				} else {
					elementLoaded = false;
				}
			}
		} catch (Exception e) {
			elementLoaded = false;
		}
		return elementLoaded;

	}

	public boolean verifyElementDisplayedOnDOM(WebElement element) {

		elementLoaded = false;
		try {
			if (element.isDisplayed() == true) {
				elementLoaded = true;
			}
		} catch (Exception e) {
			elementLoaded = false;
		}
		return elementLoaded;
	}

	public int verifyLink(String urlLink) throws IOException {
		try {
			link = new URL(urlLink);
			httpConn = (HttpURLConnection) link.openConnection();
			httpConn.setConnectTimeout(2000);
			// connect using connect method
			httpConn.connect();
			// use getResponseCode() to get the response code.
			if (httpConn.getResponseCode() == 200) {
				// System.out.println(urlLink + " - " +
				// httpConn.getResponseMessage());
			}
			if (httpConn.getResponseCode() == 404) {
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return httpConn.getResponseCode();
	}

	public void logEvent(String eventLog) {
		logger.debug(eventLog);
		Reporter.log(eventLog + "<br>");

	}

	public static void highlightElement(WebElement element) {
		GenericFunctions genericFunctions = new GenericFunctions();
		genericFunctions.js = (JavascriptExecutor) driver;
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				genericFunctions.js.executeScript("arguments[0].setAttribute('style', ' border: 2px solid red;');",
						element);

			} else {
				genericFunctions.js.executeScript("arguments[0].setAttribute('style','border: 1px thin white;');",
						element);
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void navigateToNewTab() {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("window.open()");
			arrayListValue = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window((String) arrayListValue.get(1));
			WebDriverTestBase.driver.get(config.getProperty("emailSite"));
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String replaceSpecialCharacters(String stringValue, String[] specialCharArray) {
		for (int i = 0; i < specialCharArray.length; i++) {
			if (stringValue.indexOf(specialCharArray[i]) != 0) {
				stringValue = stringValue.replace(specialCharArray[i], "");
			}
		}
		stringValue = stringValue.replace("null", "");
		return stringValue;
	}

	public static void main(String[] args) {

		System.out.println(genericFunctions.generateRandomNumber(0, 3));

	}

	public String generateCustomizedRandomString(int length, String stringValue) {
		final String characters = stringValue;
		StringBuilder result = new StringBuilder();
		while (length > 0) {
			Random rand = new Random();
			result.append(characters.charAt(rand.nextInt(characters.length())));
			length--;
		}

		return result.toString();
	}

	public String generateCurrentDateAndTime(String dateformat) {
		/**
		 * date format - yyyy/MM/dd HH:mm:ss
		 */
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateformat);
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	

}
