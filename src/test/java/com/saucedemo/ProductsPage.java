package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class ProductsPage {

    public WebDriverWait wait;

    public ProductsPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void clickProduct2() {
        WebElement product2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button#add-to-cart-sauce-labs-bike-light")));
        product2.click();
    }

    public void clickProduct1() {
        WebElement product1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-to-cart-sauce-labs-backpack")));
        product1.click();
        
    }
}
