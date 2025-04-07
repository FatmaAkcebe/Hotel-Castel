package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;
import java.util.List;

public class CheckAvailability_POM extends ReusableMethods {
    public CheckAvailability_POM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "[value='Guests']")
    public WebElement searchGuest;

    @FindBy(css = "[class='ion-minus']")
    public WebElement guestDecreaseButton;

    @FindBy(css = "[class='ion-plus']")
    public WebElement guestIncreaseButton;

    @FindBy(xpath = "//*[text()='Check Availability']")
    public WebElement checkAvailabilityButton;

    @FindBy(xpath = "(//*[@id='multidate'])[1]")
    public WebElement multidate;

    @FindBy(css = "[class*='show-calendar']")
    public WebElement viewCalendar;

    @FindBy(xpath = "(//table[@class='table-condensed'])[1]/tbody/tr/td[contains(@class, 'available') and not(contains(@class, 'off'))]")
    public List<WebElement> multiDateList;

    public void clickDay(int day) {
        for (WebElement dayElement : multiDateList) {
            if (dayElement.getText().trim().equals(String.valueOf(day))) {
                dayElement.click();
                System.out.println("Clicked on day: " + day);
                break;
            }
        }
}}
