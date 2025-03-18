package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DialogContent;
import utilities.GWD;


public class LanguageToggleButtons {
    DialogContent element = new DialogContent();

    @When("The user clicks the language button Deutsch")
    public void theUserClicksTheLanguageButtonDeutsch() {
        element.myClick(element.deutschBtn);
    }

    @Then("The website content should be displayed in the selected language")
    public void theWebsiteContentShouldBeDisplayedInTheSelectedLanguage() {
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().contains("de"));
    }

    @When("The user clicks the language button Englisch")
    public void theUserClicksTheLanguageButtonEnglish() {
        element.myClick(element.englischBtn);
    }

    @And("The language should remain active after page refresh")
    public void theLanguageShouldRemainActiveAfterPageRefresh() {
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().contains("en"));
        GWD.getDriver().navigate().refresh();
    }
}
