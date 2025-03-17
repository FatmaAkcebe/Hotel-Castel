package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import utilities.ConfigReader;
import utilities.GWD;

import java.util.Arrays;
import java.util.List;

public class VerifyMiddleSectionLinks {

    private DialogContent dc = new DialogContent();

    @Given("The user is on the homepage")
    public void theUserIsOnTheHomepage() {
        String homepageURL = ConfigReader.getProperty("homepageURL");
        GWD.getDriver().navigate().to(homepageURL);
        dc.verifyURL(homepageURL);
    }

    @When("The user scrolls down to the middle section")
    public void theUserScrollsDownToTheMiddleSection() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.homepageMiddleSection));
        dc.scrollToElement(dc.homepageMiddleSection);
    }

    @Then("The user should see the Anfahrt, Über uns and Aktivitäten sections")
    public void theUserShouldSeeTheAnfahrtUberUnsAndAktivitatenSections() {
        List<WebElement> sections = Arrays.asList(dc.midSectionAnfahrt, dc.midSectionUberUns, dc.midSectionAktivitaten);
        List<WebElement> images = Arrays.asList(dc.anfahrtImg, dc.uberUnsImg, dc.aktivitatenImg);

        for (int i = 0; i < sections.size(); i++) {
            Assert.assertTrue(sections.get(i).isDisplayed(), "Section is not displayed!");
            Assert.assertTrue(images.get(i).isDisplayed(), "Image is not displayed!");
        }
    }

    @When("The user clicks on the Anfahrt link in the middle section")
    public void theUserClicksOnTheAnfahrtSection() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.midSectionAnfahrt));
        dc.myClick(dc.midSectionAnfahrt);
    }

    @Then("The user should be redirected to the Anfahrt page")
    public void theUserShouldBeRedirectedToTheAnfahrtPage() {
        dc.verifyURL(ConfigReader.getProperty("anfahrtURL"));
    }

    @When("The user clicks on the Über uns link in the middle section")
    public void theUserClicksOnTheUberUnsPage() {
        dc.navigateBack();
        dc.wait.until(ExpectedConditions.visibilityOf(dc.midSectionUberUns));
        dc.myClick(dc.midSectionUberUns);
    }

    @Then("The user should be redirected to the Über uns page")
    public void theUserShouldBeRedirectedToTheUberUnsPage() {
        dc.verifyURL(ConfigReader.getProperty("uberUnsURL"));
    }

    @When("The user clicks on the Aktivitäten link in the middle section")
    public void theUserClicksOnTheAktivitatenSection() {
        dc.navigateBack();
        dc.wait.until(ExpectedConditions.visibilityOf(dc.midSectionAktivitaten));
        dc.myClick(dc.midSectionAktivitaten);
    }

    @Then("The user should be redirected to the Aktivitäten page")
    public void theUserShouldBeRedirectedToTheAktivitatenPage() {
        dc.verifyURL(ConfigReader.getProperty("aktivitatenURL"));
    }

    @And("The user navigates back to the homepage")
    public void theUserNavigatesBackToTheHomepage() {
        dc.navigateBack();
        dc.verifyURL(ConfigReader.getProperty("homepageURL"));
    }
}