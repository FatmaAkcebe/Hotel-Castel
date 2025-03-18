package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ViewRoomDetails_POM;

public class ViewsRoomDetails {

    ViewRoomDetails_POM element=new ViewRoomDetails_POM();

    @And("The user views the Online-Preis section by clicking Details anzeigen link")
    public void theUserViewsTheOnlinePreisSectionByClickingDetailsAnzeigenLink() {
        element.myClick(element.detailsAnzeigenLink);
    }

    @When("The user clicks on the tablist and displays to verifies content sections")
    public void theUserClicksOnTheTablistAndDisplaysToVerifiesContentSections() {
    }

    @Then("The user clicks on the link Details ausblenden to close all sections")
    public void theUserClicksOnTheLinkDetailsAusblendenToCloseAllSections() {
    }
}
