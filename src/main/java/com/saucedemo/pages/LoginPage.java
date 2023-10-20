package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {

    private final WebDriver driver;
    private static final By USER_NAME_FIELD_LOCATOR = By.id("user-name");
    private static final By PASSWORD_FIELD_LOCATOR = By.id("password");
    private static final By LOGIN_BUTTON_LOCATOR = By.id("login-button");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String userName, String password) {

        WebElement userNameField = driver.findElement(USER_NAME_FIELD_LOCATOR);
        userNameField.sendKeys(userName);

        WebElement passwordField = driver.findElement(PASSWORD_FIELD_LOCATOR);
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(LOGIN_BUTTON_LOCATOR);
        loginButton.click();
    }
}
