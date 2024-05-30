package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class RequestMoreInfoPage extends BasePage {
    private By name = By.xpath("//*[@id='field_ivtv5']");
    private By radioButton = By.xpath("//*[@id='field_urwbu-0']");
    private By title = By.xpath("//*[@id='field_p7kic']");
    private By comName = By.xpath("//*[@id='field_753jw']");
    private By city = By.xpath("//*[@id='field_znvfg']");
    private By state = By.xpath("//*[@id='field_xxid3']");
    private By zipCode = By.xpath("//*[@id='field_nl9ue']");
    private By country = By.xpath("//*[@id='field_hp721']");
    private By phNo = By.xpath("//*[@id='field_wz196']");
    private By email1 = By.xpath("//*[@id='field_ful80']");
    private By signUp = By.xpath("//*[contains(@id,'field_kz3hq-0')]");
    private By des = By.xpath("//*[@id='field_k2hmi']");
   // private By imNotRobot = By.xpath("//div[@id='frm_field_27_container']");
    private By email2 = By.xpath("//*[@id='field_wdkr1']");
    private By submit = By.xpath("//*[text()='Submit']");
    private WebElement element;
    
    
    //fetching excel details
    
    
    public RequestMoreInfoPage(WebDriver driver) {
        super(driver);
    }
    public void fillForm(String nameValue, String titleValue, String comNameValue, String cityValue, String stateValue, String zipCodeValue, String countryValue, String phNoValue, String email1Value, String desValue, String email2Value) throws InterruptedException {
        driver.findElement(name).sendKeys(nameValue);
        element = driver.findElement(radioButton);
        clickWithRetry(element);
        driver.findElement(title).sendKeys(titleValue);
        driver.findElement(comName).sendKeys(comNameValue);
        driver.findElement(city).sendKeys(cityValue);
        driver.findElement(state).sendKeys(stateValue);
        driver.findElement(zipCode).sendKeys(zipCodeValue);
        driver.findElement(country).sendKeys(countryValue);
        driver.findElement(phNo).sendKeys(phNoValue);
        driver.findElement(email1).sendKeys(email1Value);
        element = driver.findElement(signUp);
        clickWithRetry(element);
//        WebElement signUpElement = driver.findElement(signUp);
//        scrollIntoView(signUpElement);
//        waitForElementToBeClickable(signUpElement);
//        signUpElement.click();
//        WebElement element = driver.findElement(signUp);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//        
//        Thread.sleep(3000);
//        
//        // Use WebDriverWait to ensure the element is clickable
//        wait.until(ExpectedConditions.elementToBeClickable(element));
//        element.click();

        driver.findElement(des).sendKeys(desValue);
        //driver.findElement(imNotRobot).click();
        driver.findElement(email2).sendKeys(email2Value);
        
        element = driver.findElement(submit);
        clickWithRetry(element);
    }
    
    
}
