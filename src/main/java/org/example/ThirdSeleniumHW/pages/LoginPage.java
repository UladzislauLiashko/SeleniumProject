package org.example.ThirdSeleniumHW.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    By emailLocator = By.cssSelector("input[name='email']");
    By passwordLocator = By.cssSelector("input[name='password']");
    By loginButtonLocator = By.xpath("//button[@name='login']");

    By logoutButtonLocator = By.xpath("//div[@class='content']//a[normalize-space()='Logout']");
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void attemptLogin(String emailForLogin, String password) {
        driver.findElement(emailLocator).sendKeys(emailForLogin);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
    }

    public void attemptLogout(String emailForLogin, String password) {
        driver.findElement(emailLocator).sendKeys(emailForLogin);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
        driver.findElement(logoutButtonLocator).click();
    }
}


