import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class Sample1 {
    WebDriver driver;

    @Test
    public void login() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://vardenisiffror.se/unitlists");
// driver.findElement(By.xpath(OR.getProperty("")));
        System.out.println("login test");
// Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("buttonCookie"))));
// org.testng.Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty(""))),"not successful");

        Thread.sleep(3000);
// driver.findElement(By.xpath("//button[text()='Ok']")).click();
        driver.findElement(By.xpath("//button[@class='PrimaryButton-vft123-0 dqTlZO']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='PrimaryButton-vft123-0 dVCAtK']")).click();
        Thread.sleep(3000);


        driver.findElement(By.xpath("//a[@title='Min lista (1)']")).click();
// driver.findElement(By.xpath("//button[@class='MainText-iqeuid-0 iEhoeP']")).click();

        Thread.sleep(3000);
// driver.findElement(By.xpath("//input[@id='select-organizations-input']")).click();
        driver.findElement(By.xpath("//input[@id='select-organizations-input']")).sendKeys("gotland");

        Thread.sleep(3000);

        List<WebElement> list = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (int i = 0; i < list.size()-1; i++) {
            Thread.sleep(3000);
            System.out.println(list.get(i).getText());
// System.out.println(list.get(i).getAttribute("title"));
// System.out.println(list.get(i).getTagName());
            list.get(i).click();

// WebElement text = driver.findElement(By.xpath("//div[@class='checkboxstyles__CheckboxContainer-a7crrk-0 iDxYvm']"));
//// System.out.println(text.getCssValue("title"));
// System.out.println(text.getAttribute("title"));
// WebElement text = driver.findElement(By.xpath("//div[@class='checkboxstyles__CheckboxContainer-a7crrk-0 iDxYvm']"));
// System.out.println(text.getAttribute("title"));
        }
        Thread.sleep(5000);
        driver.findElement(By.id("select-organizations-input")).clear();
        /*driver.findElement(By.xpath("//input[@id='select-organizations-input']")).sendKeys("Keys.TAB");
        driver.findElement(By.xpath("//input[@id='select-organizations-input']")).sendKeys("Keys.TAB");
        driver.findElement(By.xpath("//input[@id='select-organizations-input']")).sendKeys("Keys.ESCAPE");*/
// driver.findElement(By.xpath("//input[@id='unitlist-name']")).click();
//
// driver.findElement(By.xpath("//input[@id='unitlist-name' and @type='text']")).click();
//driver.findElement(By.xpath("//input[@id='select-organizations-input']")).click();
//
//driver.findElement(By.xpath("//input[@id='select-organizations-input']")).sendKeys("Keys.TAB");
//driver.findElement(By.xpath("//input[@id='select-organizations-input']")).sendKeys("Keys.ENTER");

// driver.findElement(By.xpath("//input[@id='unitlist-name']")).click();
//driver.findElement(By.xpath("//a[@class='Link-tbtlpl-0 bnKVbz']")).click();
//
//
        Actions actions = new Actions(driver);
        Action seriesOfActions = actions
                .moveToElement(driver.findElement(By.xpath("//a[@class='Link-tbtlpl-0 bnKVbz']")))
                .click()
// .keyDown(txtUsername, Keys.SHIFT)
// .sendKeys(txtUsername, "hello")
// .keyUp(txtUsername, Keys.SHIFT)
                .doubleClick(driver.findElement(By.xpath("//a[@class='Link-tbtlpl-0 bnKVbz']")))

                .build();


        ((Action) seriesOfActions).perform();


        driver.findElement(By.xpath("//input[@id='select-organizations-checkbox-7']")).sendKeys("Keys.TAB");
        driver.findElement(By.xpath("//input[@id='select-organizations-checkbox-7']")).sendKeys("Keys.ENTER");

        System.out.println("started js");
        JavascriptExecutor js = (JavascriptExecutor) driver;
//js.executeScript("window.scrollBy(0,1000)");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");


        WebElement txtUsername = driver.findElement(By.xpath("//input[@id='unitlist-name']"));
        Actions actions2 = new Actions(driver);
        Action seriesOfActions2 = actions2
                .moveToElement(txtUsername)
                .click()
                .keyDown(txtUsername, Keys.SHIFT)
                .sendKeys(txtUsername, "hello")
                .keyUp(txtUsername, Keys.SHIFT)
                .doubleClick(txtUsername)

                .build();
        seriesOfActions2.perform();


        driver.findElement(By.xpath("//button[@aria-haspopup='true']")).click();

        driver.findElement(By.cssSelector("#unitlist-name")).click();


        WebElement element = driver.findElement(By.xpath("//input[@id='unitlist-name']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);

        driver.navigate().back();
    }
}
