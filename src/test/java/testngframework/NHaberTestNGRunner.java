package testngframework;

import nhaber.pageobjectmodel.searchbutton.SearchButton;
import nhaber.pageobjectmodel.navbarlinks.IsDunyasiMenu;
import nhaber.pageobjectmodel.navbarlinks.NasilMenu;
import nhaber.pageobjectmodel.navbarlinks.NedenMenu;
import nhaber.pageobjectmodel.navbarlinks.YasamMenu;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utilsclasses.BaseClass;
import utilsclasses.Config;
import utilsclasses.ConfigReader;
import utilsintest.TestResultListener;

/**
 * @aauthor : mr.muradil
 * @created : 23.11.2024,00:27
 **/


@Listeners(TestResultListener.class) // Test sonuçlarını dinlemek için listener eklenmiş
public class NHaberTestNGRunner extends BaseClass {

    NedenMenu nedenMenu; // Links sınıfı için referans
    NasilMenu nasilMenu;
    IsDunyasiMenu isDunyasiMenu;
    YasamMenu yasamMenu;
    SearchButton searchButton;

    @BeforeClass
    public void setUp(ITestContext context) {
        openBrowser();
        driver.get(Config.readFromConfig("config.properties", "2nhaber.url"));
        context.setAttribute("driver", driver); // Driver'ı TestContext'e ekler

        nedenMenu = new NedenMenu(driver); // Links sınıfını başlat
        nasilMenu = new NasilMenu(driver);
        isDunyasiMenu = new IsDunyasiMenu(driver);
        yasamMenu = new YasamMenu(driver);
        searchButton = new SearchButton(driver);
    }

    @Test(priority = 1)
    public void testNHaberNavbarLinks() {
        nedenMenu.nedenNavbarLinksVerifyAndClick();
        nasilMenu.nasilNavbarVerifyAndClick();
        isDunyasiMenu.isDunyasiLinksVerifyAndClick();
        yasamMenu.yasamMenuLinksVerifyAndClick();
    }

    @Test(priority = 2)
    public void testNHaberSearchButton(){
      searchButton.verifySearchFunctionality();
    }

    @AfterClass
    public void tearDown() {
        closeBrowser();
    }
}

