package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AppTest {

    private ChromeOptions options;
    private WebDriver webdriver;

    /**
     * Setting the chrome driver.exe path
     *
     * @param filepath chromedriver.exe path
     */
    @BeforeClass
    @Parameters({"chromeExeFilePath"})
    public void setChromeExeFilePath(String filepath) {
        options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", filepath);

    }

    /**
     * open chrome browser and navigate to facebook.com
     */
    @Test
    public void openBrowser() throws IOException {
        webdriver = new ChromeDriver(options);
        webdriver.manage().window().maximize();
        webdriver.get("https://www.facebook.com/");

        // to take screenshot
        ScreenShotUtil.takeScreenShot(webdriver);
    }

    /**
     * Make sure to update your facebook username and password in testng.xml file
     * This method is used to login with username and password
     *
     * @param user facebook username
     * @param pass facebook password
     */
    
    @Parameters({"username", "password"})
    @Test(priority = 1)
    public void login(String user, String pass) throws IOException {
        WebElement username = webdriver.findElement(By.id("email"));
        username.clear();
        username.sendKeys(user);

        WebElement password = webdriver.findElement(By.id("pass"));
        password.clear();
        password.sendKeys(pass);
        // to take screenshot
        ScreenShotUtil.takeScreenShot(webdriver);
        password.sendKeys(Keys.ENTER);
    }
    
    /**
     * click on facebook profile
     */
    
    @Test(priority = 2)
    public void testClickProfile() throws IOException {
        WebElement profile = webdriver.findElement(By.className("x3ajldb"));
        profile.click();

        // to take screenshot
        ScreenShotUtil.takeScreenShot(webdriver);

    }

    /**
     * click on facebook home
     */
 
    @Test(priority = 3)
    public void testClickHome() throws IOException {
        WebElement profile = webdriver.findElement(By.id("x1i10hfl xjbqb8w x6umtig x1b1mbwd xaqea5y xav7gou x9f619 x1ypdohk xe8uvvx xdj266r x11i5rnm xat24cr x1mh8g0r xexx8yu x4uap5 x18d9i69 xkhd6sd x16tdsg8 x1hl2dhg xggy1nq x1o1ewxj x3x9cwd x1e5q0jg x13rtm0m x87ps6o x1lku1pv x1a2a7pz x6s0dn4 x78zum5 xdt5ytf x5yr21d xl56j7k x1n2onr6 xh8yej3"));
        profile.click();

        // to take screenshot
        ScreenShotUtil.takeScreenShot(webdriver);

    }

    /**
     * click on message option
     */

    @Test(priority = 4)
    public void testClickMessages() throws IOException {
        WebElement profile = webdriver.findElement(By.name("mercurymessages"));
        profile.click();

        // to take screenshot
        ScreenShotUtil.takeScreenShot(webdriver);
    }

    /**
     * click on show all messages
     */

    @Test(priority = 5)
    public void testClickMessagesCont() throws IOException {
        WebElement profile = webdriver.findElement(By.className("_4djt"));
        profile.click();

        // to take screenshot
        ScreenShotUtil.takeScreenShot(webdriver);

    }

    /**
     * Logout
     */
    
    @Test(priority = 6)
    public void logout() throws IOException {
        webdriver.switchTo().defaultContent();
        WebElement dropdown = webdriver.findElement(By.id("userNavigationLabel"));
        dropdown.click();
        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement signOut = webdriver.findElement(By.partialLinkText("Log Out"));

        // to take screenshot
        ScreenShotUtil.takeScreenShot(webdriver);

        signOut.click();

    }

    /**
     * Closing browser
     */
    @Test(priority = 7)
    public void closeBrowser() {
        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webdriver.close();
    }
  

}
