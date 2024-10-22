package com.perabank.perasoft.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BasePage extends Page {


    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTittle() {
        return driver.getTitle();
    }

    @Override
    public WebElement getWebElement(By locator) {
        WebElement element=null;
        try {
            element=driver.findElement(locator);

        }catch (Exception e){
            System.out.println(locator.toString()+ "selector or Locator");
        }
        return element;

    }

    @Override
    public List<WebElement> getWebElements(By locator) {

        List<WebElement> elements=null;
        try {
            elements=driver.findElements(locator);

        }catch (Exception e){
            System.out.println(locator.toString()+ "selector or Locator not found");
        }
        return elements;

    }

    @Override
    public void waitForElement(By locator) {
        try{

        }catch (Exception e) {
            System.out.println(locator.toString() + "selector or Locator not found");

            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }

    }
}
