package utils;

import DriverSetUp.DriverSetUp;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class MyTestListeners implements ITestListener {

    public static void makeScreenshot(String methods){
        File screenshotFile = ((TakesScreenshot) DriverSetUp.setUpDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File("./target/screenshots/" + methods + ".png"));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void onTestStart(ITestResult result){
        System.out.println("test with name  " + result.getMethod().getMethodName()+ "  started");

    }

    @Override
    public void onTestFailure(ITestResult result){
        makeScreenshot(result.getMethod().getMethodName());
    }


}
