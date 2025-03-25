package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

public class JetztBuchenButton_POM extends ReusableMethods {

    public JetztBuchenButton_POM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "(//a[@class='wpml-ls-link'])[5]")
    public WebElement deutschBtn;

    @FindBy(css = "[class='hotel_name ']")
    public WebElement bookNowControl;

    @FindBy(xpath = "(//a[@class='wpml-ls-link'])[6]")
    public WebElement englischBtn;
}