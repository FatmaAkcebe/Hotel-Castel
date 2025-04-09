package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

import java.util.List;

public class HotelInformation_POM extends ReusableMethods {

    public HotelInformation_POM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(linkText = "JETZT BUCHEN")
    public WebElement bookNowButton;

    @FindBy(xpath = "//div[@class='caption']")
    public WebElement informationenZurAnlage;

    @FindBy(xpath = "//div[@class='map_info']/p")
    public List<WebElement> hotelDetails;

    @FindBy(xpath = "(//div[@class='checkin-checkout-terms-block'])[2]")
    public WebElement reservationDetails;

    @FindBy(css = "div[class='checkin-checkout-terms-block'] h5")
    public WebElement checkInCheckOutText;
}