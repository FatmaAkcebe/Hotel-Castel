package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.DialogContent;

public class FooterMenuContact {
    DialogContent dc = new DialogContent();

    @And("The user scrolls down the page")
    public void theUserScrollsDownThePage() {
        dc.scrollToElement(dc.footerMenu);
    }

    @And("The user accepts the cookie banner")
    public void theUserAcceptsTheCookieBanner() {
        dc.myClick(dc.okButton);
    }

    @When("The user clicks on the {string} in the footer")
    public void theUserClicksOnTheInTheFooter(String menuItem) {
        dc.myClick(dc.getWebElement(menuItem));
        if (menuItem.equals("email address")) {
            dc.Wait(2);
            dc.closeWindow();
        }
        if (menuItem.equals("Footer Phone Number")) {
            dc.myClick(dc.footerPhoneNumber);
            dc.robotExecute(1);
            dc.Wait(2);
            dc.closeWindow();
        }
    }

    @Then("The {string} should be clickable")
    public void theShouldBeClickable(String menuItem) {
        Assert.assertTrue(dc.footerMenu.isEnabled());
    }

    @When("The user clicks on the go up button")
    public void theUserClicksOnTheGoUpButton() {
        dc.myClick(dc.goUpButton);
    }

    @Then("The go up button should be clickable. The page should scroll smoothly back to the top")
    public void theGoUpButtonShouldBeClickableThePageShouldScrollSmoothlyBackToTheTop() {
        Assert.assertTrue(dc.goUpButton.isEnabled());
    }
}
