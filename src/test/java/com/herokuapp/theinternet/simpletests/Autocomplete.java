package com.herokuapp.theinternet.simpletests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Autocomplete {
    public static void main(String[] args){
        
        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/autocomplete");

        WebElement autocomplete = driver.findElement(By.id("autocomplete"));

        autocomplete.sendKeys("1555 Park Blvd, Palo Alto, CA");

       // Implicit Wait
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

       // Explicit Wait
        WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement  autocompleteResult =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pac-item")));
        autocompleteResult.click();

        driver.quit();
    }
}
