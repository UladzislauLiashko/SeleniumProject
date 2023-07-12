package org.example.ThirdSeleniumHW.locators;

import org.openqa.selenium.By;

import java.io.InputStream;
import java.util.Properties;

public class Locators {

    private static final Properties locators;

    static {
        locators = new Properties();
        InputStream is =
                Locators.class.getResourceAsStream("/locators.properties");
        try {
            locators.load(is);
        } catch (Exception e) {
            System.out.println("Error reading from property file");
        }
    }

    public static By getLocator(String locator) {
        By by;
        String value = locators.getProperty(locator);

        String[] result = value.split("=", 2);
        LocatorType locatorType = LocatorType.valueOf(result[0]);
        String selector = result[1];
        by = switch (locatorType) {
            case id -> By.id(selector);
            case xpath -> By.xpath(selector);
            case css -> By.cssSelector(selector);
            case linkText -> By.linkText(selector);
            default -> throw new IllegalStateException("Unexpected value: " + locatorType);
        };
        return by;
    }

    public static By getLocator(String locator, int quantity) {
        By by;
        String value = locators.getProperty(locator);

        String[] result = value.split("=", 2);
        LocatorType locatorType = LocatorType.valueOf(result[0]);
        String selector = result[1];
        selector = String.format(selector, quantity);
        by = switch (locatorType) {
            case id -> By.id(selector);
            case xpath -> By.xpath(selector);
            case css -> By.cssSelector(selector);
            case linkText -> By.linkText(selector);
            default -> throw new IllegalStateException("Unexpected value: " + locatorType);
        };
        return by;
    }

    public static By getLocator(String locator, String message) {
        By by;
        String value = locators.getProperty(locator);

        String[] result = value.split("=", 2);
        LocatorType locatorType = LocatorType.valueOf(result[0]);
        String selector = result[1];
        selector = String.format(selector, message);
        by = switch (locatorType) {
            case id -> By.id(selector);
            case xpath -> By.xpath(selector);
            case css -> By.cssSelector(selector);
            case linkText -> By.linkText(selector);
            default -> throw new IllegalStateException("Unexpected value: " + locatorType);
        };
        return by;
    }
}