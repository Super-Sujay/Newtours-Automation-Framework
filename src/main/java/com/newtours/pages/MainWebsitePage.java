package com.newtours.pages;

import org.openqa.selenium.By;

import com.newtours.base.BaseTest;
import com.newtours.elements.Alert;
import com.newtours.elements.Banner;
import com.newtours.elements.Hyperlink;

/**
 * This is the Page Class for the main web page.<br>
 * <b>Note:</b> All the Page Classes must extend this Page Class.
 * 
 * @author Sujay Sawant
 * @version 1.0.3
 * @since 12/14/2019
 */
public class MainWebsitePage {

	public static Banner mercuryToursLogo = new Banner(BaseTest.getWebDriver(), "Mercury Tours", By.cssSelector("img[src='/images/nav/logo.gif']"));
	public static Hyperlink signOn = new Hyperlink(BaseTest.getWebDriver(), "Sign On", By.cssSelector("a[href='mercurysignon.php']"));
	public static Hyperlink register = new Hyperlink(BaseTest.getWebDriver(), "Register", By.cssSelector("a[href='mercuryregister.php']"));
	public static Hyperlink support = new Hyperlink(BaseTest.getWebDriver(), "Support", By.xpath(".//a[@href='mercuryunderconst.php' and text()='SUPPORT']"));
	public static Hyperlink contact = new Hyperlink(BaseTest.getWebDriver(), "Contact", By.xpath(".//a[@href='mercuryunderconst.php' and text()='CONTACT']"));
	public static Hyperlink home = new Hyperlink(BaseTest.getWebDriver(), "Home", By.cssSelector("a[href='mercurywelcome.php']"));
	public static Hyperlink flights = new Hyperlink(BaseTest.getWebDriver(), "Flights", By.cssSelector("a[href='mercuryreservation.php']"));
	public static Hyperlink hotels = new Hyperlink(BaseTest.getWebDriver(), "Hotels", By.xpath(".//a[@href='mercuryunderconst.php' and text()='Hotels']"));
	public static Hyperlink carRentals = new Hyperlink(BaseTest.getWebDriver(), "Car Rentals", By.xpath(".//a[@href='mercuryunderconst.php' and text()='Car Rentals']"));
	public static Hyperlink cruises = new Hyperlink(BaseTest.getWebDriver(), "Cruises", By.cssSelector("a[href='mercurycruise.php']"));
	public static Hyperlink destinations = new Hyperlink(BaseTest.getWebDriver(), "Destinations", By.xpath(".//a[@href='mercuryunderconst.php' and text()='Destinations']"));
	public static Hyperlink vacations = new Hyperlink(BaseTest.getWebDriver(), "Vacations", By.xpath(".//a[@href='mercuryunderconst.php' and text()='Vacations']"));
	public static Hyperlink signOff = new Hyperlink(BaseTest.getWebDriver(), "Sign Off", By.cssSelector("a[href='mercurysignoff.php']"));
	public static Hyperlink itinerary = new Hyperlink(BaseTest.getWebDriver(), "Itinerary", By.cssSelector("a[href='mercuryitinerary.php']"));
	public static Hyperlink profile = new Hyperlink(BaseTest.getWebDriver(), "Profile", By.cssSelector("a[href='mercuryprofile.php']"));
	public static Alert alert = new Alert(BaseTest.getWebDriver());
	
	/**
	 * This method is used to <b>Sign-Off</b> from the web site.
	 */
	public static void signOff() {
		signOff.click();
	}

}
