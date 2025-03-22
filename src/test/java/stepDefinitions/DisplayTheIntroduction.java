package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DisplayIntroduction_POM;

public class DisplayTheIntroduction {

    DisplayIntroduction_POM element = new DisplayIntroduction_POM();

    @When("The user scrolls down to the introduction section")
    public void theUserScrollsDownToTheIntroduction() {
        element.scrollToElement(element.willkommenBeimTitle);
        element.wait.until(ExpectedConditions.visibilityOf(element.willkommenBeimTitle));
        Assert.assertTrue(element.willkommenBeimTitle.isDisplayed(),
                "Introduction section is not displayed!");
    }

    @Then("The Willkommen Beim field should be visible in the introduction section")
    public void theWillkommenBeimfieldShouldBeVisible() {
        element.wait.until(ExpectedConditions.visibilityOf(element.castleHotelRastattTitle));
        Assert.assertTrue(element.willkommenBeimTitle.isDisplayed(),
                "Willkommen beim field is not displayed!");
    }

    @And("The content of the Willkommen Beim field should contain the expected text")
    public void theContentOfTheWillkommenBeimFieldShouldContainTheExpectedText() {
        element.wait.until(ExpectedConditions.visibilityOf(element.introTextContent));

        String expectedContent = "Das Castle Hotel Rastatt verbindet Komfort  mit persönlichem Service";
        String actualContent = element.introTextContent.getText();

        Assert.assertTrue(actualContent.contains(expectedContent),
                "Expected text not found in the introduction section!");
    }
}