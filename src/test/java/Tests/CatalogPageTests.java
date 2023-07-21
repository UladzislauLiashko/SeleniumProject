package Tests;

import org.example.ThirdSeleniumHW.locators.Locators;
import org.example.ThirdSeleniumHW.models.DuckOptions;
import org.example.ThirdSeleniumHW.pages.CatalogPage;
import org.example.ThirdSeleniumHW.utils.Utils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CatalogPageTests extends TestBase {
    int itemCounter = 0;
    String positiveSearchItem = "Green Duck";
    String negativeSearchItem = "Java";

    @Test
    public void positiveSearchInCatalog() {
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.searchAttempt(positiveSearchItem);
        String expectedResult = String.format("%s | Subcategory | Rubber Ducks | My Store", positiveSearchItem);
        assertEquals(driver.getTitle(), expectedResult);
    }

    @Test
    public void negativeSearchInCatalog() {
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.searchAttempt(negativeSearchItem);
        String expectedResult = String.format("Search Results for \"%s\" | My Store", negativeSearchItem);
        assertEquals(driver.getTitle(), expectedResult);
    }

    @Test
    public void navigateThroughCatalog() {
        DuckOptions duckOptions1 = new DuckOptions(1, "Small");
        DuckOptions duckOptions2 = new DuckOptions(2);
        DuckOptions duckOptions3 = new DuckOptions(2);
        CatalogPage catalogPage = new CatalogPage(driver);
        Utils utils = new Utils(driver);
        catalogPage.navigateToElementInCatalog(CatalogPage.yellowDuck);
        catalogPage.addItemToCart(duckOptions1);
        itemCounter += duckOptions1.getNumberOfItems();
        driver.navigate().back();
        catalogPage.navigateToElementInCatalog(CatalogPage.blueDuck);
        catalogPage.addItemToCart(duckOptions2);
        itemCounter += duckOptions2.getNumberOfItems();
        utils.generalWaiter(Locators.getLocator("Catalog.quantityLocator", itemCounter));
        catalogPage.navigateToElementInCatalog(CatalogPage.redDuck);
        catalogPage.addItemToCart(duckOptions3);
        itemCounter += duckOptions3.getNumberOfItems();
        utils.generalWaiter(Locators.getLocator("Catalog.quantityLocator", itemCounter));
        assertTrue(driver.findElement((Locators.getLocator("Catalog.quantityLocator", itemCounter))).isDisplayed());
    }
}