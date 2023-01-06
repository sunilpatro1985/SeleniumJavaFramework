package base.driver;

import base.*;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;

public class BaseTest {
    WebDriverWait wait;
    //WebDriver driver = null;

    @Parameters({"browser"})
    @BeforeClass
    public void setUp(@Optional String browser) throws MalformedURLException {
    //public void setUp() throws MalformedURLException {

        /*browser will be null if we don't run the test from testNG.xml file
         *so if the browser is null, then get the browser value from App.java file
         *You can change the default value of browser=chrome by passing the browser
         * from maven command line as mvn test -Dbrowser=firefox
         */
        if(browser == null){
            browser = App.browser;
        }

        DriverFactory.openBrowser(browser);


        System.out.println("");
        System.out.println("------driver initiated------");
        System.out.println("Running on thread - " + Thread.currentThread().getId());
        System.out.println("Tests running on " +
            ((RemoteWebDriver) PageDriver.getCurrentDriver()).getCapabilities().getBrowserName());

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
