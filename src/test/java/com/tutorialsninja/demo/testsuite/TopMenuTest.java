package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.TopMenuBar;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 1. create class "TopMenuTest"
 * 1.1 create method with name "selectMenu" it has one parameter name "menu" of type
 * string
 * 1.2 This method should click on the menu whatever name is passed as parameter.
 * Write the following Test:
 * 1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
 * 1.1 Mouse hover on “Desktops” Tab and click
 * 1.2 call selectMenu method and pass the menu = “Show All Desktops”
 * 1.3 Verify the text ‘Desktops’
 * 2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
 * 2.1 Mouse hover on “Laptops & Notebooks” Tab and click
 * 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
 * 2.3 Verify the text ‘Laptops & Notebooks’
 * 3. verifyUserShouldNavigateToComponentsPageSuccessfully()
 * 3.1 Mouse hover on “Components” Tab and click
 * 3.2 call selectMenu method and pass the menu = “Show All Components”
 * 3.3 Verify the text ‘Components’
 */
public class TopMenuTest extends BaseTest {
    TopMenuBar topMenuBar = new TopMenuBar();
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        topMenuBar.clickOnDesktopLink();
        topMenuBar.selectMenu("Show All Desktops");
        Assert.assertEquals(topMenuBar.getVerifyText(), "Desktops", "Error Message not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        topMenuBar.clickOnLaptopNotebooksLink();
        topMenuBar.selectMenu("Show AllLaptops & Notebooks");
        Assert.assertEquals(topMenuBar.getVerifyText1(), "Laptops & Notebooks", "Error Message not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        topMenuBar.clickOnComponantsLink();
        topMenuBar.selectMenu("Show AllComponents");
        Assert.assertEquals(topMenuBar.getVerifyText2(), "Components", "Error Message not displayed");
    }
}
