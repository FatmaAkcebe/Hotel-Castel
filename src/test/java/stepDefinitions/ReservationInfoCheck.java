package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.ReservationInfoCheck_POM;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReservationInfoCheck {

    ReservationInfoCheck_POM element = new ReservationInfoCheck_POM();
    private static CheckAvailableRooms checkAvailableRooms;
    private String roomTitle;
    private String price;

    public static void setCheckAvailableRooms(CheckAvailableRooms checkAvailableRooms) {
        ReservationInfoCheck.checkAvailableRooms = checkAvailableRooms;
    }

    @When("The user selects a room from the available list")
    public void theUserSelectsARoomFromTheAvailableList() {
        element.wait.until(ExpectedConditions.visibilityOf(element.roomDropdownButton));
        element.myClick(element.roomDropdownButton);

        for (WebElement room : element.roomSelection) {
            String index = room.getAttribute("data-original-index");
            if (index.equals("1")) {
                room.click();
                break;
            }
        }
        roomTitle = element.titleText.getText().trim();
        price = element.priceText.getText().trim().replaceAll("[^0-9,]", "");
    }

    @And("The user proceeds to the information filling screen")
    public void theUserProceedsToTheInformationFillingScreen() {
        element.myClick(element.bookNowBtn);
    }

    @Then("The reservation details on the information filling screen should match the selected details")
    public void theReservationDetailsOnTheInformationFillingScreenShouldMatchTheSelectedDetails() {
        element.wait.until(ExpectedConditions.visibilityOf(element.resInfo));

        String fullText = element.resTitle.getText().trim();
        String firstText = fullText.split("\n")[0].replaceAll("\\(x\\d+\\)", "").trim();

        String textcheckInDate = element.checkInText.getText().trim();
        LocalDate textLocalCheckInDate = LocalDate.parse(textcheckInDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate checkInDate = checkAvailableRooms.getCheckInDate();

        String textcheckOutDate = element.checkOutText.getText().trim();
        LocalDate textLocalCheckOutDate = LocalDate.parse(textcheckOutDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate checkOutDate = checkAvailableRooms.getCheckOutDate();

        Assert.assertTrue(roomTitle.contains(firstText));
        Assert.assertTrue(price.contains(element.resPrice.getText().trim().replaceAll("[^0-9,]", "")));
        Assert.assertEquals(textLocalCheckInDate, checkInDate);
        Assert.assertEquals(textLocalCheckOutDate, checkOutDate);
    }
}
