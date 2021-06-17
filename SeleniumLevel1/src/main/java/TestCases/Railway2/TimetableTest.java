package TestCases.Railway2;

import Common.Constant.Constant;
import PageObjects.Railway2.BookTicketPage;
import PageObjects.Railway2.GeneralPage;
import PageObjects.Railway2.TimetablePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TimetableTest extends GeneralTest{
    private GeneralPage generalPage = new GeneralPage();
    private TimetablePage timetablePage = new TimetablePage();
    private BookTicketPage bookTicketPage = new BookTicketPage();

    @BeforeMethod
    public void beforeMethod() {
        generalPage.goToLoginPage().login(Constant.USERNAME, Constant.PASSWORD);
        generalPage.goToTimetablePage();
    }

    @Test
    public void TC15() {
        System.out.println("TC15 - User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page");

        timetablePage.goToBookTicketPageByLink("Huế", "Sài Gòn");
        String actualTitle = Constant.WEBDRIVER.getTitle();
        String actualDepart = bookTicketPage.getDepartStationSelected();
        String actualArrive = bookTicketPage.getArriveStationSelected();
        String expectedTitle = "Safe Railway - Book Ticket";
        String expectedDepart = "Huế";
        String expectedArrive = "Sài Gòn";

        Assert.assertEquals(actualTitle, expectedTitle, "Book ticket page does not display");
        Assert.assertEquals(actualDepart, expectedDepart, "Depart station is not displayed as expected");
        Assert.assertEquals(actualArrive, expectedArrive, "Arrive station is not displayed as expected");
    }
}
