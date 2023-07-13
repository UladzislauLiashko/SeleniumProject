package Tests.ForThirdHW;

import org.example.ThirdSeleniumHW.locators.Locators;
import org.example.ThirdSeleniumHW.models.DuckOptions;
import org.example.ThirdSeleniumHW.models.UserInfo;
import org.example.ThirdSeleniumHW.pages.CartPage;
import org.example.ThirdSeleniumHW.pages.CatalogPage;
import org.example.ThirdSeleniumHW.pages.LoginPage;
import org.example.ThirdSeleniumHW.utils.Utils;
import org.junit.Test;
import org.openqa.selenium.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartPageTests extends TestBase {

    String emailForLogin = "vladleshko@gmail.com";
    String passwordForLogin = "zaqWER123";
    int itemCounter = 0;

    @Test
    public void buyDuckWithoutLogin() {
        DuckOptions duckOptions1 = new DuckOptions(1, "Small");
        UserInfo user =  new UserInfo("Test", "Tester", "QA", 220104, "Minsk", "Belarus", "test@test.com", "375290000000", "test");
        CatalogPage catalogPage = new CatalogPage(driver);
        CartPage cartPage = new CartPage(driver);
        Utils utils = new Utils(driver);
        catalogPage.navigateToElementInCatalog(CatalogPage.yellowDuck);
        catalogPage.addItemToCart(duckOptions1);
        itemCounter += duckOptions1.getNumberOfItems();
        utils.generalWaiter(Locators.getLocator("Catalog.quantityLocator", itemCounter));
        cartPage.navigateToCart();
        cartPage.fillInRequiredInformation(user);
        utils.generalWaiter(CartPage.confirmButtonNotDisabled);
        cartPage.confirmOrder();
        assertTrue(driver.findElement(CartPage.successfulOrderMessage).isDisplayed());
    }

    @Test
    public void buyDuckWithLogin() {
        DuckOptions duckOptions1 = new DuckOptions(1, "Small");
        LoginPage loginPage = new LoginPage(driver);
        CatalogPage catalogPage = new CatalogPage(driver);
        CartPage cartPage = new CartPage(driver);
        Utils utils = new Utils(driver);
        loginPage.attemptLogin(emailForLogin, passwordForLogin);
        catalogPage.navigateToElementInCatalog(CatalogPage.yellowDuck);
        catalogPage.addItemToCart(duckOptions1);
        itemCounter += duckOptions1.getNumberOfItems();
        utils.generalWaiter(Locators.getLocator("Catalog.quantityLocator", itemCounter));
        cartPage.navigateToCart();
        cartPage.confirmOrder();
        assertTrue(driver.findElement(CartPage.successfulOrderMessage).isDisplayed());
    }

    @Test
    public void addAndRemoveItem() {
        Utils utils = new Utils(driver);
        DuckOptions duckOptions1 = new DuckOptions(1, "Small");
        CatalogPage catalogPage = new CatalogPage(driver);
        CartPage cartPage = new CartPage(driver);
        catalogPage.navigateToElementInCatalog(CatalogPage.yellowDuck);
        catalogPage.addItemToCart(duckOptions1);
        itemCounter += duckOptions1.getNumberOfItems();
        utils.generalWaiter(Locators.getLocator("Catalog.quantityLocator", itemCounter));
        driver.navigate().back();
        cartPage.navigateToCart();
        cartPage.removeItemFromCart();
        utils.generalWaiter(CartPage.emptyCartMessage);
        assertTrue(driver.findElement(CartPage.emptyCartMessage).isDisplayed());
    }
}