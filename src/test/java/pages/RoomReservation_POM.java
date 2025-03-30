package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

import java.util.List;

public class RoomReservation_POM extends ReusableMethods {
    public RoomReservation_POM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//b[text()='Kasse']")
    public WebElement kasseText;

    @FindBy(css = "[name='first_name']")
    public WebElement firstName;

    @FindBy(css = "[name='last_name']")
    public WebElement lastName;

    @FindBy(css = "[name='email']")
    public WebElement email;

    @FindBy(css = "[name='phone']")
    public WebElement phone;

    @FindBy(css = "[name='country']")
    public WebElement selectCountryMenu;

    @FindBy(xpath = "//select[@name='country']//option")
    public List<WebElement>selectCountry;

    @FindBy(css = "[name='zip']")
    public WebElement zipCode;

    @FindBy(css = "[name='address1']")
    public WebElement address1;

    @FindBy(css = "[name='address2']")
    public WebElement address2;

    @FindBy(css = "[name='city']")
    public WebElement city;

    @FindBy(css = "[name='state']")
    public WebElement selectStateMenu;

    @FindBy(xpath = "//select[@name='state']//option")
    public List<WebElement>selectState;

    @FindBy(css = "[title='Gastname']")
    public WebElement gastName;

    @FindBy(css = "[title='Auftragsnummer']")
    public WebElement auftragsnummer;

    @FindBy(css = "[title='VAT ID']")
    public WebElement vatID;

    @FindBy(css = "[title='Kostenstelle']")
    public WebElement kostenstelle;

    @FindBy(css = "[data-label='Referenz']")
    public WebElement referenz;

    @FindBy(linkText = "Ich stimme den")
    public WebElement acceptTextControl;

    @FindBy(xpath = "//label[@for='agree_terms']/span[@class='box']")
    public WebElement agreeTermsCheckBox;

    @FindBy(xpath = "//button[contains(@class,'finalize btn ')]")
    public WebElement reservierungBtn;

    @FindBy(xpath = "//*[text()='Vielen Dank!']")
    public WebElement vielenDankText;
}
