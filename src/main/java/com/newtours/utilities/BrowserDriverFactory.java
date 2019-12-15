package com.newtours.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * This Class is used to initialize the <b>Web Driver</b>.
 * 
 * @author Sujay Sawant
 * @version 1.0.3
 * @since 12/14/2019
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
		case "chrome":
			System.setProperty(Constants.driver_chrome, Constants.driverPath_chrome);
			driver.set(new ChromeDriver());
			break;
		case "firefox":
			System.setProperty(Constants.driver_firefox, Constants.driverPath_firefox);
			driver.set(new FirefoxDriver());
			break;
		case "ie":
			System.setProperty(Constants.driver_ie, Constants.driverPath_ie);
			driver.set(new InternetExplorerDriver());
			break;
		default:
			System.out.println("Invalid browser name provided.");
		}
		return driver.get();
	}

}
