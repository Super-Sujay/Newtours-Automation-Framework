package com.newtours.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.newtours.utilities.Actions;

/**
 * This Class is used to handle <b>Text Box</b>.
 * 
 * @author Sujay Sawant
 * @version 1.0.3
 * @since 12/14/2019
 */
public class Textbox extends Actions {

	/**
	 * This Constructor is used to create an object to access a <b>Textbox</b>.
	 * 
	 * @param driver : WebDriver object
	 * @param description : Description of the Textbox
	 * @param locator : Xpath of the Textbox
	 */
	public Textbox(WebDriver driver, String description, By locator) {
		super(driver, "[" + description + "] text box", locator);
	}

}
