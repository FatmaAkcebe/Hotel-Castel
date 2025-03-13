package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DialogContent;

public class CurrencySelection {

    DialogContent dc = new DialogContent();

    @When("The user displays the currency section located at the top-right corner of the booking page")
    public void theUserDisplaysTheCurrencySectionLocatedAtTheTopRightCornerOfTheBookingPage() {
    }

    @And("The user clicks on the currency section and displays the currencies of different countries")
    public void theUserClicksOnTheCurrencySectionAndDisplaysTheCurrenciesOfDifferentCountries() {
    }

    @Then("The user displays each currency in the drop-down menu and checks whether it is active by clicking on it")
    public void theUserDisplaysEachCurrencyInTheDropDownMenuAndChecksWhetherItIsActiveByClickingOnIt() {
    }
}