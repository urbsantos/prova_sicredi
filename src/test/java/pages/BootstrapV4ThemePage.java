package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.BasePage;

public class BootstrapV4ThemePage extends BasePage {

    public BootstrapV4ThemePage(WebDriver driver) {
        super(driver);
    }

    public AddCustomerPage clickAddCustomer(){
        return clickButtonByXpath("//a[contains(@href, '/demo/bootstrap_theme_v4/add')]",
                new AddCustomerPage(driver));
    }

    public BootstrapV4ThemePage findCustomerByName(String value){
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return typeFieldByXpath(value, "//input[contains(@name, 'customerName')]", this);
    }

    public BootstrapV4ThemePage clickSelectAllComboBox(){
        return clickButtonByXpath("//input[contains(@class, 'select-all-none')]", this);
    }

    public BootstrapV4ThemePage clickDeleteButton(){
        return clickButtonByLinkText("Delete", this);
    }

    public void verifyConfirmToDeletePopupText(){
        WebElement popUpDeleteText = driver.findElement(By.xpath("//p[contains(@class, 'alert-delete-multiple-one')]"));
        String text = popUpDeleteText.getText();

        Assert.assertTrue(text.contentEquals("Are you sure that you want to delete this 1 item?"));
    }

    public BootstrapV4ThemePage clickPopupDeleteButton(){
        return clickButtonByXpath("//button[contains(@class, 'delete-multiple-confirmation-button')]", this);
    }

    public void verifyCostumerDeletedSuccessfullyMsg(){
        WebElement deleteConfirmation = driver.findElement(By.xpath("//div[contains(@class, 'alert-success')]"));
        String text = deleteConfirmation.getText();

        Assert.assertTrue(text.contentEquals("Your data has been successfully deleted from the database."));
    }

}
