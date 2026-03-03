package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Explicit wait method
    protected WebElement waitForElement(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Click method
    public void click(By locator) {
        waitForElement(locator, 10).click();
    }

    // Type method
    public void type(By locator, String text) {
        waitForElement(locator, 10).sendKeys(text);
    }

    // Get text method
    public String getText(By locator) {
        return waitForElement(locator, 10).getText();
    }

    // Get attribute method
    public String getAttribute(By locator, String attribute) {
        return waitForElement(locator, 10).getAttribute(attribute);
    }

    // Navigation method
    public void navigateTo(String url) {
        driver.get(url);
    }

    // JavaScript execution method
    public Object executeJavaScript(String script, Object... args) {
        return ((JavascriptExecutor) driver).executeScript(script, args);
    }
}