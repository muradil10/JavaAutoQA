package nhaber.pageobjectmodel.navbarlinks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilsclasses.WebDriverUtils;

/**
 * @aauthor : mr.muradil
 * @created : 23.11.2024,12:57
 **/
public class NedenMenu {
    WebDriver driver;
    WebDriverUtils webDriverUtils;

    @FindBy(xpath = "//*[@id=\"menu-item-31740\"]/a/span")
    WebElement nedenMenu;
    @FindBy(xpath = "//*[@id=\"menu-item-30340\"]/a")
    WebElement astronomiLink;
    @FindBy(xpath = "//*[@id=\"menu-item-30349\"]/a")
    WebElement fizikLink;
    @FindBy(xpath = "//*[@id=\"menu-item-31794\"]/a")
    WebElement kimyaLink;
    @FindBy(xpath = "//*[@id=\"menu-item-31799\"]/a")
    WebElement biyolojiLink;
    @FindBy(xpath = "//*[@id=\"menu-item-31827\"]/a")
    WebElement diğerLink;


    // Constructor
    public NedenMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webDriverUtils = new WebDriverUtils(driver);
    }

    public void nedenNavbarLinksVerifyAndClick() {
        // NedenLink elemanının tıklanabilir olmasını bekle
        webDriverUtils.waitForElementVisible(nedenMenu);
        System.out.println("Clicking: " + nedenMenu.getText());
        nedenMenu.click();
        // Sayfanın düzgün bir şekilde yüklendiğini doğrula
        String nedenUrl = driver.getCurrentUrl();
        Assert.assertTrue(nedenUrl.contains("neden"), "Beklenen URL bulunamadı. Mevcut URL: " + nedenUrl);
        System.out.println("Sayfa açıldı: " + nedenUrl);
        driver.navigate().back();

        webDriverUtils.waitForElementVisible(astronomiLink);
        System.out.println("Clicking: " + astronomiLink.getText());
        astronomiLink.click();
        // Sayfanın düzgün bir şekilde yüklendiğini doğrula
        String astronomiUrl = driver.getCurrentUrl();
        Assert.assertTrue(astronomiUrl.contains("astronomi"), "Beklenen URL bulunamadı. Mevcut URL: " + astronomiUrl);
        System.out.println("Sayfa açıldı: " + astronomiUrl);
        driver.navigate().back();

        webDriverUtils.waitForElementVisible(this.fizikLink);
        System.out.println("Clicking: " + this.fizikLink.getText());
        this.fizikLink.click();
        // Sayfanın düzgün bir şekilde yüklendiğini doğrula
        String fizikLink = driver.getCurrentUrl();
        Assert.assertTrue(fizikLink.contains("fizik"), "Beklenen URL bulunamadı. Mevcut URL: " + fizikLink);
        System.out.println("Sayfa açıldı: " + fizikLink);
        driver.navigate().back();

        webDriverUtils.waitForElementVisible(this.kimyaLink);
        System.out.println("Clicking: " + this.kimyaLink.getText());
        this.kimyaLink.click();
        // Sayfanın düzgün bir şekilde yüklendiğini doğrula
        String kimyaLink = driver.getCurrentUrl();
        Assert.assertTrue(kimyaLink.contains("kimya"), "Beklenen URL bulunamadı. Mevcut URL: " + kimyaLink);
        System.out.println("Sayfa açıldı: " + kimyaLink);
        driver.navigate().back();

        webDriverUtils.waitForElementVisible(this.biyolojiLink);
        System.out.println("Clicking: " + this.biyolojiLink.getText());
        this.biyolojiLink.click();
        // Sayfanın düzgün bir şekilde yüklendiğini doğrula
        String biyolojiLink = driver.getCurrentUrl();
        Assert.assertTrue(biyolojiLink.contains("biyoloji"), "Beklenen URL bulunamadı. Mevcut URL: " + biyolojiLink);
        System.out.println("Sayfa açıldı: " + biyolojiLink);
        driver.navigate().back();

        webDriverUtils.waitForElementVisible(diğerLink);
        System.out.println("Clicking: " + diğerLink.getText());
        diğerLink.click();
        // Sayfanın düzgün bir şekilde yüklendiğini doğrula
        String diğerLink = driver.getCurrentUrl();
        Assert.assertTrue(diğerLink.contains("diger"), "Beklenen URL bulunamadı. Mevcut URL: " + diğerLink);
        System.out.println("Sayfa açıldı: " + diğerLink);
        driver.navigate().back();
}

    }
