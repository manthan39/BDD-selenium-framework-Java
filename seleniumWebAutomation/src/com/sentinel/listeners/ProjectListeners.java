package com.sentinel.listeners;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.sentinel.driver.WebDriverTestBase;
import com.sentinel.utils.GenericFunctions;
import com.sentinel.utils.SoftAssertUtil;

public class ProjectListeners implements ITestListener {

	public static File file = null;
	GenericFunctions genericFunctions = new GenericFunctions();

	@Override
	public void onTestStart(ITestResult result) {
		/**
		 * Initiate Listener
		 */
		new SoftAssertUtil();

		/**
		 * Project Log
		 */
		WebDriverTestBase.logger
				.debug("-----------------------------------------------------------------------------------------");
		WebDriverTestBase.logger.debug("TEST CASE STARTED - " + result.getName().toUpperCase());
		WebDriverTestBase.logger
				.debug("-----------------------------------------------------------------------------------------");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// SoftAssertUtil.getAssert().assertAll();
		WebDriverTestBase.logger
				.debug("-----------------------------------------------------------------------------------------");
		// WebDriverTestBase.logger.debug("TEST CASE COMPLETED !!! " +
		// result.getName().toUpperCase());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// SoftAssertUtil.getAssert().assertAll();
		WebDriverTestBase.logger
				.debug("****************************************************************************************");
		WebDriverTestBase.logger.debug("TEST CASE FAILED ...." + result.getName());
		WebDriverTestBase.logger
				.debug("****************************************************************************************");

		/*
		 * JavascriptExecutor js = (JavascriptExecutor)
		 * WebDriverTestBase.driver; js.executeScript("scroll(0, -250);");
		 */
		Reporter.log(genericFunctions.screenshotOnFailure(result.getName()) + "<br>");
		Reporter.log("<br>");
		// genericFunctions.completescreenshotOnFailure(result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
	}

	@Override
	public void onFinish(ITestContext context) {

	}

}
