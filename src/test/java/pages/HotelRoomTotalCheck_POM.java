package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

public class HotelRoomTotalCheck_POM extends ReusableMethods {

    public HotelRoomTotalCheck_POM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='box']")
    public WebElement checkBoxBreakfast;

    @FindBy(xpath = "//div[@class='price']")
    public WebElement breakfastPrice;

    @FindBy(css = "button[type='submit']")
    public WebElement summeButton;

    @FindBy(xpath = "//td[@class='total_column']")
    public WebElement roomsPrices;

    @FindBy(xpath = "(//p[@class='grand_total'])[6]")
    public WebElement gesamt;
}
