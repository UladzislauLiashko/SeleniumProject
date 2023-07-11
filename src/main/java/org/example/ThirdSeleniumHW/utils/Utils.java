package org.example.ThirdSeleniumHW.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {

    private final WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForQuantityChange(String locator) {
          new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }
    public void waitForQuantityChange(By locator) {
          new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated((locator)));
    }

    public void waitForConfirmButtonAvailability() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@name='confirm_order' and not(contains(@disabled, 'disabled'))]")));
    }

    public void waitForProfileNotifications(String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }
}
