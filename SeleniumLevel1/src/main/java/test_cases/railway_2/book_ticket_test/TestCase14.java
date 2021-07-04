package test_cases.railway_2.book_ticket_test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import common.Common.Utilities;
import common.Constant.Constant;
import page_objects.railway_2.BookTicketPage;
import test_cases.railway_2.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase14 extends BaseTest {

    @Test(description = "TC14 - User can book 1 ticket at a time")
    public void TC14() {
        ExtentTest test = Constant.EXTENT.createTest("TC14 - User can book 1 ticket at a time");

        generalPage.open();
        test.log(Status.INFO, "1. Navigate to QA Railway Website");

        generalPage.goToLoginPage().login(Constant.USERNAME, Constant.PASSWORD);
        test.log(Status.INFO, "2. Login with valid account");

        BookTicketPage bookTicketPage = generalPage.goToBookTicketPage();
        test.log(Status.INFO, "3. Click on \"Book ticket\" tab");

        bookTicketPage.bookTicket(Constant.DEPART_DATE,"Đà Nẵng", "Huế", "Soft bed with air conditioner", "1");
        test.log(Status.INFO, "4. Select a \"Depart date\" from the list");
        test.log(Status.INFO, "5. Select \"Sài Gòn\" for \"Depart from\" and \"Nha Trang\" for \"Arrive at\".");
        test.log(Status.INFO, "6. Select \"Soft bed with air conditioner\" for \"Seat type\"");
        test.log(Status.INFO, "7. Select \"1\" for \"Ticket amount\"");
        test.log(Status.INFO, "8. Click on \"Book ticket\" button");

        String actualMsg = bookTicketPage.getBookSuccessMessage();
        test.log(Status.INFO, "Actual message: " + actualMsg);

        String expectedMsg = "Ticket Booked Successfully!";
        test.log(Status.INFO, "Expected message: " + expectedMsg);

        if (actualMsg.equals(expectedMsg)) {
            test.pass("Book ticket success message is displayed as expected",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        } else {
            test.fail("Book ticket success message is not displayed as expected",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        }

        Assert.assertEquals(actualMsg, expectedMsg, "Book ticket success message is not displayed as expected");
    }
}
