package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

public class VerifyReservationDetails_POM extends ReusableMethods {

    public VerifyReservationDetails_POM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Vielen Dank!']")
    public WebElement vielenDankText;

    @FindBy(css = ".reserve_guestname")
    public WebElement guestName;

    @FindBy(xpath = "//p[@class='reserve_number']")
    public WebElement resNumber;

    @FindBy(xpath = "//td[contains(@class,'bold') and contains(text(),'Zimmertyp')]/following-sibling::td")
    public WebElement roomType;

    @FindBy(xpath = "//td[contains(@class,'bold') and contains(text(),'Check-in')]/following-sibling::td")
    public WebElement checkInDate;

    @FindBy(xpath = "//td[text()='Check-out']/following-sibling::td")
    public WebElement checkOutDate;

    @FindBy(xpath = "//td[text()='Erwachsene']/following-sibling::td")
    public WebElement adult;

    @FindBy(xpath = "//td[text()='Kinder']/following-sibling::td")
    public WebElement children;

    @FindBy(xpath = "//td[text()='Gesamt']/following-sibling::td")
    public WebElement inTotal;
}