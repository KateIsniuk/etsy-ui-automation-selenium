package com.saucedemo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.saucedemo.CheckoutElements.*;

public class MakeAndOrder extends BasicPage {

    @Test
    public void addProductsToCart() {

        // Step 1 Login as standard user
        LoginPage.login(driver);

        ProductsPage productsPage = new ProductsPage(driver);

        // Step 2 Select 2 products
        productsPage.clickProduct1();
        productsPage.clickProduct2();

        // Step 3 Click on the card element
        card();

        // Step 4 Click on "Checkout" button
        checkoutButton(driver);

        // Step 5 Fill in checkout form
        fillInForm(driver);

        // Step 6 Click on the "Continue" button
        continueButton(driver);

        // Step 7 Click on the "Finish" button
        finishOrder(driver);

        // Step 8 Validate a message of  complete
        messageOfComplete();
    }
}
