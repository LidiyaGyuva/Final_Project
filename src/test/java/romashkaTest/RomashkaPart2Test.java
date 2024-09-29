package romashkaTest;

import DriverSetUp.DriverSetUp;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Listeners;
import romashkaSite.RomashkaPart2;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.MyAllureListeners;
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

    @TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/50")
    @Test(priority = 1)
    public void checkPriceFilter(){
        romashkaPart2.openNewPage()
                .openFilterAndEnterMinPrice()
               .checkPriceTitle(driver);
        romashkaPart2.openNewPage()
                .openFilterAndEnterMaxPrice()
                .checkMaxPriceTitle(driver);
    }
    @TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/49")
@Test(priority = 2)
    public void FilterSearch(){
        romashkaPart2.openNewPage()
                .checkFilterSizeAndType()
                .searchSvetrAfterFilter();
}
    @TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/51")
@Test(priority = 3)
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
    @TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/53")
@Test(priority = 4)
    public void clickInKorzinaProduct(){
        romashkaPart2.openNewPage()
                .clickColorFilter()
                .clickOnDressCard()
                .clickKorzinaButton()
                .readTextAboutKorzina();
}
    @TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/52")
@Test(priority = 5)
    public void moveToPhotoProduct(){
        romashkaPart2.openNewPage()
                .openAnimalCategories()
                .clickRightPhoto()
                .clickLeftPhoto();
}



}









