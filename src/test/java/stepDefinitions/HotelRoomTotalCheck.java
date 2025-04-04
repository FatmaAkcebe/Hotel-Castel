package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.HotelRoomTotalCheck_POM;

public class HotelRoomTotalCheck {
    HotelRoomTotalCheck_POM hr = new HotelRoomTotalCheck_POM();
    private String priceStr;
    private String breakfastPriceStr;
    private String gesamtStr;

    @And("The user checks if the total price updates correctly with added packages")
    public void theUserChecksIfTheTotalPriceUpdatesCorrectlyWithAddedPackages() {
        hr.wait.until(ExpectedConditions.visibilityOf(hr.roomPrices));
        priceStr = hr.roomPrices.getText().trim().replaceAll("[^0-9,]", "");

        hr.myClick(hr.checkBoxBreakfast);
        hr.wait.until(ExpectedConditions.visibilityOf(hr.breakfastPrice));
        breakfastPriceStr = hr.breakfastPrice.getText().trim().replaceAll("[^0-9,]", "");

        double price = 0.0;
        double breakfastPrice = 0.0;
        double gesamt = 0.0;

        if (!priceStr.isEmpty() && priceStr.matches("[0-9,]+")) {
            price = Double.parseDouble(priceStr.replace(",", "."));
        }

        if (!breakfastPriceStr.isEmpty() && breakfastPriceStr.matches("[0-9,]+")) {
            breakfastPrice = Double.parseDouble(breakfastPriceStr.replace(",", "."));
        }

        double totalPrice = price + breakfastPrice;
        String formattedPrice = String.format("%.1f", totalPrice).replace(".", ",");

        hr.myClick(hr.summeButton);
        hr.wait.until(ExpectedConditions.visibilityOf(hr.gesamt));
        gesamtStr = hr.gesamt.getText().trim().replaceAll("[^0-9,]", "");

        if (!gesamtStr.isEmpty() && gesamtStr.matches("[0-9,]+")) {
            gesamt = Double.parseDouble(gesamtStr.replace(",", "."));
        }

        double gesamtDbl = gesamt;
        String gesamtPrice = String.format("%.1f", gesamtDbl).replace(".", ",");

        Assert.assertTrue(formattedPrice.contains(gesamtPrice));
    }
}