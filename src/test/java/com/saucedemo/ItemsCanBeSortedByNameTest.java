package com.saucedemo;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import org.testng.annotations.Test;

import java.util.logging.Logger;


public class ItemsCanBeSortedByNameTest extends BasicSaucedemoTest {
    private static final Logger logger = Logger.getLogger(ItemsCanBeSortedByNameTest.class.getName());

    @Test
    public void itemsShouldBeSortedByNameCorrectly() {

        //Validation 3:

        /*
1.	Log in as a `standard user`
2.	Sort products by name
3.	Validate that the sorting is correct.
         */

        // Step # Log in as a `standard user`
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);

        // Step # Click on Dropdown element
        productsPage.sortingDropdown();

        // Step # Click on Sort products alphabetically from A to Z
        productsPage.sortFromAToZ();

        // Validate if names are sorted as expected from A to Z
        productsPage.validateNameSorting(true);

        // Step # Click on Sort products alphabetically from Z to A
        productsPage.sortFromZToA();

        // Validate if names are sorted as expected from Z to A
        productsPage.validateNameSorting(false);


    }
}
