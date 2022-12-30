package testCases;

import base.App;
import base.driver.BaseTest;
import base.ExtentReport;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class TestLogin_invalid extends BaseTest {
    WebDriverWait wait;

    @Test
    public void verifyInvalidLogin() throws InterruptedException {

        LoginPage loginPage = new LoginPage();
        loginPage.login(App.validUserName,App.inValidpassword);
        Thread.sleep(2000);
        Assert.assertEquals(loginPage.getInvalidPasswordErrorText(), "Epic sadface: Username and password do not match any user in this serv");
        ExtentReport.getTest().log(Status.INFO, "login error");

    }

}
