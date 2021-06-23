package test_cases.railway_2.login_test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import common.Common.Utilities;
import common.Constant.Constant;
import page_objects.railway_2.LoginPage;
import test_cases.railway_2.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase02 extends BaseTest {

    @Test(description = "TC02 - User can't login with blank \"Username\" textbox")
    public void TC02() {
        ExtentTest test = Constant.EXTENT.createTest("TC02 - User can't login with blank \"Username\" textbox");

        generalPage.open();
        test.log(Status.INFO, "1. Navigate to QA Railway Website");

        LoginPage loginPage = generalPage.goToLoginPage();
        test.log(Status.INFO, "2. Click on \"Login\" tab");

        String actualMsg = loginPage.login("", Constant.PASSWORD).getLoginErrorMessage();
        test.log(Status.INFO, "3. User doesn't type any words into \"Username\" textbox but enter valid information into \"Password\" textbox");
        test.log(Status.INFO, "4. Click on \"Login\" button");
        test.log(Status.INFO, "Actual message: " + actualMsg);

        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        test.log(Status.INFO, "Expected message: " + expectedMsg);

        if (actualMsg.equals(expectedMsg)) {
            test.pass("Login error message is displayed as expected",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        } else {
            test.fail("Login error message is not displayed as expected",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        }

        Assert.assertEquals(actualMsg, expectedMsg, "Login error message is not displayed as expected");
    }
}
