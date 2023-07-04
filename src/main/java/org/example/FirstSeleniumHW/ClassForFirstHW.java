package org.example.FirstSeleniumHW;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class ClassForFirstHW {

    public static void baseMethod() {
        String siteUrl = "https://the-internet.herokuapp.com";
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get(siteUrl);

        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement i : links) { //просто для себя вывел
            System.out.println(i.getAccessibleName());
        }

        WebElement finderOf10Element = links.get(9);
        finderOf10Element.click();

        driver.quit();
    }
}
