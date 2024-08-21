package utilsintest;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * @aauthor : mr.muradil
 * @created : 16.08.2024,18:38
 **/
public class TestResultListener implements ITestListener {
    ScreenShotUtility screenShotUtility = new ScreenShotUtility();

    public void onTestFailure(ITestResult result){
        screenShotUtility.takeScreenShot(result.getMethod().getMethodName().trim() + "-Failed", (ChromeDriver) result.getTestContext().getAttribute("driver"));
    }
}
