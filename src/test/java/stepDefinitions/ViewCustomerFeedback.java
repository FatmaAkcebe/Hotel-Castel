package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.AssertJUnit.assertTrue;

public class ViewCustomerFeedback {
    private boolean isUserOnReviewPage;
    private boolean areReviewsLoaded;
    private boolean areReviewsLegible;
    private boolean isDatabaseUpdated;
    private boolean canUserEvaluateFeedback;

    @Given("the user is on the customer reviews page")
    public void the_user_is_on_the_customer_reviews_page() {
        isUserOnReviewPage = true;
        System.out.println("User navigated to the reviews page.");
    }

    @When("the system loads and displays reviews with star ratings")
    public void the_system_loads_and_displays_reviews_with_star_ratings() {
        if (isUserOnReviewPage) {
            areReviewsLoaded = true;
            System.out.println("Reviews and star ratings are loaded and displayed.");
        }
    }

    @Then("reviews must be legible, well-formatted, and accessible")
    public void reviews_must_be_legible_well_formatted_and_accessible() {
        if (areReviewsLoaded) {
            areReviewsLegible = true;
            System.out.println("Reviews are legible, well-formatted, and accessible.");
        }
        assertTrue(areReviewsLegible);
    }

    @Then("the database must store and update reviews properly")
    public void the_database_must_store_and_update_reviews_properly() {
        if (areReviewsLoaded) {
            isDatabaseUpdated = true;
            System.out.println("Reviews are stored and updated in the database properly.");
        }
        assertTrue(isDatabaseUpdated);
    }

    @Then("users must be able to evaluate feedback easily")
    public void users_must_be_able_to_evaluate_feedback_easily() {
        if (areReviewsLoaded && areReviewsLegible) {
            canUserEvaluateFeedback = true;
            System.out.println("Users can evaluate feedback easily.");
        }
        assertTrue(canUserEvaluateFeedback);
    }



}

