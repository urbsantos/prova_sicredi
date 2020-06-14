package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import support.BasePage;

import java.util.concurrent.TimeUnit;

public class BootstrapV3ThemePage extends BasePage {

    public BootstrapV3ThemePage(WebDriver driver) {
        super(driver);
    }

    public BootstrapV4ThemePage selectThemeVersion(String version){
        return selectComboBoxById(version, "switch-version-select", new BootstrapV4ThemePage(driver));
    }

}
