package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import pages.ChangeDatesIbrahim;
import utilities.GWD;

public class ChangeDates {
    ChangeDatesIbrahim dc =  new ChangeDatesIbrahim();
    @When("Click on the date picker")
    public void clickOnTheDatePicker() {
        dc.scrollToElement(dc.multidate);
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].click();", dc.multidate);
    }

    @Then("Select a check-in date")
    public void selectACheckInDate() {
        int today = Integer.parseInt(dc.today.getText());
        int randomInt = (int) (today * 31);

        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].click();", dc.today);


        for (int i = today; i < randomInt; i++) {
            js.executeScript("arguments[0].click();", dc.multiDateList.get(i));
            break;
        }
        dc.myClick(dc.checkAvailability);
    }

    @Then("Try to select a check-out date that is before the check-in date")
    public void tryToSelectACheckOutDateThatIsBeforeTheCheckInDate() {
        int today = Integer.parseInt(dc.today.getText());
        int randomInt = (int) (1 * today);

        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].click();", dc.today);


        for (int i = today; i < randomInt; i++) {
            js.executeScript("arguments[0].click();", dc.multiDateList.get(i));
            Assert.assertFalse(dc.multiDateList.get(i).isSelected());
            break;
        }
    }
}
