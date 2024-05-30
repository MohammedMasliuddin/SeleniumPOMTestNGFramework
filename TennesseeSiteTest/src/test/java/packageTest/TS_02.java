package packageTest;

import org.testng.annotations.Test;

import pageObjects.ECDHomePage;
import pageObjects.RequestMoreInfoPage;
import utilities.ExcellUtils;

public class TS_02 extends BaseTest {

    @Test
    public void test2() throws InterruptedException {
    	test = extent.createTest("Test Scenario 2", "Testing TN.gov advantages page navigation and form submission");
        driver.get("https://www.tn.gov/ecd.html");
        test.info("Navigated to TN.gov ECD page");
        ECDHomePage ecd = new ECDHomePage(driver);
        ecd.hoverAdvantages();
        test.info("Hovered over Advantages menu");
        ecd.clickBusinessClimate();
        test.info("Clicked on Business Climate");
        ecd.clickReqMoreInformation();
        test.info("clicked on request more information");
        // Filling the form
        String projectPath = System.getProperty("user.dir");
        ExcellUtils excelUtils = new ExcellUtils(projectPath + "/excel/FormDetails.xlsx", "Sheet1");

        // Reading data from Excel
        String name = excelUtils.getCellDataString(1, 0);
        String jobTitle = excelUtils.getCellDataString(1, 1);
        String companyName = excelUtils.getCellDataString(1, 2);
        String city = excelUtils.getCellDataString(1, 3);
        String state = excelUtils.getCellDataString(1, 4);
        String zip = String.valueOf(excelUtils.getCellDataNumeric(1, 5));
        String country = excelUtils.getCellDataString(1, 6);
        String phone = String.valueOf(excelUtils.getCellDataNumeric(1, 7));
        String email1 = excelUtils.getCellDataString(1, 8);
        String message = excelUtils.getCellDataString(1, 9);
        String email2 = excelUtils.getCellDataString(1, 10);
      
        //requestMoreInfoPage.fillForm("durefishan", "github copilat", "Google", "Hyderabad", "Telanagana", "500087", "India", "9768762562", "durefishan@google.com", "See you soon", "durefishan991@google.com");
        
        RequestMoreInfoPage requestMoreInfoPage = new RequestMoreInfoPage(driver);
        requestMoreInfoPage.fillForm(name, jobTitle, companyName, city, state, zip, country, phone, email1, message, email2);
    
        test.pass("Form filled successfully");
    }
}
