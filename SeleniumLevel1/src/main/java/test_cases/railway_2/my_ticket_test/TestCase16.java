package test_cases.railway_2.my_ticket_test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import common.Common.Utilities;
import common.Constant.Constant;
import page_objects.railway_2.MyTicketPage;
import test_cases.railway_2.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase16 extends BaseTest {

    @Test(description = "TC16 - User can cancel a ticket")
    public void TC16() {
        ExtentTest test = Constant.EXTENT.createTest("TC16 - User can cancel a ticket");

        generalPage.open();
        test.log(Status.INFO, "1. Navigate to QA Railway Website");

        generalPage.goToLoginPage().login(Constant.USERNAME, Constant.PASSWORD);
        test.log(Status.INFO, "2. Login with valid account");

        MyTicketPage myTicketPage = generalPage.goToMyTicketPage();
        test.log(Status.INFO, "3. Click on \"My ticket\" tab");

        int ticketsAlikeBeforeCancel = myTicketPage.getTicketsAlike("Sài Gòn", "Nha Trang",
                "Soft bed with air conditioner", Constant.DEPART_DATE, Constant.BOOK_DATE, 1);
        Utilities.scrollToViewElement(myTicketPage.getTicketTable());
        test.info("Tickets appears before canceling",
                MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());

        myTicketPage.cancelTicket("Sài Gòn", "Nha Trang", "Soft bed with air conditioner",
                Constant.DEPART_DATE, Constant.BOOK_DATE, 1, 1);
        test.log(Status.INFO, "4. Click on \"Cancel\" button of ticket which user want to cancel.");
        test.log(Status.INFO, "5. Click on \"OK\" button on Confirmation message \"Are you sure?\"");

        try {
            Thread.sleep(1000); //Wait for Firefox browser reloads
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }

        int actualTickets = myTicketPage.getTicketsAlike("Sài Gòn", "Nha Trang",
                "Soft bed with air conditioner", Constant.DEPART_DATE, Constant.BOOK_DATE, 1);
        test.log(Status.INFO, "Actual canceled tickets alike: " + actualTickets);

        int expectedTickets = ticketsAlikeBeforeCancel - 1;
        test.log(Status.INFO, "Expected canceled tickets alike: " + expectedTickets);

        Utilities.scrollToViewElement(myTicketPage.getTicketTable());
        if (actualTickets == expectedTickets) {
            test.pass("The canceled ticket is disappeared as expected",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        } else {
            test.fail("The canceled ticket is not disappeared as expected",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        }

        Assert.assertEquals(actualTickets, expectedTickets, "The canceled ticket is not disappeared as expected");
    }
}
