package romashkaSite;

import MainPage.RegistrationByMainPage;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.time.Duration;

public class RomashkaMainPage {
    static final Logger logger = LoggerFactory.getLogger(RomashkaMainPage.class);
    private WebDriver driver;
    private WebDriverWait wait;

    public RomashkaMainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    private static class StringsText{
        private final static String url = "https://romashka.co.ua/";
        private final static String titleNovinki = "Новинки - купити в інтернет-магазині Romashka ❤\uFE0F";
        private final static String titleLiderProdazhy = "Лідери продажу - купити в інтернет-магазині Romashka ❤\uFE0F";
        private final static String titleSalePage = "Sale - купити в інтернет-магазині Romashka ❤\uFE0F";
        private final static String titleSorochky = "Жіночі сорочки - купити в інтернет-магазині Romashka ❤\uFE0F";
        private final static String titleVerhniOdyag = "Жіночий верхній одяг - купити в інтернет-магазині Romashka ❤\uFE0F";
        private final static String titleBruki = "Жіночі брюки - купити в інтернет-магазині Romashka ❤\uFE0F";
        private final static String titleSumki = "Жіночі сумки - купити в інтернет-магазині Romashka ❤\uFE0F";
        private final static String titleSvetry = "Жіночі светри та гольфи - купити в інтернет-магазині Romashka ❤\uFE0F";
        private final static String titleSpidnyci = "Спідниці - купити в інтернет-магазині Romashka ❤\uFE0F";
        private final static String textAnswerSearch = "За вашим запитом нічого не знайдено";
        private final static String errorMessageAlert = "×\n" +
                "Помилка Ви ввели невірний логін або пароль. Спробуйте ще раз.";


    }
//button SEARCH
@FindBy(xpath = "(//img[@class='ty-pict ty-logo-container__image cm-image'])[2]")
private static WebElement clickLogoSite;
@FindBy(xpath = "//div[@class='ty-no-items cm-pagination-container ']")
private static WebElement answerNegativeSearch;
    @FindBy(id = "search_input1549")
    private static WebElement searchInput;


//button TOP categories
    @FindBy(xpath = "(//a[contains(@href, '/products-newest/')]//strong[contains(text(), 'НОВИНКИ')])[1]")
    private static WebElement buttonNovinky;
    @FindBy(xpath = "(//a[contains(@href, '/products-bestsellers/')]//strong[contains(text(), 'ТОП ПРОДАЖ')])[1]")
    private static WebElement buttonTopProdagh;
    @FindBy(xpath = "(//a[contains(@href, '/sale/')]//strong[contains(text(), 'ЗНИЖКИ')])[1]")
    private static WebElement buttonSales;


    //button ANOTHER categories
    @FindBy(id = "det_img_1553735218")
    private static WebElement buttonSorochky;
    @FindBy(id = "det_img_2696597090")
    private static WebElement buttonVerhnyOdyah;
    @FindBy(id = "det_img_1523828128")
    private static WebElement buttonBruki;
    @FindBy(id = "det_img_1267561825")
    private static WebElement buttonSumki;
    @FindBy(id = "det_img_2858623320")
    private static WebElement buttonSvetry;
    @FindBy(id = "det_img_3129356012")
    private static WebElement buttonSpidnysi;

    //click ALL button for MAIN PAGE
    @Step("Clicking button what page you need open.")
    public RomashkaMainPage clickButtonMainPage(String buttonName) {
        logger.info("Clicking button: " + buttonName);
        WebElement buttonToClick;

        switch (buttonName) {
            case "Sorochky":
                buttonToClick = buttonSorochky;
                break;
            case "Verhny odyah":
                buttonToClick = buttonVerhnyOdyah;
                break;
            case "Bruki":
                buttonToClick = buttonBruki;
                break;
            case "Sumki":
                buttonToClick = buttonSumki;
                break;
            case "Svetry":
                buttonToClick = buttonSvetry;
                break;
            case "Spidnytci":
                buttonToClick = buttonSpidnysi;
                break;
            default:
                throw new IllegalArgumentException("Невідома кнопка: " + buttonName);
        }
        buttonToClick.click();
        return this;
    }


//click button about TOP categories
    @Step("click button about Top Prodazh")
    public RomashkaMainPage clickTopSalesButton(){
        logger.info("click button about Top Prodazh");
        buttonTopProdagh.click();
        return this;
    }
    @Step("click button about SALES")
    public RomashkaMainPage clickSalesButton(){
        logger.info("click button about SALES");
        buttonSales.click();
        return this;
    }
    @Step("click button about Novinky")
    public RomashkaMainPage clickNovinkyButton(){
        logger.info("click button about Novinky");
        buttonNovinky.click();
        return this;
    }


//open site and step back
    @Step("Open Romashka page.")
    public RomashkaMainPage openSite(){
        logger.info("Trying open Romashka page.");
        driver.get(StringsText.url);
        return this;
    }
    @Step("Step back page.")
    public RomashkaMainPage backPage(){
        logger.info("Step back page.");
        driver.navigate().back();
        return this;
    }

    //check page title AND check answer search text
    private String getExpectedTitle(String key) {
        logger.info("check key about title name");
        switch (key) {
            case "Novinky":
                return StringsText.titleNovinki;
            case "Leader Prodazh":
                return StringsText.titleLiderProdazhy;
            case "Sale":
                return StringsText.titleSalePage;
            case "Sorochky":
                return StringsText.titleSorochky;
            case "Verhny odyah":
                return StringsText.titleVerhniOdyag;
            case "Bruki":
                return StringsText.titleBruki;
            case "Sumki":
                return StringsText.titleSumki;
            case "Svetry":
                return StringsText.titleSvetry;
            case "Spidnytci":
                return StringsText.titleSpidnyci;
            default:
                throw new IllegalArgumentException("Невідомий ключ заголовка: " + key);
        }
    }


    @Step("Check all page Title.")
    public RomashkaMainPage checkPageTitle(WebDriver driver, String expectedTitleKey){
        logger.info("Check all page Title.");
        String actualTitle = driver.getTitle();
        String expectedTitle = getExpectedTitle(expectedTitleKey);
        Assert.assertEquals(actualTitle, expectedTitle, "Заголовок сторінки не збігається!");
    return this;
    }
    @Step("Check Answer about search title.")
    public RomashkaMainPage checkAnswerTitle(WebDriver driver){
        logger.info("Check Answer about search title.");
        String actualTitle =answerNegativeSearch.getText();
        Assert.assertEquals(actualTitle, StringsText.textAnswerSearch, "Заголовок сторінки не збігається!");
        return this;
    }

//write and ENTER negative word from search
@Step("Enter some word for Search.")
    public RomashkaMainPage clickSearch(String textForSearch){
        logger.info("Enter some word for Search.");
        searchInput.click();
        searchInput.sendKeys(textForSearch);
        searchInput.sendKeys(Keys.ENTER);
        return this;
}

    @FindBy(xpath = "//li[@class='ty-menu__item cm-menu-item-responsive']")
    private static WebElement buyerMenu;
    @FindBy(xpath = "//a[contains(text(), 'Відгуки')][@class='ty-menu__submenu-link']")
    private static WebElement submenuVidguki;
    @FindBy(xpath = "//a[contains(text(), 'Акції та пропозиції')][@class='ty-menu__submenu-link']")
    private static WebElement submenuAkcyi;
    @FindBy(xpath = "//a[contains(text(), 'Догляд')][@class='ty-menu__submenu-link']")
    private static WebElement submenuDoglyad;
    @FindBy(xpath = "//a[contains(text(), 'Доставка і оплата')][@class='ty-menu__submenu-link']")
    private static WebElement submenuDostavka;
    @FindBy(xpath = "//a[contains(text(), 'Повернення і обмін')][@class='ty-menu__submenu-link']")
    private static WebElement submenuPovernenya;
    @FindBy(xpath = "//a[contains(text(), 'Контакти')][@class='ty-menu__submenu-link']")
    private static WebElement submenuKontakty;
    @FindBy(xpath = "//a[contains(text(), 'Програма лояльності')][@class='ty-menu__submenu-link']")
    private static WebElement submenuProgramaLoylnosty;
    @FindBy(xpath = "//a[contains(text(), 'Благодійність')][@class='ty-menu__submenu-link']")
    private static WebElement submenuBlagodiynist;
    @FindBy(xpath = "//a[contains(text(), 'Гарантійні терміни на товар')][@class='ty-menu__submenu-link']")
    private static WebElement submenuGarantii;
    @FindBy(xpath = "//a[contains(text(), 'Відстежити замовлення')][@class='ty-menu__submenu-link']")
    private static WebElement submenuVidstezhutuZamovlenya;

//Action about SubMenu
    @Step("Hover over menu and click submenu")
    public RomashkaMainPage actionClickMenu(String buttonType){
        logger.info("Hovering over menu and clicking submenu:" + buttonType);
        Actions actions = new Actions(driver);
        actions.moveToElement(buyerMenu).perform();

        WebElement submenuToClick;
        switch (buttonType) {
            case "Vidguki":
                submenuToClick = submenuVidguki;
                break;
            case "Akcyi":
                submenuToClick = submenuAkcyi;
                break;
            case "Doglyad":
                submenuToClick = submenuDoglyad;
                break;
            case "Dostavka":
                submenuToClick = submenuDostavka;
                break;
            case "Povernenya":
                submenuToClick = submenuPovernenya;
                break;
            case "Kontakty":
                submenuToClick = submenuKontakty;
                break;
            case "ProgramaLoylnosty":
                submenuToClick = submenuProgramaLoylnosty;
                break;
            case "Blagodiynist":
                submenuToClick = submenuBlagodiynist;
                break;
            case "Garantii":
                submenuToClick = submenuGarantii;
                break;
            case "VidstezhutuZamovlenya":
                submenuToClick = submenuVidstezhutuZamovlenya;
                break;
            default:
                throw new IllegalArgumentException("Невідома кнопка: " + buttonType);
        }
        actions.moveToElement(submenuToClick).click().perform();

        return this;

    }
//Avatar cabinet
    @FindBy(id = "sw_dropdown_1445")
    private static WebElement avatarButton;
    @FindBy(xpath = "(//a[@class='ty-account-info__a underlined'][contains(text(), 'Мій кабінет')])[1]")
    private static WebElement myCabinetButton;
    @FindBy(id = "login_main_login")
    private static WebElement loginInput;
    @FindBy(id = "psw_main_login")
    private static WebElement passwordInput;
    @FindBy(xpath = "(//button[contains(text() , 'Ввійти')])[3]")
    private static WebElement buttonEnter;
    @FindBy(xpath = "//div[@class='cm-notification-content notification-content alert-error']")
    private static WebElement alertErrorButton;

    //Methods by Alert
    @Step("Alert message.")
    public RomashkaMainPage clickMessage(){
        String alertTextMessage = alertErrorButton.getText();
        Assert.assertEquals(alertTextMessage, StringsText.errorMessageAlert, "Текст не співпав. Перевірте дані і спробуйте ще раз.");
        return this;
    }
    @Step("Enter invalid login and password.")
    public RomashkaMainPage invalidLoginAndPass(String login, String password){
        logger.info("Enter invalid login and password.");
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        buttonEnter.click();
        return this;
    }
    @Step
    public RomashkaMainPage avatarAction(){
        Actions actionsAvatar = new Actions(driver);
        actionsAvatar.moveToElement(avatarButton).click()
        .moveToElement(myCabinetButton).click().build().perform();
        return this;
    }





}
