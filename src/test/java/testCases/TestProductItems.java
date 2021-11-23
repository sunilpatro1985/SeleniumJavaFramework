package testCases;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class TestProductItems extends BaseTest {
    WebDriverWait wait;

    @Test
    public void Test_TestProductItems() throws InterruptedException {
        ProductsPage productPage = new ProductsPage();
        LoginPage loginPage = new LoginPage();

        loginPage.login("standard_user","secret_sauce");
        Thread.sleep(2000);

        productPage.waitForProduct();
        Thread.sleep(2000);
        Assert.assertEquals(productPage.getItemsSize(), 6);

        productPage.add_All_items_ToCart();
        Assert.assertEquals(productPage.getCartCount(), "6");
        Thread.sleep(2000);
    }


}
