package com.newtours.pages;

import org.openqa.selenium.By;

import com.newtours.base.BaseTest;
import com.newtours.elements.Banner;
import com.newtours.elements.Button;
import com.newtours.elements.RadioButton;

/**
 * This is the Page Class for the Second Reservation page.<br>
 * <b>mercuryreservation2.php</b>
 * 
 * @author Sujay Sawant
 * @version 1.0.3
 * @since 12/14/2019
 */
public class MercuryReservation2Page extends MainWebsitePage {

	public static Banner selectFlightBanner = new Banner(BaseTest.getWebDriver(), "Select Flight", By.cssSelector("img[src='/images/masts/mast_selectflight.gif']"));
	public static RadioButton blueSkiesAirlines360 = new RadioButton(BaseTest.getWebDriver(), "Blue Skies Airlines 360", By.cssSelector("input[value^='Blue Skies Airlines$360']"));
	public static RadioButton blueSkiesAirlines361 = new RadioButton(BaseTest.getWebDriver(), "Blue Skies Airlines 361", By.cssSelector("input[value^='Blue Skies Airlines$361']"));
	public static RadioButton pangeaAirlines362 = new RadioButton(BaseTest.getWebDriver(), "Pangea Airlines 362", By.cssSelector("input[value^='Pangea Airlines$362']"));
	public static RadioButton unifiedAirlines363 = new RadioButton(BaseTest.getWebDriver(), "Unified Airlines 363", By.cssSelector("input[value^='Unified Airlines$363']"));
	public static RadioButton blueSkiesAirlines630 = new RadioButton(BaseTest.getWebDriver(), "Blue Skies Airlines 630", By.cssSelector("input[value^='Blue Skies Airlines$630']"));
	public static RadioButton blueSkiesAirlines631 = new RadioButton(BaseTest.getWebDriver(), "Blue Skies Airlines 360", By.cssSelector("input[value^='Blue Skies Airlines$631']"));
	public static RadioButton pangeaAirlines632 = new RadioButton(BaseTest.getWebDriver(), "Pangea Airlines 632", By.cssSelector("input[value^='Pangea Airlines$632']"));
	public static RadioButton unifiedAirlines633 = new RadioButton(BaseTest.getWebDriver(), "Unified Airlines 633", By.cssSelector("input[value^='Unified Airlines$633']"));
	public static Button continueNext = new Button(BaseTest.getWebDriver(), "Continue", By.name("reserveFlights"));

	/**
	 * This method is used to <b>Select Flights</b>.
	 * 
	 * @param departureFlight : Radio Button of Departure Flight
	 * @param arrivalFlight : Radio Button of Arrival Flight
	 */
	public static void selectFlights(RadioButton departureFlight, RadioButton arrivalFlight) {
		departureFlight.click();
		arrivalFlight.click();
		continueNext.click();
	}

}
