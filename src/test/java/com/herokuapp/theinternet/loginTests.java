package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class loginTests {

    private String expectedMessage;

    @Test (priority = 1, groups = {"positiveTests", "smokeTests"})
    public void positiveLoginTest() {
        System.out.println("Test is started");

        // Create driver
        WebDriver driver = new ChromeDriver();
        System.out.println("Browser is started");
        sleep(1);

        // Open tested page
        String url = "http://the-internet.herokuapp.com/login";
        driver.get(url);
        sleep(1);

        driver.manage().window().maximize();

        System.out.println("Page is opened");

        // Enter username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");

        // Enter password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword!");

        //Click the login button
        WebElement logInButton = driver.findElement(By.tagName("button"));
        logInButton.click();

        // Verifications
        // New URL
        String expectedUrl = "http://the-internet.herokuapp.com/secure";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Actual URL page is not the same as expected.");

        // logout button is visible
        WebElement logOutButton = driver.findElement(By.xpath("//i[@class='icon-2x icon-signout']"));
        Assert.assertTrue(logOutButton.isDisplayed(), "LogOut button is not visible.");

        // successful login message
        WebElement successfulMessage = driver.findElement(By.cssSelector("#flash"));
        String expectedMessage = "You logged into a secure area!";
        String actualMessage = successfulMessage.getText();
        //  Assert.assertEquals(actualMessage,expectedMessage, "Actual message is not the same as expected.");
        Assert.assertTrue(actualMessage.contains(expectedMessage), "Actual message does not contain expected message.\nActual Message: "
                + actualMessage + "\nExpected Message: " + expectedMessage);

        driver.close();
        System.out.println("Test is finished");
    }

    @Parameters({"username", "password", "expectedMessage"})
    @Test (priority = 2, groups = {"negativeTests", "smokeTests"})
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

    /**
     * Stop execution for the given amount of time
     *
     * @param seconds
     */
    
    private static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
