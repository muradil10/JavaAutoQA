package amazon.pageobjectmodel.pages;

import amazon.pageobjectmodel.utilsclasses.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @aauthor : mr.muradil
 * @created : 17.08.2024,00:14
 **/

public class SignInPage {
    WebDriver webDriver;
    WebDriverUtils webDriverUtils;

    @FindBy(xpath = "//i[@class='a-icon a-icon-logo' and @aria-label='Amazon']")
    WebElement createAccountHeader;
    @FindBy(xpath = "//input[@placeholder='Adı ve soyadı']")
    WebElement fullNameLabel;
    @FindBy(xpath = "//input[@name='email']")
    WebElement emailInput;
    @FindBy(xpath = "//input[@id='ap_password']")
    WebElement passwordInput;
    @FindBy(xpath = "//input[@id='ap_password_check']")
    WebElement passwordConfirmInput;
    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement termsAgreementCheckbox;
    @FindBy(xpath = "//input[@class='a-button-input']")
    WebElement continueButton;

    @FindBy(xpath = "//div[@class='a-alert-content' and contains(text(), 'Geçerli bir e-posta adresi girin')]")
    WebElement invalidEmailMessage;
    @FindBy(xpath = "//div[@class='a-alert-content' and contains(text(), 'Şifreler eşleşmiyor')]")
    WebElement passwordMismatchMessage;

    public SignInPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverUtils = new WebDriverUtils(webDriver);
    }

    public void verifyCreateAccountPageVisible() {
        if (createAccountHeader.isDisplayed()) {
            System.out.println("create account header is visible");
        }else{
            System.out.println("create account header is not visible");
        }
    }

    public void createNewAccount() {
        try {
            // Wait for elements to be visible
            webDriverUtils.waitForElementVisible(fullNameLabel);
            webDriverUtils.waitForElementVisible(emailInput);
            webDriverUtils.waitForElementVisible(passwordInput);
            webDriverUtils.waitForElementVisible(passwordConfirmInput);
            webDriverUtils.waitForElementVisible(termsAgreementCheckbox);
            webDriverUtils.waitForElementVisible(continueButton);

            // Fill out the form
            fullNameLabel.sendKeys(webDriverUtils.generateFakerFullName());
            emailInput.sendKeys(webDriverUtils.generateFakerEmail());
            passwordInput.sendKeys(webDriverUtils.generateFakerPassword());
            passwordConfirmInput.sendKeys(webDriverUtils.generateFakerPassword());

            // Agree to terms and continue
            termsAgreementCheckbox.click();
            continueButton.click();
            webDriverUtils.sleep(2);

            boolean isEmailErrorDisplayed = webDriverUtils.isElementPresent(By.xpath("//div[@class='a-alert-content' and contains(text(), 'Geçerli bir e-posta adresi girin')]"));
            boolean isPasswordMismatchDisplayed = webDriverUtils.isElementPresent(By.xpath("//div[@class='a-alert-content' and contains(text(), 'Şifreler eşleşmiyor')]"));

            if (isEmailErrorDisplayed) {
                System.out.println("Invalid email error message is displayed, as expected.");
            } else if (isPasswordMismatchDisplayed) {
                System.out.println("Password mismatch error message is displayed, as expected.");
            }
        } catch (Exception e) {
            System.err.println("An error occurred while creating a new account: " + e.getMessage());
        }
    }
}
