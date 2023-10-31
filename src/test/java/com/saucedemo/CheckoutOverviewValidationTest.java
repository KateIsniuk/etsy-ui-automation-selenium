package com.saucedemo;

import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.OrderCompletionPage;
import com.saucedemo.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class CheckoutOverviewValidationTest extends BasicSaucedemoTest {

    private static final Logger logger = LoggerFactory.getLogger(CheckoutOverviewValidationTest.class);
   
    @Test
    public void checkoutOverviewSuccessfulValidation() {

        //Validation 6 sub part (5):

        // Step # Login performance_glitch_user
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("performance_glitch_user","secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);

        // Step # Select all product items
        List<String> itemsToSelect = Arrays.asList(
                "Sauce Labs Backpack",
                "Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Fleece Jacket",
                "Sauce Labs Onesie",
                "Test.allTheThings() T-Shirt (Red)");
        productsPage.selectProductItems(itemsToSelect);

        // Step # Click on the card button for all product items
        productsPage.addToCartButtons();

        // Step # Click on the card icon
        productsPage.goToShoppingCart();

        // Step # Find the third item by name
        String itemName = productsPage.getProductNameElement();

        // Step # Remove item # 3 from the cart
        productsPage.removeItemFormTheCart(itemName);
        System.out.println("Removed product: " + itemName);

        // Step # Click on "Checkout" button
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCheckoutButton();

        // Step # Fill in checkout form
        checkoutPage.fillInForm("John","Smith","01238");

        // TBD: >>>
        //	Validate in the Checkout Overview that:
        //	It only contains the items that you want to purchase
        //	The Item Total is right (should 2 items remain)

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
