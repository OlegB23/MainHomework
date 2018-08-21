package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BaseFunctions {
    WebDriver chrome;

    public BaseFunctions() {
        System.setProperty("webdriver.chrome.driver", "/Users/oleg/Desktop/QA2/Drivers/chromedriver");
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();
    }

    public void openPage(String url) {
        chrome.get(url);
    }

    public List<WebElement> getElements(By locator) {
        Assert.assertFalse("Elements not found", chrome.findElements(locator).isEmpty());
        return chrome.findElements(locator);
    }

    public WebElement getElement(By locator) {
        Assert.assertFalse("Element not found", getElements(locator).isEmpty());
        return chrome.findElement(locator);
    }
}

