package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckIfTheHotel_POM;

public class CheckIfTheHotelHasDirections {

    CheckIfTheHotel_POM ch = new CheckIfTheHotel_POM();

    @When("The user checks the description of the hotel's location.")
    public void theUserChecksTheDescriptionOfTheHotelSLocation() {
        ch.myClick(ch.anfahrt);
        ch.verifyContainsText(ch.text,"SO FINDEN SIE UNS");
    }

    @Then("The user checks the hotel's activity information")
    public void theUserChecksTheHotelSActivityInformation() {
        ch.myClick(ch.aktivitätenButton);
        ch.verifyContainsText(ch.Aktivitäten,"Aktivitäten");
    }
}