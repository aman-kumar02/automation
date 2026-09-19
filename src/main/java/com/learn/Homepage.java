package com.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage extends BasePage{

    private final By PRODUCTS = By.xpath("//button[contains(text(),\"Products\")]");

    public Homepage(WebDriver driver){
        super(driver);
    }

    @Override 
    public Boolean isPageLoaded(){
        return driver.getTitle().contains("UKG"); 
    }

    public void exploreProducts(){
        click(PRODUCTS);
    }
}
