package testngframework;

import amazon.pageobjectmodel.pages.Homepage;
import amazon.pageobjectmodel.pages.SignInPage;
import amazon.pageobjectmodel.pages.SignUpPage;
import utilsclasses.BaseClass;
import utilsclasses.Config;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utilsclasses.ConfigReader;
import utilsintest.TestResultListener;

/**
 * @aauthor : mr.muradil
 * @created : 16.08.2024,18:34
 **/

@Listeners(TestResultListener.class)
public class AmazonTestNGRunner extends BaseClass {
    Homepage homepage;
    SignUpPage signUpPage;
    SignInPage signInPage;

    @BeforeClass
    public void setUp(ITestContext context) {
        openBrowser();
        driver.get(Config.readFromConfig("config.properties", "amazon.url"));
        homepage = new Homepage(driver);
        signUpPage = new SignUpPage(driver);
        signInPage = new SignInPage(driver);
        context.setAttribute("driver", driver);
    }

    @Test(priority = 1)
    public void testHomePage() {
        homepage.homePageVisibleVerify();
    }

    @Test(priority = 2)
    public void testSearchProduct() {
        homepage.searchProduct();
        homepage.searchedProductResult();
    }

    @Test(priority = 3)
    public void testToSignInPage() {
        homepage.toSignInPage();
    }

    @Test(priority = 4)
    public void testLogin() {
        homepage.toSignUpPage();
        signUpPage.verifyVisibleLoginPage();
        signUpPage.login(Config.readFromConfig("config.properties", "amazon.email"),
                Config.readFromConfig("config.properties", "amazon.password"));
        homepage.isUserProfilePageDisplayed();
        homepage.logout();
    }

    @Test(priority = 5)
    public void testSignIn() {
        signUpPage.testNavigateToHomePage();
        homepage.toCreateNewAccount();
        signUpPage.createNewAccountButton();
    }

    @Test(priority = 6)
    public void testCreateAccount() {
        signInPage.verifyCreateAccountPageVisible();
        signInPage.createNewAccount();
    }

    @AfterClass
    public void tearDown() {
        closeBrowser();
    }
}