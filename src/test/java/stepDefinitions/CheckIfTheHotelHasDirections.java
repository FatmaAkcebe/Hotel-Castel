package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DialogContent;
import utilities.GWD;

public class CheckIfTheHotelHasDirections {

    DialogContent dc = new DialogContent();

    @Given("Navigate to hootelCastle")
    public void navigateToHootelCastle() {
        GWD.getDriver().get("https://hotel-castle-rastatt.de/");
        dc.myClick(dc.anfahrt);
    }

    @When("The user Check the description of the hotel's location.")
    public void theUserCheckTheDescriptionOfTheHotelSLocation() {
    }

    @Then("The user Check the buttons on the map")
    public void theUserCheckTheButtonsOnTheMap() {
    }

    @And("The user Check the hotel's activity information")
    public void theUserCheckTheHotelSActivityInformation() {
    }
/*
    @When("Check the description of the hotel's location.")
    public void checkTheDescriptionOfTheHotelSLocation() {
        dc.verifyContainsText(dc.text,"SO FINDEN SIE UNS");
        dc.myClick(dc.mapName);
        dc.verifyContainsText(dc.mapName,"Harita");
    }

    @Then("Check the buttons on the map")
    public void checkTheButtonsOnTheMap() {
        dc.myClick(dc.fullScreen);
        dc.myClick(dc.controlKey);
        dc.myClick(dc.upKey);
        dc.myClick(dc.downKey);
        dc.myClick(dc.rightKey);
        dc.myClick(dc.leftKey);
        dc.myClick(dc.enlarge);
        dc.myClick(dc.reduce);
//        dc.drapAndDrop(dc.streetView, dc.map);
        dc.myClick(dc.fullScreen);
    }

    @And("Check the hotel's activity information")
    public void checkTheHotelSActivityInformation() {
        dc.myClick(dc.aktivitaten);
        dc.verifyContainsText(dc.ourHotel,"OUR HOTEL");
    }
*/
}

