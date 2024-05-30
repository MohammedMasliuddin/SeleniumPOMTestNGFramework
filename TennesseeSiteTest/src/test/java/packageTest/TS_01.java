package packageTest;

import java.io.IOException;

import org.testng.annotations.Test;
import pageObjects.BusinessClimatePage;
import pageObjects.RequestMoreInfoPage;
import utilities.ExcellUtils;

public class TS_01 extends BaseTest {

    @Test
    public void test1() throws InterruptedException, IOException {
    	test = extent.createTest("Test Scenario 1", "Testing the business climate page navigation UI and form submission");
        driver.get("https://tnecd.com/advantages/business-climate/");
        test.info("Successfully Navigated to business climate page");

        BusinessClimatePage businessClimatePage = new BusinessClimatePage(driver);
        businessClimatePage.clickMenu();
        test.info("Clicked on menu");
        businessClimatePage.clickWorkforceAndEducation();
        test.info("Clicked on Workforce and Education");
        
        Thread.sleep(3000);  
        businessClimatePage.clickRequestMoreInfo();
        test.info("Clicked on Request More Info");
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
        
        // Filling the form
        RequestMoreInfoPage requestMoreInfoPage = new RequestMoreInfoPage(driver);
        requestMoreInfoPage.fillForm(name, jobTitle, companyName, city, state, zip, country, phone, email1, message, email2);  
        test.pass("Form filled successfully");
    }
}
