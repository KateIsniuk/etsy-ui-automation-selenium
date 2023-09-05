package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;


public class ExceptionTests {
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
                System.out.println("Don't know how to start " + browser + " started Chrome browser instead.");
                driver = new ChromeDriver();
                break;
        }

        // Open tested page
        String url = "https://practicetestautomation.com/practice-test-exceptions/";
        driver.get(url);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        System.out.println("Page is opened");
    }

    @Test
    public void homeworkTest() {
//        Open page is opened in the before step

//        Click Add button

        WebElement addButton = driver.findElement(By.id("add_btn"));
        addButton.click();

//        Verify Row 2 input field is displayed

        WebElement rowElement = driver.findElement(By.xpath("//div[@id='row2']/input"));
        Assert.assertTrue(rowElement.isDisplayed(), "Is not displayed.");
        rowElement.sendKeys("Pizza");

//        Click Save button

        WebElement saveButton = driver.findElement(By.xpath("//div[@id='rows']/div[3]/div[@class='row']/button[@id='save_btn']"));
        saveButton.click();
    }

    @AfterMethod(alwaysRun = true)
    private void tearDown() {
        driver.quit();
        System.out.println("Test is finished");

    }
}
