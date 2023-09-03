package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeTests {
    private String expectedMessage;

   /* @Test (priority = 2, groups = { "negariveTests"})

    public void invalidPassword() {
        System.out.println("Test is started");

        // Create driver
        WebDriver driver = new ChromeDriver();
        System.out.println("Browser is started");

        // Open tested page
        String url = "http://the-internet.herokuapp.com/login";
        driver.get(url);

        driver.manage().window().maximize();

        System.out.println("Page is opened");

        // Enter username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");
        System.out.println("User name is entered");

        // Enter invalid password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword");
        System.out.println("Password is entered");

        //Click the login button
        WebElement logInButton = driver.findElement(By.tagName("button"));
        logInButton.click();

        // verification
        WebElement errorMessage = driver.findElement(By.cssSelector("#flash"));
        String expectedMessage = "Your password is invalid!";
        String actualMessage = errorMessage.getText();

        Assert.assertTrue(actualMessage.contains(expectedMessage), "Actual message does not contain expected message.\nActual Message: "
                + actualMessage + "\nExpected Message: " + expectedMessage);

        driver.quit();
        System.out.println("Test is finished");

    }*/

    @Parameters({"username", "password", "expectedMessage"})
    @Test
    public void negativeLoginTest(String username, String password, String expectedErrorMessage) {
        System.out.println("Test is started");

        // Create driver

        WebDriver driver = new ChromeDriver();
        System.out.println("Browser is started");

        // Open tested page
        String url = "http://the-internet.herokuapp.com/login";
        driver.get(url);

        driver.manage().window().maximize();

        System.out.println("Page is opened");

        // Enter username
        WebElement usernameElement = driver.findElement(By.id("username"));
        usernameElement.sendKeys(username);
        System.out.println("User name is entered");

        // Enter password
        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys(password);
        System.out.println("Password is entered");

        //Click the login button
        WebElement logInButton = driver.findElement(By.tagName("button"));
        logInButton.click();

        // verification
        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='flash']"));

        String actualMessage = errorMessage.getText();

        Assert.assertTrue(actualMessage.contains(expectedErrorMessage), "Actual message does not contain expected message.\nActual Message: "
                + actualMessage + "\nExpected Message: " + expectedErrorMessage);

        driver.quit();
        System.out.println("Test is finished");

    }
}
