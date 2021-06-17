package TestCases.Railway2;

import Common.Constant.Constant;
import PageObjects.Railway2.BookTicketPage;
import PageObjects.Railway2.GeneralPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookTicketTest extends GeneralTest{
    private GeneralPage generalPage = new GeneralPage();
    private BookTicketPage bookTicketPage = new BookTicketPage();

    @BeforeMethod
    public void beforeMethod() {
        generalPage.goToLoginPage().login(Constant.USERNAME, Constant.PASSWORD);
        generalPage.goToBookTicketPage();
    }

//    @AfterMethod
//    public void afterMethod() {
//        generalPage.logout();
//    }

    @Test
    public void TC14() {
        System.out.println("User can book 1 ticket at a time");

        bookTicketPage.bookTicket("6/26/2021","Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "1");
        String actualMsg = bookTicketPage.getBookSuccessMessage();
        String expectedMsg = "Ticket Booked Successfully!";

        Assert.assertEquals(actualMsg, expectedMsg, "Book ticket success message is not displayed as expected");
    }
}
