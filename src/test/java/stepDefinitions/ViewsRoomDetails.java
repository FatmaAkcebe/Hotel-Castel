package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.ViewRoomDetails_POM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ViewsRoomDetails {
    ViewRoomDetails_POM element = new ViewRoomDetails_POM();

    @And("The user views the Online-Preis section by clicking Details anzeigen link")
    public void theUserViewsTheOnlinePreisSectionByClickingDetailsAnzeigenLink() {
        element.myClick(element.detailsAnzeigenLink);

        if (element.standardRateText.isDisplayed()) {
            element.wait.until(ExpectedConditions.visibilityOf(element.standardRateText));
            element.verifyContainsText(element.standardRateText, "Standard Rate");
            element.verifyContainsText(element.erwachseneUndKinderText.getFirst(), "1 Erwachsene und 0 Kinder");

            if (!element.zusätzlicheBtn.isEmpty()) {
                element.myClick(element.zusätzlicheBtn.get(0));
                element.wait.until(ExpectedConditions.elementToBeClickable(element.nextBtn));
                if (element.nextBtn.isDisplayed() && element.backBtn.isDisplayed()) {
                    element.wait.until(ExpectedConditions.elementToBeClickable(element.nextBtn));
                    element.jsClick(element.nextBtn);
                    System.out.println("size:" + element.dateList.size());
                    Assert.assertTrue(element.dateList.size() == 7);

                    element.wait.until(ExpectedConditions.elementToBeClickable(element.backBtn));
                    element.jsClick(element.backBtn);
                    element.wait.until(ExpectedConditions.visibilityOfAllElements(element.dateList));
                    Assert.assertTrue(element.dateList.size() == 7);
                    element.verifyContainsText(element.adultBtn, "2.");
                    element.verifyContainsText(element.childBtn, "1.");
                }
            }
        }
    }

    @When("The user clicks on the tablist and displays to verifies content sections")
    public void theUserClicksOnTheTablistAndDisplaysToVerifiesContentSections(DataTable dataTable) {
        if (!element.zusätzlicheBtn.isEmpty()) {
            element.scrollToElement(element.beschreibungText);
            List<String> dataTableList = dataTable.asList();

            List<String> roomsDetail = new ArrayList<>();
            Collections.addAll(roomsDetail, "Beschreibung", "Zusatzleistungen", "Fotos");

            for (int i = 0; i < dataTableList.size(); i++) {
                element.myClick(element.getWebElement(dataTableList.get(i)));
                Assert.assertTrue(dataTableList.get(i).contains(roomsDetail.get(i)));
                Assert.assertTrue(element.tabContent.isDisplayed());
            }

            element.myClick(element.zusatzleistungenBtn);
            element.verifyContainsText(element.hausschuheText, "Hausschuhe");
            element.verifyContainsText(element.kabelfernsehenText, "Kabelfernsehen");
            element.verifyContainsText(element.heizungText, "Heizung");
        }
    }

    @Then("The user clicks on the link Details ausblenden to close all sections")
    public void theUserClicksOnTheLinkDetailsAusblendenToCloseAllSections() {
        if (!element.zusätzlicheBtn.isEmpty()) {
            element.myClick(element.fotosBtn);
            element.jsClick(element.fotosDescription);
            if (element.fotosGalleriaWindow.isDisplayed()) {
                for (int i = 0; i < element.smallFotoClick.size(); i++) {
                    element.myClick(element.smallFotoClick.get(i));
                }
                element.myClick(element.closeBtn);
            }
            element.myClick(element.detailsAusbledenLinks);
        }
    }
}