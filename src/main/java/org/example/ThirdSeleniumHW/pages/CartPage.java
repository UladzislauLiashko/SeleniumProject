package org.example.ThirdSeleniumHW.pages;

import org.example.ThirdSeleniumHW.locators.Locators;
import org.example.ThirdSeleniumHW.models.UserInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class CartPage {

    private final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By checkOutButton = Locators.getLocator("Cart.checkOutButton");
    private static final By confirmButton = Locators.getLocator("Cart.confirmButton");
    private static final By removeItemFromCart = Locators.getLocator("Cart.removeItemFromCart");


    public void navigateToCart() {
        driver.findElement(checkOutButton).click();
    }

    public void fillInRequiredInformation(UserInfo userInfo) {
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(userInfo.getFirstName());
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(userInfo.getLastName());
        driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(userInfo.getAddress());
        driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys(String.valueOf(userInfo.getPostcode()));
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys(userInfo.getCity());
        new Select(driver.findElement(By.xpath("//select[@name='country_code']"))).selectByVisibleText(userInfo.getCountry());
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(userInfo.getEmail());
        driver.findElement(By.xpath("//input[@placeholder='+375']")).sendKeys(userInfo.getPhoneNumber());
        driver.findElement(By.xpath("//button[@name='set_addresses']")).click();
        driver.findElement(By.xpath("//textarea[@name='comments']")).sendKeys(userInfo.getComment());
    }

    public void confirmOrder() {
        driver.findElement(confirmButton).click();
    }

    public void removeItemFromCart() {
        driver.findElement(removeItemFromCart).click();
    }
}
