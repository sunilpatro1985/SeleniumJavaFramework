package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SamplePF {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(name = "commit1")
    public WebElement TryMe;

    @FindBy(id = "delay")
    public WebElement delayText;

    @Test
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://qavbox.github.io/demo/delay/");

        PageFactory.initElements(driver, this);

        this.TryMe.click();


        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(waitForElement(delayText));

        System.out.println(delayText.getText());

        Thread.sleep(5000);

        driver.quit();

    }

    public static ExpectedCondition<Boolean> waitForElement(WebElement el) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                boolean flag = false;
                try {
                    if (el.isDisplayed()) {
                        flag = true;
                    }
                } catch (Exception e) {
                    System.out.println("inside catch block " + e.getMessage());
                }
                return flag;
            }
        };
    }
}
