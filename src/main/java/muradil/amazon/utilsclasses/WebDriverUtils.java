package muradil.amazon.utilsclasses;

import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;

/**
 * @aauthor : mr.muradil
 * @created : 16.08.2024,16:15
 **/
public class WebDriverUtils {
    WebDriver driver;
    Faker faker;

    public WebDriverUtils(WebDriver driver) {
            this.driver = driver;
        faker = new Faker();
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public void waitForElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementPresent(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForAlertPresent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public boolean isElementPresent(By locator) {
        try {
            waitForElementPresent((By) locator);
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String generateFakerFullName(){
        return faker.name().fullName();
    }

    public String generateFakeFirstName() {
        return faker.name().firstName();
    }

    public String generateFakeLastName() {
        return faker.name().lastName();
    }

    public String generateFakerEmail() {
        return faker.internet().emailAddress();
    }

    public String generateFakerPassword(){
        return faker.internet().password();
    }

    public String generateFakeWebsiteName() {
        return faker.internet().username();
    }

    public String generateFakeCode() {
        return faker.name().lastName().toLowerCase(Locale.ROOT) + System.currentTimeMillis();
    }


    public String generateProductName() {
        String[] products = {"Car", "Bike", "Phone", "Laptop", "TV", "PlayStation", "Book", "Toy", "Fruit", "Clothing"};
        int indexNumber = (int) (Math.random() * 11 - 1);
        return products[indexNumber];
    }

    public String generateFakeStreetAddress() {
        return faker.address().streetAddress();
    }

    public String generateFakeCityName() {
        return faker.address().city();
    }

    public String generateFakePostcode() {
        return faker.address().postcode();
    }

    public String generateFakePhoneNumber() {
        return faker.phoneNumber().phoneNumberInternational();
    }
}