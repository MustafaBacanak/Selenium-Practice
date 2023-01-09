package practice_canhoca;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q07 extends TestBase {

    @Test
    public void test01() {
        Actions actions =new Actions(driver);

    //  #go to url : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

    //  #Fill in capitals by country

        WebElement oslo = findId("box1");
        WebElement norway = findId("box101");
        actions.dragAndDrop(oslo,norway).perform();

        WebElement stockholm = findId("box2");
        WebElement sweden = findId("box102");
        actions.dragAndDrop(stockholm,sweden).perform();

        WebElement washington = findId("box3");
        WebElement unitedStates = findId("box103");
        actions.dragAndDrop(washington,unitedStates).perform();

        WebElement copenhagen = findId("box4");
        WebElement denmark = findId("box104");
        actions.dragAndDrop(copenhagen,denmark).perform();

        WebElement seoul = findId("box5");
        WebElement southKorea = findId("box105");
        actions.dragAndDrop(seoul,southKorea).perform();

        WebElement rome = findId("box6");
        WebElement italy = findId("box106");
        actions.dragAndDrop(rome,italy).perform();

        WebElement madrid = findId("box7");
        WebElement spain = findId("box107");
        actions.dragAndDrop(madrid,spain).perform();

    }
}
