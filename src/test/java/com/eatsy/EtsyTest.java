package com.eatsy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class EtsyTest extends BaseEtsy{
    @Test(priority = 1)
    public void leatherBags(){
        WebElement popUp =
                driver.findElement(By.xpath("//button[@class = 'wt-btn wt-btn--filled wt-mb-xs-0']"));
        popUp.click();

        //Find search field
        WebElement searchField = driver.findElement(By.xpath("//input[@name='search_query']"));
        searchField.sendKeys("leather Bags");
        searchField.sendKeys(Keys.ENTER);

    }
    @Test(priority = 2)
    public void freeShipping(){
        WebElement allFilters =
                driver.findElement(By.xpath("//span[@class='wt-hide-xs wt-show-md filter-expander']"));
        allFilters.click();

        WebElement freeShippingCheckBox =
                driver.findElement(By.xpath("//form[@id='search-filter-form']//div[contains(@class, 'main-filters')]//div[2]//div[contains(@class, 'wt-checkbox--small')]//label[contains(@class, 'wt-checkbox__label wt-display-inline')]"));
        freeShippingCheckBox.click();

        WebElement applyButton = driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--primary wt-width-full wt-mt-xs-3 wt-mb-xs-3 wt-mr-xs-3']"));
        applyButton.click();
    }
}
