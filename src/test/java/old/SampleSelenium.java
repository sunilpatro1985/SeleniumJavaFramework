package old;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SampleSelenium {
    WebDriver driver = null;
    WebDriverWait wait;

    //@Test
    public void MavenParamTest() throws InterruptedException {

        String browser = System.getProperty("browser", "chrome");

        if(browser.contains("chrome")){
            System.setProperty("webdriver.chrome.driver","/Users/skpatro/sel/chromedriver");
            driver = new ChromeDriver();
        }else
        if(browser.contains("firefox")){
            System.setProperty("webdriver.gecko.driver","/Users/skpatro/sel/geckodriver");
            driver = new FirefoxDriver();
        }

        if(driver != null){
            wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            driver.get("https://www.saucedemo.com/");

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

            driver.findElement(By.id("user-name")).sendKeys("standard_user");

            driver.findElement(By.id("password")).sendKeys("secret_sauce");

            driver.findElement(By.id("login-button")).click();
            Thread.sleep(2000);
            driver.quit();
        }
    }


}
