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
    public List<WebElement>zusätzlicheBtn;

    @FindBy(xpath = "//span[text()='2.']")
    public WebElement adultBtn;

    @FindBy(xpath = "//span[text()='1.']")
    public WebElement childBtn;

    @FindBy(xpath = "//a[text()='<']")
    public WebElement backBtn;

    @FindBy(xpath = "//a[text()='>']")
    public WebElement nextBtn;

    @FindBy(css = "th.date")
    public List<WebElement> dateList;

    @FindBy(xpath = "//a[contains(text(),'Beschreibung')]")
    public WebElement beschreibungBtn;

    @FindBy(xpath = "//a[contains(text(),'Zusatzleistungen')]")
    public WebElement zusatzleistungenBtn;

    @FindBy(xpath = "//a[contains(text(),'Fotos')]")
    public WebElement fotosBtn;

    @FindBy(xpath = "(//font[@xss='removed'])[2]")
    public WebElement beschreibungText;

    @FindBy(css = "[class='tab-content']")
    public WebElement tabContent;

    @FindBy(xpath = "(//*[text()='Hausschuhe'])[1]")
    public WebElement hausschuheText;

    @FindBy(xpath = "(//*[text()='Kabelfernsehen'])[1]")
    public WebElement kabelfernsehenText;

    @FindBy(xpath = "(//*[text()='Heizung'])[1]")
    public WebElement heizungText;

    @FindBy(css = "[class='room_image']")
    public WebElement fotosDescription;

    @FindBy(css = "[class='image']")
    public List<WebElement> smallFotoClick;

    @FindBy(xpath = "//div[@id='galleria']")
    public WebElement fotosGalleriaWindow;

    @FindBy(css = "div [id='modal-close']")
    public WebElement closeBtn;

    public WebElement getWebElement(String menuItem) {
        switch (menuItem) {
            case "Beschreibung":
                return this.beschreibungBtn;
            case "Zusatzleistungen":
                return this.zusatzleistungenBtn;
            case "Fotos":
                return this.fotosBtn;
        }
        return null;
    }
}
