package com.kamal.learnlocatexpath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

@Test
public class BrowserFactory {
    public static WebDriver driver;
    // Object ob= new ChromeDriver();
    //WebDriver driver = (WebDriver)ob;

    public static WebDriver getDriver(String browserName) {
        if (browserName.equalsIgnoreCase("Chrome"))
            driver = new ChromeDriver();
        else if (browserName.equalsIgnoreCase("Microsoft Edge")) {
            driver = new EdgeDriver();
        }
        return driver;
    }
}
