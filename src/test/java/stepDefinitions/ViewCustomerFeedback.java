package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;



public class ViewCustomerFeedback extends ReusableMethods {

    private WebDriver driver;

    public ViewCustomerFeedback() {
        GWD Driver = new GWD();
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @Given("The user is on the customer reviews page")
    public void the_user_is_on_the_customer_reviews_page() {
        navigateToReviewsPage(); // `reusableMethods.` kullanmaya gerek yok
    }

    @When("The system loads and displays reviews with star ratings")
    public void the_system_loads_and_displays_reviews_with_star_ratings() {
        loadReviews();
    }

    @Then("Reviews must be legible, well-formatted, and accessible")
    public void reviews_must_be_legible_well_formatted_and_accessible() {
        areReviewsLegible();
    }

    @Then("The database must store and update reviews properly")
    public void the_database_must_store_and_update_reviews_properly() {
        isDatabaseUpdated();
    }

    @Then("The user must be able to evaluate feedback easily")
    public void users_must_be_able_to_evaluate_feedback_easily() {
        canUserEvaluateFeedback();
    }
}


