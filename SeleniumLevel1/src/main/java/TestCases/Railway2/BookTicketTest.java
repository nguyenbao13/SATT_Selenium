package TestCases.Railway2;

import Common.Constant.Constant;
import PageObjects.Railway2.BookTicketPage;
import PageObjects.Railway2.GeneralPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookTicketTest {
    GeneralPage generalPage = new GeneralPage();

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
        generalPage.open().goToLoginPage().login(Constant.USERNAME, Constant.PASSWORD);
    }

//    @AfterMethod
//    public void afterMethod() {
//        generalPage.logout();
//    }

    @Test
    public void bookTicket() {
        BookTicketPage bookTicketPage = generalPage.goToBookTicketPage();
        bookTicketPage.bookTicket("6/20/2021","Đà Nẵng", "Huế", "Soft bed", "3");
        String actualMsg = bookTicketPage.getBookSuccessMessage();
        System.out.print(actualMsg);
    }
}
