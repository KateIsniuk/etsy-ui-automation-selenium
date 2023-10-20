package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderCompletionPage {
    private final WebDriver driver;
    
    private static final By ORDER_MESSAGE_LOCATOR = (By.xpath("//h2[contains(text(), 'Thank you for your order!')]"));
    
    public OrderCompletionPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getOrderConfirmationMessage() {
        WebElement confirmationMessageElement = driver.findElement(ORDER_MESSAGE_LOCATOR);
        return confirmationMessageElement.getText();
    }
}
