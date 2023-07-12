package org.example.ThirdSeleniumHW.pages;

import org.example.ThirdSeleniumHW.locators.Locators;
import org.example.ThirdSeleniumHW.models.DuckOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CatalogPage {

    private final WebDriver driver;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By searchLine = Locators.getLocator("SidePanel.searchLine");
    private static final By sizeDropdown = Locators.getLocator("Catalog.sizeDropdown");
    private static final By quantityField = Locators.getLocator("Catalog.quantityField");
    private static final By addToCart = Locators.getLocator("Catalog.addToCart");

    public boolean isElementPresent(By sizeDropdown) {
        try {
            driver.findElement(sizeDropdown);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void searchAttempt(String searchItem) {
        driver.findElement(searchLine).sendKeys(searchItem);
        driver.findElement(searchLine).sendKeys(Keys.RETURN);
    }

    public void addItemToCart(DuckOptions duckOptions) {
        if (isElementPresent(sizeDropdown)) {
            new Select(driver.findElement(sizeDropdown)).selectByVisibleText(duckOptions.getSize());
        }
        for (int i = 0; i < duckOptions.getNumberOfItems() - 1; i++) {
            driver.findElement(quantityField).sendKeys(Keys.ARROW_UP);
        }
        driver.findElement(addToCart).click();
    }

    public void navigateToElementInCatalog(By itemName) {
        driver.findElement(itemName).click();
    }
}