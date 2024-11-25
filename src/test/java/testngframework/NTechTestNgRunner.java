package testngframework;

import ntech.pageopjectmodel.formfilling.MyFormApplication;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilsclasses.BaseClass;
import utilsclasses.Config;
import utilsintest.TestResultListener;

/**
 * @aauthor : mr.muradil
 * @created : 24.11.2024,16:25
 **/

@Listeners(TestResultListener.class)
public class NTechTestNgRunner extends BaseClass {
    MyFormApplication myFormApplication;

    @BeforeClass
    public void setUp(ITestContext context){;
        openBrowser();
        driver.get(Config.readFromConfig("config.properties", "2ntech.url"));
        context.setAttribute("driver",driver);
        myFormApplication = new MyFormApplication(driver);
    }

    @Test
    public void testFormApplication(){
        myFormApplication.verifyCompleteAndSuccessfullySubmitForm();
    }

    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
}
