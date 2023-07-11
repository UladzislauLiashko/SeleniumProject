package Tests.ForThirdHW;

import org.example.ThirdSeleniumHW.locators.Locators;
import org.example.ThirdSeleniumHW.pages.LoginPage;
import org.junit.Test;
import org.openqa.selenium.*;

import static org.junit.Assert.assertTrue;

public class ProfileTests extends TestBase {
    String emailForLogin = "vladleshko@gmail.com";
    String passwordForLogin = "zaqWER123";
    private static By successfulNotification = Locators.getLocator("successMessage");

    String profileNotificationLocator = "//div[@class='notice success' and text()=%s]";
    String profileFailedNotificationLocator = "//div[@class='notice errors' and text()=%s]";
    String successfulLoginMessage = "\" You are now logged in as Vlad Leshko.\"";
    String logoutMessage = "\" You are now logged out.\"";
    String failMessage = "\" Wrong password or the account is disabled, or does not exist\"";

    @Test
    public void successfulLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.attemptLogin(emailForLogin, passwordForLogin);
        assertTrue(driver.findElement(By.xpath(String.format(profileNotificationLocator, successfulLoginMessage))).isDisplayed());
    }

  @Test
    public void failedLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.attemptLogin(emailForLogin, passwordForLogin+1);
      assertTrue(driver.findElement(By.xpath(String.format(profileFailedNotificationLocator, failMessage))).isDisplayed());
    }

    @Test
    public void logoutTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.attemptLogout(emailForLogin, passwordForLogin);
        assertTrue(driver.findElement(By.xpath(String.format(profileNotificationLocator, logoutMessage))).isDisplayed());
    }
}