package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.DialogContent;
import utilities.GWD;

public class CheckIfTheHotelHasDirections {

    DialogContent dc = new DialogContent();

    @Given("Navigate to hootelCastle")
    public void navigateToHootelCastle() {
        GWD.getDriver().get("https://hotel-castle-rastatt.de/");
        dc.myClick(dc.almanca);
        dc.myClick(dc.anfahrt);
    }

    @When("Check the description of the hotel's location.")
    public void checkTheDescriptionOfTheHotelSLocation() {
    }
}
