package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CheckoutPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final long DEFAULT_WAIT_PERIOD = 10;
    private static final By CHECKOUT_BUTTON_LOCATOR = By.id("checkout");
    private static final By CONTINUE_BUTTON_LOCATOR = By.id("continue");
    private static final By FINISH_ORDER_BUTTON_LOCATOR = By.id("finish");
    private static final By CANCEL_ORDER_BUTTON_LOCATOR = By.id("cancel");
    private static final By FIRST_NAME_FIELD_LOCATOR = By.id("first-name");
    private static final By LAST_NAME_FIELD_LOCATOR = By.id("last-name");
    private static final By ZIPCODE_FIELD_LOCATOR = By.id("postal-code");
    private static final By PRODUCT_ITEM_NAME_LOCATOR = By.cssSelector(".inventory_item_name");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_PERIOD));
    }

    public void clickCheckoutButton() {
        WebElement checkout = driver.findElement(CHECKOUT_BUTTON_LOCATOR);
        checkout.click();
    }

    public void fillInForm(String firstName, String lastName, String zipCode) {
        WebElement firstNameField = driver.findElement(FIRST_NAME_FIELD_LOCATOR);
        firstNameField.sendKeys(firstName);

        WebElement lastNameField = driver.findElement(LAST_NAME_FIELD_LOCATOR);
        lastNameField.sendKeys(lastName);

        WebElement zipCodeField = driver.findElement(ZIPCODE_FIELD_LOCATOR);
        zipCodeField.sendKeys(zipCode);
    }

    public void clickContinueButton() {
        WebElement continueButton = driver.findElement(CONTINUE_BUTTON_LOCATOR);
        continueButton.click();
    }

    public List<String> validateItemsList() {
        List<WebElement> validatedItemElements = wait.until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(PRODUCT_ITEM_NAME_LOCATOR));

        List<String> validatedItemNames = new ArrayList<>();

        for (WebElement itemElement : validatedItemElements){
            validatedItemNames.add(itemElement.getText());
        }
        return validatedItemNames;
    }

    public void finishOrder() {
        WebElement finishButton = driver.findElement(FINISH_ORDER_BUTTON_LOCATOR);
        finishButton.click();
    }

    public void cancelOrder() {
        WebElement cancelButton = driver.findElement(CANCEL_ORDER_BUTTON_LOCATOR);
        cancelButton.click();
    }

}
