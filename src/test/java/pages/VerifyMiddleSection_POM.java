package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

public class VerifyMiddleSection_POM extends ReusableMethods {

    public VerifyMiddleSection_POM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

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
    public WebElement aktivitatenPageContent;
}
