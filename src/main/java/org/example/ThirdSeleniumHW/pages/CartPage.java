package org.example.ThirdSeleniumHW.pages;

import org.example.ThirdSeleniumHW.locators.Locators;
import org.example.ThirdSeleniumHW.models.UserInfo;
import org.example.ThirdSeleniumHW.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class CartPage {

    private final WebDriver driver;
    private final Utils utils;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        utils = new Utils(driver);
    }

    private static final By checkOutButton = Locators.getLocator("Cart.checkOutButton");
    public static final By confirmButton = Locators.getLocator("Cart.confirmButton");
    private static final By removeItemFromCart = Locators.getLocator("Cart.removeItemFromCart");
    private static final By nameField = Locators.getLocator("UserInfo.nameField");
    private static final By lastNameField = Locators.getLocator("UserInfo.lastNameField");
    private static final By addressField = Locators.getLocator("UserInfo.addressField");
    private static final By postcodeField = Locators.getLocator("UserInfo.postcodeField");
    private static final By cityField = Locators.getLocator("UserInfo.cityField");
    private static final By emailField = Locators.getLocator("UserInfo.emailField");
    private static final By phoneNumberField = Locators.getLocator("UserInfo.phoneNumberField");
    private static final By commentsField = Locators.getLocator("UserInfo.commentsField");
    private static final By countryDropdown = Locators.getLocator("UserInfo.countryDropdown");
    private static final By setAddressButton = Locators.getLocator("UserInfo.setAddressButton");
    public static final By successfulOrderMessage = Locators.getLocator("Cart.successfulOrderMessage");
    public static final By emptyCartMessage = Locators.getLocator("Notifications.emptyCart");
    public static final By confirmButtonNotDisabled = Locators.getLocator("Cart.confirmButtonNotDisabled");


    public void navigateToCart() {
        driver.findElement(checkOutButton).click();
    }

    public void fillInRequiredInformation(UserInfo userInfo) {
        driver.findElement(nameField).sendKeys(userInfo.getFirstName());
        driver.findElement(lastNameField).sendKeys(userInfo.getLastName());
        driver.findElement(addressField).sendKeys(userInfo.getAddress());
        driver.findElement(postcodeField).sendKeys(String.valueOf(userInfo.getPostcode()));
        driver.findElement(cityField).sendKeys(userInfo.getCity());
        new Select(driver.findElement(countryDropdown)).selectByVisibleText(userInfo.getCountry());
        driver.findElement(emailField).sendKeys(userInfo.getEmail());
        driver.findElement(phoneNumberField).sendKeys(userInfo.getPhoneNumber());
        driver.findElement(setAddressButton).click();
        driver.findElement(commentsField).sendKeys(userInfo.getComment());
    }

    public void confirmOrder() {
        utils.generalWaiter(CartPage.confirmButtonNotDisabled);
        utils.generalWaiter(CartPage.confirmButton);
        driver.findElement(confirmButton).click();
    }

    public void removeItemFromCart() {
        driver.findElement(removeItemFromCart).click();
        utils.generalWaiter(CartPage.emptyCartMessage);
    }
}
