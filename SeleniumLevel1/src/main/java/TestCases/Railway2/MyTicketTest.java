package TestCases.Railway2;

import Common.Constant.Constant;
import PageObjects.Railway2.GeneralPage;
import PageObjects.Railway2.MyTicketPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyTicketTest {
    private GeneralPage generalPage = new GeneralPage();
    private MyTicketPage myTicketPage = new MyTicketPage();

    @BeforeMethod
    public void beforeMethod() {
        generalPage.goToLoginPage().login(Constant.USERNAME, Constant.PASSWORD);
        generalPage.goToMyTicketPage();
    }

    @Test
    public void TC16() {
        System.out.println("TC16 - User can cancel a ticket");

        myTicketPage.cancelTicket(2);
    }
}
