package PageObjects.Railway2;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage {
    //Elements
    protected WebElement getCheckPriceLink(String departStation, String arriveStation) {
        By checkPriceLink = By.xpath("//td[.='"+departStation+"']/following-sibling::td[.='"+arriveStation+"']/..//a[.='check price']");
        return Constant.WEBDRIVER.findElement(checkPriceLink);
    }

    protected WebElement getBookTicketLink(String departStation, String arriveStation) {
        By bookTicketLink = By.xpath("//td[.='"+departStation+"']/following-sibling::td[.='"+arriveStation+"']/..//a[.='book ticket']");
        return Constant.WEBDRIVER.findElement(bookTicketLink);
    }

    //Methods
    public CheckPricePage goToCheckPricePage(String departStation, String arriveStation) {
        this.getCheckPriceLink(departStation, arriveStation).click();
        return new CheckPricePage();
    }

    public BookTicketPage goToBookTicketPage(String departStation, String arriveStation) {
        this.getBookTicketLink(departStation, arriveStation).click();
        return new BookTicketPage();
    }
}


