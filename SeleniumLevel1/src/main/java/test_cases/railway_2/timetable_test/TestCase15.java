package test_cases.railway_2.timetable_test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import common.Common.Utilities;
import common.Constant.Constant;
import page_objects.railway_2.BookTicketPage;
import page_objects.railway_2.TimetablePage;
import test_cases.railway_2.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase15 extends BaseTest {

    @Test(description = "TC15 - User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page")
    public void TC15() {
        ExtentTest test = Constant.EXTENT.createTest("TC15 - User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page");

        generalPage.open();
        test.log(Status.INFO, "1. Navigate to QA Railway Website");

        generalPage.goToLoginPage().login(Constant.USERNAME, Constant.PASSWORD);
        test.log(Status.INFO, "2. Login with valid account");

        TimetablePage timetablePage = generalPage.goToTimetablePage();
        test.log(Status.INFO, "3. Click on \"Timetable\" tab");

        BookTicketPage bookTicketPage = timetablePage.goToBookTicketPageByLink("Huế", "Sài Gòn");
        test.log(Status.INFO, "4. Click on \"book ticket\" link of the route from \"Huế\" to \"Sài Gòn\"");

        String actualTitle = Constant.WEBDRIVER.getTitle();
        test.log(Status.INFO, "Actual browser title: " + actualTitle);

        String actualDepart = bookTicketPage.getDepartStationSelected();
        test.log(Status.INFO, "Actual depart station: " + actualDepart);

        String actualArrive = bookTicketPage.getArriveStationSelected();
        test.log(Status.INFO, "Actual arrive station: " + actualArrive);

        String expectedTitle = "Safe Railway - Book Ticket";
        test.log(Status.INFO, "Expected browser title: " + expectedTitle);

        String expectedDepart = "Huế";
        test.log(Status.INFO, "Expected depart station: " + expectedDepart);

        String expectedArrive = "Sài Gòn";
        test.log(Status.INFO, "Expected arrive station: " + expectedArrive);

        if (actualTitle.equals(expectedTitle)) {
            test.pass("Book ticket page is displayed as expected",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        } else {
            test.fail("Book ticket page is not displayed as expected",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        }

        if (actualDepart.equals(expectedDepart)) {
            test.pass("Depart station is displayed as expected",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        } else {
            test.fail("Depart station is not displayed as expected",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        }

        if (actualArrive.equals(expectedArrive)) {
            test.pass("Arrive station is displayed as expected",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        } else {
            test.fail("Arrive station is not displayed as expected",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(Utilities.getScreenshot()).build());
        }

        Assert.assertEquals(actualTitle, expectedTitle, "Book ticket page does not display");
        Assert.assertEquals(actualDepart, expectedDepart, "Depart station is not displayed as expected");
        Assert.assertEquals(actualArrive, expectedArrive, "Arrive station is not displayed as expected");
    }
}
