package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

import java.util.List;

public class ViewAvailableRoomsWithDetails_POM extends ReusableMethods {

    public ViewAvailableRoomsWithDetails_POM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "(//button[@type='button'])[5]")
    public WebElement adultDropdownButton;

    @FindBy(xpath = "(//button[@type='button'])[5]/following-sibling::div//li")
    public List<WebElement> adultSelection;

    @FindBy(xpath = "(//button[@type='button'])[6]")
    public WebElement childrenDropdownButton;

    @FindBy(xpath = "(//button[@type='button'])[6]/following-sibling::div//li")
    public List<WebElement> childrenSelection;

    @FindBy(xpath = "(//button[@type='button'])[7]")
    public WebElement roomDropdownButton;

    @FindBy(xpath = "(//button[@type='button'])[7]/following-sibling::div//li")
    public List<WebElement> roomSelection;

    @FindBy(css = "p[class='selected_rooms_price']")
    public WebElement totalPrice;
}
