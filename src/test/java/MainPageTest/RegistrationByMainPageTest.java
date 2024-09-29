package MainPageTest;

import DriverSetUp.DriverSetUp;
import MainPage.RegistrationByMainPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.MyTestListeners;

@Listeners(MyTestListeners.class)
public class RegistrationByMainPageTest {
    private WebDriver driver;
    private RegistrationByMainPage registrationByMainPage;


    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.setUpDriver();
        registrationByMainPage = new RegistrationByMainPage(driver);
    }

    @AfterClass
    public void stop() {
        driver.quit();
    }

    /*@Test
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
}*/


    @Test
    public void registrationByEmail(){
        registrationByMainPage.openMainPage()
                .loginLinkMainPage()
                .EnterByEmail()
                .registrationButton()
                .blockMessage();

    }

    @Test
    public void enterByInvalidPass(){
        registrationByMainPage.openMainPage()
                .loginLinkMainPage()
                .EnterByEmail()
                .setInvalidPass()
                .checkboxInfo()
                .buttonClick();
        //.titleBlock() переробити, зробити декілька варіантів неправильний пароль чи пошта;

    }

    @Test
    public void enterByValidPass() {
        registrationByMainPage.openMainPage()
                .loginLinkMainPage()
                .EnterByEmail()
                .checkboxInfo()
                .setValidPass()
                .buttonClick().profileInformation();

//вивести очікуваний результат

    }

/*
@Test
    public void clickLentaPage(){
        registrationByMainPage.openMainPage()
                .popularNewsButton()
                .clickAllMaterials()
               .stringTitle();

    registrationByMainPage.clickAllTeamNews()
            .qaDigestClick();
    Assert.assertEquals(registrationByMainPage.stringTitle(), registrationByMainPage.getTitlePage());
    Assert.assertEquals(registrationByMainPage.getAllTeamsNews(), registrationByMainPage.textAboutHeadTitle());
    }
*/


@Test
    public void checkCommunities(){
        registrationByMainPage.openMainPage()
                .clickCommunityPage()
                .clickQaDigestButton()
                .clickLatestPage()
                .clickTechPage()
                .clickCommentPage();
    //Assert.assertEquals(registrationByMainPage.allHeaderTitlePageQA(), registrationByMainPage.onlyQaTitle());
   // Assert.assertEquals(registrationByMainPage.allHeaderTitlePageQA(), registrationByMainPage.onlyTechTitle());
    Assert.assertEquals(registrationByMainPage.allHeaderTitlePageQA(), registrationByMainPage.onlyCommentTitle());

}


}
