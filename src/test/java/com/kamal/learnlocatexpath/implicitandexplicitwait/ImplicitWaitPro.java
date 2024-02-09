package com.kamal.learnlocatexpath.implicitandexplicitwait;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ImplicitWaitPro {
WebDriver driver=null;

public  void openBrowser(){
    driver= new ChromeDriver();
    driver.get("https://demo.actitime.com/login.do");
}
    @Test
    public void takeScreenshot(){
         openBrowser();
        TakesScreenshot tc = (TakesScreenshot)driver;
        File src = tc.getScreenshotAs(OutputType.FILE);
        File des = new File("basics_screenshot\\"+ "abc.png");
        try {
            FileUtils.copyFile(src,des);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
