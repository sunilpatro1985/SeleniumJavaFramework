package parallel_distribute;

import base.Utility;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestNG1 extends BaseTestNG{
    @Test
    public void TestNG1_Test1(){
        System.out.println("TestNG1_Test1");
        System.out.println(Thread.currentThread().getId());
    }

    @Test
    public void TestNG1_Test2() throws InterruptedException {
        System.out.println("TestNG1_Test2");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getId());
    }

    @Test
    public void TestNG1_Test3(){
        System.out.println("TestNG1_Test3");
        System.out.println(Thread.currentThread().getId());
    }
}
