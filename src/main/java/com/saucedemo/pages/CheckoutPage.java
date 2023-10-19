package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private final WebDriver driver;

    public void clickCheckoutButton() {
        WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.click();
    }

    public void fillInForm(String firstName, String lastName, String zipCode) {
        WebElement firstNameField = driver.findElement(By.id("first-name"));
        firstNameField.sendKeys(firstName);

        WebElement lastNameField = driver.findElement(By.id("last-name"));
        lastNameField.sendKeys(lastName);

        WebElement zipCodeField = driver.findElement(By.id("postal-code"));
        zipCodeField.sendKeys(zipCode);
    }

    public void clickContinueButton() {
        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();
    }
    public void finishOrder() {
        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();
    }
    public void cancelOrder() {
        WebElement cancelButton = driver.findElement(By.id("cancel"));
        cancelButton.click();
    }

}
