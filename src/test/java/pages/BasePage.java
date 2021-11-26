package pages;

import base.PageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    WebDriverWait wait;

    public void type(By byLocator, String text){
        PageDriver.getCurrentDriver()
                .findElement(byLocator)
                .sendKeys(text);

        //wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(15));
        //wait.until(ExpectedConditions.presenceOfElementLocated(byLocator)).sendKeys();
    }

    public void click(By byLocator){
        //waitForEl(byLocator);
        PageDriver.getCurrentDriver()
                .findElement(byLocator)
                .click();

        //wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(15));
        //wait.until(ExpectedConditions.presenceOfElementLocated(byLocator)).click();
    }

    public int size(By byLocator){
        return PageDriver.getCurrentDriver()
                .findElements(byLocator)
                .size();
    }

    public String getText(By byLocator){
        return PageDriver.getCurrentDriver()
                .findElement(byLocator)
                .getText();
    }

    public List<WebElement> getEls(By byLocator){
        return PageDriver.getCurrentDriver()
                .findElements(byLocator);
    }

    public void selectByOption(By byLocator, String option){
        Select select = new Select(PageDriver.getCurrentDriver().findElement(byLocator));
        select.selectByVisibleText(option);
    }

    public void waitForEl(By byLocator){
        wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(byLocator));
    }

}
