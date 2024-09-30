package romashkaTest;

import DriverSetUp.DriverSetUp;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
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

    @Test(priority = 1)
    @TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/43")
    @Feature("Negative test")
    @Description("Пошук товару по неправильним ключовим словам.")
    public void openNegativeSearch(){
        romashkaMainPage.openSite().clickSearch("КУРКА").checkAnswerTitle(driver).backPage()
                .clickSearch("KURKA").checkAnswerTitle(driver).backPage()
                .clickSearch("12345").checkAnswerTitle(driver).backPage();
    }

    @Test(priority = 2)
    @TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/44")
    @Feature("Click button menu")
    @Description("Перевірка переходів між сторінками топового меню.")
    public void checkTopCategories(){
        romashkaMainPage.openSite().clickNovinkyButton()
        .checkPageTitle(driver, "Novinky").backPage()
        .clickTopSalesButton().checkPageTitle(driver, "Leader Prodazh").backPage()
        .clickSalesButton().checkPageTitle(driver, "Sale").backPage();

    }

    @Test(priority = 3)
    @TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/45")
    @Feature("Click button menu")
    @Description("Перевірка переходів між сторінками меню на головній сторінці.")
    public void clickOtherCategories(){
        romashkaMainPage.openSite().clickButtonMainPage("Sorochky").checkPageTitle(driver, "Sorochky").backPage()
                .clickButtonMainPage("Verhny odyah").checkPageTitle(driver, "Verhny odyah").backPage()
                .clickButtonMainPage("Bruki").checkPageTitle(driver, "Bruki").backPage()
                .clickButtonMainPage("Sumki").checkPageTitle(driver, "Sumki").backPage()
                .clickButtonMainPage("Svetry").checkPageTitle(driver, "Svetry").backPage()
                .clickButtonMainPage("Spidnytci").checkPageTitle(driver, "Spidnytci").backPage();
    }

    @Test(priority = 4)
    @TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/46")
    @Feature("Click button menu")
    @Description("Перевірка переходів між сторінками субменю.")
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

@Test(priority = 5)
@TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/47")
@Feature("Negative test")
@Description("Реєстрація з неправильними даними.")
    public void loginAndPasswordTest(){
        romashkaMainPage.openSite()
                .avatarAction()
               .invalidLoginAndPass("mailmail@mail", "123456")
                .clickMessage();
}

}
