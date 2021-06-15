package PageObjects.Railway2;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage {
    //Locators
    private final By emailLink = By.xpath("//div[@id='content']//a[@href='mailto:thanh.viet.le@logigear.com']");

    //Elements
    protected WebElement getEmailLink() {
        return Constant.WEBDRIVER.findElement(emailLink);
    }

    //Methods
    public void openMailApp() {
        this.getEmailLink().click();
    }
}
