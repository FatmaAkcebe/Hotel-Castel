package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

public class VC_POM extends ReusableMethods {
    public VC_POM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }


    @FindBy(css = "div[class*='testimonial-overlay']")
    public WebElement commentSection;

    @FindBy(css = "[class='thim-sc-testimonial left ']")
    public WebElement comments;

    @FindBy(xpath = "//div[@class='owl-dots']/div[1]")
    public WebElement firstDot;

    @FindBy(xpath = "//div[@class='owl-dots']/div[2]")
    public WebElement secondDot;

    @FindBy(xpath = "//div[@class='owl-dots']/div[3]")
    public WebElement  thirdDot;

    @FindBy(xpath = "(//*[@class= 'testimonial-name'])[3]")
    public WebElement firstComment;

    @FindBy(xpath = "(//*[@class= 'testimonial-name'])[4]")
    public WebElement secondComment;

    @FindBy(xpath = "(//*[@class= 'testimonial-name'])[5]")
    public WebElement thirdComment;

    @FindBy(xpath = "//div[contains(@class, 'active')]//h5[contains(@class, 'testimonial-name')]")
    public WebElement  activeCommenter;
}

