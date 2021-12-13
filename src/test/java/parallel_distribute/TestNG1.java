package parallel_distribute;

import org.testng.annotations.Test;

public class TestNG1 {
    //@Test
    public void TestNG1_Test1(){
        System.out.println("TestNG1_Test1");
        System.out.println(Thread.currentThread().getId());
    }

    //@Test
    public void TestNG1_Test2(){
        System.out.println("TestNG1_Test2");
        System.out.println(Thread.currentThread().getId());
    }

    //@Test
    public void TestNG1_Test3(){
        System.out.println("TestNG1_Test3");
        System.out.println(Thread.currentThread().getId());
    }
}
