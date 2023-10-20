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

    public void selectProductItems(String item01, String item02) {
        WebElement item = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(), 'Add to cart')]")));
        item.click();
    }

    public void goToShoppingCart() {
        WebElement card = driver.findElement(By.cssSelector(".shopping_cart_link"));
        card.click();
    }
}
