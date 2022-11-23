package testCases;

import base.App;
import base.BaseTest;
import base.ExtentReport;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

import java.time.Duration;

public class TestLogin extends BaseTest {
    WebDriverWait wait;

    @Test
    public void VeirfyValidLogin() throws InterruptedException {
            //WebDriver driver = PageDriver.getCurrentDriver();
            ProductsPage productPage = new ProductsPage();
            //wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            /*driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

            driver.findElement(By.id("user-name")).sendKeys("standard_user");

            driver.findElement(By.id("password")).sendKeys("secret_sauce");

            driver.findElement(By.id("login-button")).click();*/
            LoginPage loginPage = new LoginPage();
            loginPage.login(App.validUserName,App.validPassword);
            Thread.sleep(2000);
            //ProductsPage productPage = new ProductsPage();
            productPage.waitForProduct();
            ExtentReport.getTest().log(Status.INFO, "login Successful");
            Thread.sleep(2000);
    }

    /*public static ExpectedCondition<Boolean> waitForElement(WebElement el) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                boolean flag = false;
                //System.out.println();
                try {
                    if(el == null){
                        flag = true;
                    }
                } catch (Exception e) {
                    flag = false;
                }
                return flag;
            }
        };
    }*/

}
