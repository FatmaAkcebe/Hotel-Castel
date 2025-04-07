package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckIfTheHotel;
import pages.DialogContent;
import utilities.ConfigReader;
import utilities.GWD;

public class CheckIfTheHotelHasDirections {

    CheckIfTheHotel ch = new CheckIfTheHotel();

    @When("The user Check the description of the hotel's location.")
    public void theUserCheckTheDescriptionOfTheHotelSLocation() {
        ch.verifyContainsText(ch.text, "SO FINDEN SIE UNS");
    }

    @Then("The user Check the hotel's activity information")
    public void theUserCheckTheHotelSActivityInformation() {
        ch.myClick(ch.aktivitätenButton);
        ch.verifyContainsText(ch.Aktivitäten, "Aktivitäten");
    }

}

