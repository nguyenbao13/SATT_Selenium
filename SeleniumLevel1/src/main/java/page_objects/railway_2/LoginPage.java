package page_objects.railway_2;

import common.Common.Utilities;
import common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    //Locators
    private final By userNameInput = By.id("username");
    private final By loginBtn = By.xpath("//input[@title='Login']");
    private final By loginErrMsg = By.xpath("//p[@class='message error LoginForm']");

    //Elements
    protected WebElement getUserNameInput() {
        return Constant.WEBDRIVER.findElement(userNameInput);
    }

    protected WebElement getLoginBtn() {
        return Constant.WEBDRIVER.findElement(loginBtn);
    }

    protected WebElement getLoginErrMsg() {
        return Constant.WEBDRIVER.findElement(loginErrMsg);
    }

    //Methods
    public LoginPage login(String username, String password) {
        getUserNameInput().clear();
        getUserNameInput().sendKeys(username);
        getPasswordInput().sendKeys(password);
        Utilities.scrollToViewElement(getLoginBtn());
        getLoginBtn().click();
        return new LoginPage();
    }

    public String getLoginErrorMessage() {
        return getLoginErrMsg().getText();
    }
}
