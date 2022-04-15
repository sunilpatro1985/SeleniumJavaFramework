package base.extentPkg;

import com.aventstack.extentreports.ExtentTest;

public class Extent {

    private static ExtentTest test;
    
    public static ExtentTest getTest(){
        return test;
    }

    public static void setTest(ExtentTest test){
        Extent.test = test;
    }

}
