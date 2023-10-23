package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsPage {

    private final WebDriverWait wait;
    private final WebDriver driver;
    
    private static final long DEFAULT_WAIT_PERIOD = 10;
    private static final By PRODUCT_ITEMS_LOCATOR_CART = By.xpath("//button[contains(text(), 'Add to cart')]");
    private static final By SHOPPING_CART_LOCATOR = By.cssSelector(".shopping_cart_link");
    private static final By ADD_TO_CART_BUTTON_INSIDE_PRODUCT_PAGE = By.cssSelector("add-to-cart-sauce-labs-bolt-t-shirt");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_PERIOD));
    }

    public void selectProductItems(List<String> itemNames) {
        for (String itemName : itemNames) {
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//div[@class='inventory_item_name ' and text()='" + itemName + "']")));
        }
    }
    public void addToCartButton() {
        WebElement addToCartButton = wait.until(ExpectedConditions.presenceOfElementLocated(PRODUCT_ITEMS_LOCATOR_CART));
        addToCartButton.click();
    }

    public void goToShoppingCart() {
        WebElement card = driver.findElement(SHOPPING_CART_LOCATOR);
        card.click();
    }
}
