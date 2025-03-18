package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.DialogContent;
import utilities.GWD;

public class JetztBuchenButton {
    DialogContent element = new DialogContent();

    @Then("The user is redirected to the JETZT BUCHEN booking page and verifies")
    public void theUserIsRedirectedToTheJETZTBUCHENBookingPageAndVerifies() {
        element.verifyContainsText(element.bookNowControl,"Hotel Castle");
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().contains("reservation"));
    }
}
