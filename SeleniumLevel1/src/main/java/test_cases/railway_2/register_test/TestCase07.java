package test_cases.railway_2.register_test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import common.Common.Utilities;
import common.Constant.Constant;
import page_objects.railway_2.RegisterPage;
import test_cases.railway_2.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase07 extends BaseTest {

    @Test(description = "TC07 - User can create new account")
    public void TC07() {
        ExtentTest test = Constant.EXTENT.createTest("TC07 - User can create new account");

        generalPage.open();
        test.log(Status.INFO, "1. Navigate to QA Railway Website");

        RegisterPage registerPage = generalPage.goToRegisterPage();
        test.log(Status.INFO, "2. Click on \"Register\" tab");

        registerPage.registerAccount(Constant.REGISTER_NAME, Constant.PASSWORD, Constant.PASSWORD, "12345678");
        test.log(Status.INFO, "3. Enter valid information into all fields");
        test.log(Status.INFO, " - Username: " + Constant.REGISTER_NAME);
        test.log(Status.INFO, " - Password: " + Constant.PASSWORD);
        test.log(Status.INFO, " - PID: 12345678");
        test.log(Status.INFO, "4. Click on \"Register\" button");

        String actualMsg = registerPage.getRegisterSuccessMessage();
        test.log(Status.INFO, "Actual message: " + actualMsg);

        String expectedMsg = "Thank you for registering your account";
        test.log(Status.INFO, "Expected message: " + expectedMsg);

        if (actualMsg.equals(expectedMsg)) {
            test.pass("Success register message is displayed as expected",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        } else {
            test.fail("Success register message is not displayed as expected",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        }

        Assert.assertEquals(actualMsg, expectedMsg, "Success register message is not displayed as expected");
    }
}
