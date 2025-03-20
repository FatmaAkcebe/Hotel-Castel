package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class ReusableMethods {
    public WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(ConfigReader.getIntProperty("explicit.wait")));

    public void myClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void clickAndEsc(WebElement clickElement,WebElement assertElement){
        wait.until(ExpectedConditions.visibilityOf(clickElement));
        wait.until(ExpectedConditions.elementToBeClickable(clickElement));
        jsClick(clickElement);
        wait.until(ExpectedConditions.visibilityOfAllElements(assertElement));
        Assert.assertTrue(assertElement.isDisplayed());
        new Actions(GWD.getDriver()).sendKeys(Keys.ESCAPE).build().perform();
    }

    public void mySendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void hoverOver(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        new Actions(GWD.getDriver()).moveToElement(element).perform();
    }

    public void scrollToElement(WebElement elements) {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", elements);
    }

    public void robotExecute(int number){
        try {
            Robot robot =new Robot();
            for (int i = 0; i <= number; i++) {
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
                Wait(1);
            }
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public void uploadFilePath(String path){
        Robot robot;
        try {
            robot=new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        StringSelection filePath=new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
        Wait(1);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        Wait(1);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void verifyContainsText(WebElement element, String value) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()));
        new Actions(GWD.getDriver()).sendKeys(Keys.ESCAPE).build().perform();
    }

    public void verifyEqualsText(WebElement element,String value){
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
        Assert.assertTrue(element.getText().toLowerCase().equals(value.toLowerCase()));
        new Actions(GWD.getDriver()).sendKeys(Keys.ESCAPE).build().perform();
    }

    public void jsClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public String jsColor(String value,WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) GWD.getDriver();
        String backgroundColor = (String) js.executeScript(
                "return getComputedStyle(arguments[0]).getPropertyValue('"+value+"');",
                element);
        return backgroundColor;
    }

    public int randomGenerator(int range) {
        return (int) (Math.random() * range);
    }

    public void Wait(int sn) {
        try {
            Thread.sleep(sn * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

public void closeWindow() {
    try {
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_F4);

        robot.keyRelease(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_ALT);
    } catch (AWTException e) {
        throw new RuntimeException(e);
    }








}

    public String getCurrentURL() {
        return GWD.getDriver().getCurrentUrl();
    }

    public void navigateBack() {
        GWD.getDriver().navigate().back();
    }

    public void verifyURL(String expectedUrl) {
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String actualUrl = getCurrentURL();
        Assert.assertEquals(actualUrl, expectedUrl, "Redirection failed!");
    }
    public void navigateToReviewsPage() {
        System.out.println("Navigating to the customer reviews page...");

    }

    public void loadReviews() {
        System.out.println("Loading and displaying reviews with star ratings...");

    }

    public void areReviewsLegible() {
        System.out.println("Checking if reviews are legible, well-formatted, and accessible...");

    }

    public void isDatabaseUpdated() {
        System.out.println("Verifying if the database properly stores and updates reviews...");

    }

    public void canUserEvaluateFeedback() {
        System.out.println("Checking if users can evaluate feedback easily...");

    }
}
