package com.newtours.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This Class is used to handle <b>Buttons</b>.
 * 
 * @author Sujay
 * @version 1.0.1
 * @since 02/14/2018
 */

import com.newtours.utilities.Actions;

/**
 * This Class is used to handle <b>Button</b>.
 * 
 * @author Sujay Sawant
 * @version 1.0.3
 * @since 12/14/2019
 */
public class Button extends Actions {

	/**
	 * This Constructor is used to create an object to access a <b>Button</b>.
	 * 
	 * @param driver : WebDriver object
	 * @param description : Description of the Button
	 * @param locator : Xpath of the Button
	 */
	public Button(WebDriver driver, String description, By locator) {
		super(driver, "[" + description + "] button", locator);
	}

}
