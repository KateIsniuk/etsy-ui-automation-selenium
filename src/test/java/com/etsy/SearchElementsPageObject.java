package com.etsy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchElementsPageObject {

//    private static final By searchFieldLocator = By.xpath("//input[@name='search_query']");

    public static WebElement searchField(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@name='search_query']"));
    }


}
