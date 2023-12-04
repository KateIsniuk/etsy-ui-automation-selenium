package com.saucedemo;

import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.OrderCompletionPage;
import com.saucedemo.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ItemCanBeAddedFromItemPageTest extends BasicSaucedemoTest {

    @Test
    public void itemSuccessfullyAddedFromItemPage() {

        // Validation 2:
/*
2.	Find one item by name, click on the item
3.	Add it to the cart from the item page
4.	Go to the cart
5.	Validate that the item was added
 */

        // Step # Login as problem_user user
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("problem_user","secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);

        // Step # Find one item by name, click on the item
        List<String> itemsToSelect = List.of("Sauce Labs Bolt T-Shirt");
        productsPage.waitForItemNamesToBeVisible(itemsToSelect);


        // Step # Click on "add to cart" button inside the product page
        productsPage.addToCartButtons();

        // Step # Click on the card element
        productsPage.goToShoppingCart();

        // Step # Click on "Checkout" button
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCheckoutButton();

        // Step # Fill in checkout form
        checkoutPage.fillInForm("John","Smith","01238");

        // Step # Click on the "Continue" button
        checkoutPage.clickContinueButton();

        // Step # Click on the "Finish" button
        checkoutPage.finishOrder();

        // Step # Validate a message of  complete
        OrderCompletionPage orderCompletionPage = new OrderCompletionPage(driver);

        String actualMessage = orderCompletionPage.getOrderConfirmationMessage();
        Assert.assertEquals(actualMessage, "Thank you for your order!");
    }
}
