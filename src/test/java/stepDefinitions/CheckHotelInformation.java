package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.HotelInformation_POM;
import utilities.ConfigReader;
import utilities.GWD;

import java.util.*;

public class CheckHotelInformation {
    HotelInformation_POM ch = new HotelInformation_POM();

    @Given("The user is on to the Hotel Castle homepage")
    public void theUserIsOnToTheHotelCastleHomepage() {
        GWD.getDriver().get(ConfigReader.getProperty("homepageURL"));
        ch.verifyURL(ConfigReader.getProperty("homepageURL"));
    }

    @When("The user clicks the JETZT BUCHEN button")
    public void theUserClicksTheJETZTBUCHENButton() {
        ch.wait.until(ExpectedConditions.elementToBeClickable(ch.bookNowButton));
        ch.myClick(ch.bookNowButton);
    }

    @Then("The user is redirected to the JETZT BUCHEN booking page")
    public void theUserIsRedirectedToTheJETZTBUCHENBookingPage() {
        ch.wait.until(ExpectedConditions.urlContains("reservation"));
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().contains("reservation"));
    }

    @And("The user checks the hotel information in the Informationen zur Anlage section")
    public void theUserChecksTheHotelInformationInTheInformationenZurAnlageSection() {
        ch.scrollToElement(ch.informationenZurAnlage);
        ch.wait.until(ExpectedConditions.visibilityOf(ch.informationenZurAnlage));

        List<WebElement> hotelDetails = ch.hotelDetails;
        Set<String> actualDetails = new HashSet<>();
        for (WebElement element : hotelDetails) {
            actualDetails.add(element.getText().trim());
        }

        Set<String> expectedDetails = new HashSet<>(Arrays.asList(
                ConfigReader.getProperty("Anlagenname"),
                ConfigReader.getProperty("StrHausnr"),
                ConfigReader.getProperty("Stadt"),
                ConfigReader.getProperty("PLZ"),
                ConfigReader.getProperty("Kontaktperson"),
                ConfigReader.getProperty("Telefon"),
                ConfigReader.getProperty("EmailAdresse")
        ));

        Assert.assertTrue(actualDetails.containsAll(expectedDetails));

        ch.scrollToElement(ch.checkInCheckOutText);
        ch.wait.until(ExpectedConditions.visibilityOf(ch.checkInCheckOutText));

        String reservationDetailsText = ch.reservationDetails.getText().trim();
        String[] reservationDetailsArray = reservationDetailsText.split("\n");

        Set<String> expectedreservation = new HashSet<>(Arrays.asList(
                ConfigReader.getProperty("Anreise"),
                ConfigReader.getProperty("Abreise")
        ));

        Set<String> actualreservation = new HashSet<>(Arrays.asList(reservationDetailsArray));
        Assert.assertTrue(actualreservation.containsAll(expectedreservation));
    }
}