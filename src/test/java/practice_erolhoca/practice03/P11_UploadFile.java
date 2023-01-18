package practice_erolhoca.practice03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;

public class P11_UploadFile extends TestBase {

    //https://demo.guru99.com/test/upload/ adresine gidiniz
    //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
    // I accept terms of service bölümünü tikleyin
    // Submit File buttonuna basınız
    // "1 file has been successfully uploaded" görünür olduğunu test edin


    @Test
    public void fileUpload() {

        //https://demo.guru99.com/test/upload/ adresine gidiniz
        driver.get("https://demo.guru99.com/test/upload/");

        //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
        String file =System.getProperty("user.home");
        String dosyaYolu = "\\OneDrive\\Masaüstü\\logo.jpeg";

        findId("uploadfile_0").sendKeys(file+dosyaYolu);

        // I accept terms of service bölümünü tikleyin
        driver.findElement(By.id("terms")).click();

        // Submit File buttonuna basınız
        driver.findElement(By.id("submitbutton")).click();

        // "1 file has been successfully uploaded" görünür olduğunu test edin
        WebElement text = findId("res");
        System.out.println(text.getText());

        Assert.assertTrue(text.isDisplayed());
    }
}
