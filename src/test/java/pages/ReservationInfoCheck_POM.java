package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

import java.util.List;

public class ReservationInfoCheck_POM extends ReusableMethods {

    public ReservationInfoCheck_POM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "(//button[@type='button'])[7]")
    public WebElement roomDropdownButton;

    @FindBy(xpath = "(//button[@type='button'])[7]/following-sibling::div//li")
    public List<WebElement> roomSelection;

    @FindBy(linkText = "JETZT BUCHEN")
    public WebElement bookNowBtn;

    @FindBy(xpath = "(//div[@class='availability_list']//div[@class='av-name'])[1]")
    public WebElement titleText;

    @FindBy(css = "p[class='selected_rooms_price']")
    public WebElement priceText;

    @FindBy(css = "h2[class='medium']")
    public WebElement resInfo;

    @FindBy(xpath = "//p[@class='short_info2']")
    public WebElement resTitle;

    @FindBy(xpath = "//div[@class='grand_total']//div[@class='row']/div[2]")
    public WebElement resPrice;

    @FindBy(css = "p[class='checkin_date']")
    public WebElement checkInText;

    @FindBy(css = "p[class='checkout_date']")
    public WebElement checkOutText;
}
