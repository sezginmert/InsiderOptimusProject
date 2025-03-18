package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class ReusableMethods  {


    // Burada parent-child uygulandi her methoddan sonra hata bulursa screenshot alıcak
    @AfterMethod
    public void ErrorScreenShots(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            screenshot();
        }
    }

    public static void wait(int saniye) {

        try {
            Thread.sleep(saniye * 1000L);
        } catch (InterruptedException e) {
            System.out.println("Thread.sleep calismadi");
        }

    }

    public static void scrollToElement(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'}); ", element);
    }


    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
    }


}
