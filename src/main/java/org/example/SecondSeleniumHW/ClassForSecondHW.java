package org.example.SecondSeleniumHW;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

import java.time.Duration;

public class ClassForSecondHW {

    public static void openSite() {
        String siteUrl = "https://litecart.stqa.ru/en/";
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get(siteUrl);
    }

}

