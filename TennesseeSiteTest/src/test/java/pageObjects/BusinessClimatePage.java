package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BusinessClimatePage extends BasePage {
    private By menu = By.xpath("//*[@class='openMenu']");
    private By wfAndEdu = By.xpath("//*[text()='Workforce & Education']");
    private By moreInfo = By.xpath("//a[text()='Request More Info']");

    public BusinessClimatePage(WebDriver driver) {
        super(driver);
    }

    public void clickMenu() {
        driver.findElement(menu).click();
    }

    public void clickWorkforceAndEducation() throws InterruptedException {
    	Thread.sleep(3000);
        driver.findElement(wfAndEdu).click();
    }
    
    public void clickRequestMoreInfo() {
        WebElement element = driver.findElement(moreInfo);
        clickWithRetry(element);
    }

	
}
