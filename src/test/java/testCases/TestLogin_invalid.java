package testCases;

import base.App;
import base.BaseTest;
import base.ExtentReport;
import base.PageDriver;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class TestLogin_invalid extends BaseTest {
    WebDriverWait wait;

    @Test
    public void verifyInvalidLogin() throws InterruptedException {
            //WebDriver driver = PageDriver.getDriver();

            //wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            /*driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

            driver.findElement(By.id("user-name")).sendKeys("standard_user");

            driver.findElement(By.id("password")).sendKeys("secret_sauce1");

            driver.findElement(By.id("login-button")).click();*/

            LoginPage loginPage = new LoginPage();
            loginPage.login(App.validUserName,App.inValidpassword);
            Thread.sleep(2000);
        ExtentReport.getTest().log(Status.INFO, "login error");

    }

}
