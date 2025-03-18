package runner;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

import java.util.List;

public class ChangeDatesIbrahim extends ReusableMethods {
    public ChangeDatesIbrahim() {
        
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "(//*[@id='primary-menu']/li[2]/a)[2]")
    public WebElement aboutUs;

    @FindBy(xpath = "//*[@id='text-2']/div")
    public WebElement aboutHotelDiv;

    @FindBy(xpath = "//*[@id='post-3801']/div/div[1]/div/div/div/div[4]/div")
    public WebElement unserHotelDiv;

    @FindBy(xpath = "//span[@class='icon-next']")
    public WebElement unserHotelButtonRight;

    @FindBy(xpath = "//span[@class='icon-prev']")
    public WebElement unserHotelButtonLeft;

    @FindBy(xpath = "(//*[@id='multidate'])[1]")
    public WebElement multidate;

    @FindBy(xpath = "(//*[@class='today active start-date active end-date in-range available'])[1]")
    public WebElement today;

    @FindBy(xpath = "(//td[@class='weekend available in-range'])[1]")
    public WebElement weekend;

    @FindBy(xpath = "(//button[text()='Check Availability'])[1]")
    public WebElement checkAvailability;

    @FindBy(xpath = "(//table[@class='table-condensed'])[1]/tbody/tr/td")
    public List<WebElement> multiDateList;
}
