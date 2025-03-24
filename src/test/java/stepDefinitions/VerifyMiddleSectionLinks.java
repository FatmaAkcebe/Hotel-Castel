package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.VerifyMiddleSection_POM;
import utilities.ConfigReader;
import utilities.GWD;

import java.util.Arrays;
import java.util.List;

public class VerifyMiddleSectionLinks {

    VerifyMiddleSection_POM element = new VerifyMiddleSection_POM();

    @Given("The user is on the homepage")
    public void theUserIsOnTheHomepage() {
        String homepageURL = ConfigReader.getProperty("homepageURL");
        GWD.getDriver().navigate().to(homepageURL);
        element.verifyURL(homepageURL);
    }

    @When("The user scrolls down to the middle section")
    public void theUserScrollsDownToTheMiddleSection() {
        element.wait.until(ExpectedConditions.visibilityOf(element.homepageMiddleSection));
        element.scrollToElement(element.homepageMiddleSection);
    }

    @Then("The user should see the Anfahrt, Über uns and Aktivitäten sections")
    public void theUserShouldSeeTheAnfahrtUberUnsAndAktivitatenSections() {
        List<WebElement> sections = Arrays.asList(element.midSectionAnfahrt, element.midSectionUberUns, element.midSectionAktivitaten);
        List<WebElement> images = Arrays.asList(element.anfahrtImg, element.uberUnsImg, element.aktivitatenImg);

        for (int i = 0; i < sections.size(); i++) {
            Assert.assertTrue(sections.get(i).isDisplayed());
            Assert.assertTrue(images.get(i).isDisplayed());
        }
    }

    @When("The user clicks on the Anfahrt link in the middle section")
    public void theUserClicksOnTheAnfahrtSection() {
        element.wait.until(ExpectedConditions.visibilityOf(element.midSectionAnfahrt));
        element.myClick(element.midSectionAnfahrt);
    }

    @Then("The user should be redirected to the Anfahrt page")
    public void theUserShouldBeRedirectedToTheAnfahrtPage() {
        element.verifyURL(ConfigReader.getProperty("anfahrtURL"));
        Assert.assertTrue(element.anfahrtPageContent.isDisplayed());
    }

    @When("The user clicks on the Über uns link in the middle section")
    public void theUserClicksOnTheUberUnsPage() {
        element.navigateBack();
        element.wait.until(ExpectedConditions.visibilityOf(element.midSectionUberUns));
        element.myClick(element.midSectionUberUns);
    }

    @Then("The user should be redirected to the Über uns page")
    public void theUserShouldBeRedirectedToTheUberUnsPage() {
        element.verifyURL(ConfigReader.getProperty("uberUnsURL"));
        Assert.assertTrue(element.uberUnsPageContent.isDisplayed());
    }

    @When("The user clicks on the Aktivitäten link in the middle section")
    public void theUserClicksOnTheAktivitatenSection() {
        element.navigateBack();
        element.wait.until(ExpectedConditions.visibilityOf(element.midSectionAktivitaten));
        element.myClick(element.midSectionAktivitaten);
    }

    @Then("The user should be redirected to the Aktivitäten page")
    public void theUserShouldBeRedirectedToTheAktivitatenPage() {
        element.verifyURL(ConfigReader.getProperty("aktivitatenURL"));
        Assert.assertTrue(element.aktivitatenPageContent.isDisplayed());
    }

    @And("The user navigates back to the homepage")
    public void theUserNavigatesBackToTheHomepage() {
        element.navigateBack();
        element.verifyURL(ConfigReader.getProperty("homepageURL"));
    }
}