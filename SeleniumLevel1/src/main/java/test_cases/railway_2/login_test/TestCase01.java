package test_cases.railway_2.login_test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import common.Common.Utilities;
import common.Constant.Constant;
import page_objects.railway_2.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_cases.railway_2.BaseTest;

public class TestCase01 extends BaseTest {

    @Test(description = "TC01 - User can log into Railway with valid username and password")
    public void TC01() {
        ExtentTest test = Constant.EXTENT.createTest("TC01 - User can log into Railway with valid username and password");

        generalPage.open();
        test.log(Status.INFO, "1. Navigate to QA Railway Website");

        LoginPage loginPage = generalPage.goToLoginPage();
        test.log(Status.INFO, "2. Click on \"Login\" tab");

        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        test.log(Status.INFO, "3. Enter valid Email and Password");
        test.log(Status.INFO, " - Email: " + Constant.USERNAME);
        test.log(Status.INFO, " - Password: " + Constant.PASSWORD);
        test.log(Status.INFO, "4. Click on \"Login\" button");
        test.log(Status.INFO, "Actual message: " + actualMsg);

        String expectedMsg = "Welcome " + Constant.USERNAME;
        test.log(Status.INFO, "Expected message: " + expectedMsg);

        if (actualMsg.equals(expectedMsg)) {
            test.pass("Login successfully",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        } else {
            test.fail("Welcome message is not displayed as expected",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        }

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }
}
