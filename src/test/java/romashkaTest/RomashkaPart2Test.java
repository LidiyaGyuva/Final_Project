package romashkaTest;

import DriverSetUp.DriverSetUp;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Listeners;
import romashkaSite.RomashkaPart2;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.MyTestListeners;

@Listeners({MyTestListeners.class})
public class RomashkaPart2Test {
    private WebDriver driver;
    private RomashkaPart2 romashkaPart2;

    @BeforeClass
    public void setUp(){
        driver = DriverSetUp.setUpDriver();
        romashkaPart2 = new RomashkaPart2(driver);
    }
    @AfterClass
    public void stop(){
        driver.quit();
    }


    @Test(priority = 1)
    @TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/50")
    @Feature("Filter")
    @Description("Перевірка фільтрації товарів по ціні.")
    public void checkPriceFilter(){

            romashkaPart2.openNewPage()
                    .openFilterAndEnterMinPrice()
                    .checkPriceTitle(driver);
            romashkaPart2.openNewPage()
                    .openFilterAndEnterMaxPrice()
                    .checkMaxPriceTitle(driver);
    }


@Test(priority = 2)
@TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/49")
@Feature("Filter")
@Description("Перевірка фільтрації товарів по розміру та типу товару.")
    public void FilterSearch(){
        romashkaPart2.openNewPage()
                .checkFilterSizeAndType()
                .searchSvetrAfterFilter();

}

@Test(priority = 3)
@TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/51")
@Feature("Click button menu")
@Description("Перевірка сортування товарів по всім категоріям")
    public void sortOtherButton(){
        romashkaPart2.openNewPage()
                .sortTovaryBestSales();
        romashkaPart2.openNewPage()
                .sortTopProdazh();
        romashkaPart2.openNewPage()
                .sortDorogo();
        romashkaPart2.openNewPage()
                .sortOtherSortType();
}

@Test(priority = 4)
@TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/53")
    @Feature("Cart")
@Description("Відфільтрувати товари по кольору, відкрити один із товарів, додати " +
        "його в корзину та перевірити його наявність в корзині.")
    public void clickInKorzinaProduct(){
        romashkaPart2.openNewPage()
                .clickColorFilter()
                .clickOnDressCard()
                .clickKorzinaButton()
                .readTextAboutKorzina();
}

@Test(priority = 5)
@TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/52")
@Feature("Product card")
@Description("Перевірити переходи фото товару в праву та ліву сторону.")
    public void moveToPhotoProduct(){
        romashkaPart2.openNewPage()
                .openAnimalCategories()
                .clickRightPhoto()
                .clickLeftPhoto();
}



}









