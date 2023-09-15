package com.eatsy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LeatherBags {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();

        String url = "https://www.etsy.com/";
        driver.get(url);

        driver.manage().window().maximize();

        System.out.println("Page is opened");
    }
    @Test
    public void test(){
        WebElement popUp =
                driver.findElement(By.xpath("//button[@class = 'wt-btn wt-btn--filled wt-mb-xs-0']"));
        popUp.click();

        //Find the search field
        WebElement searchField = driver.findElement(By.xpath("//input[@name='search_query']"));
        searchField.sendKeys("leather Bags");
        searchField.sendKeys(Keys.ENTER);

    }
    @AfterMethod(alwaysRun = true)
    private void tearDown() {
        driver.quit();
        System.out.println("Test is finished");
    }
}
