package Lesson10;

import DriverSetUp.DriverSetUp;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.MyAllureListeners;

@Listeners({MyAllureListeners.class})
public class ContactUsPageTest {

    private WebDriver driver;
    private lesson10.ContactUsPage contactUsPage;

    @BeforeClass
    public void setUp(){
        driver = DriverSetUp.setUpDriver();
        contactUsPage = new lesson10.ContactUsPage(driver);
    }
    @AfterClass
    public void stop(){
        driver.quit();
    }

    @Test
    @Description("this test will check positive sending message.")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Positive test")
    public void sendMessagePositive(){
        String textToSend = "Можна создавать этот метод для редактирования текста а можно писать сразу в методе, вместо это стринги.";
        contactUsPage
                .openContactUsPage()
                .selectOptionFromSubjectHeading(lesson10.ContactUsPage.SubjectHeader.WEBMASTER)
                .setValidEmail().setOrderId()
                .enterMessage(textToSend)
                .clickButton()
                .waitForResultMessage();

        /*String textToSend = "Можна создавать этот метод для редактирования текста а можно писать сразу в методе, вместо это стринги.";
        contactUsPage.openContactUsPage();
         contactUsPage.selectOptionFromSubjectHeading(ContactUsPage.SubjectHeader.WEBMASTER);
        contactUsPage.setValidEmail().setOrderId();
      contactUsPage.enterMessage(textToSend);
    contactUsPage.clickButton();
 contactUsPage.waitForResultMessage();
        */

        Assert.assertEquals(contactUsPage.getSuccessMessage(), contactUsPage.validSuccessMessage());
    }

    @Test
    @Description("this test will check empty message.")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Negative test")
    public void sendMessageNegativeEmptyMessage(){
        contactUsPage.openContactUsPage()
                .setValidEmail()
                .selectOptionFromSubjectHeading(lesson10.ContactUsPage.SubjectHeader.CUSTOM)
                .setOrderId().clickButton()
                .waitForAlertMessage();
        Assert.assertEquals(contactUsPage.getAlertMessage(), contactUsPage.alertResultMessage(lesson10.ContactUsPage.Alert.MESSAGE));
    }

    @Test
    @Description("this test will check invalide mail.")
    @Severity(SeverityLevel.MINOR)
    @Feature("Negative test")
    @TmsLink("https://lidiyagyuva.testrail.io/index.php?/cases/view/1")
    public void sendMessageNegativeInvalidMail(){
        String textToSend = "Можна создавать этот метод для редактирования текста а можно писать сразу в методе, вместо это стринги.";

        contactUsPage.openContactUsPage()
                .setInvalidEmail()
                .selectOptionFromSubjectHeading(lesson10.ContactUsPage.SubjectHeader.CUSTOM)
                .setOrderId()
                .enterMessage(textToSend)
                .clickButton()
                .waitForAlertMessage();

        Assert.assertEquals(contactUsPage.getAlertMessage(), contactUsPage.alertResultMessage(lesson10.ContactUsPage.Alert.EMAIL));
    }

    @Test
    @Description("Falled test")
    @Feature("Negative test")
    public void sendMessageNegativeNoChoose(){
        String textToSend = "text";

        contactUsPage.openContactUsPage()
                .setValidEmail()
                .setOrderId()
                .enterMessage(textToSend)
                .clickButton()
                .waitForAlertMessage();

        Assert.assertEquals(contactUsPage.getAlertMessage(), contactUsPage.alertResultMessage(lesson10.ContactUsPage.Alert.CHOOSE));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Feature("Negative test")
    public void sendMessagePositiveWithoutOrderID() {
        String textToSend = "text";
        contactUsPage
                .openContactUsPage()
                .selectOptionFromSubjectHeading(lesson10.ContactUsPage.SubjectHeader.WEBMASTER)
                .setValidEmail()
                .enterMessage(textToSend)
                .clickButton()
                .waitForResultMessage();
        Assert.assertEquals(contactUsPage.getSuccessMessage(), contactUsPage.validSuccessMessage());

    }




}
