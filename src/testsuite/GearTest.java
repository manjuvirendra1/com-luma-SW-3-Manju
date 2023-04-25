package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import utilities.Utility;



public class GearTest extends Utility {

    //Inheriting the BaseTest Class
    String baseUrl = "https://magento.softwaretestingboard.com/";


    @Before
    public void setUp()
    {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart()

        throws InterruptedException {

        Thread.sleep(2000);
        //Mouse Hover on Gear Menu
        mouseHoverToElement(By.xpath("//span[contains(text(),'Gear')]"));
        //Click on Bags
        mouseHoverAndClick(By.xpath("//span[contains(text(),'Bags')]"));
        //Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[contains(text(),'Overnight Duffle')]"));
        //Verify the text ‘Overnight Duffle’
        verifyText("Overnight Duffle", By.xpath("//span[contains(text(),'Overnight Duffle')]"), "Overnight Duffle");
        // Change Qty 3
        clearTextFromField(By.xpath("//input[@id='qty']"));
        sendTextToElement(By.xpath("//input[@id='qty']"), "3");
        //Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//button[@id='product-addtocart-button']"));
        //Verify the text ‘You added Overnight Duffle to your shopping cart.’
        verifyText("You added Overnight Duffle to your shopping cart.", By.xpath("//div[@role='alert']/div/div"), "Message");
        Thread.sleep(2000);
        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//div[@role='alert']/div/div/a"));
        //Verify the product name ‘Overnight Duffle’
        verifyText("Overnight Duffle", By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"), "Overnight Duffle");
        Thread.sleep(2000);
        //Verify the Qty is ‘3’
        verifyText("3", By.xpath("//span[@class='counter-number']"), "3");

        Thread.sleep(2000);
        //Verify the product price ‘$135.00’
        verifyText("$135.00", By.xpath("/html[1]/body[1]/div[1]/main[1]/div[3]/div[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/span[1]/span[1]/span[1]")
                , "$135.00");

        Thread.sleep(2000);
        //Change Qty to ‘5’
        mouseHover(By.xpath("//tbody/tr[1]/td[3]/div[1]/div[1]/label[1]"));
        clickOnElement(By.xpath("//tbody/tr[1]/td[3]/div[1]/div[1]/label[1]"));
        clearTextFromField(By.xpath("//tbody/tr[1]/td[3]/div[1]/div[1]/label[1]"));
        sendTextToElement(By.xpath("//tbody/tr[1]/td[3]/div[1]/div[1]/label[1]"), "5");
        Thread.sleep(2000);
        //Click on ‘Update Shopping Cart’ button
        mouseHoverAndClick(By.xpath("//span[normalize-space()='Update Shopping Cart']"));
        //Verify the product price ‘$225.00’
        verifyText("$225.00", By.xpath("/html[1]/body[1]/div[1]/main[1]/div[3]/div[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/span[1]/span[1]/span[1]"),
                "$225.00");

        Thread.sleep(2000);

    }

   @After
    public void tearDown() {
       driver.close();
   }
}