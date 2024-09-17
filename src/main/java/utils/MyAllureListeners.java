package utils;

import DriverSetUp.DriverSetUp;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyAllureListeners implements ITestListener {


    @Override
    public void onTestStart(ITestResult result){
        System.out.println("test with name  " + result.getMethod().getMethodName()+ "  started");

    }

    @Override
    public void onTestFailure(ITestResult result){
        saveScreen(((TakesScreenshot) DriverSetUp.setUpDriver()).getScreenshotAs(OutputType.BYTES));


    }

    @Attachment(value = "page Screenshot", type = "image/png")
        private byte [] saveScreen(byte[] screenshot){
        return screenshot;
    }



}
