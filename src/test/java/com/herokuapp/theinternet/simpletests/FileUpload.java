package com.herokuapp.theinternet.simpletests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/fileupload");

        WebElement file = driver.findElement(By.id("file-upload-field"));
        file.sendKeys("file-to-upload.png");

        driver.quit();
    }
}
