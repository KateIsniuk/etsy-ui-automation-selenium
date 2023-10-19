package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutElements {

    public static void checkoutButton(WebDriver driver) {
        WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.click();
    }

    public static void fillInForm(WebDriver driver) {
        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.sendKeys("John");

        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Smith");

        WebElement zipCode = driver.findElement(By.id("postal-code"));
        zipCode.sendKeys("01222");
    }

    public static void continueButton(WebDriver driver) {
        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();
    }
    public static void finishOrder(WebDriver driver) {
        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();
    }
    public static void cancelOrder(WebDriver driver) {
        WebElement cancelButton = driver.findElement(By.id("cancel"));
        cancelButton.click();
    }

}
