package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.BasePage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class AddCustomerPage extends BasePage {

    public AddCustomerPage(WebDriver driver) {
        super(driver);
    }

    public void typeFirstName(String firstName){
        typeFieldById(firstName, "field-customerName");
    }

    public void typeLastName(String lastName){
        typeFieldById(lastName, "field-contactLastName");
    }

    public void typeContactFirstName(String contactFirstName){
        typeFieldById(contactFirstName, "field-contactFirstName");
    }

    public void typePhone(String phone){
        typeFieldById(phone, "field-phone");
    }

    public void typeAddressLine1(String addressLine1){
        typeFieldById(addressLine1, "field-addressLine1");
    }

    public void typeAddressLine2(String addressLine2){
        typeFieldById(addressLine2, "field-addressLine2");
    }

    public void typeCity(String city){
        typeFieldById(city, "field-city");
    }

    public void typeState(String state){
        typeFieldById(state, "field-state");
    }

    public void typePostalCode(String postalCode){
        typeFieldById(postalCode, "field-postalCode");
    }

    public void typePostalCountry(String country){
        typeFieldById(country, "field-country");
    }

    public void selectEmployer(){
        clickCombobox("field_salesRepEmployeeNumber_chosen");
        selectComboBoxItem("//div[@class='chosen-drop']//ul[@class='chosen-results']/li[8]");
    }

    public void typeCreditLimit(String creditLimit){
        typeFieldById(creditLimit, "field-creditLimit");
    }

    public AddCustomerPage setAddCustomer(String firstName, String lastName, String contactFirstName, String phone, String addressLine1,
                                          String addressLine2, String city, String state, String postalCode,
                                          String country, String creditLimit){
        typeFirstName(firstName);
        typeLastName(lastName);
        typeContactFirstName(contactFirstName);
        typePhone(phone);
        typeAddressLine1(addressLine1);
        typeAddressLine2(addressLine2);
        typeCity(city);
        typeState(state);
        typePostalCode(postalCode);
        typePostalCountry(country);
        selectEmployer();
        typeCreditLimit(creditLimit);

        return this;
    }

    public void clickSaveButton(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        clickButtonByID("form-button-save");
    }

    public void clickAndGoBackToListButton(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        clickButtonByID("save-and-go-back-button");
    }

    public void verifyMsg(String expectedMsg){
        String actualMsg = driver.findElement(By.xpath("//*[@id=\"report-success\"]/p")).getText();
        String[] msg= actualMsg.split("\\.");
        String  newMessage = msg[0];

        assertEquals(expectedMsg, newMessage);

    }

}
