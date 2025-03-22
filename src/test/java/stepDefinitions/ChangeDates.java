package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.ChangeDatesIbrahim;
import pages.DialogContent;
import utilities.GWD;

import java.time.LocalDate;
import java.time.Month;

public class ChangeDates {
    JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
    ChangeDatesIbrahim dc =  new ChangeDatesIbrahim();
    DialogContent dh= new DialogContent();
    @When("Click on the date picker")
    public void clickOnTheDatePicker() {
        dc.scrollToElement(dc.multidate);
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].click();", dc.multidate);
    }

    @Then("Select a check-in date")
    public void selectACheckInDate() {
        int todayP = Integer.parseInt(dc.today.getText());
        LocalDate today = LocalDate.now();
        LocalDate lastDay = today.withDayOfMonth(30);
        int randomDay = (int) (Math.random() * (30 - today.getDayOfMonth() + 1)) + today.getDayOfMonth();
        System.out.println("randomDay = " + randomDay);


        String url= "https://hotels.cloudbeds.com/de/reservas/pwWAUD#checkin=2025-03-"+todayP+"&checkout=2025-03-"+randomDay;

        dc.myClick(dc.today);
        dc.myClick(dc.multiDateList.get(randomDay));
        dc.myClick(dc.checkAvailability);

        dc.wait.until(ExpectedConditions.visibilityOf(dc.checkAvailabilityButton));

    }

    @Then("Try to select a check-out date that is before the check-in date")
    public void tryToSelectACheckOutDateThatIsBeforeTheCheckInDate() {
        int today = Integer.parseInt(dc.today.getText());
        int randomInt = (int) (1 * today);
        System.out.println("randomInt = " + randomInt);

        js.executeScript("arguments[0].click();", dc.today);


        for (int i = today; i < randomInt; i++) {
            dc.myClick(dc.multiDateList.get(randomInt-1));
            Assert.assertFalse(dc.multiDateList.get(i).isSelected());
            break;
        }
        Assert.assertTrue(dc.checkAvailabilityButton.isDisplayed());
    }

    @And("change a check-in date")
    public void changeACheckInDate() {
//        LocalDate todayLocale = LocalDate.now();
//        int today = Integer.parseInt(todayLocale.toString());
//        Month thisMonthLocale = todayLocale.getMonth();
//        int thisMont= Integer.parseInt(thisMonthLocale.toString());
//        int thisYear =LocalDate.now().getYear();
//        int randomDay = (int) (Math.random() * 30) + 1;
//
//        js.executeScript("arguments[0].click();", dc.today);
//
//        dc.checkIn.sendKeys(today+1);
        dc.myClick(dc.checkIn);
//        String currentDate = dc.checkIn.getAttribute("value");
//
//        String[] dateParts = currentDate.split("/");
//        int day = Integer.parseInt(dateParts[0]);
//        int month = Integer.parseInt(dateParts[1]);
//        int year = Integer.parseInt(dateParts[2]);
//
//        day += 1;
//        if (day > 30) {
//            day = 1;
//            month += 1;
//            if (month > 12) {
//                month = 1;
//                year += 1;
//            }
//        }
//
//        String newDate = String.format("%02d/%02d/%d", day, month, year);
//        dc.checkIn.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
//        dc.checkIn.sendKeys(newDate);
        int year = 2025;

        // 1-12 arası rastgele ay üret
        int checkInMonth = (int) (Math.random() * 12) + 1;

        // 1-30 arası rastgele gün üret
        int checkInDay = (int) (Math.random() * 30) + 1;

        // Check-in'den 1-3 gün sonrası için check-out günü belirle
        int checkOutDay = checkInDay + (int) (Math.random() * 3) + 1;
        int checkOutMonth = checkInMonth;

        // Eğer gün 30'u aşarsa bir sonraki aya geç
        if (checkOutDay > 30) {
            checkOutDay -= 30;
            checkOutMonth++;
            if (checkOutMonth > 12) {
                checkOutMonth = 1;
                year++;
            }
        }
        String newDate = String.format("%02d/%02d/%d", checkOutDay, checkInMonth, year);
        dc.checkIn.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        dc.checkIn.sendKeys(newDate);
    }

    @Then("change a check-out date")
    public void changeACheckOutDate() {
//        LocalDate today = LocalDate.now();
//        Month thisMonth = today.getMonth();
//        int thisYear =LocalDate.now().getYear();
//        int randomDay = (int) (Math.random() * 30) + 1;
//
//        js.executeScript("arguments[0].click();", dc.today);
//
//        dc.checkIn.sendKeys(today+1+"/"+thisMonth+1+"/"+thisYear);
        dc.myClick(dc.checkOut);
        String currentDate = dc.checkIn.getAttribute("value");

        String[] dateParts = currentDate.split("/");
        int day = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int year = Integer.parseInt(dateParts[2]);

        day += 2;
        if (day > 30) {
            day = 1;
            month += 1;
            if (month > 12) {
                month = 1;
                year += 1;
            }
        }

        String checkOutDate = String.format("%02d/%02d/%d", day, month, year);
        dc.checkOut.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        dc.checkOut.sendKeys(checkOutDate);
    }
}
