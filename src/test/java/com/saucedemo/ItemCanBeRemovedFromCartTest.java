package com.saucedemo;

import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.OrderCompletionPage;
import com.saucedemo.pages.ProductsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ItemCanBeRemovedFromCartTest extends BasicSaucedemoTest {
   
    @Test
    public void shouldSuccessfullyProceedWithCheckoutWhenItemRemovedFromCart() {

        //Validation 6:

        // Step 1 Login performance_glitch_user
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("performance_glitch_user","secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);

        // Step 2 Select all product items
        List<String> itemsToSelect = Arrays.asList(
                "Sauce Labs Backpack",
                "Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Fleece Jacket",
                "Sauce Labs Onesie",
                "Test.allTheThings() T-Shirt (Red)");
        productsPage.selectProductItems(itemsToSelect);
        productsPage.addToCartButtons();

        // Step 3 Click on the card element
        productsPage.goToShoppingCart();

        // Step 4 Find the third item by name, then remove it from the cart.
        String removedItemName = productsPage.getAndRemoveThirdProductName();
        System.out.println("Removed product: " + removedItemName);


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
