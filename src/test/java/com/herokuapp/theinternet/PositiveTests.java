package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.*;

public class PositiveTests {

    private String expectedMessage;

    @Test
    public void loginTest() {
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

        // enter username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");

        // enter password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword!");

        // click login button
        WebElement logInButton = driver.findElement(By.tagName("button"));
        logInButton.click();

        // verifications
        // new url
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
