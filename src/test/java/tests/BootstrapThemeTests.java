package tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.AddCustomerPage;
import pages.BootstrapV3ThemePage;
import pages.BootstrapV4ThemePage;
import support.PageObjectTests;

import static org.junit.runners.MethodSorters.NAME_ASCENDING;

@FixMethodOrder(NAME_ASCENDING)
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
    public void testOrder_2_addNewCostumer() throws InterruptedException {
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

        addCustomerPage.verifyMsg("Your data has been successfully stored into the database");
    }

    @Test
    public void testOrder_1_deleteCostumer() throws InterruptedException {
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

        bootstrapV4ThemePage.waitConfirmToDeletePopupText();

        Assert.assertEquals("Are you sure that you want to delete this 1 item?",
                bootstrapV4ThemePage.verifyConfirmToDeletePopupText());

        Thread.sleep(2000);

        bootstrapV4ThemePage.clickConfirmDeleteButton();

        Thread.sleep(2000);

        bootstrapV4ThemePage.waitCostumerDeletedSuccessfullyMsg();

        Thread.sleep(2000);

        Assert.assertEquals("Your data has been successfully deleted from the database.",
                bootstrapV4ThemePage.verifyCostumerDeletedSuccessfullyMsg());

    }

}
