package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class TestsForSecondHW {
    String siteUrl = "https://litecart.stqa.ru/en/";
    String mainPageTitle = "Online Store | My Store";
    String rubberDucksPageTitle = "Rubber Ducks | My Store";
    String subCategoryPageUrl = "https://litecart.stqa.ru/en/rubber-ducks-c-1/subcategory-c-2/";
    String rubberDucksHeaderButton = "//nav[@id='site-menu']//a[contains(text(),'Rubber Ducks')]";
    String subCategoryHeaderButton = "//li[@class='category-1']//a[contains(text(),'Subcategory')]";

    public WebDriver driver;


    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get(siteUrl);
    }

    public void shutBrowser() {
        driver.quit();
    }

    public void siteIsOpening() {
        assertEquals(mainPageTitle, driver.getTitle());
    }

    public void checkSwitchToSellingPageAndTitle() {
        WebElement rubberDucksButton = driver.findElement(By.xpath(rubberDucksHeaderButton));
        rubberDucksButton.click();
        assertEquals(rubberDucksPageTitle, driver.getTitle());
    }

    public void checkSwitchToSubCategoryPageAndTitle() {
        WebElement rubberDucksButton = driver.findElement(By.xpath(rubberDucksHeaderButton));
        Actions builder = new Actions(driver);
        WebElement subCategoryButton = driver.findElement(By.xpath(subCategoryHeaderButton));
        builder.moveToElement(rubberDucksButton).moveToElement(subCategoryButton).click().perform();
        assertEquals(subCategoryPageUrl, driver.getCurrentUrl());
    }
}
