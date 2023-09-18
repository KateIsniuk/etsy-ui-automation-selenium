package com.etsy;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class EtsyTest extends BaseEtsy {

    @Test
    public void leatherBags() {

        WebElement webElement = PageHelper.popUp(this.driver);
        PageHelper.clickPopUp(webElement);

        WebElement searchElement = PageHelper.searchField(this.driver);
        PageHelper.enterToSearchField(searchElement, "leather Bags");

        WebElement hitEnterIntoField = PageHelper.searchField(this.driver);
        PageHelper.hitEnter(hitEnterIntoField);

        WebElement checkFilterElement = PageHelper.allFilters(this.driver);
        PageHelper.checkFilter(checkFilterElement);

        WebElement checkFreeShipping = PageHelper.freeShippingCheckBox(this.driver);
        PageHelper.clickFreeShipping(checkFreeShipping);

        WebElement clickApplyButton1 = PageHelper.applyButton(this.driver);
        PageHelper.clickApplyButton(clickApplyButton1);

    }
}
