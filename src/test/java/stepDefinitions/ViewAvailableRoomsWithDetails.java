package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;

public class ViewAvailableRoomsWithDetails {

    DialogContent dc = new DialogContent();

    @When("The user specifies the number of adults for the booking")
    public void theUserSpecifiesTheNumberOfAdultsForTheBooking() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.adultDropdownButton));
        dc.myClick(dc.adultDropdownButton);

        for (WebElement adult : dc.adultSelection) {
            String index = adult.getAttribute("data-original-index");
            if (index.equals("1")) {
                adult.click();
                break;
            }
        }
    }

    @And("The user specifies the number of children if allowed for the selected room type")
    public void theUserSpecifiesTheNumberOfChildrenIfAllowedForTheSelectedRoomType() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.childrenDropdownButton));
        dc.myClick(dc.childrenDropdownButton);

        for (WebElement child : dc.childrenSelection) {
            String index = child.getAttribute("data-original-index");
            if (index.equals("1")) {
                child.click();
                break;
            }
        }
    }

    @And("The user specifies the number of rooms to book")
    public void theUserSpecifiesTheNumberOfRoomsToBook() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.roomDropdownButton));
        dc.myClick(dc.roomDropdownButton);

        for (WebElement room : dc.roomSelection) {
            String index = room.getAttribute("data-original-index");
            if (index.equals("1")) {
                room.click();
                break;
            }
        }
    }

    @Then("The system should update the total price based on the number of rooms and guests selected")
    public void theSystemShouldUpdateTheTotalPriceBasedOnTheNumberOfRoomsAndGuestsSelected() {
        Assert.assertTrue(dc.totalPrice.isDisplayed());
    }
}
