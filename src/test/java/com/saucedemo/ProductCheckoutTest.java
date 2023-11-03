package com.saucedemo;

import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.OrderCompletionPage;
import com.saucedemo.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ProductCheckoutTest extends BasicSaucedemoTest {

    @Test
    public void shouldSuccessfullyProceedWithCheckout() {

        // Step 1 Login as standard user
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);

        // Step 2 Select 2 products
        List<String> itemsToSelect = Arrays.asList("Sauce Labs Bolt T-Shirt", "Sauce Labs Backpack");
        productsPage.waitForItems(itemsToSelect);

        // Step 3 Click on "add to cart" button inside the product page
        productsPage.addToCartButtons();

        // Step 3 Click on the card element
        productsPage.goToShoppingCart();

        // Step 4 Click on "Checkout" button
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCheckoutButton();

        // Step 5 Fill in checkout form
        checkoutPage.fillInForm("John","Smith","01238");

        // Step 6 Click on the "Continue" button
        checkoutPage.clickContinueButton();

        // Step 7 Click on the "Finish" button
        checkoutPage.finishOrder();

        // Step 8 Validate a message of  complete
        OrderCompletionPage orderCompletionPage = new OrderCompletionPage(driver);

        String actualMessage = orderCompletionPage.getOrderConfirmationMessage();
        Assert.assertEquals(actualMessage, "Thank you for your order!");
    }
}
