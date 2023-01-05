package practice_canhoca;

import  org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class Q05 extends TestBase {
    @Test
    public void test05() throws InterruptedException {

        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");
        Actions actions = new Actions(driver);

        //Alerts, Frame & Windows Butonuna click yap
        Thread.sleep(2000);
        WebElement aFW = driver.findElement(By.xpath("(//h5)[3]"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        aFW.click();

        Thread.sleep(2000);

        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        WebElement text1 =driver.findElement(By.cssSelector("div[class='col-12 mt-4 col-md-6']"));
        Assert.assertTrue(text1.isDisplayed());
        Thread.sleep(2000);

        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        WebElement bW = driver.findElement(By.xpath("//*[text()='Browser Windows']"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        bW.click();

        //New Tab butonunun görünür olduğunu doğrula
        WebElement newTab = driver.findElement(By.id("tabButton"));
        Assert.assertTrue(newTab.isDisplayed());
        Thread.sleep(2000);

        //New Tab butonuna click yap
        newTab.click();
        Thread.sleep(2000);

        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        String ilkSfHandle = driver.getWindowHandle();

        Set<String> allWindow= driver.getWindowHandles();
        for (String w : allWindow){
            if(!w.equals(ilkSfHandle)){
                driver.switchTo().window(w);
            }
        }
        Thread.sleep(2000);

        //İlk Tab'a geri dön
        driver.switchTo().window(ilkSfHandle);
        Thread.sleep(2000);

        ////New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(newTab.isDisplayed());

    }
}
