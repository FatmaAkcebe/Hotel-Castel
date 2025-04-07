package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.ViewCustomerFeedback_POM;
import utilities.ReusableMethods;
import java.util.Arrays;
import java.util.List;

public class ViewCustomerFeedback extends ReusableMethods{

    ViewCustomerFeedback_POM vc = new ViewCustomerFeedback_POM();

    @When("The user scrolls down to make the comments section visible")
    public void theUserScrollsDownToMakeTheCommentsSectionVisible() {
        vc.wait.until(ExpectedConditions.visibilityOf(vc.commentSection));
        vc.scrollToElement(vc.commentSection);
    }

    @Then("The comments should be visible")
    public void theCommentsShouldBeVisible() {
        Assert.assertTrue(vc.comments.isDisplayed(), "Comments section is not displayed!");
    }

    @When("The user clicks on each comment point and the corresponding comment should be displayed")
    public void theUserClicksOnEachCommentDot() {
        List<WebElement> dots = Arrays.asList(vc.firstDot, vc.secondDot, vc.thirdDot);
        List<WebElement> expectedCommenters = Arrays.asList(vc.firstComment, vc.secondComment, vc.thirdComment);

        for (int i = 0; i < dots.size(); i++) {
            WebElement dot = dots.get(i);

            Assert.assertTrue(dot.isDisplayed(), "The dot is not visible!");
            Assert.assertTrue(dot.isEnabled(), "The dot is not clickable!");

            dot.click();
            vc.Wait(2);

            WebElement activeComment = vc.activeCommenter;
            String activeCommentText = activeComment.getText();

            Assert.assertTrue(activeComment.isDisplayed(), "The active comment is not displayed!");
            Assert.assertEquals(activeCommentText, expectedCommenters.get(i).getText(), "The displayed comment does not match the clicked dot!");
        }
    }
}

