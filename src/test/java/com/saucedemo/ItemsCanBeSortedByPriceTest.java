package com.saucedemo;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class ItemsCanBeSortedByPriceTest extends BasicSaucedemoTest {
    private static final Logger logger = Logger.getLogger(ItemsCanBeSortedByPriceTest.class.getName());

    @Test
    public void itemsShouldBeSortedByPriceCorrectly() {

        //Validation 4

        // Step # Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);

        // Step # Click on Dropdown element
        productsPage.sortingDropdown();

        // Sort products by price Low to High
        productsPage.sortByPriceLowToHigh();

        // Sort products by price High to Low
        productsPage.sortByPriceHighToLow();


        // Validate that the sorting is right

    }
}
