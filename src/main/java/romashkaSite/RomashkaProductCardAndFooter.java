package romashkaSite;

import MainPage.RegistrationByMainPage;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;

import java.time.Duration;

    public class RomashkaProductCardAndFooter {
    static final Logger logger = LoggerFactory.getLogger(RomashkaProductCardAndFooter.class);
    private WebDriver driver;
    private WebDriverWait wait;

    public RomashkaProductCardAndFooter(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    private static class Strings {
        private final static String urlBasic = "https://romashka.co.ua/";
        private final static String inputRemin = "Ремінь";
        private final static String inputRed = "Червона";

    }

   /* @FindBy(xpath = "//li[@class='ty-text-links__item ty-level-0 ']//a[contains(text(), 'Акції та лояльність')]")
    private static WebElement buttonAkciiLoyalnost;*/

//FOOTER menu click
    @Step("Open main Site.")
    public RomashkaProductCardAndFooter openSite(){
        logger.info("Open main Site.");
        driver.get(Strings.urlBasic);
        return this;
    }
    @Step("Click on element with dynamic Xpath.")
        public RomashkaProductCardAndFooter clickOnLinkByText(String linkText) {
            logger.info("Click on element with dynamic Xpath: " + linkText);
            String dynamicXpath = "//li[@class='ty-text-links__item ty-level-0 ']//a[contains(text(), '" + linkText + "')]";

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXpath)));
            linkElement.click();
            return this;
        }

        //Test about Card with Odyag Pizhama
@FindBy(xpath = "//li[@class='ty-menu__item js-cp-ro-menu-hover cm-menu-item-responsive']//a[contains(text(), ' Одяг ')]")
        private static WebElement headerButtonOdyag;
    @FindBy(xpath = "//ul[@class='cp-ro-horizontal-menu__submenu-wrap']//a[contains(text(), 'Піжами')]")
        private static WebElement buttonPizhamy;
    @FindBy(xpath = "//a[contains(text(), 'Піжамний комплект \"Снедж\" Romashka, Блакитний')]")
    private static WebElement bluePizhama;
    @FindBy(xpath = "(//a[@class='ty-product-options__image--wrapper cm-history'])[1]")
    private static WebElement colorPizhama1;
        @FindBy(xpath = "(//a[@class='ty-product-options__image--wrapper cm-history'])[2]")
        private static WebElement colorPizhama2;
        @FindBy(xpath = "//a[@class='ty-product-options__image--wrapper ty-product-options__image--wrapper--active cm-history']")
        private static WebElement colorPizhama3;

@Step("Click on Odyag, Pizhama Categories and Blue pizhama.")
    public RomashkaProductCardAndFooter clickPizhama(){
    logger.info("Click on Odyag, Pizhama Categories and Blue pizhama.");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    WebElement linkElement1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='ty-menu__item js-cp-ro-menu-hover cm-menu-item-responsive']//a[contains(text(), ' Одяг ')]")));
    headerButtonOdyag.click();
        WebElement linkElement2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='cp-ro-horizontal-menu__submenu-wrap']//a[contains(text(), 'Піжами')]")));
        buttonPizhamy.click();
        WebElement linkElement3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Піжамний комплект \"Снедж\" Romashka, Блакитний')]")));
        bluePizhama.click();
        return this;
    }
@Step("Change color Pizhama.")
    public RomashkaProductCardAndFooter clickColorPizhama(){
    logger.info("Change color Pizhama.");
        colorPizhama1.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='ty-product-options__image--wrapper cm-history'])[2]")));
        colorPizhama2.click();
        WebElement linkElement2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='ty-product-options__image--wrapper ty-product-options__image--wrapper--active cm-history']")));
        colorPizhama3.click();
        return this;
    }
@FindBy(xpath = "//li[@id='features']")
        private static WebElement zamiryTaOsobluvosti;
    @FindBy(xpath = "//li[@id='product_tab_11']")
        private static WebElement oplata;
    @FindBy(xpath = "//li[@id='product_tab_12']")
        private static WebElement dostavka;
    @FindBy(xpath = "//li[@id='product_tab_13']")
        private static WebElement povernenya;
    @FindBy(xpath = "//li[@id='product_tab_19']")
        private static WebElement doglyad;
    @FindBy(xpath = "//li[@id='availability_in_stores']")
        private static WebElement nayavnistYMagazini;

    @Step("Click submenu for Product Card.")
    public RomashkaProductCardAndFooter clicksubmenuProductCard(){
        logger.info("Click submenu for Product Card.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", zamiryTaOsobluvosti);
        zamiryTaOsobluvosti.click();
        oplata.click();
        dostavka.click();
        povernenya.click();
        doglyad.click();nayavnistYMagazini.click();
        return this;
    }

    //SUMKI product check
    @FindBy(xpath = "//li[@class='ty-menu__item js-cp-ro-menu-hover cm-menu-item-responsive']//a[contains(text(), ' Сумки ')]")
        private static WebElement headerButtonSumki;
    @FindBy(xpath = "//ul[@class='cp-ro-horizontal-menu__submenu-wrap']//a[contains(text(), 'Рюкзаки ')]")
        private static WebElement buttonRykzaki;
    @FindBy(xpath = "//div[@class='ty-grid-list__item-name']//a[contains(text(), 'Рюкзак з кишенею на блискавці ROMASHKA коричневий')]")
        private static WebElement rykzakProduct;
@Step("Find and click Sumki product.")
    public RomashkaProductCardAndFooter clickSumkiProduct(){
    logger.info("Find and click Sumki product.");
        headerButtonSumki.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='cp-ro-horizontal-menu__submenu-wrap']//a[contains(text(), 'Рюкзаки ')]")));
        buttonRykzaki.click();
        WebElement linkElement2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ty-grid-list__item-name']//a[contains(text(), 'Рюкзак з кишенею на блискавці ROMASHKA коричневий')]")));
        rykzakProduct.click();
        return this;
    }
    @FindBy(xpath = "(//a[@class='ty-product-options__image--wrapper cm-history'])[1]")
        private static WebElement colorRykzak1;
        @FindBy(xpath = "(//a[@class='ty-product-options__image--wrapper cm-history'])[2]")
        private static WebElement colorRykzak2;
        @FindBy(xpath = "(//a[@class='ty-product-options__image--wrapper cm-history'])[3]")
        private static WebElement colorRykzak3;
        @FindBy(xpath = "(//a[@class='ty-product-options__image--wrapper cm-history'])[4]")
        private static WebElement colorRykzak4;
@Step("Click on color Rykzak.")
       public RomashkaProductCardAndFooter checkColorSumki(){
    logger.info("Click on color Rykzak.");
    colorRykzak1.click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement linkElement2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='ty-product-options__image--wrapper cm-history'])[2]")));
    colorRykzak2.click();
    WebElement linkElement3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='ty-product-options__image--wrapper cm-history'])[3]")));
    colorRykzak3.click();
    WebElement linkElement4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='ty-product-options__image--wrapper cm-history'])[4]")));
    colorRykzak4.click();
           return this;
       }

       //SEARCH other product and add to wishlist
@FindBy(xpath = "//input[@id='search_input1549']")
        private static WebElement buttonSearchMain;
@FindBy(xpath = "//a[contains(text(), 'Ремінь базовий з квадратною пряжкою ROMASHKA бежевий')]")
        private static WebElement productRemin;
@FindBy(xpath = "(//a[@class='ty-product-options__image--wrapper cm-history'])[4]")
        private static WebElement redColorRemin;
@FindBy(xpath = "//a[@id='button_wishlist_62615']")
        private static WebElement buttonWishlistRemin;
@FindBy(xpath = "//li[@pid='53046']")
        private static WebElement product2RedSumka;
@FindBy(xpath = "//a[@id='button_wishlist_53046']")
        private static WebElement buttonWishlistRedSumka;
@FindBy(xpath = "//a[@class='ty-btn ty-btn__secondary text-button ']")
private static WebElement trySalesButton;

@Step("Search red remin.")
public RomashkaProductCardAndFooter searchRedRemin(){
    logger.info("Search red remin.");
    buttonSearchMain.sendKeys(Strings.inputRemin);
    buttonSearchMain.sendKeys(Keys.ENTER);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Ремінь базовий з квадратною пряжкою ROMASHKA бежевий')]")));
    productRemin.click();
    redColorRemin.click();
    buttonWishlistRemin.click();
    return this;
}
@Step("Search and add Red Sumka.")
public RomashkaProductCardAndFooter searchRedSumka(){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(buttonSearchMain));
    logger.info("Search and add Red Sumka.");
    buttonSearchMain.sendKeys(Strings.inputRed);
    buttonSearchMain.sendKeys(Keys.ENTER);
    WebElement linkElement2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@pid='53046']")));
product2RedSumka.click();
    WebElement linkElement3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='button_wishlist_53046']")));
    buttonWishlistRedSumka.click();
    return this;
}
//REGISTRATION test case
@FindBy(xpath = "//span[@id='email_error_message']")
        private static WebElement errorEmailMessage;

        //enter invalid text
@FindBy(xpath = "//input[@id='email']")
private static WebElement boxEmail;
@FindBy(xpath = "//input[@id='elm_6']")
private static WebElement boxFullname;
@FindBy(xpath = "//input[@id='elm_9']")
private static WebElement boxNumber;

//find registration page
@FindBy(xpath = "//div[@id='sw_dropdown_1445']")
        private static WebElement avatarIcon;
@FindBy(xpath = "(//a[contains(text(), 'Реєстрація')])[1]")
        private static WebElement buttonRegistration;
        @FindBy(xpath = "//button[@id='save_profile_but']")
        private static WebElement saveProfileButton;

//Empty input
@FindBy(xpath = "//span[@id='email_error_message']//b")
        private static WebElement emailInputText;
@FindBy(xpath = "//span[@id='password1_error_message']//b")
        private static WebElement passwordInputText;
@FindBy(xpath = "//span[@id='password2_error_message']//b")
        private static WebElement getPasswordInputText2;
@FindBy(xpath = "//span[@id='elm_6_error_message']//b")
        private static WebElement fullnameInputText;
@FindBy(xpath = "//span[@id='elm_9_error_message']//b")
        private static WebElement phoneInputText;

@Step("Find registration page.")
public RomashkaProductCardAndFooter openRegistration(){
    logger.info("Find registration page.");
    avatarIcon.click();
    buttonRegistration.click();
    return this;
}
@Step("Get Required fields to fill in.")
public RomashkaProductCardAndFooter getTextEmptyInput(){
    logger.info("Get Required fields to fill in.");
    System.out.println("Обов'язкові поля для заповнення:");
    System.out.println(emailInputText.getText());
    System.out.println(passwordInputText.getText());
    System.out.println(getPasswordInputText2.getText());
    System.out.println(fullnameInputText.getText());
    System.out.println(phoneInputText.getText());
    return this;
}
@Step("Click button Save profile.")
public RomashkaProductCardAndFooter saveProfileCard(){
    logger.info("Click button Save profile.");
    saveProfileButton.click();
    return this;
}
@Step("Send invalid text.")
public RomashkaProductCardAndFooter enterInvalidText(){
    logger.info("Send invalid text.");
    driver.navigate().refresh();
    boxEmail.sendKeys("12345");
    boxFullname.sendKeys("ASDFGH");
    boxNumber.sendKeys("1234567891");
    return this;
}
@Step("Check error message.")
public RomashkaProductCardAndFooter checkErrorMessage(){
    logger.info("Check error message.");
    System.out.println("Тип помилки при реєстрації: ");
    System.out.println(errorEmailMessage.getText());
    return this;
}




}
