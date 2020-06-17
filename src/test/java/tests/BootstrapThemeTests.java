package tests;

import org.junit.Test;
import pages.AddCustomerPage;
import pages.BootstrapV3ThemePage;
import pages.BootstrapV4ThemePage;
import support.PageObjectTests;

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

        addCustomerPage.verifyMsg("Your data has been successfully stored into the database");
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

//        Thread.sleep(5000);
//
//        bootstrapV4ThemePage.verifyConfirmToDeletePopupText();
//
//        Thread.sleep(2000);
//
//        bootstrapV4ThemePage.clickPopupDeleteButton();
//
//        Thread.sleep(2000);
//
//        bootstrapV4ThemePage
//                .verifyCostumerDeletedSuccessfullyMsg(
//                        "Your data has been successfully deleted from the database.");

    }

}
