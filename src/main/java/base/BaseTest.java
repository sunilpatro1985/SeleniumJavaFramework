package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    WebDriver driver = null;
    WebDriverWait wait;

    //@Parameters({"browser"})
    @BeforeClass
    //public void setUp(String browserName) throws MalformedURLException {
    public void setUp() throws MalformedURLException {
        //String browser = System.getProperty("browser", "chrome");
        String browser = App.browser;
        //String browser = browserName;

        DesiredCapabilities cap = new DesiredCapabilities();

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
        System.out.println("");
        System.out.println("------driver initiated------");
        System.out.println("Running on thread - " + Thread.currentThread().getId());
        System.out.println("Tests running on " +
            ((RemoteWebDriver)driver).getCapabilities().getBrowserName());

        //cap.getBrowserName());
    }

    @AfterClass
    public void tearDown(){
        //PageDriver.getInstance().getDriver().quit();
        //PageDriver.getDriver().quit();
        PageDriver.getCurrentDriver().quit();
    }
}
