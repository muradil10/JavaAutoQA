package amazon.pageobjectmodel.pages;

import utilsclasses.Config;
import utilsclasses.WebDriverUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @aauthor : mr.muradil
 * @created : 16.08.2024,23:47
 **/

public class SignUpPage {
    WebDriver driver;
    WebDriverUtils webDriverUtils;

    @FindBy(xpath = "//h1[@class='a-spacing-small']")
    WebElement signUpHeader;
    @FindBy(xpath = "//*[@id='ap_email']")
    WebElement emailField;
    @FindBy(xpath = "(//*[@id='continue'])[1]")
    WebElement continueButton;
    @FindBy(xpath = "//*[@id='ap_password']")
    WebElement passwordField;
    @FindBy(xpath = "//*[@id='signInSubmit']")
    WebElement loginButton;
    @FindBy(xpath = "//a[@id='createAccountSubmit']")
    WebElement createAccountButton;
    @FindBy(xpath = "//i[@class='a-icon a-icon-logo' and @aria-label='Amazon']")
    WebElement amazonLogoIconClick;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webDriverUtils = new WebDriverUtils(driver);
    }

    public void verifyVisibleLoginPage() {
        webDriverUtils.waitForElementVisible(signUpHeader);
    }

    public void login(String email, String password) {
        webDriverUtils.waitForElementClickable(emailField);
        emailField.sendKeys(email);
        continueButton.click();
        webDriverUtils.waitForElementVisible(passwordField);
        passwordField.sendKeys(password);
        loginButton.click();
    }


    public void createNewAccountButton() {
        if (signUpHeader.isDisplayed()){
            System.out.println("sign header is displayed");
            createAccountButton.click();
        }else{
            System.out.println("not displayed");
        }
    }

    public void testNavigateToHomePage(){
        driver.navigate().to(Config.readFromConfig("config.properties","amazon.url"));
    }
}