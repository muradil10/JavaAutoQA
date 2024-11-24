package utilsclasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @aauthor : mr.muradil
 * @created : 16.08.2024,15:20
 **/
public class BaseClass {
    public static WebDriver driver;

    public static void openBrowser(){
        WebDriverManager.chromedriver().setup();
        //ChromeOptions options =new ChromeOptions();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.get(Config.readFromConfig("config.properties", ".url"));
    }

    public static void closeBrowser(){
        driver.close();
        driver.quit();
    }
}