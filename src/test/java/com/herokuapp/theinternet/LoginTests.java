package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

public class LoginTests {
    private WebDriver driver;
    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {
        // Create driver

        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                System.out.println(browser + " browser is started");
                break;
            case "safari":
                driver = new SafariDriver();
                System.out.println(browser + " browser is started");
                break;
            default:
                System.out.println("Don't know how to start " + browser+ " started Chrome browser instead.");
                driver = new ChromeDriver();
                break;
        }


        // Open tested page
        String url = "http://the-internet.herokuapp.com/login";
        driver.get(url);

        driver.manage().window().maximize();

        System.out.println("Page is opened");
    }

    @Test(priority = 1, groups = {"positiveTests", "smokeTests"})
    public void positiveLoginTest() {
        System.out.println("Test is started");

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

        Assert.assertTrue(actualMessage.contains(expectedMessage), "Actual message does not contain expected message.\nActual Message: "
                + actualMessage + "\nExpected Message: " + expectedMessage);
    }

    @Parameters({"username", "password", "expectedMessage"})
    @Test(priority = 2, groups = {"negativeTests", "smokeTests"})
    public void negativeLoginTest(String username, String password, String expectedErrorMessage) {

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

    }

    @AfterMethod(alwaysRun = true)
    private void tearDown() {
        driver.quit();
        System.out.println("Test is finished");
    }

    public void sleep(long m) {
        try {
            driver.wait(m);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
