package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    private final WebDriverWait wait;
    private final WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectProductItems() {
        WebElement item1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button#add-to-cart-sauce-labs-bike-light")));
        item1.click();

        WebElement item2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-to-cart-sauce-labs-backpack")));
        item2.click();
    }

    public void goToShoppingCart() {
        WebElement card = driver.findElement(By.cssSelector(".shopping_cart_link"));
        card.click();
    }
}
