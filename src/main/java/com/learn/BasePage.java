package com.learn;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage{

    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebDriverWait getWait(){
        if(wait==null)
        wait = new WebDriverWait(driver, Duration.ofSeconds(35));
        return wait;
    }

    public void click(By locator){
    try {
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    } catch (ElementClickInterceptedException e) {
        // Element is blocked by overlay, use JS click
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    } catch (Exception e) {
        e.printStackTrace();
        throw e;  // Re-throw so test actually fails
    }
}

    public void sendText(By locator, String text){
        WebElement element = getWait().until(ExpectedConditions.elementToBeClickable(locator));
        element.clear();
        element.sendKeys(text);
    }

    public abstract Boolean isPageLoaded();
}