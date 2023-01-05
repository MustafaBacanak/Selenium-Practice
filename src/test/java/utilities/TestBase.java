package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class TestBase {

    //Js Executer
    JavascriptExecutor js = (JavascriptExecutor) driver;

    //WebElement elementName = driver.findElement(By.xpath("(//h5)[3]"));
    //js.executeScript("arguments[0].click();",elementName);

    //  driver objesini olustur.
    protected static WebDriver driver;

    //  setUp
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    //  tearDown
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
//        driver.quit();
    }

    //    MULTIPLE WINDOW
    public static void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }

    public static void switchToWindowUrl(String targetUrl) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getCurrentUrl().equals(targetUrl)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }
    public static void clickWithText(String key, String text){


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        List<WebElement> element = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector(key))));

        for (int i = 0; i < element.size(); i++) {
            if (element.get(i).getText().equals(text)){
                element.get(i).click();
            }
        }
//        for (WebElement w : options){
//            if (w.getText().equals(text)){
//                w.click();
//            }
//        }
    }
}
