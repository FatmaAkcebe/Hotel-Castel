package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

public class CheckIfTheHotel_POM extends ReusableMethods {

    public CheckIfTheHotel_POM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "(//div[@class='vc_column-inner'])[1]")
    public WebElement text;

    @FindBy(xpath = "//div[@class='entry-content']")
    public WebElement Aktivitäten;

    @FindBy(xpath = "(//a[text()='Anfahrt'])[3]")
    public WebElement anfahrt;

    @FindBy(xpath = "(//*[text()='Aktivitäten'])[3]")
    public WebElement aktivitätenButton;
}