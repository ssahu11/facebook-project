package com.testng;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AppTest {

	ChromeOptions options;
	WebDriver webdriver;
	File screenshotFile;
	String screenShotName = "test";

	DateFormat dateformate = new SimpleDateFormat("dd-mm-yy-hh-mm-ss");

	/**
	 * Setting the chrome driver.exe path
	 * 
	 * @param filepath
	 * @throws IOException
	 */
	@BeforeClass
	@Parameters({ "chromeExeFilePath" })
	public void setChromeExeFilePath(String filepath) throws IOException {
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", filepath);

	}

	/**
	 * open chrome browser and navigate to facebook.com
	 * 
	 * @throws IOException
	 */
	@Test(priority = 0)
	public void openBrowser() throws IOException {
		webdriver = new ChromeDriver(options);
		webdriver.manage().window().maximize();
		webdriver.get("http://facebook.com");

		webdriver = ScreenShotUtil.takeScreenShot(webdriver);
	}

	/**
	 * Make sure to update your facebook username and password in testng.xml file
	 * This method is used to login with username and password
	 * 
	 * @param user
	 * @param pass
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Parameters({ "username", "password" })
	@Test(priority = 1)
	public void login(String user, String pass) throws InterruptedException, IOException {
		WebElement username = webdriver.findElement(By.id("email"));
		username.clear();
		username.sendKeys(user);

		WebElement password = webdriver.findElement(By.id("pass"));
		password.clear();
		password.sendKeys(pass);
		password.sendKeys(Keys.ENTER);

		webdriver = ScreenShotUtil.takeScreenShot(webdriver);

	}

	@Test(priority = 2)
	public void testClickProfile() throws IOException {
		WebElement profile = webdriver.findElement(By.className("_1qv9"));
		profile.click();

		webdriver = ScreenShotUtil.takeScreenShot(webdriver);

	}

	@Test(priority = 3)
	public void testClickHome() throws IOException {
		WebElement profile = webdriver.findElement(By.id("u_0_c"));
		profile.click();

		webdriver = ScreenShotUtil.takeScreenShot(webdriver);

	}

	@Test(priority = 4)
	public void testClickMessages() throws IOException {
		WebElement profile = webdriver.findElement(By.name("mercurymessages"));
		profile.click();

		webdriver = ScreenShotUtil.takeScreenShot(webdriver);
	}

	@Test(priority = 5)
	public void testClickMessagesCont() throws IOException {
		WebElement profile = webdriver.findElement(By.className("_4djt"));
		profile.click();

		webdriver = ScreenShotUtil.takeScreenShot(webdriver);

	}

	/**
	 * Logout
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test(priority = 6)
	public void logout() throws IOException {
		webdriver.switchTo().defaultContent();
		WebElement dropdown = webdriver.findElement(By.id("userNavigationLabel"));
		dropdown.click();
		webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// webdriver.wait(5000);
		WebElement signOut = webdriver.findElement(By.partialLinkText("Log Out"));
		signOut.click();

		webdriver = ScreenShotUtil.takeScreenShot(webdriver);
	}

	/**
	 * Closing browser
	 * 
	 * @throws IOException
	 */

	@Test(priority = 7)
	public void closeBrowser() throws IOException {
		webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webdriver.close();
	}

}
