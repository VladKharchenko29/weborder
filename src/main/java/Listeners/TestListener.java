package Listeners;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import setup.DriverManager;

import java.io.ByteArrayInputStream;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Starting test: " + result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Finished successfully test: " + result.getMethod().getMethodName());

    }

    @Attachment(value = "Page Screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "test/plain")
    public static String saveTextLog(String message){
        return message;
    }

    private static String getTestMethodName(ITestResult iTestResult){
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //Get driver from Test
        result.getInstance();
        WebDriver driver;
        try{
            driver = DriverManager.getWebDriver();
        }
        catch(Exception ClassCastException){
            driver = DriverManager.getWebDriver();
        }

        if(driver != null){
            saveScreenshot(driver);
        }

        saveTextLog(getTestMethodName(result) + " failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ((TakesScreenshot) DriverManager.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        System.out.println("Skipping test " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ((TakesScreenshot) DriverManager.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Starting: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Finishing: " + context.getName());
    }
}
