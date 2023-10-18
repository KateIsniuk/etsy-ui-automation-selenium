package com.saucedemo;

import com.etsy.BaseEtsy;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BasicPage {
    private static final Logger logger = Logger.getLogger(BaseEtsy.class.getName());

    public WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String url = "https://www.saucedemo.com";
        driver.get(url);
        driver.manage().window().maximize();
        logger.log(Level.INFO, "Page is opened");
    }

    public void card() {
        WebElement card = driver.findElement(By.cssSelector(".shopping_cart_link"));
        card.click();
    }

//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//        logger.log(Level.INFO, "Test is finished");
//    }
}
