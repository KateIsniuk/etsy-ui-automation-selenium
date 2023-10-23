package com.saucedemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.etsy.BaseEtsy;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BasicSaucedemoTest {
    private static final Logger logger = Logger.getLogger(BaseEtsy.class.getName());

    public WebDriver driver;
    private static final String HOST = "https://www.saucedemo.com";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(HOST);
        driver.manage().window().maximize();
        logger.log(Level.INFO, "Navigating to saucedemo.com landing page");
    }
//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//        logger.log(Level.INFO, "Test is finished");
//    }
}
