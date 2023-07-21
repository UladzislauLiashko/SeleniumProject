package org.example.ThirdSeleniumHW.pages;

import org.example.ThirdSeleniumHW.locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private static final By emailField = Locators.getLocator("SidePanel.loginField");
    private static final By passwordField = Locators.getLocator("SidePanel.passwordField");
    private static final By loginButton = Locators.getLocator("SidePanel.loginButton");
    private static final By logoutButton = Locators.getLocator("SidePanel.logoutButton");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void attemptLogin(String emailForLogin, String password) {
        driver.findElement(emailField).sendKeys(emailForLogin);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void attemptLogout(String emailForLogin, String password) {
        driver.findElement(emailField).sendKeys(emailForLogin);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        driver.findElement(logoutButton).click();
    }
}