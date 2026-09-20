package com.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage extends BasePage{

    private final By ABOUT = By.xpath("//a[contains(text(),\"About\")]");

    public Homepage(WebDriver driver){
        super(driver);
    }

    @Override 
    public Boolean isPageLoaded(){
        return driver.getTitle().contains("Google"); 
    }

    public void clickAbout(){
        click(ABOUT);
    }
}
