package nhaber.pageobjectmodel.searchbutton;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilsclasses.WebDriverUtils;

/**
 * @aauthor : mr.muradil
 * @created : 23.11.2024,19:24
 **/
public class SearchButton {
    WebDriver driver;
    WebDriverUtils webDriverUtils;

    @FindBy(xpath = "//div[contains(@class, 'popup-trigger-container')]")
    WebElement searchButton;
    @FindBy(xpath = "//input[contains(@class, 'cmsmasters-search__field')]")
    WebElement searchField;
    @FindBy(xpath = "(//img[contains(@src, 'placeholder-blog-archive')])[1]")
    WebElement iletisimLink;

    public SearchButton(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webDriverUtils = new WebDriverUtils(driver);
    }

    public void verifySearchFunctionality() {
        // 1. Arama butonuna tıklayın
        webDriverUtils.waitForElementVisible(searchButton);
        System.out.println("Clicking search button: " + searchButton.getText());
        searchButton.click();

        // 2. Arama kutusuna 'istanbul' yazıp Enter'a basın
        webDriverUtils.waitForElementVisible(searchField);
        searchField.sendKeys("istanbul");
        searchField.sendKeys(Keys.RETURN);

        // 3. Sonuçların ilk bağlantısını bekleyin ve tıklayın
        webDriverUtils.waitForElementVisible(iletisimLink);
        Actions actions = new Actions(driver);
        actions.moveToElement(iletisimLink).pause(1000).click().perform();

        // 4. URL doğrulaması yapın
        String currentPageUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentPageUrl.contains("iletisim"),
                "Beklenen URL '/iletisim' ifadesini içermiyor. Geçerli URL: " + currentPageUrl);
        System.out.println("Sayfa başarıyla açıldı: " + currentPageUrl);
    }
}