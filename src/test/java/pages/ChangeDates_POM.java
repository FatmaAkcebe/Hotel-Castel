package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

import java.util.List;

public class ChangeDates_POM extends ReusableMethods {
    public ChangeDates_POM() {

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

    @FindBy(xpath = "(//td[@class='today weekend active start-date active end-date in-range available'])[1]")
    public WebElement today;

    @FindBy(xpath = "(//button[text()='Check Availability'])[1]")
    public WebElement checkAvailability;

    @FindBy(xpath = "(//table[@class='table-condensed'])[1]/tbody/tr/td")
    public List<WebElement> multiDateList;

    @FindBy(xpath = "//*[@class='next available']")
    public WebElement nextAvailable;

    @FindBy(css = "input[name='search_start_date']")
    public WebElement checkIn;

    @FindBy(css = "input[name='search_end_date']")
    public WebElement checkOut;

    @FindBy(xpath = "(//button[@name='check_availability'])[2]")
    public WebElement checkAvailabilityButton;

    @FindBy(xpath = "//div[@class='availability_list']")
    public WebElement newRooms;

    @FindBy(className = "message_container")
    public WebElement message;
}
