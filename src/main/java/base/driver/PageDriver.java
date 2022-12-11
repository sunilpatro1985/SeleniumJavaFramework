package base.driver;

import org.openqa.selenium.WebDriver;

public class PageDriver {

    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static PageDriver instance = null;

    private PageDriver(){

    }

    public static PageDriver getInstance(){
        if(instance == null){
            instance = new PageDriver();
        }
        return instance;
    }

    public WebDriver getDriver(){
        return webDriver.get();
    }

    public void setDriver(WebDriver driver){
        webDriver.set(driver);
    }

    public static WebDriver getCurrentDriver(){
        return getInstance().getDriver();
    }


    /*private static final ThreadLocal<String> str = new ThreadLocal<>();
    public static String getStr(){
        return str.get();
    }

    public static void setStr(String string){
            str.set(string);
    }

    public static void main(String []args){
        PageDriver.setStr("qavbox");
        System.out.println(PageDriver.getStr());

        PageDriver.setStr("qavalidation");
        System.out.println(PageDriver.getStr());
    }*/

}
