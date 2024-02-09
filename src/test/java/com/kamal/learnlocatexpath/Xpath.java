package com.kamal.learnlocatexpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;

public class Xpath {

    @Test
    void xpath() {
        WebDriver driver;
        driver = BrowserFactory.getDriver("Chrome");
        driver.get("https://fb.com/");
//    By locate = By.xpath("//a[normalize-space()='Create new account']");
//    WebElement we = wd.findElement(locate);
//    we.click();

        WebElement we = driver.findElement(By.xpath("//a[normalize-space()='Create new account']"));
        we.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        //By locate1 = By.xpath("//input [contains(@name,'name')]");
        By locate2 = By.xpath("//input[starts-with(@name,'firstn')]");
        WebElement text_box = driver.findElement(locate2);
        text_box.sendKeys("Envision");
        // for mobile no or email:
        WebElement mobile_email = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        mobile_email.sendKeys("4236786545");

        //WebElement text1= wd.findElement(By.xpath("//input[@name='firstname']")).sendKeys("abc");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.close();
        driver.quit();

    }

    @Test
    void count_links() {
        WebDriver driver = BrowserFactory.getDriver("Chrome");
        driver.get("https://fb.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Collection<WebElement> all_links = driver.findElements(By.tagName("a"));
        System.out.println("Links in Total: " + all_links.size());
        for (WebElement s : all_links) {
            System.out.println(s.getText());
        }
        driver.close();
        driver.quit();


    }

    @Test
    void language_links() {
        WebDriver driver;
        driver = BrowserFactory.getDriver("Chrome");
        driver.get("https://fb.com/");


        Collection<WebElement> lang_links = driver.findElements(By.xpath("//div[@id='pageFooter']/ul/li"));
        System.out.println("Language count: " + lang_links.size());
        for (WebElement lang : lang_links) {
            System.out.println(lang.getText());
        }

        driver.close();
        driver.quit();

    }
    @Test
    void drop_down() {
        WebDriver driver;
        driver = BrowserFactory.getDriver("Chrome");
        driver.get("https://fb.com/");

        WebElement we = driver.findElement(By.xpath("//a[normalize-space()='Create new account']"));
        we.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        //select day
        WebElement date = driver.findElement(By.id("day"));
        Select day_selection = new Select(date);
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        day_selection.selectByIndex(14);  // selecting date 15

        // select month
        WebElement month = driver.findElement(By.id("month"));
        Select select_month = new Select(month);
        select_month.selectByValue("3"); // selecting march

        //select year
        WebElement year = driver.findElement(By.id("year"));
        Select select_year = new Select(year);
       // select_year.selectByIndex(1); // picking 2022 year
        //select_year.selectByIndex(2); // picking 2021 year
        select_year.selectByIndex(5); // picking 2018 year
    }
    @Test
    void validate(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://fb.com/");
        Collection<WebElement> link = driver.findElements(By.xpath("//div[@id='pageFooter']/ul/li"));
        System.out.println(link.size());
        int c=0;
        for(WebElement w: link){
            System.out.println(w.getText());
            c++;
            if(w.getText().equalsIgnoreCase("हिन्दी")){
                System.out.println("Location is: " + c);
            }
        }
        WebElement locate_hindi_link= driver.findElement(By.xpath("//a[@title='Hindi']"));
        locate_hindi_link.click();
//        for(WebElement w: link){
//          //  System.out.println(w.getText());//            try{//   WebElement wb = w.findElement(By.tagName("a"));
//            } catch (Exception e){
//              //  System.out.println("Link is not a link" + e.getMessage());
//                System.out.println("first tag is not a link");
//            }
//        }
        WebElement nonClicbaleHindi = driver.findElement(By.xpath("//div[@id='pageFooter']/ul/li[not(a)]"));
        Assert.assertTrue(nonClicbaleHindi.isDisplayed());
        driver.close();
        driver.quit();

    }

}