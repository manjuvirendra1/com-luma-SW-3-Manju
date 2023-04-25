package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class Utility extends BaseTest {

    /**
     * This method will hoover mouse on element
     */
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);

        actions.moveToElement(mouseHoover).build().perform();
    }

    /**
     * This method will hoover mouse and click on element
     */
    public void mouseHoverAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);

        actions.moveToElement(mouseHoover).click().build().perform();
    }
    /**
     * This method will hoover mouse on element
     */
    public WebElement mouseHover(By by)
    {
        return driver.findElement(by);
    }

    /**
     * This method will click on element
     */
    public void clickOnElement(By by)
    {
        driver.findElement(by).click();
    }


    /**
     * This method will clearTextFromField on element
     */
    public void clearTextFromField(By by) {
        driver.findElement(by).sendKeys(Keys.CONTROL + "a");
        driver.findElement(by).sendKeys(Keys.DELETE);
    }


    /**
     * This method will send text to element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();

    }
    /**
     * This method will verify text displayed on web page
     */
    public void verifyText(String expectedMessage, By by, String displayMessage) {
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals(displayMessage, expectedMessage, actualMessage);
    }

}