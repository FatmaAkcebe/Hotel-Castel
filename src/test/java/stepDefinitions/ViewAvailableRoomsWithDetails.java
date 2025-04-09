package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.ViewAvailableRoomsWithDetails_POM;

public class ViewAvailableRoomsWithDetails {

    ViewAvailableRoomsWithDetails_POM element = new ViewAvailableRoomsWithDetails_POM();

    @When("The user specifies the number of adults for the booking")
    public void theUserSpecifiesTheNumberOfAdultsForTheBooking() {
        element.wait.until(ExpectedConditions.visibilityOf(element.adultDropdownButton));
        element.myClick(element.adultDropdownButton);

        for (WebElement adult : element.adultSelection) {
            String index = adult.getAttribute("data-original-index");
            if (index.equals("1")) {
                adult.click();
                break;
            }
        }
    }

    @And("The user specifies the number of children if allowed for the selected room type")
    public void theUserSpecifiesTheNumberOfChildrenIfAllowedForTheSelectedRoomType() {
        element.wait.until(ExpectedConditions.visibilityOf(element.childrenDropdownButton));
        element.myClick(element.childrenDropdownButton);

        for (WebElement child : element.childrenSelection) {
            String index = child.getAttribute("data-original-index");
            if (index.equals("1")) {
                child.click();
                break;
            }
        }
    }

    @And("The user specifies the number of rooms to book")
    public void theUserSpecifiesTheNumberOfRoomsToBook() {
        element.wait.until(ExpectedConditions.visibilityOf(element.roomDropdownButton));
        element.myClick(element.roomDropdownButton);

        for (WebElement room : element.roomSelection) {
            String index = room.getAttribute("data-original-index");
            if (index.equals("1")) {
                room.click();
                break;
            }
        }
    }

    @Then("The system should update the total price based on the number of rooms and guests selected")
    public void theSystemShouldUpdateTheTotalPriceBasedOnTheNumberOfRoomsAndGuestsSelected() {
        Assert.assertTrue(element.totalPrice.isDisplayed());
    }
}
