package com.newtours.pages;

import org.openqa.selenium.By;

import com.newtours.base.BaseTest;
import com.newtours.elements.Banner;
import com.newtours.elements.Button;
import com.newtours.elements.Text;

/**
 * This is the Page Class for the Second Purchase page.<br>
 * <b>mercurypurchase2.php</b>
 * 
 * @author Sujay Sawant
 * @version 1.0.3
 * @since 12/14/2019
 */
public class MercuryPurchase2Page extends MainWebsitePage {

	public static Banner flightConfirmationBanner = new Banner(BaseTest.getWebDriver(), "Flight Confirmation", By.cssSelector("img[src='/images/masts/mast_confirmation.gif']"));
	public static Text totalPrice = new Text(BaseTest.getWebDriver(), "Total Price", By.xpath(".//font[contains(text(),'Price')]//following::font[4]"));
	public static Button backToFlights = new Button(BaseTest.getWebDriver(), "Back To Flights", By.cssSelector("a[href='mercuryreservation.php'] > img"));
	public static Button backToHome = new Button(BaseTest.getWebDriver(), "Back To Home", By.cssSelector("a[href='mercurywelcome.php'] > img"));
	public static Button logOut = new Button(BaseTest.getWebDriver(), "Log Out", By.cssSelector("a[href='mercurysignoff.php'] > img"));

}
