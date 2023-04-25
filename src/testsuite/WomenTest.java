package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenTest extends Utility {
    //Inheriting the BaseTest Class
    String baseUrl = "https://magento.softwaretestingboard.com/";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        //Mouse Hoover on Women Menu
        WebElement women = driver.findElement(By.xpath(" //span[contains(text(),'Women')]"));
        //Mouse Hoover on Tops
        WebElement tops = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(women).moveToElement(tops).build().perform();
        //Click on jackets
        clickOnElement(By.xpath(" //a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
        // Select Sort By filter "Product Name

        clickOnElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]"));
        WebElement element = driver.findElement(By.xpath("//div[2]//div[3]//select[1]"));
        Select select = new Select(element);
        select.selectByVisibleText("Product Name");

        // Verify the products name display in alphabetical order
        // Get the names of all the products
        List<WebElement> productNames = BaseTest.driver.findElements(By.cssSelector(".product-name a"));
        List<String> actualProductNames = new java.util.ArrayList<String>();
        for (WebElement productName : productNames) {
            actualProductNames.add(productName.getText());
        }
        // Verify that the product names are in alphabetical order
        List<String> expectedProductNames = new java.util.ArrayList<String>(actualProductNames);
        java.util.Collections.sort(expectedProductNames);
        Assert.assertEquals(actualProductNames, expectedProductNames);
        Thread.sleep(2000);
    }
    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        //Mouse Hoover on Women Menu
        WebElement women = driver.findElement(By.xpath(" //span[contains(text(),'Women')]"));
        //Mouse Hoover on Tops
        WebElement tops = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(women).moveToElement(tops).build().perform();
        //Click on jackets
        clickOnElement(By.xpath(" //a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
        //Select Sort by filter "Price"
        WebElement sortByDropdown = BaseTest.driver.findElement(By.xpath("//select[@id='sorter']"));
        sortByDropdown.click();
        WebElement priceOption = BaseTest.driver.findElement(By.xpath(" //option[contains(text(), 'Price')]"));
        priceOption.click();
        //Verify the products price display in Low To High
        List<WebElement> productPrices = driver.findElements(By.xpath("//div[@class='product-info']//span[@class='price']"));
        List<Double> prices = new ArrayList<Double>();
        for (WebElement productPrice : productPrices) {
            prices.add(Double.parseDouble(productPrice.getText().replaceAll("[^0-9.]", "")));
        }
        List<Double> sortedPrices = new ArrayList<Double>(prices);
        Collections.sort(sortedPrices);
        Assert.assertEquals(prices, sortedPrices);
        Thread.sleep(2000);


    }@After
    public void tearDown() {
        driver.close();
    }

}
