package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

import java.util.List;

public class DialogContent extends ReusableMethods {

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(linkText = "JETZT BUCHEN")
    public WebElement bookNowButton;

    @FindBy(xpath = "(//button[@name='check_availability'])[2]")
    public WebElement checkAvailabilityButton;

    @FindBy(css = "input[name='search_start_date']")
    public WebElement searchStartDate;

    @FindBy(css = "input[name='search_end_date']")
    public WebElement searchEndDate;

    @FindBy(xpath = "//div[@id='wizard-container']//div[@class='av_wrapper' and not(contains(@style, 'display: none'))]//div[@class='av-name']")
    public List<WebElement> roomTitles;

    @FindBy(xpath = "//div[contains(@class, 'av-rate-price') and not(contains(@style, 'display: none'))]//span")
    public List<WebElement> roomPrices;

    @FindBy(xpath = "(//button[@type='button'])[5]")
    public WebElement adultDropdownButton;

    @FindBy(xpath = "(//button[@type='button'])[5]/following-sibling::div//li")
    public List<WebElement> adultSelection;

    @FindBy(xpath = "(//button[@type='button'])[6]")
    public WebElement childrenDropdownButton;

    @FindBy(xpath = "(//button[@type='button'])[6]/following-sibling::div//li")
    public List<WebElement> childrenSelection;

    @FindBy(xpath = "(//button[@type='button'])[7]")
    public WebElement roomDropdownButton;

    @FindBy(xpath = "(//button[@type='button'])[7]/following-sibling::div//li")
    public List<WebElement> roomSelection;

    @FindBy(css = "p[class='selected_rooms_price']")
    public WebElement totalPrice;

    @FindBy(xpath = "//li[@id='menu-item-3867']//a[text()='Location']")
    public WebElement anfahrt;

    @FindBy(xpath = "//li[@id='menu-item-3853']/following-sibling::li//a[@class='wpml-ls-link']/img[@alt='Deutsch']")
    public WebElement almanca;

}
