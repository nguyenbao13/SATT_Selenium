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

public class TestCase10 extends BaseTest {

    @Test(description = "TC10 - User can't create account with \"Confirm password\" is not the same with \"Password\"")
    public void TC10() {
        ExtentTest test = Constant.EXTENT.createTest("TC10 - User can't create account with \"Confirm password\" is not the same with \"Password\"");

        generalPage.open();
        test.log(Status.INFO, "1. Navigate to QA Railway Website");

        RegisterPage registerPage = generalPage.goToRegisterPage();
        test.log(Status.INFO, "2. Click on \"Register\" tab");

        registerPage.registerAccount(Constant.REGISTER_NAME, Constant.PASSWORD, "abcdefgh", "12345678");
        test.log(Status.INFO, "3. Enter valid information into all fields except \"Confirm password\" is not the same with \"Password\"");
        test.log(Status.INFO, " - Username: " + Constant.REGISTER_NAME);
        test.log(Status.INFO, " - Password: " + Constant.PASSWORD);
        test.log(Status.INFO, " - Confirm Password: abcdefgh");
        test.log(Status.INFO, " - PID: 12345678");
        test.log(Status.INFO, "4. Click on \"Register\" button");

        String actualMsg = registerPage.getRegisterErrorMessage();
        test.log(Status.INFO, "Actual message: " + actualMsg);

        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        test.log(Status.INFO, "Expected message: " + expectedMsg);

        if (actualMsg.equals(expectedMsg)) {
            Utilities.scrollToViewElement(registerPage.getConfirmPasswordInput());
            test.pass("Change password error message is displayed as expected",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        } else {
            Utilities.scrollToViewElement(registerPage.getConfirmPasswordInput());
            test.fail("Change password error message is not displayed as expected",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        }

        Assert.assertEquals(actualMsg, expectedMsg, "Change password error message is not displayed as expected");
    }
}
