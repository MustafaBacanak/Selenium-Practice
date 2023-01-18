package practice_erolhoca.practice03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class P09_ExplicitWait extends TestBase {

    @Test
    public void explicitWaitTest() {
        //https://automationfc.github.io/dynamic-loading/ sayfasına gidelim
        driver.get("https://automationfc.github.io/dynamic-loading/");

        //Start button'nuna basalım
        driver.findElement(By.xpath("//*[text()='Start']")).click();

        //Hello World! yazısının çıktığını doğrulayalım
        WebElement helloWorldText = driver.findElement(By.xpath("//*[text()='Hello World!']"));
        WebElement loadingText = driver.findElement(By.xpath("//div[@id='loading']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

//        wait.until(ExpectedConditions.visibilityOf(helloWorldText));
        wait.until(ExpectedConditions.invisibilityOf(loadingText));
        Assert.assertTrue(helloWorldText.isDisplayed());
    }
}

