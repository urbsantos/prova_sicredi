package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.BasePage;

public class BootstrapV4ThemePage extends BasePage {

    public BootstrapV4ThemePage(WebDriver driver) {
        super(driver);
    }

    public AddCustomerPage clickAddCustomer(){
        return clickButtonByXpath("//a[contains(@href, '/demo/bootstrap_theme_v4/add')]",
                new AddCustomerPage(driver));
    }

    public void findCustomerByName(String value){
        WebElement find = driver.findElement(By.xpath("//input[contains(@name, 'customerName')]"));
        find.clear();
        find.click();
        find.sendKeys(value);
        find.sendKeys(Keys.ENTER);
    }

    public BootstrapV4ThemePage clickSelectAllComboBox(){
        return clickButtonByXpath("//input[contains(@class, 'select-all-none')]", this);
    }

    public void clickDeleteButton(){
        clickButtonByLinkText("Delete");
    }

    public void clickConfirmDeleteButton(){
        clickButtonByXpath("//button[contains(@class, 'delete-multiple-confirmation-button')]", this);
    }

    public void waitConfirmToDeletePopupText(){
        getAlertMessage("//p[contains(@class, 'alert-delete-multiple-one')]");

    }

    public String verifyConfirmToDeletePopupText(){
        WebElement popUpDeleteText = driver.findElement(By.xpath("//p[contains(@class, 'alert-delete-multiple-one')]"));
        return popUpDeleteText.getText();
    }

    public void waitCostumerDeletedSuccessfullyMsg(){
        getAlertMessage("//div[contains(@class, 'alert-success')]");

    }

    public String verifyCostumerDeletedSuccessfullyMsg(){
        WebElement deleteConfirmation = driver.findElement(By.xpath("//div[contains(@class, 'alert-success')]//p"));
        return deleteConfirmation.getText();
    }

}
