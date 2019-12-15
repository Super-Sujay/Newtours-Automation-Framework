package com.newtours.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.newtours.utilities.Actions;

/**
 * This Class is used to handle <b>Drop Down</b>.
 * 
 * @author Sujay Sawant
 * @version 1.0.3
 * @since 12/14/2019
 */
public class DropDown extends Actions {

	/**
	 * This Constructor is used to create an object to access a <b>DropDown</b>.
	 * 
	 * @param driver : WebDriver object
	 * @param description : Description of the DropDown
	 * @param locator : Xpath of the DropDown
	 */
	public DropDown(WebDriver driver, String description, By locator) {
		super(driver, "[" + description + "] drop down", locator);
	}

}
