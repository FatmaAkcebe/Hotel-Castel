package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.CheckAvailability_POM;
import utilities.GWD;

import java.time.LocalDate;

public class CheckAvailability  {
    CheckAvailability_POM element = new CheckAvailability_POM();
    JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();

    @When("The user scrolls down to make the date picker visible")
    public void theUserScrollsDownToMakeTheDatePickerVisible() {
        element.scrollToElement(element.multidate);
    }

    @And("The user clicks on the date picker and the date picker opens")
    public void theUserClicksOnTheDatePickerAndTheDatePickerOpens() {
        js.executeScript("arguments[0].click();", element.multidate);
        Assert.assertTrue(element.viewCalendar.isDisplayed(), "The date picker did not open!");
    }


    @And("Select a check-in and check-out date")
    public void theUserSelectACheckInDate() {

        LocalDate today = LocalDate.now();
        int[] days = element.generateCheckInOutDays(today);

        int checkInDay = days[0];
        int checkOutDay = days[1];

        System.out.println("Selected Check-in Day: " + checkInDay);
        System.out.println("Selected Check-out Day: " + checkOutDay);

        element.clickDay(checkInDay);
        element.clickDay(checkOutDay);
    }
    @And("The user selects a number of guests")
    public void theUserSelectsANumberOfGuests() {

        element.myClick(element.searchGuest);

        element.wait.until(ExpectedConditions.visibilityOf(element.guestIncreaseButton));
        element.myClick(element.guestIncreaseButton);

        element.wait.until(ExpectedConditions.visibilityOf(element.guestDecreaseButton));
        element.myClick(element.guestDecreaseButton);
    }

    @And("The user clicks the Check Availability button")
    public void theUserClicksTheCheckAvailabilityButton() {
        element.wait.until(ExpectedConditions.visibilityOf(element.checkAvailabilityButton));
        element.myClick(element.checkAvailabilityButton);
    }
}
