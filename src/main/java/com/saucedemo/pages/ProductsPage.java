package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


import java.time.Duration;
import java.util.List;

public class ProductsPage {

    private final WebDriverWait wait;
    private final WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(ProductsPage.class);


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



//one of the variants
    
    public List<WebElement> selectProductItems(String inventoryName) {
        List<WebElement> elements = driver.findElements(
                By.xpath("//div[@class='" + inventoryName + "']"));
        if (elements.size() >= 3) {
            WebElement thirdItem = elements.get(2); // Index 2 represents the third item in a zero-based index
           // logger.info("The "+ thirdItem + " product");
            WebElement removeButton = thirdItem.findElement(By.xpath("//button[@data-test='remove-sauce-labs-backpack']"));
            removeButton.click();
        } else {
            System.out.println("There are fewer than three items to remove.");
        }
        return elements;
    }


//    public String getAndRemoveThirdProductName() {
//        List<WebElement> itemNames = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
//                By.cssSelector(".inventory_item_name")));
//
//        // Check if there are at least three items
//        if (itemNames.size() >= 3) {
//            String itemName = itemNames.get(2).getText();
//            System.out.println("Item Name: " + itemName);
//         //   WebElement removeButton = driver.findElement(
//        //            By.xpath("//div[@class='inventory_item_name'][text()='" + itemName + "']/following::button[starts-with(@data-test,'remove-')]"));
//            WebElement removeButton = wait.until(ExpectedConditions.presenceOfElementLocated(
//                    By.xpath("//div[normalize-space(@class)='inventory_item_name'][normalize-space(text())='"
//                            + itemName + "']/following::button[starts-with(@data-test,'remove-')]")));
//            removeButton.click();
//
//            return itemName;
//        } else {
//            System.out.println("There are less than three items to remove.");
//            return null;
//        }
//    }

    public void addToCartButtons() {
        List<WebElement> addToCartButtons = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(PRODUCT_ITEMS_LOCATOR_CART));

        addToCartButtons.forEach(WebElement::click);
    }

    public void goToShoppingCart() {
        WebElement card = driver.findElement(SHOPPING_CART_LOCATOR);
        card.click();
    }
}
