package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckIfTheHotel;

public class CheckIfTheHotelHasDirections {

    CheckIfTheHotel ch = new CheckIfTheHotel();

    @When("The user Check the description of the hotel's location.")
    public void theUserCheckTheDescriptionOfTheHotelSLocation() {
        ch.myClick(ch.anfahrt);
        ch.verifyContainsText(ch.text,"SO FINDEN SIE UNS");
    }

    @Then("The user Check the hotel's activity information")
    public void theUserCheckTheHotelSActivityInformation() {
        ch.myClick(ch.aktivitätenButton);
        ch.verifyContainsText(ch.Aktivitäten,"Aktivitäten");
    }
}