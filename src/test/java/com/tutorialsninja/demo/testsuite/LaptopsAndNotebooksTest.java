package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LaptopsAndNotebooksTest extends BaseTest {
    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();

    /**
     * 1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
     * 1.1 Mouse hover on Laptops & Notebooks Tab.and click
     * 1.2 Click on “Show All Laptops & Notebooks”
     * 1.3 Select Sort By "Price (High > Low)"
     * 1.4 Verify the Product price will arrange in High to Low order
     */

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        //  1.1 Mouse hover on Laptops & Notebooks Tab.and click
        laptopsAndNotebooksPage.clickOnLaptopsAndNotebooksTab();
        // Click on “Show All Laptops & Notebooks”
        laptopsAndNotebooksPage.clickOnShowAllLaptopsAndNotebooksTab();
        //1.3 Select Sort By "Price (High > Low)"
        List<Double> actualText = laptopsAndNotebooksPage.getProductPricesInDefaultFilterAndSortByDescendingOrder();
        laptopsAndNotebooksPage.setSortByPriceHighToLow();
        Thread.sleep(2000);
        //1.4 Verify the Product price will arrange in High to Low order
        List<Double> expectedText = laptopsAndNotebooksPage.getProductPriceAfterFilterHighToLow();
        Assert.assertEquals(actualText, expectedText);
    }

    /**
     * 2. Test name verifyThatUserPlaceOrderSuccessfully()
     * 2.1 Mouse hover on Laptops & Notebooks Tab and click
     * 2.2 Click on “Show All Laptops & Notebooks”
     * 2.3 Select Sort By "Price (High > Low)"
     * 2.4 Select Product “MacBook”
     * 2.5 Verify the text “MacBook”
     * 2.6 Click on ‘Add To Cart’ button
     * 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
     * 2.8 Click on link “shopping cart” display into success message
     * 2.9 Verify the text "Shopping Cart"
     * 2.10 Verify the Product name "MacBook"
     * 2.11 Change Quantity "2"
     * 2.12 Click on “Update” Tab
     * 2.13 Verify the message “Success: You have modified your shopping cart!”
     * 2.14 Verify the Total $1204.00
     * 2.15 Click on “Checkout” button
     * 2.16 Verify the text “Checkout”
     * 2.17 Verify the Text “New Customer”
     * 2.18 Click on “Guest Checkout” radio button
     * 2.19 Click on “Continue” tab
     * 2.20 Fill the mandatory fields
     * 2.21 Click on “Continue” Button
     * 2.22 Add Comments About your order into text area
     * 2.23 Check the Terms & Conditions check box
     * 2.24 Click on “Continue” button
     */
    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        laptopsAndNotebooksPage.clickOnLaptopsAndNotebooksTab();
        laptopsAndNotebooksPage.clickOnShowAllLaptopsAndNotebooksTab();
        laptopsAndNotebooksPage.selectSortByPriceHighToLow();
        laptopsAndNotebooksPage.selectProductMacBook();
        Assert.assertEquals(laptopsAndNotebooksPage.verifyTheTextMacBook(), "MacBook");
        laptopsAndNotebooksPage.clickOnAddToCartButton();
        Assert.assertEquals(laptopsAndNotebooksPage.verifyTheMessageSuccess(), "Success: You have added MacBook to your shopping cart!\n" +
                "×");
        laptopsAndNotebooksPage.clickOnLinkShoppingCartDisplayIntoSuccess();
        Assert.assertEquals(laptopsAndNotebooksPage.verifyTheTextShoppingCart(), "Shopping Cart");
        Assert.assertEquals(laptopsAndNotebooksPage.verifyTheProductNameMacBook(), "MacBook");
        laptopsAndNotebooksPage.setClearTextBox();
        laptopsAndNotebooksPage.changeQty();
        laptopsAndNotebooksPage.clickOnUpdateTab();
        Assert.assertEquals(laptopsAndNotebooksPage.verifyTheMessageModifiedShoppingCart(), "Success: You have modified your shopping cart!\n" +
                "×");
        Assert.assertEquals(laptopsAndNotebooksPage.verifyTheTotal(), "$1,204.00");
        laptopsAndNotebooksPage.clickOnCheckoutButton();
        laptopsAndNotebooksPage.clickOnLaptopsAndNotebooksTab();
        laptopsAndNotebooksPage.clickOnShowAllLaptopsAndNotebooksTab();
        laptopsAndNotebooksPage.selectSortByPriceHighToLow();
        laptopsAndNotebooksPage.clickOnNewProduct();
        laptopsAndNotebooksPage.selectAddToCart();
        laptopsAndNotebooksPage.clickOnCheckoutButton();
        laptopsAndNotebooksPage.removeOldProduct();
        Thread.sleep(2000);
        laptopsAndNotebooksPage.setClickOnCheckout();
        Assert.assertEquals(laptopsAndNotebooksPage.verifyTheCheckoutText(), "Checkout");

        Assert.assertEquals(laptopsAndNotebooksPage.verifyTheTextNewCustomer(), "New Customer");

        laptopsAndNotebooksPage.clickOnGuestCheckoutbutton();
        laptopsAndNotebooksPage.clickOnContinueButton();
        laptopsAndNotebooksPage.firstNameField();
        laptopsAndNotebooksPage.lastNameField();
        laptopsAndNotebooksPage.emailFieldText();
        laptopsAndNotebooksPage.telephoneField();
        laptopsAndNotebooksPage.address1Field();
        laptopsAndNotebooksPage.cityFieldText();
        laptopsAndNotebooksPage.postalCodeField();
        laptopsAndNotebooksPage.countryField();
        laptopsAndNotebooksPage.regionField();
        laptopsAndNotebooksPage.clickOnContinueButtonAfterMandatory();
        laptopsAndNotebooksPage.addCommentsAboutYourOrderInToTextArea();
        laptopsAndNotebooksPage.clickOnFinalContinueButton();
        laptopsAndNotebooksPage.clickOnTermsAndConditionCheckbox();
        laptopsAndNotebooksPage.setFinalContinueButton();
    }
}
