package base.extentPkg;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class ExtentTestSample1 extends BTest{

    @Test
    public void MainTest1(){


        //ExtentTest test = ExtentManager.getInstance().createTest("MyTest1111");
        Extent.getTest().log(Status.INFO, "launching browser FF");

        //verify
        Extent.getTest().log(Status.FAIL, "Test spelling not correct   bb");

        //verify
        Extent.getTest().log(Status.WARNING, "alert test not correct");

        //to-dox`
        //verify
        //test.pass("Test case passed");
        Extent.getTest().pass("");



    }

}
