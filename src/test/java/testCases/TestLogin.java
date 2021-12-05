package testCases;

import base.BaseTest;
import base.PageDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

import java.time.Duration;

public class TestLogin extends BaseTest {
    WebDriverWait wait;

    @Test
    public void MavenParamTest() throws InterruptedException {
            //WebDriver driver = PageDriver.getCurrentDriver();
            ProductsPage productPage = new ProductsPage();
            //wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            /*driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

            driver.findElement(By.id("user-name")).sendKeys("standard_user");

            driver.findElement(By.id("password")).sendKeys("secret_sauce");

            driver.findElement(By.id("login-button")).click();*/
            LoginPage loginPage = new LoginPage();
            loginPage.login("standard_user","secret_sauce");
            Thread.sleep(2000);
            //ProductsPage productPage = new ProductsPage();
            productPage.waitForProduct();

            //productPage.add_items_to_cart();
        //Assert.assertEquals("6", productPage.getCartCount());

        Assert.assertEquals(
                productPage.select_sortOption("Name (Z to A)").getFirstItemName()
                ,"Test.allTheThings() T-Shirt (Red)");

            Thread.sleep(2000);
    }

    public static ExpectedCondition<Boolean> waitForElement(WebElement el) {
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
    }

}
