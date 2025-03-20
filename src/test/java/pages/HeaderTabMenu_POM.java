package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

public class HeaderTabMenu_POM extends ReusableMethods {

    public HeaderTabMenu_POM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "(//a[@class='wpml-ls-link'])[5]")
    public WebElement deutschBtn;

    @FindBy(css = "[class='logo']")
    public WebElement logo;

    @FindBy(xpath = "(//*[text()='Start'])[3]")
    public WebElement startButton;

    @FindBy(xpath = "(//*[text()='Über uns'])[3]")
    public WebElement uberUnsButton;

    @FindBy(xpath = "(//*[text()='Anfahrt'])[3]")
    public WebElement anfahrtButton;

    @FindBy(xpath = "(//*[text()='Aktivitäten'])[3]")
    public WebElement aktivitatenButton;

    @FindBy(id = "masthead")
    public WebElement headerMenu;

    @FindBy(xpath = "(//*[@class='value'])[3]")
    public WebElement headerPhoneNumber;
}
