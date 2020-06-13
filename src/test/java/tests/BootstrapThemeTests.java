package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.AddCustomerPage;
import pages.BootstrapV3ThemePage;
import support.PageObjectTests;

import static org.junit.Assert.assertEquals;

public class BootstrapThemeTests extends PageObjectTests {

    private BootstrapV3ThemePage bootstrapThemePage;
    private AddCustomerPage addCustomerPage;

    @Override
    public void setup() {
        super.setup();
        bootstrapThemePage = new BootstrapV3ThemePage(driver);
        bootstrapThemePage.
                selectThemeVersion("Bootstrap V4 Theme").clickAddCustomer();
    }

    @Test
    public void addNewCostumerBootstrapV4Theme(){

                addCustomerPage
                .setAddCustomer("Urbano", "Santos", "81999991111", "Rua 01",
                        "N 001", "Recife", "PE", "51000-000",
                        "Brasil", "10000")
                .clickSaveAndGoBackToListButton();


        Assert.assertEquals("Your data has been successfully stored into the database. Edit Customer or Go back to list", msg);
    }

}
