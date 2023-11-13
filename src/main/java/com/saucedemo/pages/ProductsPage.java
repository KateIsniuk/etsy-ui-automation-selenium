package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductsPage {

    private final WebDriverWait wait;
    private final WebDriver driver;

    private static final long DEFAULT_WAIT_PERIOD = 10;
    private static final By PRODUCT_ITEMS_CART_LOCATOR = By.xpath("//button[contains(text(), 'Add to cart')]");
    private static final By SHOPPING_CART_LOCATOR = By.cssSelector(".shopping_cart_link");
    private static final By ADD_TO_CART_BUTTON_INSIDE_PRODUCT_PAGE = By.cssSelector("add-to-cart-sauce-labs-bolt-t-shirt");
    private static final By PRODUCT_ITEM_NAME_LOCATOR = By.cssSelector(".inventory_item_name");
    private static final By DROPDOWN_LOCATOR = By.cssSelector(".product_sort_container");
    private static final By SORT_PRICE_FROM_LOW_TO_HIGH_LOCATOR = By.cssSelector(".product_sort_container > option[value='lohi']");
    private static final By SORT_PRICE_FROM_HIGH_TO_LOW_LOCATOR = By.cssSelector(".product_sort_container > option[value='hilo']");
    private static final String ITEM_BY_NAME_SELECTOR_TO_REMOVE = "//div[normalize-space(@class)='inventory_item_name'][normalize-space(text())='%s']/following::button[starts-with(@data-test,'remove-')]";
    private static final String ITEM_NAME_LIST = "//div[@class='inventory_item_name ' and text()='%s']";
    private static final String ITEM_PRICE_LIST = "//div[@class='inventory_item_price' and text()='%s']";


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_PERIOD));
    }

    public void waitForItemNamesToBeVisible(List<String> itemNames) {
        for (String itemName : itemNames) {
            String itemListSelector = String.format(ITEM_NAME_LIST, itemName);
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath(itemListSelector)));
        }
    }

    public void sortingDropdown() {
        WebElement sortDropdown = driver.findElement(DROPDOWN_LOCATOR);
        sortDropdown.click();
    }

    public void sortByPriceLowToHigh() {
        WebElement sortFromLowToHigh = driver.findElement(SORT_PRICE_FROM_LOW_TO_HIGH_LOCATOR);
        sortFromLowToHigh.click();
    }

    public void sortByPriceHighToLow() {
        WebElement sortFromHighToLow = driver.findElement(SORT_PRICE_FROM_HIGH_TO_LOW_LOCATOR);
        sortFromHighToLow.click();
    }

    public String getProductTitleWithIndex(int index) {
        List<WebElement> itemNames = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(PRODUCT_ITEM_NAME_LOCATOR));

        // Check if there are at least three items
        if (itemNames.size() >= index - 1) {
            String itemName = itemNames.get(index - 1).getText();
            System.out.println("Item Name: " + itemName);
            return itemName;
        } else {
            System.out.println("Can not remove item with " + index);
        }
        return null;
    }

    public List<Double> getItemPricesList() {
        List<WebElement> itemPricesList = driver.findElements(By.cssSelector(".inventory_item_price"));
        List<Double> itemPrices = new ArrayList<>();

        for (WebElement itemPriceElement : itemPricesList) {
            String itemPriceText = itemPriceElement.getText();

            // Remove the "$" sign and convert the price to a double value
            double itemPrice = Double.parseDouble(itemPriceText.substring(1));
           // System.out.println(itemPrice);
            itemPrices.add(itemPrice);
        }
        return itemPrices;
    }

    public void removeItemFormTheCart(String itemName) {
        String concreteItemSelector = String.format(ITEM_BY_NAME_SELECTOR_TO_REMOVE, itemName);
        WebElement removeButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(concreteItemSelector)));
        removeButton.click();
    }

    public void addToCartButtons() {
        List<WebElement> addToCartButtons = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                PRODUCT_ITEMS_CART_LOCATOR));
        for (WebElement button : addToCartButtons) {
            button.click();
        }
    }

    public void goToShoppingCart() {
        WebElement card = driver.findElement(SHOPPING_CART_LOCATOR);
        card.click();
    }
}
