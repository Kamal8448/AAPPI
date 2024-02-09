package upload_file;

import com.kamal.learnlocatexpath.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Upload_File {
    WebDriver driver = null;

    @Test
    void upload_file() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.naukri.com/registration/createAccount?othersrcp=22636");
        WebElement upload_locator = driver.findElement(By.xpath("//button[normalize-space()='Upload Resume']"));
        upload_locator.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String location = "F:\\May23 Batch\\Automation\\Practical\\seleniumbasics\\sample.pdf";
        StringSelection s = new StringSelection(location);

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null); // clipboard copy ctrl+c
        try {
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_V);
            r.keyRelease(KeyEvent.VK_CONTROL);
            r.keyRelease(KeyEvent.VK_ENTER);
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
           // driver.quit();
    }
}
