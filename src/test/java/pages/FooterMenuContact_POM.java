package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

public class FooterMenuContact_POM extends ReusableMethods {

    public FooterMenuContact_POM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Impressum']")
    public WebElement impressumButton;

    @FindBy(xpath = "//*[text()='Datenschutz']")
    public WebElement datenschutzButton;

    @FindBy(css = "[class='scrolldown']")
    public WebElement goUpButton;

    @FindBy(xpath = "//*[text()='OK']")
    public WebElement okButton;

    @FindBy(css = "[class='footer ']")
    public WebElement footerMenu;

    @FindBy(xpath = "//*[text()='07222 1590750']")
    public WebElement footerPhoneNumber;

    @FindBy(xpath = "(//*[@class='info'])[2]")
    public WebElement emailAddress;
}


