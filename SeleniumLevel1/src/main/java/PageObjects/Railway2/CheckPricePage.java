package PageObjects.Railway2;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckPricePage {
    //Elements
    protected WebElement getBookTicketBtn(String seatType) {
        By bookTicketBtn = By.xpath("//td[.='"+seatType+"']/..//a[.='Book ticket']");
        return Constant.WEBDRIVER.findElement(bookTicketBtn);
    }

    //Methods
    public BookTicketPage goToBookTicketPage(String seatType) {
        this.getBookTicketBtn(seatType).click();
        return new BookTicketPage();
    }
}
