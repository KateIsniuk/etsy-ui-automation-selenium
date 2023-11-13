package com.saucedemo;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

        // Step # Click on Sort products by price Low to High
        productsPage.sortByPriceLowToHigh();

        // Step # Get all prices
        productsPage.getItemPricesList();

        // Validate if Prices sorted as expected from Low to High
        List<Double> expectedSortedPricesFromLowToHigh = Arrays.asList(7.99, 9.99, 15.99, 15.99, 29.99, 49.99);
        Assert.assertEquals(expectedSortedPricesFromLowToHigh,
                productsPage.getItemPricesList(), "Prices are not sorted ascending");

        // Step # Click on Sort products by price High to Low
        productsPage.sortByPriceHighToLow();

        // Step # Get all prices
        productsPage.getItemPricesList();

        // Validate if Prices sorted as expected from Low to High
        List<Double> expectedSortedPricesFromHighToLoe = Arrays.asList(49.99,29.99,15.99,15.99,9.99,7.99);
        Assert.assertEquals(expectedSortedPricesFromHighToLoe,
                productsPage.getItemPricesList(), "Prices are not sorted descending");
    }
}
