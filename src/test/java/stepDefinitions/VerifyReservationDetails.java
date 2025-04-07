package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.VerifyReservationDetails_POM;
import utilities.ConfigReader;

public class VerifyReservationDetails {

    VerifyReservationDetails_POM element = new VerifyReservationDetails_POM();

    private final String expectedRoomType = ConfigReader.getProperty("roomTitle");
    private final String expectedAdults = ConfigReader.getProperty("adults");
    private final String expectedChildren = ConfigReader.getProperty("children");
    private final String expectedCheckInDate = ConfigReader.getProperty("checkInDate");
    private final String expectedCheckOutDate = ConfigReader.getProperty("checkOutDate");
    private final String expectedTotalPrice = ConfigReader.getProperty("price").replaceAll("[^0-9,]", "");
    private final String expectedGuestName = ConfigReader.getProperty("firstName") + " " + ConfigReader.getProperty("lastName");


    @When("The user reaches the reservation details page")
    public void theUserReachesTheReservationDetailsPage() {
        element.wait.until(ExpectedConditions.urlContains("confirmation"));
        Assert.assertTrue(element.getCurrentURL().contains("confirmation"));

        element.wait.until(ExpectedConditions.visibilityOf(element.vielenDankText));
        element.verifyContainsText(element.vielenDankText, "Vielen Dank");
    }

    @Then("The reservation details on the page should match the previously entered information")
    public void theReservationDetailsShouldMatchThePreviousInfo() {
        String actualResNumber = element.resNumber.getText().trim();
        ConfigReader.saveToConfig("reservationNumber", actualResNumber);
        Assert.assertFalse(actualResNumber.isEmpty());

        verifyDetails("Adults", expectedAdults, element.adult);
        verifyDetails("Children", expectedChildren, element.children);
        verifyDetails("Room Type", expectedRoomType, element.roomType);
        verifyDetails("Guest Name", expectedGuestName, element.guestName);
        verifyDetails("Check-In Date", expectedCheckInDate, element.checkInDate);
        verifyDetails("Check-Out Date", expectedCheckOutDate, element.checkOutDate);

        String actualTotalPrice = element.getTextUsingJS(element.inTotal).replaceAll("[^0-9,]", "");
        logVerificationInfo("Total Price", expectedTotalPrice, actualTotalPrice);
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
    }

    private void verifyDetails(String fieldName, String expectedText, WebElement webElement) {
        String actualText = element.getTextUsingJS(webElement).trim();
        logVerificationInfo(fieldName, expectedText, actualText);
        Assert.assertEquals(actualText, expectedText);
    }

    private void logVerificationInfo(String fieldName, String expected, String actual) {
        System.out.println(" Expected " + fieldName + " = " + expected);
        System.out.println(" Actual " + fieldName + " = " + actual);
    }
}