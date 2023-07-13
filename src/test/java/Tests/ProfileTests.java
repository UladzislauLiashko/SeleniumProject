package Tests;

import org.example.ThirdSeleniumHW.locators.Locators;
import org.example.ThirdSeleniumHW.pages.LoginPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ProfileTests extends TestBase {
    String emailForLogin = "vladleshko@gmail.com";
    String passwordForLogin = "zaqWER123";
    String successfulLoginMessage = "\" You are now logged in as Vlad Leshko.\"";
    String logoutMessage = "\" You are now logged out.\"";
    String failedLoginMessage = "\" Wrong password or the account is disabled, or does not exist\"";

    @Test
    public void successfulLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.attemptLogin(emailForLogin, passwordForLogin);
        assertTrue(driver.findElement(Locators.getLocator("Notifications.success", successfulLoginMessage)).isDisplayed());
    }

    @Test
    public void failedLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.attemptLogin(emailForLogin, passwordForLogin + 1);
        assertTrue(driver.findElement(Locators.getLocator("Notifications.fail", failedLoginMessage)).isDisplayed());
    }

    @Test
    public void logoutTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.attemptLogout(emailForLogin, passwordForLogin);
        assertTrue(driver.findElement(Locators.getLocator("Notifications.success", logoutMessage)).isDisplayed());
    }
}