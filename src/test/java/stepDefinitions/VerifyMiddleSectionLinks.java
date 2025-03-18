package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.VerifyMiddleSectionContent;
import utilities.ConfigReader;
import utilities.GWD;

import java.util.Arrays;
import java.util.List;

public class VerifyMiddleSectionLinks {

    VerifyMiddleSectionContent mc = new VerifyMiddleSectionContent();

    @Given("The user is on the homepage")
    public void theUserIsOnTheHomepage() {
        String homepageURL = ConfigReader.getProperty("homepageURL");
        GWD.getDriver().navigate().to(homepageURL);
        mc.verifyURL(homepageURL);
    }

    @When("The user scrolls down to the middle section")
    public void theUserScrollsDownToTheMiddleSection() {
        mc.wait.until(ExpectedConditions.visibilityOf(mc.homepageMiddleSection));
        mc.scrollToElement(mc.homepageMiddleSection);
    }

    @Then("The user should see the Anfahrt, Über uns and Aktivitäten sections")
    public void theUserShouldSeeTheAnfahrtUberUnsAndAktivitatenSections() {
        List<WebElement> sections = Arrays.asList(mc.midSectionAnfahrt, mc.midSectionUberUns, mc.midSectionAktivitaten);
        List<WebElement> images = Arrays.asList(mc.anfahrtImg, mc.uberUnsImg, mc.aktivitatenImg);

        for (int i = 0; i < sections.size(); i++) {
            Assert.assertTrue(sections.get(i).isDisplayed(), "Section is not displayed!");
            Assert.assertTrue(images.get(i).isDisplayed(), "Image is not displayed!");
        }
    }

    @When("The user clicks on the Anfahrt link in the middle section")
    public void theUserClicksOnTheAnfahrtSection() {
        mc.wait.until(ExpectedConditions.visibilityOf(mc.midSectionAnfahrt));
        mc.myClick(mc.midSectionAnfahrt);
    }

    @Then("The user should be redirected to the Anfahrt page")
    public void theUserShouldBeRedirectedToTheAnfahrtPage() {
        mc.verifyURL(ConfigReader.getProperty("anfahrtURL"));
    }

    @When("The user clicks on the Über uns link in the middle section")
    public void theUserClicksOnTheUberUnsPage() {
        mc.navigateBack();
        mc.wait.until(ExpectedConditions.visibilityOf(mc.midSectionUberUns));
        mc.myClick(mc.midSectionUberUns);
    }

    @Then("The user should be redirected to the Über uns page")
    public void theUserShouldBeRedirectedToTheUberUnsPage() {
        mc.verifyURL(ConfigReader.getProperty("uberUnsURL"));
    }

    @When("The user clicks on the Aktivitäten link in the middle section")
    public void theUserClicksOnTheAktivitatenSection() {
        mc.navigateBack();
        mc.wait.until(ExpectedConditions.visibilityOf(mc.midSectionAktivitaten));
        mc.myClick(mc.midSectionAktivitaten);
    }

    @Then("The user should be redirected to the Aktivitäten page")
    public void theUserShouldBeRedirectedToTheAktivitatenPage() {
        mc.verifyURL(ConfigReader.getProperty("aktivitatenURL"));
    }

    @And("The user navigates back to the homepage")
    public void theUserNavigatesBackToTheHomepage() {
        mc.navigateBack();
        mc.verifyURL(ConfigReader.getProperty("homepageURL"));
    }
}