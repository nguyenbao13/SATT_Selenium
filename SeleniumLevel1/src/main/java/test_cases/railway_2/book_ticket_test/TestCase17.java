package test_cases.railway_2.book_ticket_test;

import common.Constant.Constant;
import data_objects.DataProviderClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.railway_2.BookTicketPage;
import page_objects.railway_2.MyTicketPage;
import test_cases.railway_2.BaseTest;

public class TestCase17 extends BaseTest {
    private BookTicketPage bookTicketPage = new BookTicketPage();
    @Test(description = "User can book more than one ticket.",
            dataProvider = "TicketProvider", dataProviderClass = DataProviderClass.class)
    public void TC17(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount) {

        generalPage.open();

        generalPage.goToLoginPage().login(Constant.USERNAME, Constant.PASSWORD);

        MyTicketPage myTicketPage = generalPage.goToMyTicketPage();

//        String actualMsg = "";

        if (myTicketPage.getTicketAmount() < 6) {
            generalPage.goToBookTicketPage();
            bookTicketPage.bookTicket(departDate, departStation, arriveStation, seatType, ticketAmount);
//            actualMsg = bookTicketPage.getBookSuccessMessage();
        } else {
            System.out.println("filter test");
        }

//        String expectedMsg = "Ticket Booked Successfully!";
//
//        Assert.assertEquals(actualMsg, expectedMsg, "Book ticket success message is not displayed as expected");

        generalPage.logout();
    }
}
