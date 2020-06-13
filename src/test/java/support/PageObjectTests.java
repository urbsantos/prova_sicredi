package support;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class PageObjectTests {

    protected WebDriver driver;

    @Before
    public void setup(){
        driver = Web.createChrome();
    }

//    @After
//    public void tearDown(){
//        driver.quit();
//    }


}
