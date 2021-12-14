package parallel_distribute;

import base.Utility;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTestNG {
    @BeforeSuite
    public void setUp(){
        new Utility().printCurrentDateTime();
    }
    @AfterSuite
    public void tearDown(){
        new Utility().printCurrentDateTime();
    }
}
