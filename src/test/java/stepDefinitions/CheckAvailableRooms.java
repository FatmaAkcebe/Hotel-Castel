package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.CheckAvailableRooms_POM;
import utilities.GWD;

public class CheckAvailableRooms {

    CheckAvailableRooms_POM element = new CheckAvailableRooms_POM();

    @Given("The user is on the Reservation page")
    public void theUserIsOnTheReservationPage() {
        GWD.getDriver().get("https://hotel-castle-rastatt.de/");
        element.myClick(element.bookNowButton);
        element.wait.until(ExpectedConditions.visibilityOf(element.checkAvailabilityButton));
    }

    @When("The user selects a check-in date")
    public void theUserSelectsACheckInDate() {
        element.myClick(element.searchStartDate);
        String currentDate = element.searchStartDate.getAttribute("value");

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
        element.searchStartDate.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        element.searchStartDate.sendKeys(newDate);
    }

    @And("The user selects a check-out date later than the check-in date")
    public void theUserSelectsACheckOutDateLaterThanTheCheckInDate() {
        element.myClick(element.searchEndDate);
        String currentDate = element.searchStartDate.getAttribute("value");

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
        element.searchEndDate.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        element.searchEndDate.sendKeys(checkOutDate);
    }

    @Then("A list of available rooms for the selected period should be displayed")
    public void aListOfAvailableRoomsForTheSelectedPeriodShouldBeDisplayed() {
        element.myClick(element.checkAvailabilityButton);
        element.wait.until(ExpectedConditions.visibilityOfAllElements(element.roomTitles));
    }

    @And("Each room should display its type")
    public void eachRoomShouldDisplayItsType() {
        for (WebElement roomTitle : element.roomTitles) {
            Assert.assertTrue(roomTitle.isDisplayed());
            System.out.println(roomTitle.getText());
        }
    }

    @And("Each room should display its price per night")
    public void eachRoomShouldDisplayItsPricePerNight() {
        for (WebElement roomPrice : element.roomPrices) {
            Assert.assertTrue(roomPrice.isDisplayed());
            System.out.println(roomPrice.getText());
        }
    }
}
