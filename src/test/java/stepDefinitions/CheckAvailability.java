package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.CR_POM;
import utilities.ReusableMethods;

import java.time.LocalDate;
import java.util.Random;

public class CheckAvailability  {
    CR_POM element = new CR_POM();

    @When("The user select a check-in date")
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
