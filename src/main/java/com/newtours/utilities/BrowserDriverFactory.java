package com.newtours.utilities;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.BrowserType;

/**
 * This Class is used to initialize the <b>Web Driver</b>.
 * 
 * @author Sujay Sawant
 * @version 1.0.4
 * @since 03/01/2020
 */
public class BrowserDriverFactory {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private String browser;

	/**
	 * This constructor is used to initialze the browser
	 * 
	 * @param browser : Browser to run Automation on
	 */
	public BrowserDriverFactory(String browser) {
		this.browser = browser.toLowerCase();
	}

	/**
	 * This method is used to create a Web Driver object
	 * 
	 * @return Web Driver object
	 */
	public WebDriver createDriver() {
		switch (browser) {
		case BrowserType.CHROME:
			System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, Constants.driverPath_chrome);
			driver.set(new ChromeDriver());
			break;
		case BrowserType.FIREFOX:
			System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, Constants.driverPath_firefox);
			driver.set(new FirefoxDriver());
			break;
		case BrowserType.IE:
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			options.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, UnexpectedAlertBehaviour.ACCEPT);
			options.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
			options.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY, Constants.driverPath_ie);
			driver.set(new InternetExplorerDriver(options));
			break;
		default:
			System.out.println("Invalid browser name provided.");
		}
		return driver.get();
	}

}
