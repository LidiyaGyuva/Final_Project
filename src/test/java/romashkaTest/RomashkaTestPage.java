package romashkaTest;

import DriverSetUp.DriverSetUp;
import org.testng.annotations.Listeners;
import romashkaSite.RomashkaMainPage;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.MyAllureListeners;
import utils.MyTestListeners;

@Listeners({MyTestListeners.class})
public class RomashkaTestPage {
    private WebDriver driver;
    private RomashkaMainPage romashkaMainPage;

    @BeforeClass
    public void setUp(){
        driver = DriverSetUp.setUpDriver();
        romashkaMainPage = new RomashkaMainPage(driver);
    }
    @AfterClass
    public void stop(){
        driver.quit();
    }
@TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/43")
    @Test(priority = 1)
    public void openNegativeSearch(){
        romashkaMainPage.openSite().clickSearch("КУРКА").checkAnswerTitle(driver).backPage()
                .clickSearch("KURKA").checkAnswerTitle(driver).backPage()
                .clickSearch("12345").checkAnswerTitle(driver).backPage();
    }
@TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/44")
    @Test(priority = 2)
    public void checkTopCategories(){
        romashkaMainPage.openSite().clickNovinkyButton()
        .checkPageTitle(driver, "Novinky").backPage()
        .clickTopSalesButton().checkPageTitle(driver, "Leader Prodazh").backPage()
        .clickSalesButton().checkPageTitle(driver, "Sale").backPage();

    }
@TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/45")
    @Test(priority = 3)
    public void clickOtherCategories(){
        romashkaMainPage.openSite().clickButtonMainPage("Sorochky").checkPageTitle(driver, "Sorochky").backPage()
                .clickButtonMainPage("Verhny odyah").checkPageTitle(driver, "Verhny odyah").backPage()
                .clickButtonMainPage("Bruki").checkPageTitle(driver, "Bruki").backPage()
                .clickButtonMainPage("Sumki").checkPageTitle(driver, "Sumki").backPage()
                .clickButtonMainPage("Svetry").checkPageTitle(driver, "Svetry").backPage()
                .clickButtonMainPage("Spidnytci").checkPageTitle(driver, "Spidnytci").backPage();
    }
@TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/46")
    @Test(priority = 4)
    public void clickSubmenuBuyer(){
        romashkaMainPage.openSite().actionClickMenu("Vidguki").backPage()
                .actionClickMenu("Akcyi").backPage()
                .actionClickMenu("Doglyad").backPage()
                .actionClickMenu("Dostavka").backPage()
                .actionClickMenu("Povernenya").backPage()
                .actionClickMenu("Kontakty").backPage()
                .actionClickMenu("ProgramaLoylnosty").backPage()
                .actionClickMenu("Blagodiynist").backPage()
                .actionClickMenu("Garantii").backPage()
                .actionClickMenu("VidstezhutuZamovlenya").backPage();
    }
@TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/47")
@Test(priority = 5)
    public void loginAndPasswordTest(){
        romashkaMainPage.openSite()
                .avatarAction()
               .invalidLoginAndPass("mailmail@mail", "123456")
                .clickMessage();
}

}
