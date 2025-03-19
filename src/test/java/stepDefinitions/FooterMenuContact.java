package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.FooterMenuContact_POM;
import utilities.ConfigReader;

public class FooterMenuContact {
    FooterMenuContact_POM fm = new FooterMenuContact_POM();

    @And("The user scrolls down the page")
    public void theUserScrollsDownThePage() {
        fm.scrollToElement(fm.footerMenu);
    }

    @And("The user accepts the cookie banner")
    public void theUserAcceptsTheCookieBanner() {
        fm.myClick(fm.okButton);
    }

    @When("The user clicks on the phone number button in the footer menu")
    public void theUserClicksOnThePhoneNumberButtonInTheFooterMenu() {
        fm.wait.until(ExpectedConditions.visibilityOf(fm.footerPhoneNumber));
        fm.myClick(fm.footerPhoneNumber);
    }

    @When("The user clicks on the email address button in the footer menu")
    public void theUserClicksOnTheEmailAddressButtonInTheFooterMenu() {
        fm.wait.until(ExpectedConditions.visibilityOf(fm.emailAddress));
        fm.myClick(fm.emailAddress);
        fm.Wait(2);
        fm.closeWindow();
    }

    @When("The user clicks on the Impressum button in the footer menu")
    public void theUserClicksOnTheImpressumButtonInTheFooterMenu() {
        fm.wait.until(ExpectedConditions.visibilityOf(fm.impressumButton));
        fm.myClick(fm.impressumButton);
    }

    @Then("The user should be redirected to the Impressum page")
    public void theUserShouldBeRedirectedToTheImpressumPage() {
        fm.verifyURL(ConfigReader.getProperty("impressumPageURL"));
    }

    @When("The user clicks on the Datenschutz button in the footer menu")
    public void theUserClicksOnTheDatenschutzButtonInTheFooterMenu() {
        fm.wait.until(ExpectedConditions.visibilityOf(fm.datenschutzButton));
        fm.myClick(fm.datenschutzButton);
    }

    @Then("The user should be redirected to the Datenschutz page")
    public void theUserShouldBeRedirectedToTheDatenschutzPage() {
        fm.verifyURL(ConfigReader.getProperty("datenschutzPageURL"));
    }

    @When("The user clicks on the go up button")
    public void theUserClicksOnTheGoUpButton() {
        fm.myClick(fm.goUpButton);
    }

    @Then("The go up button should be clickable. The page should scroll smoothly back to the top")
    public void theGoUpButtonShouldBeClickableThePageShouldScrollSmoothlyBackToTheTop() {
        Assert.assertTrue(fm.goUpButton.isEnabled());
    }
}
