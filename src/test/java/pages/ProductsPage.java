package pages;

import base.PageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage extends BasePage {
    WebDriver driver;
    WebDriverWait wait;

    /*public ProductsPage() {
        driver = PageDriver.getCurrentDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".title")
    public WebElement productsTest;*/

    By productsText = By.cssSelector(".title");

    By inventoryItems = By.cssSelector(".inventory_item");
    By cart_count = By.className("shopping_cart_badge");
    By remove_first_item = By.cssSelector(".inventory_item:nth-child(1) .btn_inventory");
    By remove_second_item = By.cssSelector(".inventory_item:nth-child(2) .btn_inventory");
    By sort_selector = By.cssSelector(".product_sort_container");
    By first_item_name = By.cssSelector(".inventory_item:nth-child(1) .inventory_item_name");
    By first_item_price = By.cssSelector(".inventory_item:nth-child(1) .inventory_item_price");

    public String getFirstItem(){
        return getText(first_item_name);
    }

    public String getFirstItemPrice(){
        return getText(first_item_price);
    }



    public void waitForProductText() {
        wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(productsText));
    }

    public int getItemsCount() {
        return size(inventoryItems);
    }

    public void add_items_to_cart() {
        for(int i=1; i<=getItemsCount(); i++){
            click((By.cssSelector(".inventory_item:nth-child("+i+") .btn_inventory")));
        }
    }

    public String getCartCount() {
        return getText(cart_count);
    }

    public ProductsPage select_sortOption(String option){
        selectByText(sort_selector, option);
        return this;
    }

    /*
    //public WebElement productsText =  driver.findElement(By.cssSelector(".title"));

    public void waitForProduct() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(productsTest));
    }

    public void waitForEl() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(productsTest))
        wait.until(waitForElement(productsTest));
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
    */

}
