package amazon.pageobjectmodel.pages;

import amazon.pageobjectmodel.utilsclasses.WebDriverUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @aauthor : mr.muradil
 * @created : 16.08.2024,17:14
 **/

public class Homepage {
    WebDriver driver;
    WebDriverUtils webDriverUtils;

    @FindBy(xpath = "//input[@id='sp-cc-accept']")
    WebElement acceptButton;
    @FindBy(id = "sp-cc-rejectall-link")
    WebElement rejectButton;
    @FindBy(xpath = "//span[@class='hm-icon-label']")
    WebElement navigationLabel;
    @FindBy(xpath = "//*[@id='twotabsearchtextbox']")
    WebElement searchBox;
    @FindBy(xpath = "//*[@id='nav-link-accountList-nav-line-1']")
    WebElement accountDropdown;
    @FindBy(xpath = "//*[@id='nav-flyout-ya-newCust']/a")
    WebElement signIn;
    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    WebElement searchSubmitButton;
    @FindBy(xpath = "//*[@id='search']/span[2]/div/h1/div/div[1]/div/div")
    WebElement searchResultsSummary;

    @FindBy(xpath = "//*[@id='nav-link-accountList']")
    WebElement openedAccountDropdown;
    @FindBy(xpath = "//*[@id='nav-item-signout']/span")
    WebElement logoutButton;

    public Homepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webDriverUtils = new WebDriverUtils(driver);
    }

    public void homePageVisibleVerify() {
        try {
            webDriverUtils.waitForElementVisible(acceptButton);
            webDriverUtils.waitForElementVisible(rejectButton);
            webDriverUtils.waitForElementVisible(navigationLabel);
            webDriverUtils.waitForElementVisible(searchBox);
            System.out.println("All elements are visible on the homepage.");
        } catch (Exception e) {
            throw new RuntimeException("Homepage elements not visible: " + e.getMessage(), e);
        }
    }

    public void searchProduct() {
        rejectButton.click();
        searchBox.click();
        searchBox.sendKeys("iphone 15 max pro");
        searchSubmitButton.click();
    }

    public void searchedProductResult() {
        try {
            webDriverUtils.waitForElementVisible(searchResultsSummary);
            String summaryText = searchResultsSummary.getText().trim();
            if (!summaryText.isEmpty()) {
                System.out.println("Arama sonuçları sayfası başarıyla yüklendi ve doğru içerik gösteriliyor: " + summaryText);
            } else {
                System.out.println("Arama sonuçları sayfasında beklenen içerik bulunamadı.");
            }
        } catch (Exception e) {
            System.err.println("Arama sonuçları sayfasında bir hata oluştu: " + e.getMessage());
            throw new RuntimeException("Arama sonuçları sayfasında bir hata oluştu: " + e.getMessage(), e);
        }
    }

    public void toSignInPage() {
        Actions actions = new Actions(driver);
        actions.moveToElement(accountDropdown).perform();
        signIn.click();
        driver.navigate().back();
    }

    public void toSignUpPage() {
        accountDropdown.click();
    }

    public void isUserProfilePageDisplayed() {
        try {
            webDriverUtils.waitForElementVisible(openedAccountDropdown);
            System.out.println("User profile page is displayed.");
        } catch (NoSuchElementException ignored) {
        }
    }

    public void logout() {
        Actions actions = new Actions(driver);
        actions.moveToElement(openedAccountDropdown).perform();
        logoutButton.click();
        driver.navigate().back();
    }

    public void toCreateNewAccount() {
        accountDropdown.click();
    }
}
