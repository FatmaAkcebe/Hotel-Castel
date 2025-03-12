package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import utilities.GWD;

public class CheckAvailableRooms {

    DialogContent dc = new DialogContent();

    @Given("The user is on the Reservation page")
    public void theUserIsOnTheReservationPage() {
        GWD.getDriver().get("https://hotel-castle-rastatt.de/");
        dc.myClick(dc.bookNowButton);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.checkAvailabilityButton));
    }

    @When("The user selects a check-in date")
    public void theUserSelectsACheckInDate() {
        dc.myClick(dc.searchStartDate);
        String currentDate = dc.searchStartDate.getAttribute("value");

        String[] dateParts = currentDate.split("/");
        int day = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int year = Integer.parseInt(dateParts[2]);

        day += 1;
        if (day > 30) {
            day = 1;
            month += 1;
            if (month > 12) {
                month = 1;
                year += 1;
            }
        }

        String newDate = String.format("%02d/%02d/%d", day, month, year);
        dc.searchStartDate.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        dc.searchStartDate.sendKeys(newDate);
    }

    @And("The user selects a check-out date later than the check-in date")
    public void theUserSelectsACheckOutDateLaterThanTheCheckInDate() {
        dc.myClick(dc.searchEndDate);
        String currentDate = dc.searchStartDate.getAttribute("value");

        String[] dateParts = currentDate.split("/");
        int day = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int year = Integer.parseInt(dateParts[2]);

        day += 2;
        if (day > 30) {
            day = 1;
            month += 1;
            if (month > 12) {
                month = 1;
                year += 1;
            }
        }

        String checkOutDate = String.format("%02d/%02d/%d", day, month, year);
        dc.searchEndDate.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        dc.searchEndDate.sendKeys(checkOutDate);
    }

    @Then("A list of available rooms for the selected period should be displayed")
    public void aListOfAvailableRoomsForTheSelectedPeriodShouldBeDisplayed() {
        dc.myClick(dc.checkAvailabilityButton);
        dc.wait.until(ExpectedConditions.visibilityOfAllElements(dc.roomTitles));
    }

    @And("Each room should display its type")
    public void eachRoomShouldDisplayItsType() {
        for (WebElement roomTitle : dc.roomTitles) {
            Assert.assertTrue(roomTitle.isDisplayed());
            System.out.println(roomTitle.getText());
        }
    }

    @And("Each room should display its price per night")
    public void eachRoomShouldDisplayItsPricePerNight() {
        for (WebElement roomPrice : dc.roomPrices) {
            Assert.assertTrue(roomPrice.isDisplayed());
            System.out.println(roomPrice.getText());
        }
    }
}
