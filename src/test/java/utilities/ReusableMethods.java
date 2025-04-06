package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class ReusableMethods {
    public WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(ConfigReader.getIntProperty("explicit.wait")));

    public void myClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void mySendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void scrollToElement(WebElement elements) {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", elements);
    }

    public void robotExecute(int number) {
        try {
            Robot robot = new Robot();
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

    public void verifyContainsText(WebElement element, String value) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()));
        new Actions(GWD.getDriver()).sendKeys(Keys.ESCAPE).build().perform();
    }

    public void jsClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].click();", element);
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

    public static int[] generateCheckInOutDays(LocalDate today) {
        int todayDay = today.getDayOfMonth();
        int maxDaysInMonth = today.lengthOfMonth();

        Random random = new Random();
        int checkInDay = todayDay + random.nextInt(maxDaysInMonth - todayDay + 1);

        int checkOutDay = checkInDay + 1;

        if (checkOutDay > maxDaysInMonth) {
            checkOutDay = 1;
        }
        return new int[]{checkInDay, checkOutDay};
    }

    public void selectMenu(WebElement dropdownMenu, List<WebElement>list) {
        Select select = new Select(dropdownMenu);
        wait.until(ExpectedConditions.elementToBeClickable(dropdownMenu));
        dropdownMenu.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(list));
        select.selectByIndex(randomGenerator(list.size()));
    }

    public String getTextUsingJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        return (String) js.executeScript("return arguments[0]?.textContent.trim();", element);
    }
}
