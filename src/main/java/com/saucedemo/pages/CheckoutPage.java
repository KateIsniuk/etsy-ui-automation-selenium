package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    private final WebDriver driver;

    private static final By CHECKOUT_BUTTON_LOCATOR = By.id("checkout");
    private static final By CONTINUE_BUTTON_LOCATOR = By.id("continue");
    private static final By FINISH_ORDER_BUTTON_LOCATOR = By.id("finish");
    private static final By CANCEL_ORDER_BUTTON_LOCATOR = By.id("cancel");
    private static final By FIRST_NAME_FIELD_LOCATOR = By.id("first-name");
    private static final By LAST_NAME_FIELD_LOCATOR = By.id("last-name");
    private static final By ZIPCODE_FIELD_LOCATOR = By.id("postal-code");
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
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
    public void finishOrder() {
        WebElement finishButton = driver.findElement(FINISH_ORDER_BUTTON_LOCATOR);
        finishButton.click();
    }
    public void cancelOrder() {
        WebElement cancelButton = driver.findElement(CANCEL_ORDER_BUTTON_LOCATOR);
        cancelButton.click();
    }

}
