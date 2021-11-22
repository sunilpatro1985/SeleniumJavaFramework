package pages;

import base.PageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
        WebDriverWait wait;

    public void waitForEl(By byLocator){
        wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(byLocator));
    }

    public void type(By byLocator, String text){
        PageDriver.getCurrentDriver()
                .findElement(byLocator)
                .sendKeys(text);
    }

    public void click(By byLocator){
        PageDriver.getCurrentDriver()
                .findElement(byLocator)
                .click();
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
}
