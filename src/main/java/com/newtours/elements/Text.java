package com.newtours.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.newtours.utilities.Actions;

/**
 * This Class is used to handle <b>Text</b> in a Web Page.
 * 
 * @author Sujay Sawant
 * @version 1.0.3
 * @since 12/14/2019
 */
public class Text extends Actions {

	/**
	 * This Constructor is used to create an object to access a <b>Text</b>.
	 * 
	 * @param driver : WebDriver object
	 * @param description : Description of the Text
	 * @param locator : Xpath of the Text
	 */
	public Text(WebDriver driver, String description, By locator) {
		super(driver, description, locator);
	}

}
