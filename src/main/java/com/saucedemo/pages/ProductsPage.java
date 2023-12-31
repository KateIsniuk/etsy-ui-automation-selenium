package com.saucedemo.pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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
    private static final By SORT_ALPHABETICALLY_FROM_A_TO_Z_LOCATOR = By.cssSelector(".product_sort_container > option[value='az']");
    private static final By SORT_ALPHABETICALLY_FROM_Z_TO_Z_LOCATOR = By.cssSelector(".product_sort_container > option[value='za']");
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

    public void sortFromAToZ() {
        WebElement sortFromLowToHigh = driver.findElement(SORT_ALPHABETICALLY_FROM_A_TO_Z_LOCATOR);
        sortFromLowToHigh.click();
    }

    public void sortFromZToA() {
        WebElement sortFromHighToLow = driver.findElement(SORT_ALPHABETICALLY_FROM_Z_TO_Z_LOCATOR);
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

    public void validatePriceSorting(boolean asc) {
        List<WebElement> itemPricesList = driver.findElements(By.cssSelector(".inventory_item_price"));

        for (int i = 0; i < itemPricesList.size() - 1; i++) {

            WebElement current = itemPricesList.get(i);
            WebElement next = itemPricesList.get(i + 1);

            double currentItemPrice = extractItemPrice(current);
            double nextItemPrice = extractItemPrice(next);

            boolean result = asc ? currentItemPrice <= nextItemPrice
                                 : currentItemPrice >= nextItemPrice;

            Assert.isTrue(result, "The prices are not sorted correctly.");
        }
    }
    public void validateNameSorting(boolean asc) {
        List<WebElement> itemNameList = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(PRODUCT_ITEM_NAME_LOCATOR));

        for (int i = 0; i < itemNameList.size() - 1; i++) {

            WebElement current = itemNameList.get(i);
            WebElement next = itemNameList.get(i + 1);

            String currentItemName = extractItemName(current);
            String nextItemName = extractItemName(next);

            int comparisonResult = currentItemName.compareTo(nextItemName);

            boolean result = asc ? (comparisonResult <= 0) : (comparisonResult >= 0);

            Assert.isTrue(result, "The names are not sorted correctly.");
        }
    }

    public double extractItemPrice(WebElement itemPriceElement) { // Remove the "$" sign and convert the price to a double value
        String itemPriceText = itemPriceElement.getText();
        return Double.parseDouble(itemPriceText.substring(1));
    }

    public String extractItemName(WebElement itemNameElement) {
        return itemNameElement.getText();
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
