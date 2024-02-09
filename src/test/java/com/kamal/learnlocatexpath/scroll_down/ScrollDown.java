package com.kamal.learnlocatexpath.scroll_down;

import com.kamal.learnlocatexpath.BrowserFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class ScrollDown {

    @Test

    void scroll_down(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.credit-agricole.fr/ca-cmds/particulier/compte.html");
       // System.out.println(driver.getCurrentUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        JavascriptExecutor jp = (JavascriptExecutor)driver;
        jp.executeScript("window.scrollBy(0,document.body.scrollHeight)");

    }
}
