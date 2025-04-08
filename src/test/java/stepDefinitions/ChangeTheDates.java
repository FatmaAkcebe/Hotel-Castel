package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.ChangeDates_POM;
import utilities.GWD;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class ChangeTheDates {
    ChangeDates_POM dc = new ChangeDates_POM();

    int randomNumber = (int)(Math.random() * (20 - 1 + 1)) + 1;
    LocalDate today = LocalDate.now();
    LocalDate futureDate = today.plusDays(randomNumber);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @When("The user selects the check-in and check-out dates")
    public void selectCheckInAndCheckOutDates() {
        dc.myClick(dc.checkAvailability);
        Set<String> windowHandles = GWD.getDriver().getWindowHandles();
        for (String handle : windowHandles) {
            GWD.getDriver().switchTo().window(handle);
        }
        dc.myClick(dc.checkIn);
    }

    @And("The user selects the check-in date")
    public void userChangesCheckInDate() {
        String formattedDate = futureDate.format(formatter);
        dc.checkIn.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        dc.checkIn.sendKeys(formattedDate);
    }

    @And("The user selects the check-out date")
    public void userChangesCheckOutDate() {
        dc.myClick(dc.checkOut);
        futureDate = today.plusDays(randomNumber+2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = futureDate.format(formatter);

        dc.checkOut.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        dc.checkOut.sendKeys(formattedDate);
    }

    @Then("New rooms should be displayed")
    public void newRoomsShouldAppear() {
        boolean invalidDate;

        do {
            dc.myClick(dc.checkAvailabilityButton);
            dc.wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfAllElements(dc.newRooms),
                    ExpectedConditions.visibilityOf(dc.message)
            ));

            invalidDate = dc.message.isDisplayed();
            if (invalidDate) {
                String formattedDate = futureDate.format(formatter);
                dc.checkIn.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
                dc.checkIn.sendKeys(formattedDate+1);
                dc.checkOut.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
                dc.checkOut.sendKeys(formattedDate+3);
            }
        } while (invalidDate);
    }

    @And("User selects wrong check-out date")
    public void userSelectsWrongCheckOutDate() {
        dc.myClick(dc.checkOut);
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusDays(randomNumber-4);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = futureDate.format(formatter);

        dc.checkOut.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);

        dc.checkOut.sendKeys(formattedDate);
    }

    @Then("New rooms should not be displayed")
    public void newRoomsNotShouldCome() {
        Assert.assertFalse(dc.newRooms.isDisplayed());
    }
}
