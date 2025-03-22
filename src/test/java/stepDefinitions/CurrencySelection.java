package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.CurrencySelect;

import java.util.Random;

public class CurrencySelection {
    CurrencySelect cs = new CurrencySelect();
    Random random = new Random();

    @When("The user displays the currency section located at the top-right corner of the booking page")
    public void theUserDisplaysTheCurrencySectionLocatedAtTheTopRightCornerOfTheBookingPage() {
        cs.wait.until(ExpectedConditions.visibilityOf(cs.currencyUnit));
        Assert.assertTrue(cs.currencyUnit.isDisplayed());
    }

    @And("The user clicks on the currency section to display the drop-down menu")
    public void theUserClicksOnTheCurrencySectionAndDisplaysTheCurrenciesOfDifferentCountries() {
        cs.wait.until(ExpectedConditions.elementToBeClickable(cs.currencyUnit));
        cs.myClick(cs.currencyUnit);

        cs.wait.until(ExpectedConditions.visibilityOf(cs.dropDownMenu));
        Assert.assertTrue(cs.dropDownMenu.isDisplayed());
        cs.myClick(cs.currencyUnitClose);
    }

    @Then("The user clicks each currency in the drop-down menu and checks if it is activated")
    public void theUserDisplaysEachCurrencyInTheDropDownMenuAndChecksWhetherItIsActiveByClickingOnIt() {
        for (int i = 0; i < 10; i++) {
            cs.wait.until(ExpectedConditions.visibilityOf(cs.currencyUnit));
            cs.myClick(cs.currencyUnit);

            WebElement randomCurrency = cs.currencyList.get(random.nextInt(cs.currencyList.size()));
            cs.scrollToElement(randomCurrency);
            cs.myClick(randomCurrency);

            cs.wait.until(ExpectedConditions.visibilityOf(cs.preisVonText));
            System.out.println(cs.preisVonText.getText());

            cs.wait.until(ExpectedConditions.visibilityOf(cs.currencyUnit));
            System.out.println(cs.currencyUnit.getText());

            Assert.assertTrue(cs.preisVonText.getText().contains(cs.currencyUnit.getText()));
            System.out.println(cs.preisVonText.getText().contains(cs.currencyUnit.getText()));
        }
    }
}