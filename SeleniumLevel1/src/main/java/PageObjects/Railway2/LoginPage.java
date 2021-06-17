package PageObjects.Railway2;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    //Locators
    private final By userNameInput = By.id("username");
    private final By loginBtn = By.xpath("//input[@title='Login']");
    private final By registerLink = By.xpath("//a[.='Registration Page']");
    private final By forgotPasswordLink = By.xpath("//a[.='Forgot Password page']");
    private final By loginErrMsg = By.xpath("//p[@class='message error LoginForm']");

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

    protected WebElement getLoginErrMsg() {
        return Constant.WEBDRIVER.findElement(loginErrMsg);
    }

    //Methods
    public LoginPage login(String username, String password) {
        this.getUserNameInput().clear();
        this.getUserNameInput().sendKeys(username);
        this.getPasswordInput().sendKeys(password, Keys.ENTER);
        return new LoginPage();
    }

    public RegisterPage goToRegistrationPage() {
        this.getRegisterLink().click();
        return new RegisterPage();
    }

    public ForgotPasswordPage goToForgotPasswordPage() {
        this.getForgotPasswordLink().click();
        return new ForgotPasswordPage();
    }

    public String getLoginErrorMessage() {
        return this.getLoginErrMsg().getText();
    }
}
