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

public class TestCase11 extends BaseTest {

    @Test(description = "TC11 - User can't create account while password and PID fields are empty")
    public void TC11() {
        ExtentTest test = Constant.EXTENT.createTest("TC11 - User can't create account while password and PID fields are empty");

        generalPage.open();
        test.log(Status.INFO, "1. Navigate to QA Railway Website");

        RegisterPage registerPage = generalPage.goToRegisterPage();
        test.log(Status.INFO, "2. Click on \"Register\" tab");

        registerPage.registerAccount(Constant.REGISTER_NAME, "", "", "");
        test.log(Status.INFO, "3. Enter valid email address and leave other fields empty");
        test.log(Status.INFO, "4. Click on \"Register\" button");

        String actualRegisterMsg = registerPage.getRegisterErrorMessage();
        test.log(Status.INFO, "Actual register message: " + actualRegisterMsg);

        String actualPasswordMsg = registerPage.getValidationErrorMessage("Password (8 - 64 characters)");
        test.log(Status.INFO, "Actual password message: " + actualPasswordMsg);

        String actualPIDMsg = registerPage.getValidationErrorMessage("PID/Passport number (8 - 20 characters)");
        test.log(Status.INFO, "Actual PID message: " + actualPIDMsg);

        String expectedRegisterMsg = "There're errors in the form. Please correct the errors and try again.";
        test.log(Status.INFO, "Expected register message: " + expectedRegisterMsg);

        String expectedPasswordMsg = "Invalid password length";
        test.log(Status.INFO, "Expected password message: " + expectedPasswordMsg);

        String expectedPIDMsg = "Invalid ID length";
        test.log(Status.INFO, "Expected PID message: " + expectedPIDMsg);

        if (actualRegisterMsg.equals(expectedRegisterMsg)) {
            test.pass("Register error message is displayed as expected",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        } else {
            test.fail("Register error message is not displayed as expected",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        }

        if (actualPasswordMsg.equals(expectedPasswordMsg)) {
            test.pass("Password error message is displayed as expected",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        } else {
            test.fail("Password error message is not displayed as expected",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        }

        if (actualPIDMsg.equals(expectedPIDMsg)) {
            Utilities.scrollToViewElement(registerPage.getPIDInput());
            test.pass("PID number error message is displayed as expected",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        } else {
            Utilities.scrollToViewElement(registerPage.getPIDInput());
            test.fail("PID number error message is not displayed as expected",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        }

        Assert.assertEquals(actualRegisterMsg, expectedRegisterMsg, "Register error message is not displayed as expected");
        Assert.assertEquals(actualPasswordMsg, expectedPasswordMsg, "Password error message is not displayed as expected");
        Assert.assertEquals(actualPIDMsg, expectedPIDMsg, "PID number error message is not displayed as expected");
    }
}
