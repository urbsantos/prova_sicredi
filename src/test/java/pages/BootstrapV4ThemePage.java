package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.BasePage;

public class BootstrapV4ThemePage extends BasePage {

    public BootstrapV4ThemePage(WebDriver driver) {
        super(driver);
    }

    public AddCustomerPage clickAddCustomer(){
        return clickButtonByXpath("//a[contains(@href, '/demo/bootstrap_theme_v4/add')]",
                new AddCustomerPage(driver));
    }

}
