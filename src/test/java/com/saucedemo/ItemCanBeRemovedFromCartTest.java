package com.saucedemo;

import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.OrderCompletionPage;
import com.saucedemo.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ItemCanBeRemovedFromCartTest extends BasicSaucedemoTest {
   
    @Test
    public void shouldSuccessfullyProceedWithCheckoutWhenItemRemovedFromCart() {

        // Step 1 Login performance_glitch_user
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("performance_glitch_user","secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);

        // Step 2 Select 3 product items
        List<String> itemsToSelect = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt", "Test.allTheThings() T-Shirt (Red)");
        productsPage.selectProductItems(itemsToSelect);

        // Step 3 Click on the card element
        productsPage.goToShoppingCart();

        // TBD >> Step 4 Find the third item by name, then remove it from the cart.

        // Step 5 Click on "Checkout" button
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCheckoutButton();

        // Step 5 Fill in checkout form
        checkoutPage.fillInForm("John","Smith","01238");

        // TBD: >>>
        //	Validate in the Checkout Overview that:
        //	It only contains the items that you want to purchase
        //	The Item Total is right (should 2 items remain)

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
