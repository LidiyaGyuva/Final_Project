package romashkaSite;

import DriverSetUp.CustomWaiterClass;
import MainPage.RegistrationByMainPage;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import javax.crypto.spec.PSource;
import java.time.Duration;

public class RomashkaPart2 {
    static final Logger logger = LoggerFactory.getLogger(RomashkaPart2.class);
    CustomWaiterClass customWaiterClass;
    private WebDriver driver;
    private WebDriverWait wait;

    public RomashkaPart2(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    private static class StringsMessage{
        private final static String urlPageOdyag = "https://romashka.co.ua/odyag/";
        private final static String titleProductSvetr = "СВЕТР \"КЕНТУККІ\" ВІЛЬНОГО КРОЮ ROMASHKA БОРДОВИЙ";
        private final static String bestSales = "-71%";
        private final static String superNew = "Новинка";
        private final static String topProdazh = "Топ продажів";
        private final static String  priceMin = "1000 грн. - 5500 грн.";
        private final static String priceMax = "170 грн. - 1000 грн.";
    }

   @FindBy(xpath = "//div[@class='cp-ro-selected-filter-item']")
    private static WebElement activeFilter;


//Open webPage
   @Step("Open page Odyag")
   public RomashkaPart2 openNewPage(){
       logger.info("Open page Odyag");
       driver.get(StringsMessage.urlPageOdyag);
       return this;
   }


   //button Price
   @FindBy(xpath = "//div[@id='sw_dropdown_1374']")
   private static WebElement buttonFilter;
    @FindBy(xpath = "//a[@class='cm-scroll cm-external-click ty-btn ty-btn__primary ty-product-filters__reset-all']")
    private static WebElement buttonResultFilter;
    @FindBy(xpath = "//input[@id='slider_86_8_left']")
    private static WebElement minPrice;
    @FindBy(xpath = "//input[@id='slider_86_8_right']")
    private static WebElement maxPrice;
    @FindBy(xpath = "//div[@class='cp-ro-selected-filter-item']")
    private static WebElement filterText;
    @FindBy(xpath = "//a[@class='ty-product-filters__reset-all cm-ajax cm-ajax-full-render cm-history']")
    private static WebElement closeFilterOne;
    @FindBy(xpath = "//i[@class='cp-ro-icon cp-ro-icon-close']")
    private static WebElement closeFilterTwo;

    //Open Filter and ENTER min and max PRICE
    @Step("Open filter and enter min price.")
   public RomashkaPart2 openFilterAndEnterMinPrice(){
       logger.info("Open filter and enter min price.");
       buttonFilter.click();
       minPrice.clear();
       minPrice.sendKeys("1000");
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cm-scroll cm-external-click ty-btn ty-btn__primary ty-product-filters__reset-all']")));
       buttonResultFilter.click();
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='cp-ro-icon cp-ro-icon-close']")));
       closeFilterTwo.click();
       return this;
   }
    @Step("Open filter and enter max price.")
    public RomashkaPart2 openFilterAndEnterMaxPrice() {
        logger.info("Open filter and enter MAX price.");
        buttonFilter.click();
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='slider_86_8_right']")));
        maxPrice.clear();
        maxPrice.sendKeys("1000");
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cm-scroll cm-external-click ty-btn ty-btn__primary ty-product-filters__reset-all']")));
        buttonResultFilter.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='cp-ro-icon cp-ro-icon-close']")));
        closeFilterOne.click();
        return this;
    }
   @Step("Check min price about filter.")
public RomashkaPart2 checkPriceTitle(WebDriver driver){
       logger.info("Check min price about filter.");
       String actualPrice = filterText.getText();
       String expectedPrice = StringsMessage.priceMin;
       Assert.assertEquals(actualPrice, expectedPrice, "Ціни не співпадають.");
      return this;
}

    @Step("Check min price about filter.")
    public RomashkaPart2 checkMaxPriceTitle(WebDriver driver){
        logger.info("Check min price about filter.");
        String actualPrice = filterText.getText();
        String expectedPrice = StringsMessage.priceMax;
        Assert.assertEquals(actualPrice, expectedPrice, "Ціни не співпадають.");
        return this;
    }

//button search in filter Size and Type
    @FindBy(id = "sw_content_86_9")
    private static WebElement sizeOdyag;
    @FindBy(xpath = "//a[@class='ab__sf_filter_url'][contains(@href, 'https://romashka.co.ua/odyag/rozmir-one-size/')]")
    private static WebElement checkBoxOneSize;
    @FindBy(xpath = "//div[@id='sw_content_86_17']")
    private static WebElement buttonCategoryTovaru;
    @FindBy(xpath = "(//span[contains(text(), 'Сукні, сарафани')])[1]")
    private static WebElement sykniButton;
    @FindBy(xpath = "(//a[contains(@href, 'https://romashka.co.ua/odyag/svetri-ta-golfi/sviter-kentukki-svobodnogo-kroya-romashka-bordovyy/')])[1]")
    private static WebElement svetrAfterFilter;
    @FindBy(xpath = "//h1[@class='ty-product-block-title']")
    private static WebElement titleProductCard;


    //search in filter with Size and Type
    @Step("Check filter size and type")
    public RomashkaPart2 checkFilterSizeAndType(){
        logger.info("Check filter size and type");
        buttonFilter.click();
        sizeOdyag.click();
        checkBoxOneSize.click();
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cm-scroll cm-external-click ty-btn ty-btn__primary ty-product-filters__reset-all']")));

        buttonCategoryTovaru.click();
        sykniButton.click();
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cm-scroll cm-external-click ty-btn ty-btn__primary ty-product-filters__reset-all']")));
        buttonResultFilter.click();
        return this;
    }

    @Step("Open first Svetr with filter")
    public RomashkaPart2 searchSvetrAfterFilter(){
        logger.info("Open first Svetr with filter");
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@href, 'https://romashka.co.ua/odyag/svetri-ta-golfi/sviter-kentukki-svobodnogo-kroya-romashka-bordovyy/')])[1]")));
        svetrAfterFilter.click();

        String actualTitle = titleProductCard.getText();
        String expectedTitle = StringsMessage.titleProductSvetr;
        Assert.assertEquals(actualTitle, expectedTitle, "Назви не співпали.");
        return this;
    }


    //Work with sort
    @FindBy(xpath = "//a[@id='sw_elm_sort_fields']")
    private static WebElement buttonSort;
    @FindBy(xpath = "//a[contains(text(), 'Спочатку дешевші')]")
    private static WebElement firstDeshevo;
    @FindBy(xpath = "//a[contains(text(), 'Спочатку найбільші знижки')]")
    private static WebElement firstBestSales;
    @FindBy(xpath = "//a[contains(text(), 'Спочатку дорожчі')]")
    private static WebElement firstDorogo;
    @FindBy(xpath = "//a[contains(text(), 'За популярністю')]")
    private static WebElement firstPopular;
    @FindBy(xpath = "//a[contains(text(), 'Сортувати за позицією')]")
    private static WebElement firstPozishion;
    @FindBy(xpath = "//a[contains(text(), 'Сортувати по топу продажів')]")
    private static WebElement firstTopProgyazh;
    @FindBy(xpath = "(//a[contains(@href, 'https://romashka.co.ua/odyag/bluza-s-obemnymi-rukavami-parizh-romashka-lilovaya-uk/')])[1]")
    private static WebElement tovarBestSales;
    @FindBy(xpath = "//span[@class='tfs'][contains(text(), '-71%')]")
    private static WebElement shablonSales;
    @FindBy(xpath = "(//a[contains(@href, 'https://romashka.co.ua/odyag/uteplennoe-zimnee-palto-mersin-romashka-seryy/')])[1]")
    private static WebElement tovarDorogo;
    @FindBy(xpath = "(//span[@class='tfs'][contains(text(), 'Новинка')])[1]")
    private static WebElement shablonNovinka;
    @FindBy(xpath = "//a[contains(text(), 'Спідниця \"Матейрі\" ROMASHKA Коричневий')]")
    private static WebElement tovarTopProdazh;
    @FindBy(xpath = "(//span[@class='tfs'][contains(text(), 'Топ продажів')])[1]")
    private static WebElement shablonTopTovary;

    @Step("Sort tovary about Best Sales")
    public RomashkaPart2 sortTovaryBestSales(){
        logger.info("Sort tovary about Best Sales");
        buttonSort.click();
        firstBestSales.click();
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@href, 'https://romashka.co.ua/odyag/bluza-s-obemnymi-rukavami-parizh-romashka-lilovaya-uk/')])[1]")));
        tovarBestSales.click();

        String actualSale = shablonSales.getText();
        String expectedSale = StringsMessage.bestSales;
        Assert.assertEquals(actualSale, expectedSale, "Шаблон не співпав");
        System.out.println(actualSale);
        return this;
    }
@Step("Sort tovary about Top Prodazh")
    public RomashkaPart2 sortTopProdazh(){
        logger.info("Sort tovary about Top Prodazh");
        buttonSort.click();
        firstTopProgyazh.click();
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Спідниця \"Матейрі\" ROMASHKA Коричневий')]")));
        tovarTopProdazh.click();

        String actualTop = shablonTopTovary.getText();
        String expectedTop = StringsMessage.topProdazh;
        Assert.assertEquals(actualTop, expectedTop, "Шаблон не співпав");
        System.out.println(actualTop);
        return this;
    }
@Step("Sort Dorogo tovary with novinky")
    public RomashkaPart2 sortDorogo(){
        logger.info("Sort Dorogo tovary with novinky");
        buttonSort.click();
        firstDorogo.click();
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@href, 'https://romashka.co.ua/odyag/uteplennoe-zimnee-palto-mersin-romashka-seryy/')])[1]")));
        tovarDorogo.click();

        String actualNew = shablonNovinka.getText();
        String expectedTextNew = StringsMessage.superNew;
        Assert.assertEquals(actualNew, expectedTextNew, "Шаблон не співпав");
        System.out.println(actualNew);
        return this;
    }
@Step("Sort other variant")
    public RomashkaPart2 sortOtherSortType(){
        logger.info("Sort other variant");
        buttonSort.click();
       firstDeshevo.click();
        driver.navigate().refresh();
        buttonSort.click();
        firstPopular.click();
        driver.navigate().refresh();
        buttonSort.click();
        firstPozishion.click();
        return this;
    }


    @FindBy(id = "sw_content_86_12")
    private static WebElement filterColor;
    @FindBy(xpath = "//label[@id='elm_checkbox_86_12_132422']")
    private static WebElement whiteColorFilter;
    @FindBy(xpath = "(//a[contains(@href, 'https://romashka.co.ua/odyag/bodi-uk/bodi-nasva-romashka-belyy-uk-4/')])[1]")
    private static WebElement tovarBilaSyknya;
    @FindBy(xpath = "//button[@id='button_cart_62283']")
    private static WebElement clickButtonBuy;
    @FindBy(xpath = "//a[@class='ty-btn ty-btn__primary cm-notification-close ']")
    private static WebElement clickButtonKorzina;
    @FindBy(xpath = "//div[@id='sw_dropdown_1443']")
    private static WebElement clickButtonMainKorzina;
    @FindBy(xpath = "//th[@class='ty-checkout-summary__sum-total']")
    private static WebElement checkSumKorzina;
    @FindBy(xpath = "//h1[@class='zakaz-title-new']")
    private static WebElement getTextAboutYourBuyer;
    @FindBy(xpath = "//th[@class='ty-checkout-summary__sum-total']")
    private static WebElement sumInKorzina;

@Step("Click in color filter.")
    public RomashkaPart2 clickColorFilter(){
    logger.info("Click in color filter.");
        buttonFilter.click();
        filterColor.click();
        whiteColorFilter.click();
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cm-scroll cm-external-click ty-btn ty-btn__primary ty-product-filters__reset-all']")));
        buttonResultFilter.click();
        return this;
    }
@Step("Click on dress Card.")
    public RomashkaPart2 clickOnDressCard(){
    logger.info("Click on dress Card.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement elem = wait.until(ExpectedConditions.visibilityOf(tovarBilaSyknya));
        tovarBilaSyknya.click();
        clickButtonBuy.click();
        return this;
    }
@Step("Click button about Korzina.")
    public RomashkaPart2 clickKorzinaButton(){
    logger.info("Click button about Korzina.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement elem = wait.until(ExpectedConditions.visibilityOf(clickButtonKorzina));
        clickButtonKorzina.click();
        clickButtonMainKorzina.click();
        return this;
    }
@Step("Read the message in Korzina.")
    public RomashkaPart2 readTextAboutKorzina(){
    logger.info("Read the message in Korzina.");
        System.out.println(getTextAboutYourBuyer.getText());
        System.out.println(sumInKorzina.getText());
return this;
    }

   //Pet Photo gallery
    @FindBy(xpath = "//ul[@class='ty-menu__items cp-ro-main-menu js-cp-ro-menu cp-ro-horizontal-menu cm-responsive-menu']//a[contains(text(), 'Для улюбленців')]")
    private static WebElement categoryLoveAnimal;
    @FindBy(xpath = "//div[@class='ty-grid-list__item-name']//a[contains(text(), 'Худі \"Сіетл\" ROMASHKA Рожевий plus')]")
    private static WebElement productKombess;
    @FindBy(xpath = "//div[@class='owl-next']")
    private static WebElement clickRightPhoto;
    @FindBy(xpath = "//div[@class='owl-prev']//i[@class='cp-ro-icon-arrow-left']")
    private static WebElement clickLeftPhoto;

@Step("Open Animal categories.")
    public RomashkaPart2 openAnimalCategories(){
    logger.info("Open Animal categories.");
        categoryLoveAnimal.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ty-grid-list__item-name']//a[contains(text(), 'Худі \"Сіетл\" ROMASHKA Рожевий plus')]")));
        productKombess.click();
        return this;
    }
@Step("Click right photo.")
    public RomashkaPart2 clickRightPhoto(){
    logger.info("Click right photo.");
        clickRightPhoto.click();
        clickRightPhoto.click();
        clickRightPhoto.click();
        clickRightPhoto.click();
        return this;
    }

    @Step("Click left photo.")
    public RomashkaPart2 clickLeftPhoto(){
        logger.info("Click left photo.");
        clickLeftPhoto.click();
        clickLeftPhoto.click();
        clickLeftPhoto.click();
        clickLeftPhoto.click();
        return this;
    }



















}
