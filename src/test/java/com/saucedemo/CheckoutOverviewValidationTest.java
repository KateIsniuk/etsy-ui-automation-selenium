package com.saucedemo;

import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.OrderCompletionPage;
import com.saucedemo.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CheckoutOverviewValidationTest extends BasicSaucedemoTest {

    @Test
    public void checkoutOverviewSuccessfulValidation() {


        //Validation 6 subpart (5):

        // Step # Login performance_glitch_user
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("performance_glitch_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);

        // Step # Select all product items
        List<String> itemsToSelect = Arrays.asList(
                "Sauce Labs Backpack",
                "Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Fleece Jacket",
                "Sauce Labs Onesie",
                "Test.allTheThings() T-Shirt (Red)");

        productsPage.waitForItems(itemsToSelect);

        // Step # Click on the card button for all product items
        productsPage.addToCartButtons();

        // Step # Click on the card icon
        productsPage.goToShoppingCart();

        // Step # Click on "Checkout" button
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCheckoutButton();

        // Step # Fill in checkout form
        checkoutPage.fillInForm("John", "Smith", "01238");

        // Step # Click on the "Continue" button
        checkoutPage.clickContinueButton();

        // Step # Validate in the Checkout Overview that:
        List<String> itemElement = checkoutPage.validateItemsList();

        // Step # Click on the "Finish" button
        checkoutPage.finishOrder();

        // Step # Validate a message of  complete
        OrderCompletionPage orderCompletionPage = new OrderCompletionPage(driver);

        String actualMessage = orderCompletionPage.getOrderConfirmationMessage();
        Assert.assertEquals(actualMessage, "Thank you for your order!");
    }
}
