package nhaber.pageobjectmodel.navbarlinks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilsclasses.WebDriverUtils;

/**
 * @aauthor : mr.muradil
 * @created : 23.11.2024,17:32
 **/
public class NasilMenu {
    WebDriver driver;
    WebDriverUtils webDriverUtils;

    @FindBy(xpath = "(//a[text()='Nasıl'])[1]")
    WebElement nasilMenu;
    @FindBy(xpath = "(//a[text()='Savunma'])[1]")
    WebElement savunmaLink;
    @FindBy(xpath = "(//a[text()='Otomotiv'])[1]")
    WebElement otomotivLink;
    @FindBy(xpath = "(//a[text()='Enerji'])[1]")
    WebElement enerjiLink;
    @FindBy(xpath = "(//a[text()='Yapay Zeka'])[1]")
    WebElement yapayZekaLink;
    @FindBy(xpath = "(//a[text()='Elektronik'])[1]")
    WebElement elektronikLink;
    @FindBy(xpath = "(//a[text()='Bilgisayar'])[1]")
    WebElement bilgisayarLink;
    @FindBy(xpath = "(//a[text()='Güvenlik'])[1]")
    WebElement guvenlikLink;
    @FindBy(xpath = "(//a[text()='Uzay / Havacılık'])[1]")
    WebElement uzayHavacilikLink;

    public NasilMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webDriverUtils = new WebDriverUtils(driver);
    }

    public void nasilNavbarVerifyAndClick(){

        webDriverUtils.waitForElementVisible(nasilMenu);
        System.out.println("Clicking: " + nasilMenu.getText());
        nasilMenu.click();
        // Sayfanın düzgün bir şekilde yüklendiğini doğrula
        String NasilMenu = driver.getCurrentUrl();
        Assert.assertTrue(NasilMenu.contains("nasil"), "Beklenen URL bulunamadı. Mevcut URL: " + NasilMenu);
        System.out.println("Sayfa açıldı: " + NasilMenu);
        driver.navigate().back();

        webDriverUtils.waitForElementVisible(savunmaLink);
        System.out.println("Clicking: " + savunmaLink.getText());
        savunmaLink.click();
        // Sayfanın düzgün bir şekilde yüklendiğini doğrula
        String savunmaLink = driver.getCurrentUrl();
        Assert.assertTrue(savunmaLink.contains("savunma"), "Beklenen URL bulunamadı. Mevcut URL: " + savunmaLink);
        System.out.println("Sayfa açıldı: " + savunmaLink);
        driver.navigate().back();

        webDriverUtils.waitForElementVisible(otomotivLink);
        System.out.println("Clicking: " + otomotivLink.getText());
        otomotivLink.click();
        // Sayfanın düzgün bir şekilde yüklendiğini doğrula
        String otomotivLink = driver.getCurrentUrl();
        Assert.assertTrue(otomotivLink.contains("otomotiv"), "Beklenen URL bulunamadı. Mevcut URL: " + otomotivLink);
        System.out.println("Sayfa açıldı: " + otomotivLink);
        driver.navigate().back();

        webDriverUtils.waitForElementVisible(enerjiLink);
        System.out.println("Clicking: " + enerjiLink.getText());
        enerjiLink.click();
        // Sayfanın düzgün bir şekilde yüklendiğini doğrula
        String enerjiLink = driver.getCurrentUrl();
        Assert.assertTrue(enerjiLink.contains("enerji"), "Beklenen URL bulunamadı. Mevcut URL: " + enerjiLink);
        System.out.println("Sayfa açıldı: " + enerjiLink);
        driver.navigate().back();

        webDriverUtils.waitForElementVisible(yapayZekaLink);
        System.out.println("Clicking: " + yapayZekaLink.getText());
        yapayZekaLink.click();
        // Sayfanın düzgün bir şekilde yüklendiğini doğrula
        String yapayZeka = driver.getCurrentUrl();
        Assert.assertTrue(yapayZeka.contains("yapay-zeka"), "Beklenen URL bulunamadı. Mevcut URL: " + yapayZeka);
        System.out.println("Sayfa açıldı: " + yapayZeka);
        driver.navigate().back();

        webDriverUtils.waitForElementVisible(elektronikLink);
        System.out.println("Clicking: " + elektronikLink.getText());
        elektronikLink.click();
        // Sayfanın düzgün bir şekilde yüklendiğini doğrula
        String elektronikLink = driver.getCurrentUrl();
        Assert.assertTrue(elektronikLink.contains("elektronik"), "Beklenen URL bulunamadı. Mevcut URL: " + elektronikLink);
        System.out.println("Sayfa açıldı: " + elektronikLink);
        driver.navigate().back();

        webDriverUtils.waitForElementVisible(bilgisayarLink);
        System.out.println("Clicking: " + bilgisayarLink.getText());
        bilgisayarLink.click();
        // Sayfanın düzgün bir şekilde yüklendiğini doğrula
        String bilgisayar = driver.getCurrentUrl();
        Assert.assertTrue(bilgisayar.contains("bilgisayar"), "Beklenen URL bulunamadı. Mevcut URL: " + bilgisayar);
        System.out.println("Sayfa açıldı: " + bilgisayar);
        driver.navigate().back();

        webDriverUtils.waitForElementVisible(guvenlikLink);
        System.out.println("Clicking: " + guvenlikLink.getText());
        guvenlikLink.click();
        // Sayfanın düzgün bir şekilde yüklendiğini doğrula
        String guvenlikLink = driver.getCurrentUrl();
        Assert.assertTrue(guvenlikLink.contains("guvenlik"), "Beklenen URL bulunamadı. Mevcut URL: " + guvenlikLink);
        System.out.println("Sayfa açıldı: " + guvenlikLink);
        driver.navigate().back();

        webDriverUtils.waitForElementVisible(uzayHavacilikLink);
        System.out.println("Clicking: " + uzayHavacilikLink.getText());
        uzayHavacilikLink.click();
        // Sayfanın düzgün bir şekilde yüklendiğini doğrula
        String uzayHavacilikLink = driver.getCurrentUrl();
        Assert.assertTrue(uzayHavacilikLink.contains("uzay-havacilik"), "Beklenen URL bulunamadı. Mevcut URL: " + uzayHavacilikLink);
        System.out.println("Sayfa açıldı: " + uzayHavacilikLink);
        driver.navigate().back();
    }
}
