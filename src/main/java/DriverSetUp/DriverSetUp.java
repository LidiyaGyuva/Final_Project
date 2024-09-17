package DriverSetUp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSetUp {
    public static WebDriver setUpDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("disable-gpu");
        //options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    public static void clickOnElement(WebDriver driver, By locator){
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        driver.findElement(locator).click();
    }

    public static String getTextFromElement(WebDriver driver, By locator){

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.println("Element with locator " + locator + " not exist!!!");
        }
        return driver.findElement(locator).getText();
    }
}
