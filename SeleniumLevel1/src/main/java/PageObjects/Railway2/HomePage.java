package PageObjects.Railway2;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends GeneralPage {
    //Locators
    private final By createAccountLink = By.xpath("//a[.='create an account']");

    //Elements
    protected WebElement getCreateAccountLink() {
        return Constant.WEBDRIVER.findElement(createAccountLink);
    }

    //Methods
    public void goToRegisterPage() {
        this.getCreateAccountLink().click();
    }
}
