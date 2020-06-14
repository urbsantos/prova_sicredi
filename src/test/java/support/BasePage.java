package support;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver){

        this.driver = driver;
    }


    public <T> T selectComboBoxById(String value, String id, T type){
        if (value != null) {
            WebElement chooseOption = driver.findElement(By.id(id));
            new Select(chooseOption).selectByVisibleText(value);
        }
        return type;
    }

    public <T> T selectComboBoxByXpath(String value, String xpath, T type){
        if (value != null) {
            WebElement chooseOption = driver.findElement(By.xpath(xpath));
            new Select(chooseOption).selectByVisibleText(value);
        }
        return type;
    }


    public <T> T selectRadioButtonById(String value, String id, T type){
        if(value != null){
            WebElement radio = driver.findElement(By.id(id));
            radio.sendKeys(Keys.SPACE);
            radio.click();
        }
        return type;
    }


    public <T> T selectRadioButtonByXpath(String value, String xpath, T type) {
        if (value != null) {
            WebElement radio = driver.findElement(By.xpath(xpath));
            radio.sendKeys(Keys.SPACE);
            radio.click();
        }
        return type;
    }


    public <T> T clickButtonByXpath(String xpath, T type){
        driver.findElement(By.xpath(xpath)).click();
        return type;
    }

    public <T> T clickButtonByID(String id, T type){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.id(id)).click();
        return type;
    }

    public <T> T clickButtonByLinkText(String linkText, T type){
        driver.findElement(By.linkText(linkText)).click();
        return type;
    }


    public <T> T typeFieldById(String value, String id, T type) {
        driver.findElement(By.id(id)).clear();
        driver.findElement(By.id(id)).sendKeys(value);
        return type;
    }

    public <T> T typeFieldByXpath(String value, String xpath, T type) {
        driver.findElement(By.xpath(xpath)).clear();
        driver.findElement(By.xpath(xpath)).sendKeys(value);
        return type;
    }

    public <T> T clickCombobox(String id, T type){
        driver.findElement(By.id(id)).click();
        return type;
    }

    public <T> T selectComboBoxItem(String xpath, T type){
        driver.findElement(By.xpath(xpath)).click();
        return type;
    }

    public String getTextById(String id) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver.findElement(By.id(id)).getText();
    }


}

