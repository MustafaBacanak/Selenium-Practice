package practice_canhoca;

import  org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class Q05 extends TestBase {
    @Test
    public void test05() {

        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");
        Actions actions = new Actions(driver);

        //Alerts, Frame & Windows Butonuna click yap
        waitFor(2);
        WebElement aFW = driver.findElement(By.xpath("(//h5)[3]"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(3);
        aFW.click();
        waitFor(2);

        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        WebElement text1 =driver.findElement(By.cssSelector("div[class='col-12 mt-4 col-md-6']"));
        Assert.assertTrue(text1.isDisplayed());
        waitFor(2);

        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        WebElement bW = driver.findElement(By.xpath("//*[text()='Browser Windows']"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);
        bW.click();

        //New Tab butonunun görünür olduğunu doğrula
        WebElement newTab = driver.findElement(By.id("tabButton"));
        Assert.assertTrue(newTab.isDisplayed());
        waitFor(2);

        //New Tab butonuna click yap
        newTab.click();
        waitFor(2);

        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        String ilkSfHandle = driver.getWindowHandle();

        Set<String> allWindow= driver.getWindowHandles();
        for (String w : allWindow){
            if(!w.equals(ilkSfHandle)){
                driver.switchTo().window(w);
            }
        }
        waitFor(2);

        //İlk Tab'a geri dön
        driver.switchTo().window(ilkSfHandle);
        waitFor(2);

        ////New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(newTab.isDisplayed());

    }
}
