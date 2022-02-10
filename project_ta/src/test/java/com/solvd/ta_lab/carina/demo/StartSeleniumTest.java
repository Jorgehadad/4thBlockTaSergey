package com.solvd.ta_lab.carina.demo;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.webdriver.core.capability.impl.desktop.ChromeCapabilities;


public class StartSeleniumTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testStartSel() throws InterruptedException, MalformedURLException{
        //check just chrome
        //ChromeDriver driver = new ChromeDriver();
        DesiredCapabilities capabilities = new ChromeCapabilities().getCapability("testStartSel");
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.125:4444/wd/hub"), capabilities);
        driver.get("http://www.google.com");
        driver.getTitle();
        driver.getCurrentUrl();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Carina");
        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.click();
        driver.findElement(By.name("q")).getAttribute("value"); // => "Selenium"
        driver.navigate().to("https://www.selenium.dev/documentation/webdriver/browser/navigation/");
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(5000);
        driver.quit();
    }

    //testCarinaSel
    @Test
    public void testCarinaSel() throws InterruptedException, MalformedURLException{
        getDriver().get("http://www.google.com");   
        getDriver().getTitle();
        getDriver().getCurrentUrl();
        getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    


    @Test
    public void testLogin() throws MalformedURLException {
        DesiredCapabilities capabilities = new ChromeCapabilities().getCapability("testStartSel");
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.125:4444/wd/hub"), capabilities);
        driver.get("http://facebook.com");
        // fill login data on sign-in page
        driver.findElement(By.name("user_name")).sendKeys("userName");
        driver.findElement(By.name("password")).sendKeys("my supersecret password");
        driver.findElement(By.name("sign-in")).click();
    
        // verify h1 tag is "Hello userName" after login
        driver.findElement(By.tagName("h1")).isDisplayed();
        //verification
        driver.findElement(By.tagName("h1")).getText().equals("Hello userName");

        //Store the web element
        WebElement iframe = driver.findElement(By.cssSelector("#modal>iframe"));

        //Switch to the frame
        driver.switchTo().frame(iframe);

        //Now we can click the button
        driver.findElement(By.tagName("button")).click();

      }
    
}
