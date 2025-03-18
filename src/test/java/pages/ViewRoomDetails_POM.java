package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

import java.util.List;

public class ViewRoomDetails_POM extends ReusableMethods {
    public ViewRoomDetails_POM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "span[data-closed-details-text='Details anzeigen']")
    public WebElement detailsAnzeigenLink;

    @FindBy(css = "span[data-opened-details-text='Details ausblenden']")
    public WebElement detailsAusbledenLinks;

    @FindBy(xpath = "//h4[text()='Standard Rate']")
    public WebElement standardRateText;

    @FindBy(xpath = "//p[contains(text(),'(inkl. 1 Erwachsene und 0 Kinder)')]")
    public List<WebElement> erwachseneUndKinderText;

    @FindBy(partialLinkText = "Zusätzliche")
    public WebElement zusätzlicheBtn;

    @FindBy(xpath = "//td[@class='adult']")
    public WebElement adultBtn;

    @FindBy(xpath = "//td[@class='child']")
    public WebElement childBtn;

    @FindBy(css = "btn grey additional-guests-prev prev")
    public WebElement backBtn;

    @FindBy(css= "btn grey additional-guests-next next")
    public WebElement nextBtn;

    @FindBy(css = "tab_rate_id_description")
    public WebElement beschreibungBtn;

    @FindBy(css = "tab_rate_id_features")
    public WebElement zusatzleistungenBtn;

    @FindBy(css= "tab_rate_id_photos")
    public WebElement fotosBtn;

    @FindBy(css = "tab-pane tab_rate_id_description active")
    public WebElement beschreibungText;

    @FindBy(xpath = "(//div[@class='tab-pane amenities_tab tab_rate_id_features active']/ul/li)[1]")
    public WebElement hausschuheText;

    @FindBy(xpath = "(//div[@class='tab-pane amenities_tab tab_rate_id_features active']/ul/li)[2]")
    public WebElement voltSteckdosenText;

    @FindBy(xpath = "(//div[@class='tab-pane amenities_tab tab_rate_id_features active']/ul/li)[3] ")
    public WebElement kabelfernsehenText;

    @FindBy(css = "tab-pane photo_content tab_rate_id_photos active")
    public WebElement fotosDescription;

    @FindBy(xpath = "//div[@class='tab-content']")
    public WebElement fotosPanel;

    @FindBy(xpath = "//div[@class='small']")
    public List<WebElement> smallFotos;

    @FindBy(xpath = "//div[@id='galleria']")
    public WebElement fotosGalleriaWindow;

    @FindBy(css = "div [id='modal-close']")
    public WebElement closeBtn;

    @FindBy(xpath = "//div[@class='galleria-thumbnails minimap scrollable']/div")
    public List<WebElement> fotosList;

}
