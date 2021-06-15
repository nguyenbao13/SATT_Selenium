package PageObjects.Railway2;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {
    //Locators
    private final By createAccountLink = By.xpath("//a[.='create an account']");

    //Elements
    protected WebElement getCreateAccountLink() {
        return Constant.WEBDRIVER.findElement(createAccountLink);
    }

    //Methods
    public RegisterPage goToCreateAnAccount() {
        this.getCreateAccountLink().click();
        return new RegisterPage();
    }
}
