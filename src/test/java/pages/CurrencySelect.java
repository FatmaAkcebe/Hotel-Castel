package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

public class CurrencySelect extends ReusableMethods {

    public CurrencySelect() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "a[class='last dropdown active'] span")
    public WebElement currencyButton;
}