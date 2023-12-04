package com.saucedemo;

import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.OrderCompletionPage;
import com.saucedemo.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class ItemCanBeAddedFromItemPageTest extends BasicSaucedemoTest {
    private static final Logger logger = Logger.getLogger(ItemCanBeAddedFromItemPageTest.class.getName());
    @Test
    public void itemSuccessfullyAddedFromItemPage() {

        int itemIndex = 1;

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

        // Step # Find one item by name
        List<String> itemsToSelect = List.of("Sauce Labs Bolt T-Shirt");
        productsPage.waitForItemNamesToBeVisible(itemsToSelect);

        // Step # Click on the item name
        productsPage.addToCartButtons();

        // Step # Click on the card
        productsPage.goToShoppingCart();

        String itemName = productsPage.getProductTitleWithIndex(itemIndex);

        // Step # Validate that the item was added
        Assert.assertNotNull(itemName);

        logger.info("The product name in the card is : " + itemName);
    }
}
