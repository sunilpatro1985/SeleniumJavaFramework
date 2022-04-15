package base;

import base.extentPkg.Extent;
import com.aventstack.extentreports.ExtentTest;

public class ExtentReport {
    //private static ExtentTest test;
    private static final ThreadLocal<ExtentTest> extentTest
            = new ThreadLocal<ExtentTest>();

    public static ExtentTest getTest(){
        return extentTest.get();
    }

    public static void setTest(ExtentTest test){
        extentTest.set(test);
        //Extent.test = test;
    }
}
