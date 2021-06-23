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

public class TestCase06 extends BaseTest {

    @Test(description = "TC06 - Additional pages display once user logged in")
    public void TC06() {
        ExtentTest test = Constant.EXTENT.createTest("TC06 - Additional pages display once user logged in");

        generalPage.open();
        test.log(Status.INFO, "1. Navigate to QA Railway Website");

        LoginPage loginPage = generalPage.goToLoginPage();
        test.log(Status.INFO, "2. Click on \"Login\" tab");

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        test.log(Status.INFO, "3. Login with valid account");
        test.log(Status.INFO, " - Username: " + Constant.USERNAME);
        test.log(Status.INFO, " - Password: " + Constant.PASSWORD);

        Boolean myTicket = generalPage.checkMyTicketTabExists();
        Boolean changePassword = generalPage.checkChangePasswordTabExists();
        Boolean logout = generalPage.checkLogoutTabExists();
        String actualMyTicketTitle = "";
        String actualChangePasswordTitle = "";
        String expectedMyTicketTitle = "Safe Railway - My Ticket";
        String expectedChangePasswordTitle = "Safe Railway - Change Password";

        if (myTicket && changePassword && logout) {
            test.pass("\"My ticket\", \"Change password\" and \"Logout\" tabs are displayed.",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());

            generalPage.goToMyTicketPage();
            actualMyTicketTitle = Constant.WEBDRIVER.getTitle();

            if (actualMyTicketTitle.equals(expectedMyTicketTitle)) {
                test.pass("My ticket page is displayed as expected",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
            } else {
                test.fail("My ticket page is not displayed as expected",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
            }

            generalPage.goToChangePasswordPage();
            actualChangePasswordTitle = Constant.WEBDRIVER.getTitle();

            if (actualChangePasswordTitle.equals(expectedChangePasswordTitle)) {
                test.pass("Change password page is displayed as expected",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
            } else {
                test.fail("Change password page is not displayed as expected",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
            }

        } else {
            test.fail("\"My ticket\", \"Change password\" and \"Logout\" tabs are not displayed.",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        }

        Assert.assertEquals(actualMyTicketTitle, expectedMyTicketTitle, "My ticket page is not displayed as expected");
        Assert.assertEquals(actualChangePasswordTitle, expectedChangePasswordTitle, "Change password page is not displayed as expected");
    }
}
