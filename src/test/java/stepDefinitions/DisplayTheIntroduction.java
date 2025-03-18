package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.VerifyMiddleSectionContent;

public class DisplayTheIntroduction {

    VerifyMiddleSectionContent mc = new VerifyMiddleSectionContent();

    @When("The user scrolls down to the introduction section")
    public void theUserScrollDownToTheIntroduction() {
        mc.scrollToElement(mc.willkommenBeimTitle);
        mc.wait.until(ExpectedConditions.visibilityOf(mc.willkommenBeimTitle));
        Assert.assertTrue(mc.willkommenBeimTitle.isDisplayed(), "Introduction section is not displayed!");
    }

    @Then("The Willkommen Beim field should be visible in the introduction section")
    public void theWillkommenBeimfieldShouldBeVisible() {
        mc.wait.until(ExpectedConditions.visibilityOf(mc.castleHotelRastattTitle));
        Assert.assertTrue(mc.willkommenBeimTitle.isDisplayed(), "Willkommen beim field is not displayed!");
    }

    @And("The content of the Willkommen Beim field should contain the expected text")
    public void theContentOfTheWillkommenBeimFieldShouldContainTheExpectedText() {
        mc.wait.until(ExpectedConditions.visibilityOf(mc.introTextContent));
        String expectedContent = "Das Castle Hotel Rastatt verbindet Komfort  mit persönlichem Service";
        String actualContent = mc.introTextContent.getText();
        Assert.assertTrue(actualContent.contains(expectedContent), "expected text not found!");
    }
}
