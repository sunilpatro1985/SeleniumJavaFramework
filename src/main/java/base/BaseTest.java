package base;

import base.extentPkg.Extent;
import base.ExtentManager;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class BaseTest {
    WebDriverWait wait;
    //WebDriver driver = null;

    //@Parameters({"browser"})
    @BeforeClass
    //public void setUp(String browserName) throws MalformedURLException {
    public void setUp() throws MalformedURLException {

        DriverFactory.openBrowser();


        System.out.println("");
        System.out.println("------driver initiated------");
        System.out.println("Running on thread - " + Thread.currentThread().getId());
        System.out.println("Tests running on " +
            ((RemoteWebDriver)PageDriver.getCurrentDriver()).getCapabilities().getBrowserName());

        //cap.getBrowserName());
    }

    @BeforeMethod
    public void setUpSparktest(ITestResult result){
        ExtentTest test = ExtentManager.getInstance().createTest(result.getMethod().getMethodName());
        ExtentReport.setTest(test);
    }

    @AfterMethod
    public void SparktestResult(ITestResult result) throws IOException {
        if(!result.isSuccess()){
            ExtentReport.getTest().log(Status.FAIL, "test case failed as - " +
                    result.getThrowable());
            String screenshotPath = Util.getScreenshot(result.getMethod().getMethodName()+".jpg");

             /*ExtentReport.getTest()
                    .addScreenCaptureFromPath(screenshotPath)
                    .fail(MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
                    */
            ExtentReport.getTest().fail(MediaEntityBuilder
                    .createScreenCaptureFromBase64String(Util.convertImg_Base64(screenshotPath)).build());
        }
    }

    @AfterClass
    public void tearDown(){
        //PageDriver.getInstance().getDriver().quit();
        //PageDriver.getDriver().quit();
        if(PageDriver.getInstance() != null) {
            PageDriver.getCurrentDriver().quit();
        }
    }

    @AfterSuite
    public void sparkFlush(){
        ExtentManager.getInstance().flush();
    }
}
