package org.example.ThirdSeleniumHW.utils;

import org.example.ThirdSeleniumHW.locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {

    private static WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    public void generalWaiter(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}