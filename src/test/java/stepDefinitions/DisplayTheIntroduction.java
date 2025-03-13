package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DisplayTheIntroduction {
    @When("The user scroll down to the introduction section")
    public void theUserScrollDownToTheIntroduction() {
    }

    @Then("The user should see the {string} field")
    public void theUserShouldSeeTheText(String arg0) {
    }

    @And("The content of the {string} field should contain the expected text")
    public void theContentOfTheFieldShouldContainTheExpectedText(String arg0) {
    }
}
