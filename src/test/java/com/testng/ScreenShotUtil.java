package com.testng;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author vishal
 *
 */
public class ScreenShotUtil {

	static File screenshotFile;
	static String screenShotName = "test";

	/**
	 * For taking screenshot this method is used by AppTest class
	 * @param webdriver
	 * @return
	 * @throws IOException
	 */
	public static WebDriver takeScreenShot(WebDriver webdriver) throws IOException {

		Date date = new Date();
		DateFormat dateformate = new SimpleDateFormat("dd-mm-yy-hh-mm-ss");
		String currentdate = dateformate.format(date);
		screenshotFile = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);
		String imageName = screenShotName + currentdate;
		String location = System.getProperty("user.dir") + "\\test-output\\screenshot\\" + imageName + ".png";
		FileUtils.copyFile(screenshotFile, new File(location));

		return webdriver;

	}

}
