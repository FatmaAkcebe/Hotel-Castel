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

    @FindBy(xpath = "(//ul[@id='primary-menu']//a[text()='Location'])[2]")
    public WebElement anfahrt;

    @FindBy(xpath = "//div//li[@class='menu-right']//a[@class='wpml-ls-link']/img[@alt='Deutsch']")
    public WebElement almanca;

    @FindBy(xpath = "(//div[@class='wpb_wrapper'])[1]")
    public WebElement text;

    @FindBy(xpath = "//div[@style='position: absolute; left: 0px; top: 0px; width: 256px; height: 256px;']")
    public WebElement map;

    @FindBy(xpath = "//button[@aria-label='Sokak haritasını göster']")
    public WebElement mapName;

    @FindBy(xpath = "//button[@aria-label='Tam ekran görünümü açma/kapama']")
    public WebElement fullScreen;

    @FindBy(xpath = "//button[@draggable='false' and @aria-label='Harita kamerası kontrolleri']")
    public WebElement controlKey;

    @FindBy(xpath = "//button[@draggable='false' and @aria-label='Yukarı taşı']")
    public WebElement upKey;

    @FindBy(xpath = "//button[@draggable='false' and @aria-label='Sola taşı']")
    public WebElement leftKey;

    @FindBy(xpath = "//button[@draggable='false' and @aria-label='Sağa taşı']")
    public WebElement rightKey;

    @FindBy(xpath = "//button[@draggable='false' and @aria-label='Aşağı taşı']")
    public WebElement downKey;

    @FindBy(xpath = "//button[@draggable='false' and @aria-label='Büyüt']")
    public WebElement enlarge;

    @FindBy(xpath = "//button[@draggable='false' and @aria-label='Küçült']")
    public WebElement reduce;

    @FindBy(xpath = "//button[@draggable='false' and @aria-label='Street View'u açmak için Pegman'i harita üzerine sürükleyin']")
    public WebElement streetView;

    @FindBy(xpath = "(//ul[@id='primary-menu']//a[text()='Activities'])[2]")
    public WebElement aktivitaten;

    @FindBy(xpath = "//h3[text()='OUR HOTEL']")
    public WebElement ourHotel;
}
