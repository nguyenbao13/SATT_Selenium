package test_cases.railway_2.login_test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import common.Common.Utilities;
import common.Constant.Constant;
import test_cases.railway_2.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase04 extends BaseTest {

    @Test(description = "TC04 - Login page displays when un-logged User clicks on \"Book ticket\" tab")
    public void TC04() {
        ExtentTest test = Constant.EXTENT.createTest("TC04 - Login page displays when un-logged User clicks on \"Book ticket\" tab");

        generalPage.open();
        test.log(Status.INFO, "1. Navigate to QA Railway Website");

        generalPage.goToBookTicketPage();
        test.log(Status.INFO, "2. Click on \"Book ticket\" tab");

        String actualTitle = Constant.WEBDRIVER.getTitle();
        test.log(Status.INFO, "Actual browser title: " + actualTitle);

        String expectedTitle = "Safe Railway - Login";
        test.log(Status.INFO, "Expected browser title: " + expectedTitle);

        if (actualTitle.equals(expectedTitle)) {
            test.pass("Login page is displayed as expected",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        } else {
            test.fail("Login page is not displayed as expected",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        }

        Assert.assertEquals(actualTitle, expectedTitle, "Login page is not displayed as expected");
    }
}
