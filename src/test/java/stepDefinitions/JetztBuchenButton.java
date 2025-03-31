package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.JetztBuchenButton_POM;
import utilities.GWD;

public class JetztBuchenButton {
    JetztBuchenButton_POM element = new JetztBuchenButton_POM();

    @Then("The user is redirected to the JETZT BUCHEN booking page and verifies")
    public void theUserIsRedirectedToTheJETZTBUCHENBookingPageAndVerifies() {
        element.verifyContainsText(element.bookNowControl,"Hotel Castle");
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().contains("reservation"));
    }
}
