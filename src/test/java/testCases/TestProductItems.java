package testCases;

import base.BaseTest;
import base.ExcelReader;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class TestProductItems extends BaseTest {
    WebDriverWait wait;

    @Test
    public void Test_TestProductItems() throws Exception {
        ProductsPage productPage = new ProductsPage();
        LoginPage loginPage = new LoginPage();

        loginPage.login(); //valid login
        Thread.sleep(2000);

        productPage.waitForProduct();
        Thread.sleep(2000);
        Assert.assertEquals(productPage.getItemsSize(), 6);

        productPage.add_All_items_ToCart();
        Assert.assertEquals(productPage.getCartCount(), "6");
        Thread.sleep(2000);

        ExcelReader excelreader = new ExcelReader();
        excelreader.setExcelFile("./test_data.xlsx", "prodsort");

        Object obj[][] = excelreader.to2DArray();

        Thread.sleep(30);

        //productPage.select_sortOption("name (Z to A)");
        Assert.assertEquals(
                productPage.select_sortOption("Name (Z to A)").getFirstItemName()
                ,"Test.allTheThings() T-Shirt (Red)"
        );
        Thread.sleep(3000);
        Assert.assertEquals(
                productPage.select_sortOption("Price (low to high)").getFirstItemName()
                ,"Sauce Labs Onesie"
        );
        Thread.sleep(3000);
    }


}
