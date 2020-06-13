package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.BootstrapV3ThemePage;
import support.PageObjectTests;

import static org.junit.Assert.assertEquals;

public class BootstrapThemeTests extends PageObjectTests {

    private BootstrapV3ThemePage bootstrapThemePage;

    @Override
    public void setup() {
        super.setup();
        bootstrapThemePage = new BootstrapV3ThemePage(driver);
    }

    @Test
    public void addNewCostumerBootstrapV4Theme(){
        bootstrapThemePage.
                selectThemeVersion("Bootstrap V4 Theme").
                clickAddCustomer()
                .setAddCustomer("Urbano", "Santos", "81999991111", "Rua 01",
                        "N 001", "Recife", "PE", "51000-000",
                        "Brasil", "10000")
                .clickSaveAndGoBackToListButton();

    }
}
