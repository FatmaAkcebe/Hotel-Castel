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

    @FindBy(xpath = "(//ul[@id='primary-menu']//a[text()='Anfahrt'])[2]")
    public WebElement anfahrt;

    @FindBy(xpath = "//div//li[@class='menu-right']//a[@class='wpml-ls-link']/img[@alt='Deutsch']")
    public WebElement almanca;

    @FindBy(xpath = "(//a[@class='wpml-ls-link'])[5]")
    public WebElement deutschBtn;

    @FindBy(css = "[class='hotel_name ']")
    public WebElement bookNowControl;

    @FindBy(xpath = "(//a[@class='wpml-ls-link'])[6]")
    public WebElement englischBtn;

    @FindBy(xpath = "(//div[@class='vc_row wpb_row vc_row-fluid']//p)[1]")
    public WebElement willkommenBeimTitle;

    @FindBy(xpath = "(//div[@class='vc_row wpb_row vc_row-fluid']//h3)[1]")
    public WebElement castleHotelRastattTitle;

    @FindBy(xpath = "((//div[@class='vc_row wpb_row vc_row-fluid'])[2]//p)[1]")
    public WebElement introTextContent;

    @FindBy(css = ".thim-sc-categories-link a.categories-link[href$='anfahrt']")
    public WebElement midSectionAnfahrt;

    @FindBy(css = ".thim-sc-categories-link a.categories-link[href$='ueber-uns']")
    public WebElement midSectionUberUns;

    @FindBy(css = ".thim-sc-categories-link a.categories-link[href$='aktivitaeten']")
    public WebElement midSectionAktivitaten;

    @FindBy(css = ".wpb_wrapper img[alt='hotelrastattanfahrt-min (1)']")
    public WebElement anfahrtImg;

    @FindBy(css = ".wpb_wrapper img[alt='hotelrastattüberuns-min (1)']")
    public WebElement uberUnsImg;

    @FindBy(css = ".wpb_wrapper img[alt='rastatt hotel schloss']")
    public WebElement aktivitatenImg;

    @FindBy(css = "div[class='vc_row wpb_row vc_row-fluid no-fill-sm category-group vc_row-no-padding']")
    public WebElement homepageMiddleSection;

    @FindBy(css = "div.wpb_wrapper h3.heading_secondary")
    public WebElement anfahrtPageContent;

    @FindBy(css = "div.wpb_wrapper h3.heading_secondary")
    public WebElement uberUnsPageContent;

    @FindBy(css = "div.wpb_wrapper h3.heading_secondary")
    public WebElement activitatenPageContent;

    @FindBy(css = "[class='logo']")
    public WebElement logo;

    @FindBy(xpath = "(//*[text()='Start'])[3]")
    public WebElement startButton;

    @FindBy(xpath = "(//*[text()='Über uns'])[3]")
    public WebElement uberUnsButton;

    @FindBy(xpath = "(//*[text()='Anfahrt'])[3]")
    public WebElement anfahrtButton;

    @FindBy(xpath = "(//*[text()='Aktivitäten'])[3]")
    public WebElement aktivitätenButton;

    @FindBy(id = "masthead")
    public WebElement headerMenu;

    @FindBy(xpath = "(//*[@class='value'])[3]")
    public WebElement headerPhoneNumber;

    @FindBy(xpath = "//*[text()='Impressum']")
    public WebElement impressumButton;

    @FindBy(xpath = "//*[text()='Datenschutz']")
    public WebElement datenschutzButton;

    @FindBy(css = "[class='scrolldown']")
    public WebElement goUpButton;

    @FindBy(xpath = "//*[text()='OK']")
    public WebElement okButton;

    @FindBy(css = "[class='footer ']")
    public WebElement footerMenu;

    @FindBy(xpath = "//*[text()='07222 1590750']")
    public WebElement footerPhoneNumber;

    @FindBy(xpath = "(//*[@class='info'])[2]")
    public WebElement emailAddress;
}
