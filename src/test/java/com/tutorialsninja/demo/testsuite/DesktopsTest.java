package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.DesktopsPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DesktopsTest extends BaseTest {

    DesktopsPage desktopsPage = new DesktopsPage();

    /**
     * Write the following Test:
     * 1.Test name verifyProductArrangeInAlphaBaticalOrder()
     * 1.1 Mouse hover on Desktops Tab.and click
     * 1.2 Click on “Show All Desktops”
     * 1.3 Select Sort By position "Name: Z to A"
     * 1.4 Verify the Product will arrange in Descending orde
     */
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        desktopsPage.clickOnDesktopsTab();
        desktopsPage.clickOnShowAllDesktop();
        List<String> actualText = desktopsPage.getProductNamesInDefaultFilterAndSortByDescendingOrder();
        desktopsPage.selectFilter("https://tutorialsninja.com/demo/index.php?route=product/category&path=20&sort=pd.name&order=DESC");
        Thread.sleep(2000);
        List<String> expectedText = desktopsPage.getProductNamesAfterFilterZtoA();
        //1.4 Verify the Product will arrange in Descending order.
        Assert.assertEquals(actualText, expectedText);
    }

    /**
     * 2.1 Mouse hover on Currency Dropdown and click
     * 2.2 Mouse hover on £Pound Sterling and click
     * 2.3 Mouse hover on Desktops Tab.
     * 2.4 Click on “Show All Desktops”
     * 2.5 Select Sort By position "Name: A to Z"
     * 2.6 Select product “HP LP3065”
     * 2.7 Verify the Text "HP LP3065"
     * 2.8 Select Delivery Date "2023-11-27"
     * 2.9.Enter Qty "1” using Select class.
     * 2.10 Click on “Add to Cart” button
     * 2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
     * 2.12 Click on link “shopping cart” display into success message
     * 2.13 Verify the text "Shopping Cart"
     * 2.14 Verify the Product name "HP LP3065"
     * 2.15 Verify the Delivery Date "2023-11-27"
     * 2.16 Verify the Model "Product21"
     * 2.17 Verify the Totat "£74.73"
     */
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        desktopsPage.clickOnCurrencyDropDown();
        desktopsPage.mouseHoverOnPoundAndSterling();
        desktopsPage.clickOnDesktopsTab();
        desktopsPage.clickOnShowAllDesktop();
        desktopsPage.getOriginalProductDisplayList();
        desktopsPage.getProductSortByAToZ();
        desktopsPage.clickOnHPLP3065();
        Assert.assertEquals(desktopsPage.getTextHPLP3065(), "HP LP3065", "HP LP3065 not displayed");
        desktopsPage.selectDeliveryDate();
        desktopsPage.enterTheQuantity1();
        desktopsPage.clickOnAddToCartButton();
        Thread.sleep(2000);
        Assert.assertEquals(desktopsPage.verifySuccessMessage(), "Success: You have added HP LP3065 to your shopping cart!\n" +
                "×", "Success Message not displayed");
        desktopsPage.clickOnShoppingCartInToSuccessMessage();
        Thread.sleep(2000);
        Assert.assertEquals(desktopsPage.getShoppingCartText(), "Shopping Cart", "Shopping Cart text not displayed");
        Assert.assertEquals(desktopsPage.getProductNameIsHPLP3065(), "HP LP3065", "Product name is not HP LP3065");
        Assert.assertEquals(desktopsPage.getTheDeliveryDateIs20231130(), "Delivery Date:2023-11-27", "Delivery date is not correct");
        Assert.assertEquals(desktopsPage.getTheModelIsProduct21(), "Product 21", "Error Message not displayed");
        Assert.assertEquals(desktopsPage.getTotal(), "£74.73");
    }
}
