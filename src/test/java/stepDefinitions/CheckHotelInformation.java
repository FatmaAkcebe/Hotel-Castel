package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.HotelInformation;
import utilities.ConfigReader;
import utilities.GWD;

import java.util.*;

public class CheckHotelInformation {
    HotelInformation ch = new HotelInformation();

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
                "Anlagenname: Hotel Castle Rastatt",
                "Str./Hausnr.: Niederwaldstr. 2/2",
                "Stadt : Rastatt",
                "PLZ : 76437",
                "Kontaktperson: Castle Hotel Rastatt Team",
                "Telefon: +49 72221590750",
                "E-Mail-Adresse: info@hotel-castle-rastatt.de"
        ));

        Assert.assertTrue(actualDetails.containsAll(expectedDetails));

        ch.scrollToElement(ch.checkInCheckOutText);
        ch.wait.until(ExpectedConditions.visibilityOf(ch.checkInCheckOutText));

        String reservationDetailsText = ch.reservationDetails.getText().trim();
        String[] reservationDetailsArray = reservationDetailsText.split("\n");

        Set<String> expectedreservation = new HashSet<>(Arrays.asList(
                "Anreise: 15:00",
                "Abreise: 11:00"
        ));

        Set<String> actualreservation = new HashSet<>(Arrays.asList(reservationDetailsArray));
        Assert.assertTrue(actualreservation.containsAll(expectedreservation));
    }
}