package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    //Creating self method
    public void openBrowser(String baseUrl){
        ChromeOptions options = new ChromeOptions();
        options.addArguments(("--disable-notifications"));
        driver = new ChromeDriver(options);
        //Launch the URL
        driver.get(baseUrl);
        //Maximise window
        driver.manage().window().maximize();
        //Implicit Timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }


    public void closeBrowser() {
        driver.close();//closing all the instances
    }
}


