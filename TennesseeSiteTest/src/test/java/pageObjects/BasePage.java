package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;
    
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
    }
    
    protected void scrollIntoView(WebElement element) {
    	//Thread.sleep(3000);
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    protected void waitForElementToBeClickable(WebElement element) throws InterruptedException {
    	Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    protected void clickWithRetry(WebElement element) {
        try {
            waitForElementToBeClickable(element);
            element.click();
        } catch (Exception e) {
            try {
                scrollIntoView(element);
                waitForElementToBeClickable(element);
                element.click();
            } catch (Exception ex) {
                js.executeScript("arguments[0].click();", element);
            }
        }
    }
}
