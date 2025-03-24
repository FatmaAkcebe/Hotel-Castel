package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.ChangeDatesIbrahim;
import utilities.GWD;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class ChangeDates {
    ChangeDatesIbrahim dc = new ChangeDatesIbrahim();
    int randomNumber = (int)(Math.random() * (20 - 1 + 1)) + 1;

    @When("select check-in and check out dates")
    public void selectCheckInAndCheckOutDates() {
        dc.myClick(dc.checkAvailability);
        Set<String> windowHandles = GWD.getDriver().getWindowHandles();
        for (String handle : windowHandles) {
            GWD.getDriver().switchTo().window(handle); // Yeni sekmeye geçiş yap
        }
        dc.myClick(dc.checkIn);
    }

    @And("user changes Check-in date")
    public void userChangesCheckInDate() {
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusDays(randomNumber);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = futureDate.format(formatter);

        dc.checkIn.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        dc.checkIn.sendKeys(formattedDate);
    }

    @And("user changes Check-out date")
    public void userChangesCheckOutDate() {

        dc.myClick(dc.checkOut);
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusDays(randomNumber+2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = futureDate.format(formatter);

        dc.checkOut.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        dc.checkOut.sendKeys(formattedDate);
    }

    @Then("New rooms should come")
    public void newRoomsShouldCome() {
      Assert.assertTrue(dc.roomPhotos.isDisplayed());
    }
}
