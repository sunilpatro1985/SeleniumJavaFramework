package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    //static

    public static void openBrowser() throws MalformedURLException {
        WebDriver driver = null;
        DesiredCapabilities cap = new DesiredCapabilities();
        //String browser = System.getProperty("browser", "chrome");
        String browser = App.browser;
        //String browser = browserName;

        if(browser.contains("chrome")){
            //System.setProperty("webdriver.chrome.driver","/Users/skpatro/sel/chromedriver");
            //WebDriverManager.chromedriver().browserVersion("92");
            //WebDriverManager.chromedriver().driverVersion("93.0.4577.63");

            if(App.platform.equalsIgnoreCase("local")){
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            else if(App.platform.equalsIgnoreCase("remote")){
                //If you run on docker
                cap.setBrowserName("chrome");
                cap.setPlatform(Platform.LINUX);
                driver = new RemoteWebDriver(new URL("http://localhost:4441/wd/hub"), cap);
            }
        }else
        if(browser.contains("firefox")){
            //System.setProperty("webdriver.gecko.driver","/Users/skpatro/sel/geckodriver");
            if(App.platform.equalsIgnoreCase("local")){
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            else if(App.platform.equalsIgnoreCase("remote")){
                //If you run on docker
                cap.setBrowserName("firefox");
                cap.setPlatform(Platform.LINUX);
                driver = new RemoteWebDriver(new URL("http://localhost:4442/wd/hub"), cap);
                //System.out.println("Tests running on " + cap.getBrowserName());
            }
        }

        driver.get("https://www.saucedemo.com/"); //prod
        /*if(App.stage.equals("qa")){
            driver.get("https://www.qa.saucedemo.com/");
        }*/

        //PageDriver.setDriver(driver);
        PageDriver.getInstance().setDriver(driver);

    }
}
