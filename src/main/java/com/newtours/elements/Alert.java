package com.newtours.elements;

import org.openqa.selenium.WebDriver;

import com.newtours.utilities.Actions;

/**
 * This Class is used to handle <b>Alerts</b>.
 * 
 * @author Sujay Sawant
 * @version 1.0.3
 * @since 12/14/2019
 */
public class Alert extends Actions {

	/**
	 * This Constructor is used to create an object to access an <b>Alert</b>.
	 * 
	 * @param driver : WebDriver object
	 */
	public Alert(WebDriver driver) {
		super(driver);
	}

}
