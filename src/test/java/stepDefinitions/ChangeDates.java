package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.ChangeDatesIbrahim;
import utilities.GWD;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class ChangeDates {
    ChangeDatesIbrahim dc = new ChangeDatesIbrahim();
    // 1 ile 19 arası random sayı üret.
    int randomNumber = (int)(Math.random() * (20 - 1 + 1)) + 1;

    @When("select check-in and check out dates")
    public void selectCheckInAndCheckOutDates() {
        dc.myClick(dc.checkAvailability);
        Set<String> windowHandles = GWD.getDriver().getWindowHandles();
        for (String handle : windowHandles) {
            GWD.getDriver().switchTo().window(handle); // Yeni sekmeye geçiş yap
        }
        dc.myClick(dc.checkIn);
    }

    @And("user changes Check-in date")
    public void userChangesCheckInDate() {
        // Bugünün tarihini al
        LocalDate today = LocalDate.now();
        // Bugünden random bir şekilde başka tarihe ilerle
        LocalDate futureDate = today.plusDays(randomNumber);
        // Belirlenen Tarihi "dd/MM/yyyy" formatına çevir
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Tarihi belirlenen formata çevirip Stringe ata
        String formattedDate = futureDate.format(formatter);

        // İnput'daki eski tarihi sil

        dc.checkIn.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        // Stringe çevirdiğimiz tarihi içine ata
        dc.checkIn.sendKeys(formattedDate);
    }

    @And("user changes Check-out date")
    public void userChangesCheckOutDate() {
        // CheckOut a tıkla
        dc.myClick(dc.checkOut);
        LocalDate today = LocalDate.now();
        // Yukarıda seçtiğimiz tarihin 2 gün ilerisine git
        LocalDate futureDate = today.plusDays(randomNumber+2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = futureDate.format(formatter);

        dc.checkOut.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        // 2 Gün ilerisi olarak seçtiğimiz tarihi CheckOut a ata
        dc.checkOut.sendKeys(formattedDate);
    }

    @Then("New rooms should come")
    public void newRoomsShouldCome() {
        // Yeni odalar geliyor mu kontrol et
        Assert.assertTrue(dc.newRooms.isDisplayed());
    }
}
