package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

public class DisplayIntroduction_POM extends ReusableMethods {
    public DisplayIntroduction_POM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "(//div[@class='vc_row wpb_row vc_row-fluid']//p)[1]")
    public WebElement willkommenBeimTitle;

    @FindBy(xpath = "(//div[@class='vc_row wpb_row vc_row-fluid']//h3)[1]")
    public WebElement castleHotelRastattTitle;

    @FindBy(xpath = "((//div[@class='vc_row wpb_row vc_row-fluid'])[2]//p)[1]")
    public WebElement introTextContent;
}
