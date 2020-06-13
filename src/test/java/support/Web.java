package support;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Web {
    private static final String ADDRESS = "https://www.grocerycrud.com/demo/bootstrap_theme";

    static WebDriver createChrome() {
        System.setProperty("webdriver.chrome.driver", ".\\libs\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return getDriverConfigured(driver);
    }

    private static WebDriver getDriverConfigured(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ADDRESS);

        return driver;
    }

}