package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends BasePage{
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
    By addToCartButtons = By.cssSelector(".inventory_item button");
    By cartCount = By.cssSelector(".shopping_cart_badge");
    By sort_selector = By.cssSelector(".product_sort_container");
    By first_item_name = By.cssSelector(".inventory_item:nth-child(1) .inventory_item_name");
    By first_item_price = By.cssSelector(".inventory_item:nth-child(1) .inventory_item_price");
    //public WebElement productsText =  driver.findElement(By.cssSelector(".title"));


    public void waitForProduct(){
        waitForEl(productsText);
    }

    public int getItemsSize(){
        return size(inventoryItems);
    }

    public String getCartCount(){
        return getText(cartCount);
    }

    public ProductsPage select_sortOption(String option){
        selectByOption(sort_selector, option);
        return this;
    }

    public String getFirstItemName(){
        return getText(first_item_name);
    }

    public String getFirstItemPrice(){
        return getText(first_item_price);
    }

    public void add_All_items_ToCart(){
        for(WebElement el : getEls(addToCartButtons)){
            el.click();
        }
    }



    /*public void waitForProduct() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(productsTest));
    }

    public void waitForEl() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(productsTest))
        wait.until(waitForElement(productsTest));
    }*/

    /*public static ExpectedCondition<Boolean> waitForElement(WebElement el) {
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
    }*/
}
