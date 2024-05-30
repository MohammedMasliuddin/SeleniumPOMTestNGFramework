package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ECDHomePage extends BasePage {
	public ECDHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	private By advantages = By.xpath("//a[text()='Advantages']");
	private By businessClimate = By.xpath("//a[text()='Business Climate']");
	private By reqMoreInformation = By.xpath("//a[contains(text(),'Request More Information')]");
	private WebElement element;
	
	public void hoverAdvantages(){
		Actions actions = new Actions(driver);
        WebElement elementToHover = driver.findElement(advantages);
        actions.moveToElement(elementToHover).perform();
	}
	
	public void clickBusinessClimate() {
        driver.findElement(businessClimate).click();
	}
	
	public void clickReqMoreInformation() {
		element = driver.findElement(reqMoreInformation);
		clickWithRetry(element);
	}
	
}
