package page_objects.railway_2;

import common.Common.Utilities;
import common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage {
    //Locators
    private final By ticketTable = By.xpath("//table[@class='MyTable']");

    //Elements
    protected WebElement getCancelButton(String departStation, String arriveStation, String seatType, String departDate,
                                         String bookDate, int amount, int number) {
        By cancelBtn = By.xpath("(//td[.='" + departStation + "']/following-sibling::td[.='" + arriveStation + "']/../" +
                "td[.='" + seatType + "']/../td[.='" + departDate + "']/../td[.='" + bookDate + "']/" +
                "following-sibling::td[.='" + amount + "']/..//input[@value='Cancel'])[" + number + "]");
        return Constant.WEBDRIVER.findElement(cancelBtn);
    }

    public WebElement getTicketTable() {
        return Constant.WEBDRIVER.findElement(ticketTable);
    }

    //Methods
    public void cancelTicket(String departStation, String arriveStation, String seatType, String departDate,
                             String bookDate, int amount, int number) {
        Utilities.scrollToViewElement(getCancelButton(departStation, arriveStation, seatType, departDate, bookDate, amount, number));
        getCancelButton(departStation, arriveStation, seatType, departDate, bookDate, amount, number).click();
        Constant.WEBDRIVER.switchTo().alert().accept();
    }

    public int getTicketsAlike(String departStation, String arriveStation, String seatType, String departDate,
                               String bookDate, int amount) {
        return Constant.WEBDRIVER.findElements(By.xpath("//td[.='" + departStation + "']/following-sibling::td[.='" +
                arriveStation + "']/../td[.='" + seatType + "']/../td[.='" + departDate + "']/../td[.='" +
                bookDate + "']/following-sibling::td[.='" + amount + "']/..//input[@value='Cancel']")).size();
    }

    public int getTicketAmount() {
        return Constant.WEBDRIVER.findElements(By.xpath("//table[@class='MyTable']//tr")).size() - 1;
    }
}
