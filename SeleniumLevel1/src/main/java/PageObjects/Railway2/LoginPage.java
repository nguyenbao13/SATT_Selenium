package PageObjects.Railway2;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    //Locators
    private final By userNameInput = By.id("username");
    private final By loginBtn = By.xpath("//input[@title='Login']");
    private final By registerLink = By.xpath("//a[.='Registration Page']");
    private final By forgotPasswordLink = By.xpath("//a[.='Forgot Password page']");

    //Elements
    protected WebElement getUserNameInput() {
        return Constant.WEBDRIVER.findElement(userNameInput);
    }

    protected WebElement getLoginBtn() {
        return Constant.WEBDRIVER.findElement(loginBtn);
    }

    protected WebElement getRegisterLink() {
        return Constant.WEBDRIVER.findElement(registerLink);
    }

    protected WebElement getForgotPasswordLink() {
        return Constant.WEBDRIVER.findElement(forgotPasswordLink);
    }

    //Methods
    public void login(String username, String password) {
        this.getUserNameInput().sendKeys(username);
        this.getPasswordInput().sendKeys(password);
        this.getLoginBtn().click();
    }

    public void goToRegisterPage() {
        this.getRegisterLink().click();
    }

    public void goToForgotPasswordPage() {
        this.getForgotPasswordLink().click();
    }
}