package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;

public class DisplayTheIntroduction {

    DialogContent dc = new DialogContent();

    @When("The user scrolls down to the introduction section")
    public void theUserScrollDownToTheIntroduction() {
        dc.scrollToElement(dc.willkommenBeimTitle);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.willkommenBeimTitle));
        Assert.assertTrue(dc.willkommenBeimTitle.isDisplayed(), "Introduction section is not displayed!");
    }

    @Then("The Willkommen Beim field should be visible in the introduction section")
    public void theWillkommenBeimfieldShouldBeVisible() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.castleHotelRastattTitle));
        Assert.assertTrue(dc.willkommenBeimTitle.isDisplayed(), "Willkommen beim field is not displayed!");
    }

    @And("The content of the Willkommen Beim field should contain the expected text")
    public void theContentOfTheWillkommenBeimFieldShouldContainTheExpectedText() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.introTextContent));
        String expectedContent = "Das Castle Hotel Rastatt verbindet Komfort  mit persönlichem Service";
        String actualContent = dc.introTextContent.getText();
        Assert.assertTrue(actualContent.contains(expectedContent), "expected text not found!");
    }
}
