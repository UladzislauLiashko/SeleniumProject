package org.example.ThirdSeleniumHW.utils;

import org.example.ThirdSeleniumHW.locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {

    private static final By confirmButtonNotDisabled = Locators.getLocator("Cart.confirmButtonNotDisabled");
    private static final By emptyCartMessage = Locators.getLocator("Notifications.emptyCart");

    private final WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForQuantityChange(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated((locator)));
    }

    public void waitForConfirmButtonAvailability() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(confirmButtonNotDisabled));
    }

    public void waitForEmptyCart() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(emptyCartMessage));
    }
}