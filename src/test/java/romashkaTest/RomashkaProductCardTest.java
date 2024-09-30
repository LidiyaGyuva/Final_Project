package romashkaTest;

import DriverSetUp.DriverSetUp;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
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

    @Test(priority = 3)
    @TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/57")
    @Feature("Click button menu")
    @Description("Перевірка переходів між сторінками нижнього меню")
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

    @Test(priority = 1)
    @TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/56")
    @Feature("Product card")
    @Description("Перевірка в карточці товару переходи між кольорами, та внутрішня інформація.")
    public void checkOdyagCard(){
        romashkaProductCardAndFooter.openSite()
                .clickPizhama()
                .clickColorPizhama()
                .clicksubmenuProductCard();
    }

@Test(priority = 2)
@TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/55")
    @Feature("Product card")
@Description("Перевірка в карточці товару переходи між кольорами, та внутрішня інформація.")
    public void checkSumkiCard(){
        romashkaProductCardAndFooter.openSite()
                .clickSumkiProduct()
                .checkColorSumki()
                .clicksubmenuProductCard();
}

@Test(priority = 5)
@TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/54")
@Feature("Wishlist")
@Description("Перевірка пошуку товару по ключовому слову та додавання його в лист обраного.")
    public void checkSearchAndAddWishlist(){
        romashkaProductCardAndFooter.openSite()
                .searchRedRemin()
                .searchRedSumka();
}

@Test(priority = 4)
@TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/58")
@Feature("Negative test")
@Description("Відправка пустих полів для анкети.")
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
