package Tests.ForThirdHW;

import org.example.ThirdSeleniumHW.locators.Locators;
import org.example.ThirdSeleniumHW.models.DuckOptions;
import org.example.ThirdSeleniumHW.pages.CatalogPage;
import org.example.ThirdSeleniumHW.utils.Utils;
import org.junit.Test;
import org.openqa.selenium.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CatalogPageTests extends TestBase {
    private static final By yellowDuck = Locators.getLocator("Catalog.yellowDuck");

    private static final By blueDuck = Locators.getLocator("Catalog.blueDuck");
    private static final By redDuck = Locators.getLocator("Catalog.redDuck");
    int itemCounter = 0;

    @Test
    public void positiveSearchInCatalog() {
        CatalogPage catalogPage = new CatalogPage(driver);
        String positiveSearchItem = "Green Duck";
        catalogPage.searchAttempt(positiveSearchItem);
        String expectedResult = String.format("%s | Subcategory | Rubber Ducks | My Store", positiveSearchItem);
        assertEquals(driver.getTitle(), expectedResult);
    }

    @Test
    public void negativeSearchInCatalog() {
        CatalogPage catalogPage = new CatalogPage(driver);
        String negativeSearchItem = "Java";
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

        catalogPage.navigateToElementInCatalog(yellowDuck);
        catalogPage.addItemToCart(duckOptions1);
        itemCounter += duckOptions1.getNumberOfItems();
        utils.waitForQuantityChange(Locators.getLocator("Catalog.quantityLocator", itemCounter));
        driver.navigate().back();

        catalogPage.navigateToElementInCatalog(blueDuck);
        catalogPage.addItemToCart(duckOptions2);
        itemCounter += duckOptions2.getNumberOfItems();
        utils.waitForQuantityChange(Locators.getLocator("Catalog.quantityLocator", itemCounter));

//        utils.waitForQuantityChange(String.format(quantityLocator, itemCounter));

        catalogPage.navigateToElementInCatalog(redDuck);
        catalogPage.addItemToCart(duckOptions3);
        itemCounter += duckOptions3.getNumberOfItems();
        utils.waitForQuantityChange(Locators.getLocator("Catalog.quantityLocator", itemCounter));

//        utils.waitForQuantityChange(String.format(quantityLocator, itemCounter));

//        assertTrue(driver.findElement(By.xpath((String.format(quantityLocator, itemCounter)))).isDisplayed());
    }
}
