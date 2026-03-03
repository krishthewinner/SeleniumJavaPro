package com.automation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    public static String takeScreenshot(WebDriver driver, String testName) {
        try {
            String screenshotDir = "screenshots";
            Files.createDirectories(Paths.get(screenshotDir));
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            String fileName = screenshotDir + "/" + testName + "_" + timestamp + ".png";
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(srcFile.toPath(), Paths.get(fileName));
            System.out.println("Screenshot saved: " + fileName);
            return fileName;
        } catch (IOException e) {
            System.out.println("Failed to take screenshot: " + e.getMessage());
            return null;
        }
    }
}