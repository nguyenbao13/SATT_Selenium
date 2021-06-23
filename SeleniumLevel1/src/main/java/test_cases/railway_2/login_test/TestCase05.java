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

public class TestCase05 extends BaseTest {

    @Test(description = "TC05 - System shows message when user enters wrong password several times")
    public void TC05() {
        ExtentTest test = Constant.EXTENT.createTest("TC05 - System shows message when user enters wrong password several times");

        generalPage.open();
        test.log(Status.INFO, "1. Navigate to QA Railway Website");

        LoginPage loginPage = generalPage.goToLoginPage();
        test.log(Status.INFO, "2. Click on \"Login\" tab");

        for (int i = 1; i < 5; i++) {
            loginPage.login(Constant.USERNAME, "1");
        }
        test.log(Status.INFO, "3. Enter valid information into \"Username\" textbox except \"Password\" textbox.");
        test.log(Status.INFO, " - Username: " + Constant.USERNAME);
        test.log(Status.INFO, " - Password: 1");
        test.log(Status.INFO, "4. Click on \"Login\" button");
        test.log(Status.INFO, "5. Repeat step 3 three more times.");

        String actualMsg = loginPage.getLoginErrorMessage();
        test.log(Status.INFO, "Actual message: " + actualMsg);

        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        test.log(Status.INFO, "Expected message: " + expectedMsg);

        if (actualMsg.equals(expectedMsg)) {
            test.pass("Out of attempts to login error message is displayed as expected",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        } else {
            test.fail("Out of attempts to login error message is not displayed as expected",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        }

        Assert.assertEquals(actualMsg, expectedMsg, "Out of attempts to login message is not displayed as expected");
    }
}
