package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import pages.ChangeDatesIbrahim;
import utilities.ConfigReader;
import utilities.GWD;
import utilities.ReusableMethods;

public class AboutHotel {
    ReusableMethods reusableMethods= new ReusableMethods();
    ChangeDatesIbrahim dc = new ChangeDatesIbrahim();

    @When("Click on the About Us link from the menu")
    public void clickOnTheLinkFromTheMenu() {
        dc.myClick(dc.aboutUs);
    }


    @Given("Navigate HotelCastle")
    public void navigateHotelCastle() {
        GWD.getDriver().get(ConfigReader.getProperty("homepageURL"));
    }

    @Then("The about us section should be visible")
    public void theAboutUsSectionShouldBeVisible() {
        Assert.assertTrue(dc.aboutHotelDiv.isDisplayed());
        Assert.assertTrue(dc.unserHotelDiv.getText().contains("Über uns"));
    }

    @And("Click on the change buttons")
    public void clickOnTheChangeButtons() {
        JavascriptExecutor js=(JavascriptExecutor)GWD.getDriver();
        js.executeScript("window.scrollTo(0,500)");
        dc.myClick(dc.unserHotelButtonLeft);
        Assert.assertTrue(dc.unserHotelButtonLeft.isEnabled());
        Assert.assertTrue(dc.unserHotelButtonRight.isEnabled());
    }
}
