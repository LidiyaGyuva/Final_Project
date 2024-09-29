package romashkaTest;

import DriverSetUp.DriverSetUp;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import romashkaSite.RomashkaPart2;
import romashkaSite.RomashkaProductCardAndFooter;
import utils.MyAllureListeners;
import utils.MyTestListeners;

@Listeners({MyTestListeners.class})
public class RomashkaProductCardTest {
    private WebDriver driver;
    private RomashkaProductCardAndFooter romashkaProductCardAndFooter;

    @BeforeClass
    public void setUp(){
        driver = DriverSetUp.setUpDriver();
        romashkaProductCardAndFooter = new RomashkaProductCardAndFooter(driver);
    }
    @AfterClass
    public void stop(){
        driver.quit();
    }
    @TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/57")
    @Test(priority = 3)
    public void clickFooterMenu(){
        romashkaProductCardAndFooter.openSite()
                .clickOnLinkByText("Акції та лояльність")
                .clickOnLinkByText("Поради по догляду")
                .clickOnLinkByText("Повернення і обмін")
                .clickOnLinkByText("Доставка і оплата")
                .clickOnLinkByText("Офлайн магазини")
                .clickOnLinkByText("Відгуки клієнтів")
                .clickOnLinkByText("Гарантія")
                .clickOnLinkByText("Контакти")
                .clickOnLinkByText("Відстежити замовлення");
    }
    @TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/56")
    @Test(priority = 1)
    public void checkOdyagCard(){
        romashkaProductCardAndFooter.openSite()
                .clickPizhama()
                .clickColorPizhama()
                .clicksubmenuProductCard();
    }
    @TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/55")
@Test(priority = 2)
    public void checkSumkiCard(){
        romashkaProductCardAndFooter.openSite()
                .clickSumkiProduct()
                .checkColorSumki()
                .clicksubmenuProductCard();
}
    @TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/54")
@Test(priority = 5)
    public void checkSearchAndAddWishlist(){
        romashkaProductCardAndFooter.openSite()
                .searchRedRemin()
                .searchRedSumka();
}
    @TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/58")
@Test(priority = 4)
    public void checkEmptyInput() {
        romashkaProductCardAndFooter.openSite()
                .openRegistration()
                .saveProfileCard()
                .getTextEmptyInput()
                .enterInvalidText()
                .saveProfileCard()
                .checkErrorMessage();

}






}
