package com.newtours.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.newtours.base.BaseTest;

/**
 * This Class is used to take <b>Screenshot</b> at the current page.
 * 
 * @author Sujay Sawant
 * @version 1.0.3
 * @since 12/14/2019
 */
public class ScreenShot {

	/**
	 * This method is used to take <b>Screenshot</b> of the current page.
	 * 
	 * @param driver : WebDriver object
	 */
	public static String takeScreenShot() {

		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("yyyy.MM.dd.HH.mm.ss");
		String fileName = "ScreenShot_" + datePattern.format(dateTime) + ".jpg";
		TakesScreenshot scr = (TakesScreenshot) BaseTest.getWebDriver();
		Path screenshot = Paths.get(Constants.screenShotDestination);
		Path source = scr.getScreenshotAs(OutputType.FILE).toPath();
		Path target = Paths.get(Constants.screenShotDestination + fileName);
		try {
			System.out.println("Screen shot at " + Constants.screenShotDestination);
			Reporter.log("Screen shot at " + Constants.screenShotDestination + "<br>");
			if (Files.notExists(screenshot))
				Files.createDirectory(screenshot);
			Files.copy(source, target);
		} catch (IOException e) {
			System.out.println("Unable to take screen shot");
			Reporter.log("Unable to take screen shot<br>");
			e.printStackTrace();
		}
		return Constants.screenShotDestination + fileName;

	}

	/**
	 * This method is used to take <b>Screenshot</b> of the current page.
	 * 
	 * @param driver : WebDriver object
	 * @param name : Screenshot file name
	 */
	public static String takeScreenShot(String name) {

		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("yyyy.MM.dd.HH.mm.ss");
		String fileName = name + "_" + datePattern.format(dateTime) + ".jpg";
		TakesScreenshot scr = (TakesScreenshot) BaseTest.getWebDriver();
		Path screenshot = Paths.get(Constants.screenShotDestination);
		Path source = scr.getScreenshotAs(OutputType.FILE).toPath();
		Path target = Paths.get(Constants.screenShotDestination + fileName);
		try {
			System.out.println("Screen shot at " + Constants.screenShotDestination);
			Reporter.log("Screen shot at " + Constants.screenShotDestination + "<br>");
			if (Files.notExists(screenshot))
				Files.createDirectory(screenshot);
			Files.copy(source, target);
		} catch (IOException e) {
			System.out.println("Unable to take screen shot");
			Reporter.log("Unable to take screen shot<br>");
			e.printStackTrace();
		}
		return Constants.screenShotDestination + fileName;

	}

}