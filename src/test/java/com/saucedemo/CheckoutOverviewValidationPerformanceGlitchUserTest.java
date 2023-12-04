package com.saucedemo;

import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.OrderCompletionPage;
import com.saucedemo.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckoutOverviewValidationPerformanceGlitchUserTest extends BasicSaucedemoTest {

    @Test
    public void checkoutOverviewSuccessfulValidation() {

        int itemIndexToRemove = 3;

        //Validation 6:

        // Step # Login performance_glitch_user
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("performance_glitch_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);

        // Step # Click on the card button for all product items
        productsPage.addToCartButtons();

        // Step # Click on the card icon
        productsPage.goToShoppingCart();

        // Step # Remove item # 3 from the cart
        String itemName = productsPage.getProductTitleWithIndex(itemIndexToRemove);
        productsPage.removeItemFormTheCart(itemName);

        // Step # Click on "Checkout" button
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCheckoutButton();

        // Step # Fill in checkout form
        checkoutPage.fillInForm("John", "Smith", "01238");

        // Step # Click on the "Continue" button
        checkoutPage.clickContinueButton();

        // Step # Validate in the Checkout Overview
        List<String> itemElement = checkoutPage.validateItemsList();
        Assert.assertFalse(itemElement.contains(itemName), "Item " + itemName + " should not be present in the checkout items list.");

        // Step # Click on the "Finish" button
        checkoutPage.finishOrder();

        // Step # Validate a message of  complete
        OrderCompletionPage orderCompletionPage = new OrderCompletionPage(driver);

        String actualMessage = orderCompletionPage.getOrderConfirmationMessage();
        Assert.assertEquals(actualMessage, "Thank you for your order!");
    }
}
