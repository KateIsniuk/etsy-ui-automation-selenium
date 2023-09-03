package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeInvalidUserNameTests {

    private String expectedMessage;

    @Test
    //Change the method name so that it starts in lowercase 
    public void InvalidUserName() {
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
        username.sendKeys("invalid user name");
        System.out.println("User name is entered");

        // Enter password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword!");
        System.out.println("Password is entered");

        //Click the login button
        WebElement logInButton = driver.findElement(By.tagName("button"));
        logInButton.click();

        // verification
        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='flash']"));
        String expectedMessage = "Your username is invalid!";
        String actualMessage = errorMessage.getText();

        Assert.assertTrue(actualMessage.contains(expectedMessage), "Actual message does not contain expected message.\nActual Message: "
                + actualMessage + "\nExpected Message: " + expectedMessage);

        driver.quit();
        System.out.println("Test is finished");

    }
}
