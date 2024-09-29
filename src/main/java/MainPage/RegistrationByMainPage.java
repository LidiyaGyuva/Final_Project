package MainPage;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.time.Duration;

public class RegistrationByMainPage {

    static final Logger logger = LoggerFactory.getLogger(RegistrationByMainPage.class);
    private WebDriver driver;
    private WebDriverWait wait;
    public RegistrationByMainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

private static class Strings{
    private final static String url = "https://dou.ua/";
    private final static String messageClosed = "Реєстрацію по email закрито";
    private final static String titlePage = "Нові записи — Стрічка | DOU";
    private final static String loginText = "lidiyagyuva@gmail.com";
    private final static String passNegativePage = "123Abc";
    private final static String passPositivePage = "1234AbCdE";
    private final static String titleTextForm = "Вхід по пошті";
    private final static String headNewsTitle = "Матеріали на тему «QA дайджест» RSS";
    private final static String titleHeaderQaTopic = "QA спільнота";
    private final static String titleHeaderTech = "Технічні статті й дайджести";
    private final static String titleHeaderComments = "Останні коментарі";

}

public String textAboutHeadTitle(){
        return Strings.headNewsTitle;
}
    public String getTitlePage(){
        return Strings.titlePage;
    }
    public String endEmailMessage(){
        return Strings.messageClosed;
    }


    @FindBy(xpath = "//div[contains(text(), 'Вхід по пошті')]")
    private static WebElement textByTitle;
    @FindBy(xpath = "(//a[contains(@href, 'https://dou.ua/users/lidiya-gujva/')])[1]")
    private static WebElement profileLink;
    @FindBy(id = "login-link")
    private static WebElement linkLogin;
    @FindBy(id = "agree-checkbox")
    private static WebElement checkboxAgree;
    @FindBy(xpath = "//button[@class='big-button btnSubmit'][contains(text (), 'Увійти')]")
    private static WebElement buttonEnter;
    @FindBy(xpath = "//div[@class='input']//input[@type='text']")
    private static WebElement emailInput;
    @FindBy(xpath = "//input[@class='txtPassword']")
    private static WebElement passwordInput;
    @FindBy(id = "_loginByMail")
    private static WebElement loginByEmail;
    @FindBy(xpath = "//a[contains(text(), \"Реєстрація\")]")
    private static WebElement buttonRegistration;
    @FindBy(xpath = "//div[@class='message-closed']")
    private static WebElement messageEndBlock;
    @FindBy(xpath = "//ul[@class='b-articles-switch']//a[contains(text(), 'Популярне')]")
    private static WebElement popularNews;
    @FindBy(xpath = "//a[@class='all-materials']")
    private static WebElement buttonAllMaterials;
    @FindBy(xpath = "//div[@class='wrap m320-hide']")
    private static WebElement allTeamsNews;
    @FindBy(xpath = "(//a[contains(@href, 'https://dou.ua/forums/tags/QA/?from=fpcommunity')])[1]")
    private static WebElement qaDigestButton;
    @FindBy(xpath = "//div[@class='page-head']")
    private static WebElement titleHeadAboutNews;
    @FindBy(xpath = "//a[contains(@href, '#communities')]")
    private static WebElement headerButtonCommunity;
    @FindBy(xpath = "//a[@class='link'][contains(@href, 'https://dou.ua/forums/tags/QA/?from=fpcommunity')]")
    private static WebElement qaCommunityLink;
    @FindBy(xpath = "//div[@class='page-head']")
    private static WebElement titleHeaderQAcommunityTechPageCommentPage;
    @FindBy(xpath = "//a[contains(@href, 'https://dou.ua/forums/latest/')]")
    private static WebElement latestNewPage;
    @FindBy(xpath = "//a[contains(@href, 'https://dou.ua/forums/tags/tech/')][contains(text(), 'Технічні')]")
    private static WebElement techNewPage;
    @FindBy(xpath = "//a[contains(@href, 'https://dou.ua/forums/comments/')]")
    private static WebElement latestCommentPage;


    /*вивести тайтл сторінки в консоль, повинна бути = Нові записи —  Стрічка | DOU

    String title = driver.getTitle();
    String url = driver.getCurrentUrl();
                System.out.println("Название: " + title);
                System.out.println("Ссылка: " + url);
*/

   @Step("Information by new user and return Full name.")
    public RegistrationByMainPage profileInformation(){
       logger.info("Information by new user and return Full name.");
       Actions actions = new Actions(driver);
       actions.moveToElement(profileLink).click();
       return this;
    }
    @Step("Block message.")
    public RegistrationByMainPage blockMessage(){
        logger.info("Block message.");
        Assert.assertEquals(messageEndBlock.getText(), Strings.messageClosed);
        return this;
    }
@Step("Text title is displayed.")
    public RegistrationByMainPage titleBlock(){
        logger.info("Text title is displayed.");
        Assert.assertEquals(textByTitle.getText(), Strings.titleTextForm);
        return this;
    }
@Step("Click by button Enter/Registration.")
    public RegistrationByMainPage loginLinkMainPage(){
        logger.info("Click by button Enter/Registration.");
        linkLogin.click();
        return this;
    }
@Step("Open Main Page.")
    public RegistrationByMainPage openMainPage(){
    logger.info("Open url Main Page");
    driver.get(Strings.url);
    return this;
}
@Step("Send valid Email and Invalid password.")
public RegistrationByMainPage setInvalidPass(){
    emailInput.sendKeys(Strings.loginText);
    passwordInput.sendKeys(Strings.passNegativePage);
    logger.info("Password info " +Strings.passNegativePage);
    return this;
}
@Step("Send valid email and INVALID password.")
public RegistrationByMainPage setValidPass(){
    emailInput.sendKeys(Strings.loginText);
    passwordInput.sendKeys(Strings.passPositivePage);
    logger.info("Password info " +Strings.passNegativePage);
    return this;
}
@Step("Click button УВІЙТИ.")
public RegistrationByMainPage buttonClick(){
    logger.info("Click button УВІЙТИ.");
    buttonEnter.click();
    return this;
}
@Step("checkbox is Enabled?")
public RegistrationByMainPage checkboxInfo(){
    logger.info("checkbox is Enabled?");
    checkboxAgree.isEnabled();
    return this;
}
@Step("Registration main button")
public RegistrationByMainPage registrationButton (){
    logger.info("Registration main button");
    buttonRegistration.click();
    return this;
}
@Step("Click by enter from email.")
public RegistrationByMainPage EnterByEmail(){
    logger.info("Click by enter from email.");
    loginByEmail.click();
    return this;
}
@Step("clickAllTeamNews")
    public RegistrationByMainPage clickAllTeamNews(){
        allTeamsNews.click();
        return this;
    }
    @Step("qaDigestClick")
    public RegistrationByMainPage qaDigestClick(){
        qaDigestButton.click();
        return this;
    }
@Step("Get text about Teams News")
    public String getAllTeamsNews(){
       logger.info("Get text about Teams News");
        return titleHeadAboutNews.getText();
    }
@Step("Click button Popular news")
    public RegistrationByMainPage popularNewsButton(){
       logger.info("Click button Popular news");
        popularNews.click();
        return this;
    }
@Step("Click button ALL Materials")
    public RegistrationByMainPage clickAllMaterials(){
       logger.info("Click button ALL Materials");
        buttonAllMaterials.click();
        return this;
    }
@Step("Get title page")
    public String stringTitle(){
       logger.info("Get title page.");
        String titleStr = driver.getTitle();
        return titleStr;
    }
@Step("locator for all Strings title page")
    public String allHeaderTitlePageQA(){
       logger.info("locator for all Strings title page");
        return titleHeaderQAcommunityTechPageCommentPage.getText();
    }
    @Step("Text about header page Comments")
    public String onlyCommentTitle(){
       logger.info("Text about header page Comments");
        return Strings.titleHeaderComments;
    }
    @Step("Text about header page Tech")
    public String onlyTechTitle(){
       logger.info("Text about header page Tech");
        return Strings.titleHeaderTech;
    }
    @Step("Text about header page QA community")
    public String onlyQaTitle(){
       logger.info("Text about header page QA community");
        return Strings.titleHeaderQaTopic;
    }

    public RegistrationByMainPage clickTechPage(){
        techNewPage.click();
        return this;
    }

    public RegistrationByMainPage clickLatestPage(){
        latestNewPage.click();
        return this;
    }

    public RegistrationByMainPage clickCommentPage(){
        latestCommentPage.click();
        return this;
    }

public RegistrationByMainPage clickCommunityPage(){
    headerButtonCommunity.click();
    return this;
}

public RegistrationByMainPage clickQaDigestButton(){
    qaDigestButton.click();
    return this;
}
}
