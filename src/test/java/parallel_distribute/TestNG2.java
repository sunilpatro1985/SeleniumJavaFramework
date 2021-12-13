package parallel_distribute;

import org.testng.annotations.Test;

public class TestNG2 {
    //@Test
    public void TestNG2_Test1(){
        System.out.println("TestNG2_Test1");
        System.out.println(Thread.currentThread().getId());
    }
    //@Test
    public void TestNG2_Test2(){
        System.out.println("TestNG2_Test2");
        System.out.println(Thread.currentThread().getId());
    }
    //@Test
    public void TestNG2_Test3(){
        System.out.println("TestNG2_Test3");
        System.out.println(Thread.currentThread().getId());
    }
}
