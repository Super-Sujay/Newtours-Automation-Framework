package com.newtours.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.newtours.utilities.Actions;

/**
 * This Class is used to handle <b>Hyperlink</b>.
 * 
 * @author Sujay Sawant
 * @version 1.0.3
 * @since 12/14/2019
 */
public class Hyperlink extends Actions {

	/**
	 * This Constructor is used to create an object to access a <b>Hyperlink</b>.
	 * 
	 * @param driver : WebDriver object
	 * @param description : Description of the Hyperlink
	 * @param locator : Xpath of the Hyperlink
	 */
	public Hyperlink(WebDriver driver, String description, By locator) {
		super(driver, "[" + description + "] link", locator);
	}

}
