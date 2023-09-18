package com.etsy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.logging.Logger;
import java.util.logging.Level;

public class BaseEtsy {
    private static final Logger logger = Logger.getLogger(BeforeClass.class.getName());
    public WebDriver driver;
  
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        String url = "https://www.etsy.com/";
        driver.get(url);
        driver.manage().window().maximize();
        logger.log(Level.INFO,"Page is opened");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        logger.log(Level.INFO, "Test is finished");
    }
}
