package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DialogContent;

public class CheckHotelInformation {
    DialogContent dc = new DialogContent();

    @Given("The user is on to the Hotel Castle homepage")
    public void theUserIsOnToTheHotelCastleHomepage() {
    }

    @When("The user clicks the JETZT BUCHEN button")
    public void theUserClicksTheJETZTBUCHENButton() {
    }

    @Then("The user is redirected to the JETZT BUCHEN booking page")
    public void theUserIsRedirectedToTheJETZTBUCHENBookingPage() {
    }

    @And("The user checks the hotel information in the Informationen zur Anlage section")
    public void theUserChecksTheHotelInformationInTheInformationenZurAnlageSection() {
    }
}