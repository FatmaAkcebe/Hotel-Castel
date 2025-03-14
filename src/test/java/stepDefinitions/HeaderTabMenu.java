package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.DialogContent;
import utilities.GWD;

import java.util.Set;

public class HeaderTabMenu {
    DialogContent dc = new DialogContent();

    @Given("The user navigates to the Hotel Castle website")
    public void theUserNavigatesToHotelCastleWebsite() {
        GWD.getDriver().get("https://hotel-castle-rastatt.de/");
        dc.myClick(dc.deutschBtn);
    }

    @When("The user clicks on {string} in the header menu")
    public void theUserClicksOnInTheHeaderMenu(String menuItem) {
        {
            dc.myClick(dc.getWebElement(menuItem));
            if (menuItem.equals("Header Phone Number")) {
                dc.myClick(dc.headerPhoneNumber);
                dc.robotExecute(1);
                dc.Wait(2);
                dc.closeWindow();
            }
        }
    }

    @Then("The header menu should be visible")
    public void theHeaderMenuShouldBeVisible() {
        Assert.assertTrue(dc.headerMenu.isDisplayed(), "Header menu is not visible!");
        System.out.println("The header menu is visible");
    }

    @And("The user should be redirected to the {string} page")
    public void theUserShouldBeRedirectedToThePage(String expectedResult) {
        String expectedUrl;
        Assert.assertEquals("https://hotel-castle-rastatt.de/" + expectedResult.toLowerCase(),
                GWD.getDriver().getCurrentUrl());
    }
}
