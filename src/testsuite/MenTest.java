package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.Utility;

public class MenTest extends Utility {
    //Inheriting the BaseTest Class
    String baseUrl = "https://magento.softwaretestingboard.com/";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() {
        // Mouse Hoover on Men Menu
        WebElement menMenu = driver.findElement(By.xpath("//a[@id='ui-id-5']//span[contains(text(),'Men')]"));
        //Mouse Hover on Bottoms
        WebElement tops = driver.findElement(By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menMenu).moveToElement(tops).build().perform();
        // Click on Pants
        clickOnElement(By.xpath("//a[@id='ui-id-23']"));
        //Mouse Hover on product name‘Cronus Yoga Pant’ and click on size 32.
        clickOnElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));
        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        clickOnElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]"));
        //Mouse Hover on product name‘Cronus Yoga Pant’ and click on‘Add To Cart’ Button.
        clickOnElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]/span[1]"));

        //Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        verifyText("You added Cronus Yoga Pant to your shopping cart.", By.xpath("//body[1]/div[1]/main[1]/div[2]/div[2]/div[1]/div[1]/div[1]"),
                "You added Cronus Yoga Pant to your shopping cart.");

        // Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[@class='action showcart']" ));
        // Click on ‘view and Edit cart’ Link into message
        clickOnElement(By.xpath("//span[normalize-space()='View and Edit Cart']"));

        // Verify the text ‘Shopping Cart’
        verifyText("Shopping Cart", By.xpath("//span[@class='base']"), "Shopping Cart");

        //Verify the product name ‘Cronus Yoga Pant’
        verifyText("Cronus Yoga Pant", By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"), "Cronus Yoga Pant");

        //Verify the product size ‘32’
        verifyText("32", By.xpath("//dd[contains(text(),'32')]"), "32");

        //Verify the product colour ‘Black’
        verifyText("Black", By.xpath("//dd[contains(text(),'Black')]"), "Black");

    }
    @After
    public void tearDown() {
        driver.close();

}
}