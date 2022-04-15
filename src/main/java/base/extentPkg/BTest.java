package base.extentPkg;

import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class BTest {

    @BeforeMethod
    public void setUp(ITestResult result){
        ExtentTest test = ExtentManager.getInstance().createTest(result.getMethod().getMethodName());
        Extent.setTest(test);
    }

    @AfterSuite
    public void tearDown(){
        ExtentManager.getInstance().flush();
    }
}
