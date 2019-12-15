package com.newtours.pages;

import org.openqa.selenium.By;

import com.newtours.base.BaseTest;
import com.newtours.elements.Banner;
import com.newtours.elements.Hyperlink;
import com.newtours.elements.Textbox;
import com.newtours.utilities.Constants;

/**
 * This is the Page Class for the Sign On page.<br>
 * <b>mercurysignon.php</b>
 * 
 * @author Sujay Sawant
 * @version 1.0.3
 * @since 12/14/2019
 */
public class MercurySignOnPage extends MainWebsitePage {

	public static Banner signOnBanner = new Banner(BaseTest.getWebDriver(), "Sign-On", By.cssSelector("img[src='/images/nav/logo.gif']"));
	public static Textbox userName = new Textbox(BaseTest.getWebDriver(), "User Name", By.name("userName"));
	public static Textbox password = new Textbox(BaseTest.getWebDriver(), "Password", By.name("password"));
	public static Hyperlink submit = new Hyperlink(BaseTest.getWebDriver(), "Submit", By.name("login"));

	/**
	 * This method is used to <b>Log-In</b> to the web site.
	 */
	public static void login() {
		MainWebsitePage.signOn.click();
		userName.sendKeys(Constants.userName);
		password.sendKeys(Constants.password);
		submit.click();
	}

	/**
	 * This method is used to <b>Log-In</b> to the web site.
	 * 
	 * @param Username : User to log in
	 * @param Password : Password of the User
	 */
	public static void login(String Username, String Password) {
		MainWebsitePage.signOn.click();
		userName.sendKeys(Username);
		password.sendKeys(Password);
		submit.click();
	}

}
