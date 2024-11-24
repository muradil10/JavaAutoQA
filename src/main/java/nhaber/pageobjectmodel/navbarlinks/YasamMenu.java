package nhaber.pageobjectmodel.navbarlinks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilsclasses.WebDriverUtils;

/**
 * @aauthor : mr.muradil
 * @created : 23.11.2024,18:58
 **/
public class YasamMenu {
    WebDriver driver;
    WebDriverUtils webDriverUtils;

    @FindBy(xpath = "(//a[text()='Yaşam'])[1]")
    WebElement yasaMenu;
    @FindBy(xpath = "(//a[text()='Sağlık'])[1]")
    WebElement saglikLink;
    @FindBy(xpath = "(//a[text()='Eğitim'])[1]")
    WebElement egitimLink;
    @FindBy(xpath = "(//a[text()='Çevre'])[1]")
    WebElement cevreLink;
    @FindBy(xpath = "(//a[text()='Kültür'])[1]")
    WebElement kulturLink;
    @FindBy(xpath = "(//a[text()='Oyun'])[1]")
    WebElement oyunLink;
    @FindBy(xpath = "(//a[text()='Spor'])[1]")
    WebElement sporLink;


    public YasamMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        webDriverUtils = new WebDriverUtils(driver);
    }

    public void yasamMenuLinksVerifyAndClick(){

        webDriverUtils.waitForElementVisible(yasaMenu);
        System.out.println("Clicking: " + yasaMenu.getText());
        yasaMenu.click();
        // Sayfanın düzgün bir şekilde yüklendiğini doğrula
        String yasamMenu = driver.getCurrentUrl();
        Assert.assertTrue(yasamMenu.contains("yasam"), "Beklenen URL bulunamadı. Mevcut URL: " + yasamMenu);
        System.out.println("Sayfa açıldı: " + yasamMenu);
        driver.navigate().back();

        webDriverUtils.waitForElementVisible(saglikLink);
        System.out.println("Clicking: " + saglikLink.getText());
        saglikLink.click();
        // Sayfanın düzgün bir şekilde yüklendiğini doğrula
        String saglikLink = driver.getCurrentUrl();
        Assert.assertTrue(saglikLink.contains("saglik"), "Beklenen URL bulunamadı. Mevcut URL: " + saglikLink);
        System.out.println("Sayfa açıldı: " + saglikLink);
        driver.navigate().back();

        webDriverUtils.waitForElementVisible(egitimLink);
        System.out.println("Clicking: " + egitimLink.getText());
        egitimLink.click();
        // Sayfanın düzgün bir şekilde yüklendiğini doğrula
        String egitimLink = driver.getCurrentUrl();
        Assert.assertTrue(egitimLink.contains("egitim"), "Beklenen URL bulunamadı. Mevcut URL: " + egitimLink);
        System.out.println("Sayfa açıldı: " + egitimLink);
        driver.navigate().back();

        webDriverUtils.waitForElementVisible(cevreLink);
        System.out.println("Clicking: " + cevreLink.getText());
        cevreLink.click();
        // Sayfanın düzgün bir şekilde yüklendiğini doğrula
        String cevreLink = driver.getCurrentUrl();
        Assert.assertTrue(cevreLink.contains("cevre"), "Beklenen URL bulunamadı. Mevcut URL: " + cevreLink);
        System.out.println("Sayfa açıldı: " + cevreLink);
        driver.navigate().back();

        webDriverUtils.waitForElementVisible(kulturLink);
        System.out.println("Clicking: " + kulturLink.getText());
        kulturLink.click();
        // Sayfanın düzgün bir şekilde yüklendiğini doğrula
        String kulturLink = driver.getCurrentUrl();
        Assert.assertTrue(kulturLink.contains("kultur"), "Beklenen URL bulunamadı. Mevcut URL: " + kulturLink);
        System.out.println("Sayfa açıldı: " + kulturLink);
        driver.navigate().back();

        webDriverUtils.waitForElementVisible(oyunLink);
        System.out.println("Clicking: " + oyunLink.getText());
        oyunLink.click();
        // Sayfanın düzgün bir şekilde yüklendiğini doğrula
        String oyunlink = driver.getCurrentUrl();
        Assert.assertTrue(oyunlink.contains("oyun"), "Beklenen URL bulunamadı. Mevcut URL: " + oyunlink);
        System.out.println("Sayfa açıldı: " + oyunlink);
        driver.navigate().back();

        webDriverUtils.waitForElementVisible(sporLink);
        System.out.println("Clicking: " + sporLink.getText());
        sporLink.click();
        // Sayfanın düzgün bir şekilde yüklendiğini doğrula
        String sporLink = driver.getCurrentUrl();
        Assert.assertTrue(sporLink.contains("spor"), "Beklenen URL bulunamadı. Mevcut URL: " + sporLink);
        System.out.println("Sayfa açıldı: " + sporLink);
        driver.navigate().back();
    }
}
