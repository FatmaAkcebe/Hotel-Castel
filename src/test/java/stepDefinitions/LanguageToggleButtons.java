package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.JetztBuchenButton_POM;
import utilities.GWD;

public class LanguageToggleButtons {
    JetztBuchenButton_POM element = new JetztBuchenButton_POM();

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
        do {
            element.jsClick(element.englischBtn);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }while(!GWD.getDriver().getCurrentUrl().equalsIgnoreCase("https://hotel-castle-rastatt.de/?lang=en"));

    }

    @And("The language should remain active after page refresh")
    public void theLanguageShouldRemainActiveAfterPageRefresh() {
        element.jsClick(element.englischBtn);
        element.wait.until(ExpectedConditions.visibilityOf(element.HomeBtn));
        Assert.assertTrue(element.HomeBtn.getText().equalsIgnoreCase("Home"));
        GWD.getDriver().navigate().refresh();
    }
}
