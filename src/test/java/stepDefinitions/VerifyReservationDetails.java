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
    private final String expectedGuestName = ConfigReader.getProperty("firstName") + " " + ConfigReader.getProperty("lastName");
    private final String expectedAdults = ConfigReader.getProperty("adults");
    private final String expectedChildren = ConfigReader.getProperty("children");
    private final String expectedCheckInDate = ConfigReader.getProperty("checkInDate");
    private final String expectedCheckOutDate = ConfigReader.getProperty("checkOutDate");
    private final String expectedTotalPrice = ConfigReader.getProperty("price").replaceAll("[^0-9,]", "");

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

        verifyDetails(expectedRoomType, element.roomType);
        verifyDetails(expectedGuestName, element.guestName);
        verifyDetails(expectedAdults, element.adult);
        verifyDetails(expectedChildren, element.children);
        verifyDetails(expectedCheckInDate, element.checkInDate);
        verifyDetails(expectedCheckOutDate, element.checkOutDate);

        String actualTotalPrice = element.getTextUsingJS(element.inTotal).replaceAll("[^0-9,]", "");
        logComparison(expectedTotalPrice, actualTotalPrice);
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
    }

    private void verifyDetails(String expectedText, WebElement webElement) {
        String actualText = element.getTextUsingJS(webElement).trim();
        logComparison(expectedText, actualText);
        Assert.assertEquals(actualText, expectedText);
    }

    private void logComparison(String expected, String actual) {
        System.out.printf("%-40s%-40s%n", "Expected Info= " + expected, "Actual Info= " + actual);
    }
}
