package com.saucedemo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AddToCart extends BasicPage {
    
    @Test
    public void addProductsToCart() {

        // Step 1 Login as standard user
        LoginPage.login(driver);

        ProductsPage productsPage = new ProductsPage(driver);

        // Step 2 Find 2 products
        productsPage.clickProduct1();
        productsPage.clickProduct2();

        // Step 3 Click on the card element
        card();
    }
}
