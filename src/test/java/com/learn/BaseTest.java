package com.learn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseTest {
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-notifications");
        driver.set(new ChromeDriver(options));
        driver.get().get("https://www.google.com");
    }

    @Test 
    public void loadtest(){
        Homepage page = new Homepage(driver.get());
        page.isPageLoaded();
        page.exploreAbout();
    }

    @AfterMethod 
    public void tearDown(){
        WebDriver currentDriver = driver.get(); 
        currentDriver.quit();
    }
    
}
