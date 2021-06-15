package PageObjects.Railway2;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage {
    //Elements
    protected WebElement getCheckPriceLink(String trainName) {
        By checkPriceLink = By.xpath("//li[.='"+trainName+"']/ancestor::tr//a[.='Check Price']");
        return Constant.WEBDRIVER.findElement(checkPriceLink);
    }

    //Methods
    public void goToCheckPricePage(String trainName) {
        this.getCheckPriceLink(trainName).click();
    }
}
