package com.sentinel.driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class WebDriverTestBase {

	public static WebDriver driver = null;
	// public static WebDriver reportDriver;
	public static Logger logger = Logger.getLogger("devpinoyLogger");
	public static FileInputStream fs;
	public static File file = null;
	public static String screenshotPath = System.getProperty("user.dir") + "\\Screenshots";
	public static String applicationDirectory = System.getProperty("user.dir") + "\\logs";
	public static String log4jPath = System.getProperty("user.dir") + "\\resources\\log4j.properties";
	public static String baseURL = null;
	public static Properties config;
	public static Properties projectInputSource;
	public static Properties functionNavigationArguments;
	public static String configPath = System.getProperty("user.dir") + "\\resources\\propertyFiles\\config.properties";
	public static String projectInputSourcePath = System.getProperty("user.dir")
			+ "\\resources\\propertyFiles\\projectInputSource.properties";
	public static String functionNavigationArgumentsPath = System.getProperty("user.dir")
			+ "\\resources\\propertyFiles\\functionNavigationArguments.properties";
	

	/**
	 * 
	 * @throws Exception
	 *             --> Initiate properties,logger and driver
	 */
	@BeforeSuite(alwaysRun = true)
	public void DriversetUp() throws Exception {
		initConfig();
		initDriver(config.getProperty("browser"));
		/*initObjects();*/
		
	}

	/**
	 * 
	 * @param browserName
	 *            --> Get the Browser name from base.properties file.
	 */
	public void initDriver(String browserName) {
		logger.debug("Project Path in Ide - " + System.getProperty("user.dir"));

		if (driver == null) {

			browserName = browserName.toLowerCase().trim();
			switch (browserName) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\Browsers\\Chrome_Exe_File\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("disable-infobars");
				driver = new ChromeDriver(options);
				logger.debug("STARTED CHROME BROWSER");
				break;

			case "firefox":
				FirefoxProfile p1 = new FirefoxProfile();
				p1.setPreference("webdriver.log.file", "/tmp/firefox_console");
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\Browsers\\Firefox Gecko Driver\\geckodriver.exe");
				driver = new FirefoxDriver();
				logger.debug("STARTED FIREFOX BROWSER");
				break;

			case "internet explorer":
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\Browsers\\IE_Exe_File\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				logger.debug("STARTED INTERNET EXPLORER BROWSER");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case "ie":
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\Browsers\\IE_Exe_File\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				logger.debug("STARTED INTERNET EXPLORER BROWSER");
				break;

			case "phantom":
				System.out.println("1");
				File file = new File(System.getProperty("user.dir") + "\\Browsers\\PhantomJS\\phantomjs.exe");
				System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
				System.out.println("2");
				driver = new PhantomJSDriver();
				System.out.println("3");
				logger.debug("STARTED PHANTOM JS");
				break;

			case "html":
				System.out.println("1");

				driver = new HtmlUnitDriver();
				System.out.println("2");
				logger.debug("STARTED HTML UNIT DRIVER");
				break;

			default:
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\Browsers\\Chrome_Exe_File\\chromedriver.exe");
				driver = new ChromeDriver();
				logger.debug("STARTED DEFAULT CHROME BROWSER");
				break;
			}

			if (!browserName.equals("html")) {
				driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS).implicitlyWait(60, TimeUnit.SECONDS)
						.setScriptTimeout(60, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			}

			baseURL = config.getProperty("projectUrl");
			driver.get(baseURL);
			logger.debug("Navigated to base URL - " + baseURL);
			systemInformation();

		}
	}

	private void systemInformation() {
		logger.debug("\n\n");
		logger.debug("-- SYSTEM INFORMATION --");
		logger.debug("Operating system Name - " + System.getProperty("os.name").toUpperCase());
		logger.debug("Operating system version - " + System.getProperty("os.version"));
		logger.debug("User working directory - " + System.getProperty("user.dir"));
		logger.debug("Operating system architecture - " + System.getProperty("os.arch"));
		logger.debug("JRE version number - " + System.getProperty("java.version"));
		logger.debug("JRE vendor URL - " + System.getProperty("java.vendor.url"));
		logger.debug("JRE vendor name - " + System.getProperty("java.vendor"));
		logger.debug("Installation directory for Java Runtime Environment (JRE) - " + System.getProperty("java.home"));
		logger.debug("Operating system Name - " + System.getProperty("os.name").toUpperCase());
		logger.debug("Operating system version - " + System.getProperty("os.version"));
		logger.debug("Testing Browser :- " + config.getProperty("browser").toUpperCase());
		logger.debug("\n\t\t\t\n -- PROJECT LOGS -- \n");

	}

	/**
	 * 
	 * @throws initConfid
	 *             --> This function will load the property file .
	 */
	public void initConfig() throws IOException {

		config = new Properties();
		fs = new FileInputStream(configPath);
		config.load(fs);

		projectInputSource = new Properties();
		fs = new FileInputStream(projectInputSourcePath);
		projectInputSource.load(fs);
		config.putAll(projectInputSource);

		functionNavigationArguments = new Properties();
		fs = new FileInputStream(functionNavigationArgumentsPath);
		functionNavigationArguments.load(fs);
		config.putAll(functionNavigationArguments);

		if (new File(screenshotPath).exists()) {
			FileUtils.deleteDirectory(new File(screenshotPath));
		}
		logger = Logger.getLogger("devpinoyLogger");

	}

	@AfterSuite(alwaysRun = true)
	public void teardownTest() throws InterruptedException {
		if (!(driver == null)) {
			if (config.getProperty("browser").toLowerCase().equals("firefox")) {
				Thread.sleep(2000);
			}
			driver.quit();
		}
	}

/*	public SoftAssert initObjects() {
		if (softAssertion == null) {
			softAssertion = new SoftAssert();
		}
		return softAssertion;

	}
	public void clean() {
		
		softAssertion = new SoftAssert();
	}*/
}
