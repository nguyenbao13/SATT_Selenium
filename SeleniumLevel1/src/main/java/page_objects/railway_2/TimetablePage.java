package page_objects.railway_2;

import common.Common.Utilities;
import common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage {
    //Elements
    protected WebElement getBookTicketLink(String departStation, String arriveStation) {
        By bookTicketLink = By.xpath("//td[.='"+departStation+"']/following-sibling::td[.='"+arriveStation+"']/..//a[.='book ticket']");
        return Constant.WEBDRIVER.findElement(bookTicketLink);
    }

    //Methods
    public BookTicketPage goToBookTicketPageByLink(String departStation, String arriveStation) {
        Utilities.scrollToViewElement(this.getBookTicketLink(departStation, arriveStation));
        this.getBookTicketLink(departStation, arriveStation).click();
        return new BookTicketPage();
    }
}


