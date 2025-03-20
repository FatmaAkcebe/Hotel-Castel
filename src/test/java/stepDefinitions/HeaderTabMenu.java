package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HeaderTabMenu_POM;
import utilities.ConfigReader;
import utilities.GWD;

public class HeaderTabMenu {
    HeaderTabMenu_POM hm = new HeaderTabMenu_POM();

    @Given("The user navigates to the Hotel Castle website")
    public void theUserNavigatesToHotelCastleWebsite() {
        GWD.getDriver().get("https://hotel-castle-rastatt.de/");
    }

    @When("The user clicks on the Hotel Logo button in the header menu")
    public void theUserClicksOnTheHotelLogoButtonInTheHeaderMenu() {
        hm.wait.until(ExpectedConditions.visibilityOf(hm.logo));
        hm.myClick(hm.logo);
    }

    @Then("The user should be redirected to the Start page")
    public void theUserShouldBeRedirectedToTheStartPage() {
        hm.verifyURL(ConfigReader.getProperty("homepageURL"));
    }

    @When("The user clicks on the Start button in the header menu")
    public void theUserClicksOnTheStartButtonInTheHeaderMenu() {
        hm.wait.until(ExpectedConditions.visibilityOf(hm.startButton));
        hm.myClick(hm.startButton);
    }

    @When("The user clicks on the Über uns button in the header menu")
    public void theUserClicksOnTheÜberUnsButtonInTheHeaderMenu() {
        hm.wait.until(ExpectedConditions.visibilityOf(hm.uberUnsButton));
        hm.myClick(hm.uberUnsButton);
    }

    @When("The user clicks on the Anfahrt button in the header menu")
    public void theUserClicksOnTheAnfahrtButtonInTheHeaderMenu() {
        hm.wait.until(ExpectedConditions.visibilityOf(hm.anfahrtButton));
        hm.myClick(hm.anfahrtButton);
    }

    @When("The user clicks on the Aktivitäten button in the header menu")
    public void theUserClicksOnTheAktivitätenButtonInTheHeaderMenu() {
        hm.wait.until(ExpectedConditions.visibilityOf(hm.aktivitatenButton));
        hm.myClick(hm.aktivitatenButton);
    }

    @When("The user clicks on the phone number in the header menu")
    public void theUserClicksOnThePhoneNumberInTheHeaderMenu() {
        hm.wait.until(ExpectedConditions.visibilityOf(hm.headerPhoneNumber));
        hm.myClick(hm.headerPhoneNumber);
    }

    @And("The application selection screen should appear, listing apps that can make a call")
    public void theApplicationSelectionScreenShouldAppearListingAppsThatCanMakeACall() {
        hm.robotExecute(1);
        hm.Wait(2);
        hm.closeWindow();
    }
}
