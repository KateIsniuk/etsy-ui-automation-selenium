package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderComplitionPage {
    
    private final WebDriver driver;
    
    public OrderComplitionPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getOrderConfirmationMessage() {
        WebElement confirmationMessageElement = driver.findElement(By.xpath("//h2[contains(text(), 'Thank you for your order!')]"));
        return confirmationMessageElement.getText();
    }
}
