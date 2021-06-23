package test_cases.railway_2.change_password_test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import common.Common.Utilities;
import common.Constant.Constant;
import page_objects.railway_2.ChangePasswordPage;
import test_cases.railway_2.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase09 extends BaseTest {

    @Test(description = "TC09 - User can change password")
    public void TC09() {
        ExtentTest test = Constant.EXTENT.createTest("TC09 - User can change password");

        generalPage.open();
        test.log(Status.INFO, "1. Navigate to QA Railway Website");

        generalPage.goToLoginPage().login(Constant.USERNAME, Constant.PASSWORD);
        test.log(Status.INFO, "2. Login with valid account");

        ChangePasswordPage changePasswordPage = generalPage.goToChangePasswordPage();
        test.log(Status.INFO, "3. Click on \"Change Password\" tab");

        changePasswordPage.changePassword(Constant.PASSWORD, Constant.NEW_PASSWORD, Constant.NEW_PASSWORD);
        test.log(Status.INFO, "4. Enter valid value into all fields.");
        test.log(Status.INFO, "5. Click on \"Change Password\" button");

        String actualMsg = changePasswordPage.getChangePassSuccessMessage();
        test.log(Status.INFO, "Actual message: " + actualMsg);

        String expectedMsg = "Your password has been updated!";
        test.log(Status.INFO, "Expected message: " + expectedMsg);

        if (actualMsg.equals(expectedMsg)) {
            test.pass("Change password success message is displayed as expected",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        } else {
            test.fail("Change password success message is not displayed as expected",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        }

        Assert.assertEquals(actualMsg, expectedMsg, "Change password success message is not displayed as expected");
    }
}
