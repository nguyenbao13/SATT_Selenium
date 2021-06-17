package PageObjects.Railway2;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {
    //Locators
    private final By PIDInput = By.id("pid");
    private final By registerBtn = By.xpath("//input[@title='Register']");
    private final By registerErrMsg = By.xpath("//p[@class='message error']");
    private final By loginLink = By.xpath("//a[.='login']");
    private final By registerSuccessMsg = By.xpath("//div[@id='content']/p");

    //Elements
    protected WebElement getPIDInput() {
        return Constant.WEBDRIVER.findElement(PIDInput);
    }

    protected WebElement getRegisterBtn() {
        return Constant.WEBDRIVER.findElement(registerBtn);
    }

    protected WebElement getRegisterErrMsg() {
        return Constant.WEBDRIVER.findElement(registerErrMsg);
    }

    protected WebElement getLoginLink() {
        return Constant.WEBDRIVER.findElement(loginLink);
    }

    protected WebElement getRegisterSuccessMsg() {
        return Constant.WEBDRIVER.findElement(registerSuccessMsg);
    }

    //Methods
    public RegisterPage registerAccount(String email, String password, String confirmPass, String pid) {
        super.getEmailInput().sendKeys(email);
        super.getPasswordInput().sendKeys(password);
        super.getConfirmPasswordInput().sendKeys(confirmPass);
        this.getPIDInput().sendKeys(pid, Keys.ENTER);
        return new RegisterPage();
    }

    public String getRegisterErrorMessage() {
        return this.getRegisterErrMsg().getText();
    }

    public LoginPage goToLoginPageByLink() {
        this.getLoginLink().click();
        return new LoginPage();
    }

    public String getRegisterSuccessMessage() {
        return this.getRegisterSuccessMsg().getText();
    }
}
