package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.RoomReservation_POM;
import utilities.ConfigReader;

public class RoomReservation {
    RoomReservation_POM element=new RoomReservation_POM();

    @And("The user fills out the form with the contact information")
    public void theUserFillsOutTheFormWithTheContactInformation() {
        element.wait.until(ExpectedConditions.urlContains("reservation"));
        element.getCurrentURL().contains("reservation");

        if(element.kasseText.isDisplayed()){
            element.verifyContainsText(element.kasseText,"KASSE");

            ConfigReader.updateProperty("firstName");
            element.mySendKeys(element.firstName,ConfigReader.getProperty("firstName"));
            ConfigReader.updateProperty("lastName");
            element.mySendKeys(element.lastName,ConfigReader.getProperty("lastName"));
            ConfigReader.updateProperty("email");
            element.mySendKeys(element.email,ConfigReader.getProperty("email"));
            ConfigReader.updateProperty("phone");
            element.mySendKeys(element.phone,ConfigReader.getProperty("phone"));

            element.selectMenu(element.selectCountryMenu,element.selectCountry);

            ConfigReader.updateProperty("PLZ");
            element.mySendKeys(element.zipCode,ConfigReader.getProperty("PLZ"));
            ConfigReader.updateProperty("address1");
            element.mySendKeys(element.address1,ConfigReader.getProperty("address1"));
            ConfigReader.updateProperty("address2");
            element.mySendKeys(element.address2,ConfigReader.getProperty("address2"));
            ConfigReader.updateProperty("city");
            element.mySendKeys(element.city,ConfigReader.getProperty("city"));

            element.selectMenu(element.selectStateMenu,element.selectState);

            ConfigReader.updateProperty("gastName");
            element.mySendKeys(element.gastName,ConfigReader.getProperty("gastName"));
            ConfigReader.updateProperty("orderNumber");
            element.mySendKeys(element.auftragsnummer,ConfigReader.getProperty("orderNumber"));
            ConfigReader.updateProperty("vatID");
            element.mySendKeys(element.vatID,ConfigReader.getProperty("vatID"));
            ConfigReader.updateProperty("costCenter");
            element.mySendKeys(element.kostenstelle,ConfigReader.getProperty("costCenter"));
            ConfigReader.updateProperty("referans");
            element.mySendKeys(element.referenz,ConfigReader.getProperty("referans"));
        }
    }

    @Then("The user clicks on the confirmation button and verifies the confirmation message")
    public void theUserClicksOnTheConfirmationButtonAndVerifiesTheConfirmationMessage() {
        element.wait.until(ExpectedConditions.visibilityOf(element.acceptTextControl));
        element.verifyContainsText(element.acceptTextControl,"Ich stimme den");
        element.myClick(element.agreeTermsCheckBox);
        element.myClick(element.reservierungBtn);

        element.getCurrentURL().contains("confirmation");
        element.wait.until(ExpectedConditions.visibilityOf(element.vielenDankText));
        element.verifyContainsText(element.vielenDankText,"Vielen Dank");
    }
}
