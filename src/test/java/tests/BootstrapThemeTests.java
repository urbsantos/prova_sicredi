package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.AddCustomerPage;
import pages.BootstrapV3ThemePage;
import pages.BootstrapV4ThemePage;
import support.PageObjectTests;
import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

public class BootstrapThemeTests extends PageObjectTests {

    private BootstrapV3ThemePage bootstrapV3ThemePage;
    private BootstrapV4ThemePage bootstrapV4ThemePage;
    private AddCustomerPage addCustomerPage;

    @Override
    public void setup() {
        super.setup();
        bootstrapV3ThemePage = new BootstrapV3ThemePage(driver);
        bootstrapV4ThemePage = new BootstrapV4ThemePage(driver);
        addCustomerPage = new AddCustomerPage(driver);
    }

    @Test
    public void addNewCostumer() throws InterruptedException {
        bootstrapV3ThemePage.
                selectThemeVersion("Bootstrap V4 Theme").
                clickAddCustomer()
                .setAddCustomer("Teste Sicredi",
                        "Teste",
                        "seu nome",
                        "51 9999-9999",
                        "Av Assis Brasil, 3970",
                        "Torre D",
                        "Porto Alegre",
                        "RS",
                        "91000-000",
                        "Brasil",
                        "200")
                .clickSaveButton();

        String expectedMsg = "Your data has been successfully stored into the database";
        String actualMsg = driver.findElement(By.xpath("//*[@id=\"report-success\"]/p")).getText();
        String[] msg= actualMsg.split("\\.");
        String  newMessage = msg[0];

        assertEquals(expectedMsg, newMessage);
    }

    @Test
    public void deleteCostumer() throws InterruptedException {
        bootstrapV3ThemePage.
                selectThemeVersion("Bootstrap V4 Theme").
                clickAddCustomer()
                .setAddCustomer("Teste Sicredi",
                        "Teste",
                        "seu nome",
                        "51 9999-9999",
                        "Av Assis Brasil, 3970",
                        "Torre D",
                        "Porto Alegre",
                        "RS",
                        "91000-000",
                        "Brasil",
                        "200").clickAndGoBackToListButton();

        Thread.sleep(5000);

        bootstrapV4ThemePage.findCustomerByName("Teste Sicredi");

        Thread.sleep(5000);

        bootstrapV4ThemePage.clickSelectAllComboBox().clickDeleteButton();

        Thread.sleep(5000);

        bootstrapV4ThemePage.verifyConfirmToDeletePopupText();

        Thread.sleep(2000);

        bootstrapV4ThemePage.clickPopupDeleteButton();

        Thread.sleep(2000);

        bootstrapV4ThemePage.verifyCostumerDeletedSuccessfullyMsg();

    }

}
