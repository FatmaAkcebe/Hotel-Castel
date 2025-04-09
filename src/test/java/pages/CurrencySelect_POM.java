package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

import java.util.List;

public class CurrencySelect_POM extends ReusableMethods {

    public CurrencySelect_POM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "a[class='last dropdown'] span")
    public WebElement currencyUnit;

    @FindBy(xpath = "//a[@class='last dropdown active']")
    public WebElement currencyUnitClose;

    @FindBy(css = "div[id='div-currency-selector'] div[class='slimScrollDiv'] li")
    public List<WebElement> currencyList;

    @FindBy(xpath = "(//div[contains(@class,'av-rate-price')])[1]")
    public WebElement preisVonText;

    @FindBy(xpath = "//div[@id='div-currency-selector']")
    public WebElement dropDownMenu;
}