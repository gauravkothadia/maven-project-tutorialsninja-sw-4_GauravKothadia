package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TopMenuBar extends Utility {
    By desktopLink = By.linkText("Desktops");
    By verifyText = By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]");
    By laptopNotebookLink = By.linkText("Laptops & Notebooks");
    By verifyText1 = By.xpath("//h2[text()='Laptops & Notebooks']");
    By componentsLink = By.linkText("Components");
    By verifyText2 = By.xpath("//h2[text()='Components']");

    public void clickOnDesktopLink() {
        clickOnElement(desktopLink);
    }

    public String getVerifyText() {
        return getTextFromElement(verifyText);
    }

    public void clickOnLaptopNotebooksLink() {
        clickOnElement(laptopNotebookLink);
    }

    public String getVerifyText1() {
        return getTextFromElement(verifyText1);
    }
    public void clickOnComponantsLink() {
        clickOnElement(componentsLink);
    }

    public String getVerifyText2() {
        return getTextFromElement(verifyText2);
    }

    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        }
    }
}
