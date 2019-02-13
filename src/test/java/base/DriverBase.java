/**
 * Automatic webdriver instantiation
 */
package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import listeners.LogListener;
import listeners.RetryListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import org.testng.annotations.Listeners;


@Listeners({LogListener.class, RetryListener.class})
public class DriverBase {
	private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();
	private static List<WebDriver> driverThreadPool = Collections.synchronizedList(new ArrayList<>());

	@BeforeSuite
	@Parameters({"BrowserName", "UseRemote", "GridURL", "DesiredPlatform", "BrowserVersion", "ProxyEnabled", "ProxyHost",
			"ProxyPort"})
	public void DriverSetup(String BrowserName, String UseRemote, String GridURL, String DesiredPlatform,
							String BrowserVersion, String ProxyEnabled, String ProxyHost, String ProxyPort) {
	    final String browserName     = BrowserName;
		final String useRemote       = UseRemote;
		final String gridURL         = GridURL;
		final String desiredPlatform = DesiredPlatform;
		final String browserVersion  = BrowserVersion;
		final String proxyEnabled    = ProxyEnabled;
		final String proxyHost       = ProxyHost;
		final String proxyPort       = ProxyPort;
		driverThread = ThreadLocal.withInitial(() -> {
			final WebDriver driver = DriverType.getDriverType(browserName, useRemote, gridURL, desiredPlatform,
					browserVersion, proxyEnabled, proxyHost, proxyPort);
			driverThreadPool.add(driver);
			return driver;
		});
	}

	
	/**
	  * Uses the getDriver() on the WebDriverThread object to pass each HelloController a WebDriver instance it can use
	  * @return browser Desired Capabilities which defined in WebDriverThread.java
	  */
	 public static WebDriver getDriver()  {
		if (driverThread.get() == null){
			System.out.println("!!! WebDriver is not established !!!");
			throw new NullPointerException();
		}
	 	return driverThread.get();
	 }

	 /**
	  * Automatic clear browser cookies after complete each HelloController so no need to close browser for next HelloController.
	  */
	 @AfterMethod
	 public static void clearCookies(){
		 getDriver().manage().deleteAllCookies();
		 // deleteAllCookies is not working with Safari Driver
		 // workaround solution: https://github.com/seleniumhq/selenium-google-code-issue-archive/issues/5212
	 }

	 
	 /**
	  * Automatically destroy the driver instance in each thread (close all browsers) after running all HelloController
	  */
	 @AfterSuite
	 public static void quitDriver() {
		for (WebDriver driver : driverThreadPool) {
			if (driver != null) {
				driver.close();
				driver.quit();
			}
		} 
	 }
}
