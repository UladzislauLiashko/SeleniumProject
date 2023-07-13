package Tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestBase {

    public WebDriver driver;
    private final static String SITE_URL = "https://litecart.stqa.ru/en/";

    @Before
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(SITE_URL);
    }

    @After
    public void shutBrowser() {
        driver.quit();
    }
}