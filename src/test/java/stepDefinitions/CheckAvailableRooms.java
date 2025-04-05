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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CheckAvailableRooms {

    CheckAvailableRooms_POM element = new CheckAvailableRooms_POM();
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    @Given("The user is on the Reservation page")
    public void theUserIsOnTheReservationPage() {
        GWD.getDriver().get("https://hotel-castle-rastatt.de/");
        element.myClick(element.bookNowButton);
        element.wait.until(ExpectedConditions.visibilityOf(element.checkAvailabilityButton));
        ReservationInfoCheck.setCheckAvailableRooms(this);
    }

    @When("The user selects a check-in date")
    public void theUserSelectsACheckInDate() {
        element.myClick(element.searchStartDate);
        element.searchStartDate.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        String checkIn = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        element.searchStartDate.sendKeys(checkIn);
        checkInDate = LocalDate.parse(checkIn, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    @And("The user selects a check-out date later than the check-in date")
    public void theUserSelectsACheckOutDateLaterThanTheCheckInDate() {
        element.myClick(element.searchEndDate);
        element.searchEndDate.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        String checkOut = getDate(2);
        element.searchEndDate.sendKeys(checkOut);
        checkOutDate = LocalDate.parse(checkOut, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    @Then("A list of available rooms for the selected period should be displayed")
    public void aListOfAvailableRoomsForTheSelectedPeriodShouldBeDisplayed() {
        boolean invalidDate;

        do {
            element.myClick(element.checkAvailabilityButton);
            element.wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfAllElements(element.roomTitles),
                    ExpectedConditions.visibilityOf(element.errorMsg)
            ));

            invalidDate = element.errorMsg.isDisplayed();
            if (invalidDate) {
                element.searchStartDate.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
                checkInDate = checkInDate.plusDays(2);
                element.searchStartDate.sendKeys(checkInDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                element.searchEndDate.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
                checkOutDate = checkOutDate.plusDays(4);
                element.searchEndDate.sendKeys(checkOutDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            }
        } while (invalidDate);
    }

    @And("Each room should display its type")
    public void eachRoomShouldDisplayItsType() {
        for (WebElement roomTitle : element.roomTitles) {
            Assert.assertTrue(roomTitle.isDisplayed());
        }
    }

    @And("Each room should display its price per night")
    public void eachRoomShouldDisplayItsPricePerNight() {
        for (WebElement roomPrice : element.roomPrices) {
            Assert.assertTrue(roomPrice.isDisplayed());
        }
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    private String getDate(int daysAdd) {
        LocalDate currentDate = LocalDate.now().plusDays(daysAdd);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return currentDate.format(formatter);
    }
}
