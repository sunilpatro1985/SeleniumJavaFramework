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

    @Parameters({"browser"})
    @BeforeClass
    public void setUp(String browserName) throws MalformedURLException {
        //String browser = System.getProperty("browser", "chrome");
        String browser = browserName;

        DesiredCapabilities cap = new DesiredCapabilities();

        if(browser.contains("chrome")){
            //System.setProperty("webdriver.chrome.driver","/Users/skpatro/sel/chromedriver");
            //WebDriverManager.chromedriver().browserVersion("92");
            //WebDriverManager.chromedriver().driverVersion("93.0.4577.63");

            //WebDriverManager.chromedriver().setup();
            //driver = new ChromeDriver();

            //If you run on docker
            cap.setBrowserName("chrome");
            cap.setPlatform(Platform.LINUX);
            driver = new RemoteWebDriver(new URL("http://localhost:4441/wd/hub"), cap);
            System.out.println("Tests running on " + cap.getBrowserName());
        }else
        if(browser.contains("firefox")){
            //System.setProperty("webdriver.gecko.driver","/Users/skpatro/sel/geckodriver");
            //WebDriverManager.firefoxdriver().setup();
            //driver = new FirefoxDriver();

            //If you run on docker
            cap.setBrowserName("firefox");
            cap.setPlatform(Platform.LINUX);
            driver = new RemoteWebDriver(new URL("http://localhost:4442/wd/hub"), cap);
            System.out.println("Tests running on " + cap.getBrowserName());

        }

        driver.get("https://www.saucedemo.com/");

        //PageDriver.setDriver(driver);
        PageDriver.getInstance().setDriver(driver);
        System.out.println("driver initiated");
    }

    @AfterClass
    public void tearDown(){
        //PageDriver.getInstance().getDriver().quit();
        //PageDriver.getDriver().quit();
        PageDriver.getCurrentDriver().quit();
    }
}
