package base.extentPkg;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ExtentTestSample extends BTest{

    @Test
    public void MainTest() throws IOException {


        //ExtentTest test = ExtentManager.getInstance().createTest("MyTest");
        Extent.getTest().log(Status.INFO, "launching browser");

        //verify
        Extent.getTest().log(Status.FAIL, "Test spelling not correct");

        //verify
        Extent.getTest().log(Status.WARNING, "alert test not correct");

        //Extent.getTest().addScreenCaptureFromPath("filepath.jpg");


        //to-dox`
        //verify
        //test.pass("Test case passed");
        Extent.getTest().pass("");



    }

}
