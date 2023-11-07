package com.saucedemo;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import java.util.logging.Logger;

public class ItemCanBeRemovedFromCartTest extends BasicSaucedemoTest {
    private static final Logger logger = Logger.getLogger(ItemCanBeRemovedFromCartTest.class.getName());

    @Test
    public void shouldSuccessfullyProceedWithCheckoutWhenItemRemovedFromCart() {

        int itemIndexToRemove = 3;
        //Validation 6 - first 4 steps implemented in this test:

        // Step 1 Login performance_glitch_user
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("performance_glitch_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);

        // Step 2 Select all product items
//        List<String> itemsToSelect = Arrays.asList(
//                "Sauce Labs Backpack",
//                "Sauce Labs Bike Light",
//                "Sauce Labs Bolt T-Shirt",
//                "Sauce Labs Fleece Jacket",
//                "Sauce Labs Onesie",
//                "Test.allTheThings() T-Shirt (Red)");

//       productsPage.waitForItems(itemsToSelect);

        // Step 3 Click on the card button for all product items
        productsPage.addToCartButtons();

        // Step 4 Click on the card icon
        productsPage.goToShoppingCart();

        // Step 5 Find the third item by name

        String itemName = productsPage.getProductTitleWithIndex(itemIndexToRemove);

        // Step 6 Remove item # 3 from the cart
        productsPage.removeItemFormTheCart(itemName);

        //Log level
        logger.info("Removed product: " + itemName);
        System.out.println("Removed product: " + itemName);

    }
}
