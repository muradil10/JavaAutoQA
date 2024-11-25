package ntech.pageopjectmodel.formfilling;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilsclasses.ConfigReader;
import utilsclasses.WebDriverUtils;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;

/**
 * @aauthor : mr.muradil
 * @created : 24.11.2024,23:54
 **/
public class MyFormApplication {
    WebDriver driver;
    WebDriverUtils webDriverUtils;

    @FindBy(xpath = "//input[@id='name']")
    WebElement nameSurNameField;
    @FindBy(xpath = "//input[@id='birth']")
    WebElement dateOfBirthField;
    @FindBy(xpath = "//input[@id='tcKimlik']")
    WebElement iDField;
    @FindBy(xpath = "//input[@id='phone']")
    WebElement phoneField;
    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;
    @FindBy(xpath = "(//input[@id='cv_field'])[1]")
    WebElement fileInput;
    @FindBy(xpath = "//button[text()='Lisans']")
    WebElement licenceButton;
    @FindBy(xpath = "//input[@id='pdp1']")
    WebElement checkBox;
    @FindBy(xpath = "//button[@aria-label='Go to the next step']")
    WebElement nextStepButton;
    @FindBy(xpath = "//div[contains(@class, 'bg-[#DF1F29]') and .//span[text()='Test Engineer']]")
    WebElement position;
    @FindBy(xpath = "//div[contains(@class, 'bg-[#DF1F29]') and text()='Gönder']")
    WebElement sendButton;

    public MyFormApplication(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webDriverUtils = new WebDriverUtils(driver);
    }

    public void verifyCompleteAndSuccessfullySubmitForm() {

        webDriverUtils.waitForElementVisible(nameSurNameField);
        String name = ConfigReader.getProperty("ad.Soyadim");
        nameSurNameField.sendKeys(name);
        System.out.println("Ad Soyad: " + name);

        webDriverUtils.waitForElementVisible(dateOfBirthField);
        String birth = ConfigReader.getProperty("dogum.tarihim");
        dateOfBirthField.sendKeys(birth);
        System.out.println("Dogum Tarihi: " + birth);

        webDriverUtils.waitForElementVisible(iDField);
        String id = ConfigReader.getProperty("T.C.numaram");
        iDField.sendKeys(id);
        System.out.println("ID:" + id);

        webDriverUtils.waitForElementVisible(phoneField);
        String phone = ConfigReader.getProperty("cep");
        phoneField.sendKeys(phone);
        System.out.println("Cep:" + phone);

        webDriverUtils.waitForElementVisible(emailField);
        String email = ConfigReader.getProperty("mailim");
        emailField.sendKeys(email);
        System.out.println("Email:" + email);


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('cv_field').style.display = 'block';");
        String cvPath = ConfigReader.getProperty("cv");
        webDriverUtils.waitForElementVisible(fileInput);
        fileInput.sendKeys(cvPath);  // Dosya yolunu 'input' alanına gönderiyoruz
        System.out.println("CV yüklendi: " + cvPath);

        webDriverUtils.waitForElementVisible(licenceButton);
        licenceButton.click();
        licenceButton.sendKeys("Lisans");
        System.out.println("Egitim Bilgisi: Lisans");

        webDriverUtils.waitForElementVisible(checkBox);
        System.out.println("KVKK Metni: Onaylandi");


        webDriverUtils.waitForElementClickable(nextStepButton);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", nextStepButton);
        System.out.println("2.adima gecildi");

        webDriverUtils.waitForElementVisible(position);
        position.click();
        System.out.println("Pozisyon: Test Engineer");

        webDriverUtils.waitForElementVisible(sendButton);
        sendButton.click();
        webDriverUtils.sleep(3);
        System.out.println("Basariyla Gonderildi!");
        webDriverUtils.sleep(4);

        takeScreenshot("PozisyonSecildiktenSonra");
    }

    public void takeScreenshot(String screenshotName) {
        // Screenshot al
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // Kaydedilecek yolu belirle
        File destinationFile = new File("screenshots"+screenshotName + ".png");
        try {
            // Screenshot'u belirtilen dosyaya kaydet
            FileUtils.copyFile(screenshotFile,destinationFile);
            System.out.println("Ekran goruntusu basariyla kaydedildi:"+ destinationFile.getAbsolutePath());
        }catch (IOException e){
            System.out.println("Ekran goruntusu alinirken bir hata olustu.");
            e.printStackTrace();
        }
    }
}
