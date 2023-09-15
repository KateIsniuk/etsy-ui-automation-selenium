package com.eatsy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageHelper {

    public static WebElement popUp(WebDriver driver) {
        return driver.findElement(By.xpath("//button[@class = 'wt-btn wt-btn--filled wt-mb-xs-0']"));
    }

    public static void clickPopUp(WebElement element) {
        element.click();
    }

    public static WebElement searchField(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@name='search_query']"));
    }

    public static void enterToSearchField(WebElement search, String searchQuery) {
        search.sendKeys(searchQuery);
    }

    public static void hitEnter(WebElement hit) {
        hit.sendKeys(Keys.ENTER);
    }

    public static WebElement allFilters(WebDriver driver) {
        return driver.findElement(By.xpath("//span[@class='wt-hide-xs wt-show-md filter-expander']"));
    }

    public static void checkFilter(WebElement filterElement) {
        filterElement.click();
    }

    public static WebElement freeShippingCheckBox(WebDriver driver) {
        return driver.findElement(By.xpath("//form[@id='search-filter-form']//div[contains(@class,'main-filters')]//div[2]//div[contains(@class, 'wt-checkbox--small')]//label[contains(@class, 'wt-checkbox__label wt-display-inline')]"));
    }

    public static void clickFreeShipping(WebElement freeShipping) {
        freeShipping.click();
    }

    public static WebElement applyButton(WebDriver driver) {
        return driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--primary wt-width-full wt-mt-xs-3 wt-mb-xs-3 wt-mr-xs-3']"));
    }

    public static void clickApplyButton (WebElement clickApply) {
        clickApply.click();
    }
}
