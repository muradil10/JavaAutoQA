package nhaber.pageobjectmodel.navbarlinks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilsclasses.WebDriverUtils;

/**
 * @aauthor : mr.muradil
 * @created : 23.11.2024,18:34
 **/
public class IsDunyasiMenu {

    WebDriver driver;
    WebDriverUtils webDriverUtils;

    @FindBy(xpath = "(//a[text()='İş Dünyası'])[1]")
    WebElement isDunyasiMenu;
    @FindBy(xpath = "(//a[text()='Türkiye'])[1]")
    WebElement turkiyeLink;
    @FindBy(xpath = "(//a[text()='Dünya'])[1]")
    WebElement dunyaLink;

    public IsDunyasiMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        webDriverUtils = new WebDriverUtils(driver);
    }

    public void isDunyasiLinksVerifyAndClick(){

        webDriverUtils.waitForElementVisible(isDunyasiMenu);
        System.out.println("Clicking: " + isDunyasiMenu.getText());
        isDunyasiMenu.click();
        // Sayfanın düzgün bir şekilde yüklendiğini doğrula
        String isDunyasiLink = driver.getCurrentUrl();
        Assert.assertTrue(isDunyasiLink.contains("is-dunyasi"), "Beklenen URL bulunamadı. Mevcut URL: " + isDunyasiLink);
        System.out.println("Sayfa açıldı: " + isDunyasiLink);
        driver.navigate().back();

        webDriverUtils.waitForElementVisible(turkiyeLink);
        System.out.println("Clicking: " + turkiyeLink.getText());
        turkiyeLink.click();
        // Sayfanın düzgün bir şekilde yüklendiğini doğrula
        String turkiyelink = driver.getCurrentUrl();
        Assert.assertTrue(turkiyelink.contains("turkiye"), "Beklenen URL bulunamadı. Mevcut URL: " + turkiyelink);
        System.out.println("Sayfa açıldı: " + turkiyelink);
        driver.navigate().back();

        webDriverUtils.waitForElementVisible(dunyaLink);
        System.out.println("Clicking: " + dunyaLink.getText());
        dunyaLink.click();
        // Sayfanın düzgün bir şekilde yüklendiğini doğrula
        String dunyaLink = driver.getCurrentUrl();
        Assert.assertTrue(dunyaLink.contains("dunya"), "Beklenen URL bulunamadı. Mevcut URL: " + dunyaLink);
        System.out.println("Sayfa açıldı: " + dunyaLink);
        driver.navigate().back();

    }
}
