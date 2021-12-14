package parallel_distribute;

import base.Utility;
import org.testng.annotations.Test;

public class TestNG3 extends BaseTestNG{
    @Test
    public void TestNG2_Test1(){
        System.out.println("TestNG2_Test1");
        System.out.println(Thread.currentThread().getId());
    }
    @Test
    public void TestNG2_Test2() throws InterruptedException {
        System.out.println("TestNG2_Test2");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getId());
    }
    @Test
    public void TestNG2_Test3(){
        System.out.println("TestNG2_Test3");
        System.out.println(Thread.currentThread().getId());
        new Utility().printCurrentDateTime();
    }
}
